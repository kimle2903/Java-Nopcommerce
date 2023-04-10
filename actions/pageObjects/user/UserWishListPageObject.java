package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserWishListPageUI;

public class UserWishListPageObject extends BasePage {
	WebDriver driver;

	public UserWishListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductAddWishListSuccess(String productName) {
		waitForElementVisible(UserWishListPageUI.PRODUCT_NAME_VIEWLIST);
		return isElementDisplay(UserWishListPageUI.PRODUCT_NAME_VIEWLIST, productName);
	}

	public void clickToYourWishListURLForShare() {
		waitForElementClickable(UserWishListPageUI.WISH_LIST_URL_FOR_SHARING);
		clickToElement(UserWishListPageUI.WISH_LIST_URL_FOR_SHARING);
	}

	public String getTitleWishListShare() {
		waitForElementVisible(UserWishListPageUI.TITLE_WISHLIST_SHARE);
		return getElementText(UserWishListPageUI.TITLE_WISHLIST_SHARE);
	}

	public String getTotalWishList() {
		waitForElementVisible(UserWishListPageUI.QUALITY_WISH_LIST);
		return getElementText(UserWishListPageUI.QUALITY_WISH_LIST);

	}

	public String getTotalShoppingCart() {
		waitForElementVisible(UserWishListPageUI.QUALITY_SHOPPING_CART);
		return getElementText(UserWishListPageUI.QUALITY_SHOPPING_CART);
	}

	public void clickToAddToCartCheckbox(String productName) {
		waitForElementClickable(UserWishListPageUI.ADD_TO_CART_CHECKBOX, productName);
		clickToElement(UserWishListPageUI.ADD_TO_CART_CHECKBOX, productName);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(UserWishListPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserWishListPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToRemoteButtonByProductName(String productName) {
		waitForElementClickable(UserWishListPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(UserWishListPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
	}

	public String getMessageNotify() {
		waitForElementVisible(UserWishListPageUI.MESSAGE_NOTIFY);
		return getElementText(UserWishListPageUI.MESSAGE_NOTIFY);
	}

	public boolean isProductByNameNotExistInWishList(String productName) {
		waitForElementInVisible(UserWishListPageUI.PRODUCT_NAME_VIEWLIST, productName);
		return isElementUndisplay(UserWishListPageUI.PRODUCT_NAME_VIEWLIST, productName);
	}

}
