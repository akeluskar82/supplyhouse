package com.supplyhouse.automation.helperutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	protected static WebDriver driver;

	public WebElement waitForElementToAppear(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return driver.findElement(by);
	}

	public void getDriverInstance() {
		driver = new FirefoxDriver();

	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void closeDriver() {
		driver.close();
	}

}
