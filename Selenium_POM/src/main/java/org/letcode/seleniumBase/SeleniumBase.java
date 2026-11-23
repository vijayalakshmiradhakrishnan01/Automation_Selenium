package org.letcode.seleniumBase;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumBase implements SeleniumAPI {

	long timeOuts = 10; //30
	long maxWaitTime = 10 ;
	
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	
	public void setUp(String Url) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Letcode1\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(Url);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	public void setUp(BrowserEnum browserName, String Url) {
	
		switch (browserName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\Letcode1\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver(); 
			break;
		case FIREFOX:
			 driver = new FirefoxDriver(); 
			 System.setProperty("webdriver.Firefox.driver",
			  "C:\\Users\\Admin\\eclipse-workspace\\Letcode1\\drivers\\geckodriver.exe");
			break;
		default:
			System.err.println("browser is not defined"); 
			break;
		
		/*
		 * case CHROME: 
		 *  break; case F
		 * break; case EDGE: break;
		 */
		/*
		 * default: break;
		 */
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(Url);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	public void close() {
		driver.close();
		
	}

	public void quit() {
		driver.quit();
		
	}

	public WebElement elementType(LocatorsEnum type, String value) {
		
		try {
			switch (type) {
			case id:
				return driver.findElement(By.id(value));
			case name:
				return driver.findElement(By.name(value));
			case xpath:
				return driver.findElement(By.xpath(value));
			case linkText:
				return driver.findElement(By.linkText(value));
			case partialLinkText:
				return driver.findElement(By.partialLinkText(value));
			case cssSelector:
				return driver.findElement(By.cssSelector(value));
			case tagName:
				return driver.findElement(By.tagName(value));
			case className:
				return driver.findElement(By.className(value));

			default:
				break;
			}
			
		} 
		catch (NoSuchElementException e) {
			System.err.println("Element not found ->" +e.getMessage());	
			throw new NoSuchElementException("Element is not found");
			
		}
		catch (WebDriverException e) {
			System.err.println("Element not found ->" +e.getMessage());
			throw new WebDriverException("some unknown webdriver error");			
		}
		catch(Exception e) {
			System.err.println("Element not found ->" +e.getMessage());
		}
		
		return null;
	}

	public void switchToWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
		
		
	}
	
	public void assertLabel(String actualString , String value) {
		
		Assert.assertEquals(actualString, value);
	}

	public void selectByValue(WebElement ele, String value) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByValue(value);
		
	}
	public void navigation() {
		driver.navigate().back();
		
	}
	

	public void selectByText(WebElement ele, String text) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByVisibleText(text);
		
	}

	public void selectIndex(WebElement ele, int position) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByIndex(position);
		
	}

	public void click(WebElement ele) {
			
		WebElement element = isElementVisible(ele);
		
		element.click();
		
	}

	private WebElement isElementVisible(WebElement ele) {
		WebElement element = wait
				.withMessage("Element is not clickable")
				.until(ExpectedConditions
				.elementToBeClickable(ele));
		return element;
	}

	public void appendText(WebElement ele,String testData , Keys keys) {
		WebElement element = wait
				.withMessage("Element is not visible")
				.until
				(ExpectedConditions
				 .visibilityOf(ele));
		
		element.sendKeys(testData,Keys.ENTER);
		
	}

	

	public void sendKeysAndEnter(WebElement ele,String testData,Keys keys) {
		WebElement element = wait
				.withMessage("Element is not visible")
				.until
				(ExpectedConditions
				 .visibilityOf(ele));
		element.clear();
		element.sendKeys(testData,Keys.ENTER);
		
	}

	public void sendKeys(WebElement ele , String testData) {
		
		try {
			WebElement element = wait.withMessage("Element is not visible").until(ExpectedConditions.visibilityOf(ele));
			element.sendKeys(testData);
		} catch (NullPointerException e) {
			System.err.println("Element might be null ->" +e.getMessage());
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public String getTitle() {
		
		return driver.getTitle();
	}


	public String getUrl() {
		
		return driver.getCurrentUrl();
	}

	
	public boolean isDisplayed(WebElement ele) {
		
		return ele.isDisplayed();
	}
	

	

}
