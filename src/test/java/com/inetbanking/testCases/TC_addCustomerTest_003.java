package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.addCustomerPage;
import com.inetbanking.pageObject.loginPage;


public class TC_addCustomerTest_003 extends BaseClass{
	
	@Test
	public void addCustomerTestCase() throws InterruptedException, IOException{
	 loginPage lp = PageFactory.initElements(driver, loginPage.class);
	 lp.login(username,password);
	 Thread.sleep(3000);
	 
	 addCustomerPage addcust = PageFactory.initElements(driver, addCustomerPage.class);
	 addcust.addCustomer("Gaurav", "05","19","1990", "capital square apartment", "Gunture" , "AP" , "522508", "7835941317", randomString()+"@gmail.com", "Saurav@12345");
	 
	}
}
