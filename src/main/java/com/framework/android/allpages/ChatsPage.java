package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.GetCurrentWindowHandle;
import org.testng.Assert;

import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;

public class ChatsPage {

	MobileActions mobileActions = null;

	public By btn_Message = By.id("com.koo.app:id/lottie_messages");
	public By btn_StartConversation = By.id("com.koo.app:id/tv_start_conversation");
	public By txt_SearchBox = By.id("com.koo.app:id/search");

	public By txt_OnNewUser = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout");

	public By vry_SearchedUser = By.id("com.koo.app:id/toolbar_name");
	public By txt_ChatBox = By.id("com.koo.app:id/edittext_chat");

	public By btn_Send = By.id("com.koo.app:id/button_send");
	public By btn_FirstProfile = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout");
	public By btn_Request = By.id("com.koo.app:id/chat_button_holder");

	/*
	 * locators by Jagath
	 */

	String actual;
	String expected;

	public By conversationEmptyTxt = By.id("com.koo.app:id/empty_text");
	public By startConversationBtn = By.id("com.koo.app:id/tv_start_conversation");
	public By messageTabBtn = By.id("com.koo.app:id/message_fab");
	public By customTabTextOthers = By.xpath(
			"//android.widget.LinearLayout[@content-desc='Others']/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
	public By othersTabBtn = By.xpath("//android.widget.LinearLayout[@content-desc='Others']");
	public By followingTabBtn = By.xpath("//android.widget.LinearLayout[@content-desc='Following']");
	public By newMessagePageHeader = By.id("com.koo.app:id/toolbar_heading_textview");
	public By searchBarAtNewMessagePage = By.id("com.koo.app:id/search"); //By.xpath("//android.widget.FrameLayout/android.widget.EditText[@resource-id='com.koo.app:id/search']");
	public By emptySearchBarText = By.xpath("//android.widget.EditText[@text='Search for your friends and family…']");
	public By emptyNewMessagePageBackGroundTxt = By.id("com.koo.app:id/search_background_textview");
	public By profileNameOfFirstResult = By
			.xpath("//android.view.ViewGroup/android.widget.TextView[@resource-id='com.koo.app:id/toolbar_name']");
	public By requestBtn_Chats = By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Request']");
	public By textOfSwitchOffChat = By.id("com.koo.app:id/chat_status_title");
	public By chatBoxInputField = By.id("com.koo.app:id/edittext_chat");
	public By sendButtonOfChatBox = By.id("com.koo.app:id/button_send");
	public By messageDisplayed = By.id("com.koo.app:id/textview_chat_sent");

	public String chatBoxInputField_Name = "Chat Box to send Message";
	public String sendButtonOfChatBox_Name = "Send Button";
	public String messageDisplayed_Name = "Message Displayed after successfully sent which we entered";
	public String conversationEmptyTxt_Name = "Text for empty conversations";
	public String startConversationBtn_Name = "Start Conversation button";
	public String messageTabBtn_Name = "Message Tab button to Start new chat conversation";
	public String othersTabBtn_Name = "Others Tab";
	public String followingTabBtn_Name = "Following Tab";
	public String newMessagePageHeader_Name = "New Message Page to Start conversation";
	public String searchBarAtNewMessagePage_Name = "Search Bar at New Message Page to chat";
	public String emptySearchBarText_Name = "Text in Empty Search bar in New Message Page";
	public String emptyNewMessagePageBackGroundTxt_Name = "Text of Empty New Message Page Background";
	public String profileNameOfFirstResult_Name = "Profile Name after clicking first profile";
	public String requestBtn_Chats_Name = "Request Button";
	public String textOfSwitchOffChat_Name = "Message of chat of request state (Switch off/On)";

	public ChatsPage() {

		this.mobileActions = BaseTest.utilObj.get().getMobileActions();

	}

	/**
	 * This method is to Click on navigation buttons
	 *
	 * @param by
	 * @return
	 */
	public void clickOnAnyBottomNavigationButton(By by, String navigationButtonName) {
		mobileActions.waitForVisible(by);
		BaseTest.utilObj.get().getAssertManager().sAssertTrue(mobileActions.isDisplayed(by, navigationButtonName),
				navigationButtonName, false, BaseTest.mobileDriver.get(), true);
		mobileActions.tapElement(by, navigationButtonName);
	}

	/**
	 * This method is to verify New Message page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public void verifyPageHeaderInChat(By by, String name, String expectedHeading) {
		mobileActions.waitForVisible(by);
		Assert.assertTrue(mobileActions.isDisplayed(by, name));
		actual = mobileActions.getText(by, name, true).trim();
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expectedHeading, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
	}

	/**
	 * This method is to verify New Message page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public void verifyAndstartConversation() {
		mobileActions.waitForVisible(startConversationBtn);
		Assert.assertTrue(mobileActions.isDisplayed(startConversationBtn, startConversationBtn_Name));
		actual = mobileActions.getText(startConversationBtn, startConversationBtn_Name, true).trim();
		expected = LanguageDataProvider.getLanguageDataValue("ToStartAConversationButtonText");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
		mobileActions.click(startConversationBtn, startConversationBtn_Name);
	}

	/**
	 * This method is to verify New Message page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public void verifyAndEnterTextInSearchBarOfNewMessage(String searchName) {
		mobileActions.waitForVisible(searchBarAtNewMessagePage);
		Assert.assertTrue(mobileActions.isDisplayed(searchBarAtNewMessagePage, searchBarAtNewMessagePage_Name));
//		actual = mobileActions.getText(emptySearchBarText, emptySearchBarText_Name, true);
//		expected = LanguageDataProvider.getLanguageDataValue("EmptySearchBarText");
//		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
//				BaseTest.mobileDriver.get(), true);
		actual = mobileActions.getText(emptyNewMessagePageBackGroundTxt, emptyNewMessagePageBackGroundTxt_Name, true)
				.trim();
		expected = LanguageDataProvider.getLanguageDataValue("EmptyNewMessagePageBackGroundTxt");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
		mobileActions.click(searchBarAtNewMessagePage, searchBarAtNewMessagePage_Name);
		mobileActions.sendKeys(searchBarAtNewMessagePage, searchBarAtNewMessagePage_Name, searchName);
	}

	/**
	 * This method is to verify New Message page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public void SearchAndSelectFirstProfileFromResults(String searchName) {
		String newXpath = "//android.widget.LinearLayout/android.widget.TextView[@text='" + searchName + "']";
		By firstProfileWithSearchText = By.xpath(newXpath);
		mobileActions.waitForVisible(firstProfileWithSearchText);
		Assert.assertTrue(mobileActions.isDisplayed(firstProfileWithSearchText,
				"First Profile Name with your text in Search Results"));
		actual = mobileActions
				.getText(firstProfileWithSearchText, "First Profile Name with your text in Search Results", true)
				.trim();
		mobileActions.click(firstProfileWithSearchText, "First Profile Name with your text in Search Results");
		Assert.assertTrue(mobileActions.isDisplayed(profileNameOfFirstResult, profileNameOfFirstResult_Name));
		expected = mobileActions.getText(profileNameOfFirstResult, profileNameOfFirstResult_Name, true).trim();
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
		actual = mobileActions.getText(textOfSwitchOffChat, textOfSwitchOffChat_Name, true).trim();
		expected = LanguageDataProvider.getLanguageDataValue("ChatRequestPageBackgroundTextForSwitchOff");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
	}

	/**
	 * This method is to verify New Message page
	 *
	 * @param expectedHeading
	 * @return
	 */
	public void verifyAndClickOnRequest() {
		mobileActions.waitForVisible(requestBtn_Chats);
		Assert.assertTrue(mobileActions.isDisplayed(requestBtn_Chats, requestBtn_Chats_Name));
		actual = mobileActions.getText(requestBtn_Chats, requestBtn_Chats_Name, true).trim();
		expected = LanguageDataProvider.getLanguageDataValue("ChatRequestButtonText");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
		mobileActions.click(requestBtn_Chats, requestBtn_Chats_Name);
		actual = mobileActions.getText(textOfSwitchOffChat, textOfSwitchOffChat_Name, true).trim();
		expected = LanguageDataProvider.getLanguageDataValue("ChatRequestPageBackgroundTextAfterRequested");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
	}
	
	public void entersTheCharacterInChatBox(String giveMeTextWhichIwantToPass) {
		mobileActions.waitForVisible(chatBoxInputField);
		Assert.assertTrue(mobileActions.isDisplayed(chatBoxInputField, chatBoxInputField_Name));
		mobileActions.click(chatBoxInputField, chatBoxInputField_Name);
		mobileActions.sendKeys(chatBoxInputField, chatBoxInputField_Name, giveMeTextWhichIwantToPass);
		if (mobileActions.isEnabled(sendButtonOfChatBox, sendButtonOfChatBox_Name)) {
			mobileActions.click(sendButtonOfChatBox, sendButtonOfChatBox_Name);
			mobileActions.waitForSec(2);
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(
					mobileActions.isDisplayed(messageDisplayed, messageDisplayed_Name), "Successfully message sent",
					true, BaseTest.mobileDriver.get(), true);
		}
	}
	
	public void verifyExpectedAndActualUser(String giveMeTextWhichIwantToPass) throws InterruptedException {
		
		actual = mobileActions.getText(vry_SearchedUser, "expectedUser", true).trim();
		expected = giveMeTextWhichIwantToPass;
		mobileActions.waitForSec(2);
		if (expected.equalsIgnoreCase(actual)) {
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(
					mobileActions.isDisplayed(vry_SearchedUser, "Actual user name"), "Searched user and Expected User is Matched",
					true, BaseTest.mobileDriver.get(), true);
			mobileActions.click(txt_OnNewUser, "searched profile");
		} else {
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(
					mobileActions.isDisplayed(vry_SearchedUser, "Actual user name"), "Searched user and Expected User is MisMatched",
					true, BaseTest.mobileDriver.get(), true);
		}

	}

	public void textForNewAccount()
	{
		if(mobileActions.isDisplayed(textOfSwitchOffChat, textOfSwitchOffChat_Name))
		{
		actual = mobileActions.getText(textOfSwitchOffChat, textOfSwitchOffChat_Name, true).trim();
		expected = LanguageDataProvider.getLanguageDataValue("ChatRequestPageBackgroundTextForSwitchOff");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(actual, expected, "Both names are matched", true,
				BaseTest.mobileDriver.get(), true);
		}
		else
		{
			System.out.println("Not Present the:- "+expected);
		}
	}
}