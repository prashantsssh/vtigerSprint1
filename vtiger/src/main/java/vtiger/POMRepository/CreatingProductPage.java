package vtiger.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vtiger.genericUtility.WebDriverUtility;

public class CreatingProductPage 
{
	WebDriver driver;
	public CreatingProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(name="sales_start_date")
	private WebElement salesStartDate;
	
	@FindBy(name = "productcategory")
	private WebElement productCategoryDropdown;
	
	@FindBy(name="sales_end_date")
	private WebElement salesEndDate;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorNameLookUpIcon;
	
	@FindBy(id = "my_file_element")
	private WebElement productImageUploadButton;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="search_text")
	private WebElement vendorSearchTextField;
	
	@FindBy(name="search_text")
	private WebElement vendorSearchInDropdown;
	
	@FindBy(name = "search")
	private WebElement vendorSearchButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getProductCategoryDropDown() {
		return productCategoryDropdown;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getVendorNameLookUpIcon() {
		return vendorNameLookUpIcon;
	}

	public WebElement getProductImageUploadButton() {
		return productImageUploadButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getVendorSearchTextField() {
		return vendorSearchTextField;
	}

	public WebElement getVendorSearchInDropdown() {
		return vendorSearchInDropdown;
	}

	public WebElement getVendorSearchButton() {
		return vendorSearchButton;
	}
	
	//Business Logic
	
	public void enterProductName(String productName)
	{
		productNameTextField.sendKeys(productName);
	}
	
	public void enterSalesStartDate(String datedateInYYYY_MM_DD_Format)
	{
		salesStartDate.sendKeys(datedateInYYYY_MM_DD_Format);
	}
	
	public void selectFromProductCategoryDropdown(String option)
	{
		Select select = new Select(productCategoryDropdown);
	}
	
	public void selectVendorNameFromVendorLookUpPage(String childWindowTitle, String vendorName, String parentWindowTitle) throws InterruptedException
	{
		vendorNameLookUpIcon.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, childWindowTitle );
		vendorSearchTextField.sendKeys(vendorName);
		vendorSearchButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		wUtils.switchToWindow(driver, parentWindowTitle);
	}
		
	public void enterSalesEndDate(String dateInYYYY_MM_DD_Format)
	{
		salesEndDate.sendKeys(dateInYYYY_MM_DD_Format);
	}
	
	public void uploadProductImage(String filePath)
	{
		String userDir = System.getProperty("user.dir");
		productImageUploadButton.sendKeys(userDir+filePath);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
