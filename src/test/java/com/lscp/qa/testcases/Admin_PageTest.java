package com.lscp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lscp.qa.base.BaseTest;
import com.lscp.qa.pages.Admin_Page;
import com.lscp.qa.pages.Home_Page;
import com.lscp.qa.pages.Login_Page;

public class Admin_PageTest extends BaseTest{
	
	Login_Page loginpage;
	Home_Page homepage;
	Admin_Page adminpage;
	
	public Admin_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		adminpage = new Admin_Page();
		loginpage = new Login_Page();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminpage = homepage.adminClick();
	}
	
	@Test(priority=1)
	public void verifyAdminPageLabel() {
		Assert.assertTrue(adminpage.verifyAdminLabel(), "admin label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectProductsoption() throws InterruptedException {
		adminpage.selectAdminOptions("Users");
	}
	
	
	@Test(priority=3)
	public void clickOnCreatelink() throws InterruptedException {
		adminpage.selectCreateLink();
	}
	
	@Test(priority=4)
	public void createNewUser() {
		adminpage.createNewUser("xyz", "abc", "Internal");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
