package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.loginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test (dataProvider="LoginData")
	public void loginDDT(String user,String password) throws InterruptedException, IOException{
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		//loginPage lp = new loginPage();
		 lp.login(user, password);
		// Thread.sleep(1000);
		 if(isAlertPresent() == true){
			 driver.switchTo().alert().accept();
			 captureScreen(driver,"loginDDT");
			 driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
			 logger.warn("Login Failed");
		 }
			else{
				Assert.assertTrue(true);
				logger.info("Login Pass");
				lp.logOut();
				//Thread.sleep(2000);
				driver.switchTo().alert().accept(); //logout alert
				driver.switchTo().defaultContent();
			 }
		 
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
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException, InterruptedException{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++){
			for(int j=0;j<colcount;j++){
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); //1,0
			}
		}
		return loginData;
	}
}
