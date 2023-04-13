package com.nopcommerce.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminCustomerPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.DashboardPageObject;
import reportConfigs.ExtentTestManager;

public class Search_Customer extends BaseTest {
	private AdminLoginPageObject adminLoginPage;
	private DashboardPageObject dashboardPage;
	private AdminCustomerPageObject adminCustomerPage;

	WebDriver driver;
	private String email, password, browserName, menuName, subMenuName;
	private String emailCustomer, passwordCustomer, firstName, lastName, gender, dateOfBirth, companyName, customerRole, managerOfVendor, adminComment, newslette;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		email = "admin@yourstore.com";
		password = "admin";
		menuName = "Customers";
		subMenuName = "Customers";

		passwordCustomer = "123123";
		firstName = "Cum";
		lastName = "Cum";
		gender = "Female";
		dateOfBirth = "3/29/2023";
		companyName = "Viet Cum";
		customerRole = "Guests";
		managerOfVendor = "Vendor 1";
		adminComment = "This is admin comment";
		newslette = "Your store name";

		this.browserName = browserName.toUpperCase();
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.enterToEmailTextBox(email);
		adminLoginPage.enterToPasswordTextBox(password);
		dashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Search_Customer_With_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Search customer with email ");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 01: Click to menu '" + menuName + "'");
		dashboardPage.clickToMenuByNameInAdmin(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 02: Click to sub menu '" + subMenuName + "'");
		dashboardPage.clickToSubMenuByNameInAdmin(subMenuName);
		adminCustomerPage = PageGeneratorManager.getAdminCustomerPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 03: Enter to email textbox search is '" + Create_Edit_Delete_Customer.emailCustomerUpdate + "'");
		adminCustomerPage.enterToEmailTextBoxSearch(Create_Edit_Delete_Customer.emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 04: Choose customer roles to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 05: Click to button Search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 06: Verify search success'");
		Assert.assertEquals(adminCustomerPage.getCountCustomerDisplay(), 1);
	}

	@Test
	public void TC_02_Search_Customer_With_FirstName_LastName(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Search customer with first name, last name and customer Role ");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 01: Refresh to page");
		adminCustomerPage.refreshToPage();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 02: Enter to first name search is '" + Create_Edit_Delete_Customer.firstNameUpate + "'");
		adminCustomerPage.enterToFirstNameTextBoxSearch(Create_Edit_Delete_Customer.firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 03: Enter to last name search is '" + Create_Edit_Delete_Customer.lastNameUpdate + "'");
		adminCustomerPage.enterToLastNameTextBoxSearch(Create_Edit_Delete_Customer.lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 04: Choose customer roles to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 05: Click to button Search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 06: Verify search success'");
		Assert.assertEquals(adminCustomerPage.getCountCustomerDisplay(), 1);
	}

	@Test
	public void TC_03_Search_Customer_With_Company(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Search customer with company and customer Role ");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 01: Refresh to page");
		adminCustomerPage.refreshToPage();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 02: Enter to company name search is '" + Create_Edit_Delete_Customer.companyNameUpdate + "'");
		adminCustomerPage.enterToCompanyTextBoxSearch(Create_Edit_Delete_Customer.companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 03: Choose customer roles to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 04: Click to button Search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search customer - Step 05: Verify search success'");
		Assert.assertTrue(adminCustomerPage.isCustomerDisplayByCompanyName(Create_Edit_Delete_Customer.companyNameUpdate));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
