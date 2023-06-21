package vtiger.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 
{	
	/**
	 * It will wait for specific time till the page get loaded.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICITWAIT));
	}
	/**
	 * It is used to maximize the browser window.
	 * @param driver
	 */
	public void maximizeTheWebpage(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * It will wait till the desired web page gets loaded and get its title.
	 * @param driver
	 * @param title
	 */
	public void waitForTheTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICITWAIT));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * It provide us with a polling time to identify an item which is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForTheElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * By using this method you can wait for an item which is clickable by entering polling time
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementForCustom(WebDriver driver, int pollingTime, WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofMillis(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * It is an method to give custom timeout
	 * @param element
	 * @throws InterruptedException
	 */
	//*****************************************************************************
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while (count < 10) 
		{
			try 
			{
				element.click();
			} 
			catch (Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * It is used to switch from one window to another window
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver, String partialWindow) 
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) 
		{
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if(currentWindow.contains(partialWindow)) 
			{
				break;
			}
		}
	}
	/**
	 * It is used to switch from one frame to another frame using index number
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * It is used to switch from one frame to another frame using id_attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_attribute)
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * It is used to switch from one frame to another frame by identifying WebElement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * It is used to switch back from child frame to parent frame.
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * It is used to accept an alert pop up.
	 * @param driver
	 */
	public void selectOkInAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * It is used to switch to alert pop up and dismiss
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * It is used to select an option from the drop down. 
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, String option)
	{
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * It is used to switch to dropdown using index value
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * It is used to switch to dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * It is used to switch to dropdown using visible text
	 * @param element
	 * @param visible_text
	 */
	public void selectDropDownByVtext(WebElement element, String visible_text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visible_text);
	}
	/**
	 * It is used to move mouse pointer on a specific element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * It is used to perform right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	/**
	 * It is used to click on Enter button using keyboard actions
	 * @param driver
	 * @param element
	 */
	public void clickOnEnterButton(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * It is used to perform scroll bar actions
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor javascript= (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,500)");
	}
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable 
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		java.io.File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		java.io.File dst = new java.io.File("./screenshots/" + screenShotName + ".PNG");
		Files.copy(src, dst);
		return screenShotName;
	}
}
