package applicationTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverInitialization.DriverSetUp;
import pageObjects.LoginPage;

public class LoginTest extends DriverSetUp{
	LoginPage login;


	@BeforeMethod
	public void setUp(){
		login = new LoginPage(driver);	
	}
	
	@Test
	public void loginToApp() throws InterruptedException {
		login.clickOnLogin();
	}
}
