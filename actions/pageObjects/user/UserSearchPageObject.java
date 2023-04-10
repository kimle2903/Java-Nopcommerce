package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getErrorMessage() {
		waitForElementVisible(UserSearchPageUI.ERROR_MESSAGE);
		return getElementText(UserSearchPageUI.ERROR_MESSAGE);
	}

	public void enterToSearchKeyword(String keyword) {
		waitForElementVisible(UserSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(UserSearchPageUI.SEARCH_TEXTBOX, keyword);
	}

	public String getMessageResultSearch() {
		waitForElementVisible(UserSearchPageUI.MESSAGE_RESULT_SEARCH);
		return getElementText(UserSearchPageUI.MESSAGE_RESULT_SEARCH);
	}

	public int countProductSearchResult() {
		waitForAllElementVisible(UserSearchPageUI.PRODUCT_NAME_RESULT);
		return getElementSize(UserSearchPageUI.PRODUCT_NAME_RESULT);
	}

	public boolean isResultIncludeRelativeProductName(String productNameRelative) {
		List<WebElement> elements = getListWebElement(UserSearchPageUI.PRODUCT_NAME_RESULT);
		Boolean check = true;
		for (WebElement element : elements) {
			if (!element.getText().contains(productNameRelative)) {
				check = false;
				return check;
			}
		}
		return check;
	}

	public String getTextProductSearchResult() {
		waitForElementVisible(UserSearchPageUI.PRODUCT_NAME_RESULT);
		return getElementText(UserSearchPageUI.PRODUCT_NAME_RESULT);
	}

	public void checkedToAdvancedSearchCheckbox() {
		waitForElementClickable(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkToDefaultCheckboxRadio(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void chooseCategoryInDropdown(String category) {
		waitForElementVisible(UserSearchPageUI.CATEGORY_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(UserSearchPageUI.CATEGORY_IN_DROPDOWN, category);
	}

	public void checkedToAutomaticallySearch() {
		waitForElementClickable(UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		checkToDefaultCheckboxRadio(UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);

	}

	public void chooseManufacturerInDropdown(String Manufacturer) {
		waitForElementVisible(UserSearchPageUI.MANUFACTURER_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(UserSearchPageUI.MANUFACTURER_IN_DROPDOWN, Manufacturer);
	}

}
