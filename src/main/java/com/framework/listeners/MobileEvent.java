package com.framework.listeners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Test;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.koo.utils.TestCaseResult;

public class MobileEvent implements ITestListener {
	
	
	private static final String KEY = "platform";
	private static final String KEY1 = "udid";
	private static final String KEY2 = "systemPort";
	private static final String KEY3 = "deviceName";

	private static final String KEY4 = "deviceVersion";

	public String Platform;
	public String Udid;
	public String SystemPort;
	public String DeviceName = "";

	public String DeviceVersion = "";

	@Override
	public void onTestStart(ITestResult arg0) {
		String language = "English";
		
		try {

			// If Test is directly running by dev team then it will value from appium config
			// file
			if (Platform == null) {
				Platform = TestConfig.getInstance().getPlatform();
				Udid = TestConfig.getInstance().getUdid();
				SystemPort = TestConfig.getInstance().getPort();
				DeviceName = "";
				DeviceVersion = "";
			}

			System.out.println("key: " + Platform);
			System.out.println("key1: " + Udid);
			System.out.println("key2: " + SystemPort);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String description = arg0.getMethod().getDescription();
		String temp = description.split("]")[0];
		String[] split = temp.replace("[", "").split(", ");
		for (String s : split) {
			if (LanguageDataProvider.getCurrentLanguage() != null) {
				language = LanguageDataProvider.getCurrentLanguage();
			}
		}
		
		

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
		String language = "English";

		try {
			String description = iTestResult.getMethod().getDescription();
			String temp = description.split("]")[0];
			String[] split = temp.replace("[", "").split(", ");
			for (String s : split) {
				String testId = s;
				if (LanguageDataProvider.getCurrentLanguage() != null) {
					language = LanguageDataProvider.getCurrentLanguage();
				}
				TestCaseResult.addResults(testId, language, Platform, "PASS");
			}
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		Test model = BaseTest.extentTest.get().getModel();
		String oldName = model.getName();
		model.setName(oldName + "_" + language);
		
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String language = "English";
		try {
			String description = iTestResult.getMethod().getDescription();
			String temp = description.split("]")[0];
			String[] split = temp.replace("[", "").split(", ");
			for (String s : split) {
				String testId = s;
				if (LanguageDataProvider.getCurrentLanguage() != null) {
					language = LanguageDataProvider.getCurrentLanguage();
				}
				TestCaseResult.addResults(testId, language, Platform, "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		
		
		Test model = BaseTest.extentTest.get().getModel();
		String oldName = model.getName();
		model.setName(oldName + "_" + language);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		try {
			TestCaseResult.saveToExcel();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InvalidFormatException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onStart(ITestContext arg0) {
		Platform = arg0.getCurrentXmlTest().getParameter(KEY);
		Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
		SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);
		DeviceName = arg0.getCurrentXmlTest().getParameter(KEY3);
		DeviceVersion = arg0.getCurrentXmlTest().getParameter(KEY4);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
// TODO Auto-generated method stub

	}

}
