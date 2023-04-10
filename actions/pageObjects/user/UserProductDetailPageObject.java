package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductReviewPageObject clickToAddYouReviewLink() {
		waitForElementClickable(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);

		return PageGeneratorManager.getUserProductReviewPO(driver);
	}

	public void clickToAddToWishListLink() {
		waitForElementClickable(UserProductDetailPageUI.ADD_TO_WISHLIST_LINK);
		clickToElement(UserProductDetailPageUI.ADD_TO_WISHLIST_LINK);
	}

	public String getMessageSuccess() {
		waitForElementVisible(UserProductDetailPageUI.MESSAGE_ADD_TO_SUCCESS);
		return getElementText(UserProductDetailPageUI.MESSAGE_ADD_TO_SUCCESS);
	}

	public UserWishListPageObject clickToWishListLink() {
		waitForElementClickable(UserProductDetailPageUI.WISHLIST_LINK);
		clickToElement(UserProductDetailPageUI.WISHLIST_LINK);

		return PageGeneratorManager.getUserWishListPO(driver);
	}

	public void chooseProcessorDropdownByVisibleText(String processor) {
		waitForElementClickable(UserProductDetailPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdownByVisibleText(UserProductDetailPageUI.PROCESSOR_DROPDOWN, processor);

	}

	public void chooseRamDropdownByVisibleText(String ram) {
		waitForElementClickable(UserProductDetailPageUI.RAM_DROPDOWN);
		selectItemInDropdownByVisibleText(UserProductDetailPageUI.RAM_DROPDOWN, ram);
	}

	public void chooseHDDRadioButtonByName(String hdd) {
		waitForElementClickable(UserProductDetailPageUI.HDD_RADIO_BUTTON, hdd);
		checkToDefaultCheckboxRadio(UserProductDetailPageUI.HDD_RADIO_BUTTON, hdd);
	}

	public void chooseOSRadioButtonByName(String os) {
		waitForElementClickable(UserProductDetailPageUI.OS_RADIO_BUTTON, os);
		checkToDefaultCheckboxRadio(UserProductDetailPageUI.OS_RADIO_BUTTON, os);
	}

	public void chooseSoftwareCheckBoxByName(String[] softwares) {
		waitForAllElementVisible(UserProductDetailPageUI.SOFTWARE_CHECKBOX);
		unCheckToListDefaultCheckbox(UserProductDetailPageUI.SOFTWARE_CHECKBOX);

		for (String software : softwares) {
			waitForElementClickable(UserProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
			checkToDefaultCheckboxRadio(UserProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
		}
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(UserProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserProductDetailPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToCloseMessageIcon() {
		waitForElementClickable(UserProductDetailPageUI.CLOSE_ICON_AT_MESSAGE);
		clickToElement(UserProductDetailPageUI.CLOSE_ICON_AT_MESSAGE);
	}

	public void hoverToShoppingCart() {
		waitForElementVisible(UserProductDetailPageUI.SHOPPING_CART);
		hoverMouseToElement(UserProductDetailPageUI.SHOPPING_CART);
	}

	public boolean isProductNameInOrderDisplay(String productName) {
		waitForElementVisible(UserProductDetailPageUI.PRODUCT_NAME_IN_SHOPPING_CART, productName);
		return isElementDisplay(UserProductDetailPageUI.PRODUCT_NAME_IN_SHOPPING_CART, productName);
	}

	public boolean isProductAttributeDisplay(String valueAttrubute) {
		waitForElementVisible(UserProductDetailPageUI.ATTRIBUTE_PRODUCT_IN_SHOPPING_CART);
		return getElementText(UserProductDetailPageUI.ATTRIBUTE_PRODUCT_IN_SHOPPING_CART).contains(valueAttrubute);
	}

	public String getTotalPriceInShoppingCart() {
		waitForElementVisible(UserProductDetailPageUI.TOTAL_PRICE_IN_SHOPPING_CART);
		return getElementText(UserProductDetailPageUI.TOTAL_PRICE_IN_SHOPPING_CART);
	}

	public UserShoppingCartPageObject clickToShoppingCart() {
		waitForElementClickable(UserProductDetailPageUI.SHOPPING_CART);
		clickToElement(UserProductDetailPageUI.SHOPPING_CART);

		return PageGeneratorManager.getUserShoppingCartPO(driver);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(UserProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserProductDetailPageUI.ADD_TO_CART_BUTTON);

	}

}
