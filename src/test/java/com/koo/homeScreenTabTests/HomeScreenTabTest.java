package com.koo.homeScreenTabTests;

import java.util.List;

import org.testng.annotations.Test;

import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.allpages.*;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import java.util.ArrayList;

public class HomeScreenTabTest extends BaseTest {
	
	@Test(description = "[TC_026] - Verify new user is able to see only Feed, People & Topics without selecting anything in onboarding",
            groups = {"regression", "HomeScreen"})
    public void TC_026_verifyNewUserHomeTabs_WithNoSelection_DuringOnBoarding() throws Exception {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_026 - Verify new user is able to see only Feed, People & Topics without selecting anything in onboarding ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC026());
			
			boolean isDisplayed = false;
			for(int i=1; i<=4; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
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
            
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_026 - Verify new user is able to see only Feed, People & Topics without selecting anything in onboarding ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_026_verifyNewUserHomeTabs_WithNoSelection_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
	
	@Test(description = "[TC_027] - Verify user is able to see all tabs on following a topic or a profile in onborading or after landing on feed",
            groups = {"regression", "HomeScreen"})
    public void TC_027_verifyNewUserHomeTabs_WithTopicSelection_DuringOnBoarding() throws Exception {
		LanguageDataProvider.setCurrentLanguage("English");
    	try{
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_027 - Verify user is able to see all tabs on following a topic or a profile in onborading or after landing on feed ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			HomePage homePage = new HomePage();
			loginKooPage.EnterLoginDetails_NewUser("English",TestConfig.getInstance().getNewUserOnBoarding_TC027());
			
			boolean isDisplayed = false;
			for(int i=1; i<=3; i++) {
				if(i==1) {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.continueButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
					}
				}else {
					isDisplayed = BaseTest.utilObj.get().getMobileActions().isElementDisplayed(onBoardingFlowPage.skipButton);
					if(isDisplayed == true) {
						BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
						BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, onBoardingFlowPage.skipButton_Name);
						BaseTest.utilObj.get().getUIUtils().waitForSec(4);	
											
						continue;
					}else {
						break;
					}
				}
				
			}
			
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Going to select a topic", true, BaseTest.mobileDriver.get());
			String followTopicsText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsHeaderText, onBoardingFlowPage.followTopicsHeaderText_Name, true);
			String followTopicsFirstTopCategoryText = null;
			if(followTopicsText.trim().equalsIgnoreCase("Follow Topics")) {
				followTopicsFirstTopCategoryText = BaseTest.utilObj.get().getMobileActions().getText(onBoardingFlowPage.followTopicsFirstTopCategory, onBoardingFlowPage.followTopicsFirstTopCategory_Name, true);
				BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Follow Topics category to be selected as "+followTopicsFirstTopCategoryText, false, BaseTest.mobileDriver.get());
				BaseTest.utilObj.get().getMobileActions().tapElement(onBoardingFlowPage.followTopicsFirstTopCategoryPlusSign, onBoardingFlowPage.followTopicsFirstTopCategoryPlusSign_Name + ":" + followTopicsFirstTopCategoryText);
			}else {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Follow Topics page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Screenshot for reference", true, BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getMobileActions().click(onBoardingFlowPage.skipButton, "Continue button");
			
			BaseTest.utilObj.get().getMobileActions().dismissUpdateWindow();
			
			isDisplayed =  BaseTest.utilObj.get().getMobileActions().isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
			if(! isDisplayed) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Please investigate as not able to reach Koo home page for further validation", true, BaseTest.mobileDriver.get(), true);
			}
			
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Going to validate all Tabs in Home page", true, BaseTest.mobileDriver.get());
            String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabs").split(",");
            List<String> expectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                expectedTabsTextList.add(array[i]);
            }
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
            
                        
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_027 - Verify user is able to see all tabs on following a topic or a profile in onborading or after landing on feed ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_027_verifyNewUserHomeTabs_WithTopicSelection_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }

}
