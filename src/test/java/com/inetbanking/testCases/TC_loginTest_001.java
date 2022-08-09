package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.loginPage;

public class TC_loginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException{
		
		logger.info("URL is opened");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		//loginPage lp = new loginPage();
		lp.login(username,password);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
