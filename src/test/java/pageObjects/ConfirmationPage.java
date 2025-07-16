package pageObjects;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ConfirmationPage extends BasePage{
	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='cds-119 css-1euneyv cds-121']")));


	public String message() {
		return confirmMsg.getText();
	}
}