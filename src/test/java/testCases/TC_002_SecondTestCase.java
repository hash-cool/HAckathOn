package testCases;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pageObjects.CampusCoursePage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;
 
public class TC_002_SecondTestCase extends BaseClass{
 
	
	@Test(dataProvider="DP1", dataProviderClass=DataProviders.class)
	public void fill_details(String fname, String lname, String workmail, String phone, String instType, String instName, String jobRole, String department, String descp, String country, String state)
	{
		logger.info("***** Starting TC002 *****");
		logger.debug("***** This is Debug Log ****");
		try {
			
 		    HomePage hm = new HomePage(driver);
			hm.clickUniversities();
			CampusCoursePage campusCoursePage=new CampusCoursePage(driver);

			campusCoursePage.scrollToForm();
			campusCoursePage.setFirstName(fname);
			campusCoursePage.setLastName(lname);
			campusCoursePage.setEmail(workmail);
			campusCoursePage.setPhoneNumber(phone);
			campusCoursePage.setInstitutionName(instName);
			campusCoursePage.selectInstitutionType(instType);
			campusCoursePage.selectJobRole(jobRole);
			campusCoursePage.selectDepartment(department);
			campusCoursePage.selectNeeds(descp);
			campusCoursePage.selectCountry(country);
			campusCoursePage.selectState(state);
			campusCoursePage.clickSubmitBtn();
			
			Thread.sleep(5000);
			ConfirmationPage obj = new ConfirmationPage(driver);
			String succ = obj.message();
			
			Assert.assertEquals(succ, "Thank you for your interest in Coursera for Campus");
			logger.info("***** TC Passed *****");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.error("Test failed: "+e.getMessage());
			Assert.fail("Test failed: "+e.getMessage());
		}
		finally
		{
			logger.info("***** Finished TC *****");
		}
	}
}