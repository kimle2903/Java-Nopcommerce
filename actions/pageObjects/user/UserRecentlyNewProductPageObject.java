package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.UserRecentlyViewProductPageUI;

public class UserRecentlyNewProductPageObject extends BasePage {
	WebDriver driver;

	public UserRecentlyNewProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isLastThreeProductShow(String[] arrProductName) {
		Boolean check = true;
		String arrName = arrProductName.toString();
		System.out.println("arrName: " + arrName);
		waitForAllElementVisible(UserRecentlyViewProductPageUI.PRODUCT_ITEM);
		List<WebElement> elements = getListWebElement(UserRecentlyViewProductPageUI.PRODUCT_NAME);
		for (WebElement webElement : elements) {
			if (!arrName.contains(webElement.getText())) {
				check = false;
			}
		}
		return check;
	}

}
