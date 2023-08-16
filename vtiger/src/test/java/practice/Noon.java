package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Noon
{
	@Test
	void testNoonSearchElectronicBag()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.noon.com/uae-en/");
		driver.findElement(By.id("searchBar")).sendKeys("electronics");
		driver.findElement(By.xpath("//div[text()=' bag']")).click();
	}	
	@Test
	void countSliderImages()
	{
		
	}
	
	
}
