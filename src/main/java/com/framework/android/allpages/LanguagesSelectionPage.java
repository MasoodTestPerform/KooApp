package com.framework.android.allpages;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import com.koo.android.utils.MobileActions;
import com.koo.android.utils.TextView;
import com.koo.framework.BaseTest;

public class LanguagesSelectionPage {   
    
    /**
     * THis method is for verification of all available languages
     *
     * @throws FilloException
     */
    public void verifyAvailableLanguagesInEnglishLanguage() {
    	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
    	HomePage homePage = new HomePage();
        // Verify Select Languages heading
        boolean selectLanguagae  = mobileActions.isDisplayed(homePage.select_languages, homePage.select_languages_Name);

        // Verify Available Languages heading
        boolean availableLanguagae  = mobileActions.isDisplayed(homePage.available_languages, homePage.available_languages_Name);

        LinkedHashMap<String, String> availableLanguages = BaseTest.availableLanguages;

        // Verify all available languages in english language keyword
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
           boolean backButtonSize = BaseTest.mobileDriver.get().findElements(homePage.backButton_LanguageChange).size() > 0;
            BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Get size of back button and size is = "+backButtonSize, false, BaseTest.mobileDriver.get());
            if (backButtonSize) {
                mobileActions.click(homePage.backButton_LanguageChange, homePage.backButton_LanguageChange_Name);
            }
            mobileActions.swipeUsingText(entry.getKey());
            boolean languageFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.englishTyped_language,"xpath", entry.getKey()), entry.getKey());
            BaseTest.utilObj.get().getAssertManager().sAssertEquals(languageFlag, true, "Verification of available language which is displaying in english language = " + entry.getKey(), true, BaseTest.mobileDriver.get());            
        }
    }

    public void verifyAllAvailableLanguagesInSameLanguage() {
    	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
    	HomePage homePage = new HomePage();
        LinkedHashMap<String, String> availableLanguages = BaseTest.availableLanguages;

        // Verify all available languages in english typed keyword
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
        	BaseTest.utilObj.get().getMobileActions().waitForSec(15);
            boolean backButtonSize = BaseTest.mobileDriver.get().findElements(homePage.backButton_LanguageChange).size() > 0;
            BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Get size of back button and size is = "+backButtonSize, false, BaseTest.mobileDriver.get());
            if (backButtonSize) {
            	BaseTest.utilObj.get().getMobileActions().waitForSec(2);
                mobileActions.click(homePage.backButton_LanguageChange, homePage.backButton_LanguageChange_Name);
                BaseTest.utilObj.get().getMobileActions().waitForSec(2);
            }
            if (entry.getValue().equalsIgnoreCase("English") && entry.getValue().equalsIgnoreCase("Hausa")) {
                mobileActions.swipeUsingText(entry.getValue());
                BaseTest.utilObj.get().getAssertManager().sAssertEquals(TextView.get(entry.getValue(), 2).isDisplayed(), true,
                        "Verify available language which is displaying in same language typed keyword = " + entry.getValue(), true, BaseTest.mobileDriver.get());
            } else {
                mobileActions.swipeUsingText(entry.getValue());
                BaseTest.utilObj.get().getAssertManager().sAssertEquals(TextView.get(entry.getValue(), 1).isDisplayed(),true,
                        "Verify available language which is displaying in same language typed keyword = " + entry.getValue(), true, BaseTest.mobileDriver.get());
            }
        }
    }
    /**
     * This method is to verify checkboxes for available languages
     *
     * @throws FilloException
     */
    public void verifyCheckBoxesForAvailableLanguages() {
    	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
    	HomePage homePage = new HomePage();
        LinkedHashMap<String, String> availableLanguages = BaseTest.availableLanguages;
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            boolean backButtonSize = BaseTest.mobileDriver.get().findElements(homePage.backButton_LanguageChange).size() > 0;
            BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Get size of back button and size is = "+backButtonSize, false, BaseTest.mobileDriver.get());
            if (backButtonSize) {
                mobileActions.click(homePage.backButton_LanguageChange,homePage.backButton_LanguageChange_Name);
            }
            mobileActions.swipeUsingText(entry.getKey());
            BaseTest.utilObj.get().getAssertManager().sAssertEquals(mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.checkBoxes_language,"xpath",entry.getKey()),entry.getKey()),
                    true,"Verify checkboxes for available language = " + entry.getKey(), true, BaseTest.mobileDriver.get());
        }
    }

    /**
     * This method is to click on checkbox
     *
     * @param language
     * @throws IOException
     */
    public void clickCheckBox(String language){
    	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
    	HomePage homePage = new HomePage();
        mobileActions.swipeUsingText(language);
        try{
            mobileActions.clickExceptionIgnored((mobileActions.returnByBasedOnPageNameAndObjectName(homePage.checkBoxes_language, "xpath",language)),
                    "Language checked successfully = " + language);
        } catch (Exception e){
            mobileActions.click(homePage.backButton_LanguageChange,homePage.backButton_LanguageChange_Name);
            mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.checkBoxes_language,"xpath",language),
                    "Language checked successfully = " + language);
        }
    }

    /**
     * This method is to verify selected language is displaying on login page or not
     *
     * @throws FilloException
     * @throws IOException
     */
    public void verifySelectedLanguageDisplayingAndRewardBanner() {
    	
    		MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
    		HomePage homePage = new HomePage();
	        LinkedHashMap<String, String> availableLanguages = BaseTest.availableLanguagesHeading;
	
	        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
	            // Verify if language is hindi then reward banner should display
	            if (entry.getKey().equalsIgnoreCase("Hindi")) {
	                clickCheckBox(entry.getKey());
					/*
					 * Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.
					 * returnByBasedOnPageNameAndObjectName("HomeScreen", "reward_banner"),
					 * "Verify reward banner is displaying for Hindi language"));
					 */    // mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "reward_banner"));
	               // ReportManager.logPass("Verify reward banner for Hindi language");
	                String actualHeading = mobileActions.getText(homePage.login_heading, homePage.login_heading_Name, true);
	                String expectedHeading = entry.getValue();
	                BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualHeading, expectedHeading,
	                        "Login Page Heading as per the selected language which is = " + entry.getKey(), true, BaseTest.mobileDriver.get());
	                
	                mobileActions.click(homePage.backButton_LanguageChange, homePage.backButton_LanguageChange_Name);
	            } else {
	                // Click on first language and verify login page heading should display in the same selected language
	                clickCheckBox(entry.getKey());
	                String actualHeading = mobileActions.getText(homePage.login_heading, homePage.login_heading_Name, true);
	                String expectedHeading = entry.getValue();
	                BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualHeading, expectedHeading, 
	                        "Login Page Heading as per the selected language which is = " + entry.getKey(), true, BaseTest.mobileDriver.get());
	               
	                // Click on back button
	                mobileActions.click(homePage.backButton_LanguageChange, homePage.backButton_LanguageChange_Name);
	            }
	        }
    	
        
    }
}
