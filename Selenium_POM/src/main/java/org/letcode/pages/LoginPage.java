package org.letcode.pages;

import org.letcode.seleniumBase.LetCodeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends LetCodeBase{
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	public boolean getUserNameLabel() {
		return driver.findElement(By.xpath("//label[text()='Username']")).isDisplayed();
	}
	public boolean getPasswordLabel() {
		return driver.findElement(By.xpath("//label[text()='Password']")).isDisplayed();
	}
	
	//@description :get the username from the user and fill the field.
	public LoginPage enterUserName(String userName) {
		driver.findElement(By.name("username")).sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
		return this;
		
	}
	public DashBoardPage clickLoginBtn() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new DashBoardPage();
	}
	public ForgotPasswordPage clickForgotPassword(){
		driver.findElement(By.xpath("//p[normalize-space()='Forgot your password?']")).click();
		return new ForgotPasswordPage();
		
	}
	//this function to login to the web site without validation login page.
	public void login(String userName,String password) {
		driver.findElement(By.name("Username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
