package utils;

import java.util.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter esp; 
	 ExtentReports rpt;
	 @Override
	  public void onStart(ITestContext testContext) {
		 System.out.println("hello this is starting of report");
		/*
		 SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm");  
		 String strDate= formatter.format(new Date());  
		 */
		 
		esp=new ExtentSparkReporter(".//reports//opencart.html");
	    esp.config().setDocumentTitle("opencart report");
	    esp.config().setReportName("opencart Extent Report");
	    esp.config().setTheme(Theme.DARK);
	    
	    rpt=new ExtentReports();
	    rpt.setSystemInfo("Project", "OpenCart");
	    rpt.setSystemInfo("Type", "Testing");
	    rpt.setSystemInfo("QA", "Akhil");
	    
	    //to add browser name
	   	String browser = testContext.getCurrentXmlTest().getParameter("browser");
		rpt.setSystemInfo("Browser", browser);
		
		//to add groups on which testing is performing
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		rpt.setSystemInfo("Groups", includedGroups.toString());
		}
	    
	    rpt.attachReporter(esp);
	    
	  }
	 @Override
	  public void onTestSuccess(ITestResult result) {
		 
		 ExtentTest test = rpt.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		 test.log(Status.PASS,result.getName()+" got successfully executed");
		 
	  }
	 
	 @Override
	  public void onTestFailure(ITestResult result) {
		 ExtentTest test = rpt.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL,result.getName()+" got failed");
		 test.log(Status.INFO, result.getThrowable().getMessage());
	  }
	 
	 @Override
	  public void onTestSkipped(ITestResult result) {
		
		 
		 ExtentTest test = rpt.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, result.getName()+" got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
	  }
	 
	 @Override
	  public void onFinish(ITestContext testContext) {
		 rpt.flush();
	 }
	
	
}
