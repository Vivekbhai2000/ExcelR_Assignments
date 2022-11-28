package Module_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void BrowserConfig() {
		System.out.println("Browser Is Opening");
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
  @Test
  public void Register() {
	  driver.findElement(By.id("email")).sendKeys("VivekTest");
	  driver.findElement(By.id("passwd")).sendKeys("Viv-123");
	  driver.findElement(By.id("SubmitLogin")).click();
  }
  
  @AfterTest
  public void CloseBrowser() {
	  System.out.println("Browser Is Closing");
	  driver.close();
	
}
}
