package com.koo.framework;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.koo.setup.TestConfig;

public class AssertManager {
	public AssertManager() {		
	};
	
	private LogMe LOGGER = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	
	public void setupTestObj() {
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			this.driver = BaseTest.mobileDriver.get();
		}else {
			this.driver = BaseTest.driver.get();
		}
		this.LOGGER = BaseTest.LOGGER.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
	}
	public void sAssertEquals(String actual, String expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected.equals(actual)) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, true, driver);
				log(Status.PASS,message + " - Successful.Expected match with Actual value:"+expected );
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	public void sAssertContains(String actual, String expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected.equals(actual)) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Contains Expected match with Actual value:"+expected, true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Contains Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Contains Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	public void sAssertEquals(boolean actual, boolean expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected == actual) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	public void sAssertEquals(double actual, double expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected == actual) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	public void sAssertEquals(float actual, float expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected == actual) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	public void sAssertEquals(int actual, int expected, String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (expected == actual) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.Expected match with Actual value:"+expected, false, driver);
			}
			
		}else{
			LOGGER.logTestStep(extentTest, "FAIL",message + "-Failed.<br>Expected:" + expected + " <br>Actual  :" + actual, true, driver);
			BaseTest.sAssert.get().assertEquals(actual, expected, message + " - Failed");	
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}
	
	public void sAssertTrue(Boolean condition, String message,boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if (condition) {
			if(screenshot) {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.", true, driver);
			}else {
				LOGGER.logTestStep(extentTest, "PASS", message + " - Successful.", false, driver);
			}
			
		}else {
			LOGGER.logTestStep(extentTest, "FAIL", message + " - Failed.", true, driver);
			BaseTest.sAssert.get().assertTrue(condition, message + " - Failed");
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}		
	}

	public void sAssertException(String message, boolean screenshot, WebDriver driver, Boolean...hardAssert) {
		if(screenshot) {
			LOGGER.logTestStep(extentTest, "FAIL", "Exception occured while validating."+ message + " - Failed.", true, driver);
			BaseTest.extentTest.get().log(Status.FAIL,"Exception occured while validating. Please investigate!!! "+message);
			BaseTest.sAssert.get().assertEquals(false, true, "Exception occured in while validating "+message);
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}else {
			LOGGER.logTestStep(extentTest, "FAIL", "Exception occured while validating."+ message + " - Failed.", false, driver);
			BaseTest.sAssert.get().assertEquals(false, true, "Exception occured in while validating "+message);
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		}
	}
	public void log(Status status, String msg, Boolean...hardAssert) {
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg= addLinebreaks(msg, 100);
		if (status == Status.PASS) {
			BaseTest.extentTest.get().log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			System.out.println(msg);
		} else if (status == Status.SKIP) {
			BaseTest.extentTest.get().log(Status.SKIP, MarkupHelper.createLabel(msg, ExtentColor.ORANGE));
			System.out.println("SKIPPED - " + msg);
		} else if (status == Status.FAIL) {
			BaseTest.extentTest.get().log(status, MarkupHelper.createLabel(msg, ExtentColor.RED));
			System.err.println(msg);
			if(hardAssert.length > 0) {
				if(hardAssert[0].equals(true)) {
					Assert.fail();
				}
			}
		} else if (status == Status.INFO) {
			BaseTest.extentTest.get().log(Status.INFO, MarkupHelper.createLabel(msg, ExtentColor.WHITE));
			System.out.println(msg);
		}
		
	}
	
	public void logWithNoLineBreak(Status status, String msg) {
		if (status == Status.PASS) {
			BaseTest.extentTest.get().log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
			System.out.println(msg);
		} else if (status == Status.SKIP) {
			BaseTest.extentTest.get().log(Status.SKIP, MarkupHelper.createLabel(msg, ExtentColor.ORANGE));
			System.out.println("SKIPPED - " + msg);
		} else if (status == Status.FAIL) {
			BaseTest.extentTest.get().log(status, MarkupHelper.createLabel(msg, ExtentColor.RED));
			System.err.println(msg);
		} else if (status == Status.INFO) {
			BaseTest.extentTest.get().log(Status.INFO, MarkupHelper.createLabel(msg, ExtentColor.WHITE));
			System.out.println(msg);
		}
	}
	public void customlog(Status status, String msg) {
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg= addLinebreaks(msg, 100);
		if (status == Status.PASS) {
			BaseTest.extentTest.get().log(Status.PASS, msg);
			System.out.println(msg);
		} else if (status == Status.SKIP) {
			BaseTest.extentTest.get().log(Status.SKIP, msg);
			System.out.println("SKIPPED - " + msg);
		} else if (status == Status.FAIL) {
			BaseTest.extentTest.get().log(status, msg);
			System.err.println(msg);
		} else if (status == Status.INFO) {
			BaseTest.extentTest.get().log(Status.INFO, msg);
			System.out.println(msg);
		}
	}
	public String addLinebreaks(String input, int maxLineLength) {
		StringBuilder output = new StringBuilder(input.length());
		String[] msgArr = input.split("(?<=\\G.{"+ maxLineLength+"})");
		for(int i=0;i<msgArr.length;i++) {
			output.append(msgArr[i]+"<br>");
		}
		return output.toString();
		
	}
	
	public void log(String msg, WebDriver driver) {
		BaseTest.extentTest.get().log(Status.FAIL, msg,MediaEntityBuilder.createScreenCaptureFromPath(BaseTest.LOGGER.get().captureScreen(driver)).build());
		System.err.println(msg);
	}

}
