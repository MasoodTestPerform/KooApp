package com.framework.android.allpages;

import org.openqa.selenium.By;

public class FeedTabPage {
	
	public By topicsWidget_feedScreen = By.xpath("//android.widget.TextView[@text = 'Add Topics to your Feed']");
	public By topicsWidget_pills = By.id("com.koo.app:id/item_title");
	
	
	public String topicsWidget_feedScreen_Name = "Add topics to your feed";

}
