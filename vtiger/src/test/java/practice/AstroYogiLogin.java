package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AstroYogiLogin 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.astroyogi.com/");
		driver.findElement(By.id("wzrk-cancel")).click();
		
		Actions action = new Actions(driver);
		action.moveByOffset(1435, 301).perform();
		driver.findElement(By.name("LoginPhoneNumber")).sendKeys("8383893320");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}
}
