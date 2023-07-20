package com.framework.android.allpages;

import org.openqa.selenium.By;

public class HashTagScreenPage {
	
	public By whatsOnYourMind = By.id("com.koo.app:id/creation_view");
	public String hasTag_PopUp = "//android.widget.TextView[contains(@text,'#')]";
	public By search_icon = By.id("com.koo.app:id/lottie_search");
	public By back_button = By.xpath("//android.widget.ImageView[@content-desc=\"Back Button\"]");
	public By searchBar_field = By.id("com.koo.app:id/search_edit_text");
	public By viewMore_link = By.xpath("//android.widget.TextView[contains(@text,'View more')]");
	public By hashtagExplore_icon = By.id("com.koo.app:id/lottie_explore");
	public String hashtag_screen_tab = "//android.widget.TextView[@text='###']";
	public String hashtag_post = "(//android.widget.TextView[@resource-id='com.koo.app:id/hashtagTitle'][contains(@text,'#')])[1]";
	public String hashtagIn_post = "(//android.widget.TextView[contains(@text,'#')])[2]";
	public By hashtag_post_heading = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview']");
	public By back_arrow_button = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/backArrow']");
	public By share_hashtag_button = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/ivShare']");
	public String profileImageFor_hashTagKoo = "(//android.widget.TextView[contains(@text,'#')])[1]//following-sibling::android.widget.FrameLayout//android.view.ViewGroup//android.widget.ImageView[not(contains(@resource-id,'com.koo.app:id/img_dot'))]";
	public String plusIconFor_hashtagKoo = "(//android.widget.TextView[contains(@text,'#')]//..//..//android.widget.ImageView[@resource-id='com.koo.app:id/hashtag_create'])[1]";
	public By selectedHashTag_attribute = By.xpath("//android.widget.EditText\"");
	public String plusIconFor_NERTagKoo = "(//android.widget.TextView[not(contains(@text,'#'))]//..//..//android.widget.ImageView[@resource-id='com.koo.app:id/hashtag_create'])[1]";
	public By user_Image = By.xpath("//android.widget.ImageView[@content-desc='User Image']");
	
	public String whatsOnYourMind_Name_Name = "";
	public String hasTag_PopUp_Name = "";
	public String search_icon_Name = "Search icon";
	public String back_button_Name = "";
	public String searchBar_field_Name = "search bar field";
	public String viewMore_link_Name = "";
	public String hashtagExplore_icon_Name = "";
	public String hashtag_screen_tab_Name = "";
	public String hashtag_post_Name = "";
	public String hashtagIn_post_Name = "";
	public String hashtag_post_heading_Name = "";
	public String back_arrow_button_Name = "";
	public String share_hashtag_button_Name = "";
	public String profileImageFor_hashTagKoo_Name = "";
	public String plusIconFor_hashtagKoo_Name = "";
	public String selectedHashTag_attribute_Name = "";
	public String plusIconFor_NERTagKoo_Name = "";
	public String user_Image_Name = "";
	
}
