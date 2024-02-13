package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initilization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualHomePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(actualHomePageTitle, "CRMPRO", "Home page title not matched.");
	}

	@Test(priority = 2)
	public void userNameInHomePageTest() {
		testUtil.switchToFrame();
		boolean actualUserName = homepage.validateLoggedUserName();
		Assert.assertEquals(actualUserName, true);
	}

	@Test(priority = 3)
	public void contactsPageTest() {
		testUtil.switchToFrame();
		contactpage = homepage.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
