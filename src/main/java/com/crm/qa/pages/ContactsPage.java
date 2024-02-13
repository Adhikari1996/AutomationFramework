package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement companyName;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//input[@value='New Contact' and @type='button']")
	WebElement newContactOnContactPage;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateContactsPage() {
		return contactLabel.getText();
	}
	
	public void clickNewContactForUser() {
		newContactOnContactPage.click();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void createNewContact(String title, String firstName, String lastName, String companyName) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.companyName.sendKeys(companyName);
		saveButton.click();
	}
}
 