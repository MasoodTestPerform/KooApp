package com.framework.android.testcases.topicsTests;

import org.testng.annotations.Test;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.android.screens.registerationAndLoginFlowPages.*;
import com.framework.android.screens.topics.*;

public class TopicWidgetTest extends BaseTest {
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_156, TC_144, TC_145, TC_147] Verify Followed Topics widget should show on feed after following atleast one topic with View Koos button, tapping on which users goes to topics detail screen.", groups = {
			"regression", "Topics" })
	public void verifyTopicWidgetPage(String language) throws Exception {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		TopicWidget topic = new TopicWidget();
		topic.topicswidgetPage();
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_155] Verify Followed Topics widget should show on feed after following atleast one topic with View Koos button, tapping on which users goes to topics detail screen.", groups = {
			"regression", "Topics" })
	public void verifyTopicWidget(String language) {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		TopicWidget topic = new TopicWidget();
		topic.topicsAddTopictoYourFeed();

	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_50, TC_51] Verify Topics tab should have Topics pills with + button, tapping on it or topic name, topic is followed>tapping on arrow button, user goes to Topics Details screen & related topics content should be shown", groups = {
			"regression", "Topics" })
	public void TC_050_051_verifyTopicTabPage(String language) {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_50_51 - Verify Topics tab should have Topics pills with + button, tapping on it or topic name, topic is followed>tapping on arrow button, user goes to Topics Details screen & related topics content should be shown ------><b>", false, BaseTest.mobileDriver.get());
		try{
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			TopicsTab topics = new TopicsTab();
			topics.topicsTab(LanguageDataProvider.getLanguageDataValue("TopicsTabText"));
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_50_51 - Verify Topics tab should have Topics pills with + button, tapping on it or topic name, topic is followed>tapping on arrow button, user goes to Topics Details screen & related topics content should be shown ------><b>", true, BaseTest.mobileDriver.get());
		    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	 }catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_134 - Verify Topics Tab Position On Home Page. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, 
			description = "[TC_049] Verify followed Topics related Koo content should show on feed and justification text should show for Topic name with View more button.", groups = {
			"regression", "Topics" })
	public void TC_049_verifyTopicViewMorePage(String language) {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_049 - Verify followed Topics related Koo content should show on feed and justification text should show for Topic name with View more button ------><b>", false, BaseTest.mobileDriver.get());
		try{
			LanguageDataProvider.setCurrentLanguage(language);
			LoginKooPage loginKooPage = new LoginKooPage();
			loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
			TopicsTab topics = new TopicsTab();
			topics.topicsWithViewMore();
			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_049 - Verify followed Topics related Koo content should show on feed and justification text should show for Topic name with View more button ------><b>", true, BaseTest.mobileDriver.get());
		    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_049 - Verify followed Topics related Koo content should show on feed and justification text should show for Topic name with View more button. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
		}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, 
			description = "[TC_053] Verify Topics widget in feed screen with same pills like in Topics tab with same behaviour.", groups = {
			"regression", "Topics" })
	public void TC_053_verifyTopicsWidgetInFeedPage(String language)  {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_053 - Verify Topics widget in feed screen with same pills like in Topics tab with same behaviour. ------><b>", false, BaseTest.mobileDriver.get());
		try{
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		TopicsTab topics = new TopicsTab();
		topics.topicsWidgetInFeedTab(language, "Add Topics to your Feed");
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_053 - Verify Topics widget in feed screen with same pills like in Topics tab with same behaviour. ------><b>", true, BaseTest.mobileDriver.get());
	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	}catch(Exception e) {
		BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_053 - Verify Topics widget in feed screen with same pills like in Topics tab with same behaviour. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
		BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	}
	}

	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, 
			description = "[TC_054] Verify Manage Topics screen in own profile, 'All' & 'Following' tabs should be present in that screen.", groups = {
			"regression", "Topics" })
	public void TC_054_055_verifyManageTopicsPage(String language)  {
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_054 - Verify Manage Topics screen in own profile, 'All' & 'Following' tabs should be present in that screen. ------><b>", false, BaseTest.mobileDriver.get());
		try{
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		TopicsTab topics = new TopicsTab();
		topics.manageTopics(language);
		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_054 - Verify Manage Topics screen in own profile, 'All' & 'Following' tabs should be present in that screen. ------><b>", true, BaseTest.mobileDriver.get());
	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	}catch(Exception e) {
		BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in TC_054 - Verify Manage Topics screen in own profile, 'All' & 'Following' tabs should be present in that screen. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
		BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
	}
	}
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class, description = "[TC_055] Verify Manage Topics screen in own profile, 'All' & 'Following' tabs should be present in that screen.", groups = {
			"regression", "Topics" })
	public void verifyAllAndFollowTopics(String language) {
		LanguageDataProvider.setCurrentLanguage(language);
		LoginKooPage loginKooPage = new LoginKooPage();
		loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
		TopicsTab topics = new TopicsTab();
		topics.allAndFollowTopicsInTopicsTab(LanguageDataProvider.getLanguageDataValue("TopicsTabText"),"Topics You Follow");
	}
}
