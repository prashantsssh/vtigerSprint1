package vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLead 
{
	public CreatingNewLead(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "salutationtype")
	private WebElement leadSalutation;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name ="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "company")
	private WebElement companyTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupByRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignToDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLeadSalutation() {
		return getLeadSalutation();
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getGroupByRadioButton() {
		return groupByRadioButton;
	}

	public WebElement getAssignToDropdown() {
		return assignToDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Bussiness Logic
	
	public void selectFromLeadsSalutationDropdown(String option)
	{
		Select select = new Select(leadSalutation);
		select.selectByVisibleText(option);
	}
	public void enterFirstName(String firstName)
	{
		firstNameTextField.sendKeys(firstName);
	}
	public void enterLastName(String lastName)
	{
		lastNameTextField.sendKeys(lastName);
	}
	public void enterCompanyName(String company)
	{
		companyTextField.sendKeys(company);
	}
	public void selectFromIndustryDropdown(String option)
	{
		Select select = new Select(industryDropdown);
		select.selectByVisibleText(option);
	}
	public void clickOnGroupRadioButton()
	{
		groupByRadioButton.click();
	}
	public void selectFromAssignToDropdown(String option)
	{
		Select select = new Select(assignToDropdown);
		select.selectByVisibleText(option);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
}
