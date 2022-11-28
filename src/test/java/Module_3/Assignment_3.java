package Module_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3 {
	
	WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	public void OpenBrowser() {
		System.out.println("Browser Is Opening");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	
	@Test(groups = "smoke")
	public void ClickOnForms() {
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[1]")).click();
		System.out.println("Clicked on Form");
		
	}
	
	@Test(dependsOnMethods = "ClickOnForms", groups = "smoke")
	public void ClickOnPracticeForm() {
		
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		System.out.println("Clicked on Practice Form");
		
	}
	
	@Test(dependsOnGroups = "smoke", groups = "regression")
	public void RegistrationForm() {
		
		driver.findElement(By.id("firstName")).sendKeys("Vivek");
		System.out.println("First Name Entered");
		driver.findElement(By.id("lastName")).sendKeys("Sharma");
		System.out.println("Last Name Entered");
		driver.findElement(By.id("userEmail")).sendKeys("123@gmail.com");
		System.out.println("Mail ID Entered");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/label")).click();
		System.out.println("Selected Male");
		driver.findElement(By.id("userNumber")).sendKeys("1234567890");
		System.out.println("Entered Phone No.");
		WebElement dobBox = driver.findElement(By.id("dateOfBirthInput"));
		dobBox.click();
		WebElement dropdownyear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select sc = new Select(dropdownyear);
		sc.selectByValue("2000");
		WebElement dropdownmonths = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select sc1 = new Select(dropdownmonths);
		sc1.selectByValue("5");
		WebElement day = driver.findElement(By.xpath("//div[@class='react-datepicker__week']"));
		day.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]")).click();
		System.out.println("Entered DOB");

//		An unknown message pop up on the screen from he demoqa site if i try to execute the below code of subjects but it work fine
		WebElement Subjects =driver.findElement(By.xpath("//*[@id='subjectsContainer']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Subjects)).click();
        WebElement Sub1 = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
        Sub1.sendKeys("English");
        Sub1.sendKeys(Keys.ENTER);
        System.out.println("Entered subject 1 " + "English");
        Sub1.sendKeys("Maths");
        Sub1.sendKeys(Keys.ENTER);
        System.out.println("Entered subject 2 " + "Maths");
		System.out.println("Subjects Entered");
		
//		for hobbies not able to Click because of the Google Ads iframe
//		WebElement hobbies = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]"));
//		hobbies.findElement(By.xpath("//input[@id='hobbies-checkbox-1']")).click();
//		hobbies.findElement(By.xpath("//input[@id='hobbies-checkbox-2']")).click();
//		hobbies.findElement(By.xpath("//input[@id='hobbies-checkbox-3']")).click();
//     	System.out.println("HC");
		
		WebElement address = driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']"));
		address.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Delhi");
		System.out.println("Entered Address");
		
//		After Zoom Out Screen still not able to Click because of the Google Ads iframe
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.body.style.zoom='50%'");

//		For state not able to Click because of the Google Ads iframe
//		WebElement states = driver.findElement(By.xpath("//*[@id=\"state\"]"));
//		states.click();
//		states.findElement(By.id("react-select-3-option-0")).click();
//		System.out.println("Selected State");
		
//		For City not able to Click because of the Google Ads iframe
//		WebElement city = driver.findElement(By.xpath("//*[@id="city"]"));
//		city.click();
//		states.findElement(By.id("react-select-3-option-0")).click();
//		System.out.println("Selected City");
		
//		For Submit button and Alert not able to Click because of the Google Ads iframe
//		driver.findElement(By.xpath("//button[@id='submit']")).click();
//		System.out.println("Clicked on Submit");
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Accepted");
		
	}	
	
	@AfterTest(alwaysRun = true)
	public void CloseBrowser() {
		System.out.println("Browser Is Closing");
		driver.quit();
    }
}