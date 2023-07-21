package com.framework.android.allpages;

import org.openqa.selenium.By;

public class ScreensPage {
	
	public By trendingTagHeading = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/header_text'])[1]");
	public By trendingTags = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/topic_title']");
	public By mostFollowedPeopleHeading = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/header_text'])[2]");
	public By followButton = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvFollow']");
	public By recentSearchHeading = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/header_text'])[1]");
	public By recentSearchValue = By.id("com.koo.app:id/tvRecentSearch");
	public By backArrowFromSearch = By.id("com.koo.app:id/img_search_backarrow");
	public By searchAllResultLink = By.id("com.koo.app:id/tv_see_all_results");
	public By leftSearchIcon = By.id("com.koo.app:id/search_icon");
	public By searchAllResultTabs = By.xpath("//android.widget.HorizontalScrollView[@resource-id='com.koo.app:id/tab_layout']//following-sibling::android.widget.TextView");
	public By noResultFoundMessage = By.id("com.koo.app:id/tv_no_result");
	public String tabForSearchResult = "//android.widget.TextView[@text='###']";
	public By profileResults = By.xpath("//android.widget.FrameLayout[@resource-id='com.koo.app:id/fl_follow_layout']");
	public By kooResults = By.xpath("(//android.view.ViewGroup[@resource-id='com.koo.app:id/koo_feed_item_container'])[2]");
	public By pagination = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/name_score_layout']");
	public By userFollowButton = By.xpath("//android.widget.TextView[@text='###']/../..//android.widget.FrameLayout[@resource-id='com.koo.app:id/follow_layout']");
	
	
	public String trendingTagHeading_Name = "";
	public String trendingTags_Name = "";
	public String mostFollowedPeopleHeading_Name = "";
	public String followButton_Name = "";
	public String recentSearchHeading_Name = "";
	public String recentSearchValue_Name = "";
	public String backArrowFromSearch_Name = "Back Arrow from search bar";
	public String searchAllResultLink_Name = "";
	public String leftSearchIcon_Name = "";
	public String searchAllResultTabs_Name = "";
	public String noResultFoundMessage_Name = "";
	public String tabForSearchResult_Name = "";
	public String profileResults_Name = "";
	public String kooResults_Name = "";
	public String pagination_Name = "";
	public String userFollowButton_Name = "";
	
	
}
