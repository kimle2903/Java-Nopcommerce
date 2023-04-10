package pageUIs.user;

public class UserChangePasswordPageUI {
	public static final String OLD_PASSWORD = "css=input#OldPassword";
	public static final String NEW_PASSWORD = "css=input#NewPassword";
	public static final String CONFIRM_NEW_PASSWORD = "css=input#ConfirmNewPassword";

	public static final String CHANGE_PASSWORD_BUTTON = "xpath=//button[contains(@class, 'change-password-button')]";
	public static final String MESSAGE_CHANGE_PASSWORD_SUCCESS = "xpath=//div[@class='bar-notification success']/p[@class='content']";
	public static final String CLOSE_MESSAGE_SUCCESS_BUTTON = "xpath=//div[@class='bar-notification success']/span[@class='close']";
	public static final String LOGOUT_LINK = "xpath=//div[@class='header-links']//a[text()='Log out']";
}
