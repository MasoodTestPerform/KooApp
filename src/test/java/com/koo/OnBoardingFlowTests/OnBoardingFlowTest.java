package com.koo.OnBoardingFlowTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.allpages.*;

public class OnBoardingFlowTest extends BaseTest {
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_039, TC_040] Verify keyboard should auto open & cursor should be in enter name text filed & user is able to type username.",
            groups = {"regression", "onboarding_flow"})
    public void verifyKeyboardAutoOpenForUpdateNameField(String language) {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        //loginKooPage.loginValidUser(language, "needtoaddnewuser");
        CommonHelper.enterValueFromKeyboard(RandomStringUtils.randomAlphabetic(40));
    }
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_12, TC_13] Verify user gets username update & profile image update screens. Verify username update only for new accounts or relogin account without handles.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleViewEditUserNamePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToViewUserNamePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_12,TC_14] Verify user gets username update & profile image update screens.  Verify profile image update screen for new login or relogin account wihtou profile image", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleViewEditProfileImagePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToviewProfileImagePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_15] Verify interest (preference) selection screen & user is able to select/deselect options.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewPrefrencesPage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser2"));
		onboardPage.verifyUserAbleToViewAddPreferencesPage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_16] Verify follow people screen & user is able to follow / unfollow users.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewFollowPeoplePage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser3"));
		Thread.sleep(20000);
		onboardPage.verifyUserAbleToViewFollowPeoplePage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_17] Verify follow topics screen & user is able to follow / unfollow topics.", groups = {
			"regression", "onboarding_flow" })
	public void verifyUserAbleToViewFollowTopicsPage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		//loginKooPage.loginValidUser(language, ConfigReader.getValue("dummyUser4"));
		Thread.sleep(20000);
		onboardPage.verifyUserAbleToViewFollowTopicsPage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_17] Verify follow topics screen & user is able to follow / unfollow topics.", groups = {
			"regression", "onboarding_flow" })
	public void verifyNewUserAbleToGetAllPages(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
		PeopleTabPage peopleTabPage = new PeopleTabPage();
		OnBoardingFlowPage onboardPage = new OnBoardingFlowPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		onboardPage.verifyNewUserAbleToViewUserNamePage();
		onboardPage.verifyNewUserAbleToviewProfileImagePage();
//		onboardPage.verifyUserAbleToViewAddPreferencesPage();
//		onboardPage.verifyUserAbleToViewFollowPeoplePage();
//		onboardPage.verifyUserAbleToViewFollowTopicsPage();
	}

}
