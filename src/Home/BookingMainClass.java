package Home;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class BookingMainClass extends BookingParametrsClass {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	public void CheckInCheckOut() throws InterruptedException {
		closePopupIfPresent();
		driver.findElement(By.className("c3953d2910")).click();
		WebElement NextmonthButton = driver.findElement(By.xpath("//button[@aria-label='Next month']"));
// Generate a random number for how many times to click the button
		Thread.sleep(10000);
		int clicks = rand.nextInt(5) + 1; 

		for (int i = 0; i < clicks; i++) {
			NextmonthButton.click();
	 }

		WebElement calendarTable = driver.findElement(By.cssSelector("body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2)"));
		List<WebElement> calendarRows  = calendarTable .findElements(By.tagName("tr"));
		calendarRows .get(0).click();
		calendarRows .get(1).click();
	}
//-------------------------------------------------------------------------------------------------------------------
	@Test (priority = 8)
	public void	 SelectRooms() throws InterruptedException {
		closePopupIfPresent();
		Thread.sleep(9000);
		WebElement r = driver.findElement(By.cssSelector(".dba1b3bddf.ead010d0b7.a080340b08.f268349634"));
		r.click();
		WebElement b=driver.findElement(By.cssSelector(".abb8c87649"));
		List<WebElement> c =b.findElements(By.className("d1821e6945"));
	    	c.get(0).click();
			c.get(2).click();// Click the element
			c.get(1).click();
			
			String arrayRooms [] = {"option[value='-1']","option[value='1'],option[value='2'],option[value='3'],option[value='4'],option[value='1'],option[value='5']"};
			int RandomRoomNumber  = rand.nextInt(arrayRooms.length);
			WebElement Rooms = driver.findElement(By.cssSelector(arrayRooms[RandomRoomNumber]));
			Rooms.click();
}
	
	@Test(priority = 9)
	public void Search () {
	WebElement SearchButton =driver.findElement(By.cssSelector("button[type='submit']"));
	SearchButton.click();
}
	
	
}