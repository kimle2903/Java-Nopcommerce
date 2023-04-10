package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(UserAddressPageUI.ADD_NEW_BUTTON);
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(UserAddressPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(UserAddressPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(UserAddressPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToCompanyTextBox(String company) {
		waitForElementVisible(UserAddressPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.COMPANY_TEXTBOX, company);
	}

	public void chooseCountryInDropdown(String country) {
		waitForElementClickable(UserAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdownByVisibleText(UserAddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public void chooseProvinceInDropdown(String province) {
		waitForElementClickable(UserAddressPageUI.PROVINCE_DROPDOWN);
		selectItemInDropdownByVisibleText(UserAddressPageUI.PROVINCE_DROPDOWN, province);
	}

	public void enterToAddressOneTextBox(String address1) {
		waitForElementVisible(UserAddressPageUI.ADDRESS_ONE_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.ADDRESS_ONE_TEXTBOX, address1);
	}

	public void enterToCityTextBox(String city) {
		waitForElementVisible(UserAddressPageUI.CITY_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.CITY_TEXTBOX, city);
	}

	public void enterToAddressTwoTextBox(String address2) {
		waitForElementVisible(UserAddressPageUI.ADDRESS_TWO_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.ADDRESS_TWO_TEXTBOX, address2);
	}

	public void enterToPostalCodeTextBox(String postalCode) {
		waitForElementVisible(UserAddressPageUI.POSTAL_CODE_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.POSTAL_CODE_TEXTBOX, postalCode);
	}

	public void enterToPhoneNumberTextBox(String phoneNumber) {
		waitForElementVisible(UserAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void enterToFaxNumberTextBox(String faxNumber) {
		waitForElementVisible(UserAddressPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(UserAddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToButtonSave() {
		waitForElementClickable(UserAddressPageUI.SAVE_BUTTON);
		clickToElement(UserAddressPageUI.SAVE_BUTTON);
	}

	public String getNameInfo() {
		waitForElementVisible(UserAddressPageUI.NAME_INFO);
		return getElementText(UserAddressPageUI.NAME_INFO);
	}

	public String getEmailInfo() {
		waitForElementVisible(UserAddressPageUI.EMAIL_INFO);
		return getElementText(UserAddressPageUI.EMAIL_INFO);

	}

	public String getPhoneNumberInfo() {
		waitForElementVisible(UserAddressPageUI.PHONE_NUMBER_INFO);
		return getElementText(UserAddressPageUI.PHONE_NUMBER_INFO);

	}

	public String getFaxNumberInfo() {
		waitForElementVisible(UserAddressPageUI.FAX_NUMBER_INFO);
		return getElementText(UserAddressPageUI.FAX_NUMBER_INFO);

	}

	public String getCompanyInfo() {
		waitForElementVisible(UserAddressPageUI.COMPANY_INFO);
		return getElementText(UserAddressPageUI.COMPANY_INFO);

	}

	public String getAddressOneInfo() {
		waitForElementVisible(UserAddressPageUI.ADDRESS_ONE_INFO);
		return getElementText(UserAddressPageUI.ADDRESS_ONE_INFO);
	}

	public String getAddressTwoInfo() {
		waitForElementVisible(UserAddressPageUI.ADDRESS_TWO_INFO);
		return getElementText(UserAddressPageUI.ADDRESS_TWO_INFO);
	}

	public String getCityStateInfo() {
		waitForElementVisible(UserAddressPageUI.CITY_STATE_INFO);
		return getElementText(UserAddressPageUI.CITY_STATE_INFO);
	}

	public String getCountryInfo() {
		waitForElementVisible(UserAddressPageUI.COUNTRY_INFO);
		return getElementText(UserAddressPageUI.COUNTRY_INFO);
	}

	public String getMessageAddSuccess() {
		waitForElementVisible(UserAddressPageUI.MESSAGE_ADD_SUCCESS);
		return getElementText(UserAddressPageUI.MESSAGE_ADD_SUCCESS);
	}

}
