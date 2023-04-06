package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(UserLoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(UserLoginPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(UserLoginPageUI.ERROR_MESSAGE_EMAIL);
	}

	public void clickToLoginLink() {
		waitForElementClickable(UserLoginPageUI.LOGIN_LINK);
		clickToElement(UserLoginPageUI.LOGIN_LINK);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementClickable(UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementClickable(UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageSummary() {
		waitForElementVisible(UserLoginPageUI.ERROR_MESSAGE_SUMMARY);
		return getElementText(UserLoginPageUI.ERROR_MESSAGE_SUMMARY);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(UserLoginPageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(UserLoginPageUI.MY_ACCOUNT_LINK);
	}

}
