package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;
import com.crm.qa.utility.TestUtility;

public class TestContactspage extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtility testutil;
	ContactsPage contactspage;
	String sheetname = "Contacts";

	public TestContactspage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		//homepage = new HomePage();
		testutil = new TestUtility();
		contactspage = new ContactsPage();
		homepage = loginpage.validateloginfunctionality(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithToframe();
		contactspage = homepage.validateContactslink();
		//Thread.sleep(1000);
	}

//	@Test(priority=1)
//	public void verifyExpandbtnTest() {
//		boolean b=contactspage.verifyExpandbtn();
//		assertTrue(b, "ExpandButton is not displayed");
//	}
//
//	@Test(priority=2)
//	public void verifyContactsbtnTest() {
//		assertTrue(contactspage.verifyContactsbtn(), "Contacts lable is not displayed");
//	}
//
//	@Test(priority=3)
//	public void selectsingleContactTest() throws InterruptedException {
//		contactspage.selectContact("parth k");
//		Thread.sleep(2000);
//	}
//
//	@Test(priority=4)
//	public void selectmultipleContactTest() throws InterruptedException {
//		contactspage.selectContact("test test1");
//		Thread.sleep(2000);
//		contactspage.selectContact("ashish k");
//		Thread.sleep(2000);
//	}

	
	@DataProvider
	public Object[][] getCrmTestdata() 
	{
		Object data [][]=TestUtility.getTestData(sheetname);
		return data;
	}
	@Test(priority=5, dataProvider="getCrmTestdata")
	public void validateNewContactTest(String title,String fname,String lname,String comp) {
		homepage.clickOnNewContact();
		//contactspage.validateNewContact("Dr.","albert","robin","apple");
		contactspage.validateNewContact(title, fname, lname, comp);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
