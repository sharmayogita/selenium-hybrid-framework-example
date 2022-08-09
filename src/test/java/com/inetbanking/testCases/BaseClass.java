package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig rc  = new ReadConfig();
	public String base_url = rc.getApplicationURL();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readConfig  = new ReadConfig();
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br){
	
	logger = Logger.getLogger("inetbanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("chrome"))
	{
		logger.info("chrome browser is opening");
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		driver = new ChromeDriver();
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
		driver = new FirefoxDriver();
	}
	else if(br.equals("ie")){
		System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
		driver = new InternetExplorerDriver();
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(base_url);
	}
	
	@AfterClass
	public void closesetup(){
		driver.quit();
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomString(){
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	public String randomNumeric(){
		String generatedNumeric = RandomStringUtils.randomNumeric(5);
		return generatedNumeric;
	}
	
}
