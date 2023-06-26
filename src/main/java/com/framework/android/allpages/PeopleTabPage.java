package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class PeopleTabPage {
	
	MobileActions mobileActions = null;
	UserBlockPage userBlockPage = null;
	HomeScreenTabPage homeScreenTabPage = null;
	HashTagScreenPage hashTagScreenPage = null;
	OnBoardingFlowPage onBoardingFlowPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	KooCreationPage kooCreationPage = null;
	CarouselPage carouselPage = null;
	PeopleTabPage peopleTabPage = null;
	ProfileScreenPage profileScreenPage = null;
	ReportUserOptionsTabPage reportUserOptionsTabPage = null;
	
	public void PeopleTabPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.homeScreenTabPage = new HomeScreenTabPage();
		this.hashTagScreenPage = new HashTagScreenPage();
		this.onBoardingFlowPage = new OnBoardingFlowPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.kooCreationPage = new KooCreationPage();
		this.carouselPage = new CarouselPage();
		this.peopleTabPage = new PeopleTabPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.reportUserOptionsTabPage = new ReportUserOptionsTabPage();
		
	}
	
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
	
	

	/**
	 * This method is to verify discover relevant people widget section
	 *
	 * @param expectedText
	 * @return
	 */
	public PeopleTabPage verifyDiscoverRelevantPeopleWidget(String expectedText) {
		boolean diaplyFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabPage.discoverRelevantPeople, "xpath", expectedText), "Discover Relevant Widget section:"+expectedText);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Discover Relevant Widget section:"+expectedText, true, BaseTest.mobileDriver.get(), true);
		return this;
	}

	/**
	 * This method is to verify People Detail Page
	 * 
	 * @param expectedText
	 * @return
	 * @throws IOException
	 */
	public PeopleTabPage verifyPeopleDetailPage(String expectedText)  {
		mobileActions.swipeUpFindElement(50, mobileActions.returnByBasedOnPageNameAndObjectName("ProfileScreen",
				"btn_arrowForSpecificSectionUnderPeopleTa", expectedText));
		mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(profileScreenPage.btn_arrowForSpecificSectionUnderPeopleTa, "xpath", expectedText));
		mobileActions.swipeUp(1);
		mobileActions.click(
				mobileActions.returnByBasedOnPageNameAndObjectName(profileScreenPage.btn_arrowForSpecificSectionUnderPeopleTa,"xpath", expectedText),
				"Click on Forward arrow for people you can follow Carousel under people tab");
		String actualText = mobileActions.getText(carouselPage.peopleYouFollowPageHeading, carouselPage.peopleYouFollowPageHeading_Name, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Validation of People detail page, Expected:"+expectedText, true, BaseTest.mobileDriver.get(), true);
				
		return this;
	}

	/**
	 * This method is to verify Find Your Friends button and click on it after that
	 * verify Your Friend page and Invite contact button
	 * 
	 * @param expectedFindYourFriendBtnText
	 * @param yourFriendHeading_expected
	 * @param inviteButtonText_expected
	 * @return
	 * @throws IOException
	 */
	public PeopleTabPage verifyFindYourFriendsAndInviteButton(String expectedFindYourFriendBtnText,
			String yourFriendHeading_expected, String inviteButtonText_expected)
		{
		mobileActions.swipeUsingText(expectedFindYourFriendBtnText);
		mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabPage.findYourFriendsButton, "xpath", expectedFindYourFriendBtnText));
		boolean diaplyFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabPage.findYourFriendsButton, "xpath",
						expectedFindYourFriendBtnText), "Find Your Friends on Koo button and expected text is = " + expectedFindYourFriendBtnText);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Find Your Friends on Koo button and expected text is = " + expectedFindYourFriendBtnText, true, BaseTest.mobileDriver.get(), true);
		
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabPage.findYourFriendsButton, "xpath",
				expectedFindYourFriendBtnText), "Click on " + expectedFindYourFriendBtnText + " button");
		handlePermissionIfVisible();
		// pushContacts();
		String actualText = mobileActions
				.getText(yourFriendsHeading, "Your Friends page is not opened expected is = " + yourFriendHeading_expected, true);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, yourFriendHeading_expected, "Validation of Your Friends page is opened expected is = " + yourFriendHeading_expected, true, BaseTest.mobileDriver.get(), true);
		
		diaplyFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(inviteButton, "xpath", inviteButtonText_expected),"Invite button is showing for Your Friend page and expected text is = "
				+ inviteButtonText_expected);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(diaplyFlag,true, "Validation of Invite button is showing for Your Friend page and expected text is = " +
				inviteButtonText_expected, true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to click on invite button and verify share with popup
	 * 
	 * @param inviteButtonText_expected
	 * @return
	 * @throws IOException
	 */
	public PeopleTabPage clickOnInviteButtonAndVerifyAlertPopUp(String inviteButtonText_expected) {
		mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(inviteButton, "xpath",
				inviteButtonText_expected));
		mobileActions.click(
				mobileActions.returnByBasedOnPageNameAndObjectName("peopleTab", "inviteButton", inviteButtonText_expected),
				"Click on " + inviteButtonText_expected + " button");
		
		return this;
	}

	/**
	 * Handle permission popup
	 * 
	 * @return
	 * @throws IOException
	 */
	public PeopleTabPage handlePermissionIfVisible()  {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		List<WebElement> permissionPopUp = BaseTest.mobileDriver.get()
				.findElements(allowPermission);
		System.out.println("Size of allow popup is = " + permissionPopUp.size());
		List<WebElement> permissionPopUp_1 = BaseTest.mobileDriver.get()
				.findElements(allowPermission_1);
		System.out.println("Size of allow popup is = " + permissionPopUp_1.size());
		if (permissionPopUp.size() > 0) {
			mobileActions.click(allowPermission, allowPermission_Name);
		} else {
			mobileActions.click(allowPermission_1, allowPermission_1_Name);
		}
		return this;
	}

	public PeopleTabPage pushContacts() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("browserstack.uploadMedia",
				new String[] { "media://90c7a8h8dc82308108734e9a46c24d8f01de12881" });
		return this;
	}

	/**
	 * This method is to verify headings on people tab for all sections
	 * 
	 * @param expectedText
	 * @return
	 */
	public PeopleTabPage verifyPeopleTabSectionHeadings(String[] expectedText) {
		for (int i = 0; i < expectedText.length; i++) {
			mobileActions.swipeUsingText(expectedText[i]);
			mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabSectionHeading, "xpath", expectedText[i]));
			
			boolean isDisplayed = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(peopleTabSectionHeading, "xpath",
					expectedText[i]), expectedText[i] + "' widget section heading is visible under people tab on home page");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(isDisplayed,true, "Validation of "+expectedText[i] + "' widget section heading is visible under people tab on home page", true, BaseTest.mobileDriver.get(), true);
			
			
		}
		return this;
	}

	/**
	 * This method is to verify profile should be refreshed under people tab
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PeopleTabPage verifyProfileShouldChangedAfterRefresh()  {
		mobileActions.swipeUp(1);
		String firstProfile = mobileActions
				.getText(peopleTabProfile, peopleTabProfile_Name, true);
		mobileActions.swipeUp(2);
		mobileActions.swipeDown(60);
		String refreshedProfile = mobileActions
				.getText(peopleTabProfile, peopleTabProfile_Name, true);
		
		boolean isTrue = !firstProfile.equalsIgnoreCase(refreshedProfile);
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(isTrue,true, "Validation of Profile is not refreshed the old profile was = " + firstProfile + " Expected refreshed profile is = "+
				refreshedProfile, true, BaseTest.mobileDriver.get(), true);
		
		return this;
	}

	/**
	 * This method is to verify Navigation to the First People Profile In People Tab
	 * 
	 * @param No
	 * @return name of the profile
	 */

	public String verifyNavigateToFirstPeopleProfileFromPeopleTab() throws Exception {
		String firstProfileName = mobileActions
				.getText(peopleTabFirstProfile, peopleTabFirstProfile_Name, true).trim();
		mobileActions.click(peopleTabFirstProfile,
				"Click on first profile under people tab");
		String profileName = mobileActions
				.getText(peopleTabFirstProfile, peopleTabFirstProfile_Name, true).trim();
		String profileNameInReportUser = null;
		
		if (firstProfileName.equals(profileName)) {
			profileNameInReportUser = firstProfileName;
			mobileActions.click(profileScreenPage.btn_threeDots, profileScreenPage.btn_threeDots_Name);
			mobileActions.click(profileScreenPage.btn_reportUserInPublicProfile, profileScreenPage.btn_reportUserInPublicProfile_Name);
		}
		Thread.sleep(25000);
		return profileNameInReportUser;
	}

	public void validateReportUserOptionsrInReportUserPageFromPeopleTab() throws Exception {
		String reportUserOptionNo;
		String reportUserOptionText;
		List<WebElement> options = BaseTest.mobileDriver.get().findElements(
				reportUserOptionsTabPage.reportTextOptions);
		List<WebElement> optionsNo = BaseTest.mobileDriver.get().findElements(
				reportUserOptionsTabPage.reportNumberOptions);
		int size = options.size();
		for (int i=0;i<size;i++)
		{
			reportUserOptionNo = optionsNo.get(i).getText();
			reportUserOptionText = options.get(i).getText();
			String actualReportOption = reportUserOptionNo + " " + reportUserOptionText;
			System.out.println("Actual Option: " + actualReportOption);
			String expectedReportOption = LanguageDataProvider.getLanguageDataValue("ReportUserOption" + (i+1) +"Txt");
			System.out.println("Expected Option: " + expectedReportOption);
			
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualReportOption,expectedReportOption, "Validation of Report User Options In Report User Page From People Tab. Actual Report Option:"+actualReportOption, true, BaseTest.mobileDriver.get(), true);
		}
	}
}
