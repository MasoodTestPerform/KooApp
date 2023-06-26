package com.framework.android.allpages;

import org.openqa.selenium.By;

public class ExploreScreenPage {
	public By allSubTabs = By.id("com.koo.app:id/rvNearBy");
	public String tabName = "//android.widget.TextView[@text='###']";
	public By hashTag_image = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/ivPoster']");
	public By headingOf_firstHashTag = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview']");
	public By all_sub_tab = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/tvLocationPill'])");
	public By write_comment = By.id("com.koo.app:id/creation_view");
	public By write_commentSection = By.xpath("//android.widget.EditText");
	public By button_post = By.xpath("//android.widget.Button");
	public By viewComment_icon = By.id("com.koo.app:id/comment_imageview");
	public String posted_comment = "(//android.widget.TextView[@text='###']//..//..)[1]//following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.koo.app:id/topic_title_textview']";
	
	public String allSubTabs_Name = "";
	public String tabName_Name = "";
	public String hashTag_image_Name = "";
	public String headingOf_firstHashTag_Name = "";
	public String all_sub_tab_Name = "";
	public String write_comment_Name = "";
	public String write_commentSection_Name = " Comment text field";
	public String button_post_Name = "post button";
	public String viewComment_icon_Name = "";
	public String posted_comment_Name = "";

}
