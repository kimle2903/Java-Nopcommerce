package pageUIs.user;

public class UserWishListPageUI {
	public static final String PRODUCT_NAME_VIEWLIST = "xpath=//div[@class='wishlist-content']//tr/td[@class='product']/a[text()='%s']";
	public static final String WISH_LIST_URL_FOR_SHARING = "xpath=//div[@class='share-info']/a[@class='share-link']";
	public static final String TITLE_WISHLIST_SHARE = "xpath=//div[contains(@class, 'wishlist-page')]//h1";

	public static final String QUALITY_WISH_LIST = "css=span.wishlist-qty";
	public static final String QUALITY_SHOPPING_CART = "css=span.cart-qty";

	public static final String ADD_TO_CART_CHECKBOX = "xpath=//div[@class='wishlist-content']//tr/td[@class='product']/a[text()='%s']/parent::td//preceding-sibling::td[@class='add-to-cart']/input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[contains(@class, 'wishlist-add-to-cart-button')]";
	public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//div[@class='wishlist-content']//tr/td[@class='product']/a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
	public static final String MESSAGE_NOTIFY = "xpath=//div[contains(@class, 'wishlist-page')]//div[@class='no-data']";

}
