package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SharajmanTechnologies 
{
	//This is task one.
	
	@Test
	void taskOne()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//span[contains (text(),'selenium')]"));
		
		for(WebElement singleSuggestion:autoSuggestions)
		{
			System.out.println(singleSuggestion.getText());
		}
	}
	
	//This is task two.
	@Test
	void taskTwo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://dev.panaaya.in/test/test-example/table.html");
		List<WebElement> data = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		for(WebElement singledata:data)
		{
			System.out.println(singledata.getText());
		}

	}
}
