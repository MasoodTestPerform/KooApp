package com.koo.tests.loginlogout;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.koo.framework.BaseTest;
import com.koo.setup.TestConfig;
import com.koo.utils.CommonUtils;
import com.koo.utils.DataLoaders;

public class KooLoginLogout {
	public class DemoTests extends BaseTest{
		
		@Test(description = "OPD Registration done Successfully")
		public void TestCase_Demo_1() {
			try {
				//Setting up test data
				DataLoaders data = BaseTest.utilObj.get().getDataLoaders();
				LinkedHashMap<String, LinkedHashMap<String, String>> allData = allTestData.get();
				String mobileNumber = "52"+CommonUtils.generateNumericNumber(8);
				
				String expectedTxt= null;
				String actualTxt = null;
				
				//Saving dynamically created test data into excel
				data.setTestData(TestConfig.getInstance().getTestSuiteName(), "TestCase_Demo_1", "mobileNumberTxt", mobileNumber);
								
				BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution started for Test:Successfully OPD REgistration in MAXHIS ------><b>", false, BaseTest.mobileDriver.get());
				
				
				BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b><----Test case execution completed for Test:Successfully executed - OPD Registration in MAXHIS ------><b>", true, BaseTest.mobileDriver.get());
				BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			}catch(Exception e) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in doing OPD Registration. Exception:"+e.getMessage(), true, BaseTest.mobileDriver.get());
				BaseTest.afterMethodDriver.set(BaseTest.mobileDriver.get());
			}
		}
	}
		

}
