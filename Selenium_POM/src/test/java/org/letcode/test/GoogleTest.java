package org.letcode.test;

import org.letcode.seleniumBase.BrowserEnum;
import org.letcode.seleniumBase.LocatorsEnum;
import org.letcode.seleniumBase.SeleniumBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleTest extends SeleniumBase {

	@Test
	void searchLetCode() {
		setUp(BrowserEnum.CHROME,"https://www.google.com/");
		//WebElement searchBox = element("name","q") ;
		sendKeysAndEnter(elementType(LocatorsEnum.name,"q"),"Letcode with Koushik", Keys.ENTER);
		quit();
		
	}
	
		


}
