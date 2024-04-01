package com.igate;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyListener extends TestListenerAdapter {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start.......");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success..........");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure...........");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped.........");
	}
}
