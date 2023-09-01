package com.framework.android.screens.profileScreenPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.FeedTabPage;
import com.framework.android.allpages.HomePage;
import com.framework.android.allpages.HomeScreenTabPage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooCreationPage;
import com.framework.android.allpages.KooRewardsProgramPage;
import com.framework.android.allpages.ManageTopicsPage;
import com.framework.android.allpages.PeopleTabPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.SettingsPage;
import com.framework.android.allpages.TopicsPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class ElementsPage {

	MobileActions mobileActions = null;
	TopicsPage topicsPage = null;
	UserBlockPage userBlockPage = null;
	ManageTopicsPage manageTopicsPage = null;
	KooCardPage kooCardPage = null;
	KooRewardsProgramPage kooRewardsProgramPage = null;
	FeedTabPage feedTabPage = null;
	ProfileScreenPage profileScreenPage = null;
	EditProfilePage editProfilePage = null;
	KooCreationPage kooCreationPage = null;
	HomePage homePage = null;
	SettingsPage settingsPage = null;

	public ElementsPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooRewardsProgramPage = new KooRewardsProgramPage();
		this.settingsPage = new SettingsPage();
		this.topicsPage = new TopicsPage();
		this.manageTopicsPage = new ManageTopicsPage();
		this.feedTabPage = new FeedTabPage();
		this.homePage = new HomePage();

	}

	public void elements(String language, String peopleTabText) throws IOException, InterruptedException {
		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(profileScreenPage.tab_people, "xpath",
				profileScreenPage.tab_people_Name), "People Tab");
		mobileActions.click(profileScreenPage.btn_arrowInPeopleTab, "Forward arrow");
		mobileActions.click(profileScreenPage.btn_publicProfile, "public Profile");
		mobileActions.swipeUsingID("tvFollow");
		String follow = mobileActions.getText(profileScreenPage.btn_followInPublicProfile,
				profileScreenPage.btn_followInPublicProfile_Name, true);
		System.out.println(follow);
		mobileActions.swipeDown(2);
		mobileActions.click(profileScreenPage.btn_backInProfileScreen, "Back button");
		mobileActions.click(editProfilePage.btn_backArrow, "Back button");
		mobileActions.click(kooCreationPage.btn_profile, "profile button");
		mobileActions.click(profileScreenPage.btn_threeDots, "Three Dots Button");
		mobileActions.click(userBlockPage.settings, "Settings Button");
		CommonHelper.logOutUser();

	}
//	public void newUserLogin(String language) throws IOException, InterruptedException {
//		mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(
//				kooCreationPage.Chkbox_Select_Language, "xpath", language), "language Checkobx");
//        mobileActions.sendKeys(homePage.MobNo_txt, homePage.MobNo_txt_Name, 
//        		TestConfig.getInstance().getNewUserNumber());
//        mobileActions.click(homePage.OTP_btn, "get OTP Button");
//        mobileActions.sendKeys(kooCreationPage.lbl_OTP, kooCreationPage.lbl_OTP_Name,
//        		TestConfig.getInstance().get);
//        mobileActions.click(homePage.verify_btn, "Verify Button");
//        mobileActions.click(profileScreenPage.skipAndContinue, "Skip and Continue Button");
//        mobileActions.click(profileScreenPage.skipAndContinue, "Skip and Continue Button");
//        Thread.sleep(10000);
//		boolean isNothanks = mobileActions.isElmPresent(By.id("com.android.vending:id/0_resource_name_obfuscated"));
//		if (isNothanks) {
//			List<WebElement> lstElm = mobileActions.elements(By.id("com.android.vending:id/0_resource_name_obfuscated"));
//			for (WebElement webElement : lstElm) {
//				if(webElement.getText().equals("NO, THANKS")||webElement.getText().equals("NO THANKS")) {
//					webElement.click();
//					break;
//				}
//			}
//			
//		}
//		try {
//			Assert.assertTrue(mobileActions.isDisplayed(
//					MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_lnk"),
//					"Profile link is visible after login"));
//			ReportManager.logPass("Logged In Successfully");
//		} catch (Exception e) {
//			// Retry verify OTP 3 times and then validate profile link
//			for (int i = 0; i < 3; i++) {
//				mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "otp_text"),
//						ConfigReader.getValue("Password"));
//				Thread.sleep(5000);
//				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
//						"Click on Verify button");
//			}
//			Assert.assertTrue(mobileActions.isDisplayed(
//					MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_lnk"),
//					"Profile link is visible after login"));
//		}
//        
//	}
//	public void verifyNokKoosInNewUser() throws IOException {
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
//                "ProfileIcon");
//		mobileActions.swipeUp(1);
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "createFirstKoo"), "Create First Koo button"));
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "likesKoos"),
//                "like button");
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "commentsKoos"),
//                "comments button");
//		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
//		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "commentsKoos"), "LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "mentionsKoos") , 2);
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "mentionsKoos"),
//                "mentions button");
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
//		
//	}

}