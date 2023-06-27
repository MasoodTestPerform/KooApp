package com.framework.android.allpages;

import org.openqa.selenium.By;

public class ManageTopicsPage {
	
	public By txt_ManageTopicsHeader = By.id("com.koo.app:id/toolbar_heading_textview");
	public By tab_AllTabInManageTopics = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)[1]");
	public By tab_FollowingTabInManageTopics = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)[2]");
	public By list_followingTopics = By.id("com.koo.app:id/tvTopicTitle");
	public By list_allTopics = By.id("com.koo.app:id/row_constraint");
	public By btn_follow = By.id("com.koo.app:id/tvFollow");
	public By btn_follow_all = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvTopicTitle']");
	public By btn_viewAll = By.id("com.koo.app:id/ivViewAll");
	
	public String txt_ManageTopicsHeader_Name = "topic heading which we followed";
	public String tab_AllTabInManageTopics_Name = "";
	public String tab_FollowingTabInManageTopics_Name = "";
	
}
