package com.framework.android.allpages;

import org.openqa.selenium.By;

import com.koo.android.utils.MobileActions;
import com.koo.framework.BaseTest;

public class LogoutAndDeletePage {
	
	MobileActions mobileActions = BaseTest.utilObj.get().getMobileActions();
	
	
	public By existsPopup = By.id("android:id/message");
	public By existsPopupOkButton = By.id("android:id/button1");
	
	public String existsPopup_Name = "PopUp message while adding child account";
	public String existsPopupOkButton_Name ="Ok button of PopUp";
	
	
	public LogoutAndDeletePage verifyPopupAlreadyExistsAccount()
	{
		
		return this;
	}
	

}
