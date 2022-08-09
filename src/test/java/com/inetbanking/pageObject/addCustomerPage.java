package com.inetbanking.pageObject;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.inetbanking.testCases.BaseClass;

public class addCustomerPage extends BaseClass {

	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcuslink;
	
	@FindBy(name="name")
	WebElement cusname;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement month;
	
	@FindBy(name="dob")
	WebElement day;
	
	@FindBy(name="dob")
	WebElement year;
	
	@FindBy(name="addr")
	WebElement adres;
	
	@FindBy(name="city")
	WebElement ccity;
	
	@FindBy(name="state")
	WebElement stat;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement mobnumber;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(id="customer")
	WebElement Custable;
	
	List<WebElement> rows,col;
	public String Customerid;
	
	public void addCustomer(String name,String mm,String dd,String yy,String address,String city,String state,String pin,String number,String email,String password) throws InterruptedException, IOException{
		newcuslink.click();
		cusname.sendKeys(name);
		gender.click();
		Thread.sleep(2000);
		month.sendKeys((mm));
		day.sendKeys((dd));
		year.sendKeys((yy));
		Thread.sleep(2000);
		adres.sendKeys(address);
		ccity.sendKeys(city);
		stat.sendKeys(state);
		pinno.sendKeys(String.valueOf(pin));
		mobnumber.sendKeys(number);
		emailid.sendKeys(email);
		pwd.sendKeys(password);
		submit.click();
		Thread.sleep(3000);
		logger.info("addCustomerPage--validation Started");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true){
			Assert.assertTrue(true);
			logger.info("addCustomerPage- customer generated successfully");
			rows = Custable.findElements(By.tagName("tr"));
			col = rows.get(3).findElements(By.tagName("td"));
			Customerid = col.get(1).getText();
			
			System.out.println("xcdxz"+Customerid);
			
		}
		else{
			captureScreen(driver, "addCustomerPage");
			Assert.assertTrue(false);
			Alert alt = driver.switchTo().alert();
			alt.dismiss();
			
			logger.info("addCustomerPage- customer not generated");
		}
		
		
	
	}
}
