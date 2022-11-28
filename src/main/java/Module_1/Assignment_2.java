package Module_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.findElement(By.id("vfb-7-1")).click();
		driver.findElement(By.id("vfb-6-1")).click();
		driver.findElement(By.id("vfb-6-2")).click();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.findElement(By.xpath("//select[@name='country']")).click();
		driver.findElement(By.xpath("//option[@value='KUWAIT']")).click();
		driver.quit();
	}

}
