package com.lscp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lscp.qa.base.BaseTest;
import com.lscp.qa.pages.Home_Page;
import com.lscp.qa.pages.Login_Page;

public class LoginPageTest extends BaseTest{
	
	Login_Page loginpage;
	Home_Page homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "DXC Life Sciences Connected Platform");
		
	
	}
	
	@Test(priority=2)
	
	public void DXClogoimgTest() {
		boolean b = loginpage.validateDxcImg();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
