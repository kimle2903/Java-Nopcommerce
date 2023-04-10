package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCheckoutProductPageObject;
import pageObjects.user.UserCompareProductPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductViewsPageObject;
import pageObjects.user.UserOrderDetailPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserProductReviewPageObject;
import pageObjects.user.UserRecentlyNewProductPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserSearchPageObject;
import pageObjects.user.UserShoppingCartPageObject;
import pageObjects.user.UserWishListPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePO(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPO(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPO(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPO(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPO(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPO(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserMyProductViewsPageObject getUserMyProductViewsPO(WebDriver driver) {
		return new UserMyProductViewsPageObject(driver);
	}

	public static UserListProductPageObject getUserListProductPO(WebDriver driver) {
		return new UserListProductPageObject(driver);
	}

	public static UserProductDetailPageObject getUserProductDetailPO(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}

	public static UserProductReviewPageObject getUserProductReviewPO(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPO(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserWishListPageObject getUserWishListPO(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}

	public static UserShoppingCartPageObject getUserShoppingCartPO(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}

	public static UserCompareProductPageObject getUserConpareProductPO(WebDriver driver) {
		return new UserCompareProductPageObject(driver);
	}

	public static UserRecentlyNewProductPageObject getUserRecentlyNewProductPO(WebDriver driver) {
		return new UserRecentlyNewProductPageObject(driver);
	}

	public static UserCheckoutProductPageObject getUserCheckoutProductPO(WebDriver driver) {
		return new UserCheckoutProductPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPO(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserOrderDetailPageObject getUserOrderDetailPO(WebDriver driver) {
		return new UserOrderDetailPageObject(driver);
	}
}
