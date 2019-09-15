package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;

public class ElementUtil extends BasePage {
	
	WebDriver driver;
	Properties prop;
	public  ElementUtil(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
public WebElement getElement( By locator) {
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
	if(flash.equalsIgnoreCase("yes")) {
      JavaScriptUtil.flash(element, driver);
         }
		}
		catch(Exception e) {
		System.out.println("Some exception occured while creating Webelement "+ locator);
		}
		return element;
	}

public void waitForElementPresent(By locator ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
public void doClick(By locator)	{
		try {
			getElement(locator).click();	}
		catch(Exception e) {
		System.out.println("Some exception occured while clicking on Webelement :"+locator);
		}
	}
public void doSendKeys(By locator, String value)	{
			try {
				getElement(locator).clear();
				getElement(locator).sendKeys(value);	}
			catch(Exception e) {
			System.out.println("Some exception occured while clicking on Webelement :"+locator);
			}	
		
	}
public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();	}
		catch(Exception e) {
		System.out.println("Some exception occured while sending to  Webelement :"+locator);
		}
		return text;	

	}
public String waitForPageTitle(String title )	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		}

public boolean isElementDisplayed(By locator ) {
		try {
			return getElement( locator).isDisplayed();
		} catch(Exception e) {
			System.out.println("Some exception occured while checking a Webelement displayed :"+ locator);
			return false;
		}
	}

}