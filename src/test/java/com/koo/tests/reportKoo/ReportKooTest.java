package com.koo.tests.reportKoo;

import org.testng.annotations.Test;

import com.framework.android.allpages.HomeScreenTabPage;
import com.framework.android.allpages.PeopleTabPage;
import com.framework.android.allpages.ReportKooOptionsTabPage;
import com.framework.android.allpages.Settings_OptionsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class ReportKooTest extends BaseTest {
	MobileActions mobileActions = new MobileActions();
	ReportKooOptionsTabPage reportKooPage = new ReportKooOptionsTabPage();
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_190] Verify following options in Account section:(a) Edit Porfile (b) Language (c) Share (d) Theme options (e) Manage Subscriptions (f) Manage Blocked users (g) Apply for Verified Account (h) Add Account (i) Manage Accounts (j) Logout (k) Delete.", groups = {
			"regression", "topicsTab_home" })
	public void validateReportKooOptions(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Options in Report Koo------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			reportKooPage.verifyButtonDotsAndClick();
			reportKooPage.validateReportKooOption();
			reportKooPage.validateReportKooOptionsInPeopleTab();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options in Report Koo ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing verify Options in Report Koo. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
}