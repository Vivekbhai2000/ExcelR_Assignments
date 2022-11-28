package Module_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {
	
	public static void main(String[] args) throws InterruptedException {
		PageURLAndTitle();
		Navigators();
		
	}
		
		public static void PageURLAndTitle() {
			
		    WebDriverManager.firefoxdriver().setup();
		    WebDriver driver = new FirefoxDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.amazon.in/");
		    String Url = driver.getCurrentUrl();
		    System.out.println("Current Page URL Is ==> " + Url);
		    String Title = driver.getTitle();
		    System.out.println("Current Page Title Is ==> " + Title);
		    driver.switchTo().newWindow(WindowType.TAB);
		    driver.get("https://www.facebook.com/");
		    String CurrentUrl = driver.getCurrentUrl();
		    System.out.println("Current Page URL Is ==> " + CurrentUrl);
		    String CurrentTitle = driver.getTitle();
		    System.out.println("Current Page Title Is ==> " + CurrentTitle);
		    driver.quit();
		 }
		
		public static void Navigators() {
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			//Thread.sleep(2000);
			driver.navigate().to("https://www.facebook.com/");
			//Thread.sleep(2000);
			driver.navigate().back();
			//Thread.sleep(2000);
			driver.navigate().forward();
			//Thread.sleep(2000);
			driver.navigate().refresh();
			//Thread.sleep(2000);
			driver.quit();
			
		}

}
