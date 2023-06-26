package com.koo.android.utils;

import org.testng.annotations.DataProvider;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.koo.framework.BaseTest;

import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageDataProvider {
	private static ThreadLocal<String> languageInThread = new ThreadLocal<>();
    private static ThreadLocal<LanguageDataSet> currentLanguageData = new ThreadLocal<>();

    public static synchronized void setCurrentLanguage(String language) {
        languageInThread.set(language);
    }

    public static synchronized String getCurrentLanguage() {
        return languageInThread.get();
    }

    public static synchronized String getLanguageDataValue(String key) {
        if (currentLanguageData.get() == null) {
            setUpDataSetForCurrentLanguage();
        } else if (!getCurrentLanguage().equalsIgnoreCase(currentLanguageData.get().getLanguage())) {
            currentLanguageData.set(null);
            setUpDataSetForCurrentLanguage();
        }

        return currentLanguageData.get().getData().get(key);
    }

    private static void setUpDataSetForCurrentLanguage() {
        try {
            Map<String, String> currentLanguageData = getCurrentLanguageData();
            LanguageDataSet languageDataSet = new LanguageDataSet();
            languageDataSet.setLanguage(getCurrentLanguage());
            languageDataSet.setData(currentLanguageData);
            LanguageDataProvider.currentLanguageData.set(languageDataSet);
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized Map<String, String> getCurrentLanguageData() throws FilloException {
        Map<String, String> languageData = new HashMap<>();
        String currentLanguage = languageInThread.get();
        if(currentLanguage.equalsIgnoreCase("english")) {
        	languageData = BaseTest.EnglishLanguageData;
        }else {
        	Recordset sheetData = ExcelDataReader.getSheetData(languageInThread.get());
            while (sheetData.next()) {
                languageData.put(sheetData.getField("Key"), sheetData.getField("Value"));
            }
            sheetData.close();
        }
        
        return languageData;
    }


    @DataProvider(name = "Languages", parallel = false)
    public Object[][] languageData() throws FilloException {

        List<Language> lstLanguages = ExcelDataReader.getLanguages();
        Object[][] objLanguages = new Object[lstLanguages.size()][1];

        for (int i = 0; i < lstLanguages.size(); i++) {
            objLanguages[i][0] = lstLanguages.get(i).getLanguage();
        }

        return objLanguages;
    }


    @Data
    public static class LanguageDataSet {
        String language;
        Map<String, String> data = new HashMap<>();
    }

}
