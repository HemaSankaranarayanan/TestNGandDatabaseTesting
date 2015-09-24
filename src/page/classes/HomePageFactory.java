package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	WebDriver driver;
	
	@FindBy(id="tab-flight-tab")
	WebElement flightTab;
	
	@FindBy(id="flight-origin")
	WebElement flightOrigin;
	
	@FindBy(id="flight-destination")
	WebElement flightDest;
	
	@FindBy(id="flight-departing")
	WebElement departDate;
	
	@FindBy(id="flight-returning")
	WebElement returnDate;
	
	@FindBy(id="search-button")
	WebElement searchButton;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToFlightTab() {
		flightTab.click();
	}
	
	public void fillOriginCity(String originCity) {
		flightOrigin.sendKeys(originCity);
	}
	
	public void fillDestCity(String destCity) {
		flightDest.sendKeys(destCity);
	}
	
	public void fillFromDate(String fromDate) {
		departDate.sendKeys(fromDate);
	}
	
	public void fillToDate(String toDate) {
		returnDate.sendKeys(toDate);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}

}
