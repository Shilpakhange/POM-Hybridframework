package com.crm.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.TestUtility;
import com.crm.qa.utility.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {

			prop = new Properties();
			FileInputStream fp = new FileInputStream(
					"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\conf.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		String urlnm = prop.getProperty("url");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Shilpa Khandge\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.pageloadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.implicitTime, TimeUnit.SECONDS);
		driver.get(urlnm);
	}

}
