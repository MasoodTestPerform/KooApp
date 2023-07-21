package com.framework.android.allpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;

public class ReportKooOptionsTabPage {
	
	PeopleTabPage peopleTabPage = new PeopleTabPage();
	MobileActions mobileActions = new MobileActions();
	SoftAssert softAssert = new SoftAssert();
	KooCardPage kooCardPage = new KooCardPage();
	
	public By reportKooBtn_Text = By.id("com.koo.app:id/itemReportContent");
	public String reportKooBtn_Text_Name = "Report Koo Button";
	public By reportKooTextOptions = By.id("com.koo.app:id/issue_textview");
	public By reportKooNumberOptions = By.id("com.koo.app:id/issue_no_textview");
	public String reportKooTextOptions_Name = "Text Option in Report Koo ";
	public String reportKooNumberOptions_Name = "Number Option in Report Koo";

	
	public By headerReportUser = By.id("com.koo.app:id/toolbar_heading_textview");
	public By channelName = By.id("com.koo.app:id/comment_channel_name_textview");
	public By channelDescription = By.id("com.koo.app:id/comment_creation_textview");
	
	public String headerReportUser_Name = "";
	public String channelName_Name = "";
	public String channelDescription_Name = "";
	
	public String verifyButtonDotsAndClick() throws Exception {
		String firstProfileName = mobileActions.getText(peopleTabPage.peopleTabFirstProfile, peopleTabPage.peopleTabFirstProfile_Name, true).trim();
		mobileActions.click(peopleTabPage.peopleTabFirstProfile, peopleTabPage.peopleTabFirstProfile_Name);
		String profileName = mobileActions
				.getText(peopleTabPage.peopleTabFirstProfile, peopleTabPage.peopleTabFirstProfile_Name, true).trim();
		String profileNameInReportUser = null;
		if (firstProfileName.equals(profileName)) {
			profileNameInReportUser = firstProfileName;
			mobileActions.swipeUp(1);
			mobileActions.click(kooCardPage.btn_dots, kooCardPage.btn_dots_Name);
		}
		mobileActions.swipeDown(1);
		return profileNameInReportUser;
	}
	public ReportKooOptionsTabPage validateReportKooOption() throws Exception {
		String actualReportKooText = mobileActions
				.getText(reportKooBtn_Text,reportKooBtn_Text_Name, true).trim();
		String expectedReportKooText = "Report Koo";
		if (actualReportKooText.equalsIgnoreCase(expectedReportKooText)) {
			System.out.println(actualReportKooText + " is matches with " + expectedReportKooText);
		} else {
			System.out.println(actualReportKooText + " is not matches with " + expectedReportKooText);
		}
		mobileActions.click(reportKooBtn_Text, reportKooBtn_Text_Name);
		return this;
	}
	
	public ReportKooOptionsTabPage validateReportKooOptionsInPeopleTab() throws Exception {
		String reportKooOptionNo;
		String reportKooOptionText;
		List<WebElement> options = mobileActions.elements(reportKooTextOptions);
		List<WebElement> optionsNo = mobileActions.elements(reportKooNumberOptions);
		int size = options.size();
		for (int i = 0; i < size; i++) {
			reportKooOptionNo = optionsNo.get(i).getText();
			reportKooOptionText = options.get(i).getText();
			String actualReportKooOption = reportKooOptionNo + " " + reportKooOptionText;
			System.out.println("Actual Option: " + actualReportKooOption);
			String expectedReportKooOption = LanguageDataProvider
					.getLanguageDataValue("ReportKooOption" + (i + 1) + "Txt");
			System.out.println("Expected Option: " + expectedReportKooOption);
			softAssert.assertEquals(actualReportKooOption, expectedReportKooOption);
		}
		softAssert.assertAll();
		return this;

	}

	
}
