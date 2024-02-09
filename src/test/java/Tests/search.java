package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.baseClass;
import POM.homePage;
import POM.resultsPage;

public class search extends baseClass {

	@Test(priority = 1)
	void basicSearch() {
		homePage hp = new homePage();

		hp.fillTextAreaWith("Union coop");
		hp.searchProceed();

		try {

			resultsPage R = new resultsPage();
			WebElement resultsList = R.getResultsList();
			R.getElementWithInnerText(resultsList,"Uni");
			System.out.println("foundeed");

		} catch (NoSuchElementException e) {

			Assert.fail("the search result doesn't match");
		}

	}

	@Test(priority = 2)
	void emptySearch() throws InterruptedException {
		String expectedURL = baseClass.getDriver().getCurrentUrl();

		homePage hp = new homePage();
		hp.clearText();
		hp.fillTextAreaWith("");
		hp.searchProceed();
		Thread.sleep(2000);

		String currentURL = baseClass.getDriver().getCurrentUrl();

		assertEquals(currentURL, expectedURL);

	}

}
