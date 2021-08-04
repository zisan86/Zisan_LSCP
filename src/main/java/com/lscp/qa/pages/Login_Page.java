package com.lscp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lscp.qa.base.BaseTest;

public class Login_Page extends BaseTest{
	
	//Page Factory - OR
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn-login']")
	WebElement login;
	
	@FindBy(xpath="//img[@title='DXC.technology']")
	WebElement logo;
	
	//Initializing the page object
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateDxcImg() {
		return logo.isDisplayed();
	}
	
	public Home_Page login(String un, String Pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(Pwd);
		login.click();
		Thread.sleep(100000);
		
		return new Home_Page();
	}

}
