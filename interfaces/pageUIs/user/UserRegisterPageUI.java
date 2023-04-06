package pageUIs.user;

public class UserRegisterPageUI {
	public static final String REGISTER_LINK = "xpath=//div[@class='header-links']//a[text()='Register']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";

	public static final String ERROR_MESSAGE_FIRSTNAME = "css=span#FirstName-error";
	public static final String ERROR_MESSAGE_LASTNAME = "css=span#LastName-error";
	public static final String ERROR_MESSAGE_EMAIL = "css=span#Email-error";
	public static final String ERROR_MESSAGE_PASSWORD = "css=span#Password-error";
	public static final String ERROR_MESSAGE_CONFIRM_PASSWORD = "css=span#ConfirmPassword-error";
	public static final String ERROR_MESSAGE_EMAIL_EXISTS = "xpath=//div[contains(@class, 'validation-summary-errors')]//li";
	public static final String MESSAGE_REGISTER_SUCCESS = "xpath=//div[@class='page-body']/div[@class='result']";

	public static final String FIRSTNAME_TEXTBOX = "css=input#FirstName";
	public static final String LASTNAME_TEXTBOX = "css=input#LastName";
	public static final String EMAIL_TEXTBOX = "css=input#Email";
	public static final String PASSWORD_TEXTBOX = "css=input#Password";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "css=input#ConfirmPassword";

}
