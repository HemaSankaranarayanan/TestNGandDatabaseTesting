package hematestcases;

import org.testng.annotations.Test;

import junit.framework.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestNG_TestCases {
	private WebDriver driver;
	private String baseUrl;
	
	
	@BeforeMethod
	public void beforeMethod() {
		 driver = new FirefoxDriver();
		 baseUrl = "https://expedia.com/";
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
	
	@DataProvider(name="valid usernames")
	public Object[][] createData() {
		return new Object[][] { {"Hema","Mrs"}, {"Arun","Mr"}, {"Sidharth","Mr"}};
		
	}

	@Test(priority=0, dataProvider="valid usernames", groups="imp")
	  public void test2(String name, String prefix) {
		  System.out.println("Hi " + prefix + "." + name + ". This is test case 2");
	}
	
	
  @Test(priority=1, groups="imp")
  public void test1() {
	  System.out.println("This is test case 1");	  
  }
  
  @SuppressWarnings("deprecation")
  @Test(priority=2)
  public void test3() {
	  Assert.assertTrue(false);
	  
  }
  
  @Test(priority=2, dependsOnMethods="test3")
  public void test4() {
	  System.out.println("This is test case 4");	  
  }
  
  
  

  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
