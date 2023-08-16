package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LtiMindtree
{
	@Test
	void arrayTest()
	{
		int ar[]= {14,74,25,36,85,9,12,32,65,45};
		for(int i=0; i<ar.length;i++)
		{
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[i]>ar[j])
				{
					int temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
					
				}
			}
		}
		//Now array is sorted in the ascending order and in below statement we are printing the fourth largest number.
		System.out.println("\n"+"The fourth largest number is->"+ar[6]);
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
