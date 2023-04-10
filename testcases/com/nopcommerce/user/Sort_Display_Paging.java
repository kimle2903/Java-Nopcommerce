package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

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
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import reportConfigs.ExtentTestManager;

public class Sort_Display_Paging extends BaseTest {

	UserHomePageObject userHomePage;
	UserListProductPageObject userListProductPage;

	WebDriver driver;
	String browserName, menuName, subMenuName;
	List<String> listName;
	List<String> sortListName;
	List<Float> listPrice;
	List<Float> sortListPrice;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		this.browserName = browserName.toUpperCase();
		menuName = "Computers";
		subMenuName = "Notebooks";

		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

	}

	@Test
	public void TC_01_Sort_Name_A_To_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Sort name a to z");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 01: Hover to menu link is '" + menuName + "'");
		userHomePage.hoverToMenuLinkByName(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 02: Click to sub menu is '" + subMenuName + "'");
		userListProductPage = userHomePage.clickToSubMenuLinkByName(subMenuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 03: Get all product name");
		listName = userListProductPage.getAllProductName();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 04: Use collections sort list name in step 3");
		Collections.sort(listName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 05: Click to sort by in dropdown and choose 'Name: A to Z'");
		userListProductPage.chooseSortInDropdownByVisibleText("Name: A to Z");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 06: Get all product name");
		sortListName = userListProductPage.getAllProductName();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 07: Verify list product name of step 4 and step 6");
		Assert.assertEquals(listName, sortListName);

	}

	@Test
	public void TC_02_Sort_Name_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Sort name Z to A");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 01: Use collections reverse list name in TC 'Sort_01_Name_A_To_Z'");
		Collections.reverse(listName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 02: Click to sort by in dropdown and choose 'Name: Z to A'");
		userListProductPage.chooseSortInDropdownByVisibleText("Name: Z to A");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 03: Get all product name");
		sortListName = userListProductPage.getAllProductName();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort name - Step 04: Verify list product name of step 1 and step 3");
		Assert.assertEquals(listName, sortListName);
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Sort Price low to high");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 01: Get all product price");
		listPrice = userListProductPage.getAllProducePrice();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 02: User collections sort product price");
		Collections.sort(listPrice);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 03: Click to sort by in dropdown and choose 'Price: Low to High'");
		userListProductPage.chooseSortInDropdownByVisibleText("Price: Low to High");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 04: Get all product price");
		sortListPrice = userListProductPage.getAllProducePrice();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 04: Verify list product price of step 2 and step 4");
		Assert.assertEquals(listPrice, sortListPrice);
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Sort Price high to low");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 01: User collections reverse product price");
		Collections.reverse(listPrice);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 02: Click to sort by in dropdown and choose 'Price: High to Low'");
		userListProductPage.chooseSortInDropdownByVisibleText("Price: High to Low");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 03: Get all product price");
		sortListPrice = userListProductPage.getAllProducePrice();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Sort Price - Step 04: Verify list product price of step 1 and step 3");
		Assert.assertEquals(listPrice, sortListPrice);
	}

	@Test()
	public void TC_05_Display_3_Product_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Check 3 product display one page");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 01: Click to display dropdown and choose value is '3'");
		userListProductPage.chooseDisplayDropdownByVisibleText("3");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 02: Verify total product display");
		Assert.assertTrue(userListProductPage.isProductDisplayByNumber(3));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 03: Verify current page is '1'");
		Assert.assertEquals(userListProductPage.getCurrentPage(), "1");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 04: Verify icon next page display");
		Assert.assertTrue(userListProductPage.isIconNextPageDisplay());

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 05: Click to icon next page");
		userListProductPage.clickToIconNextPage();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 06: Verify icon previous page display");
		Assert.assertTrue(userListProductPage.isIconPreviousDisplay());
	}

	@Test
	public void TC_06_Display_6_Product_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Check 6 product display one page");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 01: Click to display dropdown and choose value is '6'");
		userListProductPage.chooseDisplayDropdownByVisibleText("6");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 02: Verify total product display");
		Assert.assertTrue(userListProductPage.isProductDisplayByNumber(6));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 03: Verify paging un display");
		Assert.assertTrue(userListProductPage.isUnDisplayPaging());

	}

	@Test
	public void TC_07_Display_9_Product_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Check 9 product display one page");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 01: Click to display dropdown and choose value is '9'");
		userListProductPage.chooseDisplayDropdownByVisibleText("9");
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 02: Verify total product display");
		Assert.assertTrue(userListProductPage.isProductDisplayByNumber(9));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Display - Step 03: Verify paging un display");
		Assert.assertTrue(userListProductPage.isUnDisplayPaging());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
