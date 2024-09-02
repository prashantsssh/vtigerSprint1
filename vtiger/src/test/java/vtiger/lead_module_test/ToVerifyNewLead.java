package vtiger.lead_module_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vtiger.POMRepository.CreatingNewLead;
import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.LeadInformationPage;
import vtiger.POMRepository.LeadPage;
import vtiger.genericUtility.BaseClass;

public class ToVerifyNewLead extends BaseClass
{
	@Test
	public void testNewLead() throws EncryptedDocumentException, IOException
	{
		String leadFirstName=eUtils.fetchStringDataFromExcelSheet("Sheet1", 2, 2);
		String leadSecondName=eUtils.fetchStringDataFromExcelSheet("Sheet1", 2, 2);
		
		HomePage home=new HomePage(driver);
		LeadPage lead=new LeadPage(driver);
		CreatingNewLead createnewlead=new CreatingNewLead(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		
		home.clickOnLeadModule();
		lead.clickOnLeadPlusButton();
		createnewlead.enterFirstName(leadFirstName);
		
		
		
	}
}
