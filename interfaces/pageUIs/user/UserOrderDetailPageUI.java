package pageUIs.user;

public class UserOrderDetailPageUI {
	public static final String ORDER_TOTAL = "xpath=//div[@class='page-body']//li[@class='order-total']/strong";

	public static final String NAME_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='name']";
	public static final String EMAIL_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='email']";
	public static final String PHONE_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='phone']";
	public static final String ADDRESS_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='address1']";
	public static final String CITY_STATE_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='city-state-zip']";
	public static final String COUNTRY_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='country']";
	public static final String PAYMENT_IN_BILLING_INFO = "xpath=//div[@class='billing-info-wrap']//li[@class='payment-method']/span[@class='value']";

	public static final String NAME_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='name']";
	public static final String EMAIL_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='email']";
	public static final String PHONE_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='phone']";
	public static final String ADDRESS_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='address1']";
	public static final String CITY_STATE_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='city-state-zip']";
	public static final String COUNTRY_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='country']";
	public static final String SHIPPING_IN_SHIPPING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='shipping-method']//span[@class='value']";

	public static final String PRODUCT_NAME = "xpath=//td[@class='product']//a";
	public static final String PRODUCT_PRICE = "xpath=//td[@class='unit-price']//span";
	public static final String PRODUCT_QUANTITY = "xpath=//td[@class='quantity']//span";
	public static final String PRODUCT_TOTAL = "xpath=//td[@class='total']//span";

	public static final String RE_ORDER_BUTTON = "xpath=//button[contains(@class, 're-order-button')]";

}
