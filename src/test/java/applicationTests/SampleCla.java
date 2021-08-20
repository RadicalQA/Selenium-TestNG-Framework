package applicationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(EventListner.class)

public class SampleCla  {
	WebDriver driver = null;
	@BeforeClass
	public void setup() {
	String sampleDataPath = "C:\\Users\\roware\\eclipse-workspace\\selenium-testng\\src\\main\\resources\\DriversExecutables";
		System.setProperty("webdriver.chrome.driver", sampleDataPath + "/chromedriver.exe");
		
		 driver =  new ChromeDriver();
				
	}
	
	@Test
	public void open() {
		driver.get("http://www.google.com");
	}
	@Test
	public void open1() {
		Assert.assertFalse(false);
	}
	
}
