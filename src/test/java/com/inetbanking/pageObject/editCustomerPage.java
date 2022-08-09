package com.inetbanking.pageObject;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.model.ScreenCapture;
import com.inetbanking.testCases.BaseClass;

public class editCustomerPage extends BaseClass {

	@FindBy(name="cusid")
	WebElement customertxtid;
	
	@FindBy(name="AccSubmit")
	WebElement submit;
	
	@FindBy(name="sub")
	WebElement editformsub;
	
	@FindBy(name="res")
	WebElement resetbtn;
	
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
	
	@FindBy(linkText="Edit Customer")
	WebElement editlinktxt;
	
	@FindBy(linkText="Home")
	WebElement hometxt;


public void editCustomer(String address,String city,String state,String pin,String number,String email,String password) throws InterruptedException, IOException{
	editlinktxt.click();
	//addCustomerPage addcus = new addCustomerPage();
	//System.out.println("edit"+addcus.Customerid);
	customertxtid.sendKeys("92474");
	submit.click();
	
	
	Thread.sleep(1000);
	resetbtn.click();
	Thread.sleep(1000);
	adres.sendKeys(address);
	
	
	ccity.sendKeys(city);
	stat.sendKeys(state);
	pinno.sendKeys(String.valueOf(pin));
	mobnumber.sendKeys(number);
	emailid.sendKeys(email);
	editformsub.click();
	Thread.sleep(3000);
	
//	Alert alt = driver.switchTo().alert();
//	String errmsg = alt.getText();
//	System.out.println(errmsg);
//	if(errmsg.equals("No Changes made to Customer records")){
//		captureScreen(driver,"editCustomerPage");
//		alt.dismiss();
//	}
	
	
	
	//Thread.sleep(1000);
	//hometxt.click();
	
	
	
	
	
	
	//resetbtn.click();
}
}
