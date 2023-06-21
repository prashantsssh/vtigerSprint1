package vtiger.produt_module_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.POMRepository.CreatingNewVendorPage;
import vtiger.POMRepository.CreatingProductPage;
import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.ProductInformationPage;
import vtiger.POMRepository.ProductPage;
import vtiger.POMRepository.VendorInformationPage;
import vtiger.POMRepository.VendorPage;
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPathConstant;
@Listeners (vtiger.genericUtility.ListenersImplementationClass.class)
public class ToCreateProductTest extends BaseClass
{
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzerImplementationClass.class)
	public void toCreateProductAndVerifyProductName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//fetch data from excel sheets
		String vendorName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 18, 2);
		String productName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 22, 2);
		
		//Creating all objects
		HomePage home = new HomePage(driver);
		VendorPage vendor = new VendorPage(driver);
		CreatingNewVendorPage createVendor = new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfo = new VendorInformationPage(driver);
		ProductPage product = new ProductPage(driver);
		CreatingProductPage createProduct = new CreatingProductPage(driver);
		ProductInformationPage productInfo = new ProductInformationPage(driver);
		
		//Creating vendor to avoid data dependency
		home.clickOnVendorsModule();
		vendor.clickOnVendorPlusButton();
		createVendor.enterVendorName(vendorName);
		createVendor.clickOnSaveButton();
		System.out.println("The vendor has been created.");
		
		//Verifying vendor
		String actualVendor = vendorInfo.verifyVendorInfo(vendorName);
		Assert.assertTrue(actualVendor.contains(vendorName));
		System.out.println("Passed: The vendor name has been verified.");
		
		//Creating product
		home.clickOnProductsModule();
		product.clickOnProductPlusButton();
		createProduct.enterProductName(productName);
		createProduct.selectVendorNameFromVendorLookUpPage(IPathConstant.VENDOR_LOOKUP_PAGE_TITLE, vendorName, IPathConstant.CREATING_PRODUCT_PAGE_TITLE);
		createProduct.uploadProductImage(IPathConstant.PRODUCT_IMAGE_PATH);
		createProduct.clickOnSaveButton();
		System.out.println("Product has been created.");
		
		//Verifying the product
		String actualProductName = productInfo.verifyProductInfo(productName);
		Assert.assertTrue(actualProductName.contains(productName));
		System.out.println("Passed: The product name has been verified.");
		
		
		
	}
}
