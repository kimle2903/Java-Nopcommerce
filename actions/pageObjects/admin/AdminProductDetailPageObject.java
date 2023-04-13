package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends BasePage {
	WebDriver driver;

	public AdminProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getProductNameInDetailPage() {
		waitForElementVisible(AdminProductDetailPageUI.PRODUCT_NAME);
		return getElementAttribute(AdminProductDetailPageUI.PRODUCT_NAME, "value");
	}

	public boolean isGoProductDetailSuccess(String textValue) {
		waitForElementVisible(AdminProductDetailPageUI.TITLE_PRODUCT_DETAIL, textValue);
		return isElementDisplay(AdminProductDetailPageUI.TITLE_PRODUCT_DETAIL, textValue);
	}

}
