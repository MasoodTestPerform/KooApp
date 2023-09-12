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
	public void TC_149_174_verifyAbleToPostKoosWithText(String language)
			throws IOException, InterruptedException, FilloException {
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
	public void TC_149_verifyAbleToPostKoosWithImage(String language)
			throws IOException, InterruptedException, FilloException {
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

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_150] Verify user is able to post Koo with combination of different media.", groups = {
			"regression", "Profile_Screen" })
	public void TC_150_verifyAbleToPostKoosWithTextAndImage(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_150 - Verify user is able to post Koo with combination of different media. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationWithImage(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_150 - Verify user is able to post Koo with combination of different media. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_150 - Verify user is able to post Koo with combination of different media. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_149] Verify profile image on top of the screen & should load all images on entering the screen.", groups = {
			"regression", "Profile_Screen" })
	public void TC_149_verifyAbleToPostKoosWithVideo(String language)
			throws IOException, InterruptedException, FilloException {
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

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_150] Verify user is able to post Koo with combination of different media.", groups = {
			"regression", "Profile_Screen" })
	public void TC_150_verifyAbleToPostKoosWithTextAndVideo(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_150 - Verify user is able to post Koo with combination of different media. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationWithVideo(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_150 - Verify user is able to post Koo with combination of different media. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_150 - Verify user is able to post Koo with combination of different media. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_150] Verify user is able to post Koo with combination of different media.", groups = {
			"regression", "Profile_Screen" })
	public void TC_168_verifyAbleToPostAndEditKoosWithText(String language)
			throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_168 - Verify user is able to post Koo with combination of different media. ------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooCreationPages creation = new KooCreationPages();
			creation.kooCreationAndEditWithText(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_168 - Verify user is able to post Koo with combination of different media. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_168 - Verify user is able to post Koo with combination of different media. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

}
