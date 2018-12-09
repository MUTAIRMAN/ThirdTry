package com.organization.name.SalesforceReg;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBox {
  WebDriver driver;
	
	@Test
  public void f() throws InterruptedException {
  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe" );
	  driver=new ChromeDriver();
	  
	  driver.get("C:\\Users\\Muthukumar\\Documents\\Code\\WebTable.html");
	  
	  WebElement Wt=driver.findElement(By.xpath("//table"));
	  
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	for(int i=0;i<=1;i++)
	    	{
	    		js.executeScript("arguments[0].style.border='3px solid red'",Wt);
	    		Thread.sleep(2000);
	    		js.executeScript("arguments[0].style.border=''",Wt);
	    		Thread.sleep(2000);

	    	}
	    	
	    	
	    
	  List Rows=Wt.findElements(By.tagName("tr"));
	  int nRow=Rows.size();
	  
	  WebElement Wt1=driver.findElement(By.xpath("//tbody//tr"));
      List Cols=Wt1.findElements(By.tagName("th"));
      int ncol=Cols.size();
      for(int x=2;x<=nRow;x++)
      {
    	 
          for(int y=1; y<=ncol ;y++)
          {
        	//System.out.println(driver.findElement(By.tagName("td")).getText());  
        	System.out.println(driver.findElement(By.xpath("//tbody/tr["+x+"]/td["+y+"]")).getText());
        	  
          }
          
    	  
    	        }
	  driver.quit();
	  
	  
	  
	
	  
	
  
  }
  
}
