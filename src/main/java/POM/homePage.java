package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class homePage {

	public WebElement textAreaElement() {
		return baseClass.getDriver().findElement(By.id("APjFqb"));
	}

	public void fillTextAreaWith(String searchInput) {
		WebElement textArea = baseClass.getDriver().findElement(By.id("APjFqb"));

		textArea.sendKeys(searchInput);

	}

	public String getTextAreaText() {
		WebElement textArea = baseClass.getDriver().findElement(By.id("APjFqb"));

		return textArea.getText();

	}

	public void clearText() {
		WebElement clearButton = baseClass.getDriver().findElement(By.cssSelector("div[jsname='pkjasb']"));
		clearButton.click();
	}

	public void searchProceed() {
		WebElement textArea = baseClass.getDriver().findElement(By.id("APjFqb"));
		textArea.sendKeys(Keys.ENTER);

	}

	public void getElementWithInnerText(WebElement parent, String innerText) {

		WebElement get = parent.findElement(By.xpath("//*[contains(text(), '" + innerText + "')]"));

	}

	public WebElement getSuggestionsListElement() {
		return baseClass.getDriver().findElement(By.id("Alh6id"));
	}

	public void changeLanguage() {
		WebElement languageParent = baseClass.getDriver().findElement(By.id("SIvCob"));
		try {
			WebElement languageLink = languageParent.findElement(By.cssSelector("a[dir = 'rtl']"));
			languageLink.click();

		} catch (NoSuchElementException e) {
			WebElement languageLink = languageParent.findElement(By.cssSelector("a[dir = 'ltr']"));
			languageLink.click();

		}

	}

	public void openKeyboard() {
		// baseClass.getDriver().manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);

		WebElement keyboardIcon = baseClass.getDriver().findElement(By.cssSelector("span[class = 'ly0Ckb']"));

		keyboardIcon.click();
	}

	public void closeKeyboard() {
		// baseClass.getDriver().manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);

		try {

			WebElement googleFlag = baseClass.getDriver().findElement(By.id("GOOGLE_INPUT_NON_CHEXT_FLAG"));
			String flag = googleFlag.getAttribute("is_input_active");
			if (flag.equals("true")) {
				WebElement closeIcon = baseClass.getDriver()
						.findElement(By.cssSelector("div[class = 'vk-t-btn ita-kd-img vk-sf-cl' ]"));
				closeIcon.click();
			}

		} catch (NoSuchElementException e) {
			System.out.println("=============>> the keyboard is alraedy closed");
		}

	}

}
