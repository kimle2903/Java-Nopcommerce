package pageUIs.admin;

public class AdminNewAddressPageUI {
	public static final String FIRSTNAME_TEXTBOX = "CSS=input#Address_FirstName";
	public static final String LASTNAME_TEXTBOX = "CSS=input#Address_LastName";
	public static final String EMAIL_TEXTBOX = "CSS=input#Address_Email";
	public static final String COMPANY_TEXTBOX = "CSS=input#Address_Company";
	public static final String COUNTRY_IN_DROPDOWN = "CSS=select#Address_CountryId";
	public static final String COUNTY_TEXTBOX = "CSS=input#Address_County";
	public static final String CITY_TEXTBOX = "CSS=input#Address_City";
	public static final String ADDRESS_ONE_TEXTBOX = "CSS=input#Address_Address1";
	public static final String ADDRESS_TWO_TEXTBOX = "CSS=input#Address_Address2";
	public static final String POSTAL_CODE_TEXTBOX = "CSS=input#Address_ZipPostalCode";
	public static final String PHONE_NUMBER_TEXTBOX = "CSS=input#Address_PhoneNumber";
	public static final String FAX_NUMBER_TEXTBOX = "CSS=input#Address_FaxNumber";
	public static final String SAVE_BUTTON_ADD = "xpath=//button[contains(text(), 'Save')]";
	public static final String SAVE_BUTTON_EDIT = "xpath=//button[@name='save']";

	public static final String MESSAGE_SUCCESS = "xpath=//div[contains(@class, 'alert-success')]";
	public static final String BACK_TO_CUSTOMER_DETAIL = "xpath=//div[contains(@class,'content-header')]//a[text()='back to customer details']";
}
