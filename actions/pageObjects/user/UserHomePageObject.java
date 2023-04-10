package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);

		return PageGeneratorManager.getUserRegisterPO(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElement(UserHomePageUI.LOGIN_LINK);

		return PageGeneratorManager.getUserLoginPO(driver);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);

		return PageGeneratorManager.getUserCustomerInfoPO(driver);
	}

}
