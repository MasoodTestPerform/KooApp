package com.framework.android.screens.kooPages;

import java.io.IOException;
import java.util.List;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooCreationPage;
import com.framework.android.allpages.KooDetailScreenPage;
import com.framework.android.allpages.KooRewardsProgramPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.SettingsPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

import org.openqa.selenium.By;
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
	SettingsPage settingsPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;

	public KooDetailsPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooRewardsProgramPage = new KooRewardsProgramPage();
		this.settingsPage = new SettingsPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
	}

	public void commentVerification(String language) throws IOException, InterruptedException {
		mobileActions.click(kooCreationPage.btn_profile, "profile button");
		List<WebElement> noofelements = mobileActions.elements(kooDetailScreenPage.icon_kooComment);
		int size = noofelements.size();
		System.out.println("Size: "+size);
		if(size>0) {
//			for(int i=0; i<size ; i++) 
			for(WebElement ele:noofelements){
				System.out.println("Ele: "+ele);
				mobileActions.click(kooDetailScreenPage.icon_kooComment, "Koo comment icon");
				System.out.println("Success$$$$$$$$$");
				mobileActions.click(kooDetailScreenPage.icon_kooCommentSection, "Koo comment icon in comments");
				mobileActions.click(kooDetailScreenPage.txtbox_comments, "Koo detail comments");
				mobileActions.clearAndSendKeys(kooDetailScreenPage.txtbox_comments, "Koo detail comments", "for testing purpose");
				break;
			}
//			mobileActions.click(kooDetailScreenPage.icon_kooComment, "Koo comment icon");
		}
//		mobileActions.click(kooDetailScreenPage.icon_kooComment, "Koo comment icon");
//		mobileActions.click(kooDetailScreenPage.icon_kooCommentSection, "Koo comment icon in comments");
		
		mobileActions.click(profileScreenPage.btn_backInProfilePicturesScreen, "Back button");
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

	public void accountInfoDetails(String language) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			mobileActions.click(userBlockPage.threeDots, "three dots button");
			mobileActions.click(userBlockPage.settings, "Settings link");
			if (mobileActions.isElmPresent(profileScreenPage.txt_heading)) {
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(
						mobileActions.getText(profileScreenPage.txt_heading, profileScreenPage.settings_hdrname, false),
						profileScreenPage.settings_hdrname, "Settings Header", false, BaseTest.mobileDriver.get(),
						true);

				mobileActions.click(settingsPage.lnk_accInfo, "Account Information link");
				if (mobileActions.isElmPresent(settingsPage.txt_heading)) {
					BaseTest.utilObj.get().getAssertManager().sAssertEquals(
							mobileActions.getText(settingsPage.txt_heading, settingsPage.accountInfo_name, false),
							settingsPage.accountInfo_name, "Account Info Header", false, BaseTest.mobileDriver.get(),
							true);

					mobileActions.isDisplayed(settingsPage.txt_email, "Account Information heading");
					mobileActions.isDisplayed(settingsPage.txt_mobile, "Account Information heading");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
					BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to perform Pinned and Unpinned koos",
					true, BaseTest.mobileDriver.get(), true);
		}
	}

}