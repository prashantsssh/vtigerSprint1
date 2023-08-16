package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vtiger.genericUtility.ListenersImplementationClass.class)

public class DevStringx 
{
	@Test
	void test() throws AWTException, InterruptedException
	{
		//WARNING    -     CHANGE THE VALUE OF 'actualInviteeName' every times before running.
		String actualInviteeName="prashant.sssh@gmail.com";
		
		
		//Navigating to URL
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.msnagile.com/login?url=testing");
		
		//Handling POP-UP
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		//Identifying elements on Login Button.
		WebElement usernameTextField = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@aria-label='LOGIN']"));
		
		//Logging in
		Actions action=new Actions(driver);
		action.sendKeys(usernameTextField, "shweta.tyagi@devstringx.com").sendKeys(passwordTextField, "123456").perform();
		action.sendKeys(passwordTextField, "123456");
		loginButton.click();
		
		//Test starts
		WebElement manageUsersTab = driver.findElement(By.xpath("//span[text()=' Manage Users & Groups']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", manageUsersTab);
		driver.findElement(By.id("managUserBtn")).click();
		
		//Clicking on Create Button
		driver.findElement(By.id("inviteUserButton")).click();
		
		//Creating invitee
		WebElement inviteUserEmailBox = driver.findElement(By.id("emailfield"));
		inviteUserEmailBox.sendKeys(actualInviteeName);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		WebElement closeConfirmationBox=driver.findElement(By.xpath("//div[@class='text-right cursor-pointer']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(closeConfirmationBox));
		closeConfirmationBox.click();

		
		//Verifying the result
		WebElement expectedInviteeName = driver.findElement(By.xpath("//div[text()=' "+actualInviteeName+" ']"));
		Assert.assertTrue(expectedInviteeName.getText().contains(actualInviteeName));		
	}
}