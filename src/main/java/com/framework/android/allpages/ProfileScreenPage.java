package com.framework.android.allpages;

import org.openqa.selenium.By;

public class ProfileScreenPage {
	
	public By img_profilePic = By.id("com.koo.app:id/image_view");
	public By txt_profileName = By.id("com.koo.app:id/channel_name_textview");
	public By btn_selfVerifyTag = By.id("com.koo.app:id/btn_self_verify");
	public By btn_backInProfileScreen = By.id("com.koo.app:id/layoutBack");
	public By btn_threeDots = By.id("com.koo.app:id/layoutOptionMenu");
	public By btn_addImages = By.id("com.koo.app:id/addMoreImageIcon");
	public By btn_backInAddphotos = By.xpath("//android.widget.ImageView[@content-desc='BACK']");
	public By btn_editProfilePic = By.id("com.koo.app:id/menu_pic_edit");
	public By txt_noOfProfilePhotos = By.id("com.koo.app:id/image_position_text");
	public By txt_profession = By.id("com.koo.app:id/profession_textview");
	public By txt_bio = By.id("com.koo.app:id/description_textview");
	public By btn_more = By.id("com.koo.app:id/read_more");
	public By btn_backInProfilePicturesScreen = By.xpath("//android.widget.ImageButton");
	public By txt_profileNameinMorePopup = By.xpath("(//android.widget.TextView)[1]");
	public By btn_editinMorePopup = By.xpath("(//android.widget.TextView)[3]");
	public By txt_professioninMorePopup = By.xpath("(//android.widget.TextView)[4]");
	public By txt_bioinMorePopup = By.xpath("(//android.widget.TextView)[5]");
	public By txt_dateOfJoininMorePopup = By.xpath("(//android.widget.TextView)[6]");
	public By txt_socialMedialinksHeadinginMorePopup = By.xpath("(//android.widget.TextView)[7]");
	public By btn_closeinMorePopup = By.xpath("(//android.widget.TextView)[9]");
	public String tab_people = "//android.widget.LinearLayout[@content-desc='###']";
	public String tab = "//android.widget.LinearLayout[@content-desc='###']";
	public By btn_arrowInPeopleTab = By.id("com.koo.app:id/header_icon_right");
	public String btn_arrowForSpecificSectionUnderPeopleTa = "//android.widget.TextView[@text='###']//following-sibling::android.widget.ImageView[@resource-id='com.koo.app:id/header_icon_right']";
	public By btn_publicProfile = By.xpath("(//android.widget.TextView)[3]");
	public By btn_followInPublicProfile = By.id("com.koo.app:id/tvFollow");
	public By btn_follow1InPublicProfile = By.id("com.koo.app:id/ivFollow");
	public By btn_ShareInPublicProfile = By.id("com.koo.app:id/itemShareUrl");
	public By btn_followingInPublicProfile = By.id("com.koo.app:id/itemfollowUser");
	public By btn_directMsgInPublicProfile = By.id("com.koo.app:id/itemdirectmessage");
	public By btn_blockMsgInPublicProfile = By.id("com.koo.app:id/itemblockUser");
	public By btn_reportUserInPublicProfile = By.id("com.koo.app:id/itemreportUser");
	public By btn_closeInPublicProfile = By.id("com.koo.app:id/bottom_sheet_close");
	public By txt_pplYouCanFollow = By.id("com.koo.app:id/top_user_title");
	public By txt_noOfKoos = By.xpath("(//android.widget.TextView)[12]");
	public By txt_noOfKoos1 = By.xpath("//android.widget.ImageView[@content-desc='CREATED_KOO']/..");
	public By txt_noOfLikes = By.xpath("(//android.widget.TextView)[13]");
	public By txt_noOfComments = By.xpath("(//android.widget.TextView)[14]");
	public By txt_noOfReKoos = By.xpath("(//android.widget.TextView)[15]");
	public By txt_noOfMentions = By.xpath("//android.widget.ImageView[@content-desc='MENTIONS']");
	public By txt_noOfSaved = By.xpath("//android.widget.ImageView[@content-desc='ADD_TO_FAVOURITE']");
	public By btn_addforimage = By.xpath("//android.widget.Button");
	public By btn_editAadhar = By.id("com.koo.app:id/edit_Aadhar");
	public By txt_errorMsg = By.id("com.koo.app:id/error_textview");
	public By btn_getOTP = By.id("com.koo.app:id/otp_button");
	public By txt_profileHeader = By.xpath("(//android.widget.TextView[@text='Rajesh'])[2]");
	public By txt_msgPosted = By.id("com.koo.app:id/topic_title_textview");
	public By btn_bengaliLang = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/text_multilan_title'])[2]");
	public By btn_expandThreadKoo = By.id("com.koo.app:id/tvExpandThread");
	public By txt_likedProfileHeader = By.id("com.koo.app:id/layout_profile");
	public By btn_threadkooCommentbox = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/comment_imageview'])[1]");
	public By btn_commentinThreadKoo = By.xpath("//android.widget.EditText");
	public By txt_comments = By.id("com.koo.app:id/header_text");
	public By btn_showThisThreadInCommentsTab = By.id("com.koo.app:id/tvShowThisThread");
	public By txt_rekoowithComments = By.id("com.koo.app:id/tv_koo_header");
	public By btn_saved = By.id("com.koo.app:id/btnAddToFavorite");
	public By txt_kooSavedTime = By.id("com.koo.app:id/koo_time_creation_tv");
	public By btn_followers = By.id("com.koo.app:id/followers_layout");
	public By txt_followersheading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By btn_following = By.id("com.koo.app:id/following_layout");
	public By txt_followingheading = By.id("com.koo.app:id/toolbar_heading_textview");
	public By txt_all = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/custom_tab_text'])[1]");
	public By txt_latest = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/custom_tab_text'])[2]");
	public String btn_follow = "(//android.widget.TextView[@text='###'])[1]";
	public By btn_pinToProfile = By.id("com.koo.app:id/itempinKoo");
	public By btn_yes = By.id("android:id/button1");
	public By txt_pinnedKoo = By.id("com.koo.app:id/tv_koo_pinned");
	public By skipAndContinue = By.id("com.koo.app:id/bt_continue");
	public By createFirstKoo = By.id("com.koo.app:id/tv_create_koo");
	public By likesKoos = By.xpath("//android.widget.ImageView[@content-desc='LIKE_KOOS']");
	public By noKoos = By.id("com.koo.app:id/tv_title");
	public By commentsKoos = By.xpath("//android.widget.ImageView[@content-desc='COMMENT_KOOS']");
	public By mentionsKoos = By.xpath("//android.widget.ImageView[@content-desc='MENTIONS']");
	public By kooFabPlus = By.id("com.koo.app:id/circular_fab_plus");
	public By list_heartButton = By.id("com.koo.app:id/favourite_button");
	public By txt_explanatory = By.xpath("//*[@resource-id='com.koo.app:id/favourite_Accounts_Info_ComposeView']/android.view.View/android.view.View/android.widget.TextView[2]");
		
	
	public String img_profilePic_Name = "";
	public String txt_profileName_Name = "";
	public String btn_selfVerifyTag_Name = "";
	public String btn_backInProfileScreen_Name = "";
	public String btn_threeDots_Name = "";
	public String btn_addImages_Name = "";
	public String btn_backInAddphotos_Name = "";
	public String btn_editProfilePic_Name = "";
	public String txt_noOfProfilePhotos_Name = "";
	public String txt_profession_Name = "";
	public String txt_bio_Name = "";
	public String btn_more_Name = "";
	public String btn_backInProfilePicturesScreen_Name = "";
	public String txt_profileNameinMorePopup_Name = "";
	public String btn_editinMorePopup_Name = "";
	public String txt_professioninMorePopup_Name = "";
	public String txt_bioinMorePopup_Name = "";
	public String txt_dateOfJoininMorePopup_Name = "";
	public String txt_socialMedialinksHeadinginMorePopup_Name = "";
	public String btn_closeinMorePopup_Name = "";
	public String tab_people_Name = "";
	public String btn_arrowInPeopleTab_Name = "";
	public String btn_arrowForSpecificSectionUnderPeopleTa_Name = "";
	public String btn_publicProfile_Name = "";
	public String btn_followInPublicProfile_Name = "";
	public String btn_follow1InPublicProfile_Name = "";
	public String btn_ShareInPublicProfile_Name = "";
	public String btn_followingInPublicProfile_Name = "";
	public String btn_directMsgInPublicProfile_Name = "";
	public String btn_blockMsgInPublicProfile_Name = "";
	public String btn_reportUserInPublicProfile_Name = "Report user link";
	public String btn_closeInPublicProfile_Name = "";
	public String txt_pplYouCanFollow_Name = "";
	public String txt_noOfKoos_Name = "";
	public String txt_noOfKoos1_Name = "";
	public String txt_noOfLikes_Name = "";
	public String txt_noOfComments_Name = "";
	public String txt_noOfReKoos_Name = "";
	public String txt_noOfMentions_Name = "";
	public String txt_noOfSaved_Name = "";
	public String btn_addforimage_Name = "";
	public String btn_editAadhar_Name = "";
	public String txt_errorMsg_Name = "";
	public String btn_getOTP_Name = "";
	public String txt_profileHeader_Name = "";
	public String txt_msgPosted_Name = "";
	public String btn_bengaliLang_Name = "";
	public String btn_expandThreadKoo_Name = "";
	public String txt_likedProfileHeader_Name = "";
	public String btn_threadkooCommentbox_Name = "";
	public String btn_commentinThreadKoo_Name = "";
	public String txt_comments_Name = "";
	public String btn_showThisThreadInCommentsTab_Name = "";
	public String txt_rekoowithComments_Name = "";
	public String btn_saved_Name = "";
	public String txt_kooSavedTime_Name = "";
	public String btn_followers_Name = "";
	public String txt_followersheading_Name = "";
	public String btn_following_Name = "";
	public String txt_followingheading_Name = "";
	public String txt_all_Name = "";
	public String txt_latest_Name = "";
	public String btn_follow_Name = "";
	public String btn_pinToProfile_Name = "";
	public String btn_yes_Name = "";
	public String txt_pinnedKoo_Name = "";
	public String skipAndContinue_Name = "";
	public String createFirstKoo_Name = "";
	public String likesKoos_Name = "";
	public String noKoos_Name = "";
	public String commentsKoos_Name = "";
	public String mentionsKoos_Name = "";
	public String txt_explanatory_name = "Favorite accounts";
	
			
}
