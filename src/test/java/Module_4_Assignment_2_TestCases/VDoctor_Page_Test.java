package Module_4_Assignment_2_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Module_4_Assignment_2_Base.ITechNotionBase;
import Module_4_Assignment_2_Pages.ExcelReader;
import Module_4_Assignment_2_Pages.VDoctor_Page;

public class VDoctor_Page_Test extends ITechNotionBase {
	
	VDoctor_Page vdp;
	
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		Intialization();
		vdp = new VDoctor_Page();

	}
	
	@Test(priority = 0)
	public void FeaturesTest() {
		Assert.assertTrue(vdp.Features());
		
	}

	@Test(priority = 1)
	public void TechnologyTest() {
		Assert.assertTrue(vdp.Technology());
		
	}
	
	@Test(priority = 2)
	public void GetQuoteTest() {
		vdp.GetQuote();
		
	}

	@AfterTest
	public void CloseBrowser() {
		tearDown();
	}
	
//	@DataProvider
//	public Object[][] POMData(){
//		ExcelReader config = new ExcelReader("./src/test/java/Module_4_Assignment_2_Pages/POM Data.xlsx");
//		int rows = config.getRowCount(0);
//		Object[][] credentials = new Object[rows][4];
//		for (int i=0;i<rows;i++){
//			credentials[i][0] = config.getData(0,i,0);
//			credentials[i][1]= config.getData(0,i,1);
//			credentials[i][2]= config.getData(0,i,2);
//			credentials[i][3]= config.getData(0,i,3);
//			}
//		return credentials;
//	}	
}
