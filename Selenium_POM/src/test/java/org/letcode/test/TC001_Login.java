package org.letcode.test;

import org.letcode.pages.LoginPage;
import org.letcode.seleniumBase.LetCodeBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_Login extends LetCodeBase {
	
	@Test(dataProvider = "data")
	public void LoginTest(String[] data) {
		/*
		 * LoginPage lp = new LoginPage(); lp.enterUserName(null);
		 * lp.enterPassword(null); lp.clickLoginBtn();
		 */
		
		LoginPage lp = new LoginPage(driver);
	
		boolean userNameLabel = lp.getUserNameLabel();
		Assert.assertEquals(userNameLabel, true);
		boolean passwordLabel = lp.getPasswordLabel();
		Assert.assertTrue(passwordLabel);
		
		
		new LoginPage(driver)
		.enterUserName(data[0])
		.enterPassword(data[1])
		.clickLoginBtn();
		
	}

}
