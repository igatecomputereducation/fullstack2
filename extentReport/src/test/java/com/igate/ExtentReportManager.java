package com.igate;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends TestListenerAdapter {

	 ExtentSparkReporter esp; 
	 ExtentReports rpt;
	 @Override
	  public void onStart(ITestContext testContext) {
		esp=new ExtentSparkReporter(".//reports//igate.html");
	    esp.config().setDocumentTitle("opencart report");
	    esp.config().setReportName("opencart Extent Report");
	    esp.config().setTheme(Theme.DARK);
	    rpt=new ExtentReports();
	    rpt.setSystemInfo("Project", "OpenCart");
	    rpt.setSystemInfo("Type", "Regression");
	    rpt.setSystemInfo("QA", "Akhil");
	    rpt.attachReporter(esp);
	    
	  }
	 @Override
	  public void onTestSuccess(ITestResult tr) {
		 ExtentTest tc=rpt.createTest("Login test");
		 tc.log(Status.PASS,"Test Success...");
	  }
	 
	 @Override
	  public void onTestFailure(ITestResult tr) {
		 ExtentTest tc=rpt.createTest("Login test");
		 tc.log(Status.FAIL, "Test Failed");
	  }
	 
	 @Override
	  public void onTestSkipped(ITestResult tr) {
		 ExtentTest tc=rpt.createTest("Login test");
		 tc.log(Status.SKIP, "Skipped");
	  }
	 
	 @Override
	  public void onFinish(ITestContext testContext) {
		 rpt.flush();
	 }
}
