package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Define locators / OR- with By locator (NPF):
	
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.cssSelector("a#account-menu>span.account-name ");
	By contactsPageMainTab = By.id("nav-primary-contacts-branch");
	By contactsPageSecTab = By.id("nav-secondary-contacts");
	
	
     // Constructor of Page class:
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver, prop);
		
	}
	
	// Page Actions OR Methods
	public String getHomePageTitle() {
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	}
	public boolean verifyLoggedInAccountName() {
		return elementUtil.isElementDisplayed(accountName);
	}
	public String getLoggedInAccountName() {
		return elementUtil.doGetText(accountName);
	}
	private void clickOnContacts() {
		elementUtil.doClick(contactsPageMainTab);
		elementUtil.doClick(contactsPageSecTab);
	}
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	
	

}
