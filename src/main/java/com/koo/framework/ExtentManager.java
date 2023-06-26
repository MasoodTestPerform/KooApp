package com.koo.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

	private ExtentManager() {
	}

	public static synchronized ExtentReports getInstance() {
		return extent;
	}
	public static synchronized void createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		String s[] = fileName.split("/");
		htmlReporter.config().setDocumentTitle("KOO Automation Report - " + s[s.length - 1]);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(s[s.length - 1]);		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
}
