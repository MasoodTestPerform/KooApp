package com.koo.android.utils;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.android.allpages.*;
import com.google.common.collect.ImmutableMap;
import com.koo.framework.BaseTest;

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;


public class CommonHelper {
	
	 public static MobileActions mobileActions = new MobileActions();
	 public static UserBlockPage userBlockPage = new UserBlockPage();
	 public static KooCardPage kooCardPage = new KooCardPage();
	 public static SettingsPage settingsPage = new SettingsPage();
	 public static KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
	 public static KooCreationPage kooCreationPage = new KooCreationPage();
	 public static HashTagScreenPage hashTagScreenPage = new HashTagScreenPage();
	 public static ScreensPage screensPage = new ScreensPage();
	 public static HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
	 public static CarouselPage carouselPage = new CarouselPage();
	 public static PeopleTabPage peopleTabPg = new PeopleTabPage();
	 public static ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
	 public static SearchPage searchPage = new SearchPage();

	    /**
	     * This method is to click on Home icon from footer bar
	     * @throws IOException
	     */
	    public static void clickOnHomeButton(){
	        mobileActions.waitForVisible(userBlockPage.homeButton);
	        mobileActions.click(userBlockPage.homeButton, userBlockPage.homeButton_Name);
	    }

	    /**
	     * This method is to click on Edit button from Profile page
	     * @throws IOException
	     */
	    public static void clickOnEditButtonFromProfilePage() {
	        mobileActions.waitForVisible(kooCardPage.editProfileButton);
	        mobileActions.click(kooCardPage.editProfileButton, kooCardPage.editProfileButton_Name);
	    }

	    /**
	     * This method is to logout the user
	     * @throws IOException
	     */
	    public static void logOutUser(){
	        mobileActions.waitForVisible(userBlockPage.logOutUser);
	        mobileActions.click(userBlockPage.logOutUser, userBlockPage.logOutUser_Name);
	        mobileActions.waitForVisible(userBlockPage.logOutUser_popup);
	        mobileActions.click(userBlockPage.logOutUser_popup, userBlockPage.logOutUser_popup_Name);
	    }

	    /**
	     * This method is to click on cancel button from logout popup
	     * @throws IOException
	     */
	    public static void clickCancelButtonOnLogOutAndDeleteAccountPopUp() {
	        mobileActions.waitForVisible(settingsPage.cancelButtonOnLogOutPopUp);
	        mobileActions.click(settingsPage.cancelButtonOnLogOutPopUp, settingsPage.cancelButtonOnLogOutPopUp_Name);
	    }

	    /**
	     * This method is to click on cancel link from search result
	     * @throws IOException
	     */
	    public static void clickOnCancelLinkFromSearchBar(){
	        mobileActions.waitForVisible(userBlockPage.cancelButton);
	        mobileActions.click(userBlockPage.cancelButton, userBlockPage.cancelButton_Name);
	    }

	    /**
	     * This method is to click on Profile
	     * @throws IOException
	     */
	    public static void clickOnProfile(){
	        mobileActions.waitForVisible(kooCardPage.profile_icon);
	        mobileActions.click(kooCardPage.profile_icon, kooCardPage.profile_icon_Name);
	    }

	    /**
	     * This method is to click on back button from profile page
	     * @throws IOException
	     */
	    public static void verifyAndClickOnBackButtonOnProfilePage(){
	        mobileActions.waitForVisible(userBlockPage.backButton);
	        boolean dispayedFlag = mobileActions.isDisplayed(userBlockPage.backButton, userBlockPage.backButton_Name);
	        BaseTest.utilObj.get().getAssertManager().sAssertEquals(dispayedFlag,true, "Verify Back button is present", true, BaseTest.mobileDriver.get(), true); 
	        mobileActions.click(userBlockPage.backButton, userBlockPage.backButton_Name);
	    }

	    /**
	     * This method is click on back arrow
	     * @throws IOException
	     */
	    public static void clickOnBackArrow() {
	        mobileActions.waitForVisible(userBlockPage.backButton_arrow);
	        mobileActions.click(userBlockPage.backButton_arrow, userBlockPage.backButton_arrow_Name);
	    }

	    /**
	     * This method is to verify profile username
	     * @param userName
	     */
	    public static void verifyProfileUserName(String userName){
	        boolean dispayedFlag = mobileActions.isDisplayed(mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.profileUserName, "xpath",userName),
	        		kooDetailScreenPage.profileUserName_Name);
	        BaseTest.utilObj.get().getAssertManager().sAssertEquals(dispayedFlag,true, "Verify profile username is present", true, BaseTest.mobileDriver.get(), true); 
	    }

	    /**
	     * This method is to create and post koo with default selected language
	     * @param text
	     * @param postButton
	     * @throws IOException
	     */
	    public static void createAndPostKoo(String language, String text, String postButton) {
	        mobileActions.click(kooCreationPage.btn_plus, kooCreationPage.btn_plus_Name);
	        mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, text);
	        mobileActions.click(
	                mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, kooCreationPage.btn_post_Name, postButton),
	                "Click on Post Button");
	        if(language.equalsIgnoreCase("English")){
	            mobileActions.click(kooCreationPage.btn_okScheduleKoo, kooCreationPage.btn_okScheduleKoo_Name);
	            mobileActions.click(kooDetailScreenPage.languageDoneButton, kooDetailScreenPage.languageDoneButton_Name);
	        }
	    }

	    /**
	     * This method is to click on search ico
	     * @throws IOException
	     */
	    public static void clickOnSearchIcon() {
	    	mobileActions.waitForVisible(hashTagScreenPage.search_icon);
	        mobileActions.click(hashTagScreenPage.search_icon, hashTagScreenPage.search_icon_Name);
	    }

	    /**
	     * This method is to click o ack arrow after searching value
	     * @throws IOException
	     */
	    public static void clickOnBackArrowFromSearchBar() {
	        mobileActions.waitForVisible(screensPage.backArrowFromSearch);
	        mobileActions.click(screensPage.backArrowFromSearch, screensPage.backArrowFromSearch_Name);
	    }

	    /**
	     * This method is to click on Enter button
	     */
	    public static void clickEnterButton(){
	    	((RemoteWebDriver) BaseTest.mobileDriver.get()).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
	    }

	    /**
	     * This method is to click on Enter button
	     */
	    public static void clickSearchedProfileFromSearchResult(String profileID) {
	        mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooDetailScreenPage.profileIDOnSearchResult, "xpath",profileID),
	        		kooDetailScreenPage.profileIDOnSearchResult_Name);
	    }

	    /**
	     * This method is to click on search bar field
	     * @throws IOException
	     */
	    public static void clickOnSearchBarField() {
	    	mobileActions.click(searchPage.searchBar, searchPage.searchBar_Name);
	       // mobileActions.click(hashTagScreenPage.searchBar_field, hashTagScreenPage.searchBar_field_Name);
	    }

	    /**
	     * This method is to enter value in search bar field
	     * @param value
	     * @throws IOException
	     */
	    public static void enterValueInSearchBar(String value) {
	    	mobileActions.click(searchPage.searchBar, searchPage.searchBar_Name);
	       // mobileActions.sendKeys(hashTagScreenPage.searchBar_field, hashTagScreenPage.searchBar_field_Name, value) ;
	    }

	    /**
	     * This method is to type value from keyboard
	     * @param value
	     */
	    public static void enterValueFromKeyboard(String value){
	        Keyboard keyboard = ((RemoteWebDriver) BaseTest.mobileDriver.get()).getKeyboard();
	        keyboard.pressKey(value);
	    }

	    /**
	     * This method is to hide keyboard
	     */
	    public static void hideKeyboard(){
	    	((HidesKeyboard) BaseTest.mobileDriver.get()).hideKeyboard();
	    }

	    /**
	     * Click on No or Cancel button
	     * @throws IOException
	     */
	    public static void clickOnNoOrCancelButton() {
	        boolean element = mobileActions.isElmPresent(userBlockPage.noButton);
	        if(element){
	            mobileActions.click(userBlockPage.noButton, userBlockPage.noButton_Name);
	        }else {
	        	BaseTest.mobileDriver.get().navigate().back();
	        }
	    }

	    /**
	     * Click on Cross button for close tab
	     * @throws IOException
	     */
	    public static void clickOnCrossButton()  {
	        mobileActions.waitForVisible(settingsPage.crossButtonForCloseTab);
	        mobileActions.click(settingsPage.crossButtonForCloseTab, settingsPage.crossButtonForCloseTab_Name);
	    }

	    /**
	     * This method is to click on Chat icon from bottom bar
	     * @throws IOException
	     */
	    public static void clickOnChatButton() {
	        mobileActions.waitForVisible(homeScreenTabPage.chatIcon);
	        mobileActions.click(homeScreenTabPage.chatIcon, homeScreenTabPage.chatIcon_Name);
	    }

	    /**
	     * This method is to click on Notification icon from bottom bar
	     * @throws IOException
	     */
	    public static void clickOnNotificationButton() {
	        mobileActions.waitForVisible(homeScreenTabPage.notificationIcon);
	        mobileActions.click(homeScreenTabPage.notificationIcon, homeScreenTabPage.notificationIcon_Name);
	    }

	    /**
	     * This method is to click on Koo bird
	     * @throws IOException
	     */
	    public static void clickOnKooBird() {
	        mobileActions.waitForVisible(homeScreenTabPage.kooBirdIcon);
	        mobileActions.click(homeScreenTabPage.kooBirdIcon, homeScreenTabPage.kooBirdIcon_Name);
	    }

	    /**
	     * This method is to click on small cross button
	     * @throws IOException
	     */
	    public static void clickOnSmallCrossButton() {
	        mobileActions.waitForSec(5);
	        mobileActions.waitForVisible(carouselPage.crossButton);
	        mobileActions.click(carouselPage.crossButton, carouselPage.crossButton_Name);
	    }

	    /**
	     * This method is to normal swipe up
	     * @return
	     */
	    public static <T> T swipeUp(T landingPage, int i){
	        mobileActions.swipeUp(i);
	        return landingPage;
	    }

	    /**
	     * This method is to click on three dots from profile of user
	     *
	     * @throws IOException
	     */
	    public static void clickOnThreeDotsOProfilePage() {
	        mobileActions.waitForVisible(userBlockPage.threeDots);
	        mobileActions.click(userBlockPage.threeDots, userBlockPage.threeDots_Name);
	    }

	    /**
	     * This method is to click on settings button
	     *
	     * @return
	     * @throws IOException
	     */
	    public static void clickSettingsButton() {
	        mobileActions.waitForVisible(userBlockPage.settings);
	        mobileActions.click(userBlockPage.settings, userBlockPage.settings_Name);
	    }

	    /**
	     * This method is to click on settings button
	     *
	     * @return
	     * @throws IOException
	     */
	    public static void clickTrendingKooIcon() {
	        mobileActions.waitForVisible(homeScreenTabPage.trendingKooIcon);
	        mobileActions.click(homeScreenTabPage.trendingKooIcon, homeScreenTabPage.trendingKooIcon_Name);
	    }

	    /**
	     * This method is to create and post koo with default selected language
	     * @param text
	     * @param postButton
	     * @throws IOException
	     */
	    public static void createAndPostKooWithAttachment(String language, String text, String postButton) {
	        mobileActions.click(kooCreationPage.btn_plus, kooCreationPage.btn_plus_Name);
	        mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, text);
	        mobileActions.click(kooCreationPage.addImageButton, kooCreationPage.addImageButton_Name);
	        if(mobileActions.isElmPresent(kooCreationPage.enablePermissionButton)){
	            mobileActions.click(kooCreationPage.enablePermissionButton, kooCreationPage.enablePermissionButton_Name);
	            mobileActions.click(peopleTabPg.allowPermission, peopleTabPg.allowPermission_Name);
	            mobileActions.click(peopleTabPg.allowPermission, peopleTabPg.allowPermission_Name);
	            
	        }
	        mobileActions.click(kooCreationPage.selectImage, kooCreationPage.selectImage_Name);
	        if(mobileActions.isElmPresent(kooCreationPage.nextButton)){
	            mobileActions.click(kooCreationPage.nextButton, kooCreationPage.nextButton_Name);
	        }
	        mobileActions.click(
	                mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", postButton),
	                kooCreationPage.btn_post_Name);
	        if(language.equalsIgnoreCase("English")){
	            mobileActions.click(kooCreationPage.btn_okScheduleKoo, kooCreationPage.btn_okScheduleKoo_Name);
	            mobileActions.click(kooDetailScreenPage.languageDoneButton, kooDetailScreenPage.languageDoneButton_Name);
	        }
	    }

	    /**
	     * This method is to click on view koo button
	     */
	    public static void clickOnViewPostedKooButtonAfterPostingKooOrComment(){
	        mobileActions.waitForVisible(kooCreationPage.viewPostedKooButton);
	        mobileActions.click(kooCreationPage.viewPostedKooButton, kooCreationPage.viewPostedKooButton_Name);
	    }

	    /**
	     * This method is to click on like button
	     * @return
	     */
	    public static void clickOnLikeIcon(){
	        mobileActions.click(kooCardPage.btn_like, kooCardPage.btn_like_Name);
	    }

	    /**
	     * This method is to click on comment icon and post comment
	     * @param commentText
	     * @return
	     */
	    public static void clickOnCommentIconAndPostComment(String commentText){
	        mobileActions.click(kooCardPage.btn_comment, kooCardPage.btn_comment_Name);
	        mobileActions.sendKeys(exploreScreenPage.write_commentSection, exploreScreenPage.write_commentSection_Name,
	                commentText);
	        mobileActions.click(exploreScreenPage.button_post, exploreScreenPage.button_post_Name);
	    }

	    /**
	     * This method is to click on rekoo button and then click on No rekoo button
	     */
	    public static void clickOnReKooIconAndNoReKooButton(){
	        mobileActions.click(kooCardPage.reeKooIcon, kooCardPage.reeKooIcon_Name);
	        mobileActions.click(kooCardPage.reeKooNoButton, kooCardPage.reeKooNoButton_Name);
	    }

	    /**
	     * Click on refresh icon to refresh comments
	     */
	    public static void clickOnRefreshIconToRefreshComments(){
	        mobileActions.click(homeScreenTabPage.refreshButtonOnTrendingKooPage, homeScreenTabPage.refreshButtonOnTrendingKooPage_Name);
	    }

	    /**
	     * This method is to create and post koo with default selected language
	     * @param text
	     * @param postButton
	     * @throws IOException
	     */
	    public static void createAndPostMLKKoo(String language, String text, String postButton, List<String> languageContentDesc) throws InterruptedException {
	        mobileActions.click(kooCreationPage.btn_plus, kooCreationPage.btn_plus_Name);
	        mobileActions.sendKeys(kooCreationPage.txt_Message, kooCreationPage.txt_Message_Name, text);
	        mobileActions.click(
	                mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.btn_post, "xpath", postButton),
	                kooCreationPage.btn_post_Name);
	        if(language.equalsIgnoreCase("English")){
	            mobileActions.click(kooCreationPage.btn_okScheduleKoo, kooCreationPage.btn_okScheduleKoo_Name);
	            for(int i = 0; i < languageContentDesc.size(); i++){
	                mobileActions.swipeUpFindElement(10,mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.chkbox_everyone, "xpath", languageContentDesc.get(i)));
	                mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCreationPage.chkbox_everyone,"xpath",
	                                languageContentDesc.get(i)),
	                        "Click on checkbox to select multiple languages = "+languageContentDesc.get(i));
	            }
	            mobileActions.click(kooDetailScreenPage.languageDoneButton, kooDetailScreenPage.languageDoneButton_Name);
	            mobileActions.waitForVisible(mobileActions.returnByBasedOnPageNameAndObjectName(kooCardPage.postButton, "xpath", postButton));
	            mobileActions.click(mobileActions.returnByBasedOnPageNameAndObjectName(kooCardPage.postButton, "xpath", postButton),
	            		postButton + ":"+ kooCardPage.postButton_Name);
	        }
	    }

}
