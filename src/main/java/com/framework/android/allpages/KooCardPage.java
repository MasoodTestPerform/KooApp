package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import com.koo.framework.AssertManager;
import com.koo.framework.BaseTest;

public class KooCardPage {

	MobileActions mobileActions = null;
	UserBlockPage userBlockPage = null;
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	HomeScreenTabPage homeScreenTabPage = null;
	AssertManager asserManager = null;
	NewUserFlowPage newUserFlowPage = null;
	ProfileScreenPage profileScreenPage = null;
	KooDetailScreenPage kooDeatilDetailScreenPage = null;

	String actualText;

	public KooCardPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.onBoardingFlowPage = new OnBoardingFlowPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.kooCreationPage = new KooCreationPage();
		this.homeScreenTabPage = new HomeScreenTabPage();
		this.asserManager = new AssertManager();
		this.newUserFlowPage = new NewUserFlowPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.kooDeatilDetailScreenPage = new KooDetailScreenPage();
	}

	public By profile_icon = By.id("com.koo.app:id/img_my_profile");
	public String postButton = "//android.widget.TextView[@content-desc='###']";
	public String mlkButton = "//android.widget.TextView[@resource-id='com.koo.app:id/text_multilan_title'][@text='###']";
	public By reeKooIcon = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/rekoo_imageview']");
	public By reeKooNoButton = By.id("com.koo.app:id/rekooNo");
	public By likeCount = By.id("com.koo.app:id/tv_stats_likes");
	public By reeKooCount = By.id("com.koo.app:id/tv_stats_rekoos");
	public By atTheRatePopUp = By.xpath("//android.widget.TextView[contains(@text,'@')]");
	public By addToFavoriteButton = By.id("com.koo.app:id/itemAddToFavorite");
	public By saveKooRemoveKooText = By.xpath("//android.widget.TextView[@text='###']");
	public By kooTitle = By
			.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/topic_title_textview'][@text='###']");
	public By editProfileButton = By.id("com.koo.app:id/edit_profile_button");
	public By nameField = By.id("com.koo.app:id/float_name");
	public By handleField = By.id("com.koo.app:id/float_handle");
	public By professionField = By.id("com.koo.app:id/float_profession");
	public By plusFollowButton = By.id("com.koo.app:id/tvFollowStatus");
	public By channel = By.id("com.koo.app:id/channel_name_textview");
	public By title = By.id("com.koo.app:id/topic_title_textview");
	public By image = By.id("com.koo.app:id/single_image");
	public By btn_dots = By.id("com.koo.app:id/iv_options_more");
	public By btn_play = By.id("com.koo.app:id/play");
	public By btn_like = By.id("com.koo.app:id/like_imageview");
	public By likeCountText = By.id("com.koo.app:id/like_textview");
	public By btn_comment = By.id("com.koo.app:id/comment_imageview");
	public By btn_commentText = By.id("com.koo.app:id/comment_textview");
	public By comment_txt = By.xpath("//*[@content-desc='koo_create_textField']");
	public By comment_post = By.xpath("//android.widget.TextView[@content-desc='Post']");
	public By CommentCountText = By.id("com.koo.app:id/comment_textview");
	public By btn_comment1 = By.xpath("//*[@resource-id='com.koo.app:id/comment_imageview']");
	public By btn_rekoo = By.id("com.koo.app:id/rekoo_imageview");
	public By btn_rekoono = By.id("com.koo.app:id/rekooNo");
	public By btn_rekooyes = By.id("com.koo.app:id/rekooYes");
	public By back_button = By.id("com.koo.app:id/layoutBack");
	public By rekoocounttext = By.id("com.koo.app:id/rekoo_textview");
	public By btn_whatsapp = By.id("com.koo.app:id/whatsapp_share_iv");
	public By btn_share = By.id("com.koo.app:id/generic_share_iv");
	public By webLink = By.id("com.koo.app:id/link_preview_link");
	public By btn_yes = By.xpath("//android.widget.TextView[@content-desc='positiveButton']");
	public By btn_no = By.xpath("//android.widget.TextView[@content-desc='negativeButton']");

	public String profile_icon_Name = "Profile icon";
	public String postButton_Name = "Post button";
	public String mlkButton_Name = "";
	public String reeKooIcon_Name = "ReKoo button";
	public String reeKooNoButton_Name = "ReKoo No button";
	public String likeCount_Name = "Count of Likes";
	public String reeKooCount_Name = "";
	public String atTheRatePopUp_Name = "first @ at the rate result from popup";
	public String addToFavoriteButton_Name = "";
	public String saveKooRemoveKooText_Name = "Remove Save Koo button on koo card after saving the koo";
	public String kooTitle_Name = "Koo Title";
	public String editProfileButton_Name = "Edit button from Profile page";
	public String nameField_Name = "Name field on Edit Profile page";
	public String handleField_Name = "Handle field on Edit Profile page";
	public String professionField_Name = "Profession field on Edit Profile page";
	public String plusFollowButton_Name = "(+) follow button on right side of koo on feed page";
	public String channel_Name = "";
	public String title_Name = "Actual title of posted koo";
	public String image_Name = "koo media image";
	public String btn_dots_Name = "two dots on koo";
	public String btn_play_Name = "";
	public String btn_like_Name = "Like button";
	public String likeCountText_Name = "";
	public String btn_comment_Name = "Comment button";
	public String btn_commentText_Name = "";
	public String comment_txt_Name = "";
	public String comment_post_Name = "";
	public String CommentCountText_Name = "";
	public String btn_comment1_Name = "";
	public String btn_rekoo_Name = "";
	public String btn_rekoono_Name = "";
	public String btn_rekooyes_Name = "";
	public String back_button_Name = "";
	public String rekoocounttext_Name = "";
	public String btn_whatsapp_Name = "";
	public String btn_share_Name = "";
	public String webLink_Name = "Web Link on Koo";

	/**
	 * This method is to verify Name, Handle and profession fields on Edit profile
	 * page
	 *
	 * @return
	 */
	public KooCardPage verifyUserNameHandleProfessionFields() {
		mobileActions.swipeUsingID("float_name");
		mobileActions.waitForVisible(nameField);
		Assert.assertTrue(mobileActions.isDisplayed(nameField, nameField_Name));
		mobileActions.swipeUsingID("float_handle");
		mobileActions.waitForVisible(handleField);
		Assert.assertTrue(mobileActions.isDisplayed(handleField, handleField_Name));
		mobileActions.swipeUsingID("float_profession");
		mobileActions.waitForVisible(professionField);
		Assert.assertTrue(mobileActions.isDisplayed(professionField, professionField_Name));
		return this;
	}

	/**
	 * This method is to verify time stamp on right side of koo card
	 *
	 * @return
	 */
	public KooCardPage verifyTimeStampOnRightOfKooCard() {
		mobileActions.swipeUsingID("koo_time_creation_tv");
		mobileActions.waitForVisible(homeScreenTabPage.kooCreationTimeStamp);
		Assert.assertTrue(mobileActions.isDisplayed(homeScreenTabPage.kooCreationTimeStamp,
				homeScreenTabPage.kooCreationTimeStamp_Name));
		return this;
	}

	/**
	 * This method is to verify + follow button on right side of koo on feed page
	 *
	 * @return
	 */
	public KooCardPage verifyPlusFollowButtonOnRightSideOfKoo() {
		mobileActions.swipeUsingID("tvFollowStatus");
		mobileActions.waitForVisible(plusFollowButton);
		Assert.assertTrue(mobileActions.isDisplayed(plusFollowButton, plusFollowButton_Name));
		return this;
	}

	/**
	 * This method is to verify + follow button on right side of koo on feed page
	 *
	 * @return
	 */
	public KooCardPage verifyOnClickPlusFollowButtonUserShouldBeFollowedAndViewKooBtn() {
		mobileActions.swipeUsingID("tvFollowStatus");
		mobileActions.swipeUp(1);
		mobileActions.waitForVisible(plusFollowButton);
		mobileActions.click(plusFollowButton, plusFollowButton_Name);
		Assert.assertTrue(
				mobileActions.isDisplayed(newUserFlowPage.miniPillButton, newUserFlowPage.miniPillButton_Name));
		// Now, verify user is followed
		mobileActions.waitForVisible(kooCreationPage.menu_drafthamberger);
		mobileActions.click(kooCreationPage.menu_drafthamberger, kooCreationPage.menu_drafthamberger_Name);
		mobileActions.click(profileScreenPage.btn_followingInPublicProfile,
				profileScreenPage.btn_followingInPublicProfile_Name);
		mobileActions.click(kooCreationPage.btn_yes, kooCreationPage.btn_yes_Name);
		Assert.assertTrue(mobileActions.isDisplayed(plusFollowButton, plusFollowButton_Name));
		return this;
	}

	/**
	 * This method is to Verify Save Koo button on koo card
	 *
	 * @return
	 */
	public KooCardPage verifySaveKooIcon() {
		mobileActions.swipeUsingID("btnAddToFavorite");
		mobileActions.swipeUp(1);
		mobileActions.waitForVisible(profileScreenPage.btn_saved);
		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_saved, profileScreenPage.btn_saved_Name));
		return this;
	}

	/**
	 * This method is to verify user can save the koo and remove the saved koo
	 *
	 * @return
	 */
	public KooCardPage verifyUserCanSaveKoo(String removeSavedKooText) {
		mobileActions.click(profileScreenPage.btn_saved, profileScreenPage.btn_saved_Name);
		mobileActions.click(btn_dots, btn_dots_Name);
		Assert.assertTrue(mobileActions.isDisplayed(saveKooRemoveKooText, removeSavedKooText));

		// Now, unsaved the koo
		mobileActions.click(addToFavoriteButton, addToFavoriteButton_Name);
		return this;
	}

	/**
	 * This method is to verify posted koo title
	 *
	 * @param expectedKooTitle
	 * @return
	 */
	public KooCardPage verifyKooTitle(String expectedKooTitle) {
		mobileActions.waitForVisible(title);
		mobileActions.isDisplayed(title, title_Name);
		Assert.assertEquals(mobileActions.getText(title, title_Name, true).trim(), expectedKooTitle);
		return this;
	}

	/**
	 * This method is to verify koo image/ media
	 *
	 * @return
	 */
	public KooCardPage verifyKooMedia() {
		mobileActions.waitForVisible(image);
		Assert.assertTrue(mobileActions.isDisplayed(image, image_Name), "Koo Image media is not showing");
		return this;
	}

	public KooCardPage createKooWithHashTagAndAtTheRate(String language, String hashTag, String atTheRate,
			String postButton) {
		mobileActions.isDisplayed(kooCreationPage.btn_plus, kooCreationPage.btn_plus_Name);
		mobileActions.click(kooCreationPage.btn_plus, kooCreationPage.btn_plus_Name);
		mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, hashTag);
		mobileActions.isDisplayed(hashTagScreenPage.hasTag_PopUp, hashTagScreenPage.hasTag_PopUp_Name);
		mobileActions.click(hashTagScreenPage.hasTag_PopUp, hashTagScreenPage.hasTag_PopUp_Name);
		mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, atTheRate);
		mobileActions.isDisplayed(atTheRatePopUp, atTheRatePopUp_Name);
		mobileActions.click(atTheRatePopUp, atTheRatePopUp_Name);
		mobileActions.isDisplayed(kooCreationPage.btn_Post, kooCreationPage.btn_post_Name);
		mobileActions.click(kooCreationPage.btn_Post, kooCreationPage.btn_post_Name);
		if (language.equalsIgnoreCase("English")) {
			mobileActions.waitForVisible(kooCreationPage.btn_okScheduleKoo);
			mobileActions.isDisplayed(kooCreationPage.btn_okScheduleKoo, kooCreationPage.btn_okScheduleKoo_Name);
			mobileActions.click(kooCreationPage.btn_okScheduleKoo, kooCreationPage.btn_okScheduleKoo_Name);
			mobileActions.waitForVisible(kooDeatilDetailScreenPage.languageDoneButton);
			mobileActions.isDisplayed(kooDeatilDetailScreenPage.languageDoneButton,
					kooDeatilDetailScreenPage.languageDoneButton_Name);
			mobileActions.click(kooDeatilDetailScreenPage.languageDoneButton,
					kooDeatilDetailScreenPage.languageDoneButton_Name);
		}
		return this;
	}

	/**
	 * This method is to verify koo tile starts with hashtag and at the rate
	 *
	 * @param hashTag
	 * @param atTheRate
	 * @return
	 */
	public KooCardPage verifyKooTitleStartsWithHashTagAndAtTheRate(String hashTag, String atTheRate) {
		String actualText = mobileActions.getText(title, title_Name, true).trim();
		String[] array = actualText.split(" ");
		Assert.assertTrue(array[0].startsWith(hashTag), "Hash Tag is showing successfully before the koo text");
		Assert.assertTrue(array[1].startsWith(atTheRate), "at the rate @ is showing successfully before the koo text");
		return this;
	}

	/**
	 * This method is to Verify Save Koo button on koo card
	 *
	 * @return
	 */
	public KooCardPage verifyWebLinkOnKoo() {
		mobileActions.swipeUsingID("link_preview_link");
		mobileActions.waitForVisible(webLink);
		Assert.assertTrue(mobileActions.isDisplayed(webLink, webLink_Name));
		return this;
	}

	/**
	 * This method is to Verify Save Koo button on koo card
	 *
	 * @return
	 */
	public KooCardPage verifyKooImage() {
		mobileActions.swipeUsingID("single_image");
		mobileActions.waitForVisible(homeScreenTabPage.kooImage);
		Assert.assertTrue(mobileActions.isDisplayed(homeScreenTabPage.kooImage, homeScreenTabPage.kooImage_Name));
		return this;
	}

	/**
	 * This method is to click on koo title as per the specific koo post title
	 *
	 * @param kooText
	 * @return
	 */
	public KooCardPage clickOnKooPost(String kooText) {
		mobileActions.swipeUsingText(kooText);
		mobileActions.waitForVisible(kooTitle);
		Assert.assertTrue(mobileActions.isDisplayed(kooTitle, kooTitle_Name));
		mobileActions.click(kooTitle, kooTitle_Name);
		return this;
	}

	/**
	 * This method is to like koo and verify count
	 *
	 * @param expectedLikeCount
	 * @return
	 */
	public KooCardPage verifyLikeCount(String expectedLikeCount) {
		CommonHelper.clickOnLikeIcon();
		String actualLikeCount = mobileActions.getText(likeCount, likeCount_Name, true).trim();
		Assert.assertEquals(actualLikeCount, expectedLikeCount, "Like count is not correct expected is = "
				+ expectedLikeCount + " actual is showing = " + actualLikeCount);
		return this;
	}

	/**
	 * This method is to do rekoo and verify count
	 *
	 * @param expectedReKooCount
	 * @return
	 */
	public KooCardPage verifyReKooCount(String expectedReKooCount) {
		CommonHelper.clickOnReKooIconAndNoReKooButton();
		String actualReKooCount = mobileActions.getText(reeKooCount, reeKooCount_Name, true).trim();
		Assert.assertEquals(actualReKooCount, expectedReKooCount, "ReKoo count is not correct expected is = "
				+ expectedReKooCount + " actual is showing = " + actualReKooCount);
		return this;
	}

	/**
	 * This method is to write comment and verify comment count
	 *
	 * @param commentText
	 * @param expectedCommentCount
	 * @return
	 */
	public KooCardPage verifyCommentCount(String commentText, String expectedCommentCount) {
		CommonHelper.clickOnCommentIconAndPostComment(commentText);
		CommonHelper.clickOnRefreshIconToRefreshComments();
		String actualCommentCount = mobileActions.getText(kooDetailScreenPage.commentTextCountForKoo,
				kooDetailScreenPage.commentTextCountForKoo_Name, true).trim();
		Assert.assertEquals(actualCommentCount, expectedCommentCount, "Comment count is not correct expected is = "
				+ expectedCommentCount + " actual is showing = " + actualCommentCount);
		return this;
	}
	/**
	 * This method is to write comment and verify comment count removed
	 */

}
