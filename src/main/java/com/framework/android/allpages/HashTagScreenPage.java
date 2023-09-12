package com.framework.android.allpages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class HashTagScreenPage {

	MobileActions mobileActions = null;
	UserBlockPage userBlockPage = null;
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	HomeScreenTabPage homeScreenTabPage = null;
	SettingsPage settingsPage = null;

	String actualText;

	public HashTagScreenPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.onBoardingFlowPage = new OnBoardingFlowPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.kooCreationPage = new KooCreationPage();
		this.homeScreenTabPage = new HomeScreenTabPage();
		this.settingsPage = new SettingsPage();
	}

	public By whatsOnYourMind = By.id("com.koo.app:id/creation_view");
	public By hasTag_PopUp = By.xpath("//android.widget.TextView[contains(@text,'#')]");
	public By search_icon = By.id("com.koo.app:id/lottie_search");
	public By back_button = By.xpath("//android.widget.ImageView[@content-desc=\"Back Button\"]");
	public By searchBar_field = By.id("com.koo.app:id/search_edit_tex");
	public By viewMore_link = By.xpath("//android.widget.TextView[contains(@text,'View more')]");
	public By hashtagExplore_icon = By.id("com.koo.app:id/lottie_explore");
	public String hashtag_screen_tab = "//android.widget.TextView[@text='###']";
	public By hashtag_post = By
			.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/hashtagTitle'][contains(@text,'#')])[1]");
	public By hashtagIn_post = By.xpath("(//android.widget.TextView[contains(@text,'#')])[2]");
	public By hashtag_post_heading = By
			.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview']");
	public By back_arrow_button = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/backArrow']");
	public By share_hashtag_button = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/ivShare']");
	public String profileImageFor_hashTagKoo = "(//android.widget.TextView[contains(@text,'#')])[1]//following-sibling::android.widget.FrameLayout//android.view.ViewGroup//android.widget.ImageView[not(contains(@resource-id,'com.koo.app:id/img_dot'))]";
	public String plusIconFor_hashtagKoo = "(//android.widget.TextView[contains(@text,'#')]//..//..//android.widget.ImageView[@resource-id='com.koo.app:id/hashtag_create'])[1]";
	public By selectedHashTag_attribute = By.xpath("//android.widget.EditText\"");
	public String plusIconFor_NERTagKoo = "(//android.widget.TextView[not(contains(@text,'#'))]//..//..//android.widget.ImageView[@resource-id='com.koo.app:id/hashtag_create'])[1]";
	public By user_Image = By.xpath("//android.widget.ImageView[@content-desc='User Image']");

	public By kooContainsHashTag = By.xpath("//android.view.ViewGroup/android.widget.TextView[contains(@text,'#')]");

	public String whatsOnYourMind_Name_Name = "Whats on your mind field";
	public String hasTag_PopUp_Name = "HashTag popup is displaying for # post";
	public String search_icon_Name = "Search icon";
	public String back_button_Name = "";
	public String searchBar_field_Name = "search bar field";
	public String viewMore_link_Name = "";
	public String hashtagExplore_icon_Name = "Hash Tag Explore Icon to Explore Screen";
	public String hashtag_screen_tab_Name = "";
	public String hashtag_post_Name = "Actual text of HashTag post";
	public String hashtagIn_post_Name = "HashTag is present in post";
	public String hashtag_post_heading_Name = "HashTag post heading";
	public String back_arrow_button_Name = "Back Arrow button";
	public String share_hashtag_button_Name = "Share Post/HashTag button";
	public String profileImageFor_hashTagKoo_Name = "";
	public String plusIconFor_hashtagKoo_Name = "";
	public String selectedHashTag_attribute_Name = "";
	public String plusIconFor_NERTagKoo_Name = "";
	public String user_Image_Name = "";

	public void clickOnTrendingTagsIcon() {
		mobileActions.click(homeScreenTabPage.trendingTagsIcon, homeScreenTabPage.trendingKooIcon_Name);
	}

	public void verifyAndCLickOnAnyHashTagOfKoo() {

	}

	/**
	 * Verify Hash Tag popup on What's on your mind koo creation page
	 *
	 * @param hashTag
	 * @throws IOException
	 */
	public void verifyHashTagPopUpOnKooCreation(String hashTag) throws IOException {
		mobileActions.waitForVisible(whatsOnYourMind);
		mobileActions.click(whatsOnYourMind, whatsOnYourMind_Name_Name);
		mobileActions.sendKeys(whatsOnYourMind, whatsOnYourMind_Name_Name, hashTag);
		Assert.assertTrue(mobileActions.isDisplayed(hasTag_PopUp, hasTag_PopUp_Name));
	}

	/**
	 * Verify Hash Tag popup on search page
	 *
	 * @param hashTag
	 * @throws IOException
	 */
	public void verifyHashTagPopUpOnSearch(String hashTag) throws IOException, InterruptedException {
		mobileActions.waitForVisible(search_icon);
		mobileActions.isDisplayed(search_icon, search_icon_Name);
		mobileActions.click(search_icon, search_icon_Name);
		mobileActions.isDisplayed(searchBar_field, searchBar_field_Name);
		mobileActions.click(searchBar_field, searchBar_field_Name);
		mobileActions.sendKeys(searchBar_field, searchBar_field_Name, hashTag);
		mobileActions.click(searchBar_field, searchBar_field_Name);
		mobileActions.waitForVisible(hasTag_PopUp);
		Assert.assertTrue(mobileActions.isDisplayed(hasTag_PopUp, hasTag_PopUp_Name));
	}

	/**
	 * Click on HashTag Explore icon
	 *
	 * @throws IOException
	 */
	public void clickHashTagExploreIcon() throws IOException {
		mobileActions.waitForVisible(hashtagExplore_icon);
		Assert.assertTrue(mobileActions.isDisplayed(hashtagExplore_icon, hashtagExplore_icon_Name));
		mobileActions.click(hashtagExplore_icon, hashtagExplore_icon_Name);
	}

	/**
	 * This method is to get heading of # post
	 * 
	 * @return
	 */
	public String getHeadingOfHashPost() throws InterruptedException {
		mobileActions.swipeUpFindElement(10, hashtag_post);
		mobileActions.waitForVisible(hashtag_post);
		actualText = mobileActions.getText(hashtag_post, hashtag_post_Name, true).trim();
		;
		return actualText;
	}

	/**
	 * Click on First HashTag post
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void clickHashTagPost() throws InterruptedException, IOException {
		mobileActions.swipeUpFindElement(5, hashtag_post);
		mobileActions.click(hashtag_post, hashtag_post_Name);
	}

	/**
	 * This method is to verify SHare Hash Tag PopUp
	 * 
	 * @return
	 * @throws IOException
	 */
	public HashTagScreenPage verifyShareHashTagPopUp(String expectedTextOfShareKooPopUpHeading) throws IOException {
		mobileActions.waitForVisible(share_hashtag_button);
		Assert.assertTrue(mobileActions.isDisplayed(share_hashtag_button, share_hashtag_button_Name));
		mobileActions.click(share_hashtag_button, share_hashtag_button_Name);
		mobileActions.waitForVisible(settingsPage.shareKooPopUp);
		actualText = mobileActions.getText(settingsPage.shareKooPopUp, settingsPage.shareKooPopUp_Name, true).trim();
		Assert.assertEquals(actualText, expectedTextOfShareKooPopUpHeading,
				"Share Hash Tag popup is displaying successfully = " + expectedTextOfShareKooPopUpHeading);
		return this;
	}

	/**
	 * Verify Back Button on HashTag post
	 */
	public void verifyBackButton() {
		mobileActions.waitForVisible(back_arrow_button);
		Assert.assertTrue(mobileActions.isDisplayed(back_arrow_button, back_arrow_button_Name));
	}

	/**
	 * Verify Share button on HashTag post
	 */
	public void verifyShareButton() {
		mobileActions.waitForVisible(share_hashtag_button);
		Assert.assertTrue(mobileActions.isDisplayed(share_hashtag_button, share_hashtag_button_Name));
	}

	/**
	 * This method is to verify heading of hashtag post
	 */
	public void verifyHeadingOfHashTagPost(String expectedText) {
		mobileActions.waitForVisible(hashtag_post_heading);
		String actualText = mobileActions.getText(hashtag_post_heading, hashtag_post_heading_Name, true).trim();
		Assert.assertEquals(actualText, expectedText, "hashTag heading is not correct actual is displaying = "
				+ actualText + ", Expected is = " + expectedText);
	}

	/**
	 * Verify hashTag is in the post
	 */
	public void verifyHashTagOnPost() {
		Assert.assertTrue(mobileActions.isDisplayed(hashtagIn_post, hashtagIn_post_Name));
	}
}
