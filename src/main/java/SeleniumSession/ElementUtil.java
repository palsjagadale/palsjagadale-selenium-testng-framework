package SeleniumSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static By getBy(String locatortype, String locatorValue) {
		By locator = null;
		switch (locatortype) {

		case "id":
			locator = By.id(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "name":
			locator = By.name(locatorValue);
			break;

		case "className":
			locator = By.className(locatorValue);
			break;

		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;

		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;

		default:
			System.out.println("Please pass correct locator");
			break;
		}

		return locator;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement getElement(String locatortype, String locatorValue) {

		return driver.findElement(getBy(locatortype, locatorValue));
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetAttribute(By locator, String AttrName) {
		return getElement(locator).getAttribute(AttrName);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doEnable(By locator) {
		return getElement(locator).isEnabled();
	}

	public void clickonelement(By locator, String value) {

		List<WebElement> elelist = getElements(locator);
		System.out.println(elelist.size());

		for (WebElement e : elelist) {

			if (e.getText().equals(value)) {
				e.click();
				break;
			}

		}

	}
	// ***************************************** /Select dropdownUtils/
	// ***********************************************************

	public void doSelectByVisibleText(By locator, String Text) {

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(Text);

	}

	public void doSelectByValue(By locator, String Value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(Value);

	}

	public void doSelectByIndex(By locator, int index) {

		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);

	}

	// ******************************************* window Commands
	// ****************************************************

	public void doMaximizeWindow() {
		driver.manage().window().maximize();

	}

	public void doPageTimeout() {
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

	}

	// ************************************ without select Option
	// **********************************************************

	public String waitForURLContains(String UrlFraction, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlContains(UrlFraction))) {
			return driver.getCurrentUrl();
		}

		return null;

	}

	public String waitForURLIs(String urlvalue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(urlvalue))) {
			return driver.getCurrentUrl();
		}

		return null;

	}

	public List<String> GetDopDownOptionList(By locator) {

		List<String> optionValueList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			optionValueList.add(text);

			/*
			 * String optiontext = e.getAttribute(text); System.out.println(optiontext);
			 */
		}

		return optionValueList;

	}

	public void selectDopDownOptionList(By locator, String value) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void clickDropDownValue(By locator, String value) {

		List<WebElement> optionList = getElements(locator);
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals("value")) {
				e.click();
				break;
			}
		}

	}

	/*************************************
	 * waitUtils
	 **********************************************/

	public Alert waitForAlert(int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		String text = waitForAlert(timeOut).getText();
		acceptAlert(timeOut);
		return text;
	}

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismisstAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public void sendKeysOnAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

	/**
	 * presenceOfElementLocated : An expectation for checking that an element is
	 * present on the DOM of a page. This does not necessarily mean that the element
	 * is visible.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public WebElement waitforElementpresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitforElementpresence(By locator, int timeout, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervalTime); // no default constructor
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForElementVisibleusingWebElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));

	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public List<String> getElementTextList(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			eleTextList.add(e.getText());
		}
		return eleTextList;

	}

	public String waitForTitleContains(String titlevalue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleContains("titlevalue"))) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitForTitleIS(String fullTitle, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleIs("titlevalue"))) {
			return driver.getTitle();
		}
		return null;
	}

	public void waitForFrameANDSwitchToIt(String Framename, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Framename"));
	}

	public void waitForFrameANDSwitchToIt(By framelocator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelocator"));
	}

	public void waitForFrameANDSwitchToIt(int frameIndex, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameIndex"));
	}

	public void waitForFrameANDSwitchToIt(WebElement frameelement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameelement"));
	}

	public WebElement waitForElementwithFluentWait(By locator, int timeout, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebDriver waitForFramewithFluentWait(By locator, int timeout, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public WebElement retryElement(By locator, int maxAttempts) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < maxAttempts) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Element is not found in attempts:" + (attempts + 1));
			}
			attempts++;
		}
		return element;
	}
}
