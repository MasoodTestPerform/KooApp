package com.framework.android.screens.kooPages;

import java.io.IOException;
import java.util.List;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooDetailScreenPage;
import com.framework.android.allpages.KooRewardsProgramPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.SettingsPage;
import com.framework.android.allpages.*;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class KooCreationPages {
	MobileActions mobileActions = null;
	KooCreationPage kooCreationPage = null;
	ProfileScreenPage profileScreenPage = null;
	EditProfilePage editProfilePage = null;
	UserBlockPage userBlockPage = null;
	KooCardPage kooCardPage = null;
	KooRewardsProgramPage kooRewardsProgramPage = null;
	SettingsPage settingsPage = null;
	KooDetailScreenPage kooDetailScreenPage = null;
	FeedTabPage feedTabPage = null;

	public KooCreationPages() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooRewardsProgramPage = new KooRewardsProgramPage();
		this.settingsPage = new SettingsPage();
		this.kooDetailScreenPage = new KooDetailScreenPage();
		this.feedTabPage = new FeedTabPage();
	}

		public void kooCreationWithText(String language) throws IOException, InterruptedException {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			
			Assert.assertTrue(mobileActions.isDisplayed(feedTabPage.btn_plus, "Koo FAB + Button"));
			mobileActions.click(feedTabPage.btn_plus, "plus button");			
			
			if (mobileActions.isElmPresent(kooCreationPage.txt_bftEditTxt)) {
				mobileActions.sendKeys(kooCreationPage.txt_bftEditTxt, kooCreationPage.txt_bftEditTxt_Name, "Testing purpose");
				mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", kooCreationPage.btn_post_Name), "kooCreationPage.btn_post_Name");
				mobileActions.click(kooCreationPage.btn_no_multipleLang, "no button");
				twoDotsWithDelete();
			} else {
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to post the text message", true,
						BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		public void kooCreationWithImage(String language) throws IOException, InterruptedException {
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
					BaseTest.mobileDriver.get());
			try {				
				Assert.assertTrue(mobileActions.isDisplayed(feedTabPage.btn_plus, "Koo FAB + Button"));
				mobileActions.click(feedTabPage.btn_plus, "plus button");			
				
				if (mobileActions.isElmPresent(kooCreationPage.txt_bftEditTxt)) {
					mobileActions.sendKeys(kooCreationPage.txt_bftEditTxt, kooCreationPage.txt_bftEditTxt_Name, "Testing purpose");
					mobileActions.click(kooCreationPage.btn_add_image, "image button");
					if(mobileActions.isElmPresent(kooCreationPage.btn_enablePermission)) {
						mobileActions.click(kooCreationPage.btn_enablePermission, "enable permission button");
					}
					if(mobileActions.isElmPresent(kooCreationPage.btn_allowApp)) {
						mobileActions.click(kooCreationPage.btn_allowApp, "while using the app button");
						mobileActions.click(kooCreationPage.btn_allow, "allow button");
					}
					mobileActions.click(kooCreationPage.btn_camera, "camera button");
					mobileActions.click(kooCreationPage.btn_capturePhoto, "capture photo button");
					mobileActions.click(kooCreationPage.btn_ok, "ok button");
					mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", kooCreationPage.btn_post_Name), "kooCreationPage.btn_post_Name");
					mobileActions.click(kooCreationPage.btn_no_multipleLang, "no button");
					twoDotsWithDelete();
				} else {
					BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to post the text message", true,
							BaseTest.mobileDriver.get(), true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void kooCreationWithVideo(String language) throws IOException, InterruptedException {
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
					BaseTest.mobileDriver.get());
			try {				
				Assert.assertTrue(mobileActions.isDisplayed(feedTabPage.btn_plus, "Koo FAB + Button"));
				mobileActions.click(feedTabPage.btn_plus, "plus button");			
				
				if (mobileActions.isElmPresent(kooCreationPage.txt_bftEditTxt)) {
					mobileActions.sendKeys(kooCreationPage.txt_bftEditTxt, kooCreationPage.txt_bftEditTxt_Name, "Testing purpose");
					mobileActions.click(kooCreationPage.btn_add_video, "video button");
					if(mobileActions.isElmPresent(kooCreationPage.btn_enablePermission)) {
						mobileActions.click(kooCreationPage.btn_enablePermission, "enable permission button");
					}
					if(mobileActions.isElmPresent(kooCreationPage.btn_allowApp)) {
						mobileActions.click(kooCreationPage.btn_allowApp, "while using the app button");
						mobileActions.click(kooCreationPage.btn_allow, "allow button");
					}
					mobileActions.click(kooCreationPage.gallery_video, "choose video");
					mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(
							kooCreationPage.btn_post, "xpath", kooCreationPage.btn_post_Name), 
							"kooCreationPage.btn_post_Name");
					mobileActions.click(kooCreationPage.btn_no_multipleLang, "no button");
					twoDotsWithDelete();
				} else {
					BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to post the text message", true,
							BaseTest.mobileDriver.get(), true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void kooCreationWithAudio(String language) throws IOException, InterruptedException {
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
					BaseTest.mobileDriver.get());
			try {
				
				Assert.assertTrue(mobileActions.isDisplayed(feedTabPage.btn_plus, "Koo FAB + Button"));
				mobileActions.click(feedTabPage.btn_plus, "plus button");			
				
				if (mobileActions.isElmPresent(kooCreationPage.txt_bftEditTxt)) {
					mobileActions.sendKeys(kooCreationPage.txt_bftEditTxt, kooCreationPage.txt_bftEditTxt_Name, "Testing purpose");
					mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", kooCreationPage.btn_post_Name), "kooCreationPage.btn_post_Name");
					mobileActions.click(kooCreationPage.btn_no_multipleLang, "no button");
					twoDotsWithDelete();
				} else {
					BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to post the text message", true,
							BaseTest.mobileDriver.get(), true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void kooCreationWithGif(String language) throws IOException, InterruptedException {
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
					BaseTest.mobileDriver.get());
			try {
				
				Assert.assertTrue(mobileActions.isDisplayed(feedTabPage.btn_plus, "Koo FAB + Button"));
				mobileActions.click(feedTabPage.btn_plus, "plus button");			
				
				if (mobileActions.isElmPresent(kooCreationPage.txt_bftEditTxt)) {
					mobileActions.sendKeys(kooCreationPage.txt_bftEditTxt, kooCreationPage.txt_bftEditTxt_Name, "Testing purpose");
					mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", kooCreationPage.btn_post_Name), "kooCreationPage.btn_post_Name");
					mobileActions.click(kooCreationPage.btn_no_multipleLang, "no button");
					twoDotsWithDelete();
				} else {
					BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to post the text message", true,
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
	
	public void twoDotsWithDelete() {
		mobileActions.click(kooCreationPage.btn_profile, "profile button");
		List<WebElement> allKoos = BaseTest.utilObj.get().getMobileActions().elements(profileScreenPage.btn_twoDots);
		if(allKoos.size()>0) {
			
				mobileActions.click(profileScreenPage.btn_twoDots, "two dots button");
				mobileActions.click(kooCreationPage.btn_deletekoo, "koo delete");				
				mobileActions.click(kooCreationPage.btn_yesdltkoo, "yes button");
		}
	}

}