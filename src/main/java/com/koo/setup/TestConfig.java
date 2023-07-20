package com.koo.setup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.log4testng.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class TestConfig {
	static Logger LOGGER = Logger.getLogger(TestConfig.class);

	private static TestConfig testConfig;
	private static Config config;
	private String testModulesPath;
	private String browser;
	private String appURL;
	private String appUserId;
	private String appPWD;
	private String reportPath;
	private static String ENVName;
	private int FailureRetryCount;
	private String recordingFlag;
	private String MINWAITTIME;
	private String AVGWAITTIME;
	private String MAXWAITTIME;
	private String OBJWAITTIME;
	private String scriptTimeoutSecounds;
	private static String moduleName;
	private static String projDir;
	private static String testSuiteName;
	private static String webmobileFlag;
	
	//
	private static String platform;
	private static String udid;
	private static String port;
	private static String browserstack;
	private static String UserName;
	private static String ChildUserName;
	private static String userNameAuto;
	private static String userID;
	private static String userProfileName;
	private static String ExUserName;
	private static String InvalidUserName;
	private static String Password;
	private static String KooPostText;
	private static String EditPost;
	private static String AadharcardNumber;
	private static String Execution_Desktop;
	private static String localhost;
	private static String autoTestUserID;
	private static String autoTestUser;
	private static String autoBlockedUser;
	private static String autoTestUserID_02;
	private static String autoBlockedUser_02;
	private static String autoNewUser;
	private static String autoNewUserForOnBoarding;
	private static String search;
	private static String NewUserNumber;
	private static String InvalidEmail;
	private static String autoNewUserForPollKoo;
	private static String autoNewUser_03;
	private static String autoChildUser;
	private static String ChildUserNumber;
	private static String topicsArrangedUser;
	private static String user1_verifyLikeCommentRekooCount;
	private static String userHandleName_1_verifyLikeCommentRekooCount;
	private static String userName_1_verifyLikeCommentRekooCount;
	private static String user2_verifyLikeCommentRekooCount;
	private static String userHandleName_2_verifyLikeCommentRekooCount;

	private TestConfig() {
	}

	static {
		try {
			if (System.getProperty("ENVName") == null) {
				ENVName = "TEST";
			} else {
				ENVName = System.getProperty("ENVName");
			}
			projDir = System.getProperty("user.dir");
			config = new Config(projDir + "/src/main/resources/Test_Config/" + ENVName + "_config.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		PropertyConfigurator.configure("log4j.properties");
		if (System.getProperty("moduleName") == null) {
			moduleName = config.getPropertyValue("moduleName");
		} else {
			moduleName = config.getPropertyValue("moduleName");
		}
	}

	public static TestConfig getInstance() {
		if (testConfig == null) {
			testConfig = new TestConfig();
		}
		return testConfig;
	}

	public static Config getConfig() {
		return config;
	}

	public String getTestModulesPath() {
		return testModulesPath;
	}

	public String getBrowser() {
		return browser;
	}
	
	public String getAppURL() {
		return appURL;
	}

	public String getAppUserId() {
		return appUserId;
	}

	public String getAppPWD() {
		return appPWD;
	}

	public String getReportPath() {
		return reportPath;
	}

	public String getExecEnvironment() {
		return ENVName;
	}

	public int getFailureRetryCount() {
		return FailureRetryCount;
	}

	public String getRecordingFlag() {
		return recordingFlag;
	}

	public String getMINWAITTIME() {
		return MINWAITTIME;
	}

	public String getAVGWAITTIME() {
		return AVGWAITTIME;
	}

	public String getMAXWAITTIME() {
		return MAXWAITTIME;
	}

	public String getOBJWAITTIME() {
		return OBJWAITTIME;
	}

	public String getScriptTimeoutSecounds() {
		return scriptTimeoutSecounds;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getProjDir() {
		return projDir;
	}

	public String getTestSuiteName() {
		return testSuiteName;
	}
	
	public String getWebmobileFlag() {
		return webmobileFlag;
	}
	
	//Android properties
	public String getPlatform(){return platform;}
	public String getUdid(){return udid;}
	public String getPort(){return port;}
	public String getBrowserStack(){return browserstack;}
	public String getUserName(){return UserName;}
	public String getChildUserName(){return ChildUserName;}
	public String getUserNameAuto(){return userNameAuto;}
	public String getUserID(){return userID;}
	public String getUserProfileName(){return userProfileName;}
	public String getExUserName(){return ExUserName;}
	public String getInvalidUserName(){return InvalidUserName;}
	public String getPassword(){return Password;}
	public String getKooPostText(){return KooPostText;}
	public String getEditPost(){return EditPost;}
	public String getAadharcardNumber(){return AadharcardNumber;}
	public String getExecution_Desktop(){return Execution_Desktop;}
	public String getLocalhost(){return localhost;}
	public String getAutoTestUserID(){return autoTestUserID;}
	public String getAutoTestUser(){return autoTestUser;}
	public String getAutoBlockedUser(){return autoBlockedUser;}
	public String getAutoTestUserID_02(){return autoTestUserID_02;}
	public String getAutoBlockedUser_02(){return autoBlockedUser_02;}
	public String getAutoNewUser(){return autoNewUser;}
	public String getAutoNewUserForOnBoarding(){return autoNewUserForOnBoarding;}
	public String getSearch(){return search;}
	public String getNewUserNumber(){return NewUserNumber;}
	public String getInvalidEmail(){return InvalidEmail;}
	public String getAutoNewUserForPollKoo(){return autoNewUserForPollKoo;}
	public String getAutoNewUser_03(){return autoNewUser_03;}
	public String getAutoChildUser(){return autoChildUser;}
	public String getChildUserNumber(){return ChildUserNumber;}
	public String getTopicsArrangedUser(){return topicsArrangedUser;}
	public String getUser1_verifyLikeCommentRekooCount(){return user1_verifyLikeCommentRekooCount;}
	public String getUserHandleName_1_verifyLikeCommentRekooCount(){return userHandleName_1_verifyLikeCommentRekooCount;}
	public String getUserName_1_verifyLikeCommentRekooCount(){return userName_1_verifyLikeCommentRekooCount;}
	public String getUser2_verifyLikeCommentRekooCount(){return user2_verifyLikeCommentRekooCount;}
	public String getUserHandleName_2_verifyLikeCommentRekooCount(){return userHandleName_2_verifyLikeCommentRekooCount;}

	// Framework Initialization
	public void suiteSetup() {
		try {
			frameworkSetup();
		} catch (Exception e) {
			LOGGER.error("Exception " + e.getClass().getName() + " caught from suitesetup menthod");
		}
	}

	public WebDriver createBrowserInstance(String browserType) {
		WebDriver driver = null;
		browserType = browserType.toUpperCase();
		ChromeOptions options = null;
		switch (browserType) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "CHROMEHEADLESS":
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("--no-sandbox");
			options.addArguments("window-size=1920,1080");
			options.addArguments("--start-fullscreen");
			driver = new ChromeDriver(options);
			break;
		}
		driver.manage().timeouts().setScriptTimeout(Long.parseLong(TestConfig.getInstance().getScriptTimeoutSecounds()),
				TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getInstance().getAVGWAITTIME()),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getInstance().getScriptTimeoutSecounds()),
				TimeUnit.SECONDS);

		return driver;
	}

	public WebDriver setMobileDriver(String platform, String udid, String systemPort, String deviceName,
			String deviceVersion) throws Exception {
		platform="Android 13";
		udid = "R9PW40BK8NN";
		systemPort = "8200";
		deviceName = "";
		deviceVersion = "Android 13";
		WebDriver mobileDriver = null;
		String[] platformInfo = platform.split(" ");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);


		capabilities.setCapability("app",
				System.getProperty("user.dir") + "/src/main/resources/MobileApps/v_0.99.999913.apk");
		capabilities.setCapability("appPackage", "com.koo.app");
		capabilities.setCapability("appActivity", "com.koo.onboarding.OnBoardingActivity");

		capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

		try {
			mobileDriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Appium server not started.. Trying again");
			mobileDriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}

		mobileDriver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
		return mobileDriver;		
	}

	private void frameworkSetup() throws IOException {
		browser = config.getPropertyValue("browser");
		appURL = config.getPropertyValue("appURL");
		appUserId = config.getPropertyValue("appUserId");
		appPWD = config.getPropertyValue("appPWD");
		reportPath = config.getPropertyValue("reportPath");
		ENVName = config.getPropertyValue("ENVName");
		testSuiteName = config.getPropertyValue("testSuiteName");
		FailureRetryCount = Integer.parseInt(config.getPropertyValue("FailureRetryCount"));
		recordingFlag = config.getPropertyValue("recordingFlag");
		MINWAITTIME = config.getPropertyValue("MINWAITTIME");
		AVGWAITTIME = config.getPropertyValue("AVGWAITTIME");
		MAXWAITTIME = config.getPropertyValue("MAXWAITTIME");
		OBJWAITTIME = config.getPropertyValue("OBJWAITTIME");
		scriptTimeoutSecounds = config.getPropertyValue("scriptTimeoutSecounds");
		webmobileFlag = config.getPropertyValue("webmobileFlag");
		
		//Android properties
		platform = config.getPropertyValue("platform");
		udid = config.getPropertyValue("udid");
		port = config.getPropertyValue("port");
		UserName = config.getPropertyValue("UserName");
		ChildUserName = config.getPropertyValue("ChildUserName");
		userNameAuto = config.getPropertyValue("userNameAuto");
		userID = config.getPropertyValue("userID");
		userProfileName = config.getPropertyValue("userProfileName");
		ExUserName = config.getPropertyValue("ExUserName");
		InvalidUserName = config.getPropertyValue("InvalidUserName");
		Password = config.getPropertyValue("Password");
		KooPostText = config.getPropertyValue("KooPostText");
		EditPost = config.getPropertyValue("EditPost");
		AadharcardNumber = config.getPropertyValue("AadharcardNumber");
		Execution_Desktop = config.getPropertyValue("Execution_Desktop");
		localhost = config.getPropertyValue("localhost");
		autoTestUserID = config.getPropertyValue("autoTestUserID");
		autoTestUser = config.getPropertyValue("autoTestUser");
		autoBlockedUser = config.getPropertyValue("autoBlockedUser");
		autoTestUserID_02 = config.getPropertyValue("autoTestUserID_02");
		autoBlockedUser_02 = config.getPropertyValue("autoBlockedUser_02");
		autoNewUser = config.getPropertyValue("autoNewUser");
		autoNewUserForOnBoarding = config.getPropertyValue("autoNewUserForOnBoarding");
		search = config.getPropertyValue("search");
		NewUserNumber = config.getPropertyValue("NewUserNumber");
		InvalidEmail = config.getPropertyValue("InvalidEmail");
		autoNewUserForPollKoo = config.getPropertyValue("autoNewUserForPollKoo");
		autoNewUser_03 = config.getPropertyValue("autoNewUser_03");
		autoChildUser = config.getPropertyValue("autoChildUser");
		ChildUserNumber = config.getPropertyValue("ChildUserNumber");
		topicsArrangedUser = config.getPropertyValue("topicsArrangedUser");
		user1_verifyLikeCommentRekooCount = config.getPropertyValue("user1_verifyLikeCommentRekooCount");
		userHandleName_1_verifyLikeCommentRekooCount = config.getPropertyValue("userHandleName_1_verifyLikeCommentRekooCount");
		userName_1_verifyLikeCommentRekooCount = config.getPropertyValue("userName_1_verifyLikeCommentRekooCount");
		user2_verifyLikeCommentRekooCount = config.getPropertyValue("user2_verifyLikeCommentRekooCount");
		userHandleName_2_verifyLikeCommentRekooCount = config.getPropertyValue("userHandleName_2_verifyLikeCommentRekooCount");
	}

}
