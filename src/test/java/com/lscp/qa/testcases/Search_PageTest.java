package com.lscp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lscp.qa.base.BaseTest;
import com.lscp.qa.pages.Home_Page;
import com.lscp.qa.pages.Login_Page;
import com.lscp.qa.pages.Search_Page;

public class Search_PageTest extends BaseTest{
	
	Login_Page loginpage;
	Home_Page homepage;
	Search_Page searchpage;
	
	public Search_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		searchpage = new Search_Page();
		loginpage = new Login_Page();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = homepage.searchClick();
	}
	
	@Test
	public void verifySearchLabel() {
		boolean c = searchpage.verifySearchIcon();
		Assert.assertTrue(c);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
