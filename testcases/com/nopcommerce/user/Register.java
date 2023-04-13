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

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Register extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

	private WebDriver driver;
	private String firstName, lastName, email, password, confirmPassword;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGeneratorManager.getUserHomePO(driver);

		firstName = "kim";
		lastName = "le" + randomInt();
		email = "kimle" + randomInt() + "@gmail.com";
		password = "123123";
		confirmPassword = "123123";
	}

	@Test
	public void Register_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage = userHomePage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to register button");
		log.info("Register - Step 02: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify error message at firstName textbox");
		log.info("Step 03: Verify error message at firstName textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify error message at lastName textbox");
		log.info("Step 04: Verify error message at lastName textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify error message at email textbox");
		log.info("Register - Step 05: Verify error message at email textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextBox(), "Email is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify error message at password textbox");
		log.info("Step 06: Verify error message at password textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextBox(), "Password is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify error message at confirm password textbox");
		log.info("Step 07: Verify error message at confirm password textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		log.info("Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		log.info("Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to email invalid textbox with data is '123@3$%%' ");
		log.info("Register - Step 04: Enter to email invalid textbox with data is '123@3$%%' ");
		userRegisterPage.enterToEmailTextBox("123@3$%%");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to password textbox with data is '" + password + " '");
		log.info("Step 05: Enter to password textbox with data is '" + password + " '");
		userRegisterPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		log.info("Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		userRegisterPage.enterToConfirmPasswordTextBox(confirmPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to register button");
		log.info("Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify error message at confirm password textbox");
		log.info("Register - Step 08: Verify error message at confirm password textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Register_03_Password_Less_Than_6_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with password less than 6 characters");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		log.info("Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		log.info("Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to email invalid textbox with data is ' " + email + "' ");
		log.info("Register - Step 04: Enter to email invalid textbox with data is ' " + email + "'");
		userRegisterPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to password textbox with data is '123'");
		log.info("Register - Step 05: Enter to password textbox with data is '123'");
		userRegisterPage.enterToPasswordTextBox("123");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to confirm password textbox with data is '123'");
		log.info("Register - Step 06: Enter to confirm password textbox with data is '123'");
		userRegisterPage.enterToConfirmPasswordTextBox("123");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to register button");
		log.info("Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify error message at confirm password textbox");
		log.info("Register - Step 08: Verify error message at confirm password textbox");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system success");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		log.info("Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		log.info("Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to email invalid textbox with data is ' " + email + "' ");
		log.info("Register - Step 04: Enter to email invalid textbox with data is ' " + email + "'");
		userRegisterPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to password textbox with data is '" + password + " '");
		log.info("Register - Step 05: Enter to password textbox with data is '" + password + " '");
		userRegisterPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		log.info("Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		userRegisterPage.enterToConfirmPasswordTextBox(confirmPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to register button");
		log.info("Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success");
		log.info("Register - Step 08: Verify register success");
		Assert.assertEquals(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");
	}

	@Test
	public void Register_05_Email_Exists(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with email exists");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		log.info("Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		log.info("Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to email invalid textbox with data is ' " + email + "' ");
		log.info("Register - Step 04: Enter to email invalid textbox with data is ' " + email + "'");
		userRegisterPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to password textbox with data is '" + password + " '");
		log.info("Register - Step 05: Enter to password textbox with data is '" + password + " '");
		userRegisterPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		log.info("Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		userRegisterPage.enterToConfirmPasswordTextBox(confirmPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to register button");
		log.info("Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify email already exists");
		log.info("Register - Step 08: Verify email already exists");
		Assert.assertEquals(userRegisterPage.getErrorMessageEmailExists(), "The specified email already exists");
	}

	@Test
	public void Register_06_Confirm_Password_Do_Not_Match(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with confirm password don't match");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		log.info("Register - Step 01: Click to register link");
		userRegisterPage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		log.info("Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		log.info("Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to email invalid textbox with data is ' " + email + "' ");
		log.info("Register - Step 04: Enter to email invalid textbox with data is ' " + email + "'");
		userRegisterPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to password textbox with data is '" + password + " '");
		log.info("Register - Step 05: Enter to password textbox with data is '" + password + " '");
		userRegisterPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to confirm password textbox with data is '123456'");
		log.info("Register - Step 06: Enter to confirm password textbox with data is '123456'");
		userRegisterPage.enterToConfirmPasswordTextBox("123456");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to register button");
		log.info("Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify assword and confirmation password don't match");
		log.info("Register - Step 08: Verify assword and confirmation password don't match");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
