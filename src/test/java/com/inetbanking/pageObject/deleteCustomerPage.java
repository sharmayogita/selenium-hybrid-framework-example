package com.inetbanking.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.inetbanking.testCases.BaseClass;

public class deleteCustomerPage extends BaseClass{
	@FindBy(name="cusid")
	WebElement deletecusidtxt;
	
	@FindBy(name="res")
	WebElement reserbtn;
	
	@FindBy(name="AccSubmit")
	WebElement deletesubmit;
	
	@FindBy(linkText="Delete Customer")
	WebElement deletecuslink;
	
	public void deleteCustomer(){
		deletecuslink.click();
		deletecusidtxt.sendKeys("92474");
		deletesubmit.click();
	}
	
}
