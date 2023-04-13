package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(AdminLoginPageUI.LOGIN_BUTTON);

		return PageGeneratorManager.getDashboardPage(driver);
	}

}
