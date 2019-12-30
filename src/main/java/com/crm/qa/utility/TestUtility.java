package com.crm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.beust.jcommander.converters.FileConverter;
import com.crm.qa.testBase.TestBase;

public class TestUtility extends TestBase {

	public static long pageloadTime = 60;
	public static long implicitTime = 60;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Shilpa Khandge\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";

	
	//static XSSFWorkbook book;
	static Workbook book;
	static Sheet sheet;

	public void swithToframe() {

		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			//book = new XSSFWorkbook(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book=WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()-1];
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum()-1; j++) {
				data[i][j] = sheet.getRow(1 + i).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentdir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
