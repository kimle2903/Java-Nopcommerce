package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_User_Register_With_Email_And_Password;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserShoppingCartPageObject;

public class Order_01_Add_Edit_Remote_Product_In_Cart extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserListProductPageObject userListProductPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserShoppingCartPageObject userShoppingCartPage;

	private WebDriver driver;
	private String menuName, subMenuName, productName, productNameTwo;
	private String processor, ram, hdd, os, totalPrice;
	private String processorUpdate, ramUpdate, hddUpdate, osUpdate, totalPriceUpdate;
	private String software[] = { "Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]" };
	private String softwareUpdate[] = { "Microsoft Office [+$50.00]" };

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {

		menuName = "Computers";
		subMenuName = "Desktops";
		productName = "Build your own computer";
		productNameTwo = "Lenovo IdeaCentre 600 All-in-One PC";
		processor = "2.2 GHz Intel Pentium Dual-Core E2200";
		ram = "4GB [+$20.00]";
		hdd = "400 GB [+$100.00]";
		os = "Vista Home [+$50.00]";
		totalPrice = "$1,430.00";

		processorUpdate = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		ramUpdate = "8GB [+$60.00]";
		hddUpdate = "320 GB";
		osUpdate = "Vista Premium [+$60.00]";
		totalPriceUpdate = "$1,385.00";

		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);
		userLoginPage.enterToPasswordTextBox(Common_01_User_Register_With_Email_And_Password.password);
		userLoginPage.clickToLoginButton();

		userLoginPage.hoverToMenuLinkByName(menuName);
		userLoginPage.clickToSubMenuLinkByName(subMenuName);

	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		userListProductPage = PageGeneratorManager.getUserListProductPO(driver);
		userProductDetailPage = userListProductPage.clickToProductName(productName);

		userProductDetailPage.chooseProcessorDropdownByVisibleText(processor);
		userProductDetailPage.chooseRamDropdownByVisibleText(ram);
		userProductDetailPage.chooseHDDRadioButtonByName(hdd);
		userProductDetailPage.chooseOSRadioButtonByName(os);
		userProductDetailPage.chooseSoftwareCheckBoxByName(software);

		userProductDetailPage.clickToAddToCartButton();
		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your shopping cart");

		userProductDetailPage.clickToCloseMessageIcon();

		userProductDetailPage.hoverToShoppingCart();
		Assert.assertTrue(userProductDetailPage.isProductNameInOrderDisplay(productName));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(processor));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(ram));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(hdd));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(os));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(software[0]));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(software[1]));
		Assert.assertEquals(userProductDetailPage.getTotalPriceInShoppingCart(), totalPrice);

	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		userShoppingCartPage = userProductDetailPage.clickToShoppingCart();
		userProductDetailPage = userShoppingCartPage.clickToEditLink();

		userProductDetailPage.chooseProcessorDropdownByVisibleText(processorUpdate);
		userProductDetailPage.chooseRamDropdownByVisibleText(ramUpdate);
		userProductDetailPage.chooseHDDRadioButtonByName(hddUpdate);
		userProductDetailPage.chooseOSRadioButtonByName(osUpdate);
		userProductDetailPage.chooseSoftwareCheckBoxByName(softwareUpdate);

		userProductDetailPage.clickToUpdateButton();

		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your shopping cart");

		userProductDetailPage.clickToCloseMessageIcon();

		userProductDetailPage.hoverToShoppingCart();
		Assert.assertTrue(userProductDetailPage.isProductNameInOrderDisplay(productName));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(processorUpdate));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(ramUpdate));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(hddUpdate));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(osUpdate));
		Assert.assertTrue(userProductDetailPage.isProductAttributeDisplay(softwareUpdate[0]));
		Assert.assertEquals(userProductDetailPage.getTotalPriceInShoppingCart(), totalPriceUpdate);
	}

	@Test
	public void TC_03_Remove_Product_From_Cart() {
		userShoppingCartPage = userProductDetailPage.clickToShoppingCart();
		userShoppingCartPage.clickToRemoveButtonByProductName(productName);
		Assert.assertEquals(userShoppingCartPage.getMessageSummaryContent(), "Your Shopping Cart is empty!");
		Assert.assertTrue(userShoppingCartPage.isProductUnDisplay());
	}

	@Test
	public void TC_04_Update_Shopping_Cart() {
		userShoppingCartPage.hoverToMenuLinkByName(menuName);
		userShoppingCartPage.clickToSubMenuLinkByName(subMenuName);

		userListProductPage = PageGeneratorManager.getUserListProductPO(driver);
		userProductDetailPage = userListProductPage.clickToProductName(productNameTwo);

		userProductDetailPage.clickToAddToCartButton();
		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your shopping cart");
		userProductDetailPage.clickToCloseMessageIcon();
		sleepInSecond(1);
		userShoppingCartPage = userProductDetailPage.clickToShoppingCart();
		Assert.assertEquals(userShoppingCartPage.getTotalPriceByName(productNameTwo), "$500.00");

		userShoppingCartPage.enterToQuantityTextBox(productNameTwo, "4");
		sleepInSecond(2);
		Assert.assertEquals(userShoppingCartPage.getTotalPriceByName(productNameTwo), "$2,000.00");

		userShoppingCartPage.clickToRemoveButtonByProductName(productNameTwo);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
