package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserCheckoutProductPageUI;

public class UserCheckoutProductPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void chooseCountryDropdown(String country) {
		waitForElementClickable(UserCheckoutProductPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCheckoutProductPageUI.COUNTRY_DROPDOWN, country);
	}

	public void chooseCountryProvince(String province) {
		waitForElementClickable(UserCheckoutProductPageUI.PROVINCE_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCheckoutProductPageUI.PROVINCE_DROPDOWN, province);
	}

	public void enterToCityTextBox(String city) {
		waitForElementVisible(UserCheckoutProductPageUI.CITY_TEXTBOX);
		sendKeyToElement(UserCheckoutProductPageUI.CITY_TEXTBOX, city);
	}

	public void enterToAddressOneTextBox(String addressOne) {
		waitForElementVisible(UserCheckoutProductPageUI.ADDRESS_ONE_TEXTBOX);
		sendKeyToElement(UserCheckoutProductPageUI.ADDRESS_ONE_TEXTBOX, addressOne);
	}

	public void enterToPostalCodeTextBox(String postalCode) {
		waitForElementVisible(UserCheckoutProductPageUI.POSTAL_CODE_TEXTBOX);
		sendKeyToElement(UserCheckoutProductPageUI.POSTAL_CODE_TEXTBOX, postalCode);
	}

	public void enterToPhoneNumberTextBox(String phoneNumber) {
		waitForElementVisible(UserCheckoutProductPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(UserCheckoutProductPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void chooseShippingMethodInRadioButton(String shippingMethod) {
		waitForElementClickable(UserCheckoutProductPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
		checkToDefaultCheckboxRadio(UserCheckoutProductPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
	}

	public void choosePaymentMethodInRadioButton(String paymentMethod) {
		waitForElementClickable(UserCheckoutProductPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);
		checkToDefaultCheckboxRadio(UserCheckoutProductPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);
	}

	public boolean isPaymentInfoDisplay() {
		waitForElementVisible(UserCheckoutProductPageUI.PAYMENT_INFO_TEXT);
		return isElementDisplay(UserCheckoutProductPageUI.PAYMENT_INFO_TEXT);
	}

	public String getNameInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.NAME_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.NAME_IN_BILLING_INFO);
	}

	public String getEmailInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.EMAIL_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.EMAIL_IN_BILLING_INFO);
	}

	public String getPhoneInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.PHONE_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.PHONE_IN_BILLING_INFO);
	}

	public String getAddressOneInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.ADDRESS_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.ADDRESS_IN_BILLING_INFO);
	}

	public String getCityStateInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.CITY_STATE_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.CITY_STATE_IN_BILLING_INFO);
	}

	public String getCountryInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.COUNTRY_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.COUNTRY_IN_BILLING_INFO);
	}

	public String getPaymentMethodInBillingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.PAYMENT_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.PAYMENT_IN_BILLING_INFO);
	}

	public String getNameInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.NAME_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.NAME_IN_SHIPPING_INFO);
	}

	public String getEmailInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.EMAIL_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.EMAIL_IN_SHIPPING_INFO);
	}

	public String getPhoneInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.PHONE_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.PHONE_IN_SHIPPING_INFO);
	}

	public String getAddressOneInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.ADDRESS_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.ADDRESS_IN_SHIPPING_INFO);
	}

	public String getCityStateInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.CITY_STATE_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.CITY_STATE_IN_SHIPPING_INFO);
	}

	public String getCountryInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.COUNTRY_IN_SHIPPING_INFO);
		return getElementText(UserCheckoutProductPageUI.COUNTRY_IN_SHIPPING_INFO);
	}

	public String getShippingMethodInShippingInfo() {
		waitForElementVisible(UserCheckoutProductPageUI.SHIPPING_IN_BILLING_INFO);
		return getElementText(UserCheckoutProductPageUI.SHIPPING_IN_BILLING_INFO);
	}

	public String getProductName() {
		waitForElementVisible(UserCheckoutProductPageUI.PRODUCT_NAME);
		return getElementText(UserCheckoutProductPageUI.PRODUCT_NAME);
	}

	public String getProductPrice() {
		waitForElementVisible(UserCheckoutProductPageUI.PRODUCT_PRICE);
		return getElementText(UserCheckoutProductPageUI.PRODUCT_PRICE);
	}

	public String getProductQuantity() {
		waitForElementVisible(UserCheckoutProductPageUI.PRODUCT_QUANTITY);
		return getElementText(UserCheckoutProductPageUI.PRODUCT_QUANTITY);
	}

	public String getProductTotalPrice() {
		waitForElementVisible(UserCheckoutProductPageUI.PRODUCT_PRICE);
		return getElementText(UserCheckoutProductPageUI.PRODUCT_PRICE);
	}

	public String geSubTotalCheckout() {
		waitForElementVisible(UserCheckoutProductPageUI.SUB_TOTAL);
		return getElementText(UserCheckoutProductPageUI.SUB_TOTAL);
	}

	public String getFeeShippingInConfirmOrder() {
		waitForElementVisible(UserCheckoutProductPageUI.FEE_SHIPPING);
		return getElementText(UserCheckoutProductPageUI.FEE_SHIPPING);
	}

	public String getFeeTaxInConfirmOrder() {
		waitForElementVisible(UserCheckoutProductPageUI.FEE_TAX);
		return getElementText(UserCheckoutProductPageUI.FEE_TAX);
	}

	public String getTotalOrder() {
		waitForElementVisible(UserCheckoutProductPageUI.ORDER_TOTAL);
		return getElementText(UserCheckoutProductPageUI.ORDER_TOTAL);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(UserCheckoutProductPageUI.CONFIRM_BUTTON);
		clickToElement(UserCheckoutProductPageUI.CONFIRM_BUTTON);

	}

	public String getTitleOrderSuccess() {
		waitForElementVisible(UserCheckoutProductPageUI.TITLE_ORDER_SUCCESS);
		return getElementText(UserCheckoutProductPageUI.TITLE_ORDER_SUCCESS);
	}

	public String getMessageOrderSuccess() {
		waitForElementVisible(UserCheckoutProductPageUI.CONTENT_ORDER_SUCCESS);
		return getElementText(UserCheckoutProductPageUI.CONTENT_ORDER_SUCCESS);
	}

	public boolean isOrderNumberDisplay() {
		waitForElementVisible(UserCheckoutProductPageUI.ORDER_NUMBER);
		return isElementDisplay(UserCheckoutProductPageUI.ORDER_NUMBER);
	}

	public String getOrderNumber() {
		waitForElementVisible(UserCheckoutProductPageUI.ORDER_NUMBER);
		return getElementText(UserCheckoutProductPageUI.ORDER_NUMBER);
	}

	public void clickToContinueButtonInShipping() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_IN_SHIPPING_BUTTON);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_IN_SHIPPING_BUTTON);
	}

	public void clickToContinueButtonInPayment() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_IN_PAYMENT__BUTTON);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_IN_PAYMENT__BUTTON);
	}

	public void clickToContinueButtonInPaymentInfo() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_IN_PAYMENT_INFO_BUTTON);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_IN_PAYMENT_INFO_BUTTON);
	}

	public void clickToContinueButtonInCheckout() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_IN_CHECKOUT);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_IN_CHECKOUT);
	}

	public void clickToContinueButtonBillingAddress() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_IN_BIBLING_BUTTON);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_IN_BIBLING_BUTTON);
	}

	public void clickToEditButton() {
		waitForElementClickable(UserCheckoutProductPageUI.EDIT_BUTTON_IN_BILLING);
		clickToElement(UserCheckoutProductPageUI.EDIT_BUTTON_IN_BILLING);
	}

	public void clickToSaveButtonInBillingAdress() {
		waitForElementClickable(UserCheckoutProductPageUI.SAVE_BUTTON_IN_BILLING);
		clickToElement(UserCheckoutProductPageUI.SAVE_BUTTON_IN_BILLING);
	}

	public void clickToContinueButtonInBillingAdress() {
		waitForElementClickable(UserCheckoutProductPageUI.CONTINUE_BUTTON_IN_BILLING);
		clickToElement(UserCheckoutProductPageUI.CONTINUE_BUTTON_IN_BILLING);
	}

}
