package org.letcode.seleniumBase;

import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface SeleniumAPI {
	/**
	 * This method will launch the browser with given URL.
	 * @author Viji
	 * @param Url
	 * @exception NullPointerException
	 * @exception MalformedURLException
	 */
	void setUp(String Url);
	
	
	/**
	 * This method will launch the browser with the given browser and URL.
	 * @param browserName
	 * @param Url
	 *  @author Viji
	 *  @exception-SessionNotCreatedException,IllegalArgumentException
	 *  
	 */
	void setUp(BrowserEnum browserName,String Url);
	
	
	/**
	 * This method will close the browser tab.
	 *  @author Viji
	 *  @exception-NoSuchWindowException
	 */
	void close();
	
	
	/**
	 * This method will close the browser.
	 *  @author Viji
	 *   @exception-WebDriverException
	 */
	void quit();
	
	/**
	 * @param type - is any 8 locators type eg: name , linkText etc
	 * @param value -element value
	 * @return WebElement
	 *  @author Viji
	 *   @exception-NoSuchElementException,IllegalArgumentException(when locator mismatch)
	 */
	WebElement elementType(LocatorsEnum type, String value);
	
	
	
	/**
	 * This method will switch to given window
	 * @param i
	 *  @author Viji
	 *   @exception-IndexOutOfBoundsException,NoSuchWindowException
	 */
	void switchToWindow(int i);
	
	
	/**
	 * This method will select the option by given value in the element
	 * @param ele
	 * @param value
	 *  @author Viji
	 *   @exception-NoSuchElementException ,StaleElementReferenceException,UnexpectedTagNameException
	 */
	void selectByValue(WebElement ele, String value);
	
	
	/**
	 * This method will select the option by given text in the element
	 * @param ele
	 * @param text
	 *  @author Viji
	 *   @exception-NoSuchElementException ,StaleElementReferenceException,UnexpectedTagNameException
	 */
	void selectByText(WebElement ele , String text);
	
	
	/**
	 * This method will select the option by given index in the element
	 * @param ele
	 * @param position
	 *  @author Viji
	 *   @exception-NoSuchElementException ,StaleElementReferenceException,UnexpectedTagNameException
	 */
	void selectIndex(WebElement ele , int position);
	
	
	/**
	 * This method will click the given element
	 * @param ele
	 *  @author Viji
	 *   @exception-NoSuchElementException,ElementNotInteractableException,ElementClickInterceptedException,StaleElementReferenceException
	 */
	void click(WebElement ele);
	
	
	/**
	 * This method will type the text in the textbox , it will clear and type the text
	 * @param ele
	 *  @author Viji
	 *   @exception-InvalidElementStateException ,ElementNotInteractableException,StaleElementReferenceException,NoSuchElementException
	 */
	void sendKeysAndEnter(WebElement ele , String testData,Keys keys);
	
	
	/**
	 * This method will type the text in the textbox , it will append the given text in the element.
	 * @param ele
	 *  @author Viji
	 *  @exception-InvalidElementStateException ,ElementNotInteractableException,StaleElementReferenceException,NoSuchElementException
	 */
	void appendText(WebElement ele,String data , Keys keys);
	
	public String getTitle();
	
	public String getUrl();
	
	public boolean isDisplayed(WebElement ele);
}
