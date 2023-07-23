package com.framework.android.screens.registerationAndLoginFlowPages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.android.allpages.*;
import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class GoogleEmailPopUpPage {
	private MobileActions mobileActions = null;
	HomePage homePage = null;
	RegistrationFlowPage registrationFlowPage = null;
	UserBlockPage userBlockPage = null;
	SettingsPage settingsPage = null;
	
	public GoogleEmailPopUpPage(){
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.homePage = new HomePage();
		this.registrationFlowPage = new RegistrationFlowPage();
		this.userBlockPage = new UserBlockPage();
		this.settingsPage = new SettingsPage();
	}
	
	

    /**
     * This method is to verify add profile page and registration page
     *
     * @param language
     * @param buttonText
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyAllGmailAccounts(String language, String buttonText) {
    	mobileActions.swipeUpFindElement(2, mobileActions.returnByBasedOnPageNameAndObjectName(homePage.app_Language,"xpath", language));
        mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language", language),
                "Checked " + language + " language successfully");
        mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(homePage.signInGoogle_button, "xpath", buttonText),
                "clicked " + buttonText + " button successfully for language = " + language);
        
        mobileActions.waitForSec(4);
        // Registered email popup is ot showing on browser stack        
    	boolean isDisplyingFlag = mobileActions.isDisplayed(homePage.chooseAccount_button, homePage.chooseAccount_button_Name);
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplyingFlag,true, "Verify Choose Account popup is displaying", true, BaseTest.mobileDriver.get(), true);
        mobileActions.click(homePage.select_account, "Select google account");
        isDisplyingFlag = mobileActions.isDisplayed(homePage.profile_registration, "User Registration Or Add Profile image page for language = " + language);
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplyingFlag,true, "Verify User Registration Or Add Profile image page is displaying for language = " + language, true, BaseTest.mobileDriver.get(), true);       
    }

    /**
     * This method is to click on add account button
     *
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage clickOnAddAccount(){
        mobileActions.waitForVisible(registrationFlowPage.addAccount);
        mobileActions.click(registrationFlowPage.addAccount, registrationFlowPage.addAccount_Name);
        return this;
    }

    /**
     * This method is to verify choose account popup should not display while addig multi child account
     * @param expectedSize
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyRegistrationPopUpNotDisplayForMultiChildAccount(int expectedSize) {
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        clickOnAddAccount();

        List<WebElement> actualSizeOfChooseAccountElements = BaseTest.mobileDriver.get().findElements(homePage.chooseAccount_button);
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualSizeOfChooseAccountElements.size(),expectedSize, "Verify Choose Account popup is not displaying on add account page", true, BaseTest.mobileDriver.get(), true);
        return this;
    }

    /**
     * This method is to verify child account added successfully
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyChildAccountAdded() {
        mobileActions.waitForVisible(registrationFlowPage.expandProfile);
        mobileActions.click(registrationFlowPage.expandProfile, registrationFlowPage.expandProfile_Name);
        boolean isDisplayedFlag = mobileActions.isDisplayed(registrationFlowPage.addAccountLink, registrationFlowPage.addAccountLink_Name);
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayedFlag, true, "Verify Add Account link displaying", true, BaseTest.mobileDriver.get(), true);
        return this;
    }

    /**
     * Verify child account got logged out successfully
     * @param expectedHeading
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyChildUserLoggedOut(String expectedHeading) {
        mobileActions.waitForVisible(registrationFlowPage.expandProfile);
        mobileActions.click(registrationFlowPage.expandProfile, registrationFlowPage.expandProfile_Name);
        mobileActions.click(registrationFlowPage.settingsIcon, registrationFlowPage.settingsIcon_Name);
        mobileActions.waitForVisible(userBlockPage.logOutUser);
        mobileActions.click(userBlockPage.logOutUser, userBlockPage.logOutUser_Name);
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(settingsPage.settingsSectionHeading_Name, "xpath", expectedHeading));
        boolean isDisplayedFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(settingsPage.settingsSectionHeading_Name, "xpath", expectedHeading),
                "Verify Settings page sections and it's sub heading = " + expectedHeading);
        
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayedFlag, true, "Verify Settings page sections and it's sub heading = " + expectedHeading, true, BaseTest.mobileDriver.get(), true);
        
        return this;
    }

    /**
     * This method is to login child user from add account
     * @param mobileNumber
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public GoogleEmailPopUpPage loginChildUser(String mobileNumber) {
        mobileActions.waitForVisible(homePage.MobNo_txt);
        mobileActions.sendKeys(homePage.MobNo_txt, homePage.MobNo_txt_Name, mobileNumber);
        mobileActions.waitForSec(9);
        mobileActions.sendKeys(homePage.otp_text, homePage.otp_text_Name, TestConfig.getInstance().getPassword());
        mobileActions.waitForSec(5);
        mobileActions.click(homePage.verify_btn, homePage.verify_btn_Name);
        return this;
    }

}
