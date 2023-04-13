package pageObjects.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminCustomerPageUI;

public class AdminCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(AdminCustomerPageUI.ADD_NEW_BUTTON);
		clickToElement(AdminCustomerPageUI.ADD_NEW_BUTTON);
	}

	public void enterToEmailTextbox(String emailCustomer) {
		waitForElementVisible(AdminCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.EMAIL_TEXTBOX, emailCustomer);
	}

	public void enterToPasswordTextbox(String passwordCustomer) {
		waitForElementVisible(AdminCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.PASSWORD_TEXTBOX, passwordCustomer);

	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(AdminCustomerPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(AdminCustomerPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void chooseGenderInRadioButton(String gender) {
		waitForElementClickable(AdminCustomerPageUI.GENDER_RADIO_BUTTON, gender);
		checkToDefaultCheckboxRadio(AdminCustomerPageUI.GENDER_RADIO_BUTTON, gender);
	}

	public void enterToDateOfBirthTextbox(String dateOfBirth) {
		waitForElementVisible(AdminCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void enterToCompanyNameTextbox(String companyName) {
		waitForElementVisible(AdminCustomerPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(AdminCustomerPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void chooseNewsletteInDropdown(String newslette) {
		waitForElementVisible(AdminCustomerPageUI.NEWSLETE_DROPDOWN);
		selectItemInCustomDropdown(AdminCustomerPageUI.NEWSLETE_DROPDOWN, AdminCustomerPageUI.OPTION_IN_NEWSLETE_DROPDOWN, newslette);
	}

	public void chooseCustomerRoleInDropdown(String customerRole) {
		waitForElementVisible(AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN);
		selectItemInCustomDropdown(AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN, AdminCustomerPageUI.OPTION_IN_CUSTOMER_ROLE, customerRole);
	}

	public void chooseManageOfVendorInDropdown(String managerOfVendor) {
		waitForElementClickable(AdminCustomerPageUI.MANAGER_OF_VENDOR_DROPDOWN, managerOfVendor);
		selectItemInDropdownByVisibleText(AdminCustomerPageUI.MANAGER_OF_VENDOR_DROPDOWN, managerOfVendor);

	}

	public void checkedToActiveCheckbox() {
		waitForElementClickable(AdminCustomerPageUI.ACTIVE_CHECKBOX);
		checkToDefaultCheckboxRadio(AdminCustomerPageUI.ACTIVE_CHECKBOX);
	}

	public void enterToAdminCommentTextAreaa(String adminComment) {
		waitForElementVisible(AdminCustomerPageUI.ADMIN_COMMENT);
		sendKeyToElement(AdminCustomerPageUI.ADMIN_COMMENT, adminComment);
	}

	public void clickToSaveAndContinueEditButton() {
		waitForElementClickable(AdminCustomerPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		checkToDefaultCheckboxRadio(AdminCustomerPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
	}

	public Boolean isMessageSuccessDisplay(String valueText) {
		waitForElementVisible(AdminCustomerPageUI.MESSAGE_SUCCESS);
		return getElementText(AdminCustomerPageUI.MESSAGE_SUCCESS).contains(valueText);
	}

	public String getEmailOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(AdminCustomerPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getFirstNameOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(AdminCustomerPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(AdminCustomerPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getDateOfBirthOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		return getElementAttribute(AdminCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, "value");
	}

	public String getCompanyNameOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(AdminCustomerPageUI.COMPANY_TEXTBOX, "value");
	}

	public Boolean isNewSleteDisplay(String newslete) {
		waitForElementVisible(AdminCustomerPageUI.NEWSLETE_VERIFY);
		return getElementText(AdminCustomerPageUI.NEWSLETE_VERIFY).contains(newslete);
	}

	public Boolean isCustomerRoleDisplay(String customerRole) {
		waitForElementVisible(AdminCustomerPageUI.CUSTOMER_ROLE_VERIFY);
		return getElementText(AdminCustomerPageUI.CUSTOMER_ROLE_VERIFY).contains(customerRole);
	}

	public String getManagerOfVendorOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.MANAGER_OF_VENDOR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(AdminCustomerPageUI.MANAGER_OF_VENDOR_DROPDOWN);
	}

	public String getAdminCommentOfCustomer() {
		waitForElementVisible(AdminCustomerPageUI.ADMIN_COMMENT);
		return getElementText(AdminCustomerPageUI.ADMIN_COMMENT);

	}

	public void clickToBackToCustomerListLink() {
		waitForElementClickable(AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
	}

	public void enterToEmailTextBoxSearch(String emailCustomer) {
		waitForElementVisible(AdminCustomerPageUI.EMAIL_TEXTBOX_SEARCH);
		sendKeyToElement(AdminCustomerPageUI.EMAIL_TEXTBOX_SEARCH, emailCustomer);
	}

	public void enterToFirstNameTextBoxSearch(String firstName) {
		waitForElementVisible(AdminCustomerPageUI.FIRSTNAME_TEXTBOX_SEARCH);
		sendKeyToElement(AdminCustomerPageUI.FIRSTNAME_TEXTBOX_SEARCH, firstName);
	}

	public void enterToLastNameTextBoxSearch(String lastName) {
		waitForElementVisible(AdminCustomerPageUI.LASTNAME_TEXTBOX_SEARCH);
		sendKeyToElement(AdminCustomerPageUI.LASTNAME_TEXTBOX_SEARCH, lastName);
	}

	public void enterToMonthDropdownSearch(String month) {
		waitForElementVisible(AdminCustomerPageUI.MONTH_TEXTBOX_SEARCH);
		selectItemInDropdownByVisibleText(AdminCustomerPageUI.MONTH_TEXTBOX_SEARCH, month);
	}

	public void enterToDayDropdownSearch(String day) {
		waitForElementVisible(AdminCustomerPageUI.DAY_TEXTBOX_SEARCH);
		selectItemInDropdownByVisibleText(AdminCustomerPageUI.DAY_TEXTBOX_SEARCH, day);
	}

	public void enterToCompanyTextBoxSearch(String companyName) {
		waitForElementVisible(AdminCustomerPageUI.COMPANY_TEXTBOX_SEARCH);
		sendKeyToElement(AdminCustomerPageUI.COMPANY_TEXTBOX_SEARCH, companyName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminCustomerPageUI.SEARCH_BUTTON);
		clickToElement(AdminCustomerPageUI.SEARCH_BUTTON);
	}

	public void clickToEditButtonByName(String name) {
		waitForElementClickable(AdminCustomerPageUI.EDIT_BY_NAME, name);
		clickToElement(AdminCustomerPageUI.EDIT_BY_NAME, name);
	}

	public void clickToSaveButton() {
		waitForElementClickable(AdminCustomerPageUI.SAVE_BUTTON);
		clickToElement(AdminCustomerPageUI.SAVE_BUTTON);
	}

	public AdminNewAddressPageObject clickToAddNewAddressButton(String textButton) {
		waitForElementClickable(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON, textButton);
		scrollToElement(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON, textButton);
		clickToElement(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON, textButton);
		return PageGeneratorManager.getAdminNewAddressPO(driver);
	}

	public AdminNewAddressPageObject clickToEditAddressByEmail(String name) {
		waitForElementClickable(AdminCustomerPageUI.EDIT_BY_NAME, name);
		clickToElement(AdminCustomerPageUI.EDIT_BY_NAME, name);
		return PageGeneratorManager.getAdminNewAddressPO(driver);
	}

	public void clickToDeleteAddressByEmail(String emailCustomerUpdate) {
		waitForElementClickable(AdminCustomerPageUI.DELETE_ADDRESS_BY_NAME, emailCustomerUpdate);
		clickToElement(AdminCustomerPageUI.DELETE_ADDRESS_BY_NAME, emailCustomerUpdate);
	}

	public void acceptAlertConfirmDelete() {
		waitForAlertPresence();
		acceptAlert();
	}

	public String getMessageNoData() {
		waitForElementVisible(AdminCustomerPageUI.MESSAGE_NO_DATA_IN_TABLE);
		scrollToElement(AdminCustomerPageUI.MESSAGE_NO_DATA_IN_TABLE);
		return getElementText(AdminCustomerPageUI.MESSAGE_NO_DATA_IN_TABLE);
	}

	public int getCountCustomerDisplay() {
		waitForElementVisible(AdminCustomerPageUI.CUSTOMER_IN_TABLE);
		return getElementSize(AdminCustomerPageUI.CUSTOMER_IN_TABLE);
	}

	public void clearOptionSelectedInCustomerRole() {
		waitForElementVisible(AdminCustomerPageUI.OPTION_CHOOSE_IN_CUSTOMER_ROLE);
		List<WebElement> elements = getListWebElement(AdminCustomerPageUI.OPTION_CHOOSE_IN_CUSTOMER_ROLE);

		for (WebElement webElement : elements) {
			webElement.click();
		}

	}

	public boolean isCustomerDisplayByCompanyName(String companyName) {
		Boolean check = true;
		waitForElementVisible(AdminCustomerPageUI.CUSTOMER_IN_TABLE);
		List<WebElement> elements = getListWebElement(AdminCustomerPageUI.CUSTOMER_IN_TABLE);

		for (WebElement webElement : elements) {
			if (!isElementDisplay(AdminCustomerPageUI.COMPANY_NAME_IN_CUSTOMER_TABLE, companyName)) {
				check = false;
			}
		}
		return check;
	}

}
