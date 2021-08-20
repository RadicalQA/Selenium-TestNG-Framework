package driverInitialization;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;




public class DriverSetUp
{
	protected static WebDriver driver= null;
	static String sampleDataPath = "C:\\Users\\roware\\eclipse-workspace\\selenium-testng\\src\\main\\resources\\DriversExecutables";
			
	public static WebDriver getinstance()
	{
		if(driver==null){}
		return driver;
	}
		
	String browser = "Chrome";
	@Parameters({ "web-browser" })
	@BeforeSuite
    public void GetBrowser()
	{
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
		driver = new FirefoxDriver();
		System.out.println("Firefox Browser Opened Successfully");
		Reporter.log("Firefox Browser Opened Successfully");
		}
		else if(browser.equalsIgnoreCase("IE"))
			 driver =new InternetExplorerDriver();
		else if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", sampleDataPath + "/chromedriver.exe");
				driver=new ChromeDriver();	
				System.out.println("Chrome Browser Opened Successfully");
				Reporter.log("Chrome Browser Opened Successfully");
			}	
		driver.get("http://google.com");
	}
	
//	@Parameters({"website"})
//	@Test
//	public void OpenUrl(String website)
//	{
//		driver.get(website);
//		driver.manage().window().maximize();
//		System.out.println("URL Opened Successfully");
//		Reporter.log("URL Opened Successfully");
//	}
	
	
	public void winmax()
	{
		driver.manage().window().maximize();
	}
		
		

}

