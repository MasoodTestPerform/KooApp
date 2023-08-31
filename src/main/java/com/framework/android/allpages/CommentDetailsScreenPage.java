package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class CommentDetailsScreenPage {

	MobileActions mobileActions = null;
	UIUtils uiutilsPage = null;

	public By buttonTwoDots = By.id("com.koo.app:id/iv_options_more");
	public By commentHolderConstraint = By.id("com.koo.app:id/comment_holder_constraint");
	public By commentPageHeader = By.xpath("//android.widget.TextView[@text='Comment']");
	public By writeCommentBar = By.xpath("//android.widget.TextView[@text='Write Your Comment…']");
	public By threadLinkFromParent = By.xpath("//android.widget.TextView[contains(@text,'Replying to')]");
	// public By writeYourCommentTextField =
	// By.xpath("//android.view.View[@content-desc='koo_create_textField']");
	public By writeYourCommentTextField = By.xpath("//android.widget.EditText");
	public By beKindText = By.xpath("//android.view.View[@content-desc=\"Be kind\"]");
	public By backButtonFromComment = By.xpath("//android.widget.ImageView[@content-desc='Back Button']");
	public By commentPostButton = By.xpath("//android.widget.TextView[@text='Post']");
	public By viewOfSuccessfullyPostedButton = By.xpath("//android.widget.TextView[@text='View']");
	public By commentPostedSuccessfullyPopup = By
			.xpath("//android.widget.TextView[@text='Comment posted successfully']");
	public By justNowTextOnComment = By.xpath("//android.widget.TextView[@text='Just Now']");
	// public By firstKooProfileNameText =
	// By.xpath("(//android.view.View/android.widget.TextView)[1]");
	public By firstKooProfileNameText = By.id("com.koo.app:id/channel_name_textview");
	public By backButtonAfterPostComment = By.xpath("//android.view.View/android.view.View[2]/android.view.View[1]");
	public By commentsText = By.xpath("//android.widget.TextView[@text='Comments']");
	public By commentsTextNo = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/comment_textview']");
	public By navigateButton = By.xpath("//android.widget.TextView[@content-desc='negativeButton']");
	public By alertDailogTitle = By.xpath("//android.widget.TextView[@content-desc='alertDialogTitle']");

	public String buttonTwoDots_Name = "Two Dots button of Koo";
	public String commentHolderConstraint_Name = "Comment Button of Koo";
	public String writeCommentBar_Name = "Write Your Comment Input Field";
	public String threadLinkFromParent_Name = "Thread Link of Parent";
	public String writeYourCommentTextField_Name = "Write Your Comment Input Field";
	public String beKindText_Name = "Be Kind Text at Comment Page";
	public String backButtonFromComment_Name = "Back Button(Arrow) from Comment Page ";
	public String commentPostButton_Name = "Post Button in Write Your Comment Page";
	public String commentPageHeader_Name = "Comment Page Header";
	public String viewOfSuccessfullyPostedButton_Name = "View Button on Successfully Posted Pop-Up";
	public String commentPostedSuccessfullyPopup_Name = "Comment Posted Successfully Message Pop-Up";
	public String justNowTextOnComment_Name = "Declaring new comment by getting text" + justNowTextOnComment;
	public String firstKooProfileNameText_Name = "Profile of Koo which is Displaying most first";
	public String backButtonAfterPostComment_Name = "Back Button (<--) after Post your comment";
	public String commentsText_Name = "Comments Headear";
	public String commentsTextNo_Name = "Number of comments";
	public String navigateButton_Name = "Yes Button from Are You Sure? Page";
	public String alertDailogTitle_Name = "Are you Sure?  Alert";

	public CommentDetailsScreenPage() {
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		this.uiutilsPage = new UIUtils();

	}

	public CommentDetailsScreenPage verifyAndClickButtonTwoDots() throws Exception {
		mobileActions.swipeUpFindElement(10, buttonTwoDots);
		mobileActions.waitForVisible(buttonTwoDots);
		Assert.assertTrue(mobileActions.isDisplayed(buttonTwoDots, buttonTwoDots_Name));
		mobileActions.click(buttonTwoDots, buttonTwoDots_Name);
		return this;
	}

	public String getKooPostedProfile() throws InterruptedException {
		mobileActions.swipeUpFindElement(10, firstKooProfileNameText);
		mobileActions.waitForVisible(firstKooProfileNameText);
		mobileActions.isElementDisplayed(firstKooProfileNameText);
		String profile = mobileActions.getText(firstKooProfileNameText, firstKooProfileNameText_Name, true);
		return profile;
	}

	public CommentDetailsScreenPage clickWriteYourCommentBar() throws InterruptedException {
		// mobileActions.swipeUp(3); // 3
		mobileActions.waitForVisible(writeCommentBar);
		Assert.assertTrue(mobileActions.isDisplayed(writeCommentBar, writeCommentBar_Name));
		mobileActions.click(writeCommentBar, writeCommentBar_Name);
		return this;
	}

	public CommentDetailsScreenPage verifyCommentConstaint(int swipes) {
		mobileActions.swipeUpFindElement(swipes, commentsTextNo);
		mobileActions.waitForVisible(commentHolderConstraint);
		Assert.assertTrue(mobileActions.isDisplayed(commentHolderConstraint, commentHolderConstraint_Name));
		mobileActions.click(commentHolderConstraint, commentHolderConstraint_Name);
		return this;
	}

	public CommentDetailsScreenPage verifyParentThreadofKoo() {
		mobileActions.waitForVisible(threadLinkFromParent);
		BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, threadLinkFromParent_Name, true,
				BaseTest.mobileDriver.get(), true);
		return this;
	}

	public CommentDetailsScreenPage writeYourCommentInInputField(String commentText) {
		mobileActions.waitForVisible(writeYourCommentTextField);
		Assert.assertTrue(mobileActions.isDisplayed(writeYourCommentTextField, writeYourCommentTextField_Name));
		mobileActions.sendKeys(writeYourCommentTextField, writeYourCommentTextField_Name, commentText);
		return this;
	}

	public CommentDetailsScreenPage clickOnPostButton(String expected) {
		mobileActions.waitForVisible(commentPostButton);
		Assert.assertTrue(mobileActions.isDisplayed(commentPostButton, commentPostButton_Name));
		String actual = mobileActions.getText(commentPostButton, commentPostButton_Name, true);
		expected = LanguageDataProvider.getLanguageDataValue("PostButtonText");
		mobileActions.click(commentPostButton, commentPostButton_Name);
		return this;
	}
	public CommentDetailsScreenPage clickOnBackButtonOfKoo() {
		mobileActions.waitForVisible(backButtonAfterPostComment);
		Assert.assertTrue(mobileActions.isDisplayed(backButtonAfterPostComment, backButtonAfterPostComment_Name));
		mobileActions.click(backButtonAfterPostComment, backButtonAfterPostComment_Name);
		return this;
	}

	public CommentDetailsScreenPage verifyPopUpMessage(String expectedPopUpMessage) {
		mobileActions.waitForVisible(commentPostedSuccessfullyPopup);
		String actualPopUpMessage = mobileActions
				.getText(commentPostedSuccessfullyPopup, commentPostedSuccessfullyPopup_Name, true).trim();
		if (mobileActions.isDisplayed(commentPostedSuccessfullyPopup, commentPostedSuccessfullyPopup_Name)) {
			BaseTest.LOGGER.get().logInfo(actualPopUpMessage + " is Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualPopUpMessage, expectedPopUpMessage,
					"Both are matched", true, BaseTest.mobileDriver.get(), true);
		} else {
			BaseTest.LOGGER.get().logInfo(actualPopUpMessage + " is not Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualPopUpMessage, expectedPopUpMessage,
					"Both are not matched", true, BaseTest.mobileDriver.get(), true);

		}
		return this;
	}

	public CommentDetailsScreenPage clickOnViewLink() {
		mobileActions.waitForVisible(viewOfSuccessfullyPostedButton);
		Assert.assertTrue(
				mobileActions.isDisplayed(viewOfSuccessfullyPostedButton, viewOfSuccessfullyPostedButton_Name));
		mobileActions.click(viewOfSuccessfullyPostedButton, viewOfSuccessfullyPostedButton_Name);
		return this;
	}

	public CommentDetailsScreenPage clickOnBackButtonFromCommentPage() {
		mobileActions.waitForVisible(backButtonFromComment);
		Assert.assertTrue(mobileActions.isDisplayed(backButtonFromComment, backButtonFromComment_Name));
		mobileActions.click(backButtonFromComment, backButtonFromComment_Name);
		return this;
	}

	public CommentDetailsScreenPage verifyCommentsSectionHeader(int swipes,String expectedHeader) {
		mobileActions.swipeUpFindElement(swipes, commentsText);
		mobileActions.waitForVisible(commentsText);
		String actualHeader = mobileActions.getText(commentsText, commentsText_Name, true).trim();
		if (mobileActions.isDisplayed(commentsText, commentsText_Name)) {
			BaseTest.LOGGER.get().logInfo(actualHeader + " is Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualHeader, expectedHeader, "Both are matched",
					true, BaseTest.mobileDriver.get(), true);
		} else {
			BaseTest.LOGGER.get().logInfo(actualHeader + " is not Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualHeader, expectedHeader,
					"Both are not matched", true, BaseTest.mobileDriver.get(), true);

		}
		return this;
	}

	public CommentDetailsScreenPage verifyAlert(String expectedAlertText) {
		mobileActions.waitForVisible(alertDailogTitle);
		String actualAlertText = mobileActions.getText(alertDailogTitle, alertDailogTitle_Name, true).trim();
		if (mobileActions.isDisplayed(alertDailogTitle, alertDailogTitle_Name)) {
			BaseTest.LOGGER.get().logInfo(actualAlertText + " is Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualAlertText, expectedAlertText,
					"Both are matched", true, BaseTest.mobileDriver.get(), true);
			mobileActions.waitForVisible(navigateButton);
			Assert.assertTrue(mobileActions.isDisplayed(navigateButton, navigateButton_Name));
			mobileActions.click(navigateButton, navigateButton_Name);
		} else {
			BaseTest.LOGGER.get().logInfo(actualAlertText + " is not Displayed");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualAlertText, expectedAlertText,
					"Both are not matched", true, BaseTest.mobileDriver.get(), true);

		}
		return this;
	}
}
