package com.framework.android.allpages;

import org.openqa.selenium.By;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class FeedTabPage {
	MobileActions mobileActions = null;
		
	public FeedTabPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		
	}
	
	public By topicsWidget_feedScreen = By.xpath("//android.widget.TextView[@text = 'Add Topics to your Feed']");
	public By topicsWidget_pills = By.id("com.koo.app:id/item_title");
	public By btn_plus = By.id("com.koo.app:id/circular_fab");
	public By firstProfileFollowNameObj = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/koo_feed_item_container']/android.view.ViewGroup[@resource-id='com.koo.app:id/layout_profile']/android.widget.TextView");
	public By firstProfileDotElipsesObj = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/iv_options_more'])[1]");
	public By followingObj = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/itemfollowUser']");
	public By yesBtn = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
	public By plusFollowFirstProfileAfterUnfollowTxt = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/tvFollowStatus'])[1]");
	
	public String topicsWidget_feedScreen_Name = "Add topics to your feed";
	public String firstProfileFollowNameObj_Name = "First profile appeared in feed page";
	public String firstProfileDotElipsesObj_Name = "First profile two dots elipses";
	public String followingObj_Name = "Following";
	public String yesBtn_Name = "Following";
	public String plusFollowFirstProfileAfterUnfollowTxt_Name = "+ Follow as text appeared after unfollow in first profile";
	
	public void ValidateProfileFollowInFeedTab(String profileFollowed) {
		
		String profileFollowedActual = mobileActions.getText(this.firstProfileFollowNameObj,"first People Followed Name in Feed page", true);
       	BaseTest.utilObj.get().getAssertManager().sAssertEquals(profileFollowedActual, profileFollowed, "Validation of First People followed appeared in Feed tab", true, BaseTest.mobileDriver.get(), true);
		
	}
	
	public void ValidateFirstProfileUnfollowInFeedTab() {
		
		mobileActions.click(firstProfileDotElipsesObj, firstProfileDotElipsesObj_Name);
		mobileActions.click(followingObj, followingObj_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for unfollow profile", true, BaseTest.mobileDriver.get());
		mobileActions.click(yesBtn, yesBtn_Name);
		mobileActions.waitForSec(5);
		String followTextAppeared = mobileActions.getText(plusFollowFirstProfileAfterUnfollowTxt,plusFollowFirstProfileAfterUnfollowTxt_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(followTextAppeared, "+ Follow", "Validation of First People + follow text appeared after unfollowed in Feed tab", true, BaseTest.mobileDriver.get(), true);
	}

}
