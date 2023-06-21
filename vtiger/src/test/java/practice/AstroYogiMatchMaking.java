package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class AstroYogiMatchMaking 
{
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
	//	ChromeOptions option = new ChromeOptions();
	//	option.addArguments("-disable-notifications");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.astroyogi.com/");
		driver.findElement(By.id("wzrk-cancel")).click();
		
		Actions action = new Actions(driver);
		action.moveByOffset(1435, 301).perform(); 
			
		driver.findElement(By.linkText("More ￬")).click();
		driver.findElement(By.id("matchmakingtopmenu")).click();
		
		driver.findElement(By.id("Kund_M_Name")).sendKeys("Jack");
		
		WebElement maleDateDropdown = driver.findElement(By.id("Kund_M_Date"));
		maleDateDropdown.click();
		Select selectMaleDate = new Select(maleDateDropdown);
		
		selectMaleDate.selectByVisibleText("21");
		
		WebElement maleMonthDropdown = driver.findElement(By.id("Kund_M_Month"));
		Select selectMaleMonth = new Select(maleMonthDropdown);
		selectMaleMonth.selectByValue("5");
		
		WebElement maleYearDropdown = driver.findElement(By.id("Kund_M_Year"));
		Select selectMaleYear = new Select(maleYearDropdown);
		selectMaleYear.selectByValue("1999");
		
		WebElement maleHourDropdown = driver.findElement(By.id("Kund_M_BirthPlace_Hour"));
		Select selectMaleHour = new Select(maleHourDropdown);
		selectMaleHour.selectByValue("7");
		
		WebElement maleMinuteDropdown = driver.findElement(By.id("Kund_M_BirthPlace_Minute"));
		Select selectMaleMinute = new Select(maleMinuteDropdown);
		selectMaleMinute.selectByValue("48");
		
		WebElement male_am_pm_Dropdown = driver.findElement(By.id("Kund_M_BirthPlace_AM"));
		Select selectMale_am_pm=new Select(male_am_pm_Dropdown);
		selectMale_am_pm.selectByVisibleText("AM");
		
		WebElement maleBirthPlaceDropdown = driver.findElement(By.id("Kund_M_BirthPlace"));
		
		Actions selectMaleBirthPlace = new Actions(driver);
		selectMaleBirthPlace.sendKeys(maleBirthPlaceDropdown, "Delhi, Delhi, IN").perform();
		Thread.sleep(2000);
		selectMaleBirthPlace.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.id("Kund_F_Name")).sendKeys("Jill");
		
		WebElement femaleDateDropdown = driver.findElement(By.id("Kund_F_Date"));
		Select selectFemaleDate = new Select(femaleDateDropdown);
		selectFemaleDate.selectByValue("15");
		
		WebElement femaleMonthDropdown = driver.findElement(By.id("Kund_F_Month"));
		Select selectFemaleMonth = new Select(femaleMonthDropdown);
		selectFemaleMonth.selectByValue("12");
		
		WebElement femaleYearDropdown = driver.findElement(By.id("Kund_F_Year"));
		Select selectFemaleYear = new Select(femaleYearDropdown);
		selectFemaleYear.selectByValue("2000");
		
		WebElement femaleHourDropdown = driver.findElement(By.id("Kund_F_BirthPlace_Hour"));
		Select selectFemaleHour = new Select(femaleHourDropdown);
		selectFemaleHour.selectByValue("9");
		
		WebElement femaleMinuteDropdown = driver.findElement(By.id("Kund_F_BirthPlace_Minute"));
		Select selectFemaleMinute = new Select(femaleMinuteDropdown);
		selectFemaleMinute.selectByValue("19");
			
		WebElement female_am_pm_Dropdown = driver.findElement(By.id("Kund_M_BirthPlace_AM"));
		Select selectFemale_am_pm=new Select(female_am_pm_Dropdown);
		selectFemale_am_pm.selectByVisibleText("PM");
		
		WebElement femaleBirthPlaceDropdown = driver.findElement(By.id("Kund_F_BirthPlace"));
		
		Actions selectFemaleBirthPlace = new Actions(driver);
		selectFemaleBirthPlace.sendKeys(femaleBirthPlaceDropdown, "Delhi, Delhi, IN").perform();
		Thread.sleep(2000);
		selectFemaleBirthPlace.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.id("kundli_matching_btn")).click();
	}
}
