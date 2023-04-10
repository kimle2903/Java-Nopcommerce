package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToReviewTitle(String reviewTitle) {
		waitForElementVisible(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void enterToReviewText(String reviewText) {
		waitForElementVisible(UserProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
		sendKeyToElement(UserProductReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(UserProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(UserProductReviewPageUI.MY_ACCOUNT_LINK);

		return PageGeneratorManager.getUserCustomerInfoPO(driver);
	}

}
