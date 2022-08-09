package com.inetbanking.utilities;
// Listener class used to generate extent report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	public void onStart(ITestContext textContext ){
		
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Host name", "localhost");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("user", "Yogi");
		extentReport.setSystemInfo("webinfo", "Banking");
		
		htmlReporter.config().setDocumentTitle("INet Banking Test Report"); //Title of the report
		htmlReporter.config().setReportName("Functional Test Report"); //Report name
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onTestSuccess(ITestResult tr){
		extentTest =extentReport.createTest(tr.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr){
		extentTest =extentReport.createTest(tr.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotpath = System.getProperty("user.dir")+"Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotpath);
		if(f.exists()){
			try{
				extentTest.fail("Screenshot is below: "+extentTest.addScreenCaptureFromPath(screenshotpath));
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult tr){
		extentTest =extentReport.createTest(tr.getName());    //create new entry in th report
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context){
		extentReport.flush();
	}
	
}
