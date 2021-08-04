package com.lscp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lscp.qa.base.BaseTest;

public class Search_Page extends BaseTest{
	@FindBy(xpath="//a[contains(text(),'Search')]")
	WebElement searchpage;
	
	@FindBy(xpath="//h2[contains(text(),'Search')]")
	WebElement searchIcon;
	
	public Search_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySearchIcon() {
		return searchIcon.isDisplayed();
		
	}
	
	

}
