package pageUIs.user;

public class UserCustomerInfoPageUI {
	public static final String GENDER_RADIO_BUTTON = "css=input#gender-female";
	public static final String FIRSTNAME_TEXTBOX = "css=input#FirstName";
	public static final String LASTNAME_TEXTBOX = "css=input#LastName";
	public static final String EMAIL_TEXTBOX = "css=input#Email";
	public static final String COMPANY_TEXTBOX = "css=input#Company";
	public static final String DATE_IN_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
	public static final String MONTH_IN_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String YEAR_IN_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";

	public static final String SAVE_BUTTON = "xpath=//button[@id='save-info-button']";
	public static final String MESSAGE_UPDATE_SUCCESS = "xpath=//div[@class='bar-notification success']/p[@class='content']";

	public static final String GENDER_RADIO_BUTTON_CHECKED = "xpath=//input[@type='radio' and @checked]";

}
