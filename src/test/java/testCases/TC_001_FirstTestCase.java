
package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AvailCourses;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtils;

public class TC_001_FirstTestCase extends BaseClass{
	
	@Test
	public void searchCourse(){
		try {
			//Home page

			logger.info("***** Starting TC001 *****");
			HomePage hm = new HomePage(driver);
			hm.sendingKeys(prop.getProperty("course"));
			hm.click();
			
			//AvailCourses 
			AvailCourses avc = new AvailCourses(driver);
			avc.clickEnglishCheckbox();
			avc.clickLevelCheckbox();
			
			//Avail course first course
			String a1 = avc.firstCourseTitle();
			String a2 = avc.firstCourseRating();
			String a3 = avc.firstCourseDuration();
			System.out.println(a1+" "+a2+" "+a3);
					
			//Avail course second course
			String b1 = avc.secondCourseTitle();
			String b2 = avc.secondCourseRating();
			String b3 = avc.secondCourseDuration();
			System.out.println(b1+" "+b2+" "+b3);
			
			// unchecking the options
			avc.clickEnglishCheckbox();
			avc.clickLevelCheckbox();
			
			// Showing 8 more 
			avc.clickShow8More();
			
			// language learning checking
			avc.clickLanguageLearning();
			
			// Showing 21 more
			avc.clickShow21More();
			
			
			ExcelUtils eu=new ExcelUtils();
			int rowInc=1;
			//languages via list
			List<WebElement> languageWithCount = avc.languages();
			for(WebElement ele:languageWithCount) {
				System.out.println(ele.getText());
				eu.setCellData(rowInc, 0, ele.getText());
				rowInc++;
			}
			
			//levels via list
			rowInc=1;
			List<WebElement> levelWithCount = avc.levels();
			for(WebElement ele:levelWithCount) {
				System.out.println(ele.getText());
				eu.setCellData(rowInc, 3, ele.getText());
				rowInc++;
			}
			
			//Returning back to home page(Coursera)
			hm.clickHome();
			
			Assert.assertTrue(true);
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
}
