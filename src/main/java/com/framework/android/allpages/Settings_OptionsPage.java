package com.framework.android.allpages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.koo.android.utils.CommonHelper;
import com.koo.android.utils.LanguageDataProvider;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;
import com.koo.utils.UIUtils;

public class Settings_OptionsPage {
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	PeopleTabPage peopleTabPage = new PeopleTabPage();
	HomePage homePage = new HomePage();
	CommonHelper commonHelperPage = new CommonHelper();
	UIUtils uiUtilsPage = new UIUtils();
	SoftAssert softAssert = new SoftAssert();
	ProfileScreenPage profileScreenPage = new ProfileScreenPage();
	KooCardPage kooCardPage = new KooCardPage();
	UserBlockPage userBlockPage = new UserBlockPage();
	KooRewardsProgramPage kooRewardsProgramPage = new KooRewardsProgramPage();
	ManageTopicsPage manageTopicsPage = new ManageTopicsPage();

	String actualText;
	String expectedText;

	// UserBlock
	public By settingsButton = By.id("com.koo.app:id/settings");
	public String settingsButton_Name = "Setting Button";
	public By closeButton = By.id("com.android.chrome:id/close_button");
	public String closeButton_Name = "Close button in Web";

	// Notifications
	public By notifications_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/notification_layout']/android.widget.TextView");
	public String notifications_Settings_Name = "Notification Options in Others";
	public By noticationBackButtonText = By.id("com.koo.app:id/backArrow");
	public String noticationBackButtonText_Name = "Back Button from Notifications";
	public By noticationsPageHeaderText = By.id("com.koo.app:id/toolbar_heading_textview");
	public String noticationsPageHeaderText_Name = "Notifications Page Heading";

	// Whatsapp Updates
	public By whatsappUpdates_Settings = By.xpath(
			"//*[@resource-id='com.koo.app:id/whatsapp_ll']/android.widget.LinearLayout/android.widget.TextView");
	public String whatsappUpdates_Settings_Name = "Whatsapp Updates Option in Others";
	public By whatsappUpdatesSwitch_Text = By.id("com.koo.app:id/whatsapp_switch");
	public String whatsappUpdatesSwitch_Text_Name = "Whatsapp Updates Switch";

	// Video Autoplay
	public By videoAutoPlay_Settings = By
			.xpath("//*[@resource-id='com.koo.app:id/autoplay_videos']/android.widget.TextView");
	public String videoAutoPlay_Settings_Name = "Video Autoplay Option in Others";
	public By videoAutoPlaySwitchText = By.id("com.koo.app:id/autoplay_switch");
	public String videoAutoPlaySwitchText_Name = "Video Auto Play Switch";

	// Auto Play Images
	public By autoPlayImages_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/autoplay_images']/android.widget.TextView)");
	public String autoPlayImages_Settings_Name = "Autoplay Images Option in Others";
	public By autoPlayImagesSwitchText = By.id("com.koo.app:id/autoplay_images_switch");
	public String autoPlayImagesSwitchText_Name = "Auto Play Images Switch";

	// Translation
	public By translation_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/translation_layout']/android.widget.TextView)");
	public String translation_Settings_Name = "Transaction Option in Others";
	public By translationSwitchText = By.id("com.koo.app:id/translation_switch");
	public String transalationSwitchText_Name = "Transaction Switch";

	// Koo Rewards
	public By kooRewards_Settings = By.id("com.koo.app:id/setting_reward_text");
	public String kooRewards_Settings_Name = "Koo Rewards Option in Others";
	public By kooRewardsSwitchText = By.id("com.koo.app:id/rewards_switch");
	public String kooRewardsSwitchText_Name = "Koo Rewards Switch";

	// Help
	public By help_Settings = By.xpath("(//*[@resource-id='com.koo.app:id/feedback_layout']/android.widget.TextView)");
	public String help_Settings_Name = "Help Option in Others";

	// Privacy Policy
	public By privacyPolicy_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/privacy_policy_layout']/android.widget.TextView)");
	public String privacyPolicy_Settings_Name = "Privacy Policy Option in Others";

	// About us
	public By aboutUS_Settings = By.xpath("(//*[@resource-id='com.koo.app:id/about_layout']/android.widget.TextView)");
	public String aboutUS_Settings_Name = "About Us Option in Others";

	// Resource Center
	public By resourceCenter_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/resource_layout']/android.widget.TextView)");
	public String resourceCenter_Settings_Name = "Resource Center Option in Others";

	// PlayStore Compliance
	public By playStoreCompliance_Settings = By
			.xpath("(//*[@resource-id='com.koo.app:id/playStoreComplianceLayout']/android.widget.TextView)");
	public String playStoreCompliance_Settings_Name = "Play Store Compliance Option in Others";

	// Chrome Title
	public By chromePageTitle = By.id("com.android.chrome:id/title");
	public String chromePageTitle_Name = "Redirected to Chrome Page";

	/**
	 * This method is to verify Options in Others
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyOptionsinOthers() {
		try {
			mobileActions.swipeUp(3);
			actualText = mobileActions.getText(notifications_Settings, notifications_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(whatsappUpdates_Settings, whatsappUpdates_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionWhatsappUpdateSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(videoAutoPlay_Settings, videoAutoPlay_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionVideoAutoPLaySubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(autoPlayImages_Settings, autoPlayImages_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionAutoPLayImagesSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(translation_Settings, translation_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionTranslationSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(kooRewards_Settings, kooRewards_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionKooRewardsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(help_Settings, help_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(privacyPolicy_Settings, privacyPolicy_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(aboutUS_Settings, aboutUS_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(resourceCenter_Settings, resourceCenter_Settings_Name, true).trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionResourceCenterSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);
			actualText = mobileActions.getText(playStoreCompliance_Settings, playStoreCompliance_Settings_Name, true)
					.trim();
			expectedText = LanguageDataProvider.getLanguageDataValue("OthersSectionPlayStoreCompSubHeading");
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualText, expectedText, "Both names are matched",
					false, BaseTest.mobileDriver.get(), true);

		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Options in Others Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options in Others Validation Failed", true,
					BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Notifications Option
	 *
	 * @return
	 */
	public Settings_OptionsPage verifyNotifications_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading"));
			boolean notifications = mobileActions.isElmPresent(notifications_Settings);
			String beforeText = mobileActions.getText(notifications_Settings, notifications_Settings_Name, true).trim();
			mobileActions.click(notifications_Settings, notifications_Settings_Name);
			if (mobileActions.isDisplayed(noticationsPageHeaderText, noticationsPageHeaderText_Name)) {
				String afterText = mobileActions
						.getText(noticationsPageHeaderText, noticationsPageHeaderText_Name, true).trim();
				BaseTest.LOGGER.get().logInfo(noticationsPageHeaderText_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						noticationsPageHeaderText_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(noticationsPageHeaderText_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						noticationsPageHeaderText_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError("Notifications Page Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, "Options are not displaying", true,
					BaseTest.mobileDriver.get(), true);
		}
		mobileActions.click(noticationBackButtonText, noticationBackButtonText_Name);
		return this;
	}

	/**
	 * This method is to verify WhatsappUpdates Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyWhatsappUpdates_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionWhatsappUpdateSubHeading"));
			mobileActions.getText(whatsappUpdates_Settings, whatsappUpdates_Settings_Name, true).trim();
			boolean whatsappSwitch = mobileActions.isElmPresent(whatsappUpdates_Settings);
			if (whatsappSwitch) {
				BaseTest.LOGGER.get().logInfo(whatsappUpdates_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						whatsappUpdates_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(whatsappUpdates_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						whatsappUpdates_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(whatsappUpdates_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					whatsappUpdates_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Video Play Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyVideoPlay_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionVideoAutoPLaySubHeading"));
			mobileActions.getText(videoAutoPlay_Settings, videoAutoPlay_Settings_Name, true);
			boolean videoAutoPlaySwitch = mobileActions.isElmPresent(videoAutoPlaySwitchText);
			if (videoAutoPlaySwitch) {
				BaseTest.LOGGER.get().logInfo(videoAutoPlay_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						videoAutoPlay_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(videoAutoPlay_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						videoAutoPlay_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(videoAutoPlay_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					videoAutoPlay_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Auto Play Images Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyAutoPlayImages_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionAutoPLayImagesSubHeading"));
			mobileActions.getText(autoPlayImages_Settings, autoPlayImages_Settings_Name, true);
			boolean autoPlayImagesSwitch = mobileActions.isElmPresent(autoPlayImagesSwitchText);
			if (autoPlayImagesSwitch) {
				BaseTest.LOGGER.get().logInfo(autoPlayImages_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						autoPlayImages_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(autoPlayImages_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						autoPlayImages_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(autoPlayImages_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					autoPlayImages_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Translation Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyTransaltion_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionTranslationSubHeading"));
			mobileActions.getText(translation_Settings, translation_Settings_Name, true);
			boolean transalationSwitch = mobileActions.isElmPresent(translationSwitchText);
			if (transalationSwitch) {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, translation_Settings_Name + " is Displayed",
						true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						translation_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(translation_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					translation_Settings_Name + " is not Displayed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Rewards Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyRewards_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionKooRewardsSubHeading"));
			mobileActions.getText(kooRewards_Settings, kooRewards_Settings_Name, true);
			boolean transalationSwitch = mobileActions.isElmPresent(kooRewardsSwitchText);
			if (transalationSwitch) {
				BaseTest.LOGGER.get().logInfo(kooRewards_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, kooRewards_Settings_Name + " is Displayed",
						true, BaseTest.mobileDriver.get(), true);
			} else {
				BaseTest.LOGGER.get().logInfo(translation_Settings_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
						kooRewards_Settings_Name + " is Not Displayed", true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(kooRewards_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, kooRewards_Settings_Name + " is not Displayed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Help Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyHelpOption_inSettings() {
		try {
			mobileActions.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading"));
			mobileActions.swipeUsingText("Notifications");
			mobileActions.getText(help_Settings, help_Settings_Name, true);
			boolean helpOption = mobileActions.isElmPresent(help_Settings);
			if (helpOption) {
				BaseTest.LOGGER.get().logInfo(help_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true, help_Settings_Name + " is Displayed", true,
						BaseTest.mobileDriver.get(), true);
				mobileActions.click(help_Settings, help_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(help_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, help_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Privacy Policy Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyPrivacyPolicyOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading"));
			mobileActions.getText(privacyPolicy_Settings, privacyPolicy_Settings_Name, true);
			boolean privacyPolicyOption = mobileActions.isElmPresent(privacyPolicy_Settings);
			if (privacyPolicyOption) {
				BaseTest.LOGGER.get().logInfo(privacyPolicy_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						privacyPolicy_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(privacyPolicy_Settings, privacyPolicy_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(privacyPolicy_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					privacyPolicy_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify About Us Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyAboutUsOption_inSettings() {
		try {
			mobileActions.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading"));
			mobileActions.getText(aboutUS_Settings, aboutUS_Settings_Name, true);
			boolean aboutUsOption = mobileActions.isElmPresent(aboutUS_Settings);
			if (aboutUsOption) {
				BaseTest.LOGGER.get().logInfo(aboutUS_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						privacyPolicy_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(aboutUS_Settings, aboutUS_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(aboutUS_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, aboutUS_Settings_Name + " Validation Failed",
					true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyResourceCenterOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionResourceCenterSubHeading"));
			mobileActions.getText(resourceCenter_Settings, resourceCenter_Settings_Name, true);
			boolean resourceCenterOption = mobileActions.isElmPresent(resourceCenter_Settings);
			if (resourceCenterOption) {
				BaseTest.LOGGER.get().logInfo(resourceCenter_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						resourceCenter_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(resourceCenter_Settings, resourceCenter_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(resourceCenter_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					resourceCenter_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}

	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage verifyPlayStoreComplianceOption_inSettings() {
		try {
			mobileActions
					.swipeUsingText(LanguageDataProvider.getLanguageDataValue("OthersSectionPlayStoreCompSubHeading"));
			boolean playStoreOption = mobileActions.isElmPresent(playStoreCompliance_Settings);
			mobileActions.getText(playStoreCompliance_Settings, playStoreCompliance_Settings_Name, true);
			if (playStoreOption) {
				BaseTest.LOGGER.get().logInfo(playStoreCompliance_Settings_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						playStoreCompliance_Settings_Name + " is Displayed", true, BaseTest.mobileDriver.get(), true);
				mobileActions.click(playStoreCompliance_Settings, playStoreCompliance_Settings_Name);
				crossButtonInWebPage();
				BaseTest.LOGGER.get().logInfo("Successfully " + chromePageTitle_Name + " is Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(true,
						"Successfully " + chromePageTitle_Name + " is Displayed", true, BaseTest.mobileDriver.get(),
						true);
			} else {
				BaseTest.LOGGER.get().logInfo(chromePageTitle_Name + " is Not Displayed");
				BaseTest.utilObj.get().getAssertManager().sAssertTrue(false, chromePageTitle_Name + " is Not Displayed",
						true, BaseTest.mobileDriver.get(), true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseTest.LOGGER.get().logError(playStoreCompliance_Settings_Name + " Validation Failed");
			BaseTest.utilObj.get().getAssertManager().sAssertTrue(false,
					playStoreCompliance_Settings_Name + " Validation Failed", true, BaseTest.mobileDriver.get(), true);
		}
		return this;
	}
	
	/**
	 * This method is to verify Resource Center Option
	 * 
	 * @return
	 */
	public Settings_OptionsPage crossButtonInWebPage()
	{
		boolean crossButton = mobileActions.isElmPresent(closeButton);
		mobileActions.waitForVisible(closeButton);
		mobileActions.click(closeButton, closeButton_Name);
		return this;
	}
	

}