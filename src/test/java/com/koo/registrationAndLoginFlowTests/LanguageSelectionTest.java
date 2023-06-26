package com.koo.registrationAndLoginFlowTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.allpages.LanguagesSelectionPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.koo.framework.BaseTest;

import java.io.IOException;

public class LanguageSelectionTest extends BaseTest{

    @Test(description = "[TC_004, TC_008, TC_009] Verify user should able to see Language selection screen with below options:" +
            "Available Languages: English, Kannada, Hindi, Tamil, Marathi,Telugu, Bengla, Gujarati, Assamees, Punjabi & Hausa.",
            groups = {"regression", "registration_and_login"})
    public void verifyAvailableLanguagesInEnglish(){
    	try {
	        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
	        languagesSelectionPage.verifyAvailableLanguagesInEnglishLanguage();
	        BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyAvailableLanguagesInEnglish. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
    }

    @Test(description = "[TC_004, TC_008] Verify user should able to see Language selection screen with below options:" +
            "Available Languages: English, Kannada, Hindi, Tamil, Marathi,Telugu, Bengla, Gujarati, Assamees, Punjabi & Hausa.",
            groups = {"regression", "registration_and_login"})
    public void verifyAvailableLanguagesInSameLanguage() {
    	try {
	        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
	        languagesSelectionPage.verifyAllAvailableLanguagesInSameLanguage();
	        BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyAvailableLanguagesInSameLanguage. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
    }

    @Test(description = "[TC_005] Verify check box on available language & only selected language should be checked in the box.",
            groups = {"regression","registration_and_login"})
    public void verifyCheckBoxesForAvailableLanguages(){
    	try {
	        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
	        languagesSelectionPage.verifyCheckBoxesForAvailableLanguages();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyCheckBoxesForAvailableLanguages. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get(), true);
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	}
    }

    @Test(description = "[TC_006, TC_026] Verify on selecting Hindi language, user should get rewards banner screen with continue tapping " +
            "should land on login OR should auto disappear after 5 seconds.",
            groups = {"regression", "registration_and_login"})
    public void verifyRewardBannerForHindiAndVerifyLoginPageHeading() {
    	try {
	        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
	        languagesSelectionPage.verifySelectedLanguageDisplayingAndRewardBanner();
	        BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyRewardBannerForHindiAndVerifyLoginPageHeading. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get(), true);
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	}
    }
}