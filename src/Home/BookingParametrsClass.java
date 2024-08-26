package Home;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingParametrsClass {

	WebDriver driver = new ChromeDriver();
	String BookingWebSiteLink = "https://www.booking.com/?selected_currency=USD";
	boolean ExpectedLang = true ;
	String expectedCurrency = "USD";
	String ExpectedCustomerServiceLink = "Contact Customer Service";
	boolean flightsTabNotSelected = false;
	
	public void GeneralSetUp() {
		driver.manage().window().maximize();
		driver.get(BookingWebSiteLink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
 
	}
	
}
