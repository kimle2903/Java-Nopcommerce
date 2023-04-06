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
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import reportConfigs.ExtentTestManager;

public class Login extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private String invalidEmail, emailUnRegister, incorrectPassword;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

		invalidEmail = "1234@3#$";
		emailUnRegister = "tranviet@gmail.com";
		incorrectPassword = "123456";
	}

	@Test
	public void Login_01_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage = userHomePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify error message at email textbox");
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}

	@Test
	public void Login_02_With_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with data '" + invalidEmail + "'");
		userLoginPage.enterToEmailTextBox(invalidEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox with data '" + Common_01_Register_With_Email_And_Password.password + "'");
		userLoginPage.enterToPasswordTextBox(Common_01_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message at email textbox");
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with email unregister");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with data '" + emailUnRegister + "'");
		userLoginPage.enterToEmailTextBox(emailUnRegister);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox with data '" + Common_01_Register_With_Email_And_Password.password + "'");
		userLoginPage.enterToPasswordTextBox(Common_01_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message login was unsuccessful");
		Assert.assertEquals(userLoginPage.getErrorMessageSummary(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_With_Empty_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with empty password");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with data '" + Common_01_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message login was unsuccessful");
		Assert.assertEquals(userLoginPage.getErrorMessageSummary(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Incorrect_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with incorrect password");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with data '" + Common_01_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox with data '" + incorrectPassword + "'");
		userLoginPage.enterToPasswordTextBox(incorrectPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify error message login was unsuccessful");
		Assert.assertEquals(userLoginPage.getErrorMessageSummary(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system success");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to login link");
		userLoginPage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with data '" + Common_01_Register_With_Email_And_Password.email + "'");
		userLoginPage.enterToEmailTextBox(Common_01_Register_With_Email_And_Password.email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox with data '" + Common_01_Register_With_Email_And_Password.password + "'");
		userLoginPage.enterToPasswordTextBox(Common_01_Register_With_Email_And_Password.password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify my account link display");
		Assert.assertTrue(userLoginPage.isMyAccountLinkDisplay());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
