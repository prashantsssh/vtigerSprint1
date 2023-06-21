package vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage 
{
	public LeadPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement leadsPlusButtons;
	
	public WebElement getLeadsPlusButtons() {
		return leadsPlusButtons;
	}
	
	public void clickOnLeadPlusButton()
	{
		leadsPlusButtons.click();
	}
}
