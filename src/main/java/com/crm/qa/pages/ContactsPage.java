package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testBase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//small[contains(text(),'(click to expand)')]")
	WebElement Expandbtn;
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsbtn;
	@FindBy(id = "first_name")
	WebElement fname;
	@FindBy(id = "surname")
	WebElement lname;
	@FindBy(name = "client_lookup")
	WebElement company;


//	@FindBy(xpath = "//form[@id='contactForm']/table/tbody/tr/td/input[2]")
//	WebElement savebtn;
	
	@FindBy(xpath = "//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='contactForm']/table/tbody/tr/td/input[2]")
	WebElement savebtn;
	
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectContact(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]/parent::td"
				+ "//preceding-sibling::td/input[@name='contact_id']")).click();
	}

	public boolean verifyExpandbtn() {
		return Expandbtn.isDisplayed();
	}

	public boolean verifyContactsbtn() {
		return contactsbtn.isDisplayed();
	}

//	public void clickOnNewContact() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newcontact.click();
//
//	}

	public void validateNewContact(String title,String ftname,String ltname,String comp) {
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		fname.sendKeys(ftname);
		lname.sendKeys(ltname);
		company.sendKeys(comp);
		savebtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
