package com.framework.android.allpages;

import org.openqa.selenium.By;

public class TopicsPage {
	
	public String homePageTab = "(//android.widget.TextView[@text='###'])";
	public By homePageAllTabs = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/custom_tab_text'])");
	public By btn_followedtopicHeading = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/topic_title'])[1]");
	public By txt_followedtopicHeading = By.xpath("//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview']");
	public By txt_addTopicsToYourFeed = By.id("com.koo.app:id/header_text");
	public By btn_PlustoFollow = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/iv_follow_icon'])[1]");
	public By btn_popupforTopicFollow = By.id("com.koo.app:id/pillMainLayout");
	public By txt_followedkoocontent = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/topic_num_koos'])[1]");
	public String btn_topicsTab = "//android.widget.TextView[@text='###']";
	public By btn_GreaterThanIconintopics = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/ivDetail'])[1]");
	public By txt_followedtopicHeadinginTopic = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/item_title'])[1]");
	public By txt_afterfollowedtopicHeadinginTopic = By.xpath("(//android.widget.TextView[@resource-id='com.koo.app:id/toolbar_heading_textview'])");
	public By btn_PLUSintopics = By.xpath("(//android.widget.ImageView[@resource-id='com.koo.app:id/iv_follow_icon'])[10]");
	
	public By btn_topicWithViewMore = By.xpath("//android.widget.TextView[contains(@text,'View more')]");//need to be reviewed with Chaitanya
	public By txt_topic = By.id("com.koo.app:id/toolbar_heading_textview");
	public By txt_topicsYouFollow = By.xpath("//android.widget.TextView[@text='Topics You Follow']");
	public By txt_top = By.xpath("//android.widget.TextView[@text='Top']");
	public By txt_categories = By.xpath("//android.widget.TextView[@text='Categories']");
	public By txt_people = By.xpath("(//android.widget.TextView[@text='People'])[2]");
	public By txt_newTopicsToExplore = By.xpath("//android.widget.TextView[@text='New Topics To Explore']");
	public By txt_organisations = By.xpath("//android.widget.TextView[@text='Organisations']");
	public By txt_places = By.xpath("//android.widget.TextView[@text='Places']");
	public By txt_trending = By.xpath("//android.widget.TextView[@text='Trending']");
	public By btn_followedTopic = By.xpath("(//android.view.ViewGroup[1]/android.widget.TextView)[1]");
	public By AfterPosting = By.xpath("//android.view.View[@content-desc='add_language']");
	public By text_comments = By.xpath("//android.view.View[@content-desc='koo_create_textField']");
	public By chkbox_english = By.xpath("//android.widget.CheckBox[@content-desc='English_checkBox']");
	public By chkbox_telugu = By.xpath("//android.widget.CheckBox[@content-desc='Telugu_checkBox']");
	public By chkbox_hindi = By.xpath("//android.widget.CheckBox[@content-desc='Hindi_checkBox']");
	public By chkbox_kannada = By.xpath("//android.widget.CheckBox[@content-desc='Kannada_checkBox']");
	public By chkbox_tamil = By.xpath("//android.widget.CheckBox[@content-desc='Tamil_checkBox']");
	public By chkbox_marathi = By.xpath("//android.widget.CheckBox[@content-desc='Marathi_checkBox']");
	public By chkbox_bengali = By.xpath("//android.widget.CheckBox[@content-desc='Bengali_checkBox']");
	public By chkbox_assamese = By.xpath("//android.widget.CheckBox[@content-desc='Assamese_checkBox']");
	public By chkbox_gujarati = By.xpath("//android.widget.CheckBox[@content-desc='Gujarati_checkBox']");
	public By chkbox_punjabi = By.xpath("//android.widget.CheckBox[@content-desc='Punjabi_checkBox']");
	public By btn_languageDone = By.xpath("//android.view.View[@content-desc='language_done']");
	
	
	public String homePageTab_Name = "";
	public String homePageAllTabs_Name = "";
	public String btn_followedtopicHeading_Name = "topic heading which we followed";
	public String txt_followedtopicHeading_Name = "topic heading which we followed";
	public String txt_addTopicsToYourFeed_Name = "";
	public String btn_PlustoFollow_Name = "+ button to follow";
	public String btn_popupforTopicFollow_Name = "mail layout";
	public String txt_followedkoocontent_Name = "followed koo content";
	public String btn_topicsTab_Name = "Topics tab";
	public String btn_GreaterThanIconintopics_Name = "> button in topics page";
	public String txt_followedtopicHeadinginTopic_Name = "topic heading which we followed";
	public String txt_afterfollowedtopicHeadinginTopic_Name = "topic heading which we followed";
	public String btn_PLUSintopics_Name = "+ button to follow";
	public String btn_topicWithViewMore_Name = "";
	public String txt_topic_Name = "";
	public String txt_topicsYouFollow_Name = "";
	public String txt_top_Name = "";
	public String txt_categories_Name = "";
	public String txt_people_Name = "";
	public String txt_newTopicsToExplore_Name = "";
	public String txt_organisations_Name = "";
	public String txt_places_Name = "";
	public String txt_trending_Name = "";
	public String btn_followedTopic_Name = "";
	public String AfterPosting_Name = "";
	public String text_comments_Name = "";
	public String chkbox_english_Name = "";
	public String chkbox_telugu_Name = "";
	public String chkbox_hindi_Name = "";
	public String chkbox_kannada_Name = "";
	public String chkbox_tamil_Name = "";
	public String chkbox_marathi_Name = "";
	public String chkbox_bengali_Name = "";
	public String chkbox_assamese_Name = "";
	public String chkbox_gujarati_Name = "";
	public String chkbox_punjabi_Name = "";
	public String btn_languageDone_Name = "";
	
}
