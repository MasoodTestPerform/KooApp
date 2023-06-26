package com.framework.android.allpages;

import org.openqa.selenium.By;

public class ManageTopicsPage {
	
	public By txt_ManageTopicsHeader = By.id("com.koo.app:id/toolbar_heading_textview");
	public By tab_AllTabInManageTopics = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)[1]");
	public By tab_FollowingTabInManageTopics = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)[2]");
	
	public String txt_ManageTopicsHeader_Name = "topic heading which we followed";
	public String tab_AllTabInManageTopics_Name = "";
	public String tab_FollowingTabInManageTopics_Name = "";

}
