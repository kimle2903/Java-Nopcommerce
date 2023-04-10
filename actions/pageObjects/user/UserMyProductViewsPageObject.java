package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserMyProductViewsPageUI;

public class UserMyProductViewsPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductViewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextReviewTitle() {
		waitForElementVisible(UserMyProductViewsPageUI.REVIEW_TITLE);
		return getElementText(UserMyProductViewsPageUI.REVIEW_TITLE);
	}

	public String getTextReviewText() {
		waitForElementVisible(UserMyProductViewsPageUI.REVIEW_TEXT);
		return getElementText(UserMyProductViewsPageUI.REVIEW_TEXT);
	}

}
