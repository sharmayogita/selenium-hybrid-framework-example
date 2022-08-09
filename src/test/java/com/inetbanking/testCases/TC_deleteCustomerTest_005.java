package com.inetbanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.deleteCustomerPage;
import com.inetbanking.pageObject.loginPage;

public class TC_deleteCustomerTest_005 extends BaseClass {

	@Test
	public void deleteCustomerTest() throws InterruptedException{
		
		logger.info("delete testcase class calling");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.login(username,password);
		Thread.sleep(3000);
		
		deleteCustomerPage dlcus = PageFactory.initElements(driver, deleteCustomerPage.class);
		dlcus.deleteCustomer();
		Thread.sleep(1000);
		if(isAlertPresent()==true){
			Alert alt = driver.switchTo().alert();
			String altmsg = alt.getText();
			if(altmsg.equals("Do you really want to delete this")){
				alt.accept();
				driver.switchTo().defaultContent();
		}
//			else if(alt.getText().equals("You are not authorize to delete this customer!!")){
//				driver.switchTo().alert().accept();
//				driver.switchTo().defaultContent();
//			}
//			else {
//				
//			}
			
		}
	}
}
