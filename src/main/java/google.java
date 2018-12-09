import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class google {

	WebDriver driver;
	@BeforeTest
	public void start()
	{
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	@Test
	public  void google() {
		// TODO Auto-generated method stub


		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("muthu");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).clear();

		
	}
	
	   
	   @AfterTest
	   public void quit()
	   {
		   driver.quit();
	   }
	   
}
