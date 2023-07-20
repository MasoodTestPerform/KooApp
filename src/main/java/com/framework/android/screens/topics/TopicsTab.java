package com.framework.android.screens.topics;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
	ProfileScreenPage profileScreenPage = null;
	HomeScreenTabPage homeScreenTabPage = null;

	public TopicsTab() {
		mobileActions = BaseTest.utilObj.get().getMobileActions();
		topicsPage = new TopicsPage();
		userBlockPage = new UserBlockPage();
		manageTopicsPage = new ManageTopicsPage();
		kooCardPage = new KooCardPage();
		kooRewardsProgramPage = new KooRewardsProgramPage();
		feedTabPage = new FeedTabPage();
		homeScreenTabPage = new HomeScreenTabPage();
	}

	public void topicsTab(String topicsTabText) {
		mobileActions.click(
				mobileActions.returnByBasedOnPageNameAndObjectName(topicsPage.btn_topicsTab, "xpath", topicsTabText),
				topicsTabText);
//		BaseTest.utilObj.get().getMobileActions().swipeUsingText(topicsWidgetText);
//		mobileActions.click(topicsPage.btn_PLUSintopics, topicsPage.btn_PLUSintopics_Name);
		String bfrtxt = mobileActions.getText(topicsPage.txt_followedtopicHeadinginTopic,
				topicsPage.txt_followedtopicHeadinginTopic_Name, true);
		mobileActions.click(topicsPage.btn_GreaterThanIconintopics, topicsPage.btn_GreaterThanIconintopics_Name);
		String aftrtxt = mobileActions.getText(topicsPage.txt_afterfollowedtopicHeadinginTopic,
				topicsPage.txt_afterfollowedtopicHeadinginTopic_Name, true);

		BaseTest.utilObj.get().getAssertManager().sAssertEquals(bfrtxt, aftrtxt,
				"Verification of text mesage before and after are equal. Text:" + bfrtxt, true,
				BaseTest.mobileDriver.get(), false);
		mobileActions.click(userBlockPage.backButton_arrow, userBlockPage.backButton_arrow_Name);
	}

	public void topicsWithViewMore(String language) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.swipeUpFindElement(20, topicsPage.btn_topicWithViewMore);
			String topicsTitleInHome = mobileActions.getText(topicsPage.btn_topicWithViewMore,
					topicsPage.btn_topicWithViewMore_Name, true);

			mobileActions.click(topicsPage.btn_topicWithViewMore, "Topic with View more button");
			mobileActions.waitForVisible(manageTopicsPage.txt_ManageTopicsHeader);
			String topicsHeader = mobileActions.getText(manageTopicsPage.txt_ManageTopicsHeader,
					manageTopicsPage.txt_ManageTopicsHeader_Name, true).trim();
			BaseTest.utilObj.get().getAssertManager().sAssertContains(topicsTitleInHome, topicsHeader,
					"Verification of text mesage before and after are equal. Text:" + topicsTitleInHome, true,
					BaseTest.mobileDriver.get(), false);

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Topics with viewmore button is not available");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Topics with viewmore button is not available", 
					true, BaseTest.mobileDriver.get(), true);
		}
	}

	public void manageTopics(String language) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.click(kooCardPage.profile_icon, "profile icon");
			mobileActions.click(userBlockPage.threeDots, "three dots button");
			String bfrtxt = mobileActions
					.getText(kooRewardsProgramPage.btn_manageTopics, kooRewardsProgramPage.btn_manageTopics_Name, true)
					.trim();
			mobileActions.click(kooRewardsProgramPage.btn_manageTopics, "Manage topics Button");

			String aftrtxt = mobileActions.getText(manageTopicsPage.txt_ManageTopicsHeader,
					manageTopicsPage.txt_ManageTopicsHeader_Name, true).trim();
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(aftrtxt, bfrtxt, "Both name are matched", true,
					BaseTest.mobileDriver.get(), true);

			// TC_054 validation
			if (mobileActions.isElmPresent(manageTopicsPage.tab_AllTabInManageTopics)) {
				BaseTest.LOGGER.get().logInfo("All tab displayed in Manage topics");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "All tab displayed in Manage topics", false,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo("All tab not displayed in Manage topics");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "All tab not displayed in Manage topics",
						true, BaseTest.mobileDriver.get(), true);
			}

			if (mobileActions.isElmPresent(manageTopicsPage.tab_FollowingTabInManageTopics)) {
				BaseTest.LOGGER.get().logInfo("Following tab displayed in Manage topics");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Following tab displayed in Manage topics",
						false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo("Following tab not displayed in Manage topics");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						"Following tab not displayed in Manage topics", true, BaseTest.mobileDriver.get(), true);
			}

			// TC_055 validation
			List<WebElement> allTopics = mobileActions.elements(manageTopicsPage.list_btn_followView);
			System.out.println("allTopics Size: " + allTopics.size());
			if (allTopics.size() > 0) {
				BaseTest.LOGGER.get().logInfo("Topics available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Topics available in All tab", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo("No Topics available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "No Topics available in All tab", true,
						BaseTest.mobileDriver.get(), true);
			}

			mobileActions.click(manageTopicsPage.tab_FollowingTabInManageTopics, "Following tab");
			Thread.sleep(1000);
			List<WebElement> followTopics = mobileActions.elements(manageTopicsPage.list_btn_followView);
//			System.out.println("followTopics Size: "+followTopics.size());
			if (followTopics.size() > 0) {
				BaseTest.LOGGER.get().logInfo("Topics available in Following tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Topics available in Following tab", true,
						BaseTest.mobileDriver.get(), true);
			} else if (mobileActions.isElmPresent(manageTopicsPage.btn_viewTopics)) {
				mobileActions.click(manageTopicsPage.btn_viewTopics, "View Topics button");
				List<WebElement> topicsView = mobileActions.elements(manageTopicsPage.list_followingTopics);
				if (topicsView.size() > 0) {
					for (int i = 0; i < topicsView.size(); i++) {
						if (topicsView.get(i).getText().equals("Sports")) {
							System.out.println("Topic Title1: " + topicsView.get(i).getText());
							String s = Integer.toString(i + 1);
							mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(
									manageTopicsPage.btn_follow, "xpath", s), topicsPage.btn_topicsTab_Name);
							mobileActions.click(manageTopicsPage.tab_FollowingTabInManageTopics, "Following tab");
							mobileActions.swipeDown(2);
							List<WebElement> followTopics1 = BaseTest.utilObj.get().getMobileActions()
									.elements(manageTopicsPage.list_btn_followView);
							System.out.println("followTopics Size: " + followTopics1.size());
							if (followTopics.size() > 0) {
								BaseTest.LOGGER.get().logInfo("Topics available in Following tab");
								BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
										"Topics available in Following tab", true, BaseTest.mobileDriver.get(), true);
							} else {
								BaseTest.LOGGER.get().logInfo("No Topics available in Following tab");
								BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
										"No Topics available in Following tab", true, BaseTest.mobileDriver.get(),
										true);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Topics widget header is not available");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Topics widget header is not available", true,
					BaseTest.mobileDriver.get(), true);
		}
	}

	public void topicsWidgetInFeedTab(String language, String topicsWidgetText) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(
					homeScreenTabPage.tab_name, "xpath", "Feed"), "Feed tab");
			mobileActions.swipeUsingText(topicsWidgetText);
			String topicsTitle = mobileActions.getText(feedTabPage.topicsWidget_feedScreen, "topicsTitle", true);
			System.out.println("topics Title"+topicsTitle);
			
			if (topicsWidgetText.equalsIgnoreCase(topicsTitle)) {
				BaseTest.LOGGER.get().logInfo("Topics widget header is matched");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, topicsWidgetText, true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logError("Topics widget header is not matched");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, topicsWidgetText, true,
						BaseTest.mobileDriver.get(), true);
			}
			if(!mobileActions.isElmPresent(feedTabPage.topicsWidget_pills)){
				mobileActions.swipeUp(1);
			}
			List<WebElement> topicsPills = BaseTest.utilObj.get().getMobileActions()
					.elements(feedTabPage.topicsWidget_pills);
			if(topicsPills.size()>0) {
				BaseTest.LOGGER.get().logInfo("Topics pills are available");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Topic Pills", true,
						BaseTest.mobileDriver.get(), true);
			}else {
				BaseTest.LOGGER.get().logError("Topics pills are not available");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Topic Pills", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Topics widget header is not available");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, topicsWidgetText, true,
					BaseTest.mobileDriver.get(), true);
		}
	}

	public void allAndFollowTopicsInTopicsTab(String topicsTabText, String topicsWidgetText) {

		mobileActions.click(
				mobileActions.returnByBasedOnPageNameAndObjectName(topicsPage.btn_topicsTab, "xpath", topicsTabText),
				topicsPage.btn_topicsTab_Name);
		mobileActions.swipeUsingText(topicsWidgetText);
		String topicsTitle = mobileActions.getText(feedTabPage.topicsWidget_feedScreen,
				feedTabPage.topicsWidget_feedScreen_Name, true);

		BaseTest.utilObj.get().getAssertManager().sAssertEquals(topicsTitle, topicsWidgetText,
				"Verification of Topics widget header is matched as " + topicsWidgetText, true,
				BaseTest.mobileDriver.get(), false);

	}

}
