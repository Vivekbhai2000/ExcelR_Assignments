package Module_4_Assignment_2_Base;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ITechNotionBase {
	
	public static WebDriver driver;
	
	public void Intialization() throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> headers = driver.findElements(By.xpath("/html/body/div[5]/header//a"));
		System.out.println("Total Headers are ==> " + headers.size());
		for (int i = 0; i < headers.size() ; i++) {
			System.out.println("Text Of The Header Is ==> " + headers.get(i).getText());
	    }
		Thread.sleep(5000);
		WebElement Products = driver.findElement(By.xpath("/html/body/div[5]/header/div/div/div/nav/div/ul[2]/li[1]/div/ul/li[2]/a"));
		Products.click();
		Thread.sleep(2000);
		Products.findElement(By.xpath("/html/body/div[5]/header/div/div/div/nav/div/ul[2]/li[1]/div/ul/li[2]/ul/li[4]/a")).click();
	}
	
	public void tearDown() {
		driver.quit();
	}

}
