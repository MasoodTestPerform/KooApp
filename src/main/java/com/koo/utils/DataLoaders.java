package com.koo.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.koo.framework.BaseTest;
import com.koo.framework.LogMe;
import com.koo.setup.TestConfig;

public class DataLoaders {
	private LogMe LOGGER = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	
	public void setupTestObj() {
		if(TestConfig.getInstance().getWebmobileFlag().equals("mobile")) {
			this.driver = BaseTest.mobileDriver.get();
		}else {
			this.driver = BaseTest.driver.get();
		}
		
		this.LOGGER = BaseTest.LOGGER.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
	}

	public static LinkedHashMap<String, LinkedHashMap<String, String>> getAllTestData(String filePath, String sheetName) {
		LinkedHashMap<String, LinkedHashMap<String, String>> allData = null;
		try {
			sheetName = TestConfig.getInstance().getTestSuiteName();
			List<String> tcRowData = new ArrayList<String>();
			List<String> dataRowData = new ArrayList<String>();
			LinkedHashMap<String, String> tempData = null;
			allData =  new LinkedHashMap<String, LinkedHashMap<String, String>>();
			ExcelObject excelObj = new ExcelObject(filePath, sheetName);
			int rowCnt = excelObj.getTotalRowCnt(sheetName);
			int usedColCntOfRow = 0;
			String cellVal = null;
			String tcName = null;
			
			for(int i=1; i<rowCnt; i++) {
				usedColCntOfRow = excelObj.getUsedRowCntInARow(sheetName, i);
				for(int j =0; j<usedColCntOfRow; j++) {
					if(i%2 == 1) {
						cellVal = (String) excelObj.getCellValue(i, j);
						tcRowData.add(j, cellVal);
					}else {
						cellVal = (String) excelObj.getCellValue(i, j);
						dataRowData.add(j, cellVal);
					}
				}
				if(i%2 == 0) {
					tempData = new LinkedHashMap<String, String>();
					tcName = tcRowData.get(0);
					
					for(int k=1; k<dataRowData.size(); k++) {
						tempData.put(tcRowData.get(k), dataRowData.get(k));
					}
					tcRowData.clear();
					dataRowData.clear();
					allData.put(tcName, tempData);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return allData;
	}
	
	public String getTestData(ThreadLocal<LinkedHashMap<String, LinkedHashMap<String, String>>> allTestData, String objName, String...testName) {
		String returnVal = null;
		try {
			String tcName = null;
			if(testName.length==0) {
				tcName = BaseTest.LOGGER.get().test_name;
			}else {
				tcName = testName[0];
			}
			if(allTestData.get().containsKey(tcName)) {
				if(allTestData.get().get(tcName).containsKey(objName)) {
					returnVal = allTestData.get().get(tcName).get(objName);
				}
			}
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failing the test as not able to return data for field:"+objName+".Exception:"+e.getMessage(), false, this.driver, true);
		}		
		return returnVal;
	}
	
	public synchronized void setTestData(String sheetName, String testCaseNo, String colName, String setValue) throws IOException {
		ExcelObject excelObj = new ExcelObject(TestConfig.getInstance().getProjDir()+"/src/main/resources/Test_Data/"+TestConfig.getInstance().getModuleName()+"/TestData.xlsx", sheetName);
		LinkedHashMap<String, Integer> RowDetails = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> ColDetails = new LinkedHashMap<String, Integer>();
		int rowCnt = excelObj.getTotalRowCnt(sheetName);
		int usedColCntOfRow = 0;
		String cellVal = null;
		
		for(int i=1; i< rowCnt; i++) {
			cellVal = (String) excelObj.getCellValue(i, 0);
			RowDetails.put(cellVal, i);
		}
		
		int tcNo = RowDetails.get(testCaseNo);
		usedColCntOfRow = excelObj.getUsedRowCntInARow(sheetName, tcNo);
		
		for(int j=0; j<usedColCntOfRow; j++) {
			cellVal = (String) excelObj.getCellValue(tcNo, j);
			ColDetails.put(cellVal, j);
		}
		
		int colNo = ColDetails.get(colName);
		excelObj.setCellValue(sheetName, (tcNo+1), colNo, setValue);
		
		BaseTest.allTestData.get().get(testCaseNo).put(colName, setValue);
		
		
	}

}
