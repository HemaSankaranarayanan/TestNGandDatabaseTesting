package hematestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.classes.HomePage;

public class PageObjectModel {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com";
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test() {
		driver.get(baseUrl);
		HomePage.navigateToFlightsTab(driver);
		HomePage.fillOriginTextBox(driver, "San Francisco");
		HomePage.fillDestTextBox(driver, "Houston");
		HomePage.fillFromDate(driver, "10/14/2015");
		HomePage.fillToDate(driver, "10/17/2015");
		HomePage.clickOnSearchButton(driver);
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	

}
