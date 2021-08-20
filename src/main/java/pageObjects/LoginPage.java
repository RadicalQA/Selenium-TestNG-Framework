package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonlyUsed;

public class LoginPage {
	WebDriver driver;
	CommonlyUsed cmnmth = new CommonlyUsed();
	@FindBy(name = "q787")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() throws InterruptedException {
		Thread.sleep(5000);
		loginButton.sendKeys("rwar");
		Thread.sleep(5000);
	}

}
