package com.framework.android.screens.topicsPage;
import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.android.allpages.*;

public class TopicsTabPage {
	MobileActions mobileActions = null;
	TopicsPage topicsPage = null;
	
	public TopicsTabPage(){
		this.mobileActions = BaseTest.utilObj.get().getMobileActions();
		topicsPage = new TopicsPage();
	}

    /**
     * This method is to verify topics tab on third or fourth position of home page tabs
     * @param expectedTopicsTab
     * @param index
     * @return
     */
    public TopicsTabPage verifyTopicTabOnThirdOrFourthPosition(String expectedTopicsTab, int index) {
        List<WebElement> allTabs = BaseTest.mobileDriver.get().findElements(topicsPage.homePageAllTabs);
        
        boolean expectedFlag = allTabs.get(index).getText().equalsIgnoreCase(expectedTopicsTab) ||
                allTabs.get(index + 1).getText().equalsIgnoreCase(expectedTopicsTab);
        BaseTest.utilObj.get().getAssertManager().sAssertEquals(expectedFlag,true, "Topics tab is visible on third or fourth position of home page tabs", true, BaseTest.mobileDriver.get(), true);
        
        return this;
    }
}
