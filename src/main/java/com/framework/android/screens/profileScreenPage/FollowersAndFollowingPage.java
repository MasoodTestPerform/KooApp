package com.framework.android.screens.profileScreenPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooCreationPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class FollowersAndFollowingPage {
	MobileActions mobileActions = null;
	KooCreationPage kooCreationPage = null;
	ProfileScreenPage profileScreenPage = null;
	EditProfilePage editProfilePage = null;
	UserBlockPage userBlockPage = null;
	KooCardPage kooCardPage = null;

	public FollowersAndFollowingPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.userBlockPage = new UserBlockPage();
		this.profileScreenPage = new ProfileScreenPage();
		this.editProfilePage = new EditProfilePage();
		this.kooCardPage = new KooCardPage();
		this.kooCreationPage = new KooCreationPage();
	}

	public void followingProfileThroughPeopleTab(String language, int num) throws IOException, InterruptedException {
		try {
			mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(profileScreenPage.tab, "xpath", "People"),
					"People tab");
			
			List<WebElement> allHeartButtons = mobileActions.elements(profileScreenPage.list_heartButton);
			Thread.sleep(3000);
			System.out.println("Heart buttons: " + allHeartButtons.size());
			if (allHeartButtons.size() > 0) {
				BaseTest.LOGGER.get().logInfo("Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Heart buttons in All tab", true,
						BaseTest.mobileDriver.get(), true);
				for (int i = 0; i < allHeartButtons.size(); i++) {
					if (i == num) {
						By heartButton = By
								.xpath("(//*[@resource-id='com.koo.app:id/favourite_button'])[" + (i - 1) + "]");
//					String channelName = mobileActions.getText(heartButton, "Channel Name", true);
						mobileActions.click(heartButton, "Favourite button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
						mobileActions.click(editProfilePage.btn_backArrow, "back button");
						mobileActions.click(profileScreenPage.btn_following, "following button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
					}
				}
			} else {
				BaseTest.LOGGER.get().logInfo("No Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "No Heart buttons available in All tab",
						true, BaseTest.mobileDriver.get(), true);
			}
			mobileActions.click(editProfilePage.btn_backArrow, "back button");

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Not able to perform Pinned and Unpinned koos");
			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
					BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to perform Pinned and Unpinned koos",
					true, BaseTest.mobileDriver.get(), true);
		}
	}

	public void explanatoryTextVerification(String language, int num) throws IOException, InterruptedException {
		try {
			//TC_092 - Validation
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			mobileActions.click(profileScreenPage.btn_following, "following button");
			mobileActions.isDisplayed(profileScreenPage.txt_followingheading, "following heading");
			String followingText = mobileActions.getText(profileScreenPage.txt_followingheading,
					profileScreenPage.txt_followingheading_Name, true);
			System.out.println("following heading text is " + followingText);
			mobileActions.isDisplayed(profileScreenPage.txt_all, "all heading");
			mobileActions.isDisplayed(profileScreenPage.txt_latest, "latest heading");
			
			if(mobileActions.isElmPresent(profileScreenPage.txt_explanatory)) {
				String explanatoryText = mobileActions.getText(profileScreenPage.txt_explanatory, 
						profileScreenPage.txt_explanatory_name, false);
				BaseTest.utilObj.get().getAssertManager().sAssertEquals(explanatoryText, 
						LanguageDataProvider.getLanguageDataValue("ExplanatoryText"), 
						"Both texts are matched", true, BaseTest.mobileDriver.get(), true);
			}
			
			//
			List<WebElement> allHeartButtons = mobileActions.elements(profileScreenPage.list_heartButton);
			Thread.sleep(3000);
			System.out.println("Heart buttons: " + allHeartButtons.size());
			if (allHeartButtons.size() > 0) {
				BaseTest.LOGGER.get().logInfo("Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Heart buttons in All tab", true,
						BaseTest.mobileDriver.get(), true);
				for (int i = 0; i < allHeartButtons.size(); i++) {
					if (i == num) {
						By heartButton = By
								.xpath("(//*[@resource-id='com.koo.app:id/favourite_button'])[" + (i - 1) + "]");
//					String channelName = mobileActions.getText(heartButton, "Channel Name", true);
						mobileActions.click(heartButton, "Favourite button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
						mobileActions.click(editProfilePage.btn_backArrow, "Following page back button");
						mobileActions.click(profileScreenPage.btn_backInProfileScreen, "Profile page back button");
						mobileActions.click(profileScreenPage.btn_following, "following button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
						mobileActions.click(heartButton, "Favourite button");
					}
				}
			} else {
				BaseTest.LOGGER.get().logInfo("No Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "No Heart buttons available in All tab",
						true, BaseTest.mobileDriver.get(), true);
			}
			mobileActions.click(editProfilePage.btn_backArrow, "back button");

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Not able to perform Pinned and Unpinned koos");
			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
					BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to perform Pinned and Unpinned koos",
					true, BaseTest.mobileDriver.get(), true);
		}
	}

	public void followersAndFollowing(String language, int num) throws IOException, InterruptedException {
		try {
			//TC_092 - Validation
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			mobileActions.click(profileScreenPage.btn_followers, "followers button");
			mobileActions.isDisplayed(profileScreenPage.txt_followersheading, "followers heading");
			String followersText = mobileActions.getText(profileScreenPage.txt_followersheading,
					profileScreenPage.txt_followersheading_Name, true);
			System.out.println("followers heading text is " + followersText);
			mobileActions.isDisplayed(profileScreenPage.txt_all, "all heading");
			mobileActions.isDisplayed(profileScreenPage.txt_latest, "latest heading");
			mobileActions.click(profileScreenPage.txt_latest, "latest heading");
			mobileActions.click(editProfilePage.btn_backArrow, "back button");
			mobileActions.click(profileScreenPage.btn_following, "following button");
			mobileActions.isDisplayed(profileScreenPage.txt_followingheading, "following heading");
			String followingText = mobileActions.getText(profileScreenPage.txt_followingheading,
					profileScreenPage.txt_followingheading_Name, true);
			System.out.println("following heading text is " + followingText);
			mobileActions.isDisplayed(profileScreenPage.txt_all, "all heading");
			mobileActions.isDisplayed(profileScreenPage.txt_latest, "latest heading");
			
			//
			List<WebElement> allHeartButtons = mobileActions.elements(profileScreenPage.list_heartButton);
			Thread.sleep(3000);
			System.out.println("Heart buttons: " + allHeartButtons.size());
			if (allHeartButtons.size() > 0) {
				BaseTest.LOGGER.get().logInfo("Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "Heart buttons in All tab", true,
						BaseTest.mobileDriver.get(), true);
				for (int i = 0; i < allHeartButtons.size(); i++) {
					if (i == num) {
						By heartButton = By
								.xpath("(//*[@resource-id='com.koo.app:id/favourite_button'])[" + (i - 1) + "]");
						mobileActions.click(heartButton, "Favourite button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
						mobileActions.click(editProfilePage.btn_backArrow, "back button");
						mobileActions.click(profileScreenPage.btn_following, "following button");
						BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
								BaseTest.mobileDriver.get());
						mobileActions.click(heartButton, "Favourite button");
					}
				}
			} else {
				BaseTest.LOGGER.get().logInfo("No Heart buttons available in All tab");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, "No Heart buttons available in All tab",
						true, BaseTest.mobileDriver.get(), true);
			}
			mobileActions.click(editProfilePage.btn_backArrow, "back button");
			
//			mobileActions.click(profileScreenPage.btn_superLikes, "super likes button");
//			mobileActions.isDisplayed(profileScreenPage.txt_superLikesHeading, "super likes heading");
//			String followersText = mobileActions.getText(profileScreenPage.txt_followersheading,
//					profileScreenPage.txt_followersheading_Name, true);

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Not able to perform Pinned and Unpinned koos");
			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
					BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to perform Pinned and Unpinned koos",
					true, BaseTest.mobileDriver.get(), true);
		}
	}
	public void verifyPagination(String language) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			//Followers 
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			mobileActions.click(profileScreenPage.btn_followers, "followers button");
			mobileActions.isDisplayed(profileScreenPage.txt_followersheading, "followers heading");
			mobileActions.click(editProfilePage.btn_backArrow, "back button");
			mobileActions.click(profileScreenPage.btn_following, "following button");
			mobileActions.isDisplayed(profileScreenPage.txt_followingheading, "following heading");						
			mobileActions.click(editProfilePage.btn_backArrow, "back button");

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Not able to perform Pinned and Unpinned koos");
			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for heart button clicked",
					BaseTest.mobileDriver.get());
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Not able to perform Pinned and Unpinned koos",
					true, BaseTest.mobileDriver.get(), true);
		}
	}



}
