package pageUIs.user;

public class UserListProductPageUI {
	public static final String PRODUCT_NAME = "XPATH=//div[@class='product-item']//h2/a[text()='%s']";
	public static final String LIST_PRODUCT_NAME = "XPATH=//div[@class='product-item']//h2/a";
	public static final String PRICE_PRODUCT = "XPATH=//div[@class='product-item']//h2/a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']/div[@class='prices']/span";
	public static final String LIST_PRICE_PRODUCT = "XPATH=//div[@class='product-item']//h2/a/parent::h2/following-sibling::div[@class='add-info']/div[@class='prices']/span";
	public static final String ADD_TO_COMPARE_BUTTON = "XPATH=//div[@class='product-item']//h2/a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to compare list']";

	public static final String MESSAGE_ADD_TO_COMPARE_SUCCESS = "xpath=//div[@class='bar-notification success']/p[@class='content']";
	public static final String PRODUCT_COMPARE_LINK_IN_MESSAGE = "XPATH=//div[@class='bar-notification success']/p[@class='content']/a";

	public static final String SORT_BY_DROPDOWN = "XPATH=//select[@id='products-orderby']";
	public static final String DISPLAY_DROPDOWN = "XPATH=//select[@id='products-pagesize']";
	public static final String CURRENT_PAGE = "XPATH=//div[@class='pager']//li[@class='current-page']/span";
	public static final String NEXT_PAGE = "XPATH=//div[@class='pager']//li[@class='next-page']";
	public static final String PRIVIOUS_PAGE = "XPATH=//div[@class='pager']//li[@class='previous-page']";
	public static final String PAGING = "XPATH=//div[@class='pager']";

	public static final String COUNT_SHOPPING_CART = "XPATH=//div[@class='mini-shopping-cart']/div[@class='count']";

}
