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
        
    	try{
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_026 - Verify new user is able to see only Feed, People & Topics without selecting anything in onboarding ------><b>", false, BaseTest.mobileDriver.get());
			LoginKooPage loginKooPage = new LoginKooPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
    	    loginKooPage.loginValidUser("English",TestConfig.getInstance().getUserName());//new user with no selection during OnBoarding
    	    
            homeScreenTabPage.verifyRedDotIndicator();
            String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabs").split(",");
            List<String> expectedTabsTextList = new ArrayList<String>();
            for (int i = 0; i < array.length; i++) {
                expectedTabsTextList.add(array[i]);
            }
            homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_026 - Verify new user is able to see only Feed, People & Topics without selecting anything in onboarding ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_026_verifyNewUserHomeTabs_WithNoSelection_DuringOnBoarding. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }

}
