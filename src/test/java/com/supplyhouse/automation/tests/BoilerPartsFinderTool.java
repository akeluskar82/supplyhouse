package com.supplyhouse.automation.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.supplyhouse.automation.helperutils.WebDriverUtils;

import pageobjects.BoilerPartsFinderToolPage;

public class BoilerPartsFinderTool {
	private WebDriverUtils driverUtils;

	@ParameterizedTest
	@ValueSource(strings = { "AT082410C", "AT062310C", "K2WT-150" })
	public void verifyBoilerFinderToolSearch(String modelNumber) {

		BoilerPartsFinderToolPage boilerPartsPage = new BoilerPartsFinderToolPage();
		boilerPartsPage.modelNumberSearch().sendKeys(modelNumber);
		boilerPartsPage.boilerPartsSearchButton().click();
		assertTrue(boilerPartsPage.doesModelNumberAppearInLink(modelNumber),
				"The search shows a result in which a link appears for the following model number:  " + modelNumber);
		assertTrue(boilerPartsPage.doesModelNumberAppearInText(modelNumber),
				"The search shows a result in which text appears for the following model number: " + modelNumber);

	}

	@BeforeEach
	public void setupTest() {
		driverUtils = new WebDriverUtils();
		driverUtils.getDriverInstance();
		driverUtils.loadUrl("https://www.supplyhouse.com/Boiler-Parts-Finder-Tool");
	}

	@AfterEach
	public void closeDriver() {
		driverUtils.closeDriver();
	}

}
