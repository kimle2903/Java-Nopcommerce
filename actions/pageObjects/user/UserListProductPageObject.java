package pageObjects.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserListProductPageUI;

public class UserListProductPageObject extends BasePage {
	WebDriver driver;

	public UserListProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductDetailPageObject clickToProductName(String productReviewName) {
		waitForElementClickable(UserListProductPageUI.PRODUCT_NAME, productReviewName);
		clickToElement(UserListProductPageUI.PRODUCT_NAME, productReviewName);

		return PageGeneratorManager.getUserProductDetailPO(driver);
	}

	public String getPriceProductByName(String productName) {
		waitForElementVisible(UserListProductPageUI.PRICE_PRODUCT, productName);
		return getElementText(UserListProductPageUI.PRICE_PRODUCT, productName);
	}

	public void clickToAddToCompareButton(String productName) {
		waitForElementClickable(UserListProductPageUI.ADD_TO_COMPARE_BUTTON, productName);
		clickToElement(UserListProductPageUI.ADD_TO_COMPARE_BUTTON, productName);
	}

	public String getMessageAddToCompareSuccess() {
		waitForElementVisible(UserListProductPageUI.MESSAGE_ADD_TO_COMPARE_SUCCESS);
		return getElementText(UserListProductPageUI.MESSAGE_ADD_TO_COMPARE_SUCCESS);
	}

	public UserCompareProductPageObject clickToProductCompareLink() {
		waitForElementClickable(UserListProductPageUI.PRODUCT_COMPARE_LINK_IN_MESSAGE);
		clickToElement(UserListProductPageUI.PRODUCT_COMPARE_LINK_IN_MESSAGE);
		return PageGeneratorManager.getUserConpareProductPO(driver);
	}

	public void clickListViewProduct(String[] arrProductName) {
		for (String productName : arrProductName) {
			waitForElementClickable(UserListProductPageUI.PRODUCT_NAME, productName);
			clickToElement(UserListProductPageUI.PRODUCT_NAME, productName);
			backToPage();
		}
	}

	public void chooseSortInDropdownByVisibleText(String value) {
		waitForElementClickable(UserListProductPageUI.SORT_BY_DROPDOWN);
		selectItemInDropdownByVisibleText(UserListProductPageUI.SORT_BY_DROPDOWN, value);
	}

	public List<String> getAllProductName() {
		waitForAllElementVisible(UserListProductPageUI.LIST_PRODUCT_NAME);
		List<WebElement> elements = getListWebElement(UserListProductPageUI.LIST_PRODUCT_NAME);
		List<String> arrProductName = new ArrayList<String>();

		for (WebElement element : elements) {
			arrProductName.add(element.getText());
		}
		return arrProductName;
	}

	public List<Float> getAllProducePrice() {
		waitForAllElementVisible(UserListProductPageUI.LIST_PRICE_PRODUCT);
		List<WebElement> elements = getListWebElement(UserListProductPageUI.LIST_PRICE_PRODUCT);
		List<Float> arrProductPrice = new ArrayList<Float>();

		for (WebElement element : elements) {
			arrProductPrice.add(Float.parseFloat(element.getText().replace("$", "").replace(".", "").replace(",", "")));
		}
		return arrProductPrice;
	}

	public void chooseDisplayDropdownByVisibleText(String value) {
		waitForElementClickable(UserListProductPageUI.DISPLAY_DROPDOWN);
		selectItemInDropdownByVisibleText(UserListProductPageUI.DISPLAY_DROPDOWN, value);
	}

	public boolean isProductDisplayByNumber(int numberProduct) {
		waitForAllElementVisible(UserListProductPageUI.LIST_PRODUCT_NAME);
		int totalProductDisplay = getElementSize(UserListProductPageUI.LIST_PRODUCT_NAME);
		System.out.println("totalProductDisplay " + numberProduct + " : " + totalProductDisplay);
		if (totalProductDisplay <= numberProduct) {
			return true;
		}
		return false;
	}

	public String getCurrentPage() {
		waitForElementVisible(UserListProductPageUI.CURRENT_PAGE);
		return getElementText(UserListProductPageUI.CURRENT_PAGE);
	}

	public boolean isIconNextPageDisplay() {
		waitForElementVisible(UserListProductPageUI.NEXT_PAGE);
		return isElementDisplay(UserListProductPageUI.NEXT_PAGE);
	}

	public void clickToIconNextPage() {
		waitForElementClickable(UserListProductPageUI.NEXT_PAGE);
		clickToElement(UserListProductPageUI.NEXT_PAGE);
	}

	public boolean isIconPreviousDisplay() {
		waitForElementVisible(UserListProductPageUI.PRIVIOUS_PAGE);
		return isElementDisplay(UserListProductPageUI.PRIVIOUS_PAGE);
	}

	public boolean isUnDisplayPaging() {
		waitForElementInVisible(UserListProductPageUI.PAGING);
		return isElementUndisplay(UserListProductPageUI.PAGING);
	}

}
