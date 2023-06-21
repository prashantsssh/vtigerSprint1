package vtiger.lead_module_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.POMRepository.CreatingNewLead;
import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.LeadInformationPage;
import vtiger.POMRepository.LeadPage;
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPathConstant;
@Listeners (vtiger.genericUtility.ListenersImplementationClass.class)
public class ToVerifyLeadInfoTest extends BaseClass
{
	@Test(retryAnalyzer = vtiger.genericUtility.RetryAnalyzerImplementationClass.class)
	public void toCreateLeadAndToVerifyLeadInfoTest() throws EncryptedDocumentException, IOException
	{
		//Here we are fetching the data from excel sheets.
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 17, 2);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 18, 2);
		String expectedleadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 19, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 20, 2);
		String leadIndustryName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 21, 2);
		String leadAssignToDetails = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 23, 2);
		
		//All the objects creation statements
		HomePage home = new HomePage(driver);
		LeadPage leads = new LeadPage(driver);
		CreatingNewLead createLead = new CreatingNewLead(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		
		//Clicking on Lead module
		home.clickOnLeadModule();
		
		//Clicking on Lead Plus Button
		leads.clickOnLeadPlusButton();
		
		//Creating a lead
		createLead.selectFromLeadsSalutationDropdown(leadSalutation);
		createLead.enterFirstName(leadFirstName);
		createLead.enterLastName(expectedleadLastName);
		createLead.enterCompanyName(leadCompanyName);
		createLead.selectFromIndustryDropdown(leadIndustryName);
		createLead.clickOnGroupRadioButton();
		createLead.selectFromAssignToDropdown(leadAssignToDetails);
		createLead.clickOnSaveButton();
		System.out.println("The lead has been created.");
		
		//Verifying the lead.
		String actualLeadsLastName = leadInfo.verifyLeadsName(expectedleadLastName);
		
		Assert.assertTrue(actualLeadsLastName.contains(expectedleadLastName));
		System.out.println("Pass: The lead has been verified.");
	}
}
