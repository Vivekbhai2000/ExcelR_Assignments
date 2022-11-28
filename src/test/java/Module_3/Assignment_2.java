package Module_3;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Assignment_2 {
	
	WebDriver driver;
	
	@BeforeTest
	  public void BrowserConfig() {
		System.out.println("Browser Is Opening");
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/login.html");
	  }
	
  @Test(dataProvider = "Users")
  public void Login(String username, String pwd) {
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.id("passwd")).sendKeys(pwd);
  }

  @AfterTest
  public void CloseBrowser() {
	  System.out.println("Browser Is Closing");
	  driver.close();
  }

  @DataProvider
  public Object[][] Users() {
	  Object[][] data = new Object[3][2];
	  data[0][0] = "admin";
	  data[0][1] = "admin123";
	  data[1][0] = "VivekTest";
      data[1][1] = "Viv-123";
	  data[2][0] = "finance";
	  data[2][1] = "finance123";
	  return data;
    }
  }
  

  
