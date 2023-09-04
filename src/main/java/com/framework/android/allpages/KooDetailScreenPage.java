package com.framework.android.allpages;

import org.openqa.selenium.By;

public class KooDetailScreenPage {
	
	public By kooDetailTitle = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/hashtagTitle']");
	public By writeCommentsBar = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/comment_channel_imageview']//following-sibling::android.widget.TextView");
	public By pollKooIcon = By.xpath("//android.view.View[@content-desc='add_poll']");
	public String profileIDOnSearchResult = "//android.widget.TextView[@text='###']";
	public By pollPercentage = By.xpath("//android.widget.ImageView[@resource-id='com.koo.app:id/iv_selected']/following-sibling::android.widget.TextView[@resource-id='com.koo.app:id/tv_percent']");
	public String pollKooTextField = "(//android.widget.EditText)[###]";
	public By bigFollowButton = By.id("com.koo.app:id/btn_follow_big");
	public String writeYourCommentForSpecificUser = "(//android.widget.TextView[@text='###']//..//..)[1]//following-sibling::android.view.ViewGroup[@resource-id='com.koo.app:id/koo_feed_item_container']//android.widget.TextView[@resource-id='com.koo.app:id/creation_view']\"";
	public By commentTextCount = By.id("com.koo.app:id/comment_textview");
	public By commentTextCountForKoo = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/comment_textview']");
	public String likeReactionBelowCommentSection = "//android.widget.TextView[@text='###']//..//..[@class='android.view.ViewGroup']//following-sibling::android.view.ViewGroup//android.view.ViewGroup[@resource-id='com.koo.app:id/like_holder_constraint']";
	public String commentReactionBelowCommentSection = "//android.widget.TextView[@text='###']//..//..[@class='android.view.ViewGroup']//following-sibling::android.view.ViewGroup//android.view.ViewGroup[@resource-id='com.koo.app:id/comment_holder_constraint']";
	public String rekooReactionBelowCommentSection = "//android.widget.TextView[@text='###']//..//..[@class='android.view.ViewGroup']//following-sibling::android.view.ViewGroup//android.widget.ImageView[@resource-id='com.koo.app:id/rekoo_imageview']";
	public String whatsAppReactionBelowCommentSection = "//android.widget.TextView[@text='###']//..//..[@class='android.view.ViewGroup']//following-sibling::android.view.ViewGroup//android.widget.ImageView[@resource-id='com.koo.app:id/whatsapp_share_iv']";
	public String shareReactionBelowCommentSection = "//android.widget.TextView[@text='###']//..//..[@class='android.view.ViewGroup']//following-sibling::android.view.ViewGroup//android.widget.ImageView[@resource-id='com.koo.app:id/generic_share_iv']";
	public String profileUserName = "(//android.widget.TextView[@text='###'])[1]";
	public By viewMoreLink = By.id("com.koo.app:id/more_tv");
	public By playButtonOnVideo = By.id("com.koo.app:id/play");
	public By languageDoneButton = By.xpath("//android.view.View[@content-desc='language_done']");
	public String postedKooText = "//android.widget.TextView[@text='###']";
	public String postedCommentIcon = "//android.widget.TextView[@text='###']//..//..//android.widget.FrameLayout[@resource-id='com.koo.app:id/layout_interactions_single_feed']//android.widget.ImageView[@resource-id='com.koo.app:id/comment_imageview']";
	public By viewMoreForComments = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/iv_options_more'])[2]");
	public By hideUnHideComment = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/itemhideReply']");
	public By hideCommentEyeIcon = By.xpath("//android.widget.LinearLayout[@resource-id='com.koo.app:id/layout_hidden_comments']");
	public By icon_kooComment = By.id("com.koo.app:id/comment_imageview");
	public By icon_kooCommentSection = By.xpath("//android.view.View/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View");
	public By icon_kooCommentSection1 = By.xpath("//*[@id=\"sourceContainer\"]/div/div[3]/div/div/div/div[19]/span[3]/span/span/b");
	public By txtbox_comments = By.xpath("//android.view.View[@content-desc='koo_create_textField']");
	
	
	public String kooDetailTitle_Name = "";
	public String writeCommentsBar_Name = "Write your comment field";
	public String pollKooIcon_Name = "";
	public String profileIDOnSearchResult_Name = "searched profile by ID from search bar result";
	public String pollPercentage_Name = "";
	public String pollKooTextField_Name = "";
	public String bigFollowButton_Name = "";
	public String writeYourCommentForSpecificUser_Name = "";
	public String commentTextCount_Name = "";
	public String commentTextCountForKoo_Name = "Comments Count";
	public String likeReactionBelowCommentSection_Name = "";
	public String commentReactionBelowCommentSection_Name = "";
	public String rekooReactionBelowCommentSection_Name = "";
	public String whatsAppReactionBelowCommentSection_Name = "";
	public String shareReactionBelowCommentSection_Name = "";
	public String profileUserName_Name = "Profile user name";
	public String viewMoreLink_Name = "";
	public String playButtonOnVideo_Name = "";
	public String languageDoneButton_Name = "Done button";
	public String postedKooText_Name = "";
	public String postedCommentIcon_Name = "";
	public String viewMoreForComments_Name = "";
	public String hideUnHideComment_Name = "";
	public String hideCommentEyeIcon_Name = "";	
	
}
