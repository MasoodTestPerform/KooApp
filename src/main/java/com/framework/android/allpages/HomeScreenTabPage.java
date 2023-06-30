package com.framework.android.allpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class HomeScreenTabPage {
	
	MobileActions mobileActions = null;
	UserBlockPage userBlockPage = null;
	HomeScreenTabPage homeScreenTabPage = null;
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	
	public void HomeScreenTabPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.homeScreenTabPage = new HomeScreenTabPage();
		this.hashTagScreenPage = new HashTagScreenPage();
		this.onBoardingFlowPage = new OnBoardingFlowPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.kooCreationPage = new KooCreationPage();
		
	}
	
	
	public By trendingTagsIcon = By.id("com.koo.app:id/trending_feed_imageview");
	public By timeElapsedForVideo = By.id("com.koo.app:id/time_elapsed");
	public By kooDetail = By.id("com.koo.app:id/topic_title_textview");
	public String commentsSectionHeading = "//android.widget.TextView[@text='###']";
	public By chatIcon = By.id("com.koo.app:id/lottie_messages");
	public By notificationIcon = By.id("com.koo.app:id/lottie_notification");
	public By startConversationButton = By.id("com.koo.app:id/tv_start_conversation");
	public By notificationPreferenceIcon = By.id("com.koo.app:id/notification_preferences");
	public By redDotIndicator = By.id("com.koo.app:id/custom_tab_indicator");
	public String redDotIndicatorNextTab = "((//android.widget.TextView[@text='###']//..//..//..)//following-sibling::android.widget.LinearLayout)//android.view.View[@resource-id='com.koo.app:id/custom_tab_indicator']";
	public By kooBirdIcon = By.id("com.koo.app:id/koo_bird");
	public By followButton = By.id("com.koo.app:id/itemfollowUser");
	public By viewKoosFromButton = By.id("com.koo.app:id/pillMainLayout");
	public By viewKoosFromProfileImage = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/pillMainLayout']//following-sibling::android.view.ViewGroup[@resource-id='com.koo.app:id/images_container']");
	public By fiveProfileIcons = By.xpath("(//android.view.ViewGroup[@resource-id='com.koo.app:id/images_container'])[1]/android.widget.ImageView");
	public By profileImageOfKoo = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/profile_image_holder']");
	public By dynamicBanner = By.id("com.koo.app:id/root_single_user_big");
	public By dynamicBannerText = By.id("com.koo.app:id/channel_name");
	public By trendingKooIcon = By.id("com.koo.app:id/iv_trending");
	public String trendingKooPageHeading = "//android.widget.TextView[@text='###']";
	public By refreshButtonOnTrendingKooPage = By.id("com.koo.app:id/btnRefresh");
	public By kooCreationTimeStamp = By.id("com.koo.app:id/koo_time_creation_tv");
	public By likeHolderIconOnReactionBar = By.id("com.koo.app:id/like_holder_constraint");
	public By commentHolderIconOnReactionBar = By.id("com.koo.app:id/comment_holder_constraint");
	public By rekooHolderIconOnReactionBar = By.id("com.koo.app:id/rekoo_holder_constraint");
	public By whatsappShareIconOnReactionBar = By.id("com.koo.app:id/whatsapp_holder_constraint");
	public By shareIconOnReactionBar = By.id("com.koo.app:id/share_holder_constraint");
	public By kooText = By.id("com.koo.app:id/topic_title_textview");
	public By kooImage = By.id("com.koo.app:id/single_image");
	
	public String trendingTagsIcon_Name = "Trending Tag fire icon on main page";
	public String timeElapsedForVideo_Name = "Time Elapsed For Video";
	public String kooDetail_Name = "";
	public String commentsSectionHeading_Name = "";
	public String chatIcon_Name = "Chat button from bottom bar";
	public String notificationIcon_Name = "Notification button from bottom bar";
	public String startConversationButton_Name = "Start Conversation button";
	public String notificationPreferenceIcon_Name = "Notification Preference Icon";
	public String redDotIndicator_Name = "Red Dot Indicator";
	public String redDotIndicatorNextTab_Name = "Red Dot Indicator on next tab";
	public String kooBirdIcon_Name = "Koo Bird Icon";
	public String followButton_Name = "";
	public String viewKoosFromButton_Name = "";
	public String viewKoosFromProfileImage_Name = "";
	public String fiveProfileIcons_Name = "";
	public String profileImageOfKoo_Name = "";
	public String dynamicBanner_Name = "dynamic banner";
	public String dynamicBannerText_Name = "Dynamic Banner";
	public String trendingKooIcon_Name = "Trending Koo icon from home/feed page";
	public String trendingKooPageHeading_Name = "";
	public String refreshButtonOnTrendingKooPage_Name = "Refresh icon/button";
	public String kooCreationTimeStamp_Name = "koo Creation TimeStamp";
	public String likeHolderIconOnReactionBar_Name = "Like Holder Icon on reaction bar";
	public String commentHolderIconOnReactionBar_Name = "";
	public String rekooHolderIconOnReactionBar_Name = "Re-Koo Holder Icon on reaction bar";
	public String whatsappShareIconOnReactionBar_Name = "Whats App Share Icon on reaction bar";
	public String shareIconOnReactionBar_Name = "share Icon on reaction bar";
	public String kooText_Name = "koo text";
	public String kooImage_Name = "";
	
	
	

	/**
	 * This method is to verify home icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyHomeIcon() {
		mobileActions.waitForVisible(userBlockPage.homeButton);
		boolean diaplyFlag = mobileActions.isDisplayed(userBlockPage.homeButton, userBlockPage.homeButton_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Home Icon in Koo", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify trending tab fire icon from main page
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyTrendingTagIcon() {
		mobileActions.waitForVisible(homeScreenTabPage.trendingTagsIcon);
		
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.trendingTagsIcon, homeScreenTabPage.trendingTagsIcon_Name );
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Trending Tag fire icon on main page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify search icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifySearchIcon() {
		mobileActions.waitForVisible(hashTagScreenPage.search_icon);
		boolean diaplyFlag = mobileActions.isDisplayed(hashTagScreenPage.search_icon, hashTagScreenPage.search_icon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Search icon on main page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify chat icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyChatIcon() {
		mobileActions.waitForVisible(homeScreenTabPage.chatIcon);
		
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.chatIcon, homeScreenTabPage.chatIcon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Chat icon", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify notification icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationIcon() {
		mobileActions.waitForVisible(homeScreenTabPage.notificationIcon);
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.notificationIcon, homeScreenTabPage.notificationIcon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Notification icon on bottom ba", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyStartConversationButton() {
		mobileActions.waitForVisible(homeScreenTabPage.startConversationButton);
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.startConversationButton,homeScreenTabPage.startConversationButton_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Start Conversation Page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationPreferencesBtn() {
		mobileActions.waitForVisible(homeScreenTabPage.notificationPreferenceIcon);
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.notificationPreferenceIcon,homeScreenTabPage.notificationPreferenceIcon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Notification page", true, BaseTest.mobileDriver.get(), true);
				
				
		return this;
	}

	/**
	 * This method is to verify header bar tabs text
	 *
	 * @param expectedTabText
	 * @return
	 */
	public HomeScreenTabPage verifyHeaderTabs(List<String> expectedTabText) {
		for (int i = 0; i < expectedTabText.size(); i++) {
			WebElement elementsOne = BaseTest.mobileDriver.get().findElement(mobileActions
					.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", expectedTabText.get(i)));
			mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i)));
			boolean diaplyFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i)),onBoardingFlowPage.feedTab_Text_Name);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of header bar tab expected is = " + expectedTabText.get(i), true, BaseTest.mobileDriver.get(), true);
			
			mobileActions.swipeLeftOrRight(elementsOne, "LEFT");
		}
		
		return this;
	}

	/**
	 * This method is to verify red dot indicator
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyRedDotIndicator() {
		mobileActions.waitForVisible(homeScreenTabPage.redDotIndicator);
		
		boolean diaplyFlag = mobileActions.isDisplayed(homeScreenTabPage.redDotIndicator, homeScreenTabPage.redDotIndicator_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Red Dot Indicator", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify red dot on next tab
	 *
	 * @param expectedTabText
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyRedDotOnNextTabAndDisappearForLastTab(List<String> expectedTabText, String lastTab)
			 {
		boolean displayFlag = false;
		for (int i = 0; i < expectedTabText.size(); i++) {
			mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath",
					expectedTabText.get(i)), "Click on next tab = " + expectedTabText.get(i));
			
				
			mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(homeScreenTabPage.redDotIndicatorNextTab, "xpath", expectedTabText.get(i)));
			displayFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(homeScreenTabPage.redDotIndicatorNextTab, "xpath", expectedTabText.get(i)), homeScreenTabPage.redDotIndicatorNextTab_Name);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Red Dot Indicator on next tab when it's previous tab is selected. Expected:"+expectedTabText.get(i), true, BaseTest.mobileDriver.get(), true);
					
			
		}
		
		mobileActions.swipeUp(2);
		return this;
	}

	/**
	 * This method is to click on any tab from home page
	 *
	 * @param tabName
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage clickOnAnyTabFromHomePage(String tabName)  {
		mobileActions.waitForVisible(
				mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName));
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName),
				"Click on tab = " + tabName);
		return this;
	}

	/**
	 * This method is to swipe down and then click on any tab and verify user lands
	 * on top pf the page
	 *
	 * @param tabName
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyTopOfThePage(String tabName){
		mobileActions.swipeUp(5);
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName),
				"Click on tab = " + tabName);
		boolean displayFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName), homeScreenTabPage.redDotIndicatorNextTab_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Feed tab. Expected:"+ tabName, true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify dynamic banner displaying
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyDynamicBanner() {
		mobileActions.swipeUsingID("root_single_user_big");
		
		boolean displayFlag = mobileActions.isDisplayed(homeScreenTabPage.dynamicBanner, homeScreenTabPage.dynamicBanner_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of dynamic banner is displaying", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify banner page is displaying
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyBannersOnFeedPage(String regexExpression) {
		String actualText = mobileActions
				.getText(homeScreenTabPage.dynamicBannerText, homeScreenTabPage.dynamicBannerText_Name, true);
		mobileActions.click(homeScreenTabPage.dynamicBannerText, homeScreenTabPage.dynamicBannerText_Name);
		String expectedText = mobileActions
				.getText(userBlockPage.profileName, userBlockPage.profileName_Name, true);
		actualText = actualText.split("  ")[0].split(regexExpression)[0];
		expectedText = expectedText.split("  ")[0].split(regexExpression)[0];
		
		BaseTest.utilObj.get().getAssertManager().sAssertContains(actualText, expectedText, "Validation of Banners On Feed Page. Expected match:"+expectedText, true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify trending koo page after clicking on trending tag
	 * icon from home/ feed page
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyTrendingKooPageHeading(String expectedTrendingKooPageHeading) {
		boolean displayFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(homeScreenTabPage.trendingKooPageHeading, "xpath", expectedTrendingKooPageHeading), expectedTrendingKooPageHeading);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Trending Koo page heading.Heading:"+expectedTrendingKooPageHeading, true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to click on settings button
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage clickTrendingKooIcon() {
		mobileActions.waitForVisible(homeScreenTabPage.refreshButtonOnTrendingKooPage);
		mobileActions.click(homeScreenTabPage.refreshButtonOnTrendingKooPage, homeScreenTabPage.refreshButtonOnTrendingKooPage_Name);
		return this;
	}

	/**
	 * This method is to verify dynamic banner displaying
	 *
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public HomeScreenTabPage verifyKoosInRankOnFeedPage() {
		mobileActions.swipeUsingID("koo_time_creation_tv");
		String currentKooCreationTimeText = mobileActions
				.getText(homeScreenTabPage.kooCreationTimeStamp, homeScreenTabPage.kooCreationTimeStamp_Name, true);
		if (!currentKooCreationTimeText.equalsIgnoreCase("Just Now")) {
			String currentKooCreationTimeText_1 = currentKooCreationTimeText.replaceAll("[^0-9]", "");
			CommonHelper.clickOnHomeButton();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			mobileActions.swipeDown(5);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			mobileActions.swipeUsingID("koo_time_creation_tv");
			BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String newKooCreationTimeText = mobileActions
					.getText(homeScreenTabPage.kooCreationTimeStamp, homeScreenTabPage.kooCreationTimeStamp_Name, true);
			String newKooCreationTimeText_1 = newKooCreationTimeText.replaceAll("[^0-9]", "");
			
			boolean istrue = Integer.parseInt(newKooCreationTimeText_1) < Integer.parseInt(currentKooCreationTimeText_1);
			
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(istrue, true, "Validation of Latest koo is not showing on top. Hence koos are not refreshing after doing the refresh, \"\r\n"
					+ "							+ \", the old koo/expected creation time is = \" + currentKooCreationTimeText_1\r\n"
					+ "							+ \" ,latest koo/actual creation time is = \" + newKooCreationTimeText_1\r\n"
					+ "							+ \" , the latest koo creation time should be less than the old koo creation time", true, BaseTest.mobileDriver.get(), true);
			
			
		} else {			
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "PASS", "Latest Koo is showing on top and time is = " + currentKooCreationTimeText, true, BaseTest.mobileDriver.get());
		}

		return this;
	}

	/**
	 * This method is to verify koo text, media, reaction bar icons
	 *
	 * @return
	 * @throws InterruptedException
	 */
	public HomeScreenTabPage verifyReactionBarIcons() throws InterruptedException {
		mobileActions.swipeDown(5);
		mobileActions.swipeUsingID("like_holder_constraint");
		boolean displayFlag = mobileActions.isDisplayed(homeScreenTabPage.likeHolderIconOnReactionBar, homeScreenTabPage.likeHolderIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Comment Holder Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = mobileActions.isDisplayed(homeScreenTabPage.rekooHolderIconOnReactionBar, homeScreenTabPage.rekooHolderIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Re-Koo Holder Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = mobileActions.isDisplayed(homeScreenTabPage.whatsappShareIconOnReactionBar, homeScreenTabPage.whatsappShareIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Whats App Share Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = mobileActions.isDisplayed(homeScreenTabPage.shareIconOnReactionBar, homeScreenTabPage.shareIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of share Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify koo text
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooText() {
		mobileActions.swipeUsingID("topic_title_textview");
		boolean displayFlag = mobileActions.isDisplayed(homeScreenTabPage.kooText, homeScreenTabPage.kooText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of koo text", false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify koo media
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooMedia() {
		mobileActions.swipeUsingID("play");
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		boolean isPlay = mobileActions.isElmPresent(By.id("com.koo.app:id/play"));
		if (isPlay) {
			mobileActions.click(By.id("com.koo.app:id/play"), "Click on Play button to play video");
		}
		mobileActions.swipeUp(1);
		String actualTextOfTimeElapsed = mobileActions
				.getText(homeScreenTabPage.timeElapsedForVideo, homeScreenTabPage.timeElapsedForVideo_Name, true);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		String expectedTextOfTimeElapsed = mobileActions
				.getText(homeScreenTabPage.timeElapsedForVideo, homeScreenTabPage.timeElapsedForVideo_Name, true);
		int actualTime = Integer.parseInt(actualTextOfTimeElapsed.split(":")[1]);
		int expectedTime = Integer.parseInt(expectedTextOfTimeElapsed.split(":")[1]);
		boolean isTrue = actualTime > expectedTime;
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isTrue, true, "Validation of Koo Media/ Video is playing and actual time is = " + actualTime, false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify comment details section
	 * 
	 * @param commentsSectionHeading
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyCommentsDetailSection(String commentsSectionHeading, String commentText,
			String postButton, String kooText)  {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		mobileActions.swipeUp(1);
		mobileActions.swipeUpFindElement(10,
				mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedCommentIcon, "xpath", kooText));
		mobileActions.click(kooDetailScreenPage.writeCommentsBar, kooDetailScreenPage.writeCommentsBar_Name);
		mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name,
				commentText);
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", postButton),
				"Click on Post Button");
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		mobileActions.swipeUpFindElement(10,
				mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedKooText, "xpath", kooText));
		mobileActions.click(
				mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedCommentIcon, "xpath", kooText),
				"Click on View Comment Button");
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		
		boolean displayFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(homeScreenTabPage.commentsSectionHeading, "xpath", commentsSectionHeading),commentsSectionHeading);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of comment section heading:"+commentsSectionHeading, false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify koo's should be refreshed under home tab
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public HomeScreenTabPage verifyRefreshedKoo() throws InterruptedException {
		String oldKoo = mobileActions
				.getText(homeScreenTabPage.kooDetail, homeScreenTabPage.kooDetail_Name, true);
		mobileActions.swipeUp(2);
		mobileActions.swipeDown(60);

		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Refreshed the page multiple times and thenget text of latest koo", false, BaseTest.mobileDriver.get());
		BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		String refreshedKoo = mobileActions
				.getText(homeScreenTabPage.kooDetail, homeScreenTabPage.kooDetail_Name, true);

		// Verify Old Koo and New/ Refreshed Koo Text should not same/equal
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Verify Old Koo and New/ Refreshed Koo Text should not same/equal", false, BaseTest.mobileDriver.get());
		Boolean isTrue = !oldKoo.equalsIgnoreCase(refreshedKoo);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isTrue, true, "Validation of Koo refreshed. oldKoo:"+oldKoo+" and new refreshed Koo:"+refreshedKoo, true, BaseTest.mobileDriver.get(), false);
		
		return this;
	}
	

}
