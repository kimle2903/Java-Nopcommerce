package factoryBrowser;

public class BrowserNoSupportedException extends IllegalStateException {
	public BrowserNoSupportedException(String browser) {
		super(String.format("browser is not supported: %s", browser));
	}
}
