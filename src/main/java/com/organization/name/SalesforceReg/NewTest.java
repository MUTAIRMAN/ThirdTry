package com.organization.name.SalesforceReg;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class NewTest {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe" );
	  driver=new ChromeDriver();
	  driver.get("file:///C:/Users/Muthukumar/Desktop/Muthu.html");
	  Reporter.initialize();
	  
	  

	  driver.findElement(By.linkText("Google")).click();
	 
	  
	  WebDriverWait wait =new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hplogo")));
		 
		 
		 
		 driver.navigate().back();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("abodeQA")));
		 Reporter.highlight(driver,driver.findElement(By.linkText("abodeQA")));
		 Select color=new Select(driver.findElement(By.id("SelectID_One")));
		 
		 
		 color.selectByValue("greenvalue");
		 WebElement option = color.getFirstSelectedOption();
		 String defaultItem = option.getText();
		 Reporter.report(defaultItem,"Green");
		 Reporter.writeResults();
		 Reporter.TakeScreenshot(driver, "lastScreenshot");
		 driver.findElement(By.xpath("//table[@id='selectTable']/tbody/tr[2]/td/button")).click();
		 Alert alert;
		 alert = driver.switchTo().alert();
			alert.accept();
			 driver.findElement(By.linkText("abodeQA")).sendKeys(Keys.CONTROL +"t");
			 driver.get("https://yahoo.com");
			Thread.sleep(5000);
		 
		 driver.close();
			  
  }
}
