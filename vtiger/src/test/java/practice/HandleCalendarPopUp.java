package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleCalendarPopUp 
{
	public static void main(String[] args) 
	{
		String month="September";
		String day="28";
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		for(;;)
			try {
					driver.findElement(By.xpath("//div[text()='"+month+" ']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"+day+"']")).click();
					break;
			}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
		}
	}	
}
