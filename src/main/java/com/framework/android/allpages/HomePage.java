package com.framework.android.allpages;

import org.openqa.selenium.By;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class HomePage {
	MobileActions mobileActions = null;
		
	public HomePage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();	
	}
	
	public By select_languages = By.xpath("//android.widget.TextView[@text='Select Language']");
	public By backButton_LanguageChange = By.id("com.koo.app:id/select_lang_popup");
	public String englishTyped_language = "(//android.widget.TextView[@text='###'])[1]";
	public String checkBoxes_language = "(//android.widget.TextView[@text='###'])/following-sibling::android.widget.CheckBox";
	public By signInWithMobile_button = By.xpath("(//android.widget.TextView[@text='Sign-in with Mobile'])");
	public By available_languages = By.xpath("//android.widget.TextView[@text='Available Languages']");
	public By comingSoon_languages = By.xpath("//android.widget.TextView[@text='Coming Soon']");
	public By back_button = By.id("com.koo.app:id/select_lang_popup");
	public By back_button1 = By.id("com.koo.app:id/select_lang_popup");
	public By reward_banner = By.xpath("//android.widget.TextView[@text='जारी रखें']");
	public By signInPhone_button = By.id("com.koo.app:id/phone_no_edittext");
	public String signInGoogle_button = "//android.widget.TextView[@text='###']";
	public By chooseAccount_button = By.xpath("//android.widget.TextView[@text='Choose an account']");
	public By googleLoginPage_btn = By.xpath("//android.widget.Button[@text='Next']");
	public By select_account = By.id("com.google.android.gms:id/account_display_name");
	public By profile_registration = By.id("com.koo.app:id/iv_profile");
	public By signInEmail_button = By.id("com.koo.app:id/sign_with_email");
	public By otp_text = By.id("com.koo.app:id/otp_edit_text");
	public By verify_btn = By.id("com.koo.app:id/button_verify");
	public By verify_email_btn = By.id("com.koo.app:id/email_continue_button");
	public By profile_lnk = By.id("com.koo.app:id/img_my_profile");
	public By signIn_Email_Btn = By.id("com.koo.app:id/sign_with_email");
	public By signIn_Email_Heading = By.id("com.koo.app:id/login_header");
	public By enter_email = By.id("com.koo.app:id/email_edittext");
	public By continue_email_button = By.id("com.koo.app:id/email_continue_button");
	public By captcha_popup = By.xpath("//android.widget.Button[@text='VERIFY' or @text='SKIP']");
	public By change_countryCode = By.id("com.koo.app:id/code_tv");
	public String select_countryCode = "//android.widget.TextView[@text='###']";
	public By userName_txt = By.id("com.koo.app:id/channel_name_textview");
	public By back_icon = By.id("com.koo.app:id/layoutBack");
	public String resend_otp_option = "//android.widget.TextView[@text='###']";
	public By login_heading = By.id("com.koo.app:id/phone_no_textview_subtitle");
	public By incorrect_otp_message = By.id("com.koo.app:id/textview_footer_otp");
	public String app_Language = "//android.widget.TextView[@text=\\\"###\\\"]";
	public By MobNo_txt = By.id("com.koo.app:id/phone_no_edittext");
	public By OTP_btn = By.id("com.koo.app:id/phone_no_next_button");
			//+ "//android.widget.Button[text()='Get OTP']");
			
	public By OTP_Email_btn = By.id("com.koo.app:id/email_continue_button");
	public By btn_skip = By.id("com.starhub.csselfhelp.preview:id/txtSkip");
	public By feed_tab = By.id("com.starhub.csselfhelp.preview:id/txtSkip");
	public By txt_homescreen = By.id("com.starhub.csselfhelp.preview:id/imvLogo");
	public By btn_login = By.id("com.starhub.csselfhelp.preview:id/tvLogin");
	public By btn_loginwithHubId = By.id("com.starhub.csselfhelp.preview:id/layoutRoot");
	public By btn_setuplater = By.xpath("//android.widget.TextView[@text='Set up later']");
	public By btn_Hub_ID = By.id("com.starhub.csselfhelp.preview:id/etEmail");
	public By btn_pwd = By.id("com.starhub.csselfhelp.preview:id/etPassword");
	public By btn_login_hubid = By.xpath("//android.widget.TextView[@text='Login']");
	public By btn_entertainment = By.xpath("//android.widget.TextView[@text='Entertainment']");
	public By btn_amazon = By.xpath("//android.widget.TextView[@text='Amazon Prime']");
	public By btn_hotstar = By.xpath("//android.widget.TextView[@text='Hotstar']");
	public By btn_explore = By.xpath("//android.widget.TextView[@text='Explore']");
	public By btn_Next = By.xpath("//android.widget.TextView[@text='Next']");
	public By btn_accept_terms = By.id("com.starhub.csselfhelp.preview:id/cbAcceptTerm");
	public By btn_subscribe = By.xpath("(//android.widget.TextView[@text='Subscribe now'])[1]");
	public By btn_x = By.id("com.starhub.csselfhelp.preview:id/imv_option_close");
	public By btn_ok = By.xpath("//android.widget.Button[@text='Ok']");
	public By txt_verifyhotstar = By.id("com.starhub.csselfhelp.preview:id/tvHeaderSubTitle");
	public By btn_mobile = By.xpath("//android.widget.TextView[@text='Mobile']");
	public By btn_done = By.xpath("//android.widget.TextView[@text='Done']");
	public By btn_local = By.xpath("//android.widget.TextView[@text='Local']");
	public By btn_addons = By.xpath("//android.widget.TextView[@text='Add-ons']");
	public By btn_otheraddonsManage = By.xpath("(//android.widget.TextView[@text='Manage'])[2]");
	public By btn_manage = By.xpath("//android.widget.TextView[@text='Manage']");
	public By btn_add = By.xpath("(//android.widget.TextView[@text='Add'])[1]");
	public By btn_reviewchanges = By.xpath("//android.widget.TextView[@text='Review changes']");
	public By btn_submit = By.xpath("//android.widget.TextView[@text='Submit']");
	public By btn_OK = By.xpath("//android.widget.Button[@text='OK']");
	public By btn_closeimage = By.id("com.starhub.csselfhelp.preview:id/imgClose");
	public By btn_back = By.id("com.starhub.csselfhelp.preview:id/ic_left");
	public By btn_verify_request = By.xpath("//android.widget.TextView[@text='We are processing a request']");
	public By btn_pending = By.xpath("(//android.widget.TextView[@text='PENDING'])[1]");
	
	
	
	public String select_languages_Name = "";
	public String backButton_LanguageChange_Name = "Languagae Back button";
	public String englishTyped_language_Name = "";
	public String checkBoxes_language_Name = "";
	public String signInWithMobile_button_Name = "";
	public String available_languages_Name = "";
	public String comingSoon_languages_Name = "";
	public String back_button_Name = "";
	public String back_button1_Name = "";
	public String reward_banner_Name = "";
	public String signInPhone_button_Name = "";
	public String signInGoogle_button_Name = "";
	public String chooseAccount_button_Name = "Choose Account button";
	public String googleLoginPage_btn_Name = "";
	public String select_account_Name = "";
	public String profile_registration_Name = "";
	public String signInEmail_button_Name = "sign-In Email button";
	public String otp_text_Name = "OTP text box";
	public String verify_btn_Name = "Verify button";
	public String verify_email_btn_Name = "Verify email button after OTP enetered";
	public String profile_lnk_Name = "Profile Link";
	public String signIn_Email_Btn_Name = "";
	public String signIn_Email_Heading_Name = "";
	public String enter_email_Name = "Enter email text box";
	public String continue_email_button_Name = "";
	public String captcha_popup_Name = "";
	public String change_countryCode_Name = "";
	public String select_countryCode_Name = "";
	public String userName_txt_Name = "";
	public String back_icon_Name = "";
	public String resend_otp_option_Name = "";
	public String login_heading_Name = "Login Heading";
	public String incorrect_otp_message_Name = "";
	public String app_Language_Name = "";
	public String MobNo_txt_Name = "Mobile Number text field";
	public String OTP_btn_Name = "OTP button";
	public String OTP_Email_btn_Name = "OTP button for email";
	public String btn_skip_Name = "";
	public String feed_tab_Name = "";
	public String txt_homescreen_Name = "";
	public String btn_login_Name = "";
	public String btn_loginwithHubId_Name = "";
	public String btn_setuplater_Name = "";
	public String btn_Hub_ID_Name = "";
	public String btn_pwd_Name = "";
	public String btn_login_hubid_Name = "";
	public String btn_entertainment_Name = "";
	public String btn_amazon_Name = "";
	public String btn_hotstar_Name = "";
	public String btn_explore_Name = "";
	public String btn_Next_Name = "";
	public String btn_accept_terms_Name = "";
	public String btn_subscribe_Name = "";
	public String btn_x_Name = "";
	public String btn_ok_Name = "";
	public String txt_verifyhotstar_Name = "";
	public String btn_mobile_Name = "";
	public String btn_done_Name = "";
	public String btn_local_Name = "";
	public String btn_addons_Name = "";
	public String btn_otheraddonsManage_Name = "";
	public String btn_manage_Name = "";
	public String btn_add_Name = "";
	public String btn_reviewchanges_Name = "";
	public String btn_submit_Name = "";
	public String btn_OK_Name = "";
	public String btn_closeimage_Name = "";
	public String btn_back_Name = "";
	public String btn_verify_request_Name = "";
	public String btn_pending_Name = "";
	
	public void validate_InterestSelection_PeoplePage(String interestSelected) {
		By interestTopicSelectedInYourPreferences = By.xpath("(//android.view.ViewGroup[@resource-id='com.koo.app:id/leaderboard_layout']//android.widget.LinearLayout)[2]//android.view.ViewGroup[@resource-id='com.koo.app:id/main_layout']//android.widget.TextView[@resource-id='com.koo.app:id/title']");
		String interestTopicSelectedInYourPreferencesVal = this.mobileActions.getText(interestTopicSelectedInYourPreferences, "Interested Topic in your preference", true);
		if(interestSelected.equals("Politics")) {
			interestSelected = "Politicians";
		}
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(interestTopicSelectedInYourPreferencesVal, interestSelected, "Validation of interest selected as :"+interestSelected+" selection in People screen under Your Preferences", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_PremiumPage() {
		By eminentKooVerifiedHeader = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/header_text']");
		String eminentKooVerifiedHeaderVal = this.mobileActions.getText(eminentKooVerifiedHeader, "Eminent Koo Verified Header", true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(eminentKooVerifiedHeaderVal, "Koo Verified (Eminent)", "Validation of Eminent Koo Verified Header text in Premium screen", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_PollsPage() {
		By numberWithVotes = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tv_votes']");
		String numberWithVotesVal = this.mobileActions.getText(numberWithVotes, "Number with Votes", true);
		BaseTest.utilObj.get().getAssertManager().sAssertContains(numberWithVotesVal, "votes", "Validation of Votes text in Polls screen", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_VideosPage() {
		By videosTimeElapsed = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/time_elapsed']");
		String videosTimeElapsedDisplayed = this.mobileActions.getAttribute(videosTimeElapsed, "displayed","Videos Time Elapsed");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(videosTimeElapsedDisplayed, "true", "Validation of Videos Time Elapsed in Videos screen", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_FriendsPage() {
		By findYourFriendsOnKoo = By.xpath("//android.widget.Button[@resource-id='com.koo.app:id/follow_contact_tv']");
		String findYourFriendsOnKooVal = this.mobileActions.getText(findYourFriendsOnKoo, "Find Your Friends On Koo", true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(findYourFriendsOnKooVal, "Find your Friends on Koo", "Validation of Find Your Friends On Koo button in Friends screen", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_NewPage() {
		//By whatsOnYourMind = By.xpath("//android.widget.TextView[text()='What's on your mind...']");
		//String whatsOnYourMindDisplayed = this.mobileActions.getAttribute(whatsOnYourMind, "displayed", "Whats On Your Mind");
		//BaseTest.utilObj.get().getAssertManager().sAssertEquals(whatsOnYourMindDisplayed, "true", "Validation of Whats On Your Mind placeholder text in New screen", true, BaseTest.mobileDriver.get(), false);		
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "New tab screenshot", true, BaseTest.mobileDriver.get());
	}
	
	public void validate_InterestSelection_FollowingPage(String interestSelected) {
		By firstTopicAndViewMore = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/justification_container']/android.widget.TextView[@resource-id='com.koo.app:id/tv_koo_header']");
		String firstTopicAndViewMoreVal = this.mobileActions.getText(firstTopicAndViewMore, "Topic selected and view more in Following page", true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(firstTopicAndViewMoreVal, interestSelected + "  • View more", "Validation of interest selected as :"+interestSelected+" in Following page", true, BaseTest.mobileDriver.get(), false);		
	}
	
	public void validate_PopularPage() {
		By yellowImageBadge = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/imgBadge']");
		String yellowImageBadgeDisplayed = this.mobileActions.getAttribute(yellowImageBadge, "displayed", "Yellow Image Badge");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(yellowImageBadgeDisplayed, "true", "Validation of Yellow Image Badge in Popular screen", true, BaseTest.mobileDriver.get(), false);		
	}
}
