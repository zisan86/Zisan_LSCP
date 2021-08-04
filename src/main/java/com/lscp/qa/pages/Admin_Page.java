package com.lscp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lscp.qa.base.BaseTest;

public class Admin_Page extends BaseTest{
	
	@FindBy(xpath="//h2[contains(text(),'Admin')]")
	WebElement adminPage;
	
	@FindBy(xpath="//input[@value='Create']")
	WebElement create;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement ftname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement ltname;
	
	
	
	
	
	
	public Admin_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAdminLabel() {
		return adminPage.isDisplayed();
	}
	
	public void selectAdminOptions(String name) throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
		Thread.sleep(3000);
	}
	
	public void selectCreateLink() throws InterruptedException {
		create.click();
		Thread.sleep(10000);
	}
	
	public void createNewUser(String firstname, String lastname, String title) {
		ftname.sendKeys(firstname);
		ltname.sendKeys(lastname);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@name='UserSourceCode']/span/span[1]")));
		select.selectByVisibleText(title);
		
		
	
		
	}

}
