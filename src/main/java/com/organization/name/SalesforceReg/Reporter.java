package com.organization.name.SalesforceReg;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class Reporter {
	
	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = "C:\\Users\\Muthukumar\\Documents\\Code\\Seleium\\ReportTemplate.html";
			
	public Reporter() {
	}
	
	public static void initialize() {
		details = new ArrayList<Result>();
	}
	
	public static void report(String actualValue,String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result("Pass","Actual value '" + actualValue + "' matches expected value");
			details.add(r);
		} else {
			Result r = new Result("Fail","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'");
			details.add(r);
		}
	}
	
	
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	public static void writeResults() {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
			}
			
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = "C:\\Users\\Muthukumar\\Documents\\Code\\Seleium\\Reports\\_" + currentDate + ".html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
    public static void TakeScreenshot(WebDriver driver,String picname) throws IOException
   {
     
  	  TakesScreenshot scrShot =((TakesScreenshot)driver);
  	  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
  	  File DestFile=new File("C:\\Users\\Muthukumar\\Documents\\Code\\Seleium\\Screenshots\\" + picname + ".png");
  	  FileHandler.copy(SrcFile, DestFile);
  	  
  	  
    }
    
    public static void highlight(WebDriver driver,WebElement Wt) throws InterruptedException
    {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(int i=0;i<=1;i++)
	{
		js.executeScript("arguments[0].style.border='3px solid red'",Wt);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''",Wt);
		Thread.sleep(2000);

	}    
    }
	
}
