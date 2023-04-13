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
import pageObjects.admin.AdminNewAddressPageObject;
import pageObjects.admin.DashboardPageObject;
import reportConfigs.ExtentTestManager;

public class Create_Edit_Delete_Customer extends BaseTest {
	private AdminLoginPageObject adminLoginPage;
	private DashboardPageObject dashboardPage;
	private AdminCustomerPageObject adminCustomerPage;
	private AdminNewAddressPageObject adminNewAddressPage;

	WebDriver driver;
	private String email, password, browserName, menuName, subMenuName;
	private String emailCustomer, passwordCustomer, firstName, lastName, gender, dateOfBirth, companyName, customerRole, managerOfVendor, adminComment, newslette;
	private String month, day, dateOfBirthUpate, adminCommentUpdate;
	private String country, county, city, address1, address2, postalCode, phoneNumber, faxNumber;
	private String countryAddressUpdate, cityAddressUpdate, addressOneUpdate, addressTwoUpdate, firstNameAddressUpdate, lastNameAddressUpdate, companyAddressUpdate;
	public static String emailCustomerUpdate, firstNameUpate, lastNameUpdate, companyNameUpdate;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		email = "admin@yourstore.com";
		password = "admin";
		menuName = "Customers";
		subMenuName = "Customers";

		emailCustomer = "test" + randomInt() + "@gmail.com";
		passwordCustomer = "123123";
		firstName = "Cum";
		lastName = "Cum" + randomInt();
		gender = "Female";
		dateOfBirth = "3/29/2023";
		companyName = "Viet Cum";
		customerRole = "Guests";
		managerOfVendor = "Vendor 1";
		adminComment = "This is admin comment";
		newslette = "Your store name";
		month = "3";
		day = "29";
		adminCommentUpdate = "This is admin comment update";

		firstNameAddressUpdate = "Automation";
		lastNameAddressUpdate = "Test";
		companyAddressUpdate = "FC";
		countryAddressUpdate = "Angola";
		cityAddressUpdate = "Da nang";
		addressOneUpdate = "12 nguyen trai";
		addressTwoUpdate = "Nguyen tuan";

		emailCustomerUpdate = "test" + randomInt() + "@gmail.com";
		firstNameUpate = "Test";
		lastNameUpdate = "Auto" + randomInt();
		companyNameUpdate = "ABC";
		dateOfBirthUpate = "8/30/2022";

		country = "Viet Nam";
		county = "Thanh tri";
		city = "Ha noi";
		address1 = "171 Nguyen trai";
		address2 = "16/216 Van Quan";
		postalCode = "122222";
		phoneNumber = "0345555555";
		faxNumber = "3333333";

		this.browserName = browserName.toUpperCase();
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.enterToEmailTextBox(email);
		adminLoginPage.enterToPasswordTextBox(password);
		dashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Create_New_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Create New Customer");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 01: Click to menu '" + menuName + "'");
		dashboardPage.clickToMenuByNameInAdmin(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 02: Click to sub menu '" + subMenuName + "'");
		dashboardPage.clickToSubMenuByNameInAdmin(subMenuName);
		adminCustomerPage = PageGeneratorManager.getAdminCustomerPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 03: Click to button add new");
		adminCustomerPage.clickToAddNewButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 04: Enter to email textbox is'" + emailCustomer + "'");
		adminCustomerPage.enterToEmailTextbox(emailCustomer);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 05: Enter to password textbox is '" + passwordCustomer + "'");
		adminCustomerPage.enterToPasswordTextbox(passwordCustomer);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 06: Enter to firstName textbox is '" + firstName + "'");
		adminCustomerPage.enterToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 07: Enter to lastName textbox is '" + lastName + "'");
		adminCustomerPage.enterToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 08: Enter to gender textbox is '" + gender + "'");
		adminCustomerPage.chooseGenderInRadioButton(gender);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 09: Enter to date of birthday textbox is '" + dateOfBirth + "'");
		adminCustomerPage.enterToDateOfBirthTextbox(dateOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 10: Enter to email company is '" + companyName + "'");
		adminCustomerPage.enterToCompanyNameTextbox(companyName);

		adminCustomerPage.chooseNewsletteInDropdown(newslette);

		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 11: Choose manage if vendor is '" + managerOfVendor + "'");
		adminCustomerPage.chooseManageOfVendorInDropdown(managerOfVendor);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 12: Click to active checkbox");
		adminCustomerPage.checkedToActiveCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 13: Enter to admin comment textarea is '" + adminComment + "'");
		adminCustomerPage.enterToAdminCommentTextAreaa(adminComment);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 14: Click to button save and countinue edit");
		adminCustomerPage.clickToSaveAndContinueEditButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 15: Verify message success display");
		Assert.assertTrue(adminCustomerPage.isMessageSuccessDisplay("The new customer has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 16: Verify email textbox display after add is '" + emailCustomer + "'");
		Assert.assertEquals(adminCustomerPage.getEmailOfCustomer(), emailCustomer);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 17: Verify firstName textbox display after add is '" + firstName + "'");
		Assert.assertEquals(adminCustomerPage.getFirstNameOfCustomer(), firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 18: Verify lastName textbox display after add is '" + lastName + "'");
		Assert.assertEquals(adminCustomerPage.getLastNameOfCustomer(), lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 19: Verify dateOfBirthday textbox display after add is '" + dateOfBirth + "'");
		Assert.assertEquals(adminCustomerPage.getDateOfBirthOfCustomer(), dateOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 20: Verify companyName textbox display after add is '" + companyName + "'");
		Assert.assertEquals(adminCustomerPage.getCompanyNameOfCustomer(), companyName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 21: Verify email textbox display after add is '" + managerOfVendor + "'");
		Assert.assertEquals(adminCustomerPage.getManagerOfVendorOfCustomer(), managerOfVendor);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 22: Verify email textbox display after add is '" + adminComment + "'");
		Assert.assertEquals(adminCustomerPage.getAdminCommentOfCustomer(), adminComment);

		adminCustomerPage.clickToBackToCustomerListLink();

	}

	@Test
	public void TC_02_Edit_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter to email textbox to search is '" + emailCustomer + "'");
		adminCustomerPage.enterToEmailTextBoxSearch(emailCustomer);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Enter to first name textbox to search is '" + firstName + "'");
		adminCustomerPage.enterToFirstNameTextBoxSearch(firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Enter to last name textbox to search is '" + lastName + "'");
		adminCustomerPage.enterToLastNameTextBoxSearch(lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 04: Enter to month textbox to search is '" + month + "'");
		adminCustomerPage.enterToMonthDropdownSearch(month);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 05: Enter to day textbox to search is '" + day + "'");
		adminCustomerPage.enterToDayDropdownSearch(day);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 06: Enter to companyName textbox to search is '" + companyName + "'");
		adminCustomerPage.enterToCompanyTextBoxSearch(companyName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 06: Enter to customerRole textbox to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 07: Click to button search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 08: Click to button edit at email");
		adminCustomerPage.clickToEditButtonByName(firstName + " " + lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 09: Enter to email update  textbox is'" + emailCustomerUpdate + "'");
		adminCustomerPage.enterToEmailTextbox(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 10: Enter to firstName update textbox is '" + firstNameUpate + "'");
		adminCustomerPage.enterToFirstNameTextbox(firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 11: Enter to lastName update textbox is '" + lastNameUpdate + "'");
		adminCustomerPage.enterToLastNameTextbox(lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 12: Enter to date of birthday update textbox is '" + dateOfBirthUpate + "'");
		adminCustomerPage.enterToDateOfBirthTextbox(dateOfBirthUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 13: Enter to email company update is '" + companyNameUpdate + "'");
		adminCustomerPage.enterToCompanyNameTextbox(companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 14: Enter to admin comment textarea update is '" + adminCommentUpdate + "'");
		adminCustomerPage.enterToAdminCommentTextAreaa(adminCommentUpdate);

		adminCustomerPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Create New Customer - Step 15: Verify message success display");
		Assert.assertTrue(adminCustomerPage.isMessageSuccessDisplay("The customer has been updated successfully."));

	}

	@Test
	public void TC_03_Add_Address_In_Customer_Detail(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Add new address");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 01: Enter to email textbox to search is '" + emailCustomerUpdate + "'");
		adminCustomerPage.enterToEmailTextBoxSearch(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 02: Enter to first name textbox to search is '" + firstNameUpate + "'");
		adminCustomerPage.enterToFirstNameTextBoxSearch(firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 03: Enter to last name textbox to search is '" + lastNameUpdate + "'");
		adminCustomerPage.enterToLastNameTextBoxSearch(lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 04: Enter to companyName textbox to search is '" + companyNameUpdate + "'");
		adminCustomerPage.enterToCompanyTextBoxSearch(companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 06: Enter to customerRole textbox to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 05: Click to button search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 08: Click to button edit at email");
		adminCustomerPage.clickToEditButtonByName(firstNameUpate + " " + lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 06: Click to button add to new address");
		adminNewAddressPage = adminCustomerPage.clickToAddNewAddressButton("Add new address");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 07: Enter to firstname textbox is '" + firstNameUpate + "'");
		adminNewAddressPage.enterToFirstNameTextBox(firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 08: Enter to lastname textbox is '" + lastNameUpdate + "'");
		adminNewAddressPage.enterToLastNameTextBox(lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 09: Enter to email textbox is '" + emailCustomerUpdate + "'");
		adminNewAddressPage.enterToEmailTextBox(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 10: Enter to company textbox is '" + companyNameUpdate + "'");
		adminNewAddressPage.enterToCompanyTextBox(companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 11: Choose country in dropdown is '" + country + "'");
		adminNewAddressPage.chooseCountryInDropdown(country);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 12: Enter to county textbox is '" + county + "'");
		adminNewAddressPage.enterToCountyTextBox(county);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 13: Enter to city textbox is '" + city + "' ");
		adminNewAddressPage.enterToCityTextBox(city);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 14: Enter to address1 textbox is '" + address1 + "' ");
		adminNewAddressPage.enterToAddress1TextBox(address1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 15: Enter to address2 textbox is '" + address2 + "'");
		adminNewAddressPage.enterToAddress2TextBox(address2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 16: Enter to postal code textbox is '" + postalCode + "'");
		adminNewAddressPage.enterToPostalCodeTextBox(postalCode);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 17: Enter to phone number textbox is '" + phoneNumber + "'");
		adminNewAddressPage.enterToPhoneNumberTextBox(phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 18: Enter to faxNumber textbox is '" + faxNumber + "' ");
		adminNewAddressPage.enterToFaxNumberTextBox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 19: Click to button save");
		adminNewAddressPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 20: Verify message success");
		Assert.assertTrue(adminNewAddressPage.isShowMessageSuccess("The new address has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 21: Verify first name after add new address");
		Assert.assertEquals(adminNewAddressPage.getFirstNameTextBox(), firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 22: Verify last name after add new address");
		Assert.assertEquals(adminNewAddressPage.getLastNameTextBox(), lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 23: Verify email after add new address");
		Assert.assertEquals(adminNewAddressPage.getEmailNameTextBox(), emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 24: Verify company after add new address");
		Assert.assertEquals(adminNewAddressPage.getCompanyNameTextBox(), companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 25: Verify country after add new address");
		Assert.assertEquals(adminNewAddressPage.getCountryChooseInDropdown(), country);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 26: Verify county after add new address");
		Assert.assertEquals(adminNewAddressPage.getCountyTextBox(), county);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 27: Verify address1 after add new address");
		Assert.assertEquals(adminNewAddressPage.getAddress1TextBox(), address1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 28: Verify address2 after add new address");
		Assert.assertEquals(adminNewAddressPage.getAddress2TextBox(), address2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 29: Verify postal code after add new address");
		Assert.assertEquals(adminNewAddressPage.getPostalCodeTextBox(), postalCode);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 30: Verify phone number after add new address");
		Assert.assertEquals(adminNewAddressPage.getPhoneNumberTextBox(), phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Add new address - Step 32: Verify fax number after add new address");
		Assert.assertEquals(adminNewAddressPage.getFaxNumberTextBox(), faxNumber);
	}

	@Test
	public void TC_04_Edit_Address_In_Customer_Detail(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit_Address");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 02: Click to sub menu '" + subMenuName + "'");
		adminNewAddressPage.clickToSubMenuByNameInAdmin(subMenuName);
		adminCustomerPage = PageGeneratorManager.getAdminCustomerPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 03: Enter to email textbox to search is '" + emailCustomerUpdate + "'");
		adminCustomerPage.enterToEmailTextBoxSearch(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 04: Enter to first name textbox to search is '" + firstNameUpate + "'");
		adminCustomerPage.enterToFirstNameTextBoxSearch(firstNameUpate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Edit_Address - Step 05: Enter to last name textbox to search is '" + lastNameUpdate + "'");
		adminCustomerPage.enterToLastNameTextBoxSearch(lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 06: Enter to companyName textbox to search is '" + companyNameUpdate + "'");
		adminCustomerPage.enterToCompanyTextBoxSearch(companyNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 06: Enter to customerRole textbox to search is '" + customerRole + "'");
		adminCustomerPage.clearOptionSelectedInCustomerRole();
		adminCustomerPage.chooseCustomerRoleInDropdown(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 07: Click to button search");
		adminCustomerPage.clickToSearchButton();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 08: Click to button edit by email");
		adminCustomerPage.clickToEditButtonByName(firstNameUpate + " " + lastNameUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 09: Click to button edit address by email email");
		adminNewAddressPage = adminCustomerPage.clickToEditAddressByEmail(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 10: Enter to firstname textbox is '" + firstNameAddressUpdate + "'");
		adminNewAddressPage.enterToFirstNameTextBox(firstNameAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 11: Enter to lastname textbox is '" + lastNameAddressUpdate + "'");
		adminNewAddressPage.enterToLastNameTextBox(lastNameAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 12: Enter to company textbox is '" + companyAddressUpdate + "'");
		adminNewAddressPage.enterToCompanyTextBox(companyAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 13: Choose country in dropdown is '" + countryAddressUpdate + "'");
		adminNewAddressPage.chooseCountryInDropdown(countryAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 14: Enter to city textbox is '" + cityAddressUpdate + "' ");
		adminNewAddressPage.enterToCityTextBox(cityAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 15: Enter to address1 textbox is '" + addressOneUpdate + "' ");
		adminNewAddressPage.enterToAddress1TextBox(addressOneUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 16: Enter to address2 textbox is '" + addressTwoUpdate + "'");
		adminNewAddressPage.enterToAddress2TextBox(addressTwoUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit_Address - Step 17: Click to button save");
		adminNewAddressPage.clickToSaveEditButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 18: Verify message success");
		Assert.assertTrue(adminNewAddressPage.isShowMessageSuccess("The address has been updated successfully."));

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 19: Verify first name after add new address");
		Assert.assertEquals(adminNewAddressPage.getFirstNameTextBox(), firstNameAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 20: Verify last name after add new address");
		Assert.assertEquals(adminNewAddressPage.getLastNameTextBox(), lastNameAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 21: Verify company after add new address");
		Assert.assertEquals(adminNewAddressPage.getCompanyNameTextBox(), companyAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 22: Verify country after add new address");
		Assert.assertEquals(adminNewAddressPage.getCountryChooseInDropdown(), countryAddressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 23: Verify address1 after add new address");
		Assert.assertEquals(adminNewAddressPage.getAddress1TextBox(), addressOneUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-   Edit_Address - Step 24: Verify address2 after add new address");
		Assert.assertEquals(adminNewAddressPage.getAddress2TextBox(), addressTwoUpdate);

	}

	@Test
	public void TC_05_Delete_Address_In_Customer_Detail(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete address ");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete address - Step 1: Click to back customer list");
		adminCustomerPage = adminNewAddressPage.clickToBackToCustomerList();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete address - Step 2: click to delete address by email");
		adminCustomerPage.clickToDeleteAddressByEmail(emailCustomerUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete address - Step 3: accept alert confirm delete");
		adminCustomerPage.acceptAlertConfirmDelete();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete address - Step 4: Verify nodata in table");
		Assert.assertEquals(adminCustomerPage.getMessageNoData(), "No data available in table");

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
