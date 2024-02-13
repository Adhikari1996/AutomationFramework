package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends LoginPage {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactpage;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactpage = homepage.clickOnContactLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertEquals(contactpage.validateContactsPage(),"Contacts", "User name is not valid");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactpage.selectContactsByName("Ben Daukits");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactpage.selectContactsByName("Harry Kane");
		contactpage.selectContactsByName("Tom Smith");

	}
	
	@DataProvider
	public Object[][] getSheetTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getSheetTestData")
	public void createNewContactTest(String title, String firstname, String lastname, String company) {
		contactpage.clickNewContactForUser();
		contactpage.createNewContact(title, firstname, lastname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
