package com.koo.OnBoardingFlowTests;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.allpages.*;

public class OnBoardingFlowTest extends BaseTest {
	
	@Test(description = "[TC_012] - Verify user gets username update & profile image update screens.",
            groups = {"regression", "HomeScreen"})
    public void TC_012_verifyNewUserNameUpdate_ProfileImageUpdate_DuringOnBoarding() throws Exception {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String profileName = "autonewuser"+RandomStringUtils.randomAlphabetic(10);
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_012 - Verify user gets username update & profile image update screens. ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC012());
    	    			
			BaseTest.utilObj.get().getMobileActions().sendKeys(onBoardingFlowPage.userName_Field, onBoardingFlowPage.userName_Field_Name, profileName);
			String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
			
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
			String addProfilePictureHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.addProfilePictureHeaderText, onBoardingFlowPage.addProfilePictureHeaderText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addProfilePictureHeaderText.trim(), "Add Profile Picture", "Validation of header text and  expected is Add Profile Picture", true, BaseTest.mobileDriver.get(), false);
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
			boolean isDisplayed = false;
			for(int i=2; i<=4; i++) {
				isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
						
				}
				
			}
			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
            String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabsNoOnBoardingSelection").split(",");
            List<String> expectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                expectedTabsTextList.add(array[i]);
            }
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
            String[] array2 = LanguageDataProvider.getLanguageDataValue("HomePageTabsNotPresentWhenNoOnBoardingSelection").split(",");
            List<String> notExpectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array2.length; i++) {
            	notExpectedTabsTextList.add(array2[i]);
            }
            
            homeScreenTabPage.verifyHeaderTabsNotPresent(notExpectedTabsTextList);
            
                        
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_012 - VTC_012 - Verify user gets username update & profile image update screens. ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_012_verifyNewUserNameUpdate_ProfileImageUpdate_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_013,TC_018] - Verify username update only for new accounts or re-login account without handles and  Interest Selection, People Follow & Topics Follow screen shows only once per registration for an account",
            groups = {"regression", "HomeScreen"})
    public void TC_013_018_verifyNewUserNameUpdate_NewLoginOrRelogin_DuringOnBoarding() {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String profileName = "autonewuser"+RandomStringUtils.randomAlphabetic(10);
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_013_018 - Verify username update only for new accounts or re-login account without handles and  Interest Selection, People Follow & Topics Follow screen shows only once per registration for an account ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC013_018());
						
			boolean isDisplayed = false;
			for(int i=1; i<=4; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
						
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}else {
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Continue button nor present as expected", true, BaseTest.mobileDriver.get(), true);
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
											
						continue;
					}else {
						break;
					}
				}
				
			}
			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
            String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabsNoOnBoardingSelection").split(",");
            List<String> expectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                expectedTabsTextList.add(array[i]);
            }
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
            String[] array2 = LanguageDataProvider.getLanguageDataValue("HomePageTabsNotPresentWhenNoOnBoardingSelection").split(",");
            List<String> notExpectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array2.length; i++) {
            	notExpectedTabsTextList.add(array2[i]);
            }
            
            homeScreenTabPage.verifyHeaderTabsNotPresent(notExpectedTabsTextList);
            
            loginKooPage.logout("English");
            loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC013_018());
            
            BaseTest.utilObj.get().getMobileActions().sendKeys(onBoardingFlowPage.userName_Field, onBoardingFlowPage.userName_Field_Name, profileName);
			String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
			
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
			String addProfilePictureHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.addProfilePictureHeaderText, onBoardingFlowPage.addProfilePictureHeaderText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addProfilePictureHeaderText.trim(), "Add Profile Picture", "Validation of header text and  expected is Add Profile Picture", true, BaseTest.mobileDriver.get(), false);
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);		
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
            homeScreenTabPage.verifyHeaderTabsNotPresent(notExpectedTabsTextList);
                        
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_013_018 - Verify username update only for new accounts or re-login account without handles and  Interest Selection, People Follow & Topics Follow screen shows only once per registration for an account ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_013_018_verifyNewUserNameUpdate_NewLoginOrRelogin_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_014] - Verify profile image update screen for new login or re-login account wihtou profile image",
            groups = {"regression", "HomeScreen"})
    public void TC_014_verify_ProfileImageUpdate_NewLogin_Relogin_DuringOnBoarding() throws Exception {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String profileName = "autonewuser"+RandomStringUtils.randomAlphabetic(10);
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_014 - Verify profile image update screen for new login or re-login account wihtou profile image ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC014());
			
			//BaseTest.utilObj.get().getMobileActions().sendKeys(onBoardingFlowPage.userName_Field, onBoardingFlowPage.userName_Field_Name, profileName);
			String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
			
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
			String addProfilePictureHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.addProfilePictureHeaderText, onBoardingFlowPage.addProfilePictureHeaderText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addProfilePictureHeaderText.trim(), "Add Profile Picture", "Validation of header text and  expected is Add Profile Picture", true, BaseTest.mobileDriver.get(), false);
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
			boolean isDisplayed = false;
			for(int i=2; i<=4; i++) {
				isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
						
				}
				
			}
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
            String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabsNoOnBoardingSelection").split(",");
            List<String> expectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                expectedTabsTextList.add(array[i]);
            }
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
            String[] array2 = LanguageDataProvider.getLanguageDataValue("HomePageTabsNotPresentWhenNoOnBoardingSelection").split(",");
            List<String> notExpectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array2.length; i++) {
            	notExpectedTabsTextList.add(array2[i]);
            }
            
            homeScreenTabPage.verifyHeaderTabsNotPresent(notExpectedTabsTextList);
            
            loginKooPage.logout("English");
            loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC014());
            
            addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
			
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			
            addProfilePictureHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.addProfilePictureHeaderText, onBoardingFlowPage.addProfilePictureHeaderText_Name, true);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(addProfilePictureHeaderText.trim(), "Add Profile Picture", "Validation of header text and  expected is Add Profile Picture", true, BaseTest.mobileDriver.get(), false);
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
            homeScreenTabPage.verifyHeaderTabsNotPresent(notExpectedTabsTextList);          
                        
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_014 - Verify profile image update screen for new login or re-login account wihtou profile image ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_014_verify_ProfileImageUpdate_NewLogin_Relogin_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_015,TC_019,TC_020] - Verify interest (preference) selection screen & user is able to select/deselect options.",
            groups = {"regression", "HomeScreen"})
    public void TC_015_019_020_verifyNewUser_Interest_SelectDeselect_DuringOnBoarding() {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String firstTopicInterest = null;
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_015 - Verify interest (preference) selection screen & user is able to select/deselect options. ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC015());
    	    
			//loginKooPage.loginEmailTillClickingVerifyButton("English", "sunil.bgp+69@gmail.com");
			
			boolean isDisplayed = false;
			for(int i=1; i<=4; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
						
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
							firstTopicInterest = onBoardingFlowPage.ValidateSelectFirstInterestTopicName();
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
											
						continue;
					}else {
						break;
					}
				}
				
			}
			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
			homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("TopicsTabTextOnHomePage"));
						
			onBoardingFlowPage.selectedFirstTopicYouFollowValidationNewUser_InterestSelection(firstTopicInterest);
			
			homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("FeedTabText"));
			BaseTest.utilObj.get().getUIUtils().waitForSec(6);
			BaseTest.utilObj.get().getMobileActions().swipeToBotton();
			onBoardingFlowPage.selectedFirstTopicYouFollowValidationNewUser_InterestSelection_FeedPage(firstTopicInterest);
			//onBoardingFlowPage.selectedFirstTopic_InterestSelection_FeedPage_KooValidation_OnBoarding(firstTopicInterest);
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_015_019_020 - Verify interest (preference) selection screen & user is able to select/deselect options. ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_015_019_020_verifyNewUser_Interest_SelectDeselect_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_016,TC_020] - Verify follow people screen & user is able to follow / unfollow users.",
            groups = {"regression", "HomeScreen"})
    public void TC_016_020_verifyNewUser_FollowUnfollowUser_DuringOnBoarding() {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String firstPeopleFollowedName = null;
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_016 - Verify follow people screen & user is able to follow / unfollow users. ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC016());
    	   
			boolean isDisplayed = false;
			for(int i=1; i<=4; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
						
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
							
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
							firstPeopleFollowedName = onBoardingFlowPage.ValidatePeopleFollow();
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
											
						continue;
					}else {
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Skip/Continue button not present. Please investigate for new user", true, BaseTest.mobileDriver.get(), true);
					}
				}
				
			}
			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
			//onBoardingFlowPage.dismissJackportDisplay();
			BaseTest.utilObj.get().getMobileActions().swipeToBotton();
			onBoardingFlowPage.ValidatePeopleFollowInFeedTab(firstPeopleFollowedName);			
           	
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_016 - Verify follow people screen & user is able to follow / unfollow users. ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_016_verifyNewUser_FollowUnfollowUser_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_017] - Verify follow topics screen & user is able to follow / unfollow topics.",
            groups = {"regression", "HomeScreen"})
    public void TC_017_verifyNewUser_FollowUnfollowTopics_DuringOnBoarding() {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String firstTopicFollowedName = null;
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_017 - Verify follow topics screen & user is able to follow / unfollow topics. ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC017());
    	   
			boolean isDisplayed = false;
			for(int i=1; i<=4; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						String addYourNameHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.headerText, onBoardingFlowPage.headerText_Name, true);
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(addYourNameHeaderText.trim(), "Add your name", "Validation of header text and  expected is Add your name", true, BaseTest.mobileDriver.get(), false);
						
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						if(i==2) {
							String yourPreferencesHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.yourPreferencesPageHeaderText, onBoardingFlowPage.yourPreferencesPageHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(yourPreferencesHeaderText.trim(), "Your Preferences", "Validation of header text and expected is Your Preferences", true, BaseTest.mobileDriver.get(), false);
							
						}
						if(i==3) {
							String peopleYouCanFollowHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.peopleYouCanFollowHeaderText, onBoardingFlowPage.peopleYouCanFollowHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(peopleYouCanFollowHeaderText.trim(), "People you can follow", "Validation of header text and expected is People you can follow", true, BaseTest.mobileDriver.get(), false);
							
						}
						if(i==4) {
							String followTopicsHeaderText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
							BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTopicsHeaderText.trim(), "Follow Topics", "Validation of header text and expected is Follow Topics", true, BaseTest.mobileDriver.get(), false);
							firstTopicFollowedName = onBoardingFlowPage.ClickTopicFollow();
						}
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
											
						continue;
					}else {
						BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Skip/Continue button not present. Please investigate for new user", true, BaseTest.mobileDriver.get(), true);
					}
				}
				
			}
			
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
			//onBoardingFlowPage.dismissJackportDisplay();
			//BaseTest.utilObj.get().getMobileActions().swiptToBottom();
			homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("TopicsTabTextOnHomePage"));
			onBoardingFlowPage.ValidateTopicFollowInTopicTab(firstTopicFollowedName);
			
           	
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_017 - Verify follow topics screen & user is able to follow / unfollow topics. ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_017_verifyNewUser_FollowUnfollowTopics_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	
	@Test(description = "Test Debug",
            groups = {"regression", "HomeScreen"})
    public void TC_debug() {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		//Test Data setup
    		
    		String firstPeopleFollowedName = null;
    		
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_016 - Verify follow people screen & user is able to follow / unfollow users. ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English","1119100132");
			//By firstPeopleFollowNameObj = By.xpath("//*[@id='com.koo.app:id/channel_name_textview' and text()='Piramal Capital & Housing Finance Limited']");
			
			onBoardingFlowPage.dismissJackportDisplay();
			
			//By firstPeopleFollowNameObj = By.xpath("//channel_name_textview[text()='Piramal Capital & Housing Finance Limited']");
			
			By firstPeopleFollowNameObj = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/koo_feed_item_container']/android.view.ViewGroup[@resource-id='com.koo.app:id/layout_profile']/android.widget.TextView");
			By firstObj=By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/creation_view']");
			//BaseTest.utilObj.get().getMobileActions().swipeElementAndroid(firstObj,"DOWN",firstPeopleFollowNameObj,5);
			BaseTest.utilObj.get().getMobileActions().swipeToBotton();
			BaseTest.utilObj.get().getMobileActions().getText(firstPeopleFollowNameObj,"first People Followed Name in Feed page", true);
           	
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_016 - Verify follow people screen & user is able to follow / unfollow users. ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_016_verifyNewUser_FollowUnfollowUser_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_039, TC_040] Verify keyboard should auto open & cursor should be in enter name text filed & user is able to type username.",
            groups = {"regression", "onboarding_flow"})
    public void verifyKeyboardAutoOpenForUpdateNameField(String language) {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        //loginKooPage.loginValidUser(language, "needtoaddnewuser");
        CommonHelper.enterValueFromKeyboard(RandomStringUtils.randomAlphabetic(40));
    }
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_12, TC_13] Verify user gets username update & profile image update screens. Verify username update only for new accounts or relogin account without handles.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleViewEditUserNamePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToViewUserNamePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_12,TC_14] Verify user gets username update & profile image update screens.  Verify profile image update screen for new login or relogin account wihtou profile image", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleViewEditProfileImagePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToviewProfileImagePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_15] Verify interest (preference) selection screen & user is able to select/deselect options.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewPrefrencesPage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser2"));
		onboardPage.verifyUserAbleToViewAddPreferencesPage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_16] Verify follow people screen & user is able to follow / unfollow users.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewFollowPeoplePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser3"));
		Thread.sleep(20000);
		onboardPage.verifyUserAbleToViewFollowPeoplePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_17] Verify follow topics screen & user is able to follow / unfollow topics.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewFollowTopicsPage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser4"));
		Thread.sleep(20000);
		onboardPage.verifyUserAbleToViewFollowTopicsPage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_17] Verify follow topics screen & user is able to follow / unfollow topics.", groups = {
			"regression", "onboarding_flow" })
	public void verifyNewUserAbleToGetAllPages(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToViewUserNamePage();
		onboardPage.verifyNewUserAbleToviewProfileImagePage();
//		onboardPage.verifyUserAbleToViewAddPreferencesPage();
//		onboardPage.verifyUserAbleToViewFollowPeoplePage();
//		onboardPage.verifyUserAbleToViewFollowTopicsPage();
	}

}
