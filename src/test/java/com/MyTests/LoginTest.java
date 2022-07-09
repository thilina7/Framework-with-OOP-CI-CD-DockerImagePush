/**
 * 
 */
package com.MyTests;

import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.configProperties;
import com.mypages.HomePage;
import com.mypages.LoginPage;

/**
 * @author thilina.karunarathna
 *
 */
public class LoginTest extends BaseTest{
	private String loginPageTitle;
	private String lockedPageTitle;
	private String loginPageHeader;
	private static LoginPage loginPage;
	private WebElement emailValidation;
	private WebElement passwordValidation;
	
	@Description("T001_Verifying the Login page title")
	@Test(priority=1, enabled = true)
	public void verifyLoginPageTitleTest() {
		loginPageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("title->"+loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Log in");
	}
	
	@Description("T002_Verifying the header text of the login page")
	@Test(priority=2, enabled = true)
	public void verifyLoginHeaderTest() {
		loginPageHeader = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("header->"+loginPageHeader);
		Assert.assertEquals(loginPageHeader, "Not a Pipedrive user?");
	}
	
	@Description("T003_Verifying whether user can't login to the application when clicking 'login' button without giving uname and password")
	@Test(priority=3, enabled = true)
	public void emptyUnamePasswordLoginTest() {
		loginPage = new LoginPage(driver);
		loginPage.doLogin();
		Assert.assertEquals(loginPageTitle, "Log in");
	}
	
	@Description("T004_Verifying whether user can't login to the application when clicking 'login' when user give empty uname and correct password")
	@Test(priority=4, enabled = true)
	public void emptyUnameCorrectPasswordLoginTest() {
		emailValidation = page.getInstance(LoginPage.class).getEmailValidation();
		loginPage = new LoginPage(driver);
		loginPage.doLogin("password : "+configProperties.property.getProperty("password"));
		Assert.assertEquals(emailValidation.getText(), "Please add your email");
	}
	
	@Description("T005_Verifying whether user can't login to the application when clicking 'login' when user give correct uname and empty password")
	@Test(priority=5, enabled = true)
	public void correctUnameEmptyPasswordLoginTest() {
		passwordValidation = page.getInstance(LoginPage.class).getPasswordValidation().get(1);
		loginPage = new LoginPage(driver);
		loginPage.doLogin("username : "+configProperties.property.getProperty("uname"));
		Assert.assertEquals(passwordValidation.getText(), "Please add your password");
	}
	
	@Description("T006_Verifying whether user can't login to the application when clicking 'login' when user incorrect uname and correct password")
	@Test(priority=6, enabled = true)
	public void incorrectUnameCorrectPasswordLoginTest() {
		loginPageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		loginPage = new LoginPage(driver);
		loginPage.doLogin("incorrectEmail"+loginPage.randomNumberGenerator()+"@yahoo.com", configProperties.property.getProperty("password"));
		Assert.assertEquals(loginPageTitle, "Log in");
	}
	
	@Description("T007_Verifying whether user can't login to the application when clicking 'login' when user give correct uname and incorrect password")
	@Test(priority=7, enabled = true)
	public void correctUnameIncorrectPasswordLoginTest() {
		loginPageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		loginPage = new LoginPage(driver);
		loginPage.negativeLogin(configProperties.property.getProperty("uname"), "incorrectPassworD");
		Assert.assertEquals(loginPageTitle, "Log in");
		//To avoid user locking
		loginPage.clearTextBoxes();
		loginPage.doLogin(configProperties.property.getProperty("uname"), configProperties.property.getProperty("password"));
	}
	
	@Description("T008_Verifying whether user can't login to the application when giving special characters and incorrect format of email to uname field")
	@Test(priority=8, enabled = true)
	public void specialCharactersToEmailLoginTest() {
		loginPageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		loginPage = new LoginPage(driver);
		loginPage.doLogin("@@##$%^&&123asd", configProperties.property.getProperty("password"));
		Assert.assertEquals(loginPageTitle, "Log in");
	}
	
	@Description("T009_Verifying whether user can login to the application by giving correct user name and password")
	@Test(priority=9, enabled = true)
	public void doLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(configProperties.property.getProperty("uname"), configProperties.property.getProperty("password"));
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Pipedrive");
	}
	
	@Description("T010_Verifying whether user can login to the application by giving correct user name and password and clicking ENTER")
	@Test(priority=10, enabled = true)
	public void doLoginWithEnterTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLoginWithEnter(configProperties.property.getProperty("uname"), configProperties.property.getProperty("password"));
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Pipedrive");
	}
	
	@Description("T011_Verifying whether user going to correct page after locking the user")
	@Test(priority=11, enabled = true)
	public void lockedUserLoginTest() {
		loginPage = new LoginPage(driver);
		int randomNumber = loginPage.randomNumberGenerator();
		//Locking the Account by give incorrect user name for 3 times
		loginPage.doLogin("incorrectEmail"+randomNumber+"@yahoo.com", configProperties.property.getProperty("password"));
		loginPage.doLogin("incorrectEmail"+randomNumber+"@yahoo.com", configProperties.property.getProperty("password"));
		loginPage.doLogin("incorrectEmail"+randomNumber+"@yahoo.com", configProperties.property.getProperty("password"));
		lockedPageTitle = page.getInstance(LoginPage.class).getLockedPageTitle();
		Assert.assertEquals(lockedPageTitle, "Account locked");
	}
}
