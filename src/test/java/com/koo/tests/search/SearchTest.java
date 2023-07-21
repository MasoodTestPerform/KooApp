package com.koo.tests.search;

import org.testng.annotations.Test;

import com.framework.android.allpages.SearchPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class SearchTest extends BaseTest {
	MobileActions mobileActions = new MobileActions();
	

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-177] Verify User should be able to type text in seach screen & see appropriate search results", groups = {
			"regression", "topicsTab_home" })
	public void verifySearchBarFunctionality(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Search Bar is Taking inputs------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SearchPage searchPage = new SearchPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			searchPage.verifyAndclickOnSearchIcon();
			searchPage.verifyAndClickOnSearchBar();
			searchPage.enterValueInSearchBar("Yogi Adityanath");
			searchPage.verifyAndClickSearchAllResultsLink();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options Search Bar is Taking inputs ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify Search Bar is Taking inputs. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-179] Verify 4 different tabs in search result screen: All, Profile, Hashtags, Koos", groups = {
			"regression", "topicsTab_home" })
	public void verifyAllTabsInSearchResults(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Tabs Search Results ------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SearchPage searchPage = new SearchPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			searchPage.verifyAndclickOnSearchIcon();
			searchPage.verifyAndClickOnSearchBar();
			searchPage.enterValueInSearchBar("Yogi Adityanath");
			searchPage.verifyAndClickSearchAllResultsLink();
			searchPage.verifyTabsInSearchResult();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Tabs Search Results ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify Tabs Search Results. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-179] Verify 4 different tabs in search result screen: All, Profile, Hashtags, Koos", groups = {
			"regression", "topicsTab_home" })
	public void verifyAllThreeTypesOfResults(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Tabs Search Results ------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SearchPage searchPage = new SearchPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			searchPage.verifyAndclickOnSearchIcon();
			searchPage.verifyAndClickOnSearchBar();
			searchPage.enterValueInSearchBar("Yogi Adityanath");
			searchPage.verifyAndClickSearchAllResultsLink();
			searchPage.verifyTabsInSearchResult();
			searchPage.verifyallThreeTypesResults();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Tabs Search Results ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify Tabs Search Results. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
}
