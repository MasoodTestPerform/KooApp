package com.koo.CommentDetailsScreenTests;

import org.testng.annotations.Test;

import com.framework.android.allpages.CommentDetailsScreenPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class CommentDetailsScreenTest extends BaseTest {

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-137] Verify user is able to enter comment details by tapping on the comment & parent Koo should show above with a thread leading to comment.", groups = {
			"regression", "CommentDetailsScreen" })
	public void verifyUserAbleToEnterCommentDetails(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify is able to enter comment details by tapping on the comment & parent Koo should show above with a thread leading to comment. ------><b>",
					false, BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			CommentDetailsScreenPage commentDetailsScreenPage = new CommentDetailsScreenPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			commentDetailsScreenPage.verifyCommentConstaint();
			commentDetailsScreenPage.clickWriteYourCommentBar();
			commentDetailsScreenPage.writeYourCommentInInputField("Testing");
			commentDetailsScreenPage.verifyParentThreadofKoo();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified is able to enter comment details by tapping on the comment & parent Koo should show above with a thread leading to comment. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify is able to enter comment details by tapping on the comment & parent Koo should show above with a thread leading to comment. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-138] Verify parent Koo is hidden on top & focus in on comment & parent Koo should show on reverse pagination.", groups = {
			"regression", "CommentDetailsScreen" })
	public void verifyUserAbleToDoReversePagination(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify parent Koo is hidden on top & focus in on comment & parent Koo should show on reverse pagination. ------><b>",
					false, BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			CommentDetailsScreenPage commentDetailsScreenPage = new CommentDetailsScreenPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			commentDetailsScreenPage.verifyCommentConstaint();
			commentDetailsScreenPage.clickWriteYourCommentBar();
			commentDetailsScreenPage.verifyParentThreadofKoo();
			commentDetailsScreenPage.writeYourCommentInInputField("Testing");
			commentDetailsScreenPage.clickOnBackButtonFromCommentPage();
			commentDetailsScreenPage.verifyAlert("Are you sure?");
			commentDetailsScreenPage.clickOnBackButtonOfKoo();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified parent Koo is hidden on top & focus in on comment & parent Koo should show on reverse pagination. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify parent Koo is hidden on top & focus in on comment & parent Koo should show on reverse pagination. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC-138] Verify parent Koo is hidden on top & focus in on comment & parent Koo should show on reverse pagination.", groups = {
			"regression", "CommentDetailsScreen" })
	public void verifyUserAbleToReactOnOtherCommentOfKoo(String language) {
		try {
			// Saving dynamically created test data into excel
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test: Verify user is able to react on comment & all other functionaloity should be same as Koo details screen. ------><b>",
					false, BaseTest.mobileDriver.get());
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			CommentDetailsScreenPage commentDetailsScreenPage = new CommentDetailsScreenPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			commentDetailsScreenPage.verifyCommentConstaint();
			commentDetailsScreenPage.verifyCommentsHeader("Comments");
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution completed for Test:Successfully verified user is able to react on comment & all other functionaloity should be same as Koo details screen. ------><b>",
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Verify user is able to react on comment & all other functionaloity should be same as Koo details screen. Exception:"
							+ e.getMessage(),
					true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

}
