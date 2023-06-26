package com.framework.android.testcases.reportUserTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.android.allpages.*;
import com.framework.android.screens.registerationAndLoginFlowPages.*;

public class ReportUserTest {
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_389] Verify Report user option in options on Koo card & report options should be in app language.",
            groups = {"regression", "people_tab"})
    public void verifyReportUserOptions(String language) throws Exception {
        if (language.equalsIgnoreCase("English")) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
            PeopleTabPage peopleTabPage = new PeopleTabPage();
            loginKooPage.loginValidUser(language, TestConfig.getInstance().getUserName());
            homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
            String val = peopleTabPage.verifyNavigateToFirstPeopleProfileFromPeopleTab();
            System.out.println("val:"+val);
            
            MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
            mobileActions.click(peopleTabPage.peopleTabProfile, peopleTabPage.peopleTabProfile_Name);
            Thread.sleep(50000);
            val = BaseTest.mobileDriver.get().getPageSource();
            mobileActions.click(By.xpath("//android.widget.ImageButton[@resource-id='com.koo.app:id/layoutOptionMenu']"), "OptionMenu");
            Thread.sleep(20000);
            System.out.println(val);
            
        }
    }   
}
