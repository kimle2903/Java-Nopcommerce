package pageUIs.user;

public class UserShoppingCartPageUI {
	public static final String EDIT_LINK = "xpath=//div[@class='edit-item']/a[text()='Edit']";
	public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//td[@class='product']//a[text()='%s']/parent::td//following-sibling::td[@class='remove-from-cart']/button";
	public static final String PRODUCT_INFO_IN_CART = "xpath=//table[@class='cart']//tbody/tr";
	public static final String MESSAGE_SUMMARY_CONTENT = "xpath=//div[@class='order-summary-content']/div[@class='no-data']";
	public static final String TOTAL_PRICE_BY_PRODUCT_NAME = "xpath=//td[@class='product']//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span";
	public static final String QUANLITY_BY_PRODUCT_NAME = "xpath=//td[@class='product']//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";

	public static final String ESTIMATE_SHIPPING = "xpath=//a[@id='open-estimate-shipping-popup']";
	public static final String COUNTRY_IN_DROPDOWN_POPUP = "css=select#CountryId";
	public static final String POSTAL_CODE_TEXTBOX_POPUP = "css=input#ZipPostalCode";
	public static final String APPLY_BUTTON = "xpath=//button[contains(@class, 'apply-shipping-button')]";
	public static final String CLOSE_BUTTON = "xpath=//button[@class='mfp-close']";
	public static final String FEE_SHIPPING = "xpath=//tr[@class='shipping-cost']//span[@class='value-summary']";
	public static final String FEE_TAX = "xpath=//tr[@class='tax-value']//span[@class='value-summary']";
	public static final String I_AGREE_CHECKOUT = "css=input#termsofservice";
	public static final String CHECKOUT_BUTTON = "css=button#checkout";

}
