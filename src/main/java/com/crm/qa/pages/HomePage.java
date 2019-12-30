package com.crm.qa.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: shilpa khandge')]")
	WebElement userdisplay;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//form//td[3]//div[1]//input[1]")
	WebElement searchbtn;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateUserDisplay() {
		try {
			boolean b=userdisplay.isDisplayed();
			return b;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateSearchbutton() {
		return searchbtn.isDisplayed();
	}

	public ContactsPage validateContactslink() throws InterruptedException {
		contactsLink.click();
		//Thread.sleep(2000);
		return new ContactsPage();
	}

	public DealsPage validateDealslink() throws InterruptedException {

		dealsLink.click();
		Thread.sleep(2000);
		return new DealsPage();
	}
	
	public void clickOnNewContact() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontact.click();
		
	}

}

