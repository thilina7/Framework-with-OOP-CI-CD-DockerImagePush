package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver,15);	
	}
	
	//abstact methods
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract Select getDropdownElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitforPageTitle(String title);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		return null;
		
	}
	
}
