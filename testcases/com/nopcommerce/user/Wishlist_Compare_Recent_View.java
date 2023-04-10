package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.commons.Common_01_Register_With_Email_And_Password;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserCompareProductPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserRecentlyNewProductPageObject;
import pageObjects.user.UserShoppingCartPageObject;
import pageObjects.user.UserWishListPageObject;
import reportConfigs.ExtentTestManager;

public class Wishlist_Compare_Recent_View extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserListProductPageObject userListProductPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserWishListPageObject userWishListPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserCompareProductPageObject userCompareProductPage;
	private UserRecentlyNewProductPageObject userRecentlyNewProductPage;

	WebDriver driver;
	private String browserName, menuName, subMenuName;
	private String priceNameOne, priceNameTwo, productName, productNameTwo;
	int totalWishList, totalShoppingCart;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);
		this.browserName = browserName.toUpperCase();
		menuName = "Computers";
		subMenuName = "Notebooks";

		productName = "HP Spectre XT Pro UltraBook";
		productNameTwo = "Asus N551JK-XO076H Laptop";

		totalWishList = 0;
		totalShoppingCart = 0;

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.enterToEmailTextBox(Common_01_Register_With_Email_And_Password.email);
		userLoginPage.enterToPasswordTextBox(Common_01_Register_With_Email_And_Password.password);
		userLoginPage.clickToLoginButton();
		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());

		userHomePage.hoverToMenuLinkByName(menuName);
		userListProductPage = userHomePage.clickToSubMenuLinkByName(subMenuName);
		userProductDetailPage = userListProductPage.clickToProductName(productName);

	}

	@Test
	public void TC_01_Add_Product_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Add Product to wishlist");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 01: Click to link add to wishlist");
		userProductDetailPage.clickToAddToWishListLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 02:Verify add to wishlist succes");
		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your wishlist");
		totalWishList += 1;

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 03: Click to wishlist link");
		userWishListPage = userProductDetailPage.clickToWishListLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 04: Verify product add wishlist success");
		Assert.assertTrue(userWishListPage.isProductAddWishListSuccess(productName));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 05: Click to link 'Your wishlist url for share'");
		userWishListPage.clickToYourWishListURLForShare();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 06: Verify title wishlist share");
		Assert.assertEquals(userWishListPage.getTitleWishListShare(), "Wishlist of " + Common_01_Register_With_Email_And_Password.firstName + " " + Common_01_Register_With_Email_And_Password.lastName);

	}

	@Test
	public void TC_02_Add_Product_To_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Add product to cart");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 01: Back to page wishlist");
		userWishListPage.backToPage();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 02: Verify total wishlist begining");
		Assert.assertEquals(userWishListPage.getTotalWishList(), "(" + totalWishList + ")");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 03: Verify total shopping cart begining");
		Assert.assertEquals(userWishListPage.getTotalShoppingCart(), "(" + totalShoppingCart + ")");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 04: Click to checkbox Add to cart");
		userWishListPage.clickToAddToCartCheckbox(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 05: Click to button Add To Cart");
		userWishListPage.clickToAddToCartButton();

		totalWishList -= 1;
		totalShoppingCart += 1;

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 06: Verify total wishlist after");
		Assert.assertEquals(userWishListPage.getTotalWishList(), "(" + totalWishList + ")");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - WishList - Step 07: Verify total shopping cart after");
		Assert.assertEquals(userWishListPage.getTotalShoppingCart(), "(" + totalShoppingCart + ")");

		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPO(driver);

	}

	@Test
	public void TC_03_Remove_Product_In_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Remove product in wish list");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 01: Hover to menu link is '" + menuName + "'");
		userShoppingCartPage.hoverToMenuLinkByName(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 02: Click to sub menu is '" + subMenuName + "'");
		userListProductPage = userShoppingCartPage.clickToSubMenuLinkByName(subMenuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 03: Click to product name is '" + productName + "'");
		userProductDetailPage = userListProductPage.clickToProductName(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 04: Click to link Add to wishlist");
		userProductDetailPage.clickToAddToWishListLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 05: Verify Add to wishlist success");
		Assert.assertEquals(userProductDetailPage.getMessageSuccess(), "The product has been added to your wishlist");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 06: Click to link wishlist ");
		userWishListPage = userProductDetailPage.clickToWishListLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 07: Verify product add wishlist success");
		Assert.assertTrue(userWishListPage.isProductAddWishListSuccess(productName));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 08: click to button remote product is '" + productName + "'");
		userWishListPage.clickToRemoteButtonByProductName(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 09: Verify message notify");
		Assert.assertEquals(userWishListPage.getMessageNotify(), "The wishlist is empty!");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Wishlist - Step 10: Verify Product not exists");
		Assert.assertTrue(userWishListPage.isProductByNameNotExistInWishList(productName));

	}

	@Test
	public void TC_04_Add_Product_To_Compare(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + " - Add product to compare");
		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 01: Hover to menu link is '" + menuName + "'");
		userWishListPage.hoverToMenuLinkByName(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 02: Click to sub menu is '" + subMenuName + "'");
		userListProductPage = userWishListPage.clickToSubMenuLinkByName(subMenuName);

		priceNameOne = userListProductPage.getPriceProductByName(productName);
		priceNameTwo = userListProductPage.getPriceProductByName(productNameTwo);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 03: Click to button add to compare at product name is '" + productName + "'");
		userListProductPage.clickToAddToCompareButton(productName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 04: Verify Product add compare success");
		Assert.assertEquals(userListProductPage.getMessageAddToCompareSuccess(), "The product has been added to your product comparison");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 05: Click to button add to compare at product name is '" + productNameTwo + "'");
		userListProductPage.clickToAddToCompareButton(productNameTwo);

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 06: Verify Product add compare success'");
		Assert.assertEquals(userListProductPage.getMessageAddToCompareSuccess(), "The product has been added to your product comparison");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 07: Click to link product compare");
		userCompareProductPage = userListProductPage.clickToProductCompareLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 08: Verify product name is'" + productName + "' display");
		Assert.assertTrue(userCompareProductPage.isProductNameDisable(productName));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 09: Verify product name is '" + productNameTwo + "' display");
		Assert.assertTrue(userCompareProductPage.isProductNameDisable(productNameTwo));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 10: Verify price of product name is '" + productName + "' display");
		Assert.assertTrue(userCompareProductPage.isPriceProductDisable(priceNameOne));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 11:  Verify price of product name is '" + productNameTwo + "' display");
		Assert.assertTrue(userCompareProductPage.isPriceProductDisable(priceNameTwo));

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 12: Click to button clear list");
		userCompareProductPage.clickToClearListButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 13: Verify message You have no items to compare");
		Assert.assertEquals(userCompareProductPage.getMessageNotify(), "You have no items to compare.");

		ExtentTestManager.getTest().log(Status.INFO, browserName + " - Compare - Step 14: Verify product undisplay");
		Assert.assertTrue(userCompareProductPage.isProductUnDisplay());
	}

	@Test
	public void TC_05_Recently_Viewed_Products(Method method) {
		String arrProductName[] = { "Apple MacBook Pro 13-inch", "Asus N551JK-XO076H Laptop", "HP Envy 6-1180ca 15.6-Inch Sleekbook", "HP Spectre XT Pro UltraBook", "Lenovo Thinkpad X1 Carbon Laptop" };
		ExtentTestManager.startTest(method.getName(), "Recently Viewed Products");
		ExtentTestManager.getTest().log(Status.INFO, "Recently Reviewd - Step 01: Hover to menu link is '" + menuName + "'");
		userCompareProductPage.hoverToMenuLinkByName(menuName);

		ExtentTestManager.getTest().log(Status.INFO, "Recently Reviewd - Step 02: Click to sub menu link is '" + subMenuName + "'");
		userListProductPage = userWishListPage.clickToSubMenuLinkByName(subMenuName);

		ExtentTestManager.getTest().log(Status.INFO, "Recently Reviewd - Step 03: Click to view list product ");
		userListProductPage.clickListViewProduct(arrProductName);

		ExtentTestManager.getTest().log(Status.INFO, "Recently Reviewd - Step 04: Open page recently viewed products");
		userListProductPage.openPageByNameAtFooter("Recently viewed products");

		userRecentlyNewProductPage = PageGeneratorManager.getUserRecentlyNewProductPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Recently Reviewd - Step 05: Verify product in rencently views products");
		Assert.assertTrue(userRecentlyNewProductPage.isLastThreeProductShow(arrProductName));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
