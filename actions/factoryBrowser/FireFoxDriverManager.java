package factoryBrowser;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		return WebDriverManager.firefoxdriver().create();
	}

}
