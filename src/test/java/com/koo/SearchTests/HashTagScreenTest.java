package com.koo.SearchTests;

import org.testng.annotations.Test;

import com.framework.android.allpages.ChatsPage;
import com.framework.android.allpages.HomeScreenTabPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class HashTagScreenTest extends BaseTest {

	MobileActions mobileActions = new MobileActions();

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_183] Verify user should be able to request chat if other person is not following me. ", groups = {
			"regression", "topicsTab_home" })
	public void verifyUserShouldAbleToRequestChatIfOtherPersonNotFollowingMe1(String language) {
		try {

			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Verify user should be able to request chat if other person is not following me.------><b>",
					false, BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
			ChatsPage chatsPage = new ChatsPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			homeScreenTabPage.verifyTrendingTagIcon();

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully Verify user should be able to request chat if other person is not following me. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify user should be able to request chat if other person is not following me. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());

		}

	}

}
