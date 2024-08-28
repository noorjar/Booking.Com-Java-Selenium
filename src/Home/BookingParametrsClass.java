package Home;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookingParametrsClass {

	WebDriver driver = new ChromeDriver();
	String BookingWebSiteLink = "https://www.booking.com";
	boolean ExpectedLang = true ;
	String expectedCurrency = "Prices in Jordanian Dinar";
	String expectedCustomerSupportLink  = "Customer support";
	boolean flightsTabNotSelected = false;
	Random rand = new Random();	
	

	
	
	
	public void GeneralSetUp() {
		driver.manage().window().maximize();
		driver.get(BookingWebSiteLink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	
	 public void closePopupIfPresent() {
	        try {
	            // Attempt to locate the close button of the popup
	            WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
	            
	            // If found, click the close button
	            if (closeButton.isDisplayed()) {
	                closeButton.click();
	                System.out.println("Popup closed.");
	            }
	        } catch (NoSuchElementException e) {
	            // No popup appeared, nothing to close
	            System.out.println("No popup appeared.");
	        } catch (Exception e) {
	            // Handle other potential exceptions
	            System.out.println("An error occurred while trying to close the popup: " + e.getMessage());
	        }
	    }
}


 
