package hematestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.classes.HomePageFactory;

public class PageFactoryTest {
	private WebDriver driver;
	private String baseUrl;
	HomePageFactory homepage;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com";
		driver.manage().window().maximize();
		homepage = new HomePageFactory(driver);
	}
	
	
	@Test
	public void test() {
		driver.get(baseUrl);
		homepage.navigateToFlightTab();
		homepage.fillOriginCity("San Francisco");
		homepage.fillDestCity("Houston");
		homepage.fillFromDate("10/14/2015");
		homepage.fillToDate("10/17/2015");
		homepage.clickSearchButton();
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	

}
