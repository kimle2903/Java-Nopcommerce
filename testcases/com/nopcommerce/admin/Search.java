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
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminProductDetailPageObject;
import pageObjects.admin.AdminProductPageObject;
import pageObjects.admin.DashboardPageObject;
import reportConfigs.ExtentTestManager;

public class Search extends BaseTest {
	private AdminLoginPageObject adminLoginPage;
	private DashboardPageObject dashboardPage;
	private AdminProductPageObject adminProductPage;
	private AdminProductDetailPageObject adminProductDetailPage;

	WebDriver driver;
	private String email, password, browserName;
	private String menuName, subMenuName, productName, categoryValue1, categoryValue2, childCategory, manufacturerName, directlyProduct;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		email = "admin@yourstore.com";
		password = "admin";
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		menuName = "Catalog";
		subMenuName = "Products";
		categoryValue1 = "Computers";
		categoryValue2 = "All";
		childCategory = "Computers >> Desktops";
		manufacturerName = "Apple";
		directlyProduct = "LE_IC_600";

		this.browserName = browserName.toUpperCase();
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.enterToEmailTextBox(email);
		adminLoginPage.enterToPasswordTextBox(password);
		dashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Search_With_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Search with product name");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 01: Click to menu '" + menuName + "'");
		dashboardPage.clickToMenuByNameInAdmin(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 02: Click to sub menu '" + subMenuName + "'");
		dashboardPage.clickToSubMenuByNameInAdmin(subMenuName);

		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 03: Enter to product Name is '" + productName + "'");
		adminProductPage.enterToProductNameTextbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 04: Click to button search");
		adminProductPage.clickToSearchButton();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 05: Verify produc search display");
		Assert.assertEquals(adminProductPage.getCountProductInTable(), 1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 06: Verify product name display");
		Assert.assertTrue(adminProductPage.isProductNameDisplayInTable(productName));

	}

	@Test
	public void TC_02_Search_With_Parent_Category_Unchecked(Method method) {
		adminProductPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Search with product name and parent category");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 01: Enter to product Name is '" + productName + "'");
		adminProductPage.enterToProductNameTextbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 02: Choose category dropdown  is '" + categoryValue1 + "'");
		adminProductPage.chooseCategoryInDropdown(categoryValue1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 03: Click to button search");
		adminProductPage.clickToSearchButton();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 04: Verify produc search display");
		Assert.assertEquals(adminProductPage.getMessageNoDataInTable(), "No data available in table");

	}

	@Test
	public void TC_03_Search_With_Parent_Category_Checked(Method method) {
		adminProductPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Search with product name, parent category and checkbox to searchCatogory");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 01: Enter to product Name is '" + productName + "'");
		adminProductPage.enterToProductNameTextbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 02: Choose category dropdown  is '" + categoryValue1 + "'");
		adminProductPage.chooseCategoryInDropdown(categoryValue1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 03: Click to checkbox SEARCG category");
		adminProductPage.checkedToSearchCategoriesCheckBox();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 04: Click to button search");
		adminProductPage.clickToSearchButton();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 05: Verify produc search display");
		Assert.assertEquals(adminProductPage.getCountProductInTable(), 1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 06: Verify product name display");
		Assert.assertTrue(adminProductPage.isProductNameDisplayInTable(productName));
	}

	@Test
	public void TC_04_Search_With_Child_Category(Method method) {
		adminProductPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Search with product name, child category");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 01: Enter to product Name is '" + productName + "'");
		adminProductPage.enterToProductNameTextbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 02: Choose category dropdown  is '" + childCategory + "'");
		adminProductPage.chooseCategoryInDropdown(childCategory);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 03: Click to button search");
		adminProductPage.clickToSearchButton();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 04: Verify produc search display");
		Assert.assertEquals(adminProductPage.getCountProductInTable(), 1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 05: Verify product name display");
		Assert.assertTrue(adminProductPage.isProductNameDisplayInTable(productName));
	}

	@Test
	public void TC_05_Search_With_Manufacturer(Method method) {
		adminProductPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Search with product name and parent category");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 01: Enter to product Name is '" + productName + "'");
		adminProductPage.enterToProductNameTextbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 02: Choose category dropdown  is '" + categoryValue2 + "'");
		adminProductPage.chooseCategoryInDropdown(categoryValue2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 03: Click to checkbox SEARCH category");
		adminProductPage.checkedToSearchCategoriesCheckBox();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 04: Choose manufacturer dropdown  is '" + manufacturerName + "'");
		adminProductPage.chooseManufacturerInDropdown(manufacturerName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 05: Click to button search");
		adminProductPage.clickToSearchButton();

		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Search - Step 06: Verify produc search display");
		Assert.assertEquals(adminProductPage.getMessageNoDataInTable(), "No data available in table");
	}

	@Test
	public void TC_06_Go_Directly_Product_Detail(Method method) {
		adminProductPage.refreshToPage();
		ExtentTestManager.startTest(method.getName(), browserName + "- Go to directly product detail");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Go product detail - Step 01: Enter to go directly product is '" + directlyProduct + "'");
		adminProductPage.enterToGoDirectlyProductTextbox(directlyProduct);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Go product detail - Step 02: Click to button go");
		adminProductDetailPage = adminProductPage.clicktoGoButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Go product detail - Step 03: Verify produc to directly product success");
		Assert.assertTrue(adminProductDetailPage.isGoProductDetailSuccess("Edit product details"));

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Go product detail - Step 04: Verify produc name");
		Assert.assertEquals(adminProductDetailPage.getProductNameInDetailPage(), productName);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
