package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;

public class TestLoginpage extends TestBase {

	
	LoginPage loginpage;
	HomePage homepage;
	public TestLoginpage() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
	}
	
	
	@Test(priority=3)
	public void loginpagetitleTest()
	{
		String title=loginpage.validatelogintitle();
		assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void validatesignuplinkTest() {
		boolean flag=loginpage.validatesignuplink();
		assertEquals(flag, true);
	}
	
	@Test(priority=1)
	public void validateloginfunctionalityTest() throws InterruptedException {
		String uname=prop.getProperty("username");
		String password=prop.getProperty("password");
		homepage=loginpage.validateloginfunctionality(uname,password);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
