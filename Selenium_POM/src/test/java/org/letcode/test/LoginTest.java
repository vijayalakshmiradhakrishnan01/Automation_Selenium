package org.letcode.test;

import org.letcode.seleniumBase.LocatorsEnum;
import org.letcode.seleniumBase.SeleniumBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends SeleniumBase {

	@BeforeMethod
	void launch() {
		setUp("https://practicetestautomation.com/practice-test-login/");
	}
	
	@Test
	void Login() {
		
		
		click(elementType(LocatorsEnum.xpath,"//a[text()='Home']"));
		navigation();
		sendKeys(elementType(LocatorsEnum.id,"usernam"),"student");
		sendKeys(elementType(LocatorsEnum.id,"password"),"password123");
		click(elementType(LocatorsEnum.id,"submit"));
		System.out.println("completed");
		
	}
	@AfterMethod(alwaysRun=true)	
	void closeSetup() {
		quit();
	}
		
		
	
	
	
}

//always write assertion for URL , title verify so and so .