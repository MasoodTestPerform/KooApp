package com.koo.android.utils;

import java.util.concurrent.TimeUnit;
//import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.koo.framework.BaseTest;
import com.koo.framework.LogMe;
import com.koo.setup.TestConfig;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;


import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MobileActions {
	private LogMe LOGGER = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	private Actions action = null;
	
	public void setupTestObj() {
		this.LOGGER = BaseTest.LOGGER.get();
		this.driver = BaseTest.mobileDriver.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
		this.action = new Actions(BaseTest.mobileDriver.get());
	}
	
	public void waitForSec(int i) {
		try {
			long timeInSec = i*1000;
			Thread.sleep(timeInSec);
		}catch(InterruptedException e) {
			e.printStackTrace();			
		}
	}

    

    public void sleep(int timeInMilliSec) {
        try {
            Thread.sleep(timeInMilliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void hideKeyboard() {
    	((MobileActions) BaseTest.mobileDriver.get()).hideKeyboard();
    }
    
    public MobileElement swipeHorizontally(String locatorType, String viewIdentificator, String text, String attribute) {
        WebElement element = BaseTest.mobileDriver.get()
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." + locatorType + "(\""
                        + viewIdentificator + "\")).setAsHorizontalList()." + "scrollIntoView(" + "new UiSelector()."
                        + attribute + "(\"" + text + "\"));"));

        List<WebElement> elements = BaseTest.mobileDriver.get()
                .findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));

        return (MobileElement) element;

    }

    
    public WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(BaseTest.mobileDriver.get(),Long.parseLong(TestConfig.getInstance().getOBJWAITTIME()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public boolean isElementDisplayed(By locator) {
    	boolean flag = false;
    	try {
        WebDriverWait wait = new WebDriverWait(BaseTest.mobileDriver.get(),Long.parseLong(TestConfig.getInstance().getOBJWAITTIME()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        flag=true;
    	}catch(Exception e) {
    		flag=false;
    	}
    	
    	return flag;
    }
    
    public boolean objWait(String elementName, By by, String maxDurationInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(maxDurationInSec)) ;
		wait.until((ExpectedConditions.presenceOfElementLocated(by)));
		//flag = driver.findElement(by).isDisplayed();
		wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		wait.until((ExpectedConditions.elementToBeClickable(by)));
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			
		}
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
    
    public boolean isDisplayed(By locator, String elementName) {
    	boolean isPresent = false;
    	try {
	    	WebElement elm = waitForVisible(locator);
	    	isPresent = elm.isDisplayed();
	        LOGGER.logTestStep(extentTest, "INFO", elementName + " isDisplayed value is "+isPresent, false, this.driver);
        }catch(Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in isDisplayed for "+elementName+".Exception"+e.getMessage(), true, this.driver, true);
        }
    	return isPresent;
    }
    
    public void click(By by, String elementName) {
        try {
	    	WebElement elm = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
	        elm.click();
	        LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+elementName+".", false, this.driver);
        }catch(Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Clicked on element:"+elementName+".Exception"+e.getMessage(), true, this.driver, true);
        }
    }
    
    public void clickExceptionIgnored(By by, String elementName) {
        WebElement elm = driver.findElement(by);
	        elm.click();
	        LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+elementName+".", false, this.driver);
    }
    
    public By returnByBasedOnPageNameAndObjectName(String locator, String locatorType, String textToReplace) {
    	By by = null;
    	try {
        	String locatorValue = locator.replaceAll("###", textToReplace);
        	if(locatorType==null || locatorType.equalsIgnoreCase("xpath") ) {
        		locatorType = "xpath";
        		by = By.xpath(locatorValue);
        	}
        	if (locatorType.equalsIgnoreCase("id")) {
        		by = By.id(locatorValue);
        	}
        }catch(Exception e) {
        	//e.printStackTrace();
			//BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in returnByBasedOnPageNameAndObjectName.Exception"+e.getMessage(), true, this.driver, false);
        }
    	return by;
    }
    
    public void sendKeys(By by, String elementName, String data) {
    	try {
	    	WebElement elm = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
	    	elm.sendKeys(data);
	        LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+ " on element:"+elementName, false, this.driver);
    	}catch(Exception e) {
    		BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+ " on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
    	}
    }
    
    public void clearAndSendKeys(By by, String elementName, String data) {
    	try {
	    	WebElement elm = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
	    	elm.click();
	    	elm.clear();
	    	elm.sendKeys(data);
	        LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+ " on element:"+elementName, false, this.driver);
    	}catch(Exception e) {
    		BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+ " on element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
    	}
    }
    
    public String getText(By by, String elementName, boolean logMsg) {
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
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve text of element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, true);
		}
		return text;
	}
    
    public String getAttribute(By by, String attributeValue, String elementName, boolean logMsg) {
		String attributeVal = null;
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			attributeVal = element.getAttribute(attributeValue).trim();
			
			if(logMsg==true) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" attribute value:"+attributeValue+" is "+attributeVal, false, this.driver);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve attribute value of element:"+elementName+ ".Exception"+e.getMessage(), true, this.driver, false);
		}
		return attributeVal;
	}
    
    public List<WebElement> elements(By locator) {
        List<WebElement> elmList = driver.findElements(locator);
        return elmList;
    }
    
    public void swipeUp(int howManySwipes) {
        try {
	    	Dimension size = driver.manage().window().getSize();
	        // calculate coordinates for vertical swipe
	        int startY = (int) (size.height * 0.70);
	        int endY = (int) (size.height * 0.30);
	        int startX = (size.width / 2);
        
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
                        .perform();
            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to SwipeUp.Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public void swipeDown(int howManySwipes) {
    	try {
	        // calculate coordinates for vertical swipe
	        Dimension size = driver.manage().window().getSize();
	        int startY = (int) (size.height * 0.70);
	        int endY = (int) (size.height * 0.30);
	        int startX = (size.width / 2);
        
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, endY)).moveTo(PointOption.point(startX, startY)).release()
                        .perform();
                System.out.println("swipeDown");
            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to SwipeDown.Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public void swipeRightToLeft(int howManySwipes) {
    	try {
	    	Dimension size = driver.manage().window().getSize();
	        // calculate coordinates for horizontal swipe
	        int startY = (int) (size.height / 4);
	        int startX = (int) (size.width * 0.90);
	        int endX = (int) (size.width * 0.10);
        
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release()
                        .perform();

            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to swipeRightToLeft.Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public void swipeLeftToRight(int howManySwipes) {
    	try {
	    	Dimension size = driver.manage().window().getSize();
	        // calculate coordinates for horizontal swipe
	        int startY = (int) (size.height / 2);
	        int startX = (int) (size.width * 0.10);
	        int endX = (int) (size.width * 0.90);
        
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release()
                        .perform();
            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to swipeLeftToRight.Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public void swipeUpFindElementClick(int howManySwipes, By locator) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        // calculate coordinates for vertical swipe
        int startY = (int) (size.height * 0.70);
        int endY = (int) (size.height * 0.30);
        int startX = (size.width / 2);
        try {
            for (int i = 1; i <= howManySwipes; i++) {
                boolean isElmPresent = driver.findElements(locator).size() > 0;
                if (isElmPresent) {
                    driver.findElement(locator).click();
                    break;
                }
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
                        .perform();
            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to swipeUpFindElementClick.Exception"+e.getMessage(), true, this.driver, true);
        }
    }
    
    public void swipeUpFindElement(int howManySwipes, By locator) {
    	try {
	    	Dimension size = driver.manage().window().getSize();
	        // calculate coordinates for vertical swipe
	        int startY = (int) (size.height * 0.70);
	        int endY = (int) (size.height * 0.30);
	        int startX = (size.width / 2);
        
            for (int i = 1; i <= howManySwipes; i++) {

                boolean isElmPresent = driver.findElements(locator).size() > 0;
                if (isElmPresent) {
                    // DriverFactory.getInstance().getMobileDriver().findElement(locator).click();
                    break;
                }
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
                        .perform();
            }
        } catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to swipeUpFindElementClick.Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    
    public boolean isElmPresent(By locator) {
        boolean isElmPresent = driver.findElements(locator).size() > 0;
        return isElmPresent;
    }
    
    public void pressKeyboardValues(Keys value) {
    	try {
	    	action.sendKeys(value).build().perform();
	        LOGGER.logTestStep(extentTest, "INFO", "Performed keyboard action.Value:"+value, false, this.driver);
    	}catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to pressKeyboardValues.Value:"+value+". Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public int getInt(By locator) {
    	int elmIntTxt = 0 ;
        try {
	    	WebElement elm = waitForVisible(locator);
	        String elmText = elm.getText();
	        elmIntTxt = Integer.parseInt(elmText);
	        LOGGER.logTestStep(extentTest, "INFO", "Successfully get Integer text.Text:"+elmIntTxt, false, this.driver);	        
        }catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to get Integer text.Exception"+e.getMessage(), true, this.driver, false);
        }
        return elmIntTxt;
    }
    
    public void clickUsingCoordinates(int xcordinate, int ycordinate) throws InterruptedException {
    	try {
	        new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(xcordinate, ycordinate))
	                .release().perform();
	        LOGGER.logTestStep(extentTest, "INFO", "Successfully clicked using co-ordinates.X-value:"+xcordinate+" and Y-value"+ycordinate, false, this.driver);
    	}catch (Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to click using co-ordinates.X-value:"+xcordinate+" and Y-value"+ycordinate+".Exception"+e.getMessage(), true, this.driver, false);
        }
    }
    
    public List<WebElement> getElementSizeUsingFindElements(By locator) {
        List<WebElement> lst_Elm = driver.findElements(locator);
        return lst_Elm;
    }
    
    public void tapElement(By locator, String...elementName) {
    	try {
	        WebElement elm = waitForVisible(locator);
	        new TouchAction((PerformsTouchActions) driver).tap(tapOptions().withElement(element(elm)))
	                .perform();
	        if(elementName.length>0) {
	        	LOGGER.logTestStep(extentTest, "INFO", "Successfully tapped the element:"+elementName[0], false, this.driver);
	        }else {
	        	LOGGER.logTestStep(extentTest, "INFO", "Successfully tapped the element", false, this.driver);
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to tap the element."+e.getMessage(), true, this.driver, true);
    	}
    }
    
    public boolean isEnabled(By locator, String elementName) {
    	boolean isenabled = false ;
    	try {
	        WebElement elm = waitForVisible(locator);
	        isenabled = elm.isEnabled();
	        if (isenabled) {
	        	LOGGER.logTestStep(extentTest, "INFO", "Element is enabled. Element:"+elementName, false, this.driver);
	        } else {
	        	LOGGER.logTestStep(extentTest, "INFO", "Element is not enabled. Element:"+elementName, false, this.driver);
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in isEnabled. Element:"+elementName+". "+e.getMessage(), true, this.driver, false);
    	}
        return isenabled;
    }
    
    public boolean isSelected(By locator, String elementName) {
    	boolean isChecked = false;
    	try {
	        WebElement elm = waitForVisible(locator);
	        isChecked = elm.isSelected();
	        if (isChecked) {
	        	LOGGER.logTestStep(extentTest, "INFO", "Element is selected. Element:"+elementName, false, this.driver);
	        } else {
	        	LOGGER.logTestStep(extentTest, "INFO", "Element is not selected. Element:"+elementName, false, this.driver);
	
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in isSelected. Element:"+elementName+". "+e.getMessage(), true, this.driver, false);
    	}
        return isChecked;
    }
    
//    public MobileElement swipeUsingText(String text) {
//    	MobileElement element = null;
//    	
//    	try {
//    		boolean isDisplayed = BaseTest.mobileDriver.get().findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed();
//    		if(isDisplayed) {
//    			LOGGER.logTestStep(extentTest, "INFO", "Not required swiping as text:"+text+" is visible", false, this.driver);
//    		}
//	        element = (MobileElement) driver
//	                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
//	                        + ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
//	        LOGGER.logTestStep(extentTest, "INFO", "Swipe using text completed using Text:"+text, false, this.driver);
//    	}catch(Exception e) {
//    		e.printStackTrace();
//			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeUsingText. Text:"+text+". "+e.getMessage(), true, this.driver, true);
//    	}
//        return element;
//    }
    
    public MobileElement swipeUsingText(String text) {
    	MobileElement element = null;
    	
    	try {   		
    		((AndroidDriver<WebElement>)BaseTest.mobileDriver.get()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"" + text + "\"))");
	        LOGGER.logTestStep(extentTest, "INFO", "Swipe using text completed using Text:"+text, false, this.driver);
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeUsingText. Text:"+text+". "+e.getMessage(), true, this.driver, true);
    	}
        return element;
    }
    
       
    public void swipeUsingElement(By by) {
    	RemoteWebElement element = (RemoteWebElement)BaseTest.mobileDriver.get().findElement(by);
    	String elementID = element.getId();
    	HashMap<String, String> scrollObject = new HashMap<String, String>();
    	scrollObject.put("element", elementID); // Only for ‘scroll in element’
    	scrollObject.put("direction", "down");
    	JavascriptExecutor js = (JavascriptExecutor)BaseTest.mobileDriver.get();
    	js.executeScript("mobile:scroll", scrollObject);
    }
    
    public MobileElement swipeUsingID(String id) {
    	MobileElement element = null;
    	try {
	        element = (MobileElement) driver
	                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
	                        + ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + id + ".*\"))"));
	        LOGGER.logTestStep(extentTest, "INFO", "Swipe using ID completed using ID:"+id, false, this.driver);
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeUsingId. ID:"+id+". "+e.getMessage(), true, this.driver, false);
    	}
        return element;

    }
    
    public MobileElement swipeUsingIDAndSwipeCount(String id, int count) {
    	MobileElement element = null;
    	try {
	        element = (MobileElement) driver.findElement(
	                MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes("
	                        + count + ")" + ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + id + ".*\"))"));
	        LOGGER.logTestStep(extentTest, "INFO", "Swipe using ID and swipe count completed using ID:"+id+ " and count:"+count, false, this.driver);
    	}catch(Exception e) {
    		e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeUsingIDAndSwipeCount. ID:"+id+" and count:"+count+". "+e.getMessage(), true, this.driver, false);
    	}
        return element;

    }
    
    public MobileElement swipeUsingTextAndSwipeCount(String text, int count) {
    	MobileElement element = null;
        try {
	    	element = (MobileElement) driver.findElement(
	                MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes("
	                        + count + ")" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	    	LOGGER.logTestStep(extentTest, "INFO", "Swipe using Text and swipe count completed using Text:"+text+ " and count:"+count, false, this.driver);
        }catch(Exception e) {
        	e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeUsingTextAndSwipeCount. Text:"+text+" and count:"+count+". "+e.getMessage(), true, this.driver, false);
        }
        return element;
    }
    
    public void swipeLeftOrRight(WebElement element, String direction) {
        System.out.println("swipeElementAndroid(): dir: '" + direction + "'"); // always log your actions
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;
        Rectangle rect = element.getRect();
        edgeBorder = 0;
        switch (direction) {
            case "LEFT": // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                break;
            case "RIGHT": // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + direction + "' NOT supported");
        }
        try {
            new TouchAction((PerformsTouchActions) driver).press(pointOptionStart)
                    .moveTo(pointOptionEnd).release()
                    .perform();
            LOGGER.logTestStep(extentTest, "INFO", "swipe completed for direction:"+direction, false, this.driver);
            
        } catch (Exception e) {
        	BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeLeftOrRight for direction"+direction+". "+e.getMessage(), true, this.driver, false);
            return;
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }
    
    public void swipeHorizontalUsingText(String resourceID, String text) {
    	try {
	        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + resourceID
	        		+ "\")).setAsHorizontalList().scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
	        LOGGER.logTestStep(extentTest, "INFO", "swipe horizontal completed for text:"+text, false, this.driver);
    	}catch(Exception e) {
    		BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeHorizontalUsingText for text"+text+". "+e.getMessage(), true, this.driver, false);
    	}

    }
    
    public void swipeElementAndroid(By locator, String dir, By toLocator, int count, String...elementName) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
        final int ANIMATION_TIME = 100; // ms
        final int PRESS_TIME = 100; // ms
        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;
        WebElement el = driver.findElement(locator);
        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {

            case "DOWN": // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                break;
            case "UP": // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
                break;
            case "LEFT": // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                break;
            case "RIGHT": // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }
        // execute swipe using TouchAction
        try {

            for (int i = 0; i < count; i++) {
                boolean isToLocator = driver.findElements(toLocator).size() > 0;
                if (!isToLocator) {
                    System.out.println(i);
                    new TouchAction((PerformsTouchActions) driver).press(pointOptionStart)
                            // a bit more reliable when we add small wait
                            .moveTo(pointOptionEnd)
                            .release().perform();
                    
                    LOGGER.logTestStep(extentTest, "INFO", "swipe element completed for direction:"+dir, false, this.driver);
                   
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        	BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in swipeElementAndroid for direction"+dir+". "+e.getMessage(), true, this.driver, false);
            return;
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {

        }
    }
    
    public String getAttribute(By locator, String attribute, String elementName) {
    	String elmText = null;
        try {
	    	WebElement elm = waitForVisible(locator);
	        elmText = elm.getAttribute(attribute);
	        LOGGER.logTestStep(extentTest, "INFO", "Getting attribute:"+attribute+" value of element:"+elementName+" is :"+elmText, false, this.driver);
	        return elmText;
        }catch(Exception e) {
        	BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in getAttribute for element"+elementName+". "+e.getMessage(), true, this.driver, false);            
        }
        return elmText;
    }
    
    public void setImplicitWaitMinimum() {
    	BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void setImplicitWaitMinimum(int timeInSec) {
    	BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
    }
    public void setImplicitNormal() {
    	BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getInstance().getOBJWAITTIME()), TimeUnit.SECONDS);
    }
    
    public void dismissUpdateWindow() {
    	if(TestConfig.getInstance().getGooglePlayUpdateNotification().equalsIgnoreCase("true")) {
	    	setImplicitWaitMinimum();
	    	int updatesNotificationCnt = BaseTest.mobileDriver.get().findElements(By.xpath("//android.widget.ImageView[@content-desc='Dismiss update dialogue']")).size();
	    	if(updatesNotificationCnt>0) {
	    		click(By.xpath("//android.widget.ImageView[contains(@content-desc,'Dismiss update dialog')]"), " to dismiss Google Play Update");
	    	}else {
	    		System.out.println("seems not present Good Update Dialogue");
	    	}
	    	setImplicitNormal();
    	}
    }
    
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction((PerformsTouchActions) BaseTest.mobileDriver.get())
            .press(point(anchor, startPoint))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(anchor, endPoint))
            .release().perform();
    }
    public void swipeToBotton()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.80);
		int bottom_y = (int)(height*0.20);
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		TouchAction ts = new TouchAction((PerformsTouchActions) driver);
		ts.press(PointOption.point(x, top_y))
		  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		  .moveTo(PointOption.point(top_y, bottom_y)).release().perform();
	}
}
