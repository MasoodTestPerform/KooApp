package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.framework.android.allpages.*;

public class OnBoardingFlowPage {
	
	MobileActions mobileActions = null;
	PeopleTabPage peopleTabPage = null;
		
	public void PeopleTabPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.peopleTabPage = new PeopleTabPage();
		
		
	}
	
	public String feedTab_Text = "//android.widget.TextView[@text='###']";
	public By topicsArrangedCategories = By.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id='com.koo.app:id/topicFollowUnfollow']");
	public By userName_Field = By.id("com.koo.app:id/et_name");
	public By continueButton = By.id("com.koo.app:id/bt_continue");
	public By cameraIconOnGalleryPage = By.id("com.koo.app:id/album_image");
	public By interestText = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/preferenceName'])[1]");
	public By interestCheckbox = By.xpath("//android.widget.CheckBox[@resource-id='com.koo.app:id/checkbox']");
	public By skipButton = By.id("com.koo.app:id/skip_btn");
	public By preferences = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/preferenceName']");
	public By topicElement = By.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id='com.koo.app:id/topicFollowUnfollow']//following-sibling::android.widget.TextView");
	public By selectedTopicOnFeed = By.xpath("//android.view.ViewGroup[@resource-id='com.koo.app:id/justification_container']//following-sibling::android.widget.TextView");
	public By followProfilePlusButton = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/ivPlus']");
	public By kooHeaderForSelectedInterest = By.id("com.koo.app:id/tv_koo_header");
	public By addProfilePictureHeaderText = By.id("com.koo.app:id/tv_header");
	
	public By headerText = By.id("com.koo.app:id/tv_header");
	public By addProfileNameCaptionText = By.id("com.koo.app:id/app_profile_caption");
	public By editFullNameField = By.id("com.koo.app:id/et_name");
	public By skipOrContinueButton = By.id("com.koo.app:id/bt_continue");
	public By skipButtonCaptionText = By.id("com.koo.app:id/you_can_always_change_later");
	public By editProfilePicImage = By.id("com.koo.app:id/edit_image_layout");
	public By backArrowFromGallery = By.id("com.koo.app:id/back_imageview");
	
	public By nameOfPeoplePreferences = By.id("com.koo.app:id/preferenceName");
	public By yourPreferencesPageHeaderText = By.id("com.koo.app:id/textview2");
	public By yourPreferencesCaptionText = By.id("com.koo.app:id/textview3");
	public By addYourPreferenceCheckBox = By.id("com.koo.app:id/checkbox");
	public By peopleYouCanFollowHeaderText = By.id("com.koo.app:id/tvHeading");
	public By peopleYouCanFollowSubHeaderText = By.id("com.koo.app:id/tvSubheading");
	public By peopleYouCanFollowFirstProfile = By.id("com.koo.app:id/channel_name_textview");
	public By peopleYouCanFollowPageFollowButton = By.id("com.koo.app:id/tvFollow");
	public By followTopicsImage = By.id("com.koo.app:id/ivTopics");
	public By followTopicsHeaderText = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/tvHeading']");
	public By followTopicsSubHeaderText = By.id("com.koo.app:id/tvSubheading");
	public By followTopicsFirstTopCategory = By.xpath("(//androidx.compose.ui.platform.ComposeView[@resource-id='com.koo.app:id/topicFollowUnfollow']/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View)[1]/android.widget.TextView");
	public By followTopicsFirstTopCategoryPlusSign = By.xpath("(//androidx.compose.ui.platform.ComposeView[@resource-id='com.koo.app:id/topicFollowUnfollow']/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View)[1]/android.view.View");
		
	
	public String feedTab_Text_Name = "";
	public String topicsArrangedCategories_Name = "";
	public String userName_Field_Name = "";
	public String continueButton_Name = "Continue button";
	public String cameraIconOnGalleryPage_Name = "";
	public String interestText_Name = "";
	public String interestCheckbox_Name = "";
	public String skipButton_Name = "Skip button";
	public String preferences_Name = "";
	public String topicElement_Name = "";
	public String selectedTopicOnFeed_Name = "";
	public String followProfilePlusButton_Name = "";
	public String kooHeaderForSelectedInterest_Name = "";
	public String headerText_Name = "Header in Add Name";
	public String addProfileNameCaptionText_Name = "";
	public String editFullNameField_Name = "";
	public String skipOrContinueButton_Name = "Skip/Continue";
	public String skipButtonCaptionText_Name = "";
	public String editProfilePicImage_Name = "Profile Pic Edit";
	public String backArrowFromGallery_Name = "Back button";
	public String nameOfPeoplePreferences_Name = "";
	public String yourPreferencesPageHeaderText_Name = "People Prefrences Header";
	public String yourPreferencesCaptionText_Name = "";
	public String addYourPreferenceCheckBox_Name = "Check box (+) button";
	public String peopleYouCanFollowHeaderText_Name = "People You can follow";
	public String peopleYouCanFollowSubHeaderText_Name = "";
	public String peopleYouCanFollowFirstProfile_Name = "";
	public String peopleYouCanFollowPageFollowButton_Name = "";
	public String followTopicsImage_Name = "Follow Topics Image";
	public String followTopicsHeaderText_Name = "";
	public String followTopicsSubHeaderText_Name = "";
	public String followTopicsFirstTopCategory_Name = "First topic category in TOP";
	public String followTopicsFirstTopCategoryPlusSign_Name = "First topic category + sign in TOP";
	public String addProfilePictureHeaderText_Name = "Add Profile Picture header text";
	
	//working latest
	public String ValidateSelectFirstInterestTopicName() {
		By firstPrefrencesTopic = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/preferenceName'])[1]");
		String firstPrefrencesTopicName = this.mobileActions.getText(firstPrefrencesTopic, "First Prefrences Topic", true);
		By firstPrefrencesTopicCheckbox = By.xpath("(//android.widget.CheckBox[@resource-id='com.koo.app:id/checkbox'])[1]");
		this.mobileActions.click(firstPrefrencesTopicCheckbox, firstPrefrencesTopicName + " Checkbox");
		String checkedAttrbuteVal = this.mobileActions.getAttribute(firstPrefrencesTopicCheckbox, "checked", firstPrefrencesTopicName + " Checkbox", true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(checkedAttrbuteVal, "checked", "Validation of First Prefrences Topic:"+firstPrefrencesTopicName+" selection", true, BaseTest.mobileDriver.get(), false);
		return firstPrefrencesTopicName;
	}
	
	public void selectedFirstTopicYouFollowValidationNewUser_InterestSelection(String interestSelected) {
		
		By firstTopicYouFollow = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/item_title'])[1]");
		By firstTopicYouFollowTickMark = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/iv_follow_icon'])[1]");
		By sureYouUnfollowYesBtn = By.xpath("(//android.widget.Button[@resource-id='android:id/button1'])[1]");
		By firstTopicYouFollowPlusMark = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/follow_blink'])[1]");
	}
	
	
	public OnBoardingFlowPage verifyNewUserAbleToViewUserNamePage() throws Exception {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify Add Your Name page", false, BaseTest.mobileDriver.get());
		mobileActions.getText(headerText, headerText_Name, true);//need to ask this statement from Jagath
		
		boolean displayFlag = mobileActions.isDisplayed(headerText, headerText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of Header", true, BaseTest.mobileDriver.get(), true);
		
		displayFlag = mobileActions.isDisplayed(userName_Field, userName_Field_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of user Name field", true, BaseTest.mobileDriver.get(), true);

		
		
		mobileActions.sendKeys(userName_Field, userName_Field_Name, "Test OnBoading");
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		//ReportManager.logPass("Add Your Name Page is Displayed Successfully");//need to ask this statement from Jagath
		return this;
	}

	/**
	 * This method is to verify Edit user name page for OnBoarding people
	 *
	 * @return
	 * @throws IOException
	 */
	public OnBoardingFlowPage verifyNewUserAbleToviewProfileImagePage()  {
		
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify Add Profile picture page", false, BaseTest.mobileDriver.get());
		boolean displayFlag = mobileActions.isDisplayed(headerText, headerText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of Header", false, BaseTest.mobileDriver.get(), true);
		
		displayFlag = mobileActions.isDisplayed(editProfilePicImage, editProfilePicImage_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of Profile Pic Edit", false, BaseTest.mobileDriver.get(), true);
		
		
	
		mobileActions.click(editProfilePicImage, editProfilePicImage_Name);
		mobileActions.waitForVisible(peopleTabPage.allowPermission_1);
		mobileActions.click(peopleTabPage.allowPermission_1, peopleTabPage.allowPermission_1_Name);
		mobileActions.click(backArrowFromGallery, backArrowFromGallery_Name);
		//ReportManager.logPass("Add Profile Picture Page is Displayed Successfully");//need to ask this statement from Jagath
		return this;

	}

	/**
	 * This method is to verify Preferences Page
	 *
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public OnBoardingFlowPage verifyUserAbleToViewAddPreferencesPage(){
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify Preference page", false, BaseTest.mobileDriver.get());
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.getText(yourPreferencesPageHeaderText, yourPreferencesPageHeaderText_Name, true);
		
		boolean displayFlag = mobileActions.isDisplayed(yourPreferencesPageHeaderText, yourPreferencesPageHeaderText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of Your Preferences Header", true, BaseTest.mobileDriver.get(), true);

		
		mobileActions.getText(yourPreferencesCaptionText, yourPreferencesCaptionText_Name, true);
		mobileActions.swipeUp(3);
		String prefrenceName;
		List<WebElement> prefrence = BaseTest.mobileDriver.get().findElements(nameOfPeoplePreferences);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to validate Report Koo Options Text", false, BaseTest.mobileDriver.get());
		int size = prefrence.size();
		for (int i = 0; i < size; i++) {
			prefrenceName = prefrence.get(i).getText();
			System.out.println("Prefrences: " + prefrenceName);
		}
		mobileActions.swipeDown(3);
		mobileActions.click(addYourPreferenceCheckBox, addYourPreferenceCheckBox_Name);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		mobileActions.click(addYourPreferenceCheckBox, addYourPreferenceCheckBox_Name);
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "People Preferences Options Text is Validated", false, BaseTest.mobileDriver.get());
		//Reporter.log("People Preferences Options Text is Validated");//need to ask Jagath
		return this;
	}

	/**
	 * This method is to verify Preferences Page
	 *
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public OnBoardingFlowPage verifyUserAbleToViewFollowPeoplePage() throws Exception {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify People Follow page", false, BaseTest.mobileDriver.get());
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.getText(peopleYouCanFollowHeaderText, peopleYouCanFollowHeaderText_Name, true);
//		mobileActions.getText(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "yourPreferencesPageHeader"));
		boolean displayFlag = mobileActions.isDisplayed(peopleYouCanFollowHeaderText, peopleYouCanFollowHeaderText_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of People You can follow", true, BaseTest.mobileDriver.get(), true);

		
		mobileActions.getText(peopleYouCanFollowSubHeaderText, peopleYouCanFollowSubHeaderText_Name, true);
		String firstProfileName = mobileActions
				.getText(peopleTabPage.peopleTabFirstProfile, peopleTabPage.peopleTabFirstProfile_Name, true).trim();
		System.out.println(firstProfileName);
		mobileActions.getText(peopleYouCanFollowFirstProfile, peopleYouCanFollowFirstProfile_Name, true);
		mobileActions.click(peopleYouCanFollowPageFollowButton, peopleYouCanFollowPageFollowButton_Name);
		mobileActions.swipeUp(3);
		mobileActions.swipeDown(3);
		//Reporter.log("People Follow Options Validated");// need to ask Jagath
		return this;
	}

	public OnBoardingFlowPage verifyUserAbleToViewFollowTopicsPage(){
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify Follow Topics page", false, BaseTest.mobileDriver.get());
		
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.click(skipOrContinueButton, skipOrContinueButton_Name);
		mobileActions.click(skipButton, skipButton_Name);
		mobileActions
				.getText(followTopicsHeaderText, followTopicsHeaderText_Name, true);
//		mobileActions.getText(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "yourPreferencesPageHeader"));
		boolean displayFlag = mobileActions.isDisplayed(followTopicsImage, followTopicsImage_Name);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(displayFlag,true, "Validatin of Follow Topics", true, BaseTest.mobileDriver.get(), true);
		
		mobileActions.getText(followTopicsSubHeaderText, followTopicsSubHeaderText_Name, true);
		mobileActions.swipeUp(3);
		mobileActions.swipeDown(3);
		//Reporter.log("Follow Topics page Validated");
		return this;
	}

	/**
	 * This method is to
	 *
	 * @return
	 * @throws IOException
	 */
	public OnBoardingFlowPage userAbleToFollowUnfollow() {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to Verify User able to follow and unfollow", false, BaseTest.mobileDriver.get());
		String firstProfileName = mobileActions
				.getText(peopleTabPage.peopleTabFirstProfile, peopleTabPage.peopleTabFirstProfile_Name, true).trim();

		return this;
	}

	
	
}
