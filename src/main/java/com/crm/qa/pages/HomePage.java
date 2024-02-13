package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//td[contains(text(),'User: Raj Adhikari')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
//	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
//	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoggedUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() {
		contactsLink.click();  
		return new ContactsPage();
	}
	
//	public void clickOnNewContactLink() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//	}
	
	public DealsPage clickOnDealsLink() {
		deals.click();  
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskLink() {
		tasks.click();  
		return new TasksPage();
	}
}
