package com.inetbanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.inetbanking.testCases.BaseClass;

public class loginPage {
	
	//define elements
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement btn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;

	//define functions
	public void login(String username,String password){
		userid.sendKeys(username);
		pwd.sendKeys(password);
		btn.click();
	}
	
	public void logOut(){
		logout.click();
		
	}
}
