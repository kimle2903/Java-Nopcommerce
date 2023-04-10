package pageObjects.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserCheckoutProductPageUI;
import pageUIs.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductDetailPageObject clickToEditLink() {
		waitForElementClickable(UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(UserShoppingCartPageUI.EDIT_LINK);

		return PageGeneratorManager.getUserProductDetailPO(driver);
	}

	public void clickToRemoveButtonByProductName(String productName) {
		waitForElementClickable(UserShoppingCartPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(UserShoppingCartPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
	}

	public String getMessageSummaryContent() {
		waitForElementVisible(UserShoppingCartPageUI.MESSAGE_SUMMARY_CONTENT);
		return getElementText(UserShoppingCartPageUI.MESSAGE_SUMMARY_CONTENT);
	}

	public boolean isProductUnDisplay() {
		waitForElementInVisible(UserShoppingCartPageUI.PRODUCT_INFO_IN_CART);
		return isElementUndisplay(UserShoppingCartPageUI.PRODUCT_INFO_IN_CART);
	}

	public String getTotalPriceByName(String productNameTwo) {
		waitForElementVisible(UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME, productNameTwo);
		return getElementText(UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME, productNameTwo);
	}

	public void enterToQuantityTextBox(String nameProduct, String number) {
		waitForElementVisible(UserShoppingCartPageUI.QUANLITY_BY_PRODUCT_NAME, nameProduct);
		sendKeyToElement(UserShoppingCartPageUI.QUANLITY_BY_PRODUCT_NAME, number, nameProduct);
		pressingByKey(Keys.ENTER);
	}

	public void clickToEstimateShipping() {
		waitForElementClickable(UserShoppingCartPageUI.ESTIMATE_SHIPPING);
		clickToElement(UserShoppingCartPageUI.ESTIMATE_SHIPPING);
	}

	public void chooseCountryInDropdownPopup(String country) {
		waitForElementClickable(UserShoppingCartPageUI.COUNTRY_IN_DROPDOWN_POPUP, country);
		selectItemInDropdownByVisibleText(UserShoppingCartPageUI.COUNTRY_IN_DROPDOWN_POPUP, country);
	}

	public void enterToPostalCodeTextBoxInPopup(String postalCode) {
		waitForElementVisible(UserShoppingCartPageUI.POSTAL_CODE_TEXTBOX_POPUP, postalCode);
		sendKeyToElement(UserShoppingCartPageUI.POSTAL_CODE_TEXTBOX_POPUP, postalCode);
	}

	public void clickToApplyButton() {
		waitForElementClickable(UserShoppingCartPageUI.APPLY_BUTTON);
		clickToElement(UserShoppingCartPageUI.APPLY_BUTTON);
	}

	public String getFeeShiping() {
		waitForElementVisible(UserShoppingCartPageUI.FEE_SHIPPING);
		return getElementText(UserShoppingCartPageUI.FEE_SHIPPING);
	}

	public String getFeeTax() {
		waitForElementVisible(UserCheckoutProductPageUI.FEE_TAX);
		return getElementText(UserCheckoutProductPageUI.FEE_TAX);
	}

	public void checkedToIAgreeCheckbox() {
		waitForElementClickable(UserShoppingCartPageUI.I_AGREE_CHECKOUT);
		checkToDefaultCheckboxRadio(UserShoppingCartPageUI.I_AGREE_CHECKOUT);
	}

	public UserCheckoutProductPageObject clickToCheckOutButton() {
		waitForElementClickable(UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(UserShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getUserCheckoutProductPO(driver);
	}

	public void clickToCloseButton() {
		waitForElementClickable(UserShoppingCartPageUI.CLOSE_BUTTON);
		clickToElement(UserShoppingCartPageUI.CLOSE_BUTTON);
	}

}
