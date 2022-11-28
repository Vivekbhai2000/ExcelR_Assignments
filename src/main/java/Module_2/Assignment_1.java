package Module_2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {

	public static void main(String[] args) {
			
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> col = table.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
	    System.out.println("Total No of columns are : " +col.size());
	    List<WebElement> rows = table.findElements(By.xpath ("//table[@class='dataTable']/tbody/tr/td[1]"));
	    System.out.println("Total No of rows are : " + rows.size());
	    System.out.println("List of Companies Are ==>");
	    System.out.println();
	    String beforexpath = "/html/body/div/div[3]/div[1]/table/tbody/tr[";
	    String afterxpath = "]/td[1]";
	    for (int i = 1; i <=26; i++) {
	    	String actualxpath = beforexpath + i + afterxpath;
	    	WebElement element = driver.findElement(By.xpath(actualxpath));
	    	System.out.println(element.getText());	
		}
	    driver.switchTo().newWindow(WindowType.TAB); 
		driver.get("https://demo.guru99.com/test/login.html");
		driver.findElement(By.id("email")).sendKeys("VivekSharmaTest");
		driver.findElement(By.id("passwd")).sendKeys("VivekSharmaPassword");
    	driver.findElement(By.id("SubmitLogin")).click();
    	System.out.println("Login Successful");
    	driver.quit();
	}
}

