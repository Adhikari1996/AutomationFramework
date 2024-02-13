package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Initialize the Object Repository

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;
	@FindBy(xpath = "//a[contains(text(),'Sign Up']")
	WebElement signUp;
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement logoImage;

	// Page Factory - Initialize the Elements

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Action to Elements

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogoImage() {
		return logoImage.isDisplayed();
	}

	public HomePage login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		login.click();

		return new HomePage();
	}
}
