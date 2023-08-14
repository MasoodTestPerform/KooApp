package com.framework.android.allpages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.DriverFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class SearchPage {
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
	HomeScreenTabPage homeScreenPage = new HomeScreenTabPage();
	HashTagScreenPage hashTagScreenPage = new HashTagScreenPage();

	String actualValue;

	public By searchIcon = By.id("com.koo.app:id/lottie_search");
	public By searchBar = By.id("com.koo.app:id/search_edit_text");
	public By trendingTagHeading = By
			.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/header_text'])[1]");
	public By trendingTagsPresent = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/topic_title']");
	public By mostFollowedPeopleHeading = By
			.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/header_text'])[2]");
	public By followButton = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvFollow']");
	public By recentSearchesHeading = By
			.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/tvHeader'])[1]");
	public By recentSearchValue = By.id("com.koo.app:id/tvRecentSearch");
	public By backArrowFromSearch = By.id("com.koo.app:id/img_search_backarrow");
	public By searchAllResultLink = By.id("com.koo.app:id/tv_see_all_results");
	public By viewMoreLink = By.id("com.koo.app:id/tvViewMore");
	public By leftSearchIcon = By.id("com.koo.app:id/search_icon");
	public By searchResultTabs_All = By.xpath(
			"//android.widget.HorizontalScrollView[@resource-id='com.koo.app:id/tab_layout']//following-sibling::android.widget.TextView");
	public By noResultFoundMessage = By.id("com.koo.app:id/tv_no_result");
	public By tabForSearchResult = By.xpath("//android.widget.TextView[@text='###']");
	public By profileResults = By.xpath(
			"//android.widget.LinearLayout/android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview']");
	public By kooResults = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/topic_title_textview']");
	public By hashTagResults = By.id("com.koo.app:id/topic_title");
	public By pagination = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/name_score_layout']");
	public By userFollowButton = By.xpath(
			"//androidx.recyclerview.widget.RecyclerView/../..//android.widget.FrameLayout[@resource-id='com.koo.app:id/follow_layout']");
	public By tab_All = By.xpath("//android.widget.LinearLayout[@content-desc=\"All\"]");
	public By tab_People = By.xpath("//android.widget.LinearLayout[@content-desc=\"People\"]");
	public By tab_HashTags = By.xpath("//android.widget.LinearLayout[@content-desc=\"Hashtags\"]");
	public By tab_Koos = By.xpath("//android.widget.LinearLayout[@content-desc=\"Koos\"]");

	public String searchIcon_Name = "Search Icon on Home Page";
	public String searchBar_Name = "Search Bar";
	public String trendingTagHeading_inSearch_Name = "Trending Tags Heading";
	public String trendingTagsPresent_Name = "Trending Tags Present with (#) tag";
	public String mostFollowedPeopleHeading_inSearch_Name = "Most Followed People Heading";
	public String followButton_Name = "(+)Follow button for Profile";
	public String recentSearchesHeading_Name = "Recent Searches Heading";
	public String recentSearchValue_Name = "Recent Search Results";
	public String backArrowFromSearch_Name = "Back Arrow (Back Button) from Search";
	public String searchAllResultLink_Name = "Search All Link";
	public String viewMoreLink_Name = "View More Link to view all";
	public String leftSearchIcon_Name = "Search Icon on left side of Search Bar";
	public String searchResultTabs_All_Name = "All Tabs in Search Results";
	public String noResultFoundMessage_Name = "No Result for Search Text in Tab";
	public String tabForSearchResult_Name = "";
	public String profileResults_Name = "Profile Names in search result";
	public String kooResults_Name = "Koo Cards Details in Search Results";
	public String pagination_Name = "Profiles in Search Results";
	public String tab_All_Name = "All tab in Search Results";
	public String tab_People_Name = "People tab in Search Results";
	public String tab_HashTags_Name = "HashTags tab in Search Results";
	public String tab_Koos_Name = "Koos tab in Search Results";
	public String hashTagResults_Name = "Hash Tags contains topics";

	/**
	 * This method is to click on search icon jagath
	 */
	public SearchPage verifyAndclickOnSearchIcon() throws IOException {
		mobileActions.waitForVisible(searchIcon);
		Assert.assertTrue(mobileActions.isDisplayed(searchIcon, searchIcon_Name));
		mobileActions.click(searchIcon, searchIcon_Name);
		return this;
	}

	/**
	 * This method is to verify and click on search Bar jagath
	 */
	public SearchPage verifyAndClickOnSearchBar() throws IOException {
		mobileActions.waitForVisible(searchBar);
		Assert.assertTrue(mobileActions.isDisplayed(searchBar, searchBar_Name));
		mobileActions.click(searchBar, searchBar_Name);
		return this;
	}

	/**
	 * This method is to enter value in search bar field
	 * 
	 * @param value
	 * @throws IOException
	 */
	public SearchPage enterValueInSearchBar(String value) throws IOException {
		mobileActions.sendKeys(searchBar, searchBar_Name, value);
		return this;
	}

	/**
	 * This method is to verify and Click left Search icon of Search Bar
	 */
	public SearchPage verifyAndClickLeftSearchIcon() throws IOException {
		mobileActions.waitForVisible(leftSearchIcon);
		Assert.assertTrue(mobileActions.isDisplayed(leftSearchIcon, leftSearchIcon_Name));
		mobileActions.click(leftSearchIcon, leftSearchIcon_Name);
		return this;
	}

	/**
	 * This method is to verify search all result link
	 */
	public SearchPage verifyAndClickSearchAllResultsLink() throws IOException {
		mobileActions.waitForVisible(searchAllResultLink);
		Assert.assertTrue(mobileActions.isDisplayed(searchAllResultLink, searchAllResultLink_Name));
		mobileActions.click(searchAllResultLink, searchAllResultLink_Name);
		return this;
	}

	/**
	 * This method is to Verify Tabs in Search results
	 *
	 * @throws IOException
	 */
	public SearchPage verifyTabsInSearchResult() {
		List<WebElement> options = mobileActions.elements(searchResultTabs_All);
		System.out.println("Search Result Options Size: " + options.size());
		int size = options.size();
		for (int i = 0; i < size; i++) {
			String actualSearchResultTabOptionText = options.get(i).getText();
			System.out.println("Actual Option: " + actualSearchResultTabOptionText);
			String expectedSearchResultTabOption = LanguageDataProvider
					.getLanguageDataValue("SearchAllResultTabs" + (i + 1));
			System.out.println("Expected Option: " + expectedSearchResultTabOption);
			softAssert.assertEquals(actualSearchResultTabOptionText, expectedSearchResultTabOption);
		}
		return this;
	}

	/**
	 * This method is to click on tab
	 * 
	 * @param tabName
	 * @throws IOException
	 */
	public void clickOnTab(By by, String tabName) throws IOException {
		mobileActions.waitForVisible(by);
		Assert.assertTrue(mobileActions.isDisplayed(by, tabName));
		mobileActions.click(by, tabName);
	}

	/**
	 * This method is to verify data in All sub tab
	 * 
	 * @param expectedValue
	 */
	public void verifyDataInAllSubTab(String expectedValue) {
		List<WebElement> elements = mobileActions.elements(trendingTagsPresent);
		for (int i = 0; i < elements.size(); i++) {
			actualValue = elements.get(i).getText();
			softAssert.assertTrue(actualValue.contains(expectedValue),
					"Verify all koos contains searched keyword with hashtag");
		}
		softAssert.assertAll();
	}

	/**
	 * This method is to verify all profile sub tab results
	 */
	public void verifyProfileResults() {
		mobileActions.waitForVisible(profileResults);
		mobileActions.getText(profileResults, profileResults_Name, true);
		Assert.assertTrue(mobileActions.isDisplayed(profileResults, profileResults_Name));
	}

	/**
	 * This method is to verify data for koo sub tab Results
	 */
	public void verifyKoos() {
		mobileActions.waitForVisible(kooResults);
		mobileActions.getText(kooResults, kooResults_Name, true);
		Assert.assertTrue(mobileActions.isDisplayed(kooResults, kooResults_Name));
	}

	/**
	 * This method is to verify data for Hashtags sub tab Results
	 */
	public void verifyHashTags() {
		mobileActions.waitForVisible(hashTagResults);
		mobileActions.getText(hashTagResults, hashTagResults_Name, true);
		Assert.assertTrue(mobileActions.isDisplayed(hashTagResults, hashTagResults_Name));
	}

	/**
	 * This method is to verify data for three types of Results in All tab
	 */
	public void verifyallThreeTypesResults() {
		verifyHashTags();
		verifyProfileResults();
		verifyKoos();
	}
	
	/**
	 * This method is to verify and click on Tab
	 */
	public void verifyAndClickOnTab(String expectedTabName) {
		mobileActions.waitForVisible(hashTagResults);
		mobileActions.getText(hashTagResults, hashTagResults_Name, true);
		Assert.assertTrue(mobileActions.isDisplayed(hashTagResults, hashTagResults_Name));
	}
	
	/**
	 * This method is to verify and click on Tab
	 */
	public void verifyAndClickOnTab(By by, String expectedTabName) {
		mobileActions.waitForVisible(by);
		mobileActions.getText(by, expectedTabName, true);
		Assert.assertTrue(mobileActions.isDisplayed(by, expectedTabName));
	}

}
