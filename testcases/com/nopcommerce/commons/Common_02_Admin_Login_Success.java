package com.nopcommerce.commons;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.DashboardPageObject;
import reportConfigs.ExtentTestManager;

public class Common_02_Admin_Login_Success extends BaseTest {
	private AdminLoginPageObject adminLoginPage;
	private DashboardPageObject dashboardPage;
	WebDriver driver;
	public static String email, password;
	private String browserName;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("staging") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName,
			@Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		email = "admin@yourstore.com";
		password = "admin";
		this.browserName = browserName.toUpperCase();
	}

	@Test
	public void LoginAsAdmin(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "Login as admin");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Open Login page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox");
		adminLoginPage.enterToEmailTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox");
		adminLoginPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		dashboardPage = adminLoginPage.clickToLoginButton();

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
