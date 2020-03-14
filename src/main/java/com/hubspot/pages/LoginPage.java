package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Non-page factory---> concept we use 90% for locators
	//locators
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
    
	//constructor	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	
	}
	
	//page actions:
	public String getLoginPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
		//return driver.getTitle();
		
	}
	
	public HomePage doLogin(String username, String pwd){
		
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
        elementUtil.doClick(loginBtn);
		
//	     driver.findElement(emailId).sendKeys(username);	
//		 driver.findElement(password).sendKeys(pwd);
//		 driver.findElement(loginBtn).click();
		
		 return new HomePage(driver);
	}	
			
}
	