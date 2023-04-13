package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
