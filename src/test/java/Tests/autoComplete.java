package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM.baseClass;
import POM.homePage;

public class autoComplete extends baseClass {

	@Test(priority = 1)
	void confirmRelevantData() throws InterruptedException {
		homePage hp = new homePage();
		hp.fillTextAreaWith("abdelrahman");

		Thread.sleep(2000);

		try {
			WebElement suggestionList = hp.getSuggestionsListElement();
			
			hp.getElementWithInnerText(suggestionList, "a");
			
			System.out.println("suggestions matches founded");

		} catch (NoSuchElementException e) {

			Assert.fail("suggestion list results doesn't match with search keyword");

		}

	}

	@Test(priority = 2)
	void moveToSuggestions() throws InterruptedException {
		homePage hp = new homePage();

		hp.textAreaElement().sendKeys(Keys.ARROW_DOWN);
		hp.searchProceed();
		String currentText = hp.getTextAreaText();
		assertNotEquals(currentText, "abdelrahman");
	}

}
