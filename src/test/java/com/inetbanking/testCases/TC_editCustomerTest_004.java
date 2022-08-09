package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.editCustomerPage;
import com.inetbanking.pageObject.loginPage;

import junit.framework.Assert;

public class TC_editCustomerTest_004 extends BaseClass{
	@Test
	public void editCustomer() throws InterruptedException, IOException{
		logger.info("edit class calling");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.login(username,password);
		Thread.sleep(3000);
		
		editCustomerPage editcus = PageFactory.initElements(driver, editCustomerPage.class);
		editcus.editCustomer("CSA", "guntur" , "AP" , "522508", "6367965530", randomString()+"@gmail.com", "Saurav@12345");
		if(isAlertPresent() == true){
			 
			 driver.switchTo().alert().accept();
			 captureScreen(driver,"editCustomerPage");
			 driver.switchTo().defaultContent();
			 
			 logger.warn("edit customer Failed");
		 }
			else{
				
				logger.info("edit customer successfully ");
				lp.logOut();
				//Thread.sleep(2000);
				driver.switchTo().alert().accept(); //logout alert
				driver.switchTo().defaultContent();
			 }
		
	}
	
}
