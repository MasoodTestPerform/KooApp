package com.framework.android.testcases.kooTests;

import java.io.IOException;

import com.koo.android.utils.LanguageDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.kooPages.*;
import com.framework.android.screens.profileScreenPage.ElementsPage;
import com.framework.android.screens.profileScreenPage.FollowersAndFollowingPage;
import com.framework.android.screens.profileScreenPage.PinnedKoos;
import com.framework.android.screens.profileScreenPage.SelfVerificationPage;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.screens.topics.TopicsTab;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class KooDetailsScreenTest extends BaseTest {

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_128] Verify parent Koo on top of the screen & posted comments should show below the parent Koo.", groups = {
			"regression", "Profile_Screen" })
	public void TC_128_verifyCommentsSection(String language) throws IOException, InterruptedException, FilloException {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
				"<b><----Test case execution started for Test: TC_128 - Verify parent Koo on top of the screen & posted comments should show below the parent Koo.------><b>",
				false, BaseTest.mobileDriver.get());
		try {
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			KooDetailsPage kooDetails = new KooDetailsPage();
			kooDetails.commentVerification(language);
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully executed - TC_128 - Verify parent Koo on top of the screen & posted comments should show below the parent Koo. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in TC_128 - Verify parent Koo on top of the screen & posted comments should show below the parent Koo. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}
}
