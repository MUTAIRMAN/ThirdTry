
package muthu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Naukri {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe" );
	  driver=new ChromeDriver();
	  driver.get("https://www.naukri.com/mnjuser/homepage?id=");
	  driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
      driver.manage().window().maximize();
    
      String color=driver.findElement(By.xpath("//button[@type='submit']")).getCssValue("background-color");
      String hex = Color.fromString(color).asHex();
      System.out.println(hex);

	  driver.findElement(By.xpath("//*[@id='usernameField']")).sendKeys("mpmuthu59@gmail.com");
	  driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("MUTdim5");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@class='mb10']/a")).click();
	  driver.findElement(By.xpath("//span[@class='edit icon']")).click();
	  WebElement element=driver.findElement(By.xpath("//*/div[@class='input-field s12']/textarea"));
	  Thread.sleep(2000);
	  /* WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  element.isDisplayed();*/
	 
    
	  String Profile=element.getText();
	  String Profile_Up=Profile.substring(238,248);
	  Profile=Profile.replaceFirst(Profile_Up, Profile_Up);
	  Actions action=new Actions(driver);
	  action.moveToElement(element);
	  action.doubleClick(element);
      action.build().perform();
      
	  driver.findElement(By.xpath("//*/div[@class='input-field s12']/textarea")).clear();
	  driver.findElement(By.xpath("//*/div[@class='input-field s12']/textarea")).sendKeys(Profile);
	  driver.findElement(By.xpath("//*/button[@type='submit']")).click();
	  Thread.sleep(2000);
	  driver.quit();
  }
}
