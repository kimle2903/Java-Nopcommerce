package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.commons.Common_01_Register_With_Email_And_Password;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserSearchPageObject;
import reportConfigs.ExtentTestManager;

public class Search_Advanced_Search extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;

	private WebDriver driver;
	private String browserName, footerName, productNameRelative, productNameAbsolute, category, advancedKey;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);
		this.browserName = browserName.toUpperCase();

		footerName = "Search";
		productNameRelative = "Lenovo";
		productNameAbsolute = "ThinkPad X1 Carbon Laptop";
		category = "Computers";
		advancedKey = "Apple MacBook Pro";

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.enterToEmailTextBox(Common_01_Register_With_Email_And_Password.email);
		userLoginPage.enterToPasswordTextBox(Common_01_Register_With_Email_And_Password.password);
		userLoginPage.clickToLoginButton();
		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());
	}

	@Test
	public void Search_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search");
		userHomePage.openPageByNameAtFooter(footerName);
		userSearchPage = PageGeneratorManager.getUserSearchPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify error search ");
		Assert.assertEquals(userSearchPage.getErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_Data_Not_Exists(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search with data not exists");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userHomePage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter search don't exists is 'Macpro 3040'");
		userSearchPage.enterToSearchKeyword("Macpro 3040");

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Verify no products were found");
		Assert.assertEquals(userSearchPage.getMessageResultSearch(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_03_Product_Name_Relative(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search with product name relative");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter product name relative into search textbox is '" + productNameRelative + "' ");
		userSearchPage.enterToSearchKeyword(productNameRelative);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify count product were found");
		Assert.assertEquals(userSearchPage.countProductSearchResult(), 2);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify name product result");
		Assert.assertTrue(userSearchPage.isResultIncludeRelativeProductName(productNameRelative));

	}

	@Test
	public void Search_04_Product_Name_Absolute(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search with product name absolute");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter product name absolute into search textbox is '" + productNameAbsolute + "' ");
		userSearchPage.enterToSearchKeyword(productNameAbsolute);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify count product were found");
		Assert.assertEquals(userSearchPage.countProductSearchResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify name product result");
		Assert.assertEquals(userSearchPage.getTextProductSearchResult(), "Lenovo Thinkpad X1 Carbon Laptop");
	}

	@Test
	public void Search_05_Advance_With_Parent_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Advanced search with parent categories");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter keys into search textbox is '" + advancedKey + "' ");
		userSearchPage.enterToSearchKeyword(advancedKey);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Checked to advanced search checkbox ");
		userSearchPage.checkedToAdvancedSearchCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Choose category in dropdown is '" + category + "' ");
		userSearchPage.chooseCategoryInDropdown(category);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Verify product result");
		Assert.assertEquals(userSearchPage.getMessageResultSearch(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_06_Advance_With_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Advanced search with sub categories");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter keys into search textbox is '" + advancedKey + "' ");
		userSearchPage.enterToSearchKeyword(advancedKey);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Checked to advanced search checkbox ");
		userSearchPage.checkedToAdvancedSearchCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Choose category in dropdown is '" + category + "' ");
		userSearchPage.chooseCategoryInDropdown(category);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Checked to automatically search checkbox");
		userSearchPage.checkedToAutomaticallySearch();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Verify name product result");
		Assert.assertEquals(userSearchPage.getTextProductSearchResult(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void Search_07_Advance_With_Incorrect_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Advanced search with incorrect manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter keys into search textbox is '" + advancedKey + "' ");
		userSearchPage.enterToSearchKeyword(advancedKey);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Checked to advanced search checkbox ");
		userSearchPage.checkedToAdvancedSearchCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Choose category in dropdown is '" + category + "' ");
		userSearchPage.chooseCategoryInDropdown(category);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Checked to automatically search checkbox");
		userSearchPage.checkedToAutomaticallySearch();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Choose category in dropdown is  'HP' ");
		userSearchPage.chooseManufacturerInDropdown("HP");

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Verify  product result");
		Assert.assertEquals(userSearchPage.getMessageResultSearch(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_08_Advance_With_Correct_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Advanced search with correct manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Open page search again");
		userSearchPage.openPageByNameAtFooter(footerName);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Enter keys into search textbox is '" + advancedKey + "' ");
		userSearchPage.enterToSearchKeyword(advancedKey);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Checked to advanced search checkbox ");
		userSearchPage.checkedToAdvancedSearchCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Choose category in dropdown is '" + category + "' ");
		userSearchPage.chooseCategoryInDropdown(category);

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Checked to automatically search checkbox ");
		userSearchPage.checkedToAutomaticallySearch();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Choose category in dropdown is  'Apple'");
		userSearchPage.chooseManufacturerInDropdown("Apple");

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click to button search");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Verify name product result");
		Assert.assertEquals(userSearchPage.getTextProductSearchResult(), "Apple MacBook Pro 13-inch");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
