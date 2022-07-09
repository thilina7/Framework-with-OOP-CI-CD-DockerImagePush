/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author thilina.karunarathna
 *
 */
public class HomePage extends BasePage{
	
	private By header = By.className("page-heading");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}


	public String getHomePageTitle() {
		return getPageTitle();		
	}

	
	public String getHomePageHeader() {
		return getPageHeader(header);
	}
}
