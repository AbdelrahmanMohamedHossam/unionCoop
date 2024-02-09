package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class resultsPage {

	public void getElementWithInnerText(WebElement parent, String innerText) {

		WebElement get = parent.findElement(By.xpath("//*[contains(text(), '" + innerText + "')]"));

	}
	public WebElement getResultsList()
	{
		return baseClass.getDriver().findElement(By.id("rcnt"));
	}
}
