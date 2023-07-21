package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class SettingsPage {
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	UserBlockPage userBlockPage = new UserBlockPage();
	HomePage homePage = new HomePage();

	String actualText;
	String expectedText;

	// com.koo.app:id/settings
	public String settingsSectionHeading = ("//android.widget.TextView[@text=\\\"###\\\"]");
	public By continueBtnForBrowserPermission = By.id("com.android.chrome:id/positive_button");
	public By editProfileHeading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By shareKooPopUpHeading = By.id("miui:id/alertTitle");
	public By shareKooPopUp = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
	public By applySelfVerificationPageHeading = By.id("com.koo.app:id/enter_otp_header");
	public By applySelfEminenceAndHelp = By.id("com.android.chrome:id/url_bar");
	public By crossButtonForCloseTab = By.id("com.android.chrome:id/close_button");
	public String migrateFromTwitterPopUpHeading = "//android.widget.TextView[@text='###']";
	public String migrateFromTwitterCloseButton = "//android.widget.TextView[@text='###']";
	public By manageAccountAndNotificationsPageHeading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By logOutPopUpHeading = By.id("com.koo.app:id/status_textview");
	public By cancelButtonOnLogOutPopUp = By.id("com.koo.app:id/tvCancel");
	public String deletePopUPText = "//android.widget.TextView[contains(@text,'###')]";
	public String privacyPolicyAndAboutUsPage = "//android.view.View[@text='###']";
	public String changeInEnglishText = "//android.widget.TextView[@text='###']";
	public String switchButton = "//android.widget.TextView[@text='###']/../..//android.widget.Switch";

	public String settingsSectionHeading_Name = "Heading";
	public String continueBtnForBrowserPermission_Name = "";
	public String editProfileHeading_Name = "";
	public String shareKooPopUpHeading_Name = "";
	public String shareKooPopUp_Name = "";
	public String applySelfVerificationPageHeading_Name = "";
	public String applySelfEminenceAndHelp_Name = "";
	public String crossButtonForCloseTab_Name = "Cross button";
	public String migrateFromTwitterPopUpHeading_Name = "";
	public String migrateFromTwitterCloseButton_Name = "";
	public String manageAccountAndNotificationsPageHeading_Name = "";
	public String logOutPopUpHeading_Name = "";
	public String cancelButtonOnLogOutPopUp_Name = "Cancel button for logout popup";
	public String deletePopUPText_Name = "";
	public String privacyPolicyAndAboutUsPage_Name = "";
	public String changeInEnglishText_Name = "";
	public String switchButton_Name = "";

	/**
	 * This method is to click on Profile button
	 *
	 * @return
	 * @throws Exception
	 */
	public SettingsPage clickOnProfile() throws Exception {
		try {
			mobileActions.waitForVisible(homePage.profile_lnk);
			mobileActions.click(homePage.profile_lnk, homePage.profile_lnk_Name);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(homePage.profile_lnk_Name + " Not Clickable");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, homePage.profile_lnk_Name + " Not Clickable",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify settings button
	 *
	 * @param expectedText
	 */
	public SettingsPage verifySettingsButton() {
		try {
			mobileActions.waitForVisible(userBlockPage.settings);
			mobileActions.isDisplayed(userBlockPage.settings, userBlockPage.settings_Name);
			actualText = mobileActions.getText(userBlockPage.settings, userBlockPage.settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("SettingsButton");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					true, BaseTest.mobileDriver.get(), true);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(userBlockPage.settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					userBlockPage.settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to click on settings button
	 *
	 * @return
	 * @throws IOException
	 */
	public SettingsPage clickSettingsButton() {
		try {
			mobileActions.waitForVisible(userBlockPage.settings);
			mobileActions.click(userBlockPage.settings, userBlockPage.settings_Name);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(userBlockPage.settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					userBlockPage.settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify sections on settings page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyAllOptionsInSettings(String expectedHeading) throws InterruptedException {
		mobileActions.swipeUpFindElement(10, mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
				"settingsSectionHeading", expectedHeading));
		mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
				"settingsSectionHeading", expectedHeading));
		mobileActions
				.isDisplayed(
						mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
								"settingsSectionHeading", expectedHeading),
						"Verify Settings page sections and it's sub heading = " + expectedHeading);
		Assert.assertTrue(
				mobileActions.isDisplayed(
						mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
								"settingsSectionHeading", expectedHeading),
						"Verify Settings page sections and it's sub heading = " + expectedHeading));
		System.out.println("Verify Settings page sections and it's sub heading = " + expectedHeading);
		return this;
	}
}
