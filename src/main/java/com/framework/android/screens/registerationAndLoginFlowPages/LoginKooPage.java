package com.framework.android.screens.registerationAndLoginFlowPages;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import com.framework.android.allpages.*;

public class LoginKooPage {
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
			
	HomePage homePage = new HomePage();

	public void loginValidUser(String language, String userId){
		try {
			
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:"+language, false, BaseTest.mobileDriver.get());
			
			if(language.equalsIgnoreCase("English")) {
				boolean isTextBox = mobileActions.isElmPresent(homePage.MobNo_txt);
				if (isTextBox) {
					System.out.println("Already you on login screen");
				}else {
					mobileActions.swipeUsingText(language);
					//mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
					mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
				}
			}else {
				mobileActions.swipeUsingText(language);
				//mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
				mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
			}
			mobileActions.sendKeys(homePage.MobNo_txt, homePage.MobNo_txt_Name, userId);
			mobileActions.click(homePage.OTP_btn, homePage.OTP_btn_Name);
			mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for test data entered", true, BaseTest.mobileDriver.get());
			mobileActions.objWait(homePage.verify_btn_Name, homePage.verify_btn, TestConfig.getInstance().getOBJWAITTIME(), true);
			mobileActions.tapElement(homePage.verify_btn, homePage.verify_btn_Name);
			mobileActions.dismissUpdateWindow();
			
			mobileActions.setImplicitWaitMinimum();
			boolean isNothanks = mobileActions.isElmPresent(By.id("com.android.vending:id/0_resource_name_obfuscated"));
			if (isNothanks) {
				List<WebElement> lstElm = mobileActions.elements(By.id("com.android.vending:id/0_resource_name_obfuscated"));
				for (WebElement webElement : lstElm) {
					if(webElement.getText().equals("NO, THANKS")||webElement.getText().equals("NO THANKS")) {
						webElement.click();
						break;
					}
				}
				
			}
			mobileActions.dismissUpdateWindow();
			
			boolean objFlag = mobileActions.isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
						
			if (objFlag== false) {
				for(int i=1; i<=3; i++) {
					objFlag = mobileActions.isDisplayed(homePage.otp_text, homePage.otp_text_Name);
					if(objFlag) {
						mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
						mobileActions.waitForVisible(homePage.verify_btn);
						mobileActions.click(homePage.verify_btn, homePage.verify_btn_Name);	
						mobileActions.dismissUpdateWindow();
					}
				}
				objFlag = mobileActions.isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(objFlag,true, "Validation of valid Login for user:"+userId+" in Koo", true, BaseTest.mobileDriver.get(), true);
			}else {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(objFlag,true, "Validation of valid Login for user:"+userId+" in Koo", true, BaseTest.mobileDriver.get(), true);
			}
			mobileActions.setImplicitNormal();
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in loginValidUser. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
	}
	
	public void loginEmailValidUser(String language, String emailId){
		try {
			
			if(language.equalsIgnoreCase("English")) {
				boolean isTextBox = mobileActions.isElmPresent(homePage.MobNo_txt);
				if (isTextBox) {
					System.out.println("Already you on login screen");
				}else {
					mobileActions.swipeUsingText(language);
					mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
				}
			}else {
				mobileActions.swipeUsingText(language);
				mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
			}
			mobileActions.sendKeys(homePage.signIn_Email_Btn, homePage.signIn_Email_Btn_Name, emailId);
			mobileActions.sendKeys(homePage.enter_email, homePage.enter_email_Name, TestConfig.getInstance().getPassword());
			mobileActions.click(homePage.OTP_btn, homePage.OTP_btn_Name);
			mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
			mobileActions.waitForVisible(homePage.verify_btn);
			mobileActions.click(homePage.verify_btn, homePage.verify_btn_Name);
			
			boolean isNothanks = mobileActions.isElmPresent(By.id("com.android.vending:id/0_resource_name_obfuscated"));
			if (isNothanks) {
				List<WebElement> lstElm = mobileActions.elements(By.id("com.android.vending:id/0_resource_name_obfuscated"));
				for (WebElement webElement : lstElm) {
					if(webElement.getText().equals("NO, THANKS")||webElement.getText().equals("NO THANKS")) {
						webElement.click();
						break;
					}
				}
				
			}
			
			boolean objFlag = mobileActions.isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			
			if (objFlag= false) {
				for(int i=1; i<=3; i++) {
					objFlag = mobileActions.isDisplayed(homePage.otp_text, homePage.otp_text_Name);
					if(objFlag) {
						mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
						mobileActions.waitForVisible(homePage.verify_btn);
						mobileActions.click(homePage.verify_btn, homePage.verify_btn_Name);					
					}
				}
				objFlag = mobileActions.isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(objFlag,true, "Validation of valid Login for email:"+emailId+" in Koo", true, BaseTest.mobileDriver.get(), true);
			}else {
				
			}
		}catch(Exception e) {
			
		}
			
		

	}
}
