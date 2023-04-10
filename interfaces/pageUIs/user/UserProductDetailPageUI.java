package pageUIs.user;

public class UserProductDetailPageUI {
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']/a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST_LINK = "xpath=//button[contains(@class, 'add-to-wishlist-button')]";
	public static final String MESSAGE_ADD_TO_SUCCESS = "xpath=//div[@class='bar-notification success']/p[@class='content']";
	public static final String WISHLIST_LINK = "xpath=//div[@class='bar-notification success']/p[@class='content']/a";

	public static final String PROCESSOR_DROPDOWN = "css=select#product_attribute_1";
	public static final String RAM_DROPDOWN = "css=select#product_attribute_2";
	public static final String HDD_RADIO_BUTTON = "xpath=//dd[@id='product_attribute_input_3']//li//label[text()='%s']/preceding-sibling::input";
	public static final String OS_RADIO_BUTTON = "xpath=//dd[@id='product_attribute_input_4']//li//label[text()='%s']/preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX_BY_LABEL = "xpath=//dd[@id='product_attribute_input_5']//li//label[text()='%s']/preceding-sibling::input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='add-to-cart-panel']//button[contains(@class, 'add-to-cart-button')]";
	public static final String SOFTWARE_CHECKBOX = "xpath=//dd[@id='product_attribute_input_5']//li//input";

	public static final String CLOSE_ICON_AT_MESSAGE = "xpath=//div[@id='bar-notification']//span[@class='close']";
	public static final String SHOPPING_CART = "xpath=//div[@class='header-links']//span[@class='cart-label']";
	public static final String PRODUCT_NAME_IN_SHOPPING_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='name']/a";
	public static final String ATTRIBUTE_PRODUCT_IN_SHOPPING_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='attributes']";
	public static final String TOTAL_PRICE_IN_SHOPPING_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='totals']/strong";

}
