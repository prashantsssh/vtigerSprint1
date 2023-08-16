package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyPractice
{
	@Test
	void testSpiceJetCalendar()
	{
		String month="November";
		String date="21";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.spicejet.com/");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("-disable-notifications");
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		
		driver.findElement(By.xpath("//div[text()='"+month+" ']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"+date+"']")).click();
		
	}
	@Test
	void testMakeMyTripCalendar() throws InterruptedException
	{
		String month="October";
		String date="10";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		
		WebElement notificationFrame = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		driver.switchTo().frame(notificationFrame);
		driver.findElement(By.xpath("//a[@class='close']")).click();	
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.moveByOffset(72, 230).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='"+month+" 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
	}
	@Test
	void toFetchFlightPriceFromMakeMyTrip() throws InterruptedException
	{
		String month="October";
		String date="10";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		
		WebElement notificationFrame = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		driver.switchTo().frame(notificationFrame);
		driver.findElement(By.xpath("//a[@class='close']")).click();	
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.moveByOffset(72, 230).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for(;;)
		{
			try
			{
				WebElement price = driver.findElement(By.xpath("//div[text()='"+month+" 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']/following-sibling::p[@class=' todayPrice']"));
				System.out.println(price.getText());
				driver.findElement(By.xpath("//div[text()='"+month+" 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
	}
}
