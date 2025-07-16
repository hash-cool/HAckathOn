package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AvailCourses extends BasePage{
	
	public AvailCourses(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='cds-react-aria-:Rhlbdj2tacqkqikta:']")
	WebElement english_checkbox;
	
	@FindBy(xpath="//span[text()='Beginner']")
	WebElement beginner_checkbox;
	
	//First Product
	@FindBy(xpath="(//div[@class='cds-ProductCard-header'])[1]//a")
	WebElement first_course;
	
	@FindBy(xpath="(//div[@class='cds-ProductCard-footer'])[1]//div[@aria-label='Rating']//span")
	WebElement first_course_rating;
	
	
	@FindBy(xpath="(//div[@class='cds-ProductCard-footer'])[1]//p")
	WebElement first_course_duration;
	
	//Second Product
	
	@FindBy(xpath="(//div[@class='cds-ProductCard-header'])[2]//a")
	WebElement second_course;
	
	@FindBy(xpath="(//div[@class='cds-ProductCard-footer'])[2]//div[@aria-label='Rating']//span")
	WebElement second_course_rating;
	
	@FindBy(xpath="(//div[@class='cds-ProductCard-footer'])[2]//p")
	WebElement second_course_duration;
	
	@FindBy(xpath="//span[text() = 'Language Learning']")
	WebElement lang_checkbox;
	
	@FindBy(xpath="//button[@aria-label='Show more Subject options']")
	WebElement show_8_more;
	
	@FindBy(xpath="//button[@aria-label='Show more Language options']")
	WebElement show_21_more;
	 
	public void clickEnglishCheckbox() {
		english_checkbox.click();
	}
	public void clickLevelCheckbox() {
		beginner_checkbox.click();
	}
	
	public String firstCourseTitle() {
		return first_course.getText();
	}
	public String firstCourseRating() {
		return first_course_rating.getText();
	}
	public String firstCourseDuration() {
		return first_course_duration.getText();
	}
	
	public String secondCourseTitle() {
		return second_course.getText();
	}
	public String secondCourseRating() {
		return second_course_rating.getText();
	}
	public String secondCourseDuration() {
		return second_course_duration.getText();
	}
	public void clickShow8More() {
		show_8_more.click();
	}
	public void clickLanguageLearning() {
		lang_checkbox.click();
	}
	public void clickShow21More() {
		show_21_more.click();
	}
	public List<WebElement> languages() throws InterruptedException  {
		Thread.sleep(5000);
		List<WebElement> language_list = driver.findElements(By.xpath("//div[starts-with(@data-testid,'language')]"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		List<WebElement> language_list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//		    By.xpath("//div[starts-with(@data-testid,'language')]")
//		));

		return language_list;
	}
	public List<WebElement> levels(){
		List<WebElement> level_list = driver.findElements(By.xpath("//div[starts-with(@data-testid,'productDifficultyLevel')]"));
		return level_list;
	}
}
