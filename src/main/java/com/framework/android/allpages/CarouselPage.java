package com.framework.android.allpages;

import org.openqa.selenium.By;

public class CarouselPage {
	
	public By horizontalCarousel = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/item_container']");
	public By followButton = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/btnFollowView']");
	public String unfollowButton = "//android.widget.TextView[@text='###']//..//..//androidx.appcompat.widget.LinearLayoutCompat//android.widget.ImageView[@resource-id='com.koo.app:id/view_follow']";
	public By tickButton = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/btnFollowView']");
	public By arrowButtonForPeopleYouFollow = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/view_all_textview']");
	public By peopleYouFollowPageHeading = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview']");
	public By boostedProfileIcon = By.id("com.koo.app:id/boosted_profile_icon");
	public String boostedProfilePopUpHeading = "//android.widget.TextView[@text='###']";
	public By crossButton = By.id("com.koo.app:id/iv_close");
	
	
	
	public String horizontalCarousel_Name = "";
	public String followButton_Name = "";
	public String unfollowButton_Name = "";
	public String tickButton_Name = "";
	public String arrowButtonForPeopleYouFollow_Name = "";
	public String peopleYouFollowPageHeading_Name = "";
	public String boostedProfileIcon_Name = "";
	public String boostedProfilePopUpHeading_Name = "";
	public String crossButton_Name = "cross button";	
	
}
