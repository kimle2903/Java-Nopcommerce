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
import pageObjects.user.UserCheckoutProductPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderDetailPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserShoppingCartPageObject;

public class Order_02_Handle_CheckOut_Cart extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserListProductPageObject userListProductPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserCheckoutProductPageObject userCheckoutProductPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserOrdersPageObject userOrderPO;
	private UserOrderDetailPageObject userOrderDetailPage;

	private WebDriver driver;
	private String menuName, subMenuName, productName, productPrice, quantity, feeShipping, feeTax;
	private String country, countryName, province, postalCode, city, addressOne, addressUpdate, phoneNumber, shippingMethod, shippingMethodUpdate, nameMethodShipping, paymentMethod, orderNumber;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		menuName = "Computers";
		subMenuName = "Desktops";
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		productPrice = "$500.00";
		quantity = "1";
		country = "Viet Nam";
		countryName = "United States";
		province = "Indiana";
		postalCode = "123456";
		city = "Ha noi";
		addressOne = "Thanh xuan, ha dong";
		addressUpdate = "171 Thanh xuan";
		phoneNumber = "0345556666";
		shippingMethod = "Ground ($0.00)";
		shippingMethodUpdate = "Next Day Air ($0.00)";
		nameMethodShipping = "Ground";
		paymentMethod = "Check / Money Order";

		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);
		userLoginPage.enterToPasswordTextBox(Common_01_User_Register_With_Email_And_Password.password);
		userLoginPage.clickToLoginButton();

		userLoginPage.hoverToMenuLinkByName(menuName);
		userLoginPage.clickToSubMenuLinkByName(subMenuName);

		userListProductPage = PageGeneratorManager.getUserListProductPO(driver);
		userProductDetailPage = userListProductPage.clickToProductName(productName);

		userProductDetailPage.clickToAddToCartButton();
		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your shopping cart");
		userProductDetailPage.clickToCloseMessageIcon();
		sleepInSecond(1);
		userShoppingCartPage = userProductDetailPage.clickToShoppingCart();
	}

	@Test
	public void TC_05_Checkout_Order() {
		userShoppingCartPage.clickToEstimateShipping();
		userShoppingCartPage.chooseCountryInDropdownPopup(country);
		userShoppingCartPage.enterToPostalCodeTextBoxInPopup(postalCode);
		userShoppingCartPage.clickToApplyButton();
		userShoppingCartPage.clickToCloseButton();

		sleepInSecond(2);
		feeShipping = userShoppingCartPage.getFeeShiping();
		feeTax = userShoppingCartPage.getFeeTax();

		userShoppingCartPage.checkedToIAgreeCheckbox();
		userCheckoutProductPage = userShoppingCartPage.clickToCheckOutButton();

		userCheckoutProductPage.chooseCountryDropdown(countryName);
		userCheckoutProductPage.chooseCountryProvince(province);
		userCheckoutProductPage.enterToCityTextBox(city);
		userCheckoutProductPage.enterToAddressOneTextBox(addressOne);
		userCheckoutProductPage.enterToPostalCodeTextBox(postalCode);
		userCheckoutProductPage.enterToPhoneNumberTextBox(phoneNumber);
		userCheckoutProductPage.clickToContinueButtonBillingAddress();

		userCheckoutProductPage.chooseShippingMethodInRadioButton(shippingMethod);
		userCheckoutProductPage.clickToContinueButtonInShipping();

		userCheckoutProductPage.choosePaymentMethodInRadioButton(paymentMethod);
		userCheckoutProductPage.clickToContinueButtonInPayment();

		Assert.assertTrue(userCheckoutProductPage.isPaymentInfoDisplay());
		userCheckoutProductPage.clickToContinueButtonInPaymentInfo();

		Assert.assertEquals(userCheckoutProductPage.getNameInBillingInfo(), Common_01_User_Register_With_Email_And_Password.firstName + " " + Common_01_User_Register_With_Email_And_Password.lastName);
		Assert.assertEquals(userCheckoutProductPage.getEmailInBillingInfo(), "Email: " + Common_01_User_Register_With_Email_And_Password.email);
		Assert.assertEquals(userCheckoutProductPage.getPhoneInBillingInfo(), "Phone: " + phoneNumber);
		Assert.assertEquals(userCheckoutProductPage.getAddressOneInBillingInfo(), addressOne);
		Assert.assertEquals(userCheckoutProductPage.getCityStateInBillingInfo(), city + "," + province + "," + postalCode);
		Assert.assertEquals(userCheckoutProductPage.getCountryInBillingInfo(), countryName);
		Assert.assertEquals(userCheckoutProductPage.getPaymentMethodInBillingInfo(), paymentMethod);

		Assert.assertEquals(userCheckoutProductPage.getNameInShippingInfo(), Common_01_User_Register_With_Email_And_Password.firstName + " " + Common_01_User_Register_With_Email_And_Password.lastName);
		Assert.assertEquals(userCheckoutProductPage.getEmailInShippingInfo(), "Email: " + Common_01_User_Register_With_Email_And_Password.email);
		Assert.assertEquals(userCheckoutProductPage.getPhoneInShippingInfo(), "Phone: " + phoneNumber);
		Assert.assertEquals(userCheckoutProductPage.getAddressOneInShippingInfo(), addressOne);
		Assert.assertEquals(userCheckoutProductPage.getCityStateInShippingInfo(), city + "," + province + "," + postalCode);
		Assert.assertEquals(userCheckoutProductPage.getCountryInShippingInfo(), countryName);
		Assert.assertEquals(userCheckoutProductPage.getShippingMethodInShippingInfo(), nameMethodShipping);

		Assert.assertEquals(userCheckoutProductPage.getProductName(), productName);
		Assert.assertEquals(userCheckoutProductPage.getProductPrice(), productPrice);
		Assert.assertEquals(userCheckoutProductPage.getProductQuantity(), quantity);

		Assert.assertEquals(userCheckoutProductPage.getProductTotalPrice(), productPrice);

		Assert.assertEquals(userCheckoutProductPage.geSubTotalCheckout(), productPrice);
		Assert.assertEquals(userCheckoutProductPage.getFeeShippingInConfirmOrder(), feeShipping);
		Assert.assertEquals(userCheckoutProductPage.getFeeTaxInConfirmOrder(), feeTax);
		Assert.assertEquals(userCheckoutProductPage.getTotalOrder(), productPrice);

		userCheckoutProductPage.clickToConfirmButton();

		Assert.assertEquals(userCheckoutProductPage.getTitleOrderSuccess(), "Thank you");
		Assert.assertEquals(userCheckoutProductPage.getMessageOrderSuccess(), "Your order has been successfully processed!");
		Assert.assertTrue(userCheckoutProductPage.isOrderNumberDisplay());
		orderNumber = userCheckoutProductPage.getOrderNumber();
		userCheckoutProductPage.clickToContinueButtonInCheckout();

		userHomePage = PageGeneratorManager.getUserHomePO(driver);
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();

		userCustomerInfoPage.openPageByNameAtSizeBar("Orders");
		userOrderPO = PageGeneratorManager.getUserOrdersPO(driver);
		Assert.assertEquals(userOrderPO.getOrderNumber().toUpperCase(), orderNumber);

		userOrderDetailPage = userOrderPO.clickToDetailLink();
		Assert.assertEquals(userOrderDetailPage.getOrderTotal(), productPrice);

		Assert.assertEquals(userOrderDetailPage.getNameInBillingInfo(), Common_01_User_Register_With_Email_And_Password.firstName + " " + Common_01_User_Register_With_Email_And_Password.lastName);
		Assert.assertEquals(userOrderDetailPage.getEmailInBillingInfo(), "Email: " + Common_01_User_Register_With_Email_And_Password.email);
		Assert.assertEquals(userOrderDetailPage.getPhoneInBillingInfo(), "Phone: " + phoneNumber);
		Assert.assertEquals(userOrderDetailPage.getAddressOneInBillingInfo(), addressOne);
		Assert.assertEquals(userOrderDetailPage.getCityStateInBillingInfo(), city + "," + province + "," + postalCode);
		Assert.assertEquals(userOrderDetailPage.getCountryInBillingInfo(), countryName);
		Assert.assertEquals(userOrderDetailPage.getPaymentMethodInBillingInfo(), paymentMethod);

		Assert.assertEquals(userOrderDetailPage.getNameInShippingInfo(), Common_01_User_Register_With_Email_And_Password.firstName + " " + Common_01_User_Register_With_Email_And_Password.lastName);
		Assert.assertEquals(userOrderDetailPage.getEmailInShippingInfo(), "Email: " + Common_01_User_Register_With_Email_And_Password.email);
		Assert.assertEquals(userOrderDetailPage.getPhoneInShippingInfo(), "Phone: " + phoneNumber);
		Assert.assertEquals(userOrderDetailPage.getAddressOneInShippingInfo(), addressOne);
		Assert.assertEquals(userOrderDetailPage.getCityStateInShippingInfo(), city + "," + province + "," + postalCode);
		Assert.assertEquals(userOrderDetailPage.getCountryInShippingInfo(), countryName);
		Assert.assertEquals(userOrderDetailPage.getShippingMethodInShippingInfo(), nameMethodShipping);

		Assert.assertEquals(userOrderDetailPage.getProductName(), productName);
		Assert.assertEquals(userOrderDetailPage.getProductPrice(), productPrice);
		Assert.assertEquals(userOrderDetailPage.getProductQuantity(), quantity);

		Assert.assertEquals(userOrderDetailPage.getProductTotalPrice(), productPrice);

	}

	// @Test
	public void TC_06_Checkout_Order_By_Cart() {

	}

	@Test
	public void TC_07_ReOrder() {
		userShoppingCartPage = userOrderDetailPage.clickToReOrderButton();
		userShoppingCartPage.enterToQuantityTextBox(productName, "2");
		userShoppingCartPage.checkedToIAgreeCheckbox();
		userCheckoutProductPage = userShoppingCartPage.clickToCheckOutButton();
		userCheckoutProductPage.clickToEditButton();
		userCheckoutProductPage.enterToAddressOneTextBox(addressUpdate);
		userCheckoutProductPage.clickToSaveButtonInBillingAdress();
		userCheckoutProductPage.clickToContinueButtonInBillingAdress();

		userCheckoutProductPage.chooseShippingMethodInRadioButton(shippingMethodUpdate);
		userCheckoutProductPage.clickToContinueButtonInShipping();
		userCheckoutProductPage.clickToContinueButtonInPayment();
		userCheckoutProductPage.clickToContinueButtonInPaymentInfo();

		Assert.assertEquals(userCheckoutProductPage.getAddressOneInBillingInfo(), addressUpdate);
		Assert.assertEquals(userCheckoutProductPage.getAddressOneInShippingInfo(), addressUpdate);

		userCheckoutProductPage.clickToConfirmButton();

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
