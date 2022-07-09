package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			waitForElementPresent(locator);
			elements = driver.findElements(locator);
			return elements;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return elements;
	}
	
	@Override
	public Select getDropdownElement(By locator) {
		Select element = null;
		
		try {
			waitForElementPresent(locator);
			element = new Select(driver.findElement(locator));
			return element;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element" + locator.toString());
		}
	}

	@Override
	public void waitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element" + title);
		}
	}
}
