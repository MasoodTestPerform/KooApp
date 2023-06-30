package com.koo.registrationAndLoginFlowTests;

import com.framework.android.allpages.LanguagesSelectionPage;
import org.testng.annotations.Test;
import com.koo.framework.BaseTest;

public class LanguageSelectionTest extends BaseTest{

	 @Test(description = "[TC_003] Verify user is able to see different languages to see on screen, immediately on opening the app",
	            groups = {"regression", "registration_and_login"})
	    public void TC_003_verifyDifferentLanguages(){
	    	BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_006 - Verify user is able to login with phone number ------><b>", false, BaseTest.mobileDriver.get());
	    	try {
		        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
		        BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Going to start verification for Languages", false, BaseTest.mobileDriver.get());
		        languagesSelectionPage.verifyAvailableLanguages();
		       
		        BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_003 - Verify user is able to see different languages to see on screen, immediately on opening the app ------><b>", true, BaseTest.mobileDriver.get());
	    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	    	    BaseTest.sAssert.get().assertAll();
	    	}catch(Exception e) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyDifferentLanguages. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
				BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
				BaseTest.sAssert.get().assertAll();
			}
	    }
}