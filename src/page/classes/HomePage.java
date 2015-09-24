package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;
	
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String originCity) {
		element = originTextBox(driver);
		element.sendKeys(originCity);
	}
	

	public static WebElement destTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}
	
	public static void fillDestTextBox(WebDriver driver, String destCity) {
		element = destTextBox(driver);
		element.sendKeys(destCity);
	}
	
	
	public static WebElement fromDate(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}
	
	public static void fillFromDate(WebDriver driver, String startDate) {
		element = fromDate(driver);
		element.sendKeys(startDate);
	}
	
	
	public static WebElement toDate(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}
	
	public static void fillToDate(WebDriver driver, String endDate) {
		element = toDate(driver);
		element.sendKeys(endDate);
	}
	
	
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	
	
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("tab-flight-tab")).click();
	}
	
}
