package vtiger.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage
{
	WebDriver driver;
	public VendorInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public String verifyVendorInfo(String vendorName)
	{
		return driver.findElement(By.xpath("//span[contains(text(), '"+vendorName+"')]")).getText();
	}
}
