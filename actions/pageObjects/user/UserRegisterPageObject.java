package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextBox() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_FIRSTNAME);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_FIRSTNAME);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_LASTNAME);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_LASTNAME);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_EMAIL);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_LINK);
		clickToElement(UserRegisterPageUI.REGISTER_LINK);
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getMessageRegisterSuccess() {
		waitForElementVisible(UserRegisterPageUI.MESSAGE_REGISTER_SUCCESS);
		return getElementText(UserRegisterPageUI.MESSAGE_REGISTER_SUCCESS);
	}

	public String getErrorMessageEmailExists() {
		waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_EMAIL_EXISTS);
		return getElementText(UserRegisterPageUI.ERROR_MESSAGE_EMAIL_EXISTS);
	}

}
