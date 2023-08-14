package com.framework.android.testcases.kooTests;

import java.io.IOException;

import com.koo.android.utils.LanguageDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.kooPages.KooCreationPages;
import com.framework.android.screens.profileScreenPage.ElementsPage;
import com.framework.android.screens.profileScreenPage.FollowersAndFollowingPage;
import com.framework.android.screens.profileScreenPage.InformationPage;
import com.framework.android.screens.profileScreenPage.PinnedKoos;
import com.framework.android.screens.profileScreenPage.SelfVerificationPage;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.screens.topics.TopicsTab;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class KooCreationTest extends BaseTest {

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_149] Verify profile image on top of the screen & should load all images on entering the screen.", groups = {
			"regression", "Profile_Screen" })
	public void TC_149_verifyAbleToPostKoosWithText(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationWithText(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_149] Verify profile image on top of the screen & should load all images on entering the screen.", groups = {
			"regression", "Profile_Screen" })
	public void TC_149_verifyAbleToPostKoosWithImage(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationWithImage(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_149] Verify profile image on top of the screen & should load all images on entering the screen.", groups = {
			"regression", "Profile_Screen" })
	public void TC_149_verifyAbleToPostKoosWithVideo(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationWithVideo(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_149 - Verify user is able to post Koos with Text, Image, Video, Audio, GIF, Poll options. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_083] Verify Back button, Koo create FAB & all the options in 3 dot options menu.", groups = {
			"regression", "Profile_Screen" })
	public void TC_083_verifyInformationPage(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_083 - Verify Back button, Koo create FAB & all the options in 3 dot options menu. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			InformationPage information = new InformationPage();
			information.informationPage(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_083 - Verify Back button, Koo create FAB & all the options in 3 dot options menu. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_083 - Verify Back button, Koo create FAB & all the options in 3 dot options menu. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
		
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_084] Verify favourites button in public profile after following & in followings screen in own profie & user is able to tap on it.", groups = {
			"regression", "Profile_Screen" })
	public void TC_084_verifyFollowingFollowersTab(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_149 - Verify profile image on top of the screen & should load all images on entering the screen. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			FollowersAndFollowingPage page = new FollowersAndFollowingPage();
			page.followersAndFollowing(language, 5);
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_149 - Verify profile image on top of the screen & should load all images on entering the screen. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_085] Verify explinatory text in own followers & following screen & on feed favourited users Koo should have prominence.", 
			groups = {"regression", "Profile_Screen" })
	public void TC_085_verifyExplanatoryTextInFollowingAndFollowersTab(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_085 - Verify explinatory text in own followers & following screen & on feed favourited users Koo should have prominence. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			FollowersAndFollowingPage page = new FollowersAndFollowingPage();
			page.followersAndFollowing(language, 5);
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_085 - Verify explinatory text in own followers & following screen & on feed favourited users Koo should have prominence. Exception:"
							+ e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_086] Verify Pin & Unpin options on own Koos in own profile screen.", groups = {
			"regression", "Profile_Screen" })
	public void TC_086_verifyPinnedAndUnpinnedKoos(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",	"<b><----Test case execution started for Test: TC_086 - Verify Pin & Unpin options on own Koos in own profile screen. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			PinnedKoos pinned = new PinnedKoos();
			pinned.pinnedAndUnpinnedKoos(language, "Chai Test");
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_086 - Verify Pin & Unpin options on own Koos in own profile screen. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_092] Verify Followers/Following screen & it should show all Followers/Followings properly & should show data in all available tabs.", groups = {
			"regression", "Profile_Screen" })
	public void TC_092_verifyFollowingFollowersTab(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_092 - Verify profile image on top of the screen & should load all images on entering the screen. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			FollowersAndFollowingPage page = new FollowersAndFollowingPage();
			page.followersAndFollowing(language, 5);
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_092 - Verify Followers/Following screen & it should show all Followers/Followings properly & should show data in all available tabs. Exception:"
							+ e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
	
	@Test(alwaysRun = false, dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_221, TC_224, TC_225, TC_227, TC_246] Verify Follow button on public profile screen on the top bar, on scrolling the screen if user not followed the account.", groups = {
			"regression", "Profile_Screen" })
	public void verifyElements(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_149 - Verify profile image on top of the screen & should load all images on entering the screen. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			ElementsPage element = new ElementsPage();
			element.elements(language, LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
//        element.newUserLogin(language);
//        element.verifyNokKoosInNewUser();
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_149 - Verify profile image on top of the screen & should load all images on entering the screen. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(alwaysRun = false, dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_236, TC_238, TC_240] Verify appropriate error messages in aadhaar & OTP screens.", groups = {
			"regression", "Profile_Screen" })
	public void verifySelfVerification(String language) throws IOException, InterruptedException, FilloException {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		SelfVerificationPage selfverification = new SelfVerificationPage();
		selfverification.selfverificationpage(language);
	}

	@Test(alwaysRun = false, dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_078] Verify all the fields on information card & should reflect what ever is added by the user.", 
			groups = {"regression", "Profile_Screen" })
	public void verifyAccountInfoDetails(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_078 - Verify all the fields on information card & should reflect what ever is added by the user. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			InformationPage element = new InformationPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			
			element.accountInfoDetails(language);
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_078 - Verify all the fields on information card & should reflect what ever is added by the user. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}


}
