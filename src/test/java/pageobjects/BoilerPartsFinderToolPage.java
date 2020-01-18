package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.supplyhouse.automation.helperutils.WebDriverUtils;

public class BoilerPartsFinderToolPage extends WebDriverUtils {

	private static final int TIMEOUT_IN_SECONDS = 10;

	public WebElement modelNumberSearch() {
		return waitForElementToAppear(By.id("model-number"), TIMEOUT_IN_SECONDS);
	}

	public WebElement boilerPartsSearchButton() {
		return waitForElementToAppear(By.xpath("//button[text()='Search']"), TIMEOUT_IN_SECONDS);
	}

	public boolean doesModelNumberAppearInLink(String modelNumber) {
		return waitForElementToAppear(By.partialLinkText(modelNumber), TIMEOUT_IN_SECONDS).isDisplayed();
	}

	public boolean doesModelNumberAppearInText(String modelNumber) {
		return driver.getPageSource().contains(modelNumber);
	}
}
