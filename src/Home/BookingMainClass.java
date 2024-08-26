package Home;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class BookingMainClass extends BookingParametrsClass {

	@BeforeTest
	public void mysetup() {
		GeneralSetUp();

	}

	@Test(priority = 1)
	public void VerifyDefaultLanguage() {
		boolean IslangEn = driver.findElement(By.tagName("html")).getAttribute("lang").contains("en");
		Assert.assertEquals(IslangEn, ExpectedLang);
	}

	@Test(priority = 2)
	public void VerifyDefaultCurrency() {
		WebElement HeaderContainer = driver.findElement(By.cssSelector(".Header_bar"));
		WebElement currencyButton = HeaderContainer
				.findElement(By.cssSelector("button[data-testid='header-currency-picker-trigger']"));
		String actualCurrency = currencyButton.getText();
	
		Assert.assertEquals(actualCurrency, expectedCurrency);
	}

	@Test(priority = 3)
	public void FlightsTabIsNotSelected() {
		WebElement ULContainerNavList = driver
				.findElement(By.cssSelector("nav[aria-label='What are you looking for?'] ul[class='d1b2041e44']"));
		List<WebElement> listItems = ULContainerNavList.findElements(By.tagName("li"));

		for (WebElement listItem : listItems) {
			// Check if the list item contains the text "Flights"
			if (listItem.getText().contains("Flights")) {
				// Check if the list item does not have the 'f62c02908f' class
				if (!listItem.getAttribute("class").contains("f62c02908f")) {
					flightsTabNotSelected = true;
					break; 
				}
			}
		}
		Assert.assertEquals(flightsTabNotSelected, true);

	}

	@Test(priority = 3)
	public void VerifyCustomerSupportlinkintheFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 4000);");

		WebElement ULcontainerinFooter = driver.findElement(
				By.cssSelector("div[data-testid='footer-group_support'] ul[class='b3605c5e50 bdfadf615e']"));
		String ActualCustomerServiceLink = ULcontainerinFooter.findElement(By.linkText("Contact Customer Service")).getText();
		Assert.assertEquals(ActualCustomerServiceLink, ExpectedCustomerServiceLink);
	}

}
