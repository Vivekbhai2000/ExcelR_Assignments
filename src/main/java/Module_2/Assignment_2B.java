package Module_2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2B {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentID = (String) it.next();
		String childID = (String) it.next();
		driver.switchTo().window(childID);
		driver.findElement(By.name("emailid")).sendKeys("123@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.quit();
	}

}
