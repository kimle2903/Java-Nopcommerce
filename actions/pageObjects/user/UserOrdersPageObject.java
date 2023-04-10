package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserOrdersPageUI;

public class UserOrdersPageObject extends BasePage {
	WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getOrderNumber() {
		waitForElementVisible(UserOrdersPageUI.ORDER_NUMBER);
		return getElementText(UserOrdersPageUI.ORDER_NUMBER);
	}

	public UserOrderDetailPageObject clickToDetailLink() {
		waitForElementClickable(UserOrdersPageUI.DETAIL_BUTTON);
		clickToElement(UserOrdersPageUI.DETAIL_BUTTON);

		return PageGeneratorManager.getUserOrderDetailPO(driver);
	}

}
