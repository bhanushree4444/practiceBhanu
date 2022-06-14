package com.SDET34.GenricUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
   int count=0;
   int maxRetry=1;
	@Override
	public boolean retry(ITestResult result) {
		while(count<maxRetry) {
			count++;
			return true;
		}
		
		return false;
		
	}
	

}
