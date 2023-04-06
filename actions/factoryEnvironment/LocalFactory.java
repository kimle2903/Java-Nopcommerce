package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNoSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.ChromeHeadlessDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FireFoxDriverManager;
import factoryBrowser.FireFoxHeadlessDriverManager;
import factoryBrowser.SafariDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case FIREFOX:
			driver = new FireFoxDriverManager().getBrowserDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new ChromeHeadlessDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new FireFoxHeadlessDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNoSupportedException(System.getProperty("os.name"));
		}

		return driver;
	}
}
