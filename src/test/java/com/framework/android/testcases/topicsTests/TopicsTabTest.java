package com.framework.android.testcases.topicsTests;

import org.testng.annotations.Test;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.screens.topicsPage.*;

public class TopicsTabTest extends BaseTest {
	 @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_134] Verify topics tab should be in 3rd/4th position in home screen tabs for English & Hindi users only.",
	            groups = {"regression", "topicsTab_home"})
	    public void TC_134_verifyTopicsTabPositionOnHomePage(String language) {
		 BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_134 - Verify Topics Tab Position On Home Page ------><b>", false, BaseTest.mobileDriver.get());
		 try{
	        if ((language.equalsIgnoreCase("English")) || (language.equalsIgnoreCase("Hindi"))) {
	            LanguageDataProvider.setCurrentLanguage(language);
	            LoginKooPage loginKooPage = new LoginKooPage();
	            TopicsTabPage topicsTabPage = new TopicsTabPage();
	            loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
	            topicsTabPage.verifyTopicTabOnThirdOrFourthPosition(LanguageDataProvider.getLanguageDataValue("TopicsTabTextOnHomePage"),
	                    2);
	        }
	        BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_134 - Verify verify Topics Tab Position On Home Page ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		 }catch(Exception e) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_134 - Verify Topics Tab Position On Home Page. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
				BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			}
	    }
}
