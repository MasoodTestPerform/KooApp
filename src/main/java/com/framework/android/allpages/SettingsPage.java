package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class SettingsPage {

//	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
//	PeopleTabPage peopleTabPage = new PeopleTabPage();
//	HomePage homePage = new HomePage();
//	CommonHelper commonHelperPage = new CommonHelper();
//	UIUtils uiUtilsPage = new UIUtils();
//	SoftAssert softAssert = new SoftAssert();
//	ProfileScreenPage profileScreenPage = new ProfileScreenPage();
//	KooCardPage kooCardPage = new KooCardPage();
//	UserBlockPage userBlockPage = new UserBlockPage();
//	KooRewardsProgramPage kooRewardsProgramPage = new KooRewardsProgramPage();
//	ManageTopicsPage manageTopicsPage = new ManageTopicsPage();

	MobileActions mobileActions = null;
	KooCreationPage kooCreationPage = null;
	ProfileScreenPage profileScreenPage = null;
	EditProfilePage editProfilePage = null;
	UserBlockPage userBlockPage = null;
	KooCardPage kooCardPage = null;
	KooRewardsProgramPage kooRewardsProgramPage = null;
	HomePage homePage = null;
	SoftAssert softAssert = null;
	PeopleTabPage peopleTabPage = null;
	CommonHelper commonHelperPage = null;
	UIUtils uiUtilsPage = null;
	ManageTopicsPage manageTopicsPage = null;

	public SettingsPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooRewardsProgramPage = new KooRewardsProgramPage();
		this.softAssert = new SoftAssert();
		this.homePage = new HomePage();
		this.peopleTabPage = new PeopleTabPage();
		this.commonHelperPage = new CommonHelper();
		this.uiUtilsPage = new UIUtils();
		this.manageTopicsPage = new ManageTopicsPage();
	}

	String actualText;
	String expectedText;
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
	public By threeDots = By.id("com.koo.app:id/layoutOptionMenu");
	public By logoutBtn = By.id("com.koo.app:id/tvFollow");

	public By txt_heading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By txt_email = By.id("com.koo.app:id/tv_mail");
	public By txt_mobile = By.id("com.koo.app:id/tv_mobile_number");
	public By lnk_editProfile = By.xpath("//*[@text='Edit Profile']");
	public By lnk_accInfo = By.xpath("//*[@text='Account Information']");
	public By lnk_language = By.xpath("//*[@text='Language']");
	public By lnk_theme = By.xpath("//*[@text='Theme']");
	public By lnk_shareYourKooProfile = By.xpath("//*[@text='Share your Koo profile']");
	public By lnk_superLikes = By.xpath("//*[@text='Super Likes']");
	public By lnk_manageSubscriptions = By.xpath("//*[@text='Manage Subscriptions']");
	public By lnk_manageBlockedUsers = By.xpath("//*[@text='Manage Blocked Users']");
	public By lnk_applySelfVerification = By.xpath("//*[@text='Apply for Self Verification']");
	public By lnk_applyEminence = By.xpath("//*[@text='Apply for Eminence']");
	public By lnk_migrateTwitter = By.xpath("//*[@text='Migrate From Twitter']");
	public By lnk_addAccount = By.xpath("//*[@text='Add Account']");
	public By lnk_manageAccount = By.xpath("//*[@text='Manage Account']");
	public By lnk_logout = By.xpath("//*[@text='Logout']");
	public By lnk_delete = By.xpath("//*[@text='Delete']");
	public By lnk_notifications = By.xpath("//*[@text='Notifications']");
	public By lnk_whatsappUpdates = By.xpath("//*[@text='WhatsApp Updates']");
	public By lnk_videoAutoplay = By.xpath("//*[@text='Video autoplay']");
	public By lnk_autoplayImages = By.xpath("//*[@text='Auto play images']");
	public By lnk_translation = By.xpath("//*[@text='Translation']");
	public By lnk_kooRewards = By.xpath("//*[@text='Koo Rewards']");
	public By lnk_help = By.xpath("//*[@text='Help']");
	public By lnk_privacyPolicy = By.xpath("//*[@text='Privacy Policy']");
	public By lnk_aboutUs = By.xpath("//*[@text='About Us']");
	public By lnk_resourceCenter = By.xpath("//*[@text='Resource Center']");
	public By lnk_playstoreCompliance = By.xpath("//*[@text='PlayStore Compliance']");
	public By dd_translation = By.id("com.koo.app:id/translationText");

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
	public String threeDots_Name = "Ellipses(three dots)";

	// UserBlock
	public By settingsButton = By.id("com.koo.app:id/settings");
	public String settingsButton_Name = "Setting Button";
	public By optionTextinAccountCount12 = By.xpath("(//android.widget.RelativeLayout/android.widget.TextView)");
	public By optionTextinAccountCount2 = By
			.xpath("(//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView)");
	public String optionsText_Name = "Account Section Options in Settings";
	public By optionTextInOthers = By.xpath("");
	public String optionsText2_Name = "Others in Options in Settings";
	public By closeButton = By.id("com.android.chrome:id/close_button");
	public String closeButton_Name = "Close button in Web";

	// Edit Profile
	public By editProfile_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/edit_profile_layout']/android.widget.TextView");
	public String editProfile_Settings_Name = "Edit Prfoile Option in Account Section";
	public By editProfilePageHeaderText = By.xpath("(//android.view.View[1]/android.widget.TextView)[1]");
	public String editProfilePageHeaderText_Name = "Edit Profile Page Heading";
	public By editProfileBackButtonText = By.xpath("(//android.view.View/android.widget.ImageView)");
	public String editProfileBackButtonText_Name = "Back Button from Edit Profile";
	// Account Information
	public By accountInformation_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/account_info_layout']/android.widget.TextView");
	public String accountInformation_Settings_Name = "Account Information Option in Account Section";
	public By accounInformationPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String accounInformationPageHeaderText_Name = "Account Information Page Header";
	public By accountInformationBackButtonText = By.id("com.koo.app:id/backArrow");
	public String accountInformationBackButtonText_Name = "Back Button from Account Information";
	// Language
	public By language_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/language_layout']/android.widget.TextView");
	public String language_Settings_Name = "Language Option in Account Section";
	public By languagePageHeaderText = By.xpath("(//android.view.View[1]/android.widget.TextView)[1]");
	public String languagePageHeaderText_Name = "Language Page Header";
	public By availableLanguagesInlanguagePageHeaderText = By
			.xpath("(//android.widget.ScrollView/android.widget.TextView)[1]");
	public String availableLanguagesInlanguagePageHeaderText_Name = "Avalaiable Languages Sub Header in Language Page";
	public By languageCheckBoxText = By.xpath("(//android.view.View/android.widget.CheckBox)");
	public String languageCheckBoxText_Name = "Check Box of Language Selection";
	public By languageNameInLanguagePageText = By.xpath("(//android.view.View/android.widget.TextView)");
	public String languageNameInLanguagePageText_Name = "Language In Language Page";
	// Theme
	public By theme_Settigs = By.xpath("//*[@resource-id='com.koo.app:id/theme_layout']/android.widget.TextView");
	public String theme_Settigs_Name = "Theme Option in Account Section";
	public By themeSwitchActionText = By.id("com.koo.app:id/theme_switch");
	public String themeSwitchActionText_Name = "Switch the mode of Theme";
	// Share your koo profile
	public By shareYourKooProfile_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/invite_layout']/android.widget.TextView");
	public String shareYourKooProfile_Settings_Name = "Share your Koo profile Option in Account Section";
	public By shareYourKooProfilePopUpText = By.id("android:id/text1");
	public String shareYourKooProfilePopUpText_Name = "Share Your Koo Profile Pop-Up Text";
	// Manage Subcriptions
	public By manageSubscriptions_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/manage_subscription_layout']/android.widget.TextView");
	public String manageSubscriptions_Settings_Name = "Manage Subscription Option in Account Section";
	public By manageSubscriptionPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageSubscriptionPageHeaderText_Name = "Manage Subscription Page Heading";
	public By manageSubscriptionBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageSubscriptionBackButtonText_Name = "Back Button from Manage Subscription";
	// Manage Blocked Users
	public By manageBlockedUsers_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/blocked_list_layout']/android.widget.TextView");
	public String manageBlockedUsers_Settings_Name = "Manage Blocked User Option In Account Section";
	public By manageBlockedUsersPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageBlockedUsersPageHeaderText_Name = "Manager Blocked Users Page Heading";
	public By manageBlocedUsersBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageBlocedUsersBackButtonText_Name = "Back Button from Manage Blocked Users";
	// Apply for Self Verification
	public By applyForSelfVerification_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/apply_selftick_layout']/android.widget.TextView");
	public String applyForSelfVerification_Settings_Name = "Apply for Self Verify Option in Account section";
	public By applyForSelfVerificationPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String applyForSelfVerificationPageHeaderText_Name = "Apply for Self Verify Page Header";
	public By selfVerifyBackButtonText = By.id("com.koo.app:id/backArrow");
	public String selfVerifyBackButtonText_Name = "Back Button from Self Verify";
	// Apply for Eminence
	public By applyForEminence_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/apply_tick_layout']/android.widget.TextView");
	public String applyForEminence_Settings_Name = "Apply for Eminence Option in Account Section";
	public By googlePageForEminenceText = By.id("com.android.chrome:id/title");
	public String googlePageForEminenceText_Name = "Chrome/Browser Page for do Eminence";
	public By chromeCloseButton = By.id("com.android.chrome:id/close_button");
	public String chromeCloseButton_Name = "Close button from browser";

	public By action_Backward_Button = By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]");
	public String action_Backward_Button_Name = "Back button from chrome/web pages";

	// Migrate from Twitter
	public By migrateFromTwitter_Settings = By.id("com.koo.app:id/migrate_from_twitter_text");
	public String migrateFromTwitter_Settings_Name = "Migrate from Twitter Option in Account Section";
	public By migrateFromTwitterPopUpText = By.xpath("(//android.widget.ScrollView/android.widget.TextView)");
	public String migrateFromTwitterPopUpText_Name = "Magrate from Twitter Pop-Up";
	public By migrateFromTwitterCloseButtonText = By
			.xpath("(//android.widget.ScrollView/android.view.View/android.widget.TextView)[6]");
	public String migrateFromTwitterCloseButtonText_Name = "Close Button in Migrate from Twitter";
	// Add Account
	public By addAccount_Settings = By.id("com.koo.app:id/tv_add_account");
	public String addAccount_Settings_Name = "Add Account Option In Account Section";
	public By addAccountByUsngPhoneNumberText = By.id("com.koo.app:id/phone_no_textview_subtitle");
	public String addAccountByUsngPhoneNumberText_Name = "Add Account By Using Phone Number";
	public By addAccountByUsngGoogleAcntText = By.id("com.koo.app:id/sign_with_google");
	public String addAccountByUsngGoogleAcntText_Name = "Add Account By Using Google Account";
	public By addAccountByUsngEmailText = By.id("com.koo.app:id/sign_with_email");
	public String addAccountByUsngEmailText_Name = "Add Account By using E-Mail";

	// Manage Account
	public By manageAccount_Settings = By.id("com.koo.app:id/tv_manage_account");
	public String manageAccount_Settings_Name = "Manage Account Option in Account Section";
	public By manageAccountPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String manageAccountPageHeaderText_Name = "Manage Account Page Heading";
	public By middleMessageInManageAccountText = By.id("com.koo.app:id/middle_text");
	public String middleMessageInManageAccountText_Name = "Page Middle Text Message";
	public By manageAccountBackButtonText = By.id("com.koo.app:id/backArrow");
	public String manageAccountBackButtonText_Name = "Back Button from Manage Account";
	// Logout
	public By logout_Settings = By.xpath("//*[@resource-id='com.koo.app:id/logout_layout']/android.widget.TextView");
	public String logout_Settings_Name = "Logout option in Account Section";
	public By logoutPopupText = By.id("com.koo.app:id/tvLogout");
	public String logoutPopupText_Name = "Logout Button";
	public By logoutPopupCancelButtonText = By.id("com.koo.app:id/tvCancel");
	public String logoutPopupCancelButtonText_Name = "Cancel Button";
	public By logoutPopupMessageText = By.id("com.koo.app:id/status_textview");
	public String logoutPopupMessageText_Name = "Logot Pop-Up Message";
	// Delete
	public By delete_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/delete_account_layout']/android.widget.TextView");
	public String delete_Settings_Name = "Delete option in Account Section";
	public By deletePopupText = By.id("com.koo.app:id/tvLogout");
	public By deletePopupMessageText = By.id("com.koo.app:id/status_textview");
	public By deletePopupCancelButtonText = By.id("com.koo.app:id/tvCancel");
	public String deletePopupText_Name = "Delete button";
	public String deletePopupMessageText_Name = "Delete Pop-Up Message";
	public String deletePopupCancelButtonText_Name = "Cancel Button";
	// Notifications
	public By notifications_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/notification_layout']/android.widget.TextView");
	public String notifications_Settings_Name = "Notification Options in Others";
	public By noticationBackButtonText = By.id("com.koo.app:id/backArrow");
	public String noticationBackButtonText_Name = "Back Button from Notifications";
	public By noticationsPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String noticationsPageHeaderText_Name = "Notifications Page Heading";

	// Whatsapp Updates
	public By whatsappUpdates_Settings = By.xpath(
			"//*[@resource-id='com.koo.app:id/whatsapp_ll']/android.widget.LinearLayout/android.widget.TextView");
	public String whatsappUpdates_Settings_Name = "Whatsapp Updates Option in Others";
	public By whatsappUpdatesSwitch_Text = By.id("com.koo.app:id/whatsapp_switch");
	public String whatsappUpdatesSwitch_Text_Name = "Whatsapp Updates Switch";

	// Video Autoplay
	public By videoAutoPlay_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/autoplay_videos']/android.widget.TextView");
	public String videoAutoPlay_Settings_Name = "Video Autoplay Option in Others";
	public By videoAutoPlaySwitchText = By.id("com.koo.app:id/autoplay_switch");
	public String videoAutoPlaySwitchText_Name = "Video Auto Play Switch";

	// Auto Play Images
	public By autoPlayImages_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/autoplay_images']/android.widget.TextView)");
	public String autoPlayImages_Settings_Name = "Autoplay Images Option in Others";
	public By autoPlayImagesSwitchText = By.id("com.koo.app:id/autoplay_images_switch");
	public String autoPlayImagesSwitchText_Name = "Auto Play Images Switch";

	// Translation
	public By translation_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/translation_layout']/android.widget.TextView)");
	public String translation_Settings_Name = "Transaction Option in Others";
	public By translationSwitchText = By.id("com.koo.app:id/translation_switch");
	public String transalationSwitchText_Name = "Transaction Switch";

	// Koo Rewards
	public By kooRewards_Settings = By.id("com.koo.app:id/setting_reward_text");
	public String kooRewards_Settings_Name = "Koo Rewards Option in Others";
	public By kooRewardsSwitchText = By.id("com.koo.app:id/rewards_switch");
	public String kooRewardsSwitchText_Name = "Koo Rewards Switch";

	// Help
	public By help_Settings = By.xpath("(//*[@resource-id='com.koo.app:id/feedback_layout']/android.widget.TextView)");
	public String help_Settings_Name = "Help Option in Others";

	// Privacy Policy
	public By privacyPolicy_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/privacy_policy_layout']/android.widget.TextView)");
	public String privacyPolicy_Settings_Name = "Privacy Policy Option in Others";

	// About us
	public By aboutUS_Settings = By.xpath("(//*[@resource-id='com.koo.app:id/about_layout']/android.widget.TextView)");
	public String aboutUS_Settings_Name = "About Us Option in Others";

	// Resource Center
	public By resourceCenter_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/resource_layout']/android.widget.TextView)");
	public String resourceCenter_Settings_Name = "Resource Center Option in Others";

	// PlayStore Compliance
	public By playStoreCompliance_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/playStoreComplianceLayout']/android.widget.TextView)");
	public String playStoreCompliance_Settings_Name = "Play Store Compliance Option in Others";

	// Chrome Title
	public By chromePageTitle = By.id("com.android.chrome:id/title");
	public String chromePageTitle_Name = "Redirected to Chrome Page";

	public String logoutBtn_Name = "Logout Button";
	public String settingsSectionHeading_Name = "Heading";
	public String accountInfo_name = "Account Information";

	// Setting Button after Child account added
	public By settingOfChildAccount = By.id("com.koo.app:id/appCompatTextView3");
	public String settingOfChildAccount_Name = "Settings Button after adding Child Account";

	/**
	 * This method is to click on Profile button
	 *
	 * @return
	 * @throws Exception
	 */
	public SettingsPage clickOnProfile() throws Exception {
		try {
			mobileActions.waitForVisible(homePage.profile_lnk);
			mobileActions.click(homePage.profile_lnk, homePage.profile_lnk_Name);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(homePage.profile_lnk_Name + " Not Clickable");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, homePage.profile_lnk_Name + " Not Clickable",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify settings button
	 *
	 * @param expectedText
	 */
	public SettingsPage verifySettingsButton() {
		try {
			mobileActions.waitForVisible(userBlockPage.settings);
			mobileActions.isDisplayed(userBlockPage.settings, userBlockPage.settings_Name);
			actualText = mobileActions.getText(userBlockPage.settings, userBlockPage.settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("SettingsButton");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					true, BaseTest.mobileDriver.get(), true);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(userBlockPage.settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					userBlockPage.settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to click on settings button
	 *
	 * @return
	 * @throws IOException
	 */
	public SettingsPage clickSettingsButton() {
		try {
			mobileActions.waitForVisible(userBlockPage.settings);
			mobileActions.isDisplayed(userBlockPage.settings, userBlockPage.settings_Name);
			mobileActions.click(userBlockPage.settings, userBlockPage.settings_Name);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(userBlockPage.settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					userBlockPage.settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to click on settings button of Adding child account
	 *
	 * @return
	 * @throws IOException
	 */
	public SettingsPage clickSettingsButtonChildAccount() {
		try {
			mobileActions.waitForVisible(settingOfChildAccount);
			mobileActions.isDisplayed(settingOfChildAccount, settingOfChildAccount_Name);
			mobileActions.click(settingOfChildAccount, settingOfChildAccount_Name);
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(settingOfChildAccount_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					userBlockPage.settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify sections on settings page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyAllOptionsInSettings(String expectedHeading) throws InterruptedException {
		mobileActions.swipeUpFindElement(10, mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
				"settingsSectionHeading", expectedHeading));
		mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
				"settingsSectionHeading", expectedHeading));
		mobileActions
				.isDisplayed(
						mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
								"settingsSectionHeading", expectedHeading),
						"Verify Settings page sections and it's sub heading = " + expectedHeading);
		Assert.assertTrue(
				mobileActions.isDisplayed(
						mobileActions.returnByBasedOnPageNameAndObjectName(settingsSectionHeading,
								"settingsSectionHeading", expectedHeading),
						"Verify Settings page sections and it's sub heading = " + expectedHeading));
		System.out.println("Verify Settings page sections and it's sub heading = " + expectedHeading);
		return this;
	}

	/**
	 * This method is to verify Options in Account Section
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage optionsInAccountSection() {
		try {

			actualText = mobileActions.getText(editProfile_Settings, editProfile_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionEditProfileSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(accountInformation_Settings, accountInformation_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionAccountInformationSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);

			actualText = mobileActions.getText(language_Settings, language_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionLanguageSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(theme_Settigs, theme_Settigs_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionThemeSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(shareYourKooProfile_Settings, shareYourKooProfile_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionShareKooProfileSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(manageSubscriptions_Settings, manageSubscriptions_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionManageSubscriptionsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionManageBlockedUsersSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);

			actualText = mobileActions
					.getText(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionApplySelfSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(applyForEminence_Settings, applyForEminence_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionApplyEminenceSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionMigrateTwitterSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(addAccount_Settings, addAccount_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionAddAccountSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(manageAccount_Settings, manageAccount_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionManageAccountSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(logout_Settings, logout_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionLogoutSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(delete_Settings, delete_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("AccountsSectionDeleteSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Options are not displaying");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options are not displaying", true,
					BaseTest.mobileDriver.get(), true);
		}
		softAssert.assertAll();
		return this;
	}

	/**
	 * This method is to verify Edit Profile Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyEditProfilePage_inSettings() {
		try {
			String beforeText = mobileActions.getText(editProfile_Settings, editProfile_Settings_Name, true).trim();
			mobileActions.isDisplayed(editProfile_Settings, editProfile_Settings_Name);
			mobileActions.click(editProfile_Settings, editProfile_Settings_Name);
			String afterText = mobileActions.getText(editProfilePageHeaderText, editProfilePageHeaderText_Name, true)
					.trim();
			if (mobileActions.isDisplayed(editProfilePageHeaderText, editProfilePageHeaderText_Name)) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(editProfile_Settings_Name + " is Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(editProfile_Settings_Name + " Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						editProfile_Settings_Name + " Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Edit Profile Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Edit Profile Validation Failed", true,
					BaseTest.mobileDriver.get(), true);
		}
		clickBack(editProfileBackButtonText, editProfileBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Account Information Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyAccountInformationPage_inSettings() {
		try {
			mobileActions.isDisplayed(accountInformation_Settings, accountInformation_Settings_Name);
			String beforeText = mobileActions
					.getText(accountInformation_Settings, accountInformation_Settings_Name, true).trim();
			mobileActions.click(accountInformation_Settings, accountInformation_Settings_Name);
			if (mobileActions.isDisplayed(accounInformationPageHeaderText, accounInformationPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(accounInformationPageHeaderText, accounInformationPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(accountInformation_Settings_Name + " Page Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(accountInformation_Settings_Name + " Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						accountInformation_Settings_Name + " Page not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(accountInformation_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					accountInformation_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(accountInformationBackButtonText, accountInformationBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Language Option
	 *
	 * @return
	 */
	public SettingsPage verifyLanguageOption_inSettings() {
		try {
			mobileActions.isDisplayed(language_Settings, language_Settings_Name);
			mobileActions.getText(language_Settings, language_Settings_Name, true);
			mobileActions.click(language_Settings, language_Settings_Name);
			if (mobileActions.isDisplayed(languagePageHeaderText, languagePageHeaderText_Name)) {
				mobileActions.getText(languagePageHeaderText, languagePageHeaderText_Name, true);
				BaseTest.LOGGER.get().logInfo(language_Settings_Name + " Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Language Page Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(language_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						language_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(language_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, language_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Theme Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyThemeOption_inSettings() {
		try {
			mobileActions.getText(theme_Settigs, theme_Settigs_Name, true);
			boolean themeSwitch = mobileActions.isElmPresent(themeSwitchActionText);
			if (themeSwitch) {
				BaseTest.LOGGER.get().logInfo(theme_Settigs_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, theme_Settigs_Name + " is Displayed", true,
						BaseTest.mobileDriver.get(), true);
				mobileActions.click(themeSwitchActionText, themeSwitchActionText_Name);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"after click" + theme_Settigs_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(theme_Settigs_Name + " switching Action Not Done");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						theme_Settigs_Name + " switching Action Not Done", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(theme_Settigs_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, theme_Settigs_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Manage Subscription Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyManageSubscription_inSettings() {
		try {
			mobileActions.isDisplayed(manageSubscriptions_Settings, manageSubscriptions_Settings_Name);
			String beforeText = mobileActions
					.getText(manageSubscriptions_Settings, manageSubscriptions_Settings_Name, true).trim();
			mobileActions.click(manageSubscriptions_Settings, manageSubscriptions_Settings_Name);
			if (mobileActions.isDisplayed(manageSubscriptionPageHeaderText, manageSubscriptionPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageSubscriptionPageHeaderText, manageSubscriptionPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(manageSubscriptions_Settings_Name + " Page Displayed");
			} else {
				BaseTest.LOGGER.get().logInfo(manageSubscriptions_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageSubscriptions_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageSubscriptions_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageSubscriptions_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageSubscriptionBackButtonText, manageSubscriptionBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Manage Blocked Users Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyManageBlockedUsersOption_inSettings() {
		try {
			mobileActions.isDisplayed(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name);
			String beforeText = mobileActions
					.getText(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name, true).trim();
			mobileActions.click(manageBlockedUsers_Settings, manageBlockedUsers_Settings_Name);
			if (mobileActions.isDisplayed(manageBlockedUsersPageHeaderText, manageBlockedUsersPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageBlockedUsersPageHeaderText, manageBlockedUsersPageHeaderText_Name, true).trim();
				BaseTest.LOGGER.get().logInfo(manageBlockedUsers_Settings_Name + " Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						manageBlockedUsers_Settings_Name + " Page Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(manageBlockedUsers_Settings_Name + " Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageBlockedUsers_Settings_Name + " Page not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageBlockedUsers_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageBlockedUsers_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageBlocedUsersBackButtonText, manageBlocedUsersBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Apply for Self Verification Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyApplyForSelfVerificationOption_inSettings() {
		try {
			mobileActions.isDisplayed(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name);
			mobileActions.getText(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name, true);
			mobileActions.click(applyForSelfVerification_Settings, applyForSelfVerification_Settings_Name);
			if (mobileActions.isDisplayed(applyForSelfVerificationPageHeaderText,
					applyForSelfVerificationPageHeaderText_Name)) {
				mobileActions.getText(applyForSelfVerificationPageHeaderText,
						applyForSelfVerificationPageHeaderText_Name, true);
				BaseTest.LOGGER.get().logInfo(applyForSelfVerification_Settings_Name + "/Self-Verify Page Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						applyForSelfVerification_Settings_Name + "/Self-Verify Page Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get()
						.logInfo(applyForSelfVerification_Settings_Name + "/Self-Verify Page not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						applyForSelfVerification_Settings_Name + "/Self-Verify Page not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(applyForSelfVerification_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					applyForSelfVerification_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(),
					true);
		}
		clickBack(selfVerifyBackButtonText, selfVerifyBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Apply for Eminence Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyApplyForEminenceOption_inSettings() {
		try {
			mobileActions.waitForVisible(applyForEminence_Settings);
			Assert.assertTrue(mobileActions.isDisplayed(applyForEminence_Settings, applyForEminence_Settings_Name));
			mobileActions.click(applyForEminence_Settings, applyForEminence_Settings_Name);
			mobileActions.waitForVisible(closeButton);
			if (mobileActions.isDisplayed(closeButton, closeButton_Name)) {
				mobileActions.click(closeButton, closeButton_Name);
				BaseTest.LOGGER.get()
						.logInfo("Chrome/Browser Page for " + applyForEminence_Settings_Name + " Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Chrome/Browser Page for " + applyForEminence_Settings_Name + " Displayed", true,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get()
						.logInfo("Chrome/Browser Page for" + applyForEminence_Settings_Name + " not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						"Chrome/Browser Page for" + applyForEminence_Settings_Name + " not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(applyForEminence_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					applyForEminence_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		// commonHelperPage.clickOnBackArrow();
		return this;
	}

	/**
	 * This method is to verify Migrate form Twitter Option
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyMigrateFromTwitterOption_inSettings() {
		try {
			mobileActions.isDisplayed(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name);
			String beforeText = mobileActions
					.getText(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name, true).trim();
			mobileActions.click(migrateFromTwitter_Settings, migrateFromTwitter_Settings_Name);
			if (mobileActions.isElmPresent(migrateFromTwitterPopUpText)) {
				String afterText = mobileActions
						.getText(migrateFromTwitterPopUpText, migrateFromTwitterPopUpText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(migrateFromTwitter_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						migrateFromTwitter_Settings_Name + " Pop-Up Message Displayed", false,
						BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(migrateFromTwitter_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						migrateFromTwitter_Settings_Name + " Pop-Up Message Not Displayed", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(migrateFromTwitter_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					migrateFromTwitter_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(migrateFromTwitterCloseButtonText, migrateFromTwitterCloseButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Add Account Option
	 *
	 * @return
	 */
	public SettingsPage verifyAddAccountPage_inSettings() {
		try {
			mobileActions.isDisplayed(addAccount_Settings, addAccount_Settings_Name);
			mobileActions.getText(addAccount_Settings, addAccount_Settings_Name, true);
			mobileActions.click(addAccount_Settings, addAccount_Settings_Name);
			if (mobileActions.isDisplayed(addAccountByUsngPhoneNumberText, addAccountByUsngPhoneNumberText_Name)) {
				mobileActions.getText(addAccountByUsngPhoneNumberText, addAccountByUsngPhoneNumberText_Name, true);
				BaseTest.LOGGER.get().logInfo(addAccount_Settings_Name + " Page is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						addAccount_Settings_Name + " Page Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(addAccount_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						addAccount_Settings_Name + " Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(addAccount_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					addAccount_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Manage Account Option
	 *
	 * @return
	 */
	public SettingsPage verifyManageAccountPage_inSettings() {
		try {
			mobileActions.isDisplayed(manageAccount_Settings, manageAccount_Settings_Name);
			String beforeText = mobileActions.getText(manageAccount_Settings, manageAccount_Settings_Name, true).trim();
			mobileActions.click(manageAccount_Settings, manageAccount_Settings_Name);
			if (mobileActions.isDisplayed(manageAccountPageHeaderText, manageAccountPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(manageAccountPageHeaderText, manageAccountPageHeaderText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(manageAccount_Settings_Name + " Page is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						manageAccount_Settings_Name + " Page is Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(manageAccount_Settings_Name + " Page Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						manageAccount_Settings_Name + "  Page Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(manageAccount_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					manageAccount_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(manageAccountBackButtonText, manageAccountBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify Share your Koo Profile action
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyShareYourKooProfileAction_inSettings() {
		try {
			mobileActions.waitForVisible(shareYourKooProfile_Settings);
			mobileActions.isDisplayed(shareYourKooProfile_Settings, shareYourKooProfile_Settings_Name);
			mobileActions.click(shareYourKooProfile_Settings, shareYourKooProfile_Settings_Name);
			if (mobileActions.isDisplayed(shareYourKooProfilePopUpText, shareYourKooProfilePopUpText_Name)) {
				BaseTest.LOGGER.get().logInfo(shareYourKooProfilePopUpText_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						shareYourKooProfilePopUpText_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(shareYourKooProfilePopUpText_Name + " Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						shareYourKooProfilePopUpText_Name + "  Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(shareYourKooProfilePopUpText_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					shareYourKooProfilePopUpText_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Logout action
	 *
	 * @param expectedHeading
	 * @return
	 */
	public SettingsPage verifyLogOutAction_inSettings() {
		try {
			mobileActions.isDisplayed(logout_Settings, logout_Settings_Name);
			String beforeText = mobileActions.getText(logout_Settings, logout_Settings_Name, true).trim();
			mobileActions.click(logout_Settings, logout_Settings_Name);
			if (mobileActions.isElmPresent(logoutPopupText)) {
				String afterText = mobileActions.getText(logoutPopupText, logoutPopupText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(logout_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						logout_Settings_Name + " Pop-Up Message Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(logout_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						logout_Settings_Name + " Pop-Up Message Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(logout_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, logout_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(logoutPopupCancelButtonText, logoutPopupCancelButtonText_Name);
		return this;
	}

	/**
	 * This method is to do Logout
	 *
	 */

	public SettingsPage doLogout() {
		mobileActions.waitForVisible(logout_Settings);
		mobileActions.isDisplayed(logout_Settings, logout_Settings_Name);
		mobileActions.click(logout_Settings, logout_Settings_Name);
		return this;
	}

	/**
	 * This method is to verify Logout Popup
	 *
	 */
	public SettingsPage verifyLogoutPopupAndClick() {
		mobileActions.isDisplayed(logoutPopupMessageText, logoutPopupMessageText_Name);
		String actualPopupText = mobileActions.getText(logoutPopupMessageText, logoutPopupMessageText_Name, true).trim();
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualPopupText, expectedText, "Both names are matched",
				true, BaseTest.mobileDriver.get(), true);
		mobileActions.isElmPresent(logoutPopupText);
		mobileActions.click(logoutPopupText, logoutPopupText_Name);
		mobileActions.getText(homePage.select_languages, homePage.select_languages_Name, true);
		mobileActions.isDisplayed(homePage.profile_lnk, homePage.profile_lnk_Name);
		return this;
	}

	/**
	 * This method is to do Logout
	 *
	 */
	public SettingsPage doAddAccount() {
		mobileActions.waitForVisible(addAccount_Settings);
		mobileActions.isDisplayed(addAccount_Settings, addAccount_Settings_Name);
		mobileActions.click(addAccount_Settings, addAccount_Settings_Name);
		// do login with child number
		return this;
	}

	public SettingsPage doDelete() {
		mobileActions.waitForVisible(delete_Settings);
		mobileActions.isDisplayed(delete_Settings, delete_Settings_Name);
		mobileActions.click(delete_Settings, delete_Settings_Name);
		mobileActions.isDisplayed(deletePopupMessageText, deletePopupMessageText_Name);
		String afterText = mobileActions.getText(deletePopupMessageText, deletePopupMessageText_Name, true).trim();
		mobileActions.isElmPresent(deletePopupText);
		mobileActions.click(deletePopupText, deletePopUPText_Name);
		return this;
	}

	/**
	 * This method is to verify Delete action
	 *
	 * @return
	 */
	public SettingsPage verifyDeleteAction_inSettings() {
		try {
			mobileActions.isDisplayed(delete_Settings, delete_Settings_Name);
			String beforeText = mobileActions.getText(delete_Settings, delete_Settings_Name, true).trim();
			mobileActions.click(delete_Settings, delete_Settings_Name);
			if (mobileActions.isElmPresent(deletePopupText)) {
				String afterText = mobileActions.getText(deletePopupText, deletePopupText_Name, true).trim();
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(afterText, beforeText, "Both names are matched",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.LOGGER.get().logInfo(delete_Settings_Name + " Pop-Up Message Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						delete_Settings_Name + " Pop-Up Message Displayed", false, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(delete_Settings_Name + " Pop-Up Message Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						delete_Settings_Name + " Pop-Up Message Not Displayed", true, BaseTest.mobileDriver.get(),
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(delete_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, delete_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		clickBack(deletePopupCancelButtonText, deletePopupCancelButtonText_Name);
		return this;
	}

	/**
	 * This method is click on back arrow
	 * 
	 */
	public void clickBack(By by, String locatorName) {

		mobileActions.waitForVisible(by);
		Assert.assertTrue(mobileActions.isDisplayed(by, locatorName));
		mobileActions.click(by, locatorName);
	}

	/**
	 * This method is to verify Options in Others
	 * 
	 * @return
	 */
	public SettingsPage verifyOptionsinOthers() {
		try {
			mobileActions.swipeUp(3);
			actualText = mobileActions.getText(notifications_Settings, notifications_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(whatsappUpdates_Settings, whatsappUpdates_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionWhatsappUpdateSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(videoAutoPlay_Settings, videoAutoPlay_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionVideoAutoPLaySubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(autoPlayImages_Settings, autoPlayImages_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionAutoPLayImagesSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(translation_Settings, translation_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionTranslationSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(kooRewards_Settings, kooRewards_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionKooRewardsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(help_Settings, help_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(privacyPolicy_Settings, privacyPolicy_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(aboutUS_Settings, aboutUS_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(resourceCenter_Settings, resourceCenter_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionResourceCenterSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(playStoreCompliance_Settings, playStoreCompliance_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionPlayStoreCompSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Options in Others Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options in Others Validation Failed", true,
					BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Notifications Option
	 *
	 * @return
	 */
	public SettingsPage verifyNotifications_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading"));
			boolean notifications = mobileActions.isElmPresent(notifications_Settings);
			String beforeText = mobileActions.getText(notifications_Settings, notifications_Settings_Name, true).trim();
			mobileActions.click(notifications_Settings, notifications_Settings_Name);
			if (mobileActions.isDisplayed(noticationsPageHeaderText, noticationsPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(noticationsPageHeaderText, noticationsPageHeaderText_Name, true).trim();
				BaseTest.LOGGER.get().logInfo(noticationsPageHeaderText_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						noticationsPageHeaderText_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(noticationsPageHeaderText_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						noticationsPageHeaderText_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Notifications Page Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options are not displaying", true,
					BaseTest.mobileDriver.get(), true);
		}
		mobileActions.click(noticationBackButtonText, noticationBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify WhatsappUpdates Option
	 * 
	 * @return
	 */
	public SettingsPage verifyWhatsappUpdates_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionWhatsappUpdateSubHeading"));
			mobileActions.getText(whatsappUpdates_Settings, whatsappUpdates_Settings_Name, true).trim();
			boolean whatsappSwitch = mobileActions.isElmPresent(whatsappUpdates_Settings);
			if (whatsappSwitch) {
				BaseTest.LOGGER.get().logInfo(whatsappUpdates_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						whatsappUpdates_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(whatsappUpdates_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						whatsappUpdates_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(whatsappUpdates_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					whatsappUpdates_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Video Play Option
	 * 
	 * @return
	 */
	public SettingsPage verifyVideoPlay_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionVideoAutoPLaySubHeading"));
			mobileActions.getText(videoAutoPlay_Settings, videoAutoPlay_Settings_Name, true);
			boolean videoAutoPlaySwitch = mobileActions.isElmPresent(videoAutoPlaySwitchText);
			if (videoAutoPlaySwitch) {
				BaseTest.LOGGER.get().logInfo(videoAutoPlay_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						videoAutoPlay_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(videoAutoPlay_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						videoAutoPlay_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(videoAutoPlay_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					videoAutoPlay_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Auto Play Images Option
	 * 
	 * @return
	 */
	public SettingsPage verifyAutoPlayImages_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionAutoPLayImagesSubHeading"));
			mobileActions.getText(autoPlayImages_Settings, autoPlayImages_Settings_Name, true);
			boolean autoPlayImagesSwitch = mobileActions.isElmPresent(autoPlayImagesSwitchText);
			if (autoPlayImagesSwitch) {
				BaseTest.LOGGER.get().logInfo(autoPlayImages_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						autoPlayImages_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(autoPlayImages_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						autoPlayImages_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(autoPlayImages_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					autoPlayImages_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Translation Option
	 * 
	 * @return
	 */
	public SettingsPage verifyTransaltion_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionTranslationSubHeading"));
			mobileActions.getText(translation_Settings, translation_Settings_Name, true);
			boolean transalationSwitch = mobileActions.isElmPresent(translationSwitchText);
			if (transalationSwitch) {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, translation_Settings_Name + " is Displayed",
						true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						translation_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(translation_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					translation_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Rewards Option
	 * 
	 * @return
	 */
	public SettingsPage verifyRewards_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionKooRewardsSubHeading"));
			mobileActions.getText(kooRewards_Settings, kooRewards_Settings_Name, true);
			boolean transalationSwitch = mobileActions.isElmPresent(kooRewardsSwitchText);
			if (transalationSwitch) {
				BaseTest.LOGGER.get().logInfo(kooRewards_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, kooRewards_Settings_Name + " is Displayed",
						true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						kooRewards_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(kooRewards_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, kooRewards_Settings_Name + " is not Displayed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Help Option
	 * 
	 * @return
	 */
	public SettingsPage verifyHelpOption_inSettings() {
		try {
			mobileActions.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading"));
			mobileActions.swipeUsingText("Notifications");
			mobileActions.getText(help_Settings, help_Settings_Name, true);
			boolean helpOption = mobileActions.isElmPresent(help_Settings);
			if (helpOption) {
				BaseTest.LOGGER.get().logInfo(help_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, help_Settings_Name + " is Displayed", true,
						BaseTest.mobileDriver.get(), true);
				mobileActions.click(help_Settings, help_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(help_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, help_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Privacy Policy Option
	 * 
	 * @return
	 */
	public SettingsPage verifyPrivacyPolicyOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading"));
			mobileActions.getText(privacyPolicy_Settings, privacyPolicy_Settings_Name, true);
			boolean privacyPolicyOption = mobileActions.isElmPresent(privacyPolicy_Settings);
			if (privacyPolicyOption) {
				BaseTest.LOGGER.get().logInfo(privacyPolicy_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						privacyPolicy_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(privacyPolicy_Settings, privacyPolicy_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(privacyPolicy_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					privacyPolicy_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify About Us Option
	 * 
	 * @return
	 */
	public SettingsPage verifyAboutUsOption_inSettings() {
		try {
			mobileActions.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading"));
			mobileActions.getText(aboutUS_Settings, aboutUS_Settings_Name, true);
			boolean aboutUsOption = mobileActions.isElmPresent(aboutUS_Settings);
			if (aboutUsOption) {
				BaseTest.LOGGER.get().logInfo(aboutUS_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						privacyPolicy_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(aboutUS_Settings, aboutUS_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(aboutUS_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, aboutUS_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public SettingsPage verifyResourceCenterOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionResourceCenterSubHeading"));
			mobileActions.getText(resourceCenter_Settings, resourceCenter_Settings_Name, true);
			boolean resourceCenterOption = mobileActions.isElmPresent(resourceCenter_Settings);
			if (resourceCenterOption) {
				BaseTest.LOGGER.get().logInfo(resourceCenter_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						resourceCenter_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(resourceCenter_Settings, resourceCenter_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(resourceCenter_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					resourceCenter_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public SettingsPage verifyPlayStoreComplianceOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionPlayStoreCompSubHeading"));
			boolean playStoreOption = mobileActions.isElmPresent(playStoreCompliance_Settings);
			mobileActions.getText(playStoreCompliance_Settings, playStoreCompliance_Settings_Name, true);
			if (playStoreOption) {
				BaseTest.LOGGER.get().logInfo(playStoreCompliance_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						playStoreCompliance_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(playStoreCompliance_Settings, playStoreCompliance_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(playStoreCompliance_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					playStoreCompliance_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public SettingsPage crossButtonInWebPage() {
		boolean crossButton = mobileActions.isElmPresent(closeButton);
		mobileActions.waitForVisible(closeButton);
		mobileActions.click(closeButton, closeButton_Name);
		return this;
	}

	/**
	 * This method is to click on three dots/ellipses from profile of user Jagath
	 * 
	 * @throws IOException
	 */
	public void clickOnThreeDots() {
		mobileActions.waitForVisible(threeDots);
		Assert.assertTrue(mobileActions.isDisplayed(threeDots, threeDots_Name));
		mobileActions.click(threeDots, threeDots_Name);
	}

}
