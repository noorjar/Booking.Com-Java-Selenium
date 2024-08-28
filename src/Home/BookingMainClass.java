package Home;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class BookingMainClass extends BookingParametrsClass {

	@BeforeTest
	public void mysetup() {
		GeneralSetUp();
		closePopupIfPresent();
	}

	@Test(priority = 1,enabled = false)
	public void VerifyDefaultLanguage() {
		closePopupIfPresent();
		boolean IslangEn = driver.findElement(By.tagName("html")).getAttribute("lang").contains("en");
		Assert.assertEquals(IslangEn, ExpectedLang);
		
	}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 2,enabled = false)
	public void VerifyDefaultCurrency() {
		closePopupIfPresent();
		WebElement currencyPickerButton = driver.findElement(By.cssSelector("button[data-testid='header-currency-picker-trigger']"));
		String actualCurrency  = currencyPickerButton.getAttribute("aria-label");
		Assert.assertEquals(actualCurrency , expectedCurrency);
		
	}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 3,enabled = false)
	public void FlightsTabIsNotSelected() {
		closePopupIfPresent();
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
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 4,enabled = false)
	public void VerifyCustomerSupportlinkinHeader() {
		closePopupIfPresent();
		WebElement customerSupportLink = driver.findElement(By.cssSelector("a[aria-label='Customer support']"));
		String actualCustomerSupportLink =  customerSupportLink.getAttribute("aria-label");
		Assert.assertEquals(actualCustomerSupportLink, expectedCustomerSupportLink );
		
	}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 5,enabled = false)
	public void ChangeLanguage() {
		closePopupIfPresent();
		WebElement languagePickerButton = driver. findElement(By.cssSelector("button[data-testid='header-language-picker-trigger']"));
		languagePickerButton.click();
		WebElement languageOptionsContainer =driver.findElement(By.xpath("//ul[@style='--bui_stack_spaced_gap--s: 4;']"));
		List<WebElement> languageList  = languageOptionsContainer.findElements(By.tagName("li"));
		int randomNumbertoSelectLanguage =rand.nextInt(languageList.size());
		languageList.get(randomNumbertoSelectLanguage).click();
		closePopupIfPresent();
		}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 6,enabled = true)
	public void SearchforHotels() throws InterruptedException {
	closePopupIfPresent();
	WebElement HotelsTab = driver.findElement(By.cssSelector(".a7dc8ec444"));
	HotelsTab.click();
	
	WebElement searchInput  = driver.findElement(By.id(":rh:"));
	searchInput .clear();
	searchInput .sendKeys("New York");
	
	Thread.sleep(5000);
	WebElement SearchButton =driver.findElement(By.cssSelector("button[type='submit']"));	
	
	WebElement suggestionsContainer = driver.findElement(By.xpath("//ul[@role='group']"));
	List<WebElement> suggestionList  = suggestionsContainer .findElements(By.tagName("li"));
	
	WebElement thirdSuggestion  =  suggestionList .get(2);
	thirdSuggestion .click();
	//SearchButton.click();
		}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 7,enabled = true)
	public void CheckInAndCheckOut() {
		closePopupIfPresent();

	}
	}

