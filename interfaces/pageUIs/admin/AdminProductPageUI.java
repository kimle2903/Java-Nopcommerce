package pageUIs.admin;

public class AdminProductPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "CSS=input#SearchProductName";
	public static final String SEARCH_BUTTON = "CSS=button#search-products";
	public static final String PRODUCT_DISPPLAY = "XPATH=//table[@id='products-grid']//tbody/tr";
	public static final String PRODUCT_NAME_DISPPLAY = "XPATH=//table[@id='products-grid']//tbody/tr/td[text()='%s']";
	public static final String CATEGORY_DROPDOWN = "css=select#SearchCategoryId";
	public static final String MESSAGE_NO_DATA = "XPATH=//td[@class='dataTables_empty']";
	public static final String SUB_CATEGORY_CHECKBOX = "css=input#SearchIncludeSubCategories";
	public static final String MANUFACTURER_NAME = "css=select#SearchManufacturerId";

	public static final String GO_DIRECTLY_TO_PRODUCT_TEXTBOX = "css=input#GoDirectlyToSku";
	public static final String GO_BUTTON = "css=button#go-to-product-by-sku";

}
