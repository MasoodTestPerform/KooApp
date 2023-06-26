package com.koo.framework;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.koo.setup.TestConfig;

public class Myretry implements IRetryAnalyzer {
 
  private int retryCount = 0;
  //private static final int maxRetryCount =4;
 
  @Override
  public boolean retry(ITestResult result) {
	  int retryMaxCount = TestConfig.getInstance().getFailureRetryCount();
    if (retryCount < retryMaxCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}
