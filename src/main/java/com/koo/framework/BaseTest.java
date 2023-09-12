package com.koo.framework;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Connection;
import com.koo.android.utils.ExcelDataReader;
import com.koo.setup.InitUtilObjects;
import com.koo.setup.TestConfig;
import com.koo.utils.CommonUtils;
import com.koo.utils.DataLoaders;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import junit.framework.Assert;

public class BaseTest {
	public static LogMe LOGGERSUITE;
	public static ThreadLocal<LogMe> LOGGER = new ThreadLocal<LogMe>();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriver> mobileDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriver> afterMethodDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<InitUtilObjects> utilObj = new ThreadLocal<InitUtilObjects>();
	public static ThreadLocal<SoftAssert> sAssert = new ThreadLocal<SoftAssert>();
	public static ThreadLocal<LinkedHashMap<String, LinkedHashMap<String, String>>> allTestData = ThreadLocal.withInitial(() -> {
		return DataLoaders.getAllTestData(TestConfig.getInstance().getProjDir()+"/src/main/resources/Test_Data/"+TestConfig.getInstance().getModuleName()+"/TestData.xlsx",TestConfig.getInstance().getTestSuiteName());});
	public static String PARAENT_REPORT_FOLDER_PATH;
	public static String REPORT_FOLDER_PATH;
	public static String SCREENSHOT_FOLDER_PATH;
	public static String VIDEO_FOLDER_PATH;
	public static String recoringFlag = "";
	
	public static LinkedHashMap<String, String> availableLanguages = null;
	public static LinkedHashMap<String, String> availableLanguagesHeading = null;
	public static Fillo fillo = null;
	public static Connection connection = null;
	public static String KOOTESTDATAPATH = null;
	public static Map<String, String> EnglishLanguageData = new HashMap<String, String>();

	@BeforeSuite
	public void suiteSetup() {
		try {
			TestConfig.getInstance().suiteSetup();
			String currDate = new SimpleDateFormat("yyyy-MMM-dd").format(new Date());
			PARAENT_REPORT_FOLDER_PATH ="src/main/resources/Test_Reports/"+TestConfig.getInstance().getModuleName()+"_"+currDate;
			File parentDirectory = new File(PARAENT_REPORT_FOLDER_PATH);
			String currDateTimestamp = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss").format(new Date()).replace(" ", "-").replaceAll(":", "-");
			REPORT_FOLDER_PATH = PARAENT_REPORT_FOLDER_PATH+"/"+currDateTimestamp;
			File reportDirectory = new File(REPORT_FOLDER_PATH);
			SCREENSHOT_FOLDER_PATH = REPORT_FOLDER_PATH+"/Screenshots";
			File screenshotDirectory = new File(SCREENSHOT_FOLDER_PATH);
			VIDEO_FOLDER_PATH = REPORT_FOLDER_PATH+"/Videos";
			File videoDirectory = new File(VIDEO_FOLDER_PATH);
			
			if(CommonUtils.isWindows()) {
				if (! parentDirectory.exists()){
					parentDirectory.mkdirs();
			    }
				
				if (! reportDirectory.exists()){
					reportDirectory.mkdirs();
			    }
				
				if (! screenshotDirectory.exists()){
					screenshotDirectory.mkdirs();
			    }
				
				if (! videoDirectory.exists()){
					videoDirectory.mkdirs();
			    }
			}else if(CommonUtils.isLinux()){
				CommonUtils.runCommand("bash", "-c", "mkdir", "-p", SCREENSHOT_FOLDER_PATH);
				CommonUtils.runCommand("bash", "-c", "mkdir", "-p", VIDEO_FOLDER_PATH);
			}else {
				//please implement missing OS
			}
			
			if(TestConfig.getInstance().getWebmobileFlag().contains("mobile")) {
				mobileSetupTestData();
			}
			
			ExtentManager.createInstance(REPORT_FOLDER_PATH+"/AUTOMATION_Test-Reports"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).replace(" ", "-").replaceAll(":", "-")+".html");
			LOGGERSUITE = new LogMe(BaseTest.class);
			LOGGERSUITE.logInfo("*********EXECUTION STARTED**********\n\n");
			//BaseTest.allTestData.set(utilObj.get().getDataLoaders().getAllTestData(TestConfig.getInstance().getProjDir()+"/src/main/resources/Test_Data/"+TestConfig.getInstance().getModuleName()+"/TestData.xlsx", TestConfig.getInstance().getTestSuiteName()));
		} catch (Exception e) {
			LOGGERSUITE.logError("Exception " + e.getClass().getName() + " caught from suite setup method");
		}
}
	@BeforeMethod
	public void startReporting(Method method) throws Exception {
		//reloadUpdatedExcel();
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			BaseTest.mobileDriver.set(TestConfig.getInstance().setMobileDriver("", "", "", "", ""));
		}else {
			BaseTest.driver.set(TestConfig.getInstance().createBrowserInstance(TestConfig.getInstance().getBrowser()));
		}
		utilObj.set(new InitUtilObjects());
		BaseTest.LOGGER.set(new LogMe(BaseTest.class));
		BaseTest.LOGGER.get().test_name = method.getName();
		if(TestConfig.getInstance().getRecordingFlag().equals("yes")) {
			try {
				MyScreenRecorder.startRecording(method.getName());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		sAssert.set(new SoftAssert());
		BaseTest.extentTest.set(BaseTest.LOGGER.get().logBeginTestCase(BaseTest.LOGGER.get().test_name));
		BaseTest.LOGGER.get().setupTestObj(BaseTest.LOGGER.get().test_name);
		BaseTest.utilObj.get().setupTestObj();
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
			if (BaseTest.utilObj.get().getMobileActions().isElmPresent(allow)) {
				BaseTest.utilObj.get().getMobileActions().click(allow, "Clicked on allow");
			}
			
		}else {
			BaseTest.LOGGER.get().logInfo("Application URL is " + TestConfig.getInstance().getAppURL());
			BaseTest.driver.get().get(TestConfig.getInstance().getAppURL());
			BaseTest.driver.get().manage().window().maximize();
		}
	}
	
	@AfterMethod
	public void testResult(Method method, ITestResult result) throws IOException {
		BaseTest.sAssert.get().assertAll();
		
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "PASS", "<b><------ Test case execution completed and successful for test:"+ BaseTest.LOGGER.get().test_name + " -----><b>", false,BaseTest.afterMethodDriver.get());
			break;
		case ITestResult.FAILURE:
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "FAIL", "<b><------ Test case failed for test:"+ BaseTest.LOGGER.get().test_name + " -----><b>", true, BaseTest.afterMethodDriver.get());
			break;
		case ITestResult.SKIP:
			BaseTest.LOGGER.get().logWithScreenshot("skip", "Test Case " + method.getName() + "  skiped", BaseTest.afterMethodDriver.get());
			break;
		default:
			break;
		}
		LOGGER.get().logEndTestCase(method.getName(), extentTest.get());
				
		try {
			ExtentManager.getInstance().flush();
		} finally {
			ExtentManager.getInstance().flush();
		}
		
		if(TestConfig.getInstance().getRecordingFlag().equals("yes")) {
			try {
				MyScreenRecorder.stopRecording();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			BaseTest.mobileDriver.get().quit();
		}else {
			BaseTest.driver.get().quit();
		}
		
	}

	@AfterSuite
	public void generateResult() {
		try {
			ExtentManager.getInstance().flush();
			connection.close();
		} finally {
			ExtentManager.getInstance().flush();
		}
	}
	
	public void reloadUpdatedExcel() {
		BaseTest.allTestData.set(DataLoaders.getAllTestData(TestConfig.getInstance().getProjDir()+"/src/main/resources/Test_Data/"+TestConfig.getInstance().getModuleName()+"/TestData.xlsx", TestConfig.getInstance().getTestSuiteName()));
	}
	
	public void mobileSetupTestData() {
		try {
			fillo = new Fillo();
			if (System.getProperty("ENVName") == null) {
	    		KOOTESTDATAPATH = "src/main/resources/Test_Data/TEST/KooTestData.xlsx";			
	    	} else {
	    		KOOTESTDATAPATH = "src/main/resources/Test_Data/"+System.getProperty("ENVName")+"/KooTestData.xlsx";
	    	}
			connection = fillo.getConnection(KOOTESTDATAPATH);
			availableLanguages = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguages");
			availableLanguagesHeading = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguagesHeading");
			
			Recordset sheetData = ExcelDataReader.getSheetData("English");
	        while (sheetData.next()) {
	        	EnglishLanguageData.put(sheetData.getField("Key"), sheetData.getField("Value"));
	        }
	        sheetData.close();

		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Something went wrong in mobileSetupTestData");
		}
	}
	
}

