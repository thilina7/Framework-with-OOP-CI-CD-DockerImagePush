/**
 * 
 */
package com.mypages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author thilina.karunarathna
 *
 */
public class LoginPage extends BasePage{
	
	//Page locators:
	private By emailID = By.cssSelector("#login");
	private By password = By.cssSelector("#password");
	private By loginBtn = By.cssSelector(".submit-button");
	private By header = By.cssSelector("span.header__login-text");
	private By emailValidation = By.cssSelector(".pb-form__error");
	private By passwordValidation = By.cssSelector(".pb-form__error");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//public getters

	/**
	 * @return the emailID
	 */
	public WebElement getEmailID() {
		return getElement(emailID);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}


	public String getLoginPageTitle() {
		return getPageTitle();		
	}
	
	public String getLockedPageTitle() {
		return getPageTitle();		
	}

	
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	
	public WebElement getEmailValidation() {
		return getElement(emailValidation);
	}
	
	public List<WebElement> getPasswordValidation() {
		return getElements(passwordValidation);
	}
	
	public int randomNumberGenerator() {
		Random rand = new Random();
		int upperbound = 999999;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound); 
      return int_random;
	}
	
	public void clearTextBoxes() {
		getEmailID().clear();
		getPassword().clear();
	}
	
	public void clearPasswordField() {
		getPassword().clear();
	}
	
	//Happypath test case- This should be pass
	public HomePage doLogin(String uname,String password) {
		getEmailID().sendKeys(uname);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		
		//Creating object of landing page class
		return getInstance(HomePage.class);
	}
	
	public HomePage doLoginWithEnter(String uname,String password) {
		getEmailID().sendKeys(uname);
		getPassword().sendKeys(password);
		getLoginBtn().sendKeys(Keys.ENTER);
		
		//Creating object of landing page class
		return getInstance(HomePage.class);
	}
	
	//Negative testcase with method overloading
	
	public void doLogin() {
		getEmailID().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
	
	public void negativeLogin(String uname,String password) {
		getEmailID().sendKeys(uname);
		getPassword().sendKeys(password);
		getLoginBtn().click();
	}
	
	//Negative testcase : this will check "give correct uname or password and other field is empty"
	// username : thili7@yahoo.com
	// password : PassworD2.
	public void doLogin(String userCred) {
		
		if(userCred.contains("username")) {
			getEmailID().sendKeys(userCred.split(":")[1].trim());
		}else if (userCred.contains("password")) {
			getPassword().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginBtn().click();
	}
}

