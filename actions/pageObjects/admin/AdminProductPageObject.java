package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminProductPageUI;

public class AdminProductPageObject extends BasePage {
	WebDriver driver;

	public AdminProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeyToElement(AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(AdminProductPageUI.SEARCH_BUTTON);
	}

	public int getCountProductInTable() {
		waitForElementVisible(AdminProductPageUI.PRODUCT_DISPPLAY);
		return getElementSize(AdminProductPageUI.PRODUCT_DISPPLAY);
	}

	public boolean isProductNameDisplayInTable(String productName) {
		waitForElementVisible(AdminProductPageUI.PRODUCT_NAME_DISPPLAY, productName);
		return isElementDisplay(AdminProductPageUI.PRODUCT_NAME_DISPPLAY, productName);
	}

	public void chooseCategoryInDropdown(String categoryName) {
		waitForElementClickable(AdminProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdownByVisibleText(AdminProductPageUI.CATEGORY_DROPDOWN, categoryName);
	}

	public String getMessageNoDataInTable() {
		waitForElementVisible(AdminProductPageUI.MESSAGE_NO_DATA);
		return getElementText(AdminProductPageUI.MESSAGE_NO_DATA);
	}

	public void checkedToSearchCategoriesCheckBox() {
		waitForElementClickable(AdminProductPageUI.SUB_CATEGORY_CHECKBOX);
		checkToDefaultCheckboxRadio(AdminProductPageUI.SUB_CATEGORY_CHECKBOX);
	}

	public void chooseManufacturerInDropdown(String manufacturerName) {
		waitForElementClickable(AdminProductPageUI.MANUFACTURER_NAME);
		selectItemInDropdownByVisibleText(AdminProductPageUI.MANUFACTURER_NAME, manufacturerName);
	}

	public void enterToGoDirectlyProductTextbox(String directlyProduct) {
		waitForElementVisible(AdminProductPageUI.GO_DIRECTLY_TO_PRODUCT_TEXTBOX);
		sendKeyToElement(AdminProductPageUI.GO_DIRECTLY_TO_PRODUCT_TEXTBOX, directlyProduct);
	}

	public AdminProductDetailPageObject clicktoGoButton() {
		waitForElementClickable(AdminProductPageUI.GO_BUTTON);
		checkToDefaultCheckboxRadio(AdminProductPageUI.GO_BUTTON);

		return PageGeneratorManager.getAdminProductDetailPage(driver);
	}

}
