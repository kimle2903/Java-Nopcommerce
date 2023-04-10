package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToOldPassword(String password) {
		waitForElementVisible(UserChangePasswordPageUI.OLD_PASSWORD);
		sendKeyToElement(UserChangePasswordPageUI.OLD_PASSWORD, password);
	}

	public void enterToNewPassword(String newPassword) {
		waitForElementVisible(UserChangePasswordPageUI.NEW_PASSWORD);
		sendKeyToElement(UserChangePasswordPageUI.NEW_PASSWORD, newPassword);
	}

	public void enterToConfirmPassword(String confirmPassword) {
		waitForElementVisible(UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD);
		sendKeyToElement(UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD, confirmPassword);
	}

	public void clickToChangePassword() {
		waitForElementClickable(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getMessageChangePasswordSuccess() {
		waitForElementVisible(UserChangePasswordPageUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
		return getElementText(UserChangePasswordPageUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
	}

	public void clickToButtonCloseMessageSuccess() {
		waitForElementClickable(UserChangePasswordPageUI.CLOSE_MESSAGE_SUCCESS_BUTTON);
		clickToElement(UserChangePasswordPageUI.CLOSE_MESSAGE_SUCCESS_BUTTON);
	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(UserChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(UserChangePasswordPageUI.LOGOUT_LINK);

		return PageGeneratorManager.getUserHomePO(driver);
	}

}
