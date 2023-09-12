package com.framework.android.allpages;

import org.openqa.selenium.By;
import com.koo.framework.BaseTest;

public class PeopleTabPage {	
	public String discoverRelevantPeople = "(//android.widget.TextView[@text='###']//ancestor::android.view.ViewGroup)[3]//following-sibling::android.widget.TextView[@resource-id='com.koo.app:id/title']"; 
	public By followButton = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/btnFollowView']");
	public By peopleTabProfile = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview']");
	public By allowPermission = By.id("com.android.packageinstaller:id/permission_allow_button");
	public By allowPermission_1 = By.id("com.android.permissioncontroller:id/permission_allow_button");
	public String findYourFriendsButton = "//android.widget.Button[@text='###']";
	public By yourFriendsHeading = By.id("com.koo.app:id/toolbar_heading_textview");
	public String inviteButton = "//android.widget.TextView[@text='###']";
	public By alertTitle = By.id("miui:id/alertTitle");
	public String peopleTabSectionHeading = "//android.widget.TextView[@text='###']";
	public By peopleTabFirstProfile = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview'])[1]");
	public By firstProfileNameObj = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview'])[1]");
	public By firstPeopleFollowPlusObj = By.xpath("(//android.widget.ImageView[@id='com.koo.app:id/ivFollow'])[1]");
	public By firstPeopleFollowTickObj = By.xpath("(//android.widget.ImageView[@id='com.koo.app:id/ivFollow'])[1]");
	public By arrowTopObj = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/arrowTop']");
	public By viewAllObj = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvViewAll']");
	public By addPrefrencesPlusIcon = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/iv_icon']");
	//People Preferences screen
	public By firstPreferencesInPeopleReferences = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/preferenceName']");
	public By firstPreferencesTickIcon = By.xpath("//android.widget.CheckBox[@resource-id='com.koo.app:id/checkbox']");
	public By doneBtn = By.xpath("//android.widget.Button[@resource-id='com.koo.app:id/bt_continue'][text()='DONE']");
	public By firstPreferenceAddedInYourPreferencesObj = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/categories_fb']/android.view.ViewGroup[@resource-id='com.koo.app:id/main_layout']/android.widget.TextView[@resource-id='com.koo.app:id/title']");
	public By LanguageDD = By.xpath("(//android.widget.ImageView[@id='com.koo.app:id/ivArrow'])[1]");
	public By filterLanguageCountryChk2 = By.xpath("//android.widget.CheckBox[@index='2']");
	public By filterLanguageCountryChk3 = By.xpath("//android.widget.CheckBox[@index='3']");
	public By filterLanguageCountryChk4 = By.xpath("//android.widget.CheckBox[@index='4']");
	public By saveBtn = By.xpath("//android.widget.TextView[text()='Save']");
	public By totalLanguageSelectedCnt3 = By.xpath("//android.widget.TextView[text()='+2'][@resource-id='com.koo.app:id/tvCount']");
	public By countryTextBtnInFilterScreen = By.xpath("//android.widget.TextView[text()='Country']");
	public By ViewAllObj = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/lay_view_more_profile']");
	public By firstProfileAfterClickingViewAll = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview']");
	public By profileNameIndividualCorouselProfile = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/channel_name_textview']");
	public By findYourFriendsOnKooBtn = By.xpath("//android.widget.Button[text()='Find your Friends on Koo'][@resource-id='com.koo.app:id/follow_contact_tv']");
	public By followAllFriendsBtn = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvFollowBig']");//Follow all Friends
	public By followButtonInYourFriendsBtn = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/view_follow']");
	public By inviteBtn = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvFollow'][text()='Invite']");
	
	public String discoverRelevantPeople_Name = ""; 
	public String followButton_Name = ""; 
	public String peopleTabProfile_Name = "People Profile Name"; 
	public String allowPermission_Name = "Allow button for handle permission"; 
	public String allowPermission_1_Name = "Allow button for handle permission"; 
	public String findYourFriendsButton_Name = ""; 
	public String yourFriendsHeading_Name = ""; 
	public String inviteButton_Name = ""; 
	public String alertTitle_Name = ""; 
	public String peopleTabSectionHeading_Name = "";
	public String peopleTabFirstProfile_Name = "first profile under people tab";
	public String firstProfileNameObj_Name = "first profile name in People tab";
	public String firstPeopleFollowPlusObj_Name = "first profile Follow plus button in People tab";
	public String firstPeopleFollowTickObj_Name = "first profile Follow tick button in People tab";
	public String arrowTopObj_Name = "Arrow Top appeared after following profile in People tab";
	public String viewAllObj_Name = "View All in People tab";
	public String addPrefrencesPlusIcon_Name = "Add Prefrences Plus Icon";
	public String firstPreferencesInPeopleReferences_Name = "First Preferences I nPeople References";
	public String firstPreferencesTickIcon_Name = "First Preferences Tick Icon";
	public String doneBtn_Name = "Done button";
	public String firstPreferenceAddedInYourPreferencesObj_Name = "first Preference Added In Your Preferences section";	 
	public String LanguageDD_Name = "Language dropdown";
	public String filterLanguageCountryChk2_Name = "Language Country Chkbox no 2 in Filter screen";
	public String filterLanguageCountryChk3_Name = "Language Country Chkbox no 3 in Filter screen";
	public String filterLanguageCountryChk4_Name = "Language Country Chkbox no 4 in Filter screen";
	public String saveBtn_Name = "Save button";
	public String totalLanguageSelectedCnt3_Name = "Language already selected +2";
	public String countryTextBtnInFilterScreen_Name = "Country text button in Filter screen";
	public String ViewAllObj_Name = "View All in People tab";
	public String firstProfileAfterClickingViewAll_Name = "First Profil Name eAfter Clicking View All";
	public String profileNameIndividualCorouselProfile_Name = "Profile Name Individual Corousel Profile";
	public String findYourFriendsOnKooBtn_Name = "Find Your Friends On Koo Btn";
	public String followAllFriendsBtn_Name = "Follow All Friends Button";
	public String followButtonInYourFriendsBtn_Name = "first Follow Button In Your Friends";
	public String inviteBtn_Name = "Invite Button";
	
	public String ValidatePeopleFollowInPeopleTab() {
		FeedTabPage feedTabPage = new FeedTabPage();
		String firstPeopleName = BaseTest.utilObj.get().getMobileActions().getText(firstProfileNameObj, firstProfileNameObj_Name, true);
		BaseTest.utilObj.get().getMobileActions().tapElement(firstPeopleFollowPlusObj, firstPeopleFollowPlusObj_Name);
		BaseTest.utilObj.get().getMobileActions().waitForSec(4);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for follow profile", true, BaseTest.mobileDriver.get());
		BaseTest.utilObj.get().getMobileActions().click(arrowTopObj, arrowTopObj_Name);
		BaseTest.utilObj.get().getMobileActions().waitForSec(4);
		String firstPeopleNameInFeed = BaseTest.utilObj.get().getMobileActions().getText(feedTabPage.firstProfileFollowNameObj, feedTabPage.firstProfileFollowNameObj_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(firstPeopleName, firstPeopleNameInFeed, "Validation of First profile followed in People tab appeared in Feed tab", true, BaseTest.mobileDriver.get(), true);
		return firstPeopleName;
	}
	
	public void ValidateMax3LanguageAndCountrySelectionInPeopleTab() {
		
		BaseTest.utilObj.get().getMobileActions().click(LanguageDD, LanguageDD_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk2, filterLanguageCountryChk2_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk3, filterLanguageCountryChk3_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk4, filterLanguageCountryChk4_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for more than 3 languages selection", true, BaseTest.mobileDriver.get());
		
		BaseTest.utilObj.get().getMobileActions().click(countryTextBtnInFilterScreen, countryTextBtnInFilterScreen_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk2, filterLanguageCountryChk2_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk3, filterLanguageCountryChk3_Name);
		BaseTest.utilObj.get().getMobileActions().click(filterLanguageCountryChk4, filterLanguageCountryChk4_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for more than 3 countries selection", true, BaseTest.mobileDriver.get());
		BaseTest.utilObj.get().getMobileActions().click(saveBtn, saveBtn_Name);
		boolean isDisplayed = BaseTest.utilObj.get().getMobileActions().isDisplayed(totalLanguageSelectedCnt3, totalLanguageSelectedCnt3_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Validation of Languages and Countries options selections", true, BaseTest.mobileDriver.get(), true);
		
	}
	
	public String Validate_AddPreferences_PeopleTab() {
		
		BaseTest.utilObj.get().getMobileActions().click(addPrefrencesPlusIcon, addPrefrencesPlusIcon_Name);
		
		String firstPreferencesName = BaseTest.utilObj.get().getMobileActions().getText(firstPreferencesInPeopleReferences, firstPreferencesInPeopleReferences_Name, true);
		BaseTest.utilObj.get().getMobileActions().tapElement(firstPreferencesTickIcon, firstPreferencesTickIcon_Name);
		BaseTest.utilObj.get().getMobileActions().waitForSec(4);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for follow preferences", true, BaseTest.mobileDriver.get());
		
		BaseTest.utilObj.get().getMobileActions().click(doneBtn, doneBtn_Name);
		
		String firstPreferenceAddedInYourPreferences = BaseTest.utilObj.get().getMobileActions().getText(firstPreferenceAddedInYourPreferencesObj, firstPreferenceAddedInYourPreferencesObj_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(firstPreferenceAddedInYourPreferences, firstPreferencesName, "Validation of preference added in People tab", true, BaseTest.mobileDriver.get(), true);
		
		
		return firstPreferencesName;
		
	}
	
	public void ValidatePeopleFollowed_DisappearedOnRefresh() {
		
		String firstProfileName = BaseTest.utilObj.get().getMobileActions().getText(firstProfileNameObj, firstProfileNameObj_Name, true);
		BaseTest.utilObj.get().getMobileActions().tapElement(firstPeopleFollowPlusObj, firstPeopleFollowPlusObj_Name);
		BaseTest.utilObj.get().getMobileActions().waitForSec(4);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for follow profile", true, BaseTest.mobileDriver.get());
		BaseTest.utilObj.get().getMobileActions().pullToRefreshPage();
		String firstProfileNameAfterRefresh = BaseTest.utilObj.get().getMobileActions().getText(firstProfileNameObj, firstProfileNameObj_Name, true);
		if(firstProfileName.equals(firstProfileNameAfterRefresh)) {
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Validation of profile followed disappeared after refresh successful.", true, BaseTest.mobileDriver.get());
		}else {
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Validation of profile followed disappeared after refresh failed.", true, BaseTest.mobileDriver.get());
		}
		
		BaseTest.utilObj.get().getMobileActions().tapElement(firstPeopleFollowPlusObj, firstPeopleFollowPlusObj_Name);
		
	}
	
	public void Validate_ViewAll() {
		
		BaseTest.utilObj.get().getMobileActions().swipeUsingID("com.koo.app:id/lay_view_more_profile");
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for View All", true, BaseTest.mobileDriver.get());
		BaseTest.utilObj.get().getMobileActions().tapElement(viewAllObj, viewAllObj_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot after clicking View All", true, BaseTest.mobileDriver.get());
		String firstProfileName = BaseTest.utilObj.get().getMobileActions().getText(firstProfileAfterClickingViewAll, firstProfileAfterClickingViewAll_Name, true);
		BaseTest.utilObj.get().getMobileActions().click(firstProfileAfterClickingViewAll, firstProfileAfterClickingViewAll_Name);
		String profileNameAfterClickingProfileCorusel = BaseTest.utilObj.get().getMobileActions().getText(profileNameIndividualCorouselProfile, profileNameIndividualCorouselProfile_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(profileNameAfterClickingProfileCorusel, firstProfileName, "Validation of profile corousel after clicking View All", true, BaseTest.mobileDriver.get(), true);
	}
	
	public void Validate_FollowAllFriends_InviteButton() {
		
		BaseTest.utilObj.get().getMobileActions().swipeUsingID("com.koo.app:id/follow_contact_tv");
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for Find Your Friends on Koo", true, BaseTest.mobileDriver.get());
		BaseTest.utilObj.get().getMobileActions().tapElement(findYourFriendsOnKooBtn, findYourFriendsOnKooBtn_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot after clicking Find Your Friends on Koo", true, BaseTest.mobileDriver.get());
		boolean isDisplayed = BaseTest.utilObj.get().getMobileActions().isDisplayed(followAllFriendsBtn, followAllFriendsBtn_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Validation of Follow All Friends Button", true, BaseTest.mobileDriver.get(), false);
		isDisplayed = BaseTest.utilObj.get().getMobileActions().isDisplayed(followButtonInYourFriendsBtn, followButtonInYourFriendsBtn_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed, true, "Validation of Follow button in your friend's list", true, BaseTest.mobileDriver.get(), true);
		BaseTest.utilObj.get().getMobileActions().swipeUsingID("com.koo.app:id/btnFollowView");
		
		String inviteTextInBtn = BaseTest.utilObj.get().getMobileActions().getText(inviteBtn, inviteBtn_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(inviteTextInBtn, "Invite", "Validation of Invite button in your friend's list", true, BaseTest.mobileDriver.get(), true);
		BaseTest.utilObj.get().getMobileActions().tapElement(inviteBtn, inviteBtn_Name);
		BaseTest.utilObj.get().getMobileActions().waitForSec(8);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Screenshot for WhatsApp Invite", true, BaseTest.mobileDriver.get());
	}
	

	
}
