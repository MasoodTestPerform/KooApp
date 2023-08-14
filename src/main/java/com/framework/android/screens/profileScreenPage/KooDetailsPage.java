package com.framework.android.screens.profileScreenPage;

import java.io.IOException;
import java.util.List;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooCreationPage;
import com.framework.android.allpages.KooRewardsProgramPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class KooDetailsPage {
	MobileActions mobileActions = null;
	KooCreationPage kooCreationPage = null;
	ProfileScreenPage profileScreenPage = null;
	EditProfilePage editProfilePage = null;
	UserBlockPage userBlockPage = null;
	KooCardPage kooCardPage = null;
	KooRewardsProgramPage kooRewardsProgramPage = null;

	public KooDetailsPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooRewardsProgramPage = new KooRewardsProgramPage();
	}

	public void profilePhotos(String language) throws IOException, InterruptedException {
		mobileActions.click(kooCreationPage.btn_profile, "profile button");
		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.img_profilePic, "Profile Photo"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.txt_profileName, "Profile Name"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_selfVerifyTag, "Profile Self Verify Tag"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.txt_profession, "Profession Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.txt_bio, "Bio Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_more, "more button"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_backInProfileScreen, "Back Arrow"));
//		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_threeDots, "Three Dots Button"));
		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_addImages, "Add Images Button"));
		String Count = mobileActions.getText(profileScreenPage.txt_noOfProfilePhotos,
				profileScreenPage.txt_noOfComments_Name, true);
		System.out.println(Count);
//		String noOfKoos=mobileActions.getText(profileScreenPage.txt_noOfKoos, 
//				profileScreenPage.txt_noOfKoos_Name,true);
//		System.out.println(noOfKoos);
//		String noOfLikes=mobileActions.getText(profileScreenPage.txt_noOfLikes, profileScreenPage.txt_noOfLikes_Name, true);
//		System.out.println(noOfLikes);
//		String noOfComments=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfComments"));
//		System.out.println(noOfComments);
//		String noOfReKoos=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfReKoos"));
//		System.out.println(noOfReKoos);
//		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfKoos1"),"LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfSaved"),10);
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfMentions"),
//				"Mentions Tab"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfSaved"),
//				"Saved tab"));
		mobileActions.click(profileScreenPage.btn_addImages, "Add Image button");
		Assert.assertTrue(mobileActions.isDisplayed(editProfilePage.txt_addPhotos, "Add Photos Text"));
		List<WebElement> noofelements = mobileActions.elements(profileScreenPage.btn_addforimage);
		System.out.println(noofelements.size());
		mobileActions.click(profileScreenPage.btn_backInAddphotos, "Back button");
		mobileActions.click(profileScreenPage.img_profilePic, "Profile Photo");
		Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.btn_editProfilePic, "Edit Profile Pic Button"));
		String Count1 = mobileActions.getText(profileScreenPage.txt_noOfProfilePhotos,
				profileScreenPage.txt_noOfProfilePhotos_Name, true);
		System.out.println(Count1);
		mobileActions.swipeRightToLeft(1);
		String Count2 = mobileActions.getText(profileScreenPage.txt_noOfProfilePhotos,
				profileScreenPage.txt_noOfProfilePhotos_Name, true);
		System.out.println(Count2);
		mobileActions.click(profileScreenPage.btn_backInProfilePicturesScreen, "Back button");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_more"), "more button");
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profileNameinMorePopup"),
//				"Profile Name Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_editinMorePopup"),
//				"Edit button"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_professioninMorePopup"),
//				"Profession Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_bioinMorePopup"),
//				"bio Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_dateOfJoininMorePopup"),
//				"date of join Text"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_socialMedialinksHeadinginMorePopup"),
//				"Socia Media Links Text"));
//		mobileActions.click(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_closeinMorePopup"),
//				"Close Button");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInProfileScreen"), "Back Arrow");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "tab_people",peopleTabText), "people tab");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_arrowInPeopleTab"), "Forward arrow");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_publicProfile"), "public Profile");
//		String follow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followInPublicProfile"));
//		System.out.println(follow);
//		mobileActions.swipeUpFindElement(15,MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pplYouCanFollow"));
//		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pplYouCanFollow"),"people you can follow");
//		mobileActions.swipeDown(10);
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followInPublicProfile"),"follow Button");

//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threeDots"), "Three Dots Button");
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_ShareInPublicProfile"),
//				"share button"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followingInPublicProfile"),
//				"follow Button"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_directMsgInPublicProfile"),
//				"Direct message button"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_blockMsgInPublicProfile"),
//				"block button"));
//		Assert.assertTrue(mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_reportUserInPublicProfile"),
//				"Report User Button"));
//		mobileActions.click(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_closeInPublicProfile"),
//				"Close Button");

	}

	public void informationPage(String language) throws IOException, InterruptedException {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			Assert.assertTrue(mobileActions.isDisplayed(kooCardPage.back_button, kooCardPage.back_button_Name));
			Assert.assertTrue(mobileActions.isDisplayed(profileScreenPage.kooFabPlus, "Koo FAB + Button"));
			if (mobileActions.isElmPresent(userBlockPage.threeDots)) {
				mobileActions.click(userBlockPage.threeDots, "Three dots button");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.urlShare, userBlockPage.urlShare_Name), "Share URL",
						true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.editProfile, userBlockPage.editProfile_Name),
						"Edit profile button", true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.scheduledAndDrafts,
								userBlockPage.scheduledAndDrafts_Name),
						"Scheduled & Drafts button", true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.detailedStatistics,
								userBlockPage.detailedStatistics_Name),
						"Detailed Statistics button", true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.manageTopics, userBlockPage.manageTopics_Name),
						"Manage Topics button", true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.settings, userBlockPage.settings_Name),
						"Settings button", true, BaseTest.mobileDriver.get(), true);
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(
						mobileActions.isDisplayed(userBlockPage.closeButton, userBlockPage.closeButton_Name),
						"Close button", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Three dots button is not displayed", true,
						BaseTest.mobileDriver.get(), true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}