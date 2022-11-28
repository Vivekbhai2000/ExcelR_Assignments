package Module_2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		WebElement d1 = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.dragAndDropBy(d1, 120, 120).build().perform();
		Thread.sleep(5000);
		
		TakesScreenshot takesScreenshot = driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/Excelr-Assignments/Screenshot/Image1.jpg"));
		System.out.println("ScreenShot Taken");
		
		driver.quit();
		
	}

}
