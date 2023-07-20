package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class Settings_AccountPage {
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	PeopleTabPage peopleTabPage = new PeopleTabPage();
	HomePage homePage = new HomePage();
	CommonHelper commonHelperPage = new CommonHelper();
	UIUtils uiUtilsPage = new UIUtils();
	SoftAssert softAssert = new SoftAssert();
	ProfileScreenPage profileScreenPage = new ProfileScreenPage();
	KooCardPage kooCardPage = new KooCardPage();
	UserBlockPage userBlockPage = new UserBlockPage();
	KooRewardsProgramPage kooRewardsProgramPage = new KooRewardsProgramPage();
	ManageTopicsPage manageTopicsPage = new ManageTopicsPage();
	SettingsPage settingsPage = new SettingsPage();

	String actualText;
	String expectedText;

	// UserBlock
	public By settingsButton = By.id("com.koo.app:id/settings");
	public String settingsButton_Name = "Setting Button";
	public By optionTextinAccountCount12 = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)");
	public By optionTextinAccountCount2 = By
			.xpath("(//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView)");
	public String optionsText_Name = "Account Section Options in Settings";
	public By optionTextInOthers = By.xpath("");
	public String optionsText2_Name = "Others in Options in Settings";
	public By closeButton = By.id("com.android.chrome:id/close_button");
	public String closeButton_Name = "Close button in Web";

	// Edit Profile
	public By editProfile_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/edit_profile_layout']/android.widget.TextView");
	public String editProfile_Settings_Name = "Edit Prfoile Option in Account Section";
	public By editProfilePageHeaderText = By.xpath("(//android.view.View[1]/android.widget.TextView)[1]");
	public String editProfilePageHeaderText_Name = "Edit Profile Page Heading";
	public By editProfileBackButtonText = By.xpath("(//android.view.View/android.widget.ImageView)");
	public String editProfileBackButtonText_Name = "Back Button from Edit Profile";
	// Account Information
	public By accountInformation_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/account_info_layout']/android.widget.TextView");
	public String accountInformation_Settings_Name = "Account Information Option in Account Section";
	public By accounInformationPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String accounInformationPageHeaderText_Name = "Account Information Page Header";
	public By accountInformationBackButtonText = By.id("com.koo.app:id/backArrow");
	public String accountInformationBackButtonText_Name = "Back Button from Account Information";
	// Language
	public By language_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/language_layout']/android.widget.TextView");
	public String language_Settings_Name = "Language Option in Account Section";
	public By languagePageHeaderText = By.xpath("(//android.view.View[1]/android.widget.TextView)[1]");
	public String languagePageHeaderText_Name = "Language Page Header";
	public By availableLanguagesInlanguagePageHeaderText = By
			.xpath("(//android.widget.ScrollView/android.widget.TextView)[1]");
	public String availableLanguagesInlanguagePageHeaderText_Name = "Avalaiable Languages Sub Header in Language Page";
	public By languageCheckBoxText = By.xpath("(//android.view.View/android.widget.CheckBox)");
	public String languageCheckBoxText_Name = "Check Box of Language Selection";
	public By languageNameInLanguagePageText = By.xpath("(//android.view.View/android.widget.TextView)");
	public String languageNameInLanguagePageText_Name = "Language In Language Page";
	// Theme
	public By theme_Settigs = By.xpath("//*[@resource-id='com.koo.app:id/theme_layout']/android.widget.TextView");
	public String theme_Settigs_Name = "Theme Option in Account Section";
	public By themeSwitchActionText = By.id("com.koo.app:id/theme_switch");
	public String themeSwitchActionText_Name = "Switch the mode of Theme";
	// Share your koo profile
	public By shareYourKooProfile_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/invite_layout']/android.widget.TextView");
	public String shareYourKooProfile_Settings_Name = "Share your Koo profile Option in Account Section";
	public By shareYourKooProfilePopUpText = By.id("android:id/text1");
	public String shareYourKooProfilePopUpText_Name = "Share Your Koo Profile Pop-Up Text";
	// Manage Subcriptions
	public By manageSubscriptions_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/manage_subscription_layout']/android.widget.TextView");
	public String manageSubscriptions_Settings_Name = "Manage Subscription Option in Account Section";
	public By manageSubscriptionPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageSubscriptionPageHeaderText_Name = "Manage Subscription Page Heading";
	public By manageSubscriptionBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageSubscriptionBackButtonText_Name = "Back Button from Manage Subscription";
	// Manage Blocked Users
	public By manageBlockedUsers_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/blocked_list_layout']/android.widget.TextView");
	public String manageBlockedUsers_Settings_Name = "Manage Blocked User Option In Account Section";
	public By manageBlockedUsersPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageBlockedUsersPageHeaderText_Name = "Manager Blocked Users Page Heading";
	public By manageBlocedUsersBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageBlocedUsersBackButtonText_Name = "Back Button from Manage Blocked Users";
	// Apply for Self Verification
	public By applyForSelfVerification_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/apply_selftick_layout']/android.widget.TextView");
	public String applyForSelfVerification_Settings_Name = "Apply for Self Verify Option in Account section";
	public By applyForSelfVerificationPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String applyForSelfVerificationPageHeaderText_Name = "Apply for Self Verify Page Header";
	public By selfVerifyBackButtonText = By.id("com.koo.app:id/backArrow");
	public String selfVerifyBackButtonText_Name = "Back Button from Self Verify";
	// Apply for Eminence
	public By applyForEminence_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/apply_tick_layout']/android.widget.TextView");
	public String applyForEminence_Settings_Name = "Apply for Eminence Option in Account Section";
	public By googlePageForEminenceText = By.id("com.android.chrome:id/title");
	public String googlePageForEminenceText_Name = "Chrome/Browser Page for do Eminence";
	public By chromeCloseButton = By.id("com.android.chrome:id/close_button");
	public String chromeCloseButton_Name = "Close button from browser";
	// Migrate from Twitter
	public By migrateFromTwitter_Settings = By.id("com.koo.app:id/migrate_from_twitter_text");
	public String migrateFromTwitter_Settings_Name = "Migrate from Twitter Option in Account Section";
	public By migrateFromTwitterPopUpText = By.xpath("(//android.widget.ScrollView/android.widget.TextView)");
	public String migrateFromTwitterPopUpText_Name = "Magrate from Twitter Pop-Up";
	public By migrateFromTwitterCloseButtonText = By
			.xpath("(//android.widget.ScrollView/android.view.View/android.widget.TextView)[6]");
	public String migrateFromTwitterCloseButtonText_Name = "Close Button in Migrate from Twitter";
	// Add Account
	public By addAccount_Settings = By.id("com.koo.app:id/tv_add_account");
	public String addAccount_Settings_Name = "Add Account Option In Account Section";
	public By addAccountByUsngPhoneNumberText = By.id("com.koo.app:id/phone_no_textview_subtitle");
	public String addAccountByUsngPhoneNumberText_Name = "Add Account By Using Phone Number";
	public By addAccountByUsngGoogleAcntText = By.id("com.koo.app:id/sign_with_google");
	public String addAccountByUsngGoogleAcntText_Name = "Add Account By Using Google Account";
	public By addAccountByUsngEmailText = By.id("com.koo.app:id/sign_with_email");
	public String addAccountByUsngEmailText_Name = "Add Account By using E-Mail";

	// Manage Account
	public By manageAccount_Settings = By.id("com.koo.app:id/tv_manage_account");
	public String manageAccount_Settings_Name = "Manage Account Option in Account Section";
	public By manageAccountPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageAccountPageHeaderText_Name = "Manage Account Page Heading";
	public By middleMessageInManageAccountText = By.id("com.koo.app:id/middle_text");
	public String middleMessageInManageAccountText_Name = "Page Middle Text Message";
	public By manageAccountBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageAccountBackButtonText_Name = "Back Button from Manage Account";
	// Logout
	public By logout_Settings = By.xpath("//*[@resource-id='com.koo.app:id/logout_layout']/android.widget.TextView");
	public String logout_Settings_Name = "Logout option in Account Section";
	public By logoutPopupText = By.id("com.koo.app:id/tvLogout");
	public String logoutPopupText_Name = "Logout Button";
	public By logoutPopupCancelButtonText = By.id("com.koo.app:id/tvCancel");
	public String logoutPopupCancelButtonText_Name = "Cancel Button";
	public By logoutPopupMessageText = By.id("com.koo.app:id/status_textview");
	public String logoutPopupMessageText_Name = "Logot Pop-Up Message";
	// Delete
	public By delete_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/delete_account_layout']/android.widget.TextView");
	public String delete_Settings_Name = "Delete option in Account Section";
	public By deletePopupText = By.id("com.koo.app:id/tvLogout");
	public By deletePopupMessageText = By.id("com.koo.app:id/status_textview");
	public By deletePopupCancelButtonText = By.id("com.koo.app:id/tvCancel");
	public String deletePopupText_Name = "Delete button";
	public String deletePopupMessageText_Name = "Delete Pop-Up Message";
	public String deletePopupCancelButtonText_Name = "Cancel Button";

	/**
	 * This method is to verify Options in Account Section
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage optionsInAccountSection() {
		try {
			List<WebElement> options = mobileActions.elements(optionTextinAccountCount12);
			List<WebElement> options1 = mobileActions.elements(optionTextinAccountCount2);
			System.out.println("Account Section Options Size: " + options.size());
			System.out.println("Account Section Options Size" + options1.size());
			int size1 = options.size();
			for (int i = 0; i < size1; i++) {
				String actualAccountSectionOptionText1 = options.get(i).getText();
				System.out.println("Actual Option: " + actualAccountSectionOptionText1);
				String expectedAccountSectionOption1 = LanguageDataProvider
						.getLanguageDataValue("AccountSectionOption" + (i + 1) + "Text");
				System.out.println("Expected Option: " + expectedAccountSectionOption1);
				softAssert.assertEquals(actualAccountSectionOptionText1, expectedAccountSectionOption1);
			}
			int size2 = options1.size();
			for (int j = 0; j < size2; j++) {
				String actualAccountSectionOptionText2 = options1.get(j).getText();
				System.out.println("Actual Option: " + actualAccountSectionOptionText2);
				String expectedAccountSectionOption2 = LanguageDataProvider
						.getLanguageDataValue("AccountSectionOption" + (j + 1) + "TextById");
				System.out.println("Expected Option: " + expectedAccountSectionOption2);
				softAssert.assertEquals(actualAccountSectionOptionText2, expectedAccountSectionOption2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Options are not displaying");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options are not displaying", true,
					BaseTest.mobileDriver.get(), true);
		}
		softAssert.assertAll();
		return this;
	}

	/**
	 * This method is to verify Edit Profile Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyEditProfilePage_inSettings() {
		try {
			String beforeText = mobileActions.getText(editProfile_Settings, editProfile_Settings_Name, true).trim();
			mobileActions.isDisplayed(editProfile_Settings, editProfile_Settings_Name);
			mobileActions.click(editProfile_Settings, editProfile_Settings_Name);
			String afterText = mobileActions.getText(editProfilePageHeaderText, editProfilePageHeaderText_Name, true)
					.trim();
			if (mobileActions.isDisplayed(editProfilePageHeaderText, editProfilePageHeaderText_Name)) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(editProfile_Settings_Name + " is Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(editProfile_Settings_Name + " Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						editProfile_Settings_Name + " Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Edit Profile Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Edit Profile Validation Failed", true,
					BaseTest.mobileDriver.get(), true);
		}
		clickBack(editProfileBackButtonText, editProfileBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Account Information Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyAccountInformationPage_inSettings() {
		try {
			mobileActions.isDisplayed(accountInformation_Settings, accountInformation_Settings_Name);
			String beforeText = mobileActions
					.getText(accountInformation_Settings, accountInformation_Settings_Name, true).trim();
			mobileActions.click(accountInformation_Settings, accountInformation_Settings_Name);
			if (mobileActions.isDisplayed(accounInformationPageHeaderText, accounInformationPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(accounInformationPageHeaderText, accounInformationPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(accountInformation_Settings_Name + " Page Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(accountInformation_Settings_Name + " Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						accountInformation_Settings_Name + " Page not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(accountInformation_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					accountInformation_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(accountInformationBackButtonText, accountInformationBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Language Option
	 *
	 * @return
	 */
	public Settings_AccountPage verifyLanguageOption_inSettings() {
		try {
			mobileActions.isDisplayed(language_Settings, language_Settings_Name);
			mobileActions.getText(language_Settings, language_Settings_Name, true);
			mobileActions.click(language_Settings, language_Settings_Name);
			if (mobileActions.isDisplayed(languagePageHeaderText, languagePageHeaderText_Name)) {
				mobileActions.getText(languagePageHeaderText, languagePageHeaderText_Name, true);
				BaseTest.LOGGER.get().logInfo(language_Settings_Name + " Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Language Page Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(language_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						language_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(language_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, language_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Theme Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyThemeOption_inSettings() {
		try {
			mobileActions.getText(theme_Settigs, theme_Settigs_Name, true);
			boolean themeSwitch = mobileActions.isElmPresent(themeSwitchActionText);
			if (themeSwitch) {
				BaseTest.LOGGER.get().logInfo(theme_Settigs_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, theme_Settigs_Name + " is Displayed", true,
						BaseTest.mobileDriver.get(), true);
				mobileActions.click(themeSwitchActionText, themeSwitchActionText_Name);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"after click" + theme_Settigs_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(theme_Settigs_Name + " switching Action Not Done");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						theme_Settigs_Name + " switching Action Not Done", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(theme_Settigs_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, theme_Settigs_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Manage Subscription Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyManageSubscription_inSettings() {
		try {
			mobileActions.isDisplayed(manageSubscriptions_Settings, manageSubscriptions_Settings_Name);
			String beforeText = mobileActions
					.getText(manageSubscriptions_Settings, manageSubscriptions_Settings_Name, true).trim();
			mobileActions.click(manageSubscriptions_Settings, manageSubscriptions_Settings_Name);
			if (mobileActions.isDisplayed(manageSubscriptionPageHeaderText, manageSubscriptionPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageSubscriptionPageHeaderText, manageSubscriptionPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(manageSubscriptions_Settings_Name + " Page Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(manageSubscriptions_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageSubscriptions_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageSubscriptions_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageSubscriptions_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageSubscriptionBackButtonText, manageSubscriptionBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Manage Blocked Users Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyManageBlockedUsersOption_inSettings() {
		try {
			mobileActions.isDisplayed(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name);
			String beforeText = mobileActions
					.getText(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name, true).trim();
			mobileActions.click(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name);
			if (mobileActions.isDisplayed(manageBlockedUsersPageHeaderText, manageBlockedUsersPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageBlockedUsersPageHeaderText, manageBlockedUsersPageHeaderText_Name, true).trim();
				BaseTest.LOGGER.get().logInfo(manageBlockedUsers_Settings_Name + " Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						manageBlockedUsers_Settings_Name + " Page Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(manageBlockedUsers_Settings_Name + " Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageBlockedUsers_Settings_Name + " Page not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageBlockedUsers_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageBlockedUsers_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageBlocedUsersBackButtonText, manageBlocedUsersBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Apply for Self Verification Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyApplyForSelfVerificationOption_inSettings() {
		try {
			mobileActions.isDisplayed(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name);
			mobileActions.getText(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name, true);
			mobileActions.click(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name);
			if (mobileActions.isDisplayed(applyForSelfVerificationPageHeaderText,
					applyForSelfVerificationPageHeaderText_Name)) {
				mobileActions.getText(applyForSelfVerificationPageHeaderText,
						applyForSelfVerificationPageHeaderText_Name, true);
				BaseTest.LOGGER.get().logInfo(applyForSelfVerification_Settings_Name + "/Self-Verify Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						applyForSelfVerification_Settings_Name + "/Self-Verify Page Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get()
				.logInfo(applyForSelfVerification_Settings_Name + "/Self-Verify Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						applyForSelfVerification_Settings_Name + "/Self-Verify Page not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(applyForSelfVerification_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					applyForSelfVerification_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(),
					true);
		}
		clickBack(selfVerifyBackButtonText, selfVerifyBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Apply for Eminence Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyApplyForEminenceOption_inSettings() {
		try {
			mobileActions.waitForVisible(applyForEminence_Settings);
			Assert.assertTrue(mobileActions.isDisplayed(applyForEminence_Settings, applyForEminence_Settings_Name));
			mobileActions.click(applyForEminence_Settings, applyForEminence_Settings_Name);
			mobileActions.waitForVisible(closeButton);
			if (mobileActions.isDisplayed(closeButton, closeButton_Name)) {
				mobileActions.click(closeButton, closeButton_Name);
				BaseTest.LOGGER.get()
				.logInfo("Chrome/Browser Page for " + applyForEminence_Settings_Name + " Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Chrome/Browser Page for " + applyForEminence_Settings_Name + " Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get()
				.logInfo("Chrome/Browser Page for" + applyForEminence_Settings_Name + " not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						"Chrome/Browser Page for" + applyForEminence_Settings_Name + " not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(applyForEminence_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					applyForEminence_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		// commonHelperPage.clickOnBackArrow();
		return this;
	}

	/**
	 * This method is to verify Migrate form Twitter Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyMigrateFromTwitterOption_inSettings() {
		try {
			mobileActions.isDisplayed(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name);
			String beforeText = mobileActions
					.getText(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name, true).trim();
			mobileActions.click(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name);
			if (mobileActions.isElmPresent(migrateFromTwitterPopUpText)) {
				String afterText = mobileActions
						.getText(migrateFromTwitterPopUpText, migrateFromTwitterPopUpText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(migrateFromTwitter_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						migrateFromTwitter_Settings_Name + " Pop-Up Message Displayed", false,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(migrateFromTwitter_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						migrateFromTwitter_Settings_Name + " Pop-Up Message Not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(migrateFromTwitter_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					migrateFromTwitter_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(migrateFromTwitterCloseButtonText, migrateFromTwitterCloseButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Add Account Option
	 *
	 * @return
	 */
	public Settings_AccountPage verifyAddAccountPage_inSettings() {
		try {
			mobileActions.isDisplayed(addAccount_Settings, addAccount_Settings_Name);
			mobileActions.getText(addAccount_Settings, addAccount_Settings_Name, true);
			mobileActions.click(addAccount_Settings, addAccount_Settings_Name);
			if (mobileActions.isDisplayed(addAccountByUsngPhoneNumberText, addAccountByUsngPhoneNumberText_Name)) {
				mobileActions.getText(addAccountByUsngPhoneNumberText, addAccountByUsngPhoneNumberText_Name, true);
				BaseTest.LOGGER.get().logInfo(addAccount_Settings_Name + " Page is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						addAccount_Settings_Name + " Page Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(addAccount_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						addAccount_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(addAccount_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					addAccount_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Manage Account Option
	 *
	 * @return
	 */
	public Settings_AccountPage verifyManageAccountPage_inSettings() {
		try {
			mobileActions.isDisplayed(manageAccount_Settings, manageAccount_Settings_Name);
			String beforeText = mobileActions.getText(manageAccount_Settings, manageAccount_Settings_Name, true).trim();
			mobileActions.click(manageAccount_Settings, manageAccount_Settings_Name);
			if (mobileActions.isDisplayed(manageAccountPageHeaderText, manageAccountPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageAccountPageHeaderText, manageAccountPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(manageAccount_Settings_Name + " Page is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						manageAccount_Settings_Name + " Page is Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(manageAccount_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageAccount_Settings_Name + "  Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageAccount_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageAccount_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageAccountBackButtonText, manageAccountBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Share your Koo Profile action
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyShareYourKooProfileAction_inSettings() {
		try {
			mobileActions.waitForVisible(shareYourKooProfile_Settings);
			mobileActions.isDisplayed(shareYourKooProfile_Settings, shareYourKooProfile_Settings_Name);
			mobileActions.click(shareYourKooProfile_Settings, shareYourKooProfile_Settings_Name);
			if (mobileActions.isDisplayed(shareYourKooProfilePopUpText, shareYourKooProfilePopUpText_Name)) {
				BaseTest.LOGGER.get().logInfo(shareYourKooProfilePopUpText_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						shareYourKooProfilePopUpText_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(shareYourKooProfilePopUpText_Name + " Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						shareYourKooProfilePopUpText_Name + "  Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(shareYourKooProfilePopUpText_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					shareYourKooProfilePopUpText_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Logout action
	 *
	 * @param expectedHeading
	 * @return
	 */
	public Settings_AccountPage verifyLogOutAction_inSettings() {
		try {
			mobileActions.isDisplayed(logout_Settings, logout_Settings_Name);
			String beforeText = mobileActions.getText(logout_Settings, logout_Settings_Name, true).trim();
			mobileActions.click(logout_Settings, logout_Settings_Name);
			if (mobileActions.isElmPresent(logoutPopupText)) {
				String afterText = mobileActions.getText(logoutPopupText, logoutPopupText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(logout_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						logout_Settings_Name + " Pop-Up Message Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(logout_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						logout_Settings_Name + " Pop-Up Message Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(logout_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, logout_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(logoutPopupCancelButtonText, logoutPopupCancelButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Delete action
	 *
	 * @return
	 */
	public Settings_AccountPage verifyDeleteAction_inSettings() {
		try {
			mobileActions.isDisplayed(delete_Settings, delete_Settings_Name);
			String beforeText = mobileActions.getText(delete_Settings, delete_Settings_Name, true).trim();
			mobileActions.click(delete_Settings, delete_Settings_Name);
			if (mobileActions.isElmPresent(deletePopupText)) {
				String afterText = mobileActions.getText(deletePopupText, deletePopupText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(delete_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						delete_Settings_Name + " Pop-Up Message Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(delete_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						delete_Settings_Name + " Pop-Up Message Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(delete_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, delete_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(deletePopupCancelButtonText, deletePopupCancelButtonText_Name);
		return this;
	}

	/**
	 * This method is click on back arrow
	 * 
	 */
	public void clickBack(By by, String locatorName) {

		mobileActions.waitForVisible(by);
		Assert.assertTrue(mobileActions.isDisplayed(by, locatorName));
		mobileActions.click(by, locatorName);
	}
}
