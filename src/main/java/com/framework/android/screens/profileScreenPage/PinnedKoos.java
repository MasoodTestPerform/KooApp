package com.framework.android.screens.profileScreenPage;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.allpages.EditProfilePage;
import com.framework.android.allpages.KooCardPage;
import com.framework.android.allpages.KooCreationPage;
import com.framework.android.allpages.ProfileScreenPage;
import com.framework.android.allpages.UserBlockPage;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class PinnedKoos {
	MobileActions mobileActions = null;
	KooCreationPage kooCreationPage = null;
	ProfileScreenPage profileScreenPage = null;
	KooCardPage kooCardPage = null;

	public PinnedKoos() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.profileScreenPage = new ProfileScreenPage();
		this.kooCreationPage = new KooCreationPage();
		this.kooCardPage = new KooCardPage();
	}

	public void pinnedAndUnpinnedKoos(String language, String comment) throws IOException, InterruptedException {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to use Language:" + language, false,
				BaseTest.mobileDriver.get());
		try {
			mobileActions.click(kooCreationPage.btn_profile, "profile button");
			mobileActions.click(profileScreenPage.kooFabPlus, "Koo FAB + Button");
			if(mobileActions.isElmPresent(kooCreationPage.txt_Message)) {
				mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, comment);
				mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, 
						"xpath", kooCreationPage.btn_post_Name),"koo card Post button");
				if(mobileActions.isElmPresent(kooCardPage.btn_no)) {
					mobileActions.click(kooCardPage.btn_no, "no button");
				}	
			mobileActions.swipeDown(2);
				String kooSavedTime = mobileActions.getText(profileScreenPage.txt_kooSavedTime,
						profileScreenPage.txt_kooSavedTime_Name, true);
				if(kooSavedTime.equals("Just Now")) {
					String postedMsg = mobileActions.getText(kooCreationPage.txt_threadkoo1,
							kooCreationPage.txt_threadkoo1_Name, true).trim();
					BaseTest.utilObj.get().getAssertManager().sAssertEquals(postedMsg, 
							comment, "Posted messages are matched", true, BaseTest.mobileDriver.get(), true);
//					Thread.sleep(1000);
					mobileActions.click(kooCreationPage.first_menu_hamberger, "hamberger menu");
					mobileActions.click(profileScreenPage.btn_pinToProfile, "pin to profile button");
					mobileActions.click(profileScreenPage.btn_yes, "yes button");
					BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for pin to profile",
							BaseTest.mobileDriver.get());
					mobileActions.isDisplayed(profileScreenPage.txt_pinnedKoo, "pinned koo heading");
					mobileActions.click(kooCreationPage.first_menu_hamberger, "hamberger menu");
					mobileActions.click(profileScreenPage.btn_pinToProfile, "unpin to profile button");
					mobileActions.click(profileScreenPage.btn_yes, "yes button");
					BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for unpin to profile",
							BaseTest.mobileDriver.get());
					mobileActions.click(kooCreationPage.first_menu_hamberger, "hamberger menu");
					mobileActions.click(kooCreationPage.btn_deletekoo, "delete koo button");
					mobileActions.click(profileScreenPage.btn_yes, "yes button");
					
				}else {
					BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Koo message not posted",
							true, BaseTest.mobileDriver.get(), true);
				}
			}
//			mobileActions.swipeUp(2);
//			mobileActions.click(kooCreationPage.menu_hamberger, "hamberger menu");
//			mobileActions.click(profileScreenPage.btn_pinToProfile, "pin to profile button");
//			mobileActions.click(profileScreenPage.btn_yes, "yes button");
//			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for pin to profile",
//					BaseTest.mobileDriver.get());
//			mobileActions.isDisplayed(profileScreenPage.txt_pinnedKoo, "pinned koo heading");
//			mobileActions.click(kooCreationPage.menu_hamberger, "hamberger menu");
//			mobileActions.click(profileScreenPage.btn_pinToProfile, "unpin to profile button");
//			mobileActions.click(profileScreenPage.btn_yes, "yes button");
//			BaseTest.LOGGER.get().logWithScreenshot("INFO", "Screenshot for unpin to profile",
//					BaseTest.mobileDriver.get());
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
