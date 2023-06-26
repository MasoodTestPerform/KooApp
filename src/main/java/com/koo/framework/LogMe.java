package com.koo.framework;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LogMe {
	private Logger logger = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	public String test_name=null;
	
	public void setupTestObj(String test_name) {
		this.driver = BaseTest.driver.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
		this.test_name = test_name;
	}
	

	public LogMe(Class loggerClass) {
		logger = Logger.getLogger(loggerClass);
	}


	public void logInfo(ExtentTest extentTest, String message, String...status) {
		if(status.length>0) {
			logInfo(this.extentTest, "---- "+ status[0] + " ---"+message);
		}else {
			logInfo("---INFO--- " + message);
		}
		
		if (this.extentTest != null) {
			this.extentTest.log(Status.INFO, "---INFO--- " + message);
		}
	}
	
	public void logInfo(String message) {
		logger.info("---INFO--- " + message);
	}

	public void logInfo(ExtentTest extentTest, String status, String message) {
		if(status.toUpperCase().trim() == "INFO") {
			if (this.extentTest != null) {
				logInfo("---INFO--- " + message);
				this.extentTest.log(Status.INFO, message);				
			}
		}
		if(status.toUpperCase().trim() == "WARNING") {
			if (this.extentTest != null) {
				logInfo("---WARNING--- " + message);
				this.extentTest.log(Status.WARNING, message);
			}
		}
		if(status.toUpperCase().trim() == "PASS") {
			if (this.extentTest != null) {
				logInfo("---PASS--- " + message);
				this.extentTest.log(Status.PASS, message);
			}
		}
		if(status.toUpperCase().trim() == "FAIL") {
			if (this.extentTest != null) {
				logInfo("---FAIL--- " + message);
				this.extentTest.log(Status.FAIL, message);
			}
		}
		
	}

	public void logWarn(ExtentTest extentTest, String message) {
		logInfo("---WARN--- " + message);

		if (this.extentTest != null) {
			this.extentTest.log(Status.WARNING, message +".");
		}
	}

	public void logWarn(ExtentTest extentTest, String message, String screenshotPath) {
		logInfo("---WARN--- " + message);

		if (this.extentTest != null) {
			//extentTest.log(Status.WARNING, "---WARN--- " + message + extentTest.addScreenCaptureFromPath(screenshotPath));
			logWithScreenshot("warning", message, driver);
			
		}
	}

	public void logWarn(ExtentTest extentTest, String message, String... screenshotPath) {
		logInfo("---WARN--- " + message);

		if (this.extentTest != null) {
			if (screenshotPath == null) {
				extentTest.log(Status.WARNING, "---WARN--- " + message + ".");
			} else {
				logWithScreenshot("warning", message, driver);
			}
		}
	}

	public void logError(ExtentTest extentTest, String message) {
		logInfo("---ERROR--- " + message);

		if (extentTest != null) {
			logWithScreenshot("fail", "---ERROR--- " + message, driver);
		}
	}
	
	public void logError(String message) {
		logInfo("---ERROR--- " + message);
	}

	public void logError(ExtentTest extentTest, String message, String screenshotPath) {
		logInfo("---ERROR--- " + message);

		if (this.extentTest != null) {
			logWithScreenshot("fail", message, driver);
		}
	}
	
	@SuppressWarnings("unused")
	public void logError(ExtentTest extentTest, String message, String screenshotPath, String oldImage) {
		try {
			logInfo("---ERROR--- " + message);
			
			if (this.extentTest != null) {
				logWithScreenshot("fail", message, driver);
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

	public void logError(ExtentTest extentTest, String message, String... screenshotPath) {
		logInfo("---ERROR--- Exception " + message + " encountered");
		
		if (this.extentTest != null) {
			if (screenshotPath == null) {
				this.extentTest.log(Status.FAIL, "---ERROR--- " + message + ".");
				logWithScreenshot("fail", "---ERROR--- " + message + ".", driver);
			} else {
				logWithScreenshot("fail", message, driver);
				
			}
		}
	}	

	public ExtentTest logBeginTestCase(String tsName) {
		logInfo("---INFO---Strating test case " + tsName);
		return ExtentManager.getInstance().createTest(tsName);
	}

	public void logBeginTestCase(ExtentTest extentTest, String tsName, String desc) {
		logInfo("---INFO---Strating Test Case : " + tsName);
		logInfo("---INFO---Test Case Description : " + desc);
		this.extentTest = ExtentManager.getInstance().createTest(tsName, desc);
	}
	
	public void logEndTestCase(String tsName, ExtentTest extentTest) {
		logInfo("---INFO---Test Case : " + tsName + " finished");
		ExtentManager.getInstance().flush();
	}

	public void logTestStep(ExtentTest extentTest, String status, String message, boolean screenShot, WebDriver driver ) {
		Status stepStatus = Status.valueOf(status.toUpperCase());

		switch (stepStatus) {
		case PASS:
			if (screenShot == true) {
				logWithScreenshot("pass", message, driver);
			} else {
				logInfo(extentTest, "PASS", message);
			}
			break;
		case FAIL:
			logError(extentTest, "---FAIL---" + message, captureScreen(driver));
			break;
		case SKIP:
		case INFO:
			if (screenShot == true) {
				logWithScreenshot("INFO", message , driver);
			} else {
				BaseTest.extentTest.get().log(Status.INFO, message);
				logInfo("---INFO--- " + message);
				//logInfo(extentTest, "INFO", message);
			}
			break;
		case WARNING:
			if (screenShot == true) {
				//logInfo("---WARNING---" + message);				
				logWithScreenshot("WARNING", message, driver);
			} else {
				logInfo(extentTest, "WARNING" + message);	
			}
			break;
		default:
			break;
		}
	}	
		
	public void logWithScreenshot(String status, String msg, WebDriver driver) {
		try {
			if(status.equalsIgnoreCase("warning")) {
				extentTest.log(Status.WARNING, msg,
						MediaEntityBuilder.createScreenCaptureFromPath(this.captureScreen(driver)).build());
				logInfo("---WARNING--- " + msg);
			}
			if(status.equalsIgnoreCase("info")) {
				extentTest.log(Status.INFO, msg,
						MediaEntityBuilder.createScreenCaptureFromPath(this.captureScreen(driver)).build());
				logInfo("---INFO--- " + msg);
					System.out.println(msg);
			}
			if(status.equalsIgnoreCase("pass")) {
				extentTest.log(Status.PASS, msg,
						MediaEntityBuilder.createScreenCaptureFromPath(this.captureScreen(driver)).build());
				logInfo("---PASS--- " + msg);
					System.out.println(msg);
			}
			if(status.equalsIgnoreCase("fail")) {
				extentTest.log(Status.FAIL, msg,
						MediaEntityBuilder.createScreenCaptureFromPath(this.captureScreen(driver)).build());
				logInfo("---FAIL--- " + msg);
					System.out.println(msg);
			}
			if(status.equalsIgnoreCase("skip")) {
				extentTest.log(Status.SKIP, msg,
						MediaEntityBuilder.createScreenCaptureFromPath(this.captureScreen(driver)).build());
				logInfo("---SKIP--- " + msg);
					System.out.println(msg);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logWithScreenshot(String status, String msg) {
		try {
			if(status.equalsIgnoreCase("warning")) {
				extentTest.log(Status.WARNING, msg);
				logInfo("---WARNING---"+ msg);
			}
			if(status.equalsIgnoreCase("info")) {
				extentTest.log(Status.INFO, msg);
				logInfo("---INFO---"+ msg);
			}
			if(status.equalsIgnoreCase("pass")) {
				extentTest.log(Status.PASS, msg);
				logInfo("---PASS---"+ msg);
			}
			if(status.equalsIgnoreCase("fail")) {
				extentTest.log(Status.FAIL, msg);
				logInfo("---FAIL---"+ msg);
			}
			if(status.equalsIgnoreCase("skip")) {
				extentTest.log(Status.SKIP, msg);
				logInfo("---SKIP---"+ msg);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String captureScreen(WebDriver driver) {
		String filePath = null;
		String timeStamp = null;
		try {
			timeStamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()).replace(" ", "-").replaceAll(":", "-");
			filePath = test_name + "-" +timeStamp+ ".jpg";
			//File dest = new File(System.getProperty("user.dir") + "/Framework/Test_Reports/" + filePath);
			File dest = new File(BaseTest.SCREENSHOT_FOLDER_PATH+"/" +filePath);
		
			if (!dest.exists()) {
				dest.createNewFile();
			}
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, dest);
			filePath = "Screenshots/"+filePath;
		} catch (IOException e) {
			e.printStackTrace();
			filePath = null;
		}
		return filePath;
	}
}
