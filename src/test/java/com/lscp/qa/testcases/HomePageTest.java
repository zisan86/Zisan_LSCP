package com.lscp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lscp.qa.base.BaseTest;
import com.lscp.qa.pages.Home_Page;
import com.lscp.qa.pages.Login_Page;

public class HomePageTest extends BaseTest{
	
	Login_Page loginpage;
	Home_Page homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyhomePageTitle();
		Assert.assertEquals(homepageTitle, "DXC Life Sciences Connected Platform", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyAdminLinkTest() throws InterruptedException {
		homepage.adminClick();
		
		System.out.println("clicked successfully");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
