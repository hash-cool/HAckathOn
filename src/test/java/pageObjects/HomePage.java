package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {

	//3locators 2 methods
	 public HomePage(WebDriver driver) {
		 super(driver);
	 }
	 @FindBy(xpath="//input[@id=\"search-autocomplete-input\"]")
	 WebElement search;
	
	 @FindBy(xpath="//button[@class=\'nostyle search-button']/div")
	 WebElement searchbutton;
	  
	 @FindBy(xpath="//img[@class='rc-CourseraLogo']")
	 WebElement home;
	 
	 @FindBy(xpath="//div[@role='navigation']//li[3]/a")
	 WebElement universities;
	 
	 public void clickHome() {
		 home.click();
	 }
	 public void sendingKeys(String course) {
		 search.sendKeys(course);
	 }
	 public void click() {
		 searchbutton.click();
	 }
	 public void clickUniversities() {
		 universities.click();
	 }
	 
}
