package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class LogoutAndDeletePage {

	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	SettingsPage settingsPage = new SettingsPage();
	UIUtils utilsPage = new UIUtils();

	public By existsPopup = By.id("android:id/message");
	public By existsPopupOkButton = By.id("android:id/button1");
	public By childAccountName_Text = By.xpath(
			"//android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview']");
	public By expandProfileArrowButton = By.id("com.koo.app:id/expand_profiles");
	public By parentAccountName_Text = By.xpath(
			"//android.widget.LinearLayout/android.widget.TextView[1][@resource-id='com.koo.app:id/channel_name_textview']");
	// public By forSwitchAccount = By.id("com.koo.app:id/channel_imageview");
	public By forSwitchAccount = By.xpath(
			"//android.widget.FrameLayout/android.widget.ImageView[@resource-id='com.koo.app:id/channel_imageview']");

	public String existsPopup_Name = "PopUp message while adding child account";
	public String existsPopupOkButton_Name = "Ok button of PopUp";
	public String childAccountName_Text_Name = "Child Account Name";
	public String expandProfileArrowButton_Name = "Down arrow button to expand to view profiles";
	public String parentAccountName_Text_Name = "Parent Account Name";
	public String forSwitchAccount_Name = "to switch the account from existing";

	public LogoutAndDeletePage verifyPopupAlreadyExistsAccount() {

		return this;
	}

	public LogoutAndDeletePage verifySwitchAccountFromChildAccount() throws Exception {
		mobileActions.waitForVisible(childAccountName_Text);
		mobileActions.getText(childAccountName_Text, childAccountName_Text_Name, true).trim();
		Assert.assertTrue(mobileActions.isDisplayed(childAccountName_Text, childAccountName_Text_Name));
		mobileActions.isDisplayed(expandProfileArrowButton, expandProfileArrowButton_Name);
		mobileActions.click(expandProfileArrowButton, expandProfileArrowButton_Name);
		mobileActions.waitForVisible(parentAccountName_Text);
		mobileActions.getText(parentAccountName_Text, parentAccountName_Text_Name, true);
		mobileActions.click(parentAccountName_Text, parentAccountName_Text_Name);
		// utilsPage.getPageTitle(BaseTest.mobileDriver.get());

		return this;
	}

	/*
	 * public void verifyHashTags() { mobileActions.waitForVisible(hashTagResults);
	 * mobileActions.getText(hashTagResults, hashTagResults_Name, true);
	 * Assert.assertTrue(mobileActions.isDisplayed(hashTagResults,
	 * hashTagResults_Name)); }
	 */

	public LogoutAndDeletePage verifyDeleteOptionInChildAccount() {
		/*
		 * mobileActions.isDisplayed(settingsPage.delete_Settings,
		 * settingsPage.delete_Settings_Name);
		 * mobileActions.click(settingsPage.accountInformationBackButtonText,
		 * settingsPage.accountInformationBackButtonText_Name);
		 * BaseTest.LOGGER.get().logError(settingsPage.delete_Settings_Name +
		 * " Not Present"); BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
		 * settingsPage.delete_Settings_Name + " Not Present", true,
		 * BaseTest.mobileDriver.get(), true);
		 */
		boolean isDelete = mobileActions.isElmPresent(settingsPage.delete_Settings);
		if (isDelete) {
			System.out.println("Delete option is not Present in Child Account");
		} else {
			mobileActions.click(settingsPage.accountInformationBackButtonText,
					settingsPage.accountInformationBackButtonText_Name);
		}
		return this;
	}

}
