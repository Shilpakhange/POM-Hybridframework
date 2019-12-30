package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;

public class LoginPage extends TestBase{

	//pageFactory or Object repository
	@FindBy(name="username") WebElement emailaddress;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//input[@type='submit']")WebElement loginbutton;
	@FindBy(linkText="Sign Up")WebElement signuplink;
	
	
	//initializing OR:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions or methods:
		public String validatelogintitle() {
		return driver.getTitle();
	}
	
	public boolean validatesignuplink() {
		return signuplink.isDisplayed();
	}
	
	public HomePage validateloginfunctionality(String email,String pwd) throws InterruptedException
	{
		
				
		emailaddress.sendKeys(email);
		password.sendKeys(pwd);
		//loginbutton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbutton);
		Thread.sleep(3000);
		
		
		return new HomePage();
		
	}
}
