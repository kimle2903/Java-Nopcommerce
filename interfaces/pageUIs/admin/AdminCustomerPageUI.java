package pageUIs.admin;

public class AdminCustomerPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//div[contains(@class,'content-header ')]//a";
	public static final String EMAIL_TEXTBOX = "css=input#Email";
	public static final String PASSWORD_TEXTBOX = "css=input#Password";
	public static final String FIRSTNAME_TEXTBOX = "css=input#FirstName";
	public static final String LASTNAME_TEXTBOX = "css=input#LastName";
	public static final String GENDER_RADIO_BUTTON = "xpath=//div[@class='form-check']/label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DATE_OF_BIRTH_TEXTBOX = "css=input#DateOfBirth";
	public static final String COMPANY_TEXTBOX = "css=input#Company";
	public static final String NEWSLETE_DROPDOWN = "xpath=//label[text()='Newsletter']//parent::div//parent::div/following-sibling::div//div[contains(@class,'k-multiselect-wrap')]";
	public static final String OPTION_IN_NEWSLETE_DROPDOWN = "xpath=//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li";
	public static final String MANAGER_OF_VENDOR_DROPDOWN = "css=select#VendorId";
	public static final String ACTIVE_CHECKBOX = "css=input#Active";
	public static final String ADMIN_COMMENT = "css=textarea#AdminComment";
	public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "xpath=//button[@name='save-continue']";

	public static final String MESSAGE_SUCCESS = "xpath=//div[contains(@class, 'alert-success')]";
	public static final String NEWSLETE_VERIFY = "xpath=//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/li/span";
	public static final String CUSTOMER_ROLE_VERIFY = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']/li/span";

	public static final String CUSTOMER_ROLE_DROPDOWN = "xpath=//label[text()='Customer roles']//parent::div//parent::div/following-sibling::div//div[contains(@class,'k-multiselect-wrap')]";
	public static final String OPTION_IN_CUSTOMER_ROLE = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String OPTION_CHOOSE_IN_CUSTOMER_ROLE = "xpath=//label[text()='Customer roles']//parent::div//parent::div/following-sibling::div//span[@title='delete']";
	public static final String CUSTOMER_IN_TABLE = "xpath=//table[@id='customers-grid']//tbody/tr";
	public static final String COMPANY_NAME_IN_CUSTOMER_TABLE = "xpath=//table[@id='customers-grid']//tbody/tr/td[text()='%s']";
	public static final String BACK_TO_CUSTOMER_LIST = "xpath=//div[contains(@class, 'content-header')]/h1//a";

	public static final String EMAIL_TEXTBOX_SEARCH = "CSS=input#SearchEmail";
	public static final String FIRSTNAME_TEXTBOX_SEARCH = "CSS=input#SearchFirstName";
	public static final String LASTNAME_TEXTBOX_SEARCH = "CSS=input#SearchLastName";
	public static final String MONTH_TEXTBOX_SEARCH = "CSS=select#SearchMonthOfBirth";
	public static final String DAY_TEXTBOX_SEARCH = "CSS=select#SearchDayOfBirth";
	public static final String COMPANY_TEXTBOX_SEARCH = "CSS=input#SearchCompany";
	public static final String SEARCH_BUTTON = "css=button#search-customers";

	public static final String EDIT_BY_NAME = "XPATH=//td[text()='%s']/following-sibling::td[contains(@class, 'button')]/a";
	public static final String SAVE_BUTTON = "XPATH=//button[@name='save']";

	public static final String ADD_NEW_ADDRESS_BUTTON = "XPATH=//button[contains(text(), '%s')]";
	public static final String DELETE_ADDRESS_BY_NAME = "XPATH=//td[text()='%s']/following-sibling::td[contains(@class, 'button-column')]/a[text()='Delete']";
	public static final String MESSAGE_NO_DATA_IN_TABLE = "XPATH=//div[@id='customer-addresses-grid_wrapper']//td[@class='dataTables_empty']";

}
