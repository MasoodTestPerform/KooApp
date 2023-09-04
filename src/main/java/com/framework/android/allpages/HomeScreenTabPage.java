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
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	
	public HomeScreenTabPage(){
		mobileActions = BaseTest.utilObj.get().getMobileActions();
		userBlockPage = new UserBlockPage();
		hashTagScreenPage = new HashTagScreenPage();
		onBoardingFlowPage = new OnBoardingFlowPage();
		kooDetailScreenPage = new KooDetailScreenPage();
		kooCreationPage = new KooCreationPage();

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
	public By newKooBtn = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/circular_fab']");
	
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
	public String kooImage_Name = "Image on Koo";
	public String newKooBtn_Name = "new Koo button";
	
	
	

	/**
	 * This method is to verify home icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyHomeIcon() {
		mobileActions.waitForVisible(userBlockPage.homeButton);
		boolean diaplyFlag = this.mobileActions.isDisplayed(userBlockPage.homeButton, userBlockPage.homeButton_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Home Icon in Koo", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify trending tab fire icon from main page
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyTrendingTagIcon() {
		this.mobileActions.waitForVisible(trendingTagsIcon);
		
		boolean diaplyFlag = this.mobileActions.isDisplayed(trendingTagsIcon, trendingTagsIcon_Name );
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Trending Tag fire icon on main page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify search icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifySearchIcon() {
		this.mobileActions.waitForVisible(hashTagScreenPage.search_icon);
		boolean diaplyFlag = this.mobileActions.isDisplayed(hashTagScreenPage.search_icon, hashTagScreenPage.search_icon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Search icon on main page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify chat icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyChatIcon() {
		this.mobileActions.waitForVisible(chatIcon);
		
		boolean diaplyFlag = this.mobileActions.isDisplayed(chatIcon, chatIcon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Chat icon", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify notification icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationIcon() {
		this.mobileActions.waitForVisible(notificationIcon);
		boolean diaplyFlag = this.mobileActions.isDisplayed(notificationIcon, notificationIcon_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Notification icon on bottom ba", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyStartConversationButton() {
		this.mobileActions.waitForVisible(startConversationButton);
		boolean diaplyFlag = this.mobileActions.isDisplayed(startConversationButton,startConversationButton_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Start Conversation Page", true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationPreferencesBtn() {
		this.mobileActions.waitForVisible(notificationPreferenceIcon);
		boolean diaplyFlag = this.mobileActions.isDisplayed(notificationPreferenceIcon,notificationPreferenceIcon_Name);
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
			WebElement elementsOne = BaseTest.mobileDriver.get().findElement(this.mobileActions
					.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i)));
			this.mobileActions.waitForVisible(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i)));
			boolean diaplyFlag = this.mobileActions.isDisplayed(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i)),onBoardingFlowPage.feedTab_Text_Name);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of header bar tab expected is = " + expectedTabText.get(i), false, BaseTest.mobileDriver.get(), false);
			
			this.mobileActions.swipeLeftOrRight(elementsOne, "LEFT");
		}
		
		return this;
	}
	
	public void verifyNewKooButton() {
		String newKooDisplayed = this.mobileActions.getAttribute(newKooBtn, "displayed", newKooBtn_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(newKooDisplayed, "true", "Validation of new Koo button", true, BaseTest.mobileDriver.get(), true);		
	}
	
	public HomeScreenTabPage verifyHeaderTabsNotPresent(List<String> expectedTabText) {
		int  objCnt = 0;
		this.mobileActions.setImplicitWaitMinimum(1);
		for (int i = 0; i < expectedTabText.size(); i++) {
			this.mobileActions.swipeLeftToRight(1);
			objCnt = BaseTest.mobileDriver.get().findElements(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", expectedTabText.get(i))).size(); 
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(objCnt,0, "Validation of header bar tab not present and not expected TAB is = " + expectedTabText.get(i), false, BaseTest.mobileDriver.get(), false);
		}
		this.mobileActions.setImplicitNormal();
		return this;
	}

	/**
	 * This method is to verify red dot indicator
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyRedDotIndicator() {
		this.mobileActions.waitForVisible(redDotIndicator);
		
		boolean diaplyFlag = this.mobileActions.isDisplayed(redDotIndicator, redDotIndicator_Name);
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
			this.mobileActions.click(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath",
					expectedTabText.get(i)), "Click on next tab = " + expectedTabText.get(i));
			
				
			this.mobileActions.waitForVisible(this.mobileActions.returnByBasedOnPageNameAndObjectName(redDotIndicatorNextTab, "xpath", expectedTabText.get(i)));
			displayFlag = this.mobileActions.isDisplayed(this.mobileActions.returnByBasedOnPageNameAndObjectName(redDotIndicatorNextTab, "xpath", expectedTabText.get(i)), redDotIndicatorNextTab_Name);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Red Dot Indicator on next tab when it's previous tab is selected. Expected:"+expectedTabText.get(i), true, BaseTest.mobileDriver.get(), true);
					
			
		}
		
		this.mobileActions.swipeUp(2);
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
		this.mobileActions.waitForVisible(
				this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName));
		this.mobileActions.click(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName),
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
		this.mobileActions.swipeUp(5);
		this.mobileActions.click(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName),
				"Click on tab = " + tabName);
		boolean displayFlag = this.mobileActions.isDisplayed(this.mobileActions.returnByBasedOnPageNameAndObjectName(onBoardingFlowPage.feedTab_Text, "xpath", tabName), redDotIndicatorNextTab_Name);
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
		this.mobileActions.swipeUsingID("root_single_user_big");
		
		boolean displayFlag = this.mobileActions.isDisplayed(dynamicBanner, dynamicBanner_Name);
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
		String actualText = this.mobileActions
				.getText(dynamicBannerText, dynamicBannerText_Name, true);
		this.mobileActions.click(dynamicBannerText, dynamicBannerText_Name);
		String expectedText = this.mobileActions
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
		boolean displayFlag = this.mobileActions.isDisplayed(this.mobileActions.returnByBasedOnPageNameAndObjectName(trendingKooPageHeading, "xpath", expectedTrendingKooPageHeading), expectedTrendingKooPageHeading);
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
		this.mobileActions.waitForVisible(refreshButtonOnTrendingKooPage);
		this.mobileActions.click(refreshButtonOnTrendingKooPage, refreshButtonOnTrendingKooPage_Name);
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
		this.mobileActions.swipeUsingID("koo_time_creation_tv");
		String currentKooCreationTimeText = this.mobileActions
				.getText(kooCreationTimeStamp, kooCreationTimeStamp_Name, true);
		if (!currentKooCreationTimeText.equalsIgnoreCase("Just Now")) {
			String currentKooCreationTimeText_1 = currentKooCreationTimeText.replaceAll("[^0-9]", "");
			CommonHelper.clickOnHomeButton();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			this.mobileActions.swipeDown(5);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			this.mobileActions.swipeUsingID("koo_time_creation_tv");
			BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String newKooCreationTimeText = this.mobileActions
					.getText(kooCreationTimeStamp, kooCreationTimeStamp_Name, true);
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
		this.mobileActions.swipeDown(5);
		this.mobileActions.swipeUsingID("like_holder_constraint");
		boolean displayFlag = this.mobileActions.isDisplayed(likeHolderIconOnReactionBar, likeHolderIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Comment Holder Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = this.mobileActions.isDisplayed(rekooHolderIconOnReactionBar, rekooHolderIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Re-Koo Holder Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = this.mobileActions.isDisplayed(whatsappShareIconOnReactionBar, whatsappShareIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of Whats App Share Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		displayFlag = this.mobileActions.isDisplayed(shareIconOnReactionBar, shareIconOnReactionBar_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of share Icon on reaction bar", false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify koo text
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooText() {
		this.mobileActions.swipeUsingID("topic_title_textview");
		boolean displayFlag = this.mobileActions.isDisplayed(kooText, kooText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag, true, "Validation of koo text", false, BaseTest.mobileDriver.get(), false);
		
		return this;
	}

	/**
	 * This method is to verify koo media
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooMedia() {
		this.mobileActions.swipeUsingID("play");
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		boolean isPlay = this.mobileActions.isElmPresent(By.id("com.koo.app:id/play"));
		if (isPlay) {
			this.mobileActions.click(By.id("com.koo.app:id/play"), "Click on Play button to play video");
		}
		this.mobileActions.swipeUp(1);
		String actualTextOfTimeElapsed = this.mobileActions
				.getText(timeElapsedForVideo, timeElapsedForVideo_Name, true);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		String expectedTextOfTimeElapsed = this.mobileActions
				.getText(timeElapsedForVideo, timeElapsedForVideo_Name, true);
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
		this.mobileActions.swipeUp(1);
		this.mobileActions.swipeUpFindElement(10,
				this.mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedCommentIcon, "xpath", kooText));
		this.mobileActions.click(kooDetailScreenPage.writeCommentsBar, kooDetailScreenPage.writeCommentsBar_Name);
		this.mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name,
				commentText);
		//this.mobileActions.click(this.mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", postButton),
			//	"Click on Post Button");
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		this.mobileActions.swipeUpFindElement(10,
				this.mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedKooText, "xpath", kooText));
		this.mobileActions.click(
				this.mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.postedCommentIcon, "xpath", kooText),
				"Click on View Comment Button");
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		
		boolean displayFlag = this.mobileActions.isDisplayed(this.mobileActions.returnByBasedOnPageNameAndObjectName(commentsSectionHeading, "xpath", commentsSectionHeading),commentsSectionHeading);
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
		String oldKoo = this.mobileActions
				.getText(kooDetail, kooDetail_Name, true);
		this.mobileActions.swipeUp(2);
		this.mobileActions.swipeDown(60);

		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Refreshed the page multiple times and thenget text of latest koo", false, BaseTest.mobileDriver.get());
		BaseTest.mobileDriver.get().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		String refreshedKoo = this.mobileActions
				.getText(kooDetail, kooDetail_Name, true);

		// Verify Old Koo and New/ Refreshed Koo Text should not same/equal
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Verify Old Koo and New/ Refreshed Koo Text should not same/equal", false, BaseTest.mobileDriver.get());
		Boolean isTrue = !oldKoo.equalsIgnoreCase(refreshedKoo);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isTrue, true, "Validation of Koo refreshed. oldKoo:"+oldKoo+" and new refreshed Koo:"+refreshedKoo, true, BaseTest.mobileDriver.get(), false);
		
		return this;
	}
	

}
