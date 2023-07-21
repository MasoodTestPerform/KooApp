package com.framework.android.screens.registerationAndLoginFlowPages;

import com.koo.android.utils.CommonHelper;
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
	KooCreationPage kooCreationPage = new KooCreationPage();
	UserBlockPage userBlockPage = new UserBlockPage();
	SettingsPage settingsPage = new SettingsPage();

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
	public void EnterLoginDetails_NewUser(String language, String userId){
		try {
			
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:"+language, false, BaseTest.mobileDriver.get());
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to enter login details for new user:"+userId, false, BaseTest.mobileDriver.get());
			
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
			//mobileActions.waitForSec(2);
			mobileActions.sendKeys(homePage.MobNo_txt, homePage.MobNo_txt_Name, userId);
			//mobileActions.waitForSec(4);
			//mobileActions.click(homePage.OTP_btn, homePage.OTP_btn_Name);
			//mobileActions.tapElement(homePage.OTP_btn, homePage.OTP_btn_Name);
			mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for test data entered", true, BaseTest.mobileDriver.get());
			mobileActions.objWait(homePage.verify_btn_Name, homePage.verify_btn, TestConfig.getInstance().getOBJWAITTIME(), true);
			mobileActions.tapElement(homePage.verify_btn, homePage.verify_btn_Name);
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
					mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
				}
			}else {
				mobileActions.swipeUsingText(language);
				mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
			}
			mobileActions.sendKeys(homePage.signIn_Email_Btn, homePage.signIn_Email_Btn_Name, emailId);
			//mobileActions.sendKeys(homePage.enter_email, homePage.enter_email_Name, TestConfig.getInstance().getPassword());
			mobileActions.click(homePage.OTP_btn, homePage.OTP_btn_Name);
			mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
			mobileActions.waitForVisible(homePage.verify_btn);
			mobileActions.tapElement(homePage.verify_btn, homePage.verify_btn_Name);
						
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
	
	public void logout(String language) {
		
		mobileActions.click(kooCreationPage.btn_profile, kooCreationPage.btn_profile_Name);
		mobileActions.click(userBlockPage.threeDots, userBlockPage.threeDots_Name);
		mobileActions.click(userBlockPage.settings, userBlockPage.settings_Name);
		mobileActions.click(userBlockPage.logOutUser, userBlockPage.logOutUser_Name);
		String actualText = mobileActions.getText(settingsPage.logOutPopUpHeading, "Get text of LogOut popup heading", true);
		System.out.println(actualText);
		mobileActions.click(settingsPage.logoutBtn, settingsPage.logoutBtn_Name);
		boolean isDisplayed = mobileActions.isDisplayed(homePage.select_languages, homePage.select_languages_Name);
		
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Validation of Koo logout", true, BaseTest.mobileDriver.get(), true);
		
	}
	
		
	public void loginEmailTillClickingVerifyButton(String language, String emailId){
		
		try {
			
			if(language.equalsIgnoreCase("English")) {
				boolean isTextBox = mobileActions.isElmPresent(homePage.MobNo_txt);
				if (isTextBox) {
					System.out.println("Already you on login screen");
				}else {
					mobileActions.swipeUsingText(language);
					mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
				}
			}else {
				mobileActions.swipeUsingText(language);
				mobileActions.tapElement(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language, "xpath", language), language);
			}
			
			mobileActions.click(homePage.signInEmail_button, homePage.signInEmail_button_Name);
			mobileActions.sendKeys(homePage.enter_email, homePage.enter_email_Name, emailId);
			//mobileActions.sendKeys(homePage.enter_email, homePage.enter_email_Name, TestConfig.getInstance().getPassword());
			
			mobileActions.tapElement(homePage.OTP_Email_btn, homePage.OTP_Email_btn_Name);
			
			mobileActions.waitForVisible(homePage.verify_email_btn);
			mobileActions.tapElement(homePage.verify_email_btn, homePage.verify_email_btn_Name);
			
			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in loginEmailTillClickingVerifyButton. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get(), true);
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
			
		

	}
}
