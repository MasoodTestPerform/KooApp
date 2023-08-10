package com.koo.SearchTests;

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
			"regression", "Search Tab" })
	public void verifySearchBarFunctionality(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Search Bar is Taking inputs & see appropriate search results------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SearchPage searchPage = new SearchPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			searchPage.verifyAndclickOnSearchIcon();
			searchPage.verifyAndClickOnSearchBar();
			searchPage.enterValueInSearchBar("Yogi Adityanath");
			searchPage.verifyAndClickLeftSearchIcon();
			searchPage.verifyAndClickSearchAllResultsLink();
			mobileActions.swipeUp(2);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Options Search Bar is Taking inputs & see appropriate search results ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify Search Bar is Taking inputs & see appropriate search results. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-178] Verify suggestions should be shown for while typing text: Profiles, Hashtabs & Koos", groups = {
			"regression", "Search Tab" })
	public void verifyAllThreeTypesOfResults(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify Suggestions while typing ------><b>", false,
					BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			SearchPage searchPage = new SearchPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			searchPage.verifyAndclickOnSearchIcon();
			searchPage.verifyAndClickOnSearchBar();
			searchPage.enterValueInSearchBar("Lavanya");
			searchPage.verifyAndClickLeftSearchIcon();
			searchPage.verifyHashTags();
			searchPage.verifyProfileResults();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Suggestions while typing ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify Suggestions while typing. Exception:" + e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-179] Verify 4 different tabs in search result screen: All, Profile, Hashtags, Koos", groups = {
			"regression", "Search Tab" })
	public void verifyDifferentTabsInSearchResults(String language) {
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
			searchPage.verifyAndClickLeftSearchIcon();
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
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-180] Verify all three types of results in All tabs & respective search results in remaining tabs.", groups = {
			"regression", "Search Tab" })
	public void verifyRelatedResultsInEachTab(String language) {
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
			searchPage.verifyAndClickLeftSearchIcon();
			searchPage.verifyAndClickSearchAllResultsLink();
			searchPage.verifyTabsInSearchResult();
			searchPage.verifyallThreeTypesResults();
			searchPage.clickOnTab(searchPage.tab_All, searchPage.tab_All_Name);
			searchPage.clickOnTab(searchPage.tab_People, searchPage.tab_People_Name);
			searchPage.clickOnTab(searchPage.tab_HashTags, searchPage.tab_HashTags_Name);
			searchPage.clickOnTab(searchPage.tab_Koos, searchPage.tab_Koos_Name);
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
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-181] Verify blocked user profiles & Koos should not be show in search screen.", groups = {
			"regression", "Search Tab" })
	public void verifyBlockedUserPrfoile(String language) {
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
			searchPage.enterValueInSearchBar("jagathChandraZHMR");
			searchPage.verifyAndClickLeftSearchIcon();
			searchPage.verifyAndClickSearchAllResultsLink();
			
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified Blocked User ------><b>",
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
