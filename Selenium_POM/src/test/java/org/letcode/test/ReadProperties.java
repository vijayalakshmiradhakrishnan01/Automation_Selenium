package org.letcode.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Properties properties = new Properties(); properties.load(new
		 * FileInputStream("./letcodeFr.properties")); String property =
		 * properties.getProperty("welcome"); System.out.println(property);
		 */
		Properties properties = new Properties();
		properties.load(new FileInputStream("./locators.properties"));
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Letcode1\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElementById("username").sendKeys(properties.getProperty("userName"));
		driver.findElementById("password").sendKeys(properties.getProperty("password"));
		driver.findElementById("submit").submit();

	}

}
