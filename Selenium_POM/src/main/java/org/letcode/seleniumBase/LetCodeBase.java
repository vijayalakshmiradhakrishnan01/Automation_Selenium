package org.letcode.seleniumBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcel_DynamicDataReading;

public class LetCodeBase {

	protected RemoteWebDriver driver = null;
	String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@DataProvider(name="data")
	public String[][] dataprovider(){
		String[][] excelData = ReadExcel_DynamicDataReading.getExcelData("Login-data");
		return excelData;
		
	}
	///Letcode1/test-data/Login-data.xlsx
	
	@BeforeMethod()
	public void startApp() {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\Letcode1\\drivers\\chromedriver.exe");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
		
		
	}

}

