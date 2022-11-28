package Module_4_Assignment_2_Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Module_4_Assignment_2_Base.ITechNotionBase;

public class VDoctor_Page extends ITechNotionBase {
	
	public boolean Features() {
		driver.findElement(By.xpath("/html/body/header/div/div[4]/ul/li[2]/a")).click();
	    List<WebElement>  features = driver.findElements(By.xpath("//section[@id='nfeatures']//h4"));
		System.out.println("Total Features are ==> " + features.size());
		for (int i = 0; i < features.size() ; i++) {
			System.out.println("Text Of The Features Are ==> " + features.get(i).getText());	
	    }
		return driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/div")).isDisplayed();
	}
	
	public boolean Technology() {
		driver.findElement(By.xpath("/html/body/header/div/div[4]/ul/li[3]/a")).click();
	    List<WebElement>  technology = driver.findElements(By.xpath("//*[@id=\"ntechnology\"]"));
		System.out.println("Total Technolgies are ==> " + technology.size());
		for (int i = 0; i < technology.size() ; i++) {
			System.out.println("Text Of The Technologies Are ==> " + technology.get(i).getText());
	    }
		return driver.findElement(By.xpath("/html/body/section[3]/div/div[4]")).isDisplayed();
	}

	public boolean GetQuote() {
		 driver.findElement(By.xpath("/html/body/header/div/div[2]/a")).click();
		 
//		 After Clicking the GetQuote Button the below code doesn't run and gives error NoSuchElementException 
		 
		 WebElement getquote = driver.findElement(By.xpath("/html/body/div[7]/div/div/div"));
		 getquote.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vivek Omprakash Sharma");
		 getquote.findElement(By.xpath("//input[@name='email']")).sendKeys("123@gmail.com");
		 getquote.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
		 getquote.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello India");
		driver.findElement(By.xpath("//*[@id=\"voomplatform1-e83e7559-32cd-4d21-8fe5-970edce9bc8e\"]")).click();
		System.out.println("Selected");
		driver.findElement(By.xpath("/html/body/div/form/div[6]/div[2]/input")).click();
		System.out.println("Clicked On submit");
		return driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/h4")).isDisplayed();
     
	}
}	
