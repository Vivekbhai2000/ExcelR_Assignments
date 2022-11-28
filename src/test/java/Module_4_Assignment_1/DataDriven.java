package Module_4_Assignment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/V4/");
		
	}
	
	@Test(dataProvider="testdata")
	public void LoginPage(String username, String password){
	
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().alert().accept();
		System.out.println("Login Successful");
	}
		
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	
	@DataProvider(name="testdata")
	public Object[][] Users(){
		ReadExcelFile config = new ReadExcelFile("./src/test/java/Module_4_Assignment_1/testdata.xlsx");
		int rows = config.getRowCount(0);
		Object[][] credentials = new Object[rows][2];
		for (int i=0;i<rows;i++){
			credentials[i][0] = config.getData(0,i,0);
			credentials[i][1]= config.getData(0,i,1);
			}
		return credentials;
	}
}


