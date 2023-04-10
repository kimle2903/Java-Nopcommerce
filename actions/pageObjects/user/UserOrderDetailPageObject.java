package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserOrderDetailPageUI;

public class UserOrderDetailPageObject extends BasePage {
	WebDriver driver;

	public UserOrderDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getOrderTotal() {
		waitForElementVisible(UserOrderDetailPageUI.ORDER_TOTAL);
		return getElementText(UserOrderDetailPageUI.ORDER_TOTAL);
	}

	public String getNameInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.NAME_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.NAME_IN_BILLING_INFO);
	}

	public String getEmailInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.EMAIL_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.EMAIL_IN_BILLING_INFO);
	}

	public String getPhoneInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.PHONE_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.PHONE_IN_BILLING_INFO);
	}

	public String getAddressOneInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.ADDRESS_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.ADDRESS_IN_BILLING_INFO);
	}

	public String getCityStateInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.CITY_STATE_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.CITY_STATE_IN_BILLING_INFO);
	}

	public String getCountryInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.COUNTRY_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.COUNTRY_IN_BILLING_INFO);
	}

	public String getPaymentMethodInBillingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.PAYMENT_IN_BILLING_INFO);
		return getElementText(UserOrderDetailPageUI.PAYMENT_IN_BILLING_INFO);
	}

	public String getNameInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.NAME_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.NAME_IN_SHIPPING_INFO);
	}

	public String getEmailInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.EMAIL_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.EMAIL_IN_SHIPPING_INFO);
	}

	public String getPhoneInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.PHONE_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.PHONE_IN_SHIPPING_INFO);
	}

	public String getAddressOneInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.ADDRESS_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.ADDRESS_IN_SHIPPING_INFO);
	}

	public String getCityStateInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.CITY_STATE_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.CITY_STATE_IN_SHIPPING_INFO);
	}

	public String getCountryInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.COUNTRY_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.COUNTRY_IN_SHIPPING_INFO);
	}

	public String getShippingMethodInShippingInfo() {
		waitForElementVisible(UserOrderDetailPageUI.SHIPPING_IN_SHIPPING_INFO);
		return getElementText(UserOrderDetailPageUI.SHIPPING_IN_SHIPPING_INFO);
	}

	public String getProductName() {
		waitForElementVisible(UserOrderDetailPageUI.PRODUCT_NAME);
		return getElementText(UserOrderDetailPageUI.PRODUCT_NAME);
	}

	public String getProductPrice() {
		waitForElementVisible(UserOrderDetailPageUI.PRODUCT_PRICE);
		return getElementText(UserOrderDetailPageUI.PRODUCT_PRICE);
	}

	public String getProductQuantity() {
		waitForElementVisible(UserOrderDetailPageUI.PRODUCT_QUANTITY);
		return getElementText(UserOrderDetailPageUI.PRODUCT_QUANTITY);
	}

	public String getProductTotalPrice() {
		waitForElementVisible(UserOrderDetailPageUI.PRODUCT_TOTAL);
		return getElementText(UserOrderDetailPageUI.PRODUCT_TOTAL);
	}

	public UserShoppingCartPageObject clickToReOrderButton() {
		waitForElementClickable(UserOrderDetailPageUI.RE_ORDER_BUTTON);
		clickToElement(UserOrderDetailPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPO(driver);
	}

}
