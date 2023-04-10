package pageUIs.user;

public class UserCheckoutProductPageUI {

	public static final String COUNTRY_DROPDOWN = "css=select#BillingNewAddress_CountryId";
	public static final String PROVINCE_DROPDOWN = "css=select#BillingNewAddress_StateProvinceId";
	public static final String CITY_TEXTBOX = "css=input#BillingNewAddress_City";
	public static final String ADDRESS_ONE_TEXTBOX = "css=input#BillingNewAddress_Address1";
	public static final String POSTAL_CODE_TEXTBOX = "css=input#BillingNewAddress_ZipPostalCode";
	public static final String PHONE_NUMBER_TEXTBOX = "css=input#BillingNewAddress_PhoneNumber";
	public static final String CONTINUE_IN_BIBLING_BUTTON = "xpath=//div[@id='billing-buttons-container']//button[contains(@class, 'new-address-next-step-button')]";

	public static final String SHIPPING_METHOD_RADIO_BUTTON = "xpath=//div[@id='shipping-methods-form']//div[@class='method-name']/label[text()='%s']/preceding-sibling::input";
	public static final String CONTINUE_IN_SHIPPING_BUTTON = "xpath=//div[@id='shipping-method-buttons-container']//button[contains(@class, 'shipping-method-next-step-button')]";

	public static final String PAYMENT_METHOD_RADIO_BUTTON = "xpath=//div[@id='checkout-payment-method-load']//div[@class='payment-details']/label['%s']/preceding-sibling::input";
	public static final String CONTINUE_IN_PAYMENT__BUTTON = "xpath=//div[@id='payment-method-buttons-container']//button[contains(@class, 'payment-method-next-step-button')]";

	public static final String PAYMENT_INFO_TEXT = "xpath=//div[@id='checkout-payment-info-load']//div[@class='info']//table/tbody";
	public static final String CONTINUE_IN_PAYMENT_INFO_BUTTON = "xpath=//div[@id='payment-info-buttons-container']//button";

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
	public static final String SHIPPING_IN_BILLING_INFO = "xpath=//div[@class='shipping-info-wrap']//li[@class='shipping-method']//span[@class='value']";

	public static final String PRODUCT_NAME = "xpath=//form[@id='shopping-cart-form']//td[@class='product']/a";
	public static final String PRODUCT_PRICE = "xpath=//form[@id='shopping-cart-form']//td[@class='unit-price']/span";
	public static final String PRODUCT_QUANTITY = "xpath=//form[@id='shopping-cart-form']//td[@class='quantity']/span";
	public static final String PRODUCT_TOTAL = "xpath=//form[@id='shopping-cart-form']//td[@class='subtotal']/span";
	public static final String SUB_TOTAL = "xpath=//table[@class='cart-total']//tr[@class='order-subtotal']//td[@class='cart-total-right']/span";
	public static final String FEE_SHIPPING = "xpath=//table[@class='cart-total']//tr[@class='shipping-cost']//td[@class='cart-total-right']/span";
	public static final String FEE_TAX = "xpath=//table[@class='cart-total']//tr[@class='tax-value']//td[@class='cart-total-right']/span";
	public static final String ORDER_TOTAL = "xpath=//table[@class='cart-total']//tr[@class='order-total']//td[@class='cart-total-right']/span/strong";
	public static final String CONFIRM_BUTTON = "xpath=//div[@id='confirm-order-buttons-container']//button[contains(@class,'confirm-order-next-step-button')]";

	public static final String TITLE_ORDER_SUCCESS = "xpath=//div[contains(@class, 'order-completed-page')]//div[@class='page-title']/h1";
	public static final String CONTENT_ORDER_SUCCESS = "xpath=//div[contains(@class, 'order-completed-page')]//div[@class='title']/strong";
	public static final String ORDER_NUMBER = "xpath=//div[contains(@class, 'order-completed-page')]//div[@class='details']/div[@class='order-number']/strong";
	public static final String CONTINUE_IN_CHECKOUT = "xpath=//div[contains(@class, 'order-completed-page')]//div[@class='buttons']/button";

	public static final String EDIT_BUTTON_IN_BILLING = "xpath=//div[@id='billing-buttons-container']/button[@id='edit-billing-address-button']";
	public static final String CONTINUE_BUTTON_IN_BILLING = "xpath=//div[@id='billing-buttons-container']/button[contains(@class, 'new-address-next-step-button')]";
	public static final String SAVE_BUTTON_IN_BILLING = "xpath=//div[@id='billing-buttons-container']/button[@id='save-billing-address-button']";

}
