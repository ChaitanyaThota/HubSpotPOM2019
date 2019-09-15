package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	// creating by locators or (NPF)
By createContactButton= By.xpath("//span[text()='Create contact']");
By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
By email = By.id("uid-ctrl-1");
By firstName = By.id("uid-ctrl-2");
By lastName = By.id("uid-ctrl-3");
By jobTitle = By.id("uid-ctrl-5");
By header = By.xpath("//h1[@class='private-header__heading']//i18n-string[text()='Contacts']");

  // Constructor for Page class
public ContactsPage(WebDriver driver) {
	this.driver=driver;
	elementUtil = new ElementUtil(driver, prop);
}

// Page Actions:
public String getContactsPageTitle() {
	return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
}
public String getHeaderText() {
	return elementUtil.doGetText(header);
}

public void createContact(String emailID, String FN, String LN, String jobTitleVal) {
	elementUtil.doClick(createContactButton);
	elementUtil.doSendKeys(email, emailID);
	elementUtil.doSendKeys(firstName , FN);
	elementUtil.doSendKeys(lastName, LN);
	elementUtil.doSendKeys(jobTitle, jobTitleVal);
	elementUtil.doClick(createContactFormButton);
	
	
	
}

}
