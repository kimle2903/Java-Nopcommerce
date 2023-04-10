package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserCompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameDisable(String productName) {
		waitForElementVisible(UserCompareProductPageUI.PRODUCT_NAME, productName);
		return isElementDisplay(UserCompareProductPageUI.PRODUCT_NAME, productName);
	}

	public boolean isPriceProductDisable(String priceNameOne) {
		waitForElementVisible(UserCompareProductPageUI.PRICE_PRODUCT, priceNameOne);
		return isElementDisplay(UserCompareProductPageUI.PRICE_PRODUCT, priceNameOne);
	}

	public void clickToClearListButton() {
		waitForElementVisible(UserCompareProductPageUI.CLEAR_LISH_BUTTON);
		clickToElement(UserCompareProductPageUI.CLEAR_LISH_BUTTON);
	}

	public String getMessageNotify() {
		waitForElementVisible(UserCompareProductPageUI.MESSAGE_NOTIFY);
		return getElementText(UserCompareProductPageUI.MESSAGE_NOTIFY);
	}

	public boolean isProductUnDisplay() {
		waitForElementInVisible(UserCompareProductPageUI.COMPARE_PRODUCT_TABLE);
		return isElementUndisplay(UserCompareProductPageUI.COMPARE_PRODUCT_TABLE);
	}

}
