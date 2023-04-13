package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminNewAddressPageUI;

public class AdminNewAddressPageObject extends BasePage {
	WebDriver driver;

	public AdminNewAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstNameTextBox(String firstNameUpate) {
		waitForElementVisible(AdminNewAddressPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.FIRSTNAME_TEXTBOX, firstNameUpate);
	}

	public void enterToLastNameTextBox(String lastNameUpdate) {
		waitForElementVisible(AdminNewAddressPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.LASTNAME_TEXTBOX, lastNameUpdate);
	}

	public void enterToEmailTextBox(String emailCustomerUpdate) {
		waitForElementVisible(AdminNewAddressPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.EMAIL_TEXTBOX, emailCustomerUpdate);
	}

	public void enterToCompanyTextBox(String companyNameUpdate) {
		waitForElementVisible(AdminNewAddressPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.COMPANY_TEXTBOX, companyNameUpdate);
	}

	public void chooseCountryInDropdown(String country) {
		waitForElementClickable(AdminNewAddressPageUI.COUNTRY_IN_DROPDOWN);
		selectItemInDropdownByVisibleText(AdminNewAddressPageUI.COUNTRY_IN_DROPDOWN, country);
	}

	public void enterToCountyTextBox(String county) {
		waitForElementVisible(AdminNewAddressPageUI.COUNTY_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.COUNTY_TEXTBOX, county);
	}

	public void enterToCityTextBox(String city) {
		waitForElementVisible(AdminNewAddressPageUI.CITY_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.CITY_TEXTBOX, city);
	}

	public void enterToAddress1TextBox(String address1) {
		waitForElementVisible(AdminNewAddressPageUI.ADDRESS_ONE_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.ADDRESS_ONE_TEXTBOX, address1);
	}

	public void enterToAddress2TextBox(String address2) {
		waitForElementVisible(AdminNewAddressPageUI.ADDRESS_TWO_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.ADDRESS_TWO_TEXTBOX, address2);
	}

	public void enterToPostalCodeTextBox(String postalCode) {
		waitForElementVisible(AdminNewAddressPageUI.POSTAL_CODE_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.POSTAL_CODE_TEXTBOX, postalCode);
	}

	public void enterToPhoneNumberTextBox(String phoneNumber) {
		waitForElementVisible(AdminNewAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void enterToFaxNumberTextBox(String faxNumber) {
		waitForElementVisible(AdminNewAddressPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(AdminNewAddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(AdminNewAddressPageUI.SAVE_BUTTON_ADD);
		clickToElement(AdminNewAddressPageUI.SAVE_BUTTON_ADD);
	}

	public Boolean isShowMessageSuccess(String message) {
		waitForElementVisible(AdminNewAddressPageUI.MESSAGE_SUCCESS);
		return getElementText(AdminNewAddressPageUI.MESSAGE_SUCCESS).contains(message);
	}

	public String getFirstNameTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailNameTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getCountryChooseInDropdown() {
		waitForElementVisible(AdminNewAddressPageUI.COUNTRY_IN_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(AdminNewAddressPageUI.COUNTRY_IN_DROPDOWN);
	}

	public String getCountyTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.COUNTY_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.COUNTY_TEXTBOX, "value");
	}

	public String getAddress1TextBox() {
		waitForElementVisible(AdminNewAddressPageUI.ADDRESS_ONE_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.ADDRESS_ONE_TEXTBOX, "value");
	}

	public String getAddress2TextBox() {
		waitForElementVisible(AdminNewAddressPageUI.ADDRESS_TWO_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.ADDRESS_TWO_TEXTBOX, "value");
	}

	public String getPostalCodeTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.POSTAL_CODE_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.POSTAL_CODE_TEXTBOX, "value");
	}

	public String getPhoneNumberTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.PHONE_NUMBER_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.PHONE_NUMBER_TEXTBOX, "value");
	}

	public String getFaxNumberTextBox() {
		waitForElementVisible(AdminNewAddressPageUI.FAX_NUMBER_TEXTBOX);
		return getElementAttribute(AdminNewAddressPageUI.FAX_NUMBER_TEXTBOX, "value");
	}

	public void clickToSaveEditButton() {
		waitForElementClickable(AdminNewAddressPageUI.SAVE_BUTTON_EDIT);
		clickToElement(AdminNewAddressPageUI.SAVE_BUTTON_EDIT);
	}

	public AdminCustomerPageObject clickToBackToCustomerList() {
		waitForElementClickable(AdminNewAddressPageUI.BACK_TO_CUSTOMER_DETAIL);
		clickToElement(AdminNewAddressPageUI.BACK_TO_CUSTOMER_DETAIL);
		return PageGeneratorManager.getAdminCustomerPO(driver);
	}

}
