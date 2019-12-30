package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;
import com.crm.qa.utility.TestUtility;

public class TestHomepage extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TestUtility testutil;
	
	public TestHomepage() {
		super();
	
	}
	
	@BeforeMethod

	public void setUp() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtility();
		homepage=new HomePage();
		contactspage=new ContactsPage();
		dealspage=new DealsPage();
		homepage=loginpage.validateloginfunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateUserDisplayTest()
	{
		testutil.swithToframe();
		//Assert.assertTrue(homepage.validateUserDisplay());
		boolean fl=homepage.validateUserDisplay();
		assertEquals(fl, true);
	}
	
	@Test(priority=2)
	public void validateSearchbuttonTest()
	{
		testutil.swithToframe();
		Assert.assertTrue(homepage.validateSearchbutton(),"searchbutton not present on the page");
	}
	
	@Test(priority=3)
	public void validateContactslinkTest() throws InterruptedException
	{

		testutil.swithToframe();
		contactspage=homepage.validateContactslink();
		
	}
	
	@Test(priority=4)
	public void validateDealslinkTest() throws InterruptedException
	{
		testutil.swithToframe();
		dealspage=homepage.validateDealslink();
	}
	
	@AfterMethod

	public void tearDown()
	{
		driver.quit();
	}
}
