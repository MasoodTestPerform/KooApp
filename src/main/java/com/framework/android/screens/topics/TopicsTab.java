package com.framework.android.screens.topics;
import com.framework.android.allpages.*;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class TopicsTab {
	
	MobileActions mobileActions = null;
	TopicsPage topicsPage = null;
	UserBlockPage userBlockPage = null;
	ManageTopicsPage manageTopicsPage = null;
	KooCardPage kooCardPage = null;
	KooRewardsProgramPage kooRewardsProgramPage = null;
	FeedTabPage feedTabPage = null;
	
	public TopicsTab() {
		mobileActions = BaseTest.utilObj.get().getMobileActions();
		topicsPage = new TopicsPage();
		userBlockPage = new UserBlockPage();
		manageTopicsPage = new ManageTopicsPage();
		kooCardPage = new KooCardPage();
		kooRewardsProgramPage = new KooRewardsProgramPage();
		feedTabPage = new FeedTabPage();
	}
	

	public void topicsTab(String topicsTabText) {
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(topicsPage.btn_topicsTab, "xpath", topicsTabText),
				topicsTabText + ":"+topicsPage.btn_topicsTab_Name);
		mobileActions.click(topicsPage.btn_PLUSintopics, topicsPage.btn_PLUSintopics_Name);
		String bfrtxt = mobileActions.getText(topicsPage.txt_followedtopicHeadinginTopic, topicsPage.txt_followedtopicHeadinginTopic_Name, true);
		mobileActions.click(topicsPage.btn_GreaterThanIconintopics, topicsPage.btn_GreaterThanIconintopics_Name);
		String aftrtxt = mobileActions.getText(topicsPage.txt_afterfollowedtopicHeadinginTopic, topicsPage.txt_afterfollowedtopicHeadinginTopic_Name, true);
		
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(bfrtxt,aftrtxt, "Verification of text mesage before and after are equal. Text:"+bfrtxt, true, BaseTest.mobileDriver.get(), false); 
		mobileActions.click(userBlockPage.backButton_arrow, userBlockPage.backButton_arrow_Name);
	}

	public void topicsWithViewMore() {
		String topicsTitleInHome;
		
		mobileActions.click(userBlockPage.homeButton, userBlockPage.homeButton_Name);

		mobileActions.swipeUpFindElement(20, topicsPage.btn_topicWithViewMore);
		topicsTitleInHome = mobileActions.getText(topicsPage.btn_topicWithViewMore, topicsPage.btn_topicWithViewMore_Name, true);

		mobileActions.click(topicsPage.btn_topicWithViewMore,
				"Topic with View more button");
		mobileActions.waitForVisible(manageTopicsPage.txt_ManageTopicsHeader);
		String topicsHeader = mobileActions
				.getText(manageTopicsPage.txt_ManageTopicsHeader, manageTopicsPage.txt_ManageTopicsHeader_Name, true)
				.trim();
		BaseTest.utilObj.get().getAssertManager().sAssertContains(topicsTitleInHome,topicsHeader, "Verification of text mesage before and after are equal. Text:"+topicsTitleInHome, true, BaseTest.mobileDriver.get(), false);
			
	}

	public void manageTopics() {
		
		mobileActions.click(kooCardPage.profile_icon, kooCardPage.profile_icon_Name);
		mobileActions.click(userBlockPage.threeDots, userBlockPage.threeDots_Name);
		String bfrtxt = mobileActions.getText(kooRewardsProgramPage.btn_manageTopics, kooRewardsProgramPage.btn_manageTopics_Name, true);
		mobileActions.click(
				kooRewardsProgramPage.btn_manageTopics, kooRewardsProgramPage.btn_manageTopics_Name);

		String aftrtxt = mobileActions.getText(manageTopicsPage.txt_ManageTopicsHeader,
				"Manage topics heading which we followed", true);
		BaseTest.utilObj.get().getAssertManager().sAssertContains(bfrtxt,aftrtxt, "Verification of text mesage before and after are equal. Text:"+bfrtxt, true, BaseTest.mobileDriver.get(), false);
		
		boolean isDisplayed = mobileActions.isElmPresent(manageTopicsPage.tab_AllTabInManageTopics);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Verification of All tab displayed in Manage topics", true, BaseTest.mobileDriver.get(), false);
		
		mobileActions.click(userBlockPage.backButton_arrow, userBlockPage.backButton_arrow_Name);
		
	}

	public void topicsWidgetInFeedTab(String topicsWidgetText) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:"+topicsWidgetText, false, BaseTest.mobileDriver.get());
		try {
			BaseTest.utilObj.get().getMobileActions().swipeUsingText(topicsWidgetText);
			String topicsTitle = mobileActions.getText(feedTabPage.topicsWidget_feedScreen,"topicsTitle",true);

			if (topicsWidgetText.equalsIgnoreCase(topicsTitle)) {
				BaseTest.LOGGER.get().logInfo("Topics widget header is matched");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, topicsWidgetText, true,  BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logError("Topics widget header is not matched");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, topicsWidgetText, true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Topics widget header is not available");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, topicsWidgetText, true, BaseTest.mobileDriver.get(), true);
		}
	}

	
	public void allAndFollowTopicsInTopicsTab(String topicsTabText, String topicsWidgetText) {
		
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(topicsPage.btn_topicsTab, "xpath", topicsTabText),
				topicsPage.btn_topicsTab_Name);
		mobileActions.swipeUsingText(topicsWidgetText);
		String topicsTitle = mobileActions.getText(feedTabPage.topicsWidget_feedScreen, feedTabPage.topicsWidget_feedScreen_Name, true);
		
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(topicsTitle, topicsWidgetText, "Verification of Topics widget header is matched as "+topicsWidgetText, true, BaseTest.mobileDriver.get(), false);
			
	}


}
