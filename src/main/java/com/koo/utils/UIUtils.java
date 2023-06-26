package com.koo.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.koo.framework.BaseTest;
import com.koo.framework.LogMe;
import com.koo.setup.TestConfig;

public class UIUtils {
	private LogMe LOGGER = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	
	public void setupTestObj() {
		this.LOGGER = BaseTest.LOGGER.get();
		this.driver = BaseTest.driver.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
	}
	
	public void waitForSec(int i) {
		try {
			long timeInSec = i*1000;
			Thread.sleep(timeInSec);
		}catch(InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	public String getPageTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageTitle = null;
		try {
			if(js.executeScript("return document.readyState").toString().equals("complete")) {
				pageTitle = driver.getTitle();
			}else {
				for(int i=1; i<=15; i++) {
					waitForSec(1);
					if(js.executeScript("return document.readyState").toString().equals("complete")) {
						pageTitle = driver.getTitle();
						break;
					}
				}
			}
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in getPageTitle:"+e.getMessage(), true, this.driver, false);
		}
		return pageTitle;
	}
	
	public void validatePageTitle(String expectedPageTtitle, boolean isHardAssert) {
		try {
			String actualPageTitle = getPageTitle(driver);
			LOGGER.logTestStep(extentTest, "INFO", "<b><Going to valiadate page title><b>", false, this.driver);
			BaseTest.sAssert.get().assertEquals(actualPageTitle, expectedPageTtitle);
			if(isHardAssert) {
				BaseTest.sAssert.get().assertAll();
				Assert.fail("validatePageTitle failed");
			}
				
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), isHardAssert,this.driver);
		}
	}
	public boolean objWait(String elementName, By by, String maxDurationInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Integer.parseInt(maxDurationInSec)))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);

		wait.until((ExpectedConditions.presenceOfElementLocated(by)));
		flag = driver.findElement(by).isDisplayed();
		wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		wait.until((ExpectedConditions.elementToBeClickable(by)));
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in element:"+elementName+ " wait."+e.getMessage(), true, this.driver, hardAssert);
			flag = false;
		}		
		return flag;
	}
	
	public boolean objWaitWithoutIsDisplayed(String elementName, By by, String maxDurationInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Integer.parseInt(maxDurationInSec)))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
		wait.until((ExpectedConditions.presenceOfElementLocated(by)));
		//flag = driver.findElement(by).isDisplayed();
		wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		wait.until((ExpectedConditions.elementToBeClickable(by)));
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in element:"+elementName+ " wait."+e.getMessage(), true, this.driver, hardAssert);
			flag = false;
		}		
		return flag;
	}
	
	public WebElement findElement(String elementName, By by,String waitTimeInSec, boolean hardAssert) {
		objWait(elementName, by, waitTimeInSec, hardAssert);
		WebDriverWait wWait = new WebDriverWait(driver, Integer.parseInt(waitTimeInSec));
		return wWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
		
	public void inputText(String elementName, By by, String data) {
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			element.clear();
			element.sendKeys(data);
			if(data.toLowerCase().contains("password")) {
				LOGGER.logTestStep(extentTest, "INFO", "Entered password text:****** on element:"+elementName, false, this.driver);
			}else {
				LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+ " on element:"+elementName, false, this.driver);
			}			
		}catch(Exception e) {
			if(data.toLowerCase().contains("password")) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text **** on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
			}else {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+ " on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
			}			
		}
	}
	
	public void inputTextUsingActionClass(String elementName, By by, String data) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).sendKeys(data).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+" on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+" using action class on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public void clickElement(String elementName, By by) {
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			element.click();
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+elementName, false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clicking on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public String getText(String elementName, By by, boolean logMsg) {
		String text = null;
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			text = element.getText().trim();
			if(StringUtils.isBlank(text)) {
				text = element.getAttribute("value").trim();
			}
			if(logMsg==true) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" text value:"+text+".", false, this.driver);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve text of element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, false);
		}
		return text;
	}
	
	public void selectValue(String elementName, By by, String selectBy, String option) {
		try {
			objWait(elementName, by,TestConfig.getInstance().getOBJWAITTIME(), true);
			Select select = new Select(driver.findElement(by));
			switch (selectBy.toLowerCase()) {
			case "index":
				select.selectByIndex(Integer.valueOf(option));
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false, this.driver);
				break;
			case "text":
				select.selectByVisibleText(option);
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false, this.driver);
				break;
			case "value":
				select.selectByValue(option);
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false, this.driver);
				break;
			case "containstext":
				int indexNum = 1;
				for(WebElement element : select.getOptions()) {
					if(element.getText().toLowerCase().contains(option.toLowerCase())) {
						select.selectByIndex(indexNum);
						LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown containstext value as :"+option+" on element::"+elementName+".", false, this.driver);
						break;
					}
					indexNum++;
					
				}
			default:
				break;
			}			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while selecting the value:"+option+ " on element:"+elementName+".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public String getSelectedValue(String elementName, By by) {
		String selectedText = null;
		try {
			objWait(elementName, by,TestConfig.getInstance().getOBJWAITTIME(), true);
			Select select = new Select(driver.findElement(by));
			selectedText = select.getFirstSelectedOption().getText();						
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while getting the first selected option for element :"+elementName+".Exception"+e.getMessage(), true, this.driver,false);
		}
		return selectedText;
	}
	
	public void moveToElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Moved on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while moving on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	public void clickElementUsingAction(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).click().build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clickElementUsingAction on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public void rightClickElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.contextClick(element).perform();
			LOGGER.logTestStep(extentTest, "INFO", "Right clicked on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while right clicking on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public void doubleClickElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.doubleClick().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Double clicked on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while double clicking on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public void pressKeyboardKeys(String elementName, By by, Keys data) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).sendKeys(data).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Pressed keyboard keys:"+data+" on element:"+elementName+".", false, this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while pressing the keyboard keys:"+data+" on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
	}
	
	public String getRandomNumber(int digCount) {
		String num = null;
		try {
			num = CommonUtils.generateNumericNumber(digCount);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while getting the random number.Exception"+e.getMessage(), true, this.driver, true);
		}
		return num;
	}
	
	public boolean waitForInvisibilityOfElement(String elementName, By by, String waitInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			WebDriverWait wWait = new WebDriverWait(driver, Integer.parseInt(waitInSec));
			wWait.until(ExpectedConditions.invisibilityOfElementLocated(by));			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while waiting for invisibility of element:"+elementName+".Exception"+e.getMessage(), true, this.driver, true);
			flag = false;
		}
		return flag;		
	}
	
	public boolean getRightWindow(String windowTitle) {
		String title = null;
		try {
			Set<String> handles = driver.getWindowHandles();
			List<String> hlist = new ArrayList<String>(handles);
			for(String handle : hlist) {
				title = driver.switchTo().window(handle).getTitle();
				if(title.contains(windowTitle)) {
					return true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while navigating between the screen:"+windowTitle+".Exception"+e.getMessage(), true,this.driver, true);					
		}
		return false;
	}
	
	public String getTextUsingJS(String elementName, String xpath, boolean logMsg) {
		String objVal = null;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			objVal = (String) js.executeScript("return document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.value;");
			if(logMsg) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" text value using JS as:"+objVal+".", false, this.driver);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve text using JS of element:"+elementName+".Exception"+e.getMessage(), true, this.driver, false);
		}
		
		return objVal;
	}
	
	public void clickElementUsingJS(String elementName, String xpath, boolean logMsg) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("return document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.click();");
			if(logMsg) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" clicked using JS.", false, this.driver);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Element clicked using JS of element:"+elementName+".Exception"+e.getMessage(), true, this.driver, false);
		}
	}
		
	public boolean validateObjectPresent(By by, String objectName, boolean screenShot, boolean isHardAssert) {
		boolean flag = false;
		try {
			LOGGER.logTestStep(extentTest, "INFO", "Going to valiadate object:"+objectName+" presents in page", false, this.driver);
			boolean isObjPresent= objWait(objectName, by, "90", isHardAssert);
			if(isObjPresent) {
				flag = true;
			}
			LOGGER.logTestStep(extentTest, "INFO", "isObjPresent:"+isObjPresent, false, this.driver);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(isObjPresent, true, "Validating presense of element:"+objectName, screenShot, this.driver, isHardAssert);
			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), true, this.driver, isHardAssert);
			flag = false;
		}
		return flag;
	}
	public boolean validateObjectPresentWithoutIsDisplayed(By by, String objectName, boolean screenShot, boolean isHardAssert) {
		boolean flag = false;
		try {
			LOGGER.logTestStep(extentTest, "INFO", "Going to valiadate object:"+objectName+" presents in page", false, this.driver);
			boolean isObjPresent= objWaitWithoutIsDisplayed(objectName, by, "90", isHardAssert);
			if(isObjPresent) {
				flag = true;
			}
			LOGGER.logTestStep(extentTest, "INFO", "isObjPresent:"+isObjPresent, false, this.driver);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(isObjPresent, true, "Validating presense of element:"+objectName, screenShot, this.driver, isHardAssert);
			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), true, this.driver, isHardAssert);
			flag = false;
		}
		return flag;
	}
	
	public void scrollIntoView(By by) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
			waitForSec(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int objCnt(By by) {
		int cnt =0;
		try {
			setOnMinImplicitWait();
			cnt = driver.findElements(by).size();
			setOffMinImplicitWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public void setOnMinImplicitWait() {
		BaseTest.driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void setOffMinImplicitWait() {
		BaseTest.driver.get().manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getInstance().getScriptTimeoutSecounds()), TimeUnit.SECONDS);
	}
}

