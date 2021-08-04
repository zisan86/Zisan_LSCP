package com.lscp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lscp.qa.base.BaseTest;

public class Home_Page extends BaseTest{
	
	@FindBy(xpath="//a[contains(text(),'Admin')]")
	WebElement adminLinks;
	
	@FindBy(xpath="//a[contains(text(),'Library')]")
	WebElement libraryLinks;
	
	@FindBy(xpath="//a[contains(text(),'Search')]")
	WebElement searchLinks;
	
	//initializing the page objects:
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyhomePageTitle() {
		return driver.getTitle();
	}
	
	public Admin_Page adminClick() throws InterruptedException {
		
		
		adminLinks.click();
		Thread.sleep(10000);
		return new Admin_Page();
	}
	
	public Search_Page searchClick() throws InterruptedException {
		searchLinks.click();
		Thread.sleep(10000);
		
		return new Search_Page();
	}
	
	public Library_Page libraryClick() {
		libraryLinks.click();
		return new Library_Page();
	}


}
