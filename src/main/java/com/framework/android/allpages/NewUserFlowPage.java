package com.framework.android.allpages;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import com.koo.framework.AssertManager;
import com.koo.framework.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class NewUserFlowPage {

	MobileActions mobileActions = null;
	UserBlockPage userBlockPage = null;
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	HomeScreenTabPage homeScreenTabPage = null;
	AssertManager asserManager = null;

	String actualText;

	public NewUserFlowPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.onBoardingFlowPage = new OnBoardingFlowPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.kooCreationPage = new KooCreationPage();
		this.homeScreenTabPage = new HomeScreenTabPage();
		this.asserManager = new AssertManager();
	}

	public By topFiftyBulkFollowBtn = By.id("com.koo.app:id/tv_follow_all_text");
	public By miniPillButton = By.id("com.koo.app:id/pillMainLayout");
	public By followAll = By.xpath("//android.widget.TextView[@text='50+']");
	public By followAllButton = By.xpath("com.koo.app:id/lay_follow_all");
	public By suggestedPeople = By.id("com.koo.app:id/text_header_suggestpeople");
	public By checkBox = By.xpath("//android.widget.CheckBox[@resource-id='com.koo.app:id/checkbox']");
	public By followPeopleButton = By.id("com.koo.app:id/follow_action_btn");
	public By referNowButton = By.id("com.koo.app:id/btn_refer_now_big");
	public By exploreAllProfiles = By.id("com.koo.app:id/tv_explore_text");
	public By segmentBulkFollow = By.id("com.koo.app:id/category_bulk_follow_recyclerview");

	public String topFiftyBulkFollowBtn_Name = "";
	public String miniPillButton_Name = "View Koo button";
	public String followAll_Name = "50+ follow all link";
	public String followAllButton_Name = "Follow All button for new user without selecting any profile";
	public String suggestedPeople_Name = "Suggested people popup";
	public String checkBox_Name = "Checkbox";
	public String followPeopleButton_Name = "follow people button at last of feed page";
	public String referNowButton_Name = "Refer now button";
	public String exploreAllProfiles_Name = "Explore All profiles button";
	public String segmentBulkFollow_Name = "Segment Bulk Follow profiles button";

	/**
	 * This method is to verify follow all button for bulk follow
	 *
	 * @return
	 */
	public NewUserFlowPage verifyTopFiftyBulkFollowButton() {
		mobileActions.swipeUsingID("tv_follow_all_text");
		mobileActions.waitForVisible(topFiftyBulkFollowBtn);
		Assert.assertTrue(mobileActions.isDisplayed(topFiftyBulkFollowBtn, topFiftyBulkFollowBtn_Name));
		return this;
	}

	/**
	 * This method is to click on follow all button
	 *
	 * @return
	 * @throws IOException
	 */
	public NewUserFlowPage clickFollowAllButton() throws IOException {
		mobileActions.click(topFiftyBulkFollowBtn, topFiftyBulkFollowBtn_Name);
		return this;
	}

	/**
	 * This method is to verify user can unfollow the profile
	 *
	 * @param expectedValue
	 * @return
	 * @throws IOException
	 */
	public NewUserFlowPage verifySelectUnSelectFollowUser(String expectedValue) throws IOException {
		mobileActions.click(followAll, followAll_Name);
		mobileActions.waitForVisible(suggestedPeople);
		Assert.assertTrue(mobileActions.isDisplayed(suggestedPeople, suggestedPeople_Name));
		mobileActions.waitForVisible(checkBox);
		mobileActions.click(checkBox, checkBox_Name);
		String actualValue = mobileActions.getAttribute(checkBox, "checked", checkBox_Name, true);
		Assert.assertEquals(actualValue, expectedValue);
		return this;
	}

	/**
	 * This method is to Verify follow people button at last of feed page
	 * 
	 * @return
	 */
	public NewUserFlowPage verifyFollowAPeopleButton() {
		mobileActions.swipeUsingID("follow_action_btn");
		mobileActions.waitForVisible(followPeopleButton);
		Assert.assertTrue(mobileActions.isDisplayed(followPeopleButton, followPeopleButton_Name));
		return this;
	}

	/**
	 * This method is to click on continue button
	 *
	 * @return
	 * @throws IOException
	 */
	public NewUserFlowPage clickContinueButton() throws InterruptedException {
		mobileActions.waitForVisible(onBoardingFlowPage.continueButton);
		Assert.assertTrue(
				mobileActions.isDisplayed(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name));
		mobileActions.click(onBoardingFlowPage.continueButton, onBoardingFlowPage.continueButton_Name);
		return this;
	}

	/**
	 * This method is to verify refer now button on reward widget for new user
	 * 
	 * @return
	 */
	public NewUserFlowPage verifyReferNowButton() {
		mobileActions.swipeUsingID("btn_refer_now_big");
		Assert.assertTrue(mobileActions.isDisplayed(referNowButton, referNowButton_Name));
		return this;
	}

	/**
	 * This method is to verify follow all button for new user
	 * 
	 * @return
	 */
	public NewUserFlowPage verifyFollowAllButton() {
		mobileActions.swipeUsingID("lay_follow_all");
		mobileActions.waitForVisible(followAllButton);
		Assert.assertTrue(mobileActions.isDisplayed(followAllButton, followAllButton_Name));
		mobileActions.waitForVisible(followAll);
		Assert.assertTrue(mobileActions.isDisplayed(followAll, followAll_Name));
		return this;
	}

	/**
	 * This method is to verify explore all button for new user
	 * 
	 * @return
	 */
	public NewUserFlowPage verifyExploreAllButton() {
		mobileActions.swipeUsingID("lay_follow_all");
		mobileActions.waitForVisible(exploreAllProfiles);
		Assert.assertTrue(mobileActions.isDisplayed(exploreAllProfiles, exploreAllProfiles_Name));
		return this;
	}

	/**
	 * This method is to verify segment bulk follow all button for new user
	 * 
	 * @return
	 */
	public NewUserFlowPage verifySegmentBulkFollow() {
		mobileActions.swipeUsingID("category_bulk_follow_recyclerview");
		mobileActions.waitForVisible(segmentBulkFollow);
		Assert.assertTrue(mobileActions.isDisplayed(segmentBulkFollow, segmentBulkFollow_Name));
		return this;
	}

	/*
	 * public NewUserFlowPage verifyAllUserFollowed(int expectedSizeOfFollowAllBtn,
	 * String expectedCountOfFollowedUsers) throws InterruptedException, IOException
	 * { mobileActions.swipeUsingID("lay_follow_all");
	 * mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName(
	 * "NewUserFlow", "followAllButton"), "Click on 50+ follow all link");
	 * Thread.sleep(30000); List<WebElement> followAllButton =
	 * DriverFactory.getInstance().getMobileDriver()
	 * .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "followAllButton")); Assert.assertEquals(followAllButton,
	 * expectedSizeOfFollowAllBtn,
	 * "Follow all button is still visible after clicking that button which is not correct"
	 * ); CommonHelper.clickOnHomeButton(); CommonHelper.clickOnProfile(); String
	 * actualCountOfFollowedUsers = mobileActions.getText(
	 * MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "allFollowedUsersCount"), "Get all followed users count");
	 * Assert.assertEquals(actualCountOfFollowedUsers, expectedCountOfFollowedUsers,
	 * "Followed all 50+ users count is not correct on profile page the expected count is  = "
	 * + expectedCountOfFollowedUsers + " the actual count is showing - " +
	 * actualCountOfFollowedUsers); return this; }
	 */

	/*
	 * public NewUserFlowPage verifySegmentBulkFollowAction(int expectedSize) {
	 * mobileActions.swipeUsingID("category_bulk_follow_recyclerview");
	 * mobileActions.swipeUp(1); String actualHeadingOfSBFSection =
	 * mobileActions.getText(
	 * MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "segmentBulkFollowCategoryText"),
	 * "Get heading of segment bulk follow widget");
	 * mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName(
	 * "NewUserFlow", "segmentBulkFollowButton"),
	 * "Click on segment bulk follow all button"); String
	 * actualHeadingOfSBFSection_afterFollowed = mobileActions.getText(
	 * MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "segmentBulkFollowCategoryText"),
	 * "Get heading of segment bulk follow widget after followed");
	 * Assert.assertTrue(!(actualHeadingOfSBFSection.equalsIgnoreCase(
	 * actualHeadingOfSBFSection_afterFollowed)),
	 * "The SBF category heading is still visible after following, which is incorrect"
	 * ); Assert.assertTrue( mobileActions.isDisplayed(
	 * MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "miniPillButton"), "Verify Mini pill button is visible after following SBF"),
	 * "Mini pill button is not visible on new user after doing SBF");
	 * 
	 * // Get images size of mini pill popup List<WebElement> actualSize =
	 * DriverFactory.getInstance().getMobileDriver()
	 * .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow",
	 * "smallImagesOnMiniPill")); Assert.assertEquals(actualSize, expectedSize,
	 * "mini pill images size is not correct expected count is  = " + expectedSize +
	 * " the actual count is showing - " + actualSize); return this; }
	 */
}
