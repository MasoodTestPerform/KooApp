package com.framework.android.allpages;

import org.openqa.selenium.By;

public class SettingsPage {
	
	public String settingsSectionHeading = "//android.widget.TextView[@text=\\\"###\\\"]";
	public By continueBtnForBrowserPermission = By.id("com.android.chrome:id/positive_button");
	public By editProfileHeading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By shareKooPopUpHeading = By.id("miui:id/alertTitle");
	public By shareKooPopUp = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
	public By applySelfVerificationPageHeading = By.id("com.koo.app:id/enter_otp_header");
	public By applySelfEminenceAndHelp = By.id("com.android.chrome:id/url_bar");
	public By crossButtonForCloseTab = By.id("com.android.chrome:id/close_button");
	public String migrateFromTwitterPopUpHeading = "//android.widget.TextView[@text='###']";
	public String migrateFromTwitterCloseButton = "//android.widget.TextView[@text='###']";
	public By manageAccountAndNotificationsPageHeading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By logOutPopUpHeading = By.id("com.koo.app:id/status_textview");
	public By cancelButtonOnLogOutPopUp = By.id("com.koo.app:id/tvCancel");
	public String deletePopUPText = "//android.widget.TextView[contains(@text,'###')]";
	public String privacyPolicyAndAboutUsPage = "//android.view.View[@text='###']";
	public String changeInEnglishText = "//android.widget.TextView[@text='###']";
	public String switchButton = "//android.widget.TextView[@text='###']/../..//android.widget.Switch";
	public By logoutBtn = By.id("com.koo.app:id/tvFollow");
	public String settingsSectionHeading_Name = "";
	public String continueBtnForBrowserPermission_Name = "";
	public String editProfileHeading_Name = "";
	public String shareKooPopUpHeading_Name = "";
	public String shareKooPopUp_Name = "";
	public String applySelfVerificationPageHeading_Name = "";
	public String applySelfEminenceAndHelp_Name = "";
	public String crossButtonForCloseTab_Name = "Cross button";
	public String migrateFromTwitterPopUpHeading_Name = "";
	public String migrateFromTwitterCloseButton_Name = "";
	public String manageAccountAndNotificationsPageHeading_Name = "";
	public String logOutPopUpHeading_Name = "";
	public String cancelButtonOnLogOutPopUp_Name = "Cancel button for logout popup";
	public String deletePopUPText_Name = "";
	public String privacyPolicyAndAboutUsPage_Name = "";
	public String changeInEnglishText_Name = "";
	public String switchButton_Name = "";
	public String logoutBtn_Name = "Logout Button";

}
