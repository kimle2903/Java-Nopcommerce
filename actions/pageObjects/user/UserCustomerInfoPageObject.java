package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void chooseGenderRadiobutton(String gender) {
		waitForElementClickable(UserCustomerInfoPageUI.GENDER_RADIO_BUTTON);
		checkToDefaultCheckboxRadio(UserCustomerInfoPageUI.GENDER_RADIO_BUTTON);
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(UserCustomerInfoPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(UserCustomerInfoPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToCompanyTextBox(String company) {
		waitForElementVisible(UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(UserCustomerInfoPageUI.COMPANY_TEXTBOX, company);
	}

	public void chooseDateInDropdown(String day) {
		waitForElementClickable(UserCustomerInfoPageUI.DATE_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCustomerInfoPageUI.DATE_IN_DROPDOWN, day);
	}

	public void chooseMondayInDropdown(String month) {
		waitForElementClickable(UserCustomerInfoPageUI.MONTH_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCustomerInfoPageUI.MONTH_IN_DROPDOWN, month);
	}

	public void chooseYearInDropdown(String year) {
		waitForElementClickable(UserCustomerInfoPageUI.YEAR_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCustomerInfoPageUI.YEAR_IN_DROPDOWN, year);
	}

	public void clickToButtonSave() {
		waitForElementClickable(UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(UserCustomerInfoPageUI.SAVE_BUTTON);
	}

	public String getMessageUpdateSuccess() {
		waitForElementVisible(UserCustomerInfoPageUI.MESSAGE_UPDATE_SUCCESS);
		return getElementText(UserCustomerInfoPageUI.MESSAGE_UPDATE_SUCCESS);
	}

	public String getGenderInRadioButtonChecked(String attributeName) {
		waitForElementVisible(UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_CHECKED);
		return getElementAttribute(UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_CHECKED, attributeName);
	}

	public String getFirstNameInTextBox(String attributeName) {
		waitForElementVisible(UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}

	public String getLastNameInTextBox(String attributeName) {
		waitForElementVisible(UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(UserCustomerInfoPageUI.LASTNAME_TEXTBOX, attributeName);
	}

	public String getEmailInTextBox(String attributeName) {
		waitForElementVisible(UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(UserCustomerInfoPageUI.EMAIL_TEXTBOX, attributeName);
	}

	public String getCompanyInTextBox(String attributeName) {
		waitForElementVisible(UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(UserCustomerInfoPageUI.COMPANY_TEXTBOX, attributeName);
	}

	public String getDateInDropdown() {
		waitForElementVisible(UserCustomerInfoPageUI.DATE_IN_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(UserCustomerInfoPageUI.DATE_IN_DROPDOWN);
	}

	public String getMonthInDropdown() {
		waitForElementVisible(UserCustomerInfoPageUI.MONTH_IN_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(UserCustomerInfoPageUI.MONTH_IN_DROPDOWN);
	}

	public String getYearInDropdown() {
		waitForElementVisible(UserCustomerInfoPageUI.YEAR_IN_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(UserCustomerInfoPageUI.YEAR_IN_DROPDOWN);
	}

}
