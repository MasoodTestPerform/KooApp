package com.framework.android.screens.topics;

import com.framework.android.allpages.TopicsPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class TopicWidget {
	MobileActions mobileActions = null;
	TopicsPage topicsPage = null;
	UserBlockPage userBlockPage = null;
	public TopicWidget() {
		this.mobileActions = new MobileActions();
		this.topicsPage = new TopicsPage();
		this.userBlockPage = new UserBlockPage();
	}

	
	public void topicswidgetPage() {
		mobileActions.swipeUpFindElement(20,topicsPage.btn_followedtopicHeading);
		String bfrtxt=mobileActions.getText(topicsPage.btn_followedtopicHeading, topicsPage.btn_followedtopicHeading_Name, true);
		mobileActions.isDisplayed(topicsPage.txt_followedkoocontent, topicsPage.txt_followedkoocontent_Name);
		mobileActions.click(topicsPage.btn_followedtopicHeading, topicsPage.btn_followedtopicHeading_Name);
		String aftrtxt=mobileActions.getText(topicsPage.txt_followedtopicHeading, topicsPage.txt_followedtopicHeading_Name, true);
		
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(bfrtxt,aftrtxt, "Verify before and after followed Koo content with text:"+bfrtxt, true, BaseTest.mobileDriver.get(), true); 
		mobileActions.click(userBlockPage.backButton_arrow, userBlockPage.backButton_arrow_Name);
		
		
	}
	public void topicsAddTopictoYourFeed() {
		mobileActions.swipeUsingText("Add Topics to your Feed");
//		mobileActions.swipeUpFindElement(30,MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_addTopicsToYourFeed"));
		//mobileActions.swipeUsingIDAndSwipeCount("header_text", 30);
		mobileActions.click(topicsPage.btn_PlustoFollow, topicsPage.btn_PlustoFollow_Name);
		boolean isDisplayedFlag = mobileActions.isDisplayed(topicsPage.btn_popupforTopicFollow, topicsPage.btn_popupforTopicFollow_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayedFlag, true, "Verify mail layout displayed", true, BaseTest.mobileDriver.get(), true);
		
		
	}
}
