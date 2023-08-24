package com.koo.LogoutAndDeleteTests;

import org.testng.annotations.Test;

import com.framework.android.allpages.CommentDetailsScreenPage;
import com.framework.android.allpages.SettingsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class LogoutAndDeleteTest extends BaseTest {

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-202] Verify user is able to logout of added account, logging out of child, user should land on parent feed & logging out of parent account all added acount should be logged out.", groups = {
			"regression", "LogoutAndDelete" })
	public void verifyUserAbleLogoutFromProfile(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify user is able to logout of added account, logging out of child, user should land on parent feed & logging out of parent account all added acount should be logged out. ------><b>",
					false, BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.clickOnProfile();
			settingsPage.clickOnThreeDots();
			settingsPage.clickSettingsButton();
			settingsPage.doAddAccount();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getChildUserName());
			settingsPage.clickOnProfile();
			settingsPage.clickSettingsButtonChildAccount();
			settingsPage.doLogout();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified user is able to logout of added account, logging out of child, user should land on parent feed & logging out of parent account all added acount should be logged out. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify user is able to logout of added account, logging out of child, user should land on parent feed & logging out of parent account all added acount should be logged out. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
}