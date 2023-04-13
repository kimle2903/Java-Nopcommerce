package com.nopcommerce.commons;

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

public class Common_01_User_Register_With_Email_And_Password extends BaseTest {

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

	private WebDriver driver;
	private String confirmPassword;
	public static String email, password, firstName, lastName;
	public String browserName;

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
		this.browserName = browserName.toUpperCase();
	}

	@Test
	public void Register_Success_With_Email_And_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "Register to system success");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		userRegisterPage = userHomePage.clickToRegisterLink();
		sleepInSecond(2);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 02: Enter to firstName textbox with data is '" + firstName + " '");
		userRegisterPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 03: Enter to lastName textbox with data is '" + lastName + " '");
		userRegisterPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 04: Enter to email invalid textbox with data is ' " + email + "' ");
		userRegisterPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 05: Enter to password textbox with data is '" + password + " '");
		userRegisterPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 06: Enter to confirm password textbox with data is '" + confirmPassword + " '");
		userRegisterPage.enterToConfirmPasswordTextBox(confirmPassword);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 07: Click to register button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "- Register - Step 08: Verify register success");
		Assert.assertEquals(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
