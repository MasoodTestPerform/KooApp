package com.koo.SettingsTests;

import org.testng.annotations.Test;

import com.framework.android.allpages.SettingsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class SettingsTest extends BaseTest {
	MobileActions mobileActions = new MobileActions();

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_190] Verify following options in Account section:(a) Edit Porfile (b) Language (c) Share (d) Theme options (e) Manage Subscriptions (f) Manage Blocked users (g) Apply for Verified Account (h) Add Account (i) Manage Accounts (j) Logout (k) Delete.", groups = {
			"regression", "topicsTab_home" })
	public void verifyOptionsInAccountSection(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Account Section------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SettingsPage settingsPage = new SettingsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.verifySettingsButton();
			settingsPage.clickSettingsButton();
			settingsPage.optionsInAccountSection();
			settingsPage.verifyEditProfilePage_inSettings();
			settingsPage.verifyAccountInformationPage_inSettings();
			settingsPage.verifyThemeOption_inSettings();
			settingsPage.verifyManageSubscription_inSettings();
			settingsPage.verifyManageBlockedUsersOption_inSettings();
			settingsPage.verifyApplyForSelfVerificationOption_inSettings();
			settingsPage.verifyApplyForEminenceOption_inSettings();
			settingsPage.verifyMigrateFromTwitterOption_inSettings();
			settingsPage.verifyManageAccountPage_inSettings();
			settingsPage.verifyLogOutAction_inSettings();
			settingsPage.verifyDeleteAction_inSettings();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Account Section ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Account Section. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}

	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_190] Verify following options in Account section:(a) Edit Porfile (b) Language (c) Share (d) Theme options (e) Manage Subscriptions (f) Manage Blocked users (g) Apply for Verified Account (h) Add Account (i) Manage Accounts (j) Logout (k) Delete.", groups = {
			"regression", "topicsTab_home" })
	public void verifyShareYourKooProfile(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Account Section------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SettingsPage settingsPage = new SettingsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.verifySettingsButton();
			settingsPage.clickSettingsButton();
			settingsPage.verifyShareYourKooProfileAction_inSettings();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Account Section ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Account Section. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}

	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_190] Verify following options in Account section:(a) Edit Porfile (b) Language (c) Share (d) Theme options (e) Manage Subscriptions (f) Manage Blocked users (g) Apply for Verified Account (h) Add Account (i) Manage Accounts (j) Logout (k) Delete.", groups = {
			"regression", "topicsTab_home" })
	public void verifyAddAccount(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Account Section------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SettingsPage settingsPage = new SettingsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.verifySettingsButton();
			settingsPage.clickSettingsButton();
			settingsPage.verifyAddAccountPage_inSettings();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Account Section ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Account Section. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}

	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_190] Verify following options in Account section:(a) Edit Porfile (b) Language (c) Share (d) Theme options (e) Manage Subscriptions (f) Manage Blocked users (g) Apply for Verified Account (h) Add Account (i) Manage Accounts (j) Logout (k) Delete.", groups = {
			"regression", "topicsTab_home" })
	public void verifyLanguage(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Account Section------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SettingsPage settingsPage = new SettingsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.verifySettingsButton();
			settingsPage.clickSettingsButton();
			settingsPage.verifyLanguageOption_inSettings();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Account Section ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Account Section. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}

	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_191] Verify following options in Other section:\r\n"
			+ "(a) Notifications (b) Whatsapp Updates (c) Video autoplay (d) Auto play images (e) Translation (f) Koo rewards (g) Help (h) Privacy Policy (i) About us (j) Resource Center (k) Platstore Compliance.", groups = {
					"regression", "topicsTab_home" })
	public void verifyOptionsInOthers(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Option Section------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SettingsPage settingsPage = new SettingsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.verifySettingsButton();
			settingsPage.clickSettingsButton();
			settingsPage.verifyOptionsinOthers();
			settingsPage.verifyNotifications_inSettings();
			settingsPage.verifyWhatsappUpdates_inSettings();
			settingsPage.verifyVideoPlay_inSettings();
			settingsPage.verifyAutoPlayImages_inSettings();
			settingsPage.verifyTransaltion_inSettings();
			settingsPage.verifyRewards_inSettings();
			settingsPage.verifyHelpOption_inSettings();
			settingsPage.verifyPrivacyPolicyOption_inSettings();
			settingsPage.verifyAboutUsOption_inSettings();
			settingsPage.verifyResourceCenterOption_inSettings();
			settingsPage.verifyPlayStoreComplianceOption_inSettings();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Options Section ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Options Section. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}

	}
}