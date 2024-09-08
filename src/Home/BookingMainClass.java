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
import org.openqa.selenium.interactions.Actions;
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
//-------------------------------------------------------------------------------------------------------------------

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
	@Test(priority = 7,enabled = true)
	public void SearchforHotels() throws InterruptedException {
	closePopupIfPresent();
	WebElement HotelsTab = driver.findElement(By.cssSelector(".b7ab62d599"));
	HotelsTab.click();
	
	WebElement searchInput  = driver.findElement(By.xpath("//input[@id=':rh:']"));
	searchInput .clear();
	searchInput .sendKeys("New York");
	
	Thread.sleep(10000);


	WebElement suggestionsContainer = driver.findElement(By.id("autocomplete-results"));
	List<WebElement> suggestionList  = suggestionsContainer .findElements(By.tagName("li"));
	
	WebElement thirdSuggestion  =  suggestionList .get(2);
	thirdSuggestion .click();

		}
//-------------------------------------------------------------------------------------------------------------------
	@Test(priority = 6,enabled = true)
	public void CheckInCheckOut() throws InterruptedException {
		closePopupIfPresent();
		
		driver.findElement(By.className("a1139161bf")).click();
		
		
		while (true) {
			String month = driver.findElement(By.xpath("(//h3[@aria-live = 'polite'])[1]")).getText();
			if (month.equals(myMonth)){
				break;
				
			}
			else {
				driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
			}
			WebElement calendarTable = driver.findElement(By.xpath("(//table[@class = 'eb03f3f27f'])[1]"));
			List<WebElement> calendarRows  = calendarTable .findElements(By.tagName("td"));
			for(WebElement element:calendarRows) {
				String date = element.getText();
				if (date.equals(myDate)) {
					element.click();
					break;
				}
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////
		while (true) {
			String month1 = driver.findElement(By.xpath("(//h3[@aria-live = 'polite'])[2]")).getText();
			if (month1.equals(myMonth1)){
				break;
				
			}
			else {
				driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
			}
			WebElement calendarTable1 = driver.findElement(By.xpath("(//table[@class = 'eb03f3f27f'])[2]"));
			List<WebElement> calendarRows1  = calendarTable1 .findElements(By.tagName("td"));
			for(WebElement element1:calendarRows1) {
				String date1 = element1.getText();
				if (date1.equals(myDate1)) {
					element1.click();
					break;
				}
			}
		}
		

	}
//-------------------------------------------------------------------------------------------------------------------
	@Test (priority = 8,enabled = true)
	public void	 SelectRooms() throws InterruptedException {
		closePopupIfPresent();
		WebElement RoomsTab = driver.findElement(By.className("d777d2b248"));
		RoomsTab.click();
	
		
		
		while (true) {
			String Adults = driver.findElement(By.xpath("(//span[@class = 'd723d73d5f'])[1]")).getText();
			if (Adults.equals(myAdults)){
				break;
				
			}
			else {
				driver.findElement(By.xpath("(//button[@tabindex = '-1'])[2]")).click();
			}
		}
		while (true) {
			String Rooms = driver.findElement(By.xpath("(//span[@class = 'd723d73d5f'])[3]")).getText();
			if (Rooms.equals(myRooms)){
				break;
				
			}
			else {
				driver.findElement(By.xpath("(//button[@tabindex = '-1'])[6]")).click();
			}
		}
		while (true) {
			String Child = driver.findElement(By.xpath("(//span[@class = 'd723d73d5f'])[2]")).getText();
			if (Child.equals(myChildren)){
				break;
				
			}
			else {
				driver.findElement(By.xpath("(//button[@tabindex = '-1'])[4]")).click();
			}
			
		}
		WebElement SelectTag = driver.findElement(By.className("ebf4591c8e"));
		Select select = new Select(SelectTag);
		
		int totalOptions = select.getOptions().size();
		int randomNumber = rand.nextInt(totalOptions - 1) + 1;
		select.selectByIndex(randomNumber);
}
//-------------------------------------------------------------------------------------------------------------------
	
	@Test(priority = 9,enabled = true)
	public void Search () {
	WebElement SearchButton =driver.findElement(By.cssSelector("button[type='submit']"));
	SearchButton.click();
}
//-------------------------------------------------------------------------------------------------------------------
	
	@Test(priority = 10,enabled = true)
	public void filter () {
		closePopupIfPresent();
		driver.findElement(By.xpath("//button[@aria-label='Close map']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(scrollTo(0,2450))");
		
		WebElement PropertyRatingContainer =driver.findElement(By.xpath("//div[@data-filters-group='class']"));
		
		List<WebElement> PropertyRating = PropertyRatingContainer.findElements(By.tagName("svg"));
		PropertyRating.get(1).click();
		PropertyRating.get(2).click();
	}
//------------------------------------------------------------------------------------------------------------------
	@Test(priority = 11,enabled = true)
	public void filter2 () {
		closePopupIfPresent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(scrollTo(0,1550))");
		
		WebElement ReviewScoreContainer =driver.findElement(By.xpath("//div[@data-filters-group='review_score']"));
		
		List<WebElement> ReviewScore = ReviewScoreContainer.findElements(By.tagName("svg"));
		ReviewScore.get(1).click();
	}
//------------------------------------------------------------------------------------------------------------------
	@Test(priority = 12,enabled = true)
	public void filter3 () {
		closePopupIfPresent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(scrollTo(0,1550))");
		
		WebElement PropertyTypeContainer =driver.findElement(By.xpath("//div[@data-filters-group='ht_id']"));
		
		List<WebElement> PropertyType = PropertyTypeContainer.findElements(By.tagName("svg"));
		PropertyType.get(0).click();
	}
//------------------------------------------------------------------------------------------------------------------
	@Test(priority = 13,enabled = true)
	public void filter4 () {
		closePopupIfPresent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(scrollTo(0,1550))");
		
		WebElement PriceContainer =driver.findElement(By.xpath("//div[@data-filters-group='price']"));
		
	WebElement Slider= PriceContainer.findElement(By.className("f3c828a390"));
		 Actions action = new Actions(driver);

	        // Move the slider by a specific offset (this will vary depending on the slider's width)
	        action.clickAndHold(Slider).moveByOffset(50, 0).release().perform();
	}
//------------------------------------------------------------------------------------------------------------------
	@Test(priority = 14,enabled = true)
	public void Sort () {
		closePopupIfPresent();
		
		WebElement SortByTab =driver.findElement(By.className("cac967781c"));
		SortByTab.click();
		
	WebElement UlContainer =driver.findElement(By.className("ad7c39949a"));
	List<WebElement>LiList = UlContainer.findElements(By.tagName("li"));
	int RandomNumberofLista =rand.nextInt(LiList.size());
	LiList.get(RandomNumberofLista).click();
	}
//------------------------------------------------------------------------------------------------------------------
	
}