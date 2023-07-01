package com.koo.setup;

import com.koo.android.utils.MobileActions;
import com.koo.framework.AssertManager;
import com.koo.framework.BaseTest;
import com.koo.utils.DBUtils;
import com.koo.utils.DataLoaders;
import com.koo.utils.UIUtils;

public class InitUtilObjects {
	private UIUtils uiutil;
	private AssertManager assertManager;
	private DBUtils dbUtil;
	private DataLoaders data ;
	private MobileActions mobileActions;
	
	public InitUtilObjects() {
		uiutil = new UIUtils();
		assertManager = new AssertManager();
		dbUtil = new DBUtils();
		data = new DataLoaders();
		mobileActions = new MobileActions();
	}
	
	public void setupTestObj() {
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			BaseTest.utilObj.get().getMobileActions().setupTestObj();
		}else {
			BaseTest.utilObj.get().uiutil.setupTestObj();
		}
		BaseTest.utilObj.get().assertManager.setupTestObj();
		BaseTest.utilObj.get().data.setupTestObj();
		
	}
	
	public MobileActions getMobileActions() {
		return mobileActions;
	}
	
	public UIUtils getUIUtils() {
		return uiutil;
	}
	
	public DataLoaders getDataLoaders() {
		return data;
	}
	
	public AssertManager getAssertManager() {
		return assertManager;
	}
	
	public DBUtils getDBUtils() {
		return dbUtil;
	}

}
