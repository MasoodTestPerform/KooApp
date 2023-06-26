package com.koo.android.utils;

import org.openqa.selenium.By;
import com.koo.framework.BaseTest;

public class TextView {
	private By by;
    private String text;

    public TextView(String text, int index) {
        this.text = text;
        by = By.xpath(String.format("(//android.widget.TextView[@text='%s'])[%d]", text,index));
    }

    public By getBy() {
        return this.by;
    }

    public void Click(){
    		BaseTest.utilObj.get().getMobileActions().click(by, String.format("Click on Text view '%s'", text));    	
    }

    public void getText(){
        BaseTest.utilObj.get().getMobileActions().getText(by, String.format("Get %s's Text", text), true);        
    }

    public boolean isDisplayed(){
    	boolean flag = false;
    	flag = BaseTest.utilObj.get().getMobileActions().isDisplayed(by, String.format("Verify visibility of %s Text", text));
    	
    	return flag;
    }

    public static TextView get(String text, int index){
        return new TextView(text, index);
    }
}
