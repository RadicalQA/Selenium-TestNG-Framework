package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonlyUsed {

	static WebDriver driver;

	public static boolean isElementPresent(By by, WebDriver driver) {
		boolean present;
		try {
			driver.findElement(by);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}

	public static Properties prop;
	static String PropertyValue;
	public static final String PropertyFile = "src/OR.properties";

	public static String getPropertyValue(String PropertyName) {
		prop = AccessPropertiesFile();

		try {
			PropertyValue = prop.getProperty(PropertyName);
		}

		catch (Exception e) {
		}
		return PropertyValue;
	}

	public static Properties AccessPropertiesFile() {
		prop = new Properties();

		// try retrieve data from file
		try {

			prop.load(new FileInputStream(PropertyFile));
		}
		// catch exception in case properties file does not exist
		catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String getSysPropertyValue(String property) {
		String PropertyNew = System.getProperty(property);

		if (PropertyNew == null || PropertyNew.isEmpty()) {
			PropertyNew = getPropertyValue(property);
		}
		return PropertyNew;

	}

	// /* Read data from ExcelSheet */
	// public static Object[][] getTableArray(String xlFilePath, String sheetName,
	// String tableName) throws Exception
	// {
	// String[][] tabArray = null;
	// try
	// {
	// Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	// Sheet sheet = workbook.getSheet(sheetName);
	// int ci,cj, totalRows = 1, totalCols = 0;
	// totalRows = sheet.getRows();
	// totalCols = sheet.getColumns();
	// System.out.println("total cols = " + totalCols);
	// System.out.println("total rows = " + totalRows);
	// tabArray=new String[totalRows-1][totalCols];
	// ci=0;
	// for (int i=1;i<totalRows;i++,ci++)
	// {
	// cj=0;
	// for (int j=0;j<totalCols;j++, cj++)
	// {
	// tabArray[ci][cj]=sheet.getCell(j,i).getContents();
	// }
	// }
	// }
	// catch (FileNotFoundException e)
	// {
	// System.out.println("File Not Found");
	// e.printStackTrace();
	// }
	// catch (IOException e)
	// {
	// System.out.println("Could not read the Excel sheet");
	// e.printStackTrace();
	// }
	// return(tabArray);
	// }
	//

	public void clickOnElement(String locator, String locatorvalue) {

		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue)).click();
		}

		if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorvalue)).click();
		}

		if (locator.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorvalue)).click();
		}

		if (locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorvalue)).click();
		}

	}

	public String getElementText(String locator, String locatorvalue) {

		String temptext = null;
		if (locator.equalsIgnoreCase("id")) {
			temptext = driver.findElement(By.id(locatorvalue)).getText();
		}

		if (locator.equalsIgnoreCase("name")) {
			temptext = driver.findElement(By.name(locatorvalue)).getText();
		}

		if (locator.equalsIgnoreCase("css")) {
			temptext = driver.findElement(By.cssSelector(locatorvalue)).getText();
		}

		if (locator.equalsIgnoreCase("xpath")) {
			temptext = driver.findElement(By.xpath(locatorvalue)).getText();
		}

		return temptext;
	}

	// For entering value in text box on page

	public static void enterValueInTextbox(String locator, String locatorvalue, String data) {

		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue)).sendKeys(data);
		}

		if (locator.equalsIgnoreCase("name")) {

			driver.findElement(By.name(locatorvalue)).sendKeys(data);
		}

		if (locator.equalsIgnoreCase("css")) {

			driver.findElement(By.cssSelector(locatorvalue)).sendKeys(data);
		}

		if (locator.equalsIgnoreCase("xpath")) {

			driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
		}

	}

	/*
	 * For deleting value from text box on page
	 */
	public void deleteValueFromTextbox(String locator, String locatorvalue) {

		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorvalue)).clear();
		}

		if (locator.equalsIgnoreCase("name")) {

			driver.findElement(By.name(locatorvalue)).clear();
		}

		if (locator.equalsIgnoreCase("css")) {

			driver.findElement(By.cssSelector(locatorvalue)).clear();
		}

		if (locator.equalsIgnoreCase("xpath")) {

			driver.findElement(By.xpath(locatorvalue)).clear();
		}

	}

	/*
	 * For getting attribute value for element on page
	 */
	public String getAttributeValue(String locator, String locatorvalue, String attributename) {

		String temptext = null;
		if (locator.equalsIgnoreCase("id")) {
			WebElement e = driver.findElement(By.id(locatorvalue));
			temptext = e.getAttribute(attributename);
		}

		if (locator.equalsIgnoreCase("name")) {
			WebElement e = driver.findElement(By.name(locatorvalue));
			temptext = e.getAttribute(attributename);
		}

		if (locator.equalsIgnoreCase("css")) {
			WebElement e = driver.findElement(By.cssSelector(locatorvalue));
			temptext = e.getAttribute(attributename);
		}

		if (locator.equalsIgnoreCase("xpath")) {
			WebElement e = driver.findElement(By.xpath(locatorvalue));
			temptext = e.getAttribute(attributename);
		}

		return temptext;
	}

	/*
	 * For clicking on specified item from dropdown list
	 */
	public void toClickOnSpecifiedItemFromDropdown(String divid, String ItemToClick) {
		String tempcss = "div#" + divid + " li";
		int count = driver.findElements(By.cssSelector(tempcss)).size();

		for (int i = 2; i < count; i++) {

			String locatorvalue = "div#" + divid + " li:nth-of-type(" + i + ")";
			String temp = driver.findElement(By.cssSelector(locatorvalue)).getText();
			if (temp.equals(ItemToClick)) {
				// System.out.println("Got required element");
				driver.findElement(By.cssSelector(locatorvalue)).click();
				break;
			}

		}
	}

	/*
	 * To navigate given Url
	 */
	public void toGoToUrl(String Url) throws InterruptedException {
		Thread.sleep(10000);
		driver.get(Url);
	}

	/*
	 * To select value from drop down list using Visible text
	 */
	public void selectValueFromDropdownList(String locatortype, String locatorvalue, String visibletext) {
		if (locatortype.equalsIgnoreCase("id")) {
			new Select(driver.findElement(By.id(locatorvalue))).selectByVisibleText(visibletext);
		}

	}

	/*
	 * To select value from drop down list using Index
	 */
	public void selectValueFromDropdownListUsingIndex(String locatortype, String locatorvalue, int index) {
		if (locatortype.equalsIgnoreCase("id")) {
			new Select(driver.findElement(By.id(locatorvalue))).selectByIndex(index);
		}

	}

	/*
	 * To get selected value from drop down list
	 */
	public String getSelectedValueFromDropdownList(String locatortype, String locatorvalue) {
		String selectedtext = null;
		if (locatortype.equalsIgnoreCase("id")) {
			WebElement element = new Select(driver.findElement(By.id(locatorvalue))).getFirstSelectedOption();
			selectedtext = element.getText();

		}
		return selectedtext;

	}

	/*
	 * Accept JS alert and get it's text
	 */
	public String acceptAlertAndGetText() {
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		alert.accept();

		return AlertText;
	}

	/*
	 * Dismiss JS alert and get it's text
	 */
	public String dismisAlertAndGetText() {
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		alert.dismiss();

		return AlertText;
	}

	/*
	 * To get current page url
	 */
	public String toGetCurrentPageUrl() {
		return driver.getCurrentUrl();

	}

	/* To mouse hover on element */
	public void toMouseHover(String locator, String locatorvalue) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(locatorvalue));
		action.moveToElement(element).build().perform();
		Thread.sleep(5000);

		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";

		WebElement element1 = driver.findElement(By.cssSelector(locatorvalue));
		((JavascriptExecutor) driver).executeScript(javaScript, element1);

		Thread.sleep(5000);

	}

	public static void clickByJavascript(WebDriver driver, String value) {
		WebElement element = driver.findElement(By.xpath(value));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
