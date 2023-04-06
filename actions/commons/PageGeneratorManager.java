package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePO(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPO(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPO(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
}
