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
import com.nopcommerce.commons.Common_01_User_Register_With_Email_And_Password;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserListProductPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductViewsPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserProductReviewPageObject;
import reportConfigs.ExtentTestManager;

public class MyAccount extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserAddressPageObject userAddressPage;
	private UserChangePasswordPageObject userChangePassowrdPage;
	private UserMyProductViewsPageObject userMyProductViewsPage;
	private UserListProductPageObject userListProductPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserProductReviewPageObject userProductReviewPage;

	private String gender, firstName, lastName, day, month, year, company;
	private String country, province, city, address1, address2, postalCode, phoneNumber, faxNumber;
	private String browserName, menuName, subMenuName, productReviewName, reviewTitle, reviewText;
	public static String newPassword;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);
		gender = "Gender";
		firstName = "Kim le";
		lastName = "Thi";
		day = "29";
		month = "March";
		year = "1997";
		company = "Viet Kim";
		country = "Mexico";
		province = "Other";
		city = "Ha noi";
		address1 = "16/215 Tan trieu";
		address2 = "Thôn tự đông, Hoàng quý, Hoàng hóa, Thanh hóa";
		postalCode = "123456";
		phoneNumber = "0345556666";
		faxNumber = "1111";
		this.browserName = browserName.toUpperCase();
		newPassword = "kimle1997";
		menuName = "Computers ";
		subMenuName = "Desktops ";
		productReviewName = "Build your own computer";

		reviewTitle = "review title";
		reviewText = "Product use good.";
	}

	@Test
	public void My_Account_01_Login_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Login to system success");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "Login - Step 01: Click to login link");
		userLoginPage = userHomePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Login - Step 02: Enter to email textbox with data '" + Common_01_User_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Login - Step 03: Enter to password textbox with data '" + Common_01_User_Register_With_Email_And_Password.password + "'");
		userLoginPage.enterToPasswordTextBox(Common_01_User_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Login - Step 04: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Login - Step 05: Verify my account link display");
		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());
	}

	@Test
	public void My_Account_01_Update_Customer_Info(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Update customer info");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 01: Click to myaccount link");
		userCustomerInfoPage = userLoginPage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 02: Choose Gender radio button is '" + gender + "'");
		userCustomerInfoPage.chooseGenderRadiobutton(gender);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 03: Enter to first name textbox is '" + firstName + "'");
		userCustomerInfoPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 04: Enter to last name textbox is '" + lastName + "'");
		userCustomerInfoPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 05: Enter to email textbox is '" + Common_01_User_Register_With_Email_And_Password.email + "'");
		userCustomerInfoPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 06: Enter to conpany textbox is '" + company + "'");
		userCustomerInfoPage.enterToCompanyTextBox(company);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 07: Choose date in dropdown is '" + day + "'");
		userCustomerInfoPage.chooseDateInDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 08: Choose month in dropdown is '" + month + "'");
		userCustomerInfoPage.chooseMondayInDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 09: Choose date in dropdown is '" + year + "'");
		userCustomerInfoPage.chooseYearInDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 10: Click to button save");
		userCustomerInfoPage.clickToButtonSave();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 11: Verify message update success");
		Assert.assertEquals(userCustomerInfoPage.getMessageUpdateSuccess(), "The customer info has been updated successfully.");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 12: Verify gender radio button");
		Assert.assertEquals(userCustomerInfoPage.getGenderInRadioButtonChecked("name"), gender);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 13: Veriry firstname after updated");
		Assert.assertEquals(userCustomerInfoPage.getFirstNameInTextBox("value"), firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 14: Verify last name after updated");
		Assert.assertEquals(userCustomerInfoPage.getLastNameInTextBox("value"), lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 15: Verify email after updated");
		Assert.assertEquals(userCustomerInfoPage.getEmailInTextBox("value"), Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 16: Verify company after updated");
		Assert.assertEquals(userCustomerInfoPage.getCompanyInTextBox("value"), company);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 17: Verify date in dropdown after update");
		Assert.assertEquals(userCustomerInfoPage.getDateInDropdown(), day);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 18: Verify month in dropdown after update");
		Assert.assertEquals(userCustomerInfoPage.getMonthInDropdown(), month);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- MyAccount - Step 19: Verify year in dropdown after update");
		Assert.assertEquals(userCustomerInfoPage.getYearInDropdown(), year);
	}

	@Test
	public void My_Account_02_Add_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Add Address");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 01: Open address page");
		userCustomerInfoPage.openPageByNameAtSizeBar("Addresses");
		userAddressPage = PageGeneratorManager.getUserAddressPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 02: Click to button add new");
		userAddressPage.clickToAddNewButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 03: Enter to first name textbox is '" + firstName + "'");
		userAddressPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 04: Enter to last name textbox is '" + lastName + "'");
		userAddressPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 05: Enter to email textbox is '" + Common_01_User_Register_With_Email_And_Password.email + "'");
		userAddressPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 06: Enter to company textbox is '" + company + "'");
		userAddressPage.enterToCompanyTextBox(company);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 07: Enter to country textbox is '" + country + "'");
		userAddressPage.chooseCountryInDropdown(country);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 08: Enter to province textbox is '" + province + "'");
		userAddressPage.chooseProvinceInDropdown(province);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 09: Enter to city textbox is '" + city + "'");
		userAddressPage.enterToCityTextBox(city);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 10: Enter to address1 textbox is '" + address1 + "'");
		userAddressPage.enterToAddressOneTextBox(address1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 11: Enter to addres2 textbox is '" + address2 + "'");
		userAddressPage.enterToAddressTwoTextBox(address2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 12: Enter to postal code textbox is '" + postalCode + "'");
		userAddressPage.enterToPostalCodeTextBox(postalCode);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 13: Enter to phone number textbox is '" + phoneNumber + "' ");
		userAddressPage.enterToPhoneNumberTextBox(phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 14: Enter to fax number textbox is '" + faxNumber + "'");
		userAddressPage.enterToFaxNumberTextBox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 15: Click to button save");
		userAddressPage.clickToButtonSave();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 16: Verify message add success");
		Assert.assertEquals(userAddressPage.getMessageAddSuccess(), "The new address has been added successfully.");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 17: Verify name info");
		Assert.assertEquals(userAddressPage.getNameInfo(), firstName + " " + lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 18: Verify email info");
		Assert.assertEquals(userAddressPage.getEmailInfo(), "Email: " + Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 19: Verify phone number info");
		Assert.assertEquals(userAddressPage.getPhoneNumberInfo(), "Phone number: " + phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 20: Verify fax number info");
		Assert.assertEquals(userAddressPage.getFaxNumberInfo(), "Fax number: " + faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 21: Verify company info");
		Assert.assertEquals(userAddressPage.getCompanyInfo(), company);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 22: Verify address one info");
		Assert.assertEquals(userAddressPage.getAddressOneInfo(), address1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 23: Verify address two info");
		Assert.assertEquals(userAddressPage.getAddressTwoInfo(), address2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 24: Verify city info");
		Assert.assertEquals(userAddressPage.getCityStateInfo(), city + ", " + postalCode);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Add Address - Step 25: Verify country info");
		Assert.assertEquals(userAddressPage.getCountryInfo(), country);
	}

	@Test
	public void My_Account_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Change password");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 01: Open change password page");
		userAddressPage.openPageByNameAtSizeBar("Change password");
		userChangePassowrdPage = PageGeneratorManager.getUserChangePasswordPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 02: Enter to old password is '" + Common_01_User_Register_With_Email_And_Password.password + "'");
		userChangePassowrdPage.enterToOldPassword(Common_01_User_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 03: Enter to new password is '" + newPassword + "'");
		userChangePassowrdPage.enterToNewPassword(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 04: Enter to confirm password is '" + newPassword + "'");
		userChangePassowrdPage.enterToConfirmPassword(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 05: Click to button change password");
		userChangePassowrdPage.clickToChangePassword();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 06: Verify change password success");
		Assert.assertEquals(userChangePassowrdPage.getMessageChangePasswordSuccess(), "Password was changed");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 07: Click to button close in message update success");
		userChangePassowrdPage.clickToButtonCloseMessageSuccess();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 08: Click to link logout");
		userHomePage = userChangePassowrdPage.clickToLogOutLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 09: Click to login link ");
		userLoginPage = userHomePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 10:  Enter to email is '" + Common_01_User_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 11: Enter to old password is '" + Common_01_User_Register_With_Email_And_Password.password + "'");
		userLoginPage.enterToPasswordTextBox(Common_01_User_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 12: Click to button login");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 13: Verify login unsuccessful");
		Assert.assertEquals(userLoginPage.getErrorMessageSummary(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 14: Click to link logout again");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 15: Enter to email is '" + Common_01_User_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_User_Register_With_Email_And_Password.email);

		sleepInSecond(1);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 16: Enter to new password is '" + newPassword + "'");
		userLoginPage.enterToPasswordTextBox(newPassword);

		sleepInSecond(1);
		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 17: Click to button login");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Change password - Step 18: Verify my account link display");
		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());
	}

	@Test
	public void My_Account_04_My_Review_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Review Product");
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 01: Hover to menu link is '" + menuName + "' ");
		userHomePage.hoverToMenuLinkByName(menuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 02: Click to sub menu link is '" + subMenuName + "' ");
		userListProductPage = userHomePage.clickToSubMenuLinkByName(subMenuName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 03: Click to product name is '" + productReviewName + "' ");
		userProductDetailPage = userListProductPage.clickToProductName(productReviewName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 04: Click to add your review link ");
		userProductReviewPage = userProductDetailPage.clickToAddYouReviewLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 05: Enter to review title is '" + reviewTitle + "' ");
		userProductReviewPage.enterToReviewTitle(reviewTitle);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 06: Enter to review text is '" + reviewText + "' ");
		userProductReviewPage.enterToReviewText(reviewText);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 07: Click to submit review button ");
		userProductReviewPage.clickToSubmitReviewButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 08: Click to my account link ");
		userCustomerInfoPage = userProductReviewPage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 09: Open page my product review ");
		userCustomerInfoPage.openPageByNameAtSizeBar("My product reviews");
		userMyProductViewsPage = PageGeneratorManager.getUserMyProductViewsPO(driver);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 10: Verify review title ");
		Assert.assertEquals(userMyProductViewsPage.getTextReviewTitle(), reviewTitle);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Review Product - Step 11: Verify review text ");
		Assert.assertEquals(userMyProductViewsPage.getTextReviewText(), reviewText);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
