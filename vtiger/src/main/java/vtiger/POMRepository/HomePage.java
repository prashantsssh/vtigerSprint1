package vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		//********************************************
		this.driver=driver;
	}
	@FindBy(linkText = "Leads")
	private WebElement leadsModule;
	
	@FindBy(linkText = "Organizations")
	private WebElement oraganizationsModule;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText = "Products")
	private WebElement productsModule;
	
	@FindBy(linkText = "More")
	private WebElement moreDropdown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceModule;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotesModule;
	
	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOraganizationsModule() {
		return oraganizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMoreDropdown() {
		return moreDropdown;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getInvoiceModule() {
		return invoiceModule;
	}

	public WebElement getQuotesModule() {
		return quotesModule;
	}

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//Bussiness logic
	
	public void clickOnLeadModule()
	{
		leadsModule.click();
	}
	public void clickOnOrganizationsModule()
	{
		oraganizationsModule.click();
	}
	public void clickOnContactsModule()
	{
		contactsModule.click();
	}
	public void clickOnOpportunitiesModule()
	{
		opportunitiesModule.click();
	}
	public void clickOnProductsModule()
	{
		productsModule.click();
	}
	public void mouseHoverOnMoreDropdown()
	{
		Actions action = new Actions(driver);
		action.moveToElement(moreDropdown).perform();
	}
	public void clickOnCampaignsModule()
	{
		mouseHoverOnMoreDropdown();
		campaignsModule.click();
	}
	public void clickOnVendorsModule()
	{
		mouseHoverOnMoreDropdown();
		vendorsModule.click();
	}
	public void clickOnInvoiceModule()
	{
		mouseHoverOnMoreDropdown();
		invoiceModule.click();
	}
	public void logoutAction()
	{
		Actions action = new Actions(driver);
		action.moveToElement(administratorIcon).perform();
		signOutLink.click();
	}
	
	
}
