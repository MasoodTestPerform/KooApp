package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class UserBlockPage {
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	
	public String viewMore_options = "//android.widget.TextView[not(contains(@text,'###')) and @resource-id='com.koo.app:id/channel_name_textview']//..//android.widget.ImageView[@resource-id='com.koo.app:id/iv_options_more']";
	public By blockUnblockButton = By.id("com.koo.app:id/itemblockUser");
	public String blockUnblockButtonWithText = "//android.widget.TextView[@text='###']";
	public By blockUnblockPopUpText = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");
	public By noButton = By.xpath("//android.widget.Button[@resource-id='android:id/button2']");
	public By okButton = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
	public By searchedUserResult = By.id("com.koo.app:id/channel_name_textview");
	public String searchedUserName = "//android.widget.TextView[@text='###']";
	public By threeDots = By.id("com.koo.app:id/layoutOptionMenu");
	public By closeButton = By.id("com.koo.app:id/bottom_sheet_close");
	public By backButton = By.id("com.koo.app:id/layoutBack");
	public By homeButton = By.id("com.koo.app:id/lottie_home");
	public By settings = By.id("com.koo.app:id/settings");
	public By manageBlockedUser = By.xpath("//android.widget.RelativeLayout[@resource-id='com.koo.app:id/blocked_list_layout']//android.widget.TextView");
	public By unblockButton = By.id("com.koo.app:id/unblock");
	public By viewProfileButton = By.id("com.koo.app:id/view_profile");
	public By profileName = By.id("com.koo.app:id/channel_name_textview");
	public By backButton_arrow = By.id("com.koo.app:id/backArrow");
	public By logOutUser = By.id("com.koo.app:id/logout_layout");
	public By logOutUser_popup = By.id("com.koo.app:id/tvFollow");
	public By searchedUserFrame = By.id("com.koo.app:id/channel_name_textview");
	public By cancelButton = By.id("com.koo.app:id/cancel_button");
	public By commentHolder = By.id("com.koo.app:id/comment_holder");
	public String postedCommentWithSpecificUser = "(//android.widget.TextView[@text='###']//..//..)[1]//following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.koo.app:id/topic_title_textview']";
	public By multipleBlockedUsers = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/unblock']");
	public By deleteAccount = By.id("com.koo.app:id/delete_account_layout");
	
	
	public String viewMore_options_Name = "";
	public String blockUnblockButton_Name = "";
	public String blockUnblockButtonWithText_Name = "";
	public String blockUnblockPopUpText_Name = "";
	public String noButton_Name = "No Or Cancel button";
	public String okButton_Name = "";
	public String searchedUserResult_Name = "";
	public String searchedUserName_Name = "";
	public String threeDots_Name = "Ellipses(three dots)";
	public String closeButton_Name = "";
	public String backButton_Name = "Back button";
	public String homeButton_Name = "Home button";
	public String settings_Name = "Settings button";
	public String manageBlockedUser_Name = "";
	public String unblockButton_Name = "";
	public String viewProfileButton_Name = "";
	public String profileName_Name = "profile name";
	public String backButton_arrow_Name = "Back button";
	public String logOutUser_Name = "Logout user";
	public String logOutUser_popup_Name = "logOut User popup";
	public String searchedUserFrame_Name = "";
	public String cancelButton_Name = "Cancel button from search bar";
	public String commentHolder_Name = "";
	public String postedCommentWithSpecificUser_Name = "";
	public String multipleBlockedUsers_Name = "";
	public String deleteAccount_Name = "";
	
	/**
     * This method is to click on three dots/ellipses from profile of user
     * Jagath
     * @throws IOException
     */
    public void clickOnThreeDots() {
        mobileActions.waitForVisible(threeDots);
        Assert.assertTrue(mobileActions.isDisplayed(threeDots, threeDots_Name));
        mobileActions.click(threeDots,threeDots_Name);
    }
}
