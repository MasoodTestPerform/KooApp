package com.koo.registrationAndLoginFlowTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.framework.android.screens.registerationAndLoginFlowPages.*;

import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.framework.listeners.*;

//@Listeners({SuiteEvent.class, MobileEvent.class})
public class LoginKooTest extends BaseTest {
    @Test(description = "[TC_006] - Verify user is able to login with phone number",
            groups = {"regression", "registration_and_login"})
    public void TC_006_verifyUserLoginWithOTP() throws Exception {
        
    	try{
    		BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test: TC_006 - Verify user is able to login with phone number ------><b>", false, BaseTest.mobileDriver.get());
			
    		LoginKooPage loginKooPage = new LoginKooPage();
    	    loginKooPage.loginValidUser("English",TestConfig.getInstance().getUserName());
    	    BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - TC_006 - Verify user is able to login with phone number ------><b>", true, BaseTest.mobileDriver.get());
    	    BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
    	    BaseTest.sAssert.get().assertAll();
    	}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in verifyUserLoginWithOTP. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
			BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			BaseTest.sAssert.get().assertAll();
		}
    }
}
