package com.supplyhouse.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.supplyhouse.automation.helperutils.WebDriverUtils;

import pageobjects.BoilerPartsFinderToolPage;

@RunWith(JUnitPlatform.class)
public class BoilerPartsFinderTool {

	@ParameterizedTest
	@ValueSource(strings = { "AT082410C", "AT062310C", "K2WT-150" })
	public void verifyBoilerFinderToolSearch(String modelNumber) {

		WebDriverUtils driverUtils = new WebDriverUtils();
		driverUtils.getDriverInstance();
		driverUtils.loadUrl("https://www.supplyhouse.com/Boiler-Parts-Finder-Tool");
		BoilerPartsFinderToolPage boilerPartsPage = new BoilerPartsFinderToolPage();
		boilerPartsPage.modelNumberSearch().sendKeys(modelNumber);
		boilerPartsPage.boilerPartsSearchButton().click();

		try {
			Assert.assertTrue(
					"The search shows a result in which a link appears for the following model number:  " + modelNumber,
					boilerPartsPage.doesModelNumberAppearInLink(modelNumber));
			Assert.assertTrue(
					"The search shows a result in which text appears for the following model number: " + modelNumber,
					boilerPartsPage.doesModelNumberAppearInText(modelNumber));
		} finally {
			driverUtils.closeDriver();
		}

	}

}
