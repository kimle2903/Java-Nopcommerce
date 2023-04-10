package pageUIs.user;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "xpath=//button[contains(@class, 'search-button')]";
	public static final String ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class='warning']";
	public static final String SEARCH_TEXTBOX = "css=input#q";
	public static final String MESSAGE_RESULT_SEARCH = "xpath=//div[@class='search-results']//div[@class='no-result']";
	public static final String PRODUCT_NAME_RESULT = "xpath=//div[@class='product-item']//h2[@class='product-title']/a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "css=input#advs";
	public static final String CATEGORY_IN_DROPDOWN = "css=select#cid";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "css=input#isc";
	public static final String MANUFACTURER_IN_DROPDOWN = "css=select#mid";
}
