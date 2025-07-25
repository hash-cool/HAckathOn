package testBase;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
 
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public static JavascriptExecutor js;

	@BeforeClass(groups = {"Master", "Sanity", "Regression"})   //group added
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException {

		getProperties();

		//loading log4j file
		logger = LogManager.getLogger(this.getClass());

		//launching browser based on condition
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if(os.equalsIgnoreCase("windows")) {

				capabilities.setPlatform(Platform.WIN11);
			}

			else if(os.equalsIgnoreCase("mac")) {

				capabilities.setPlatform(Platform.MAC);
			}

			else {
				System.out.println("No matching os");
				return;
			}

			switch(browser.toLowerCase()) {

				case "chrome": capabilities.setBrowserName("chrome");break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			
				default: System.out.println("No matching browser");return;
			}

			driver = new RemoteWebDriver( URI.create("http://localhost:4444/wd/hub").toURL(),capabilities);
		}

		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch(browser.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default: System.out.println("No matching browser..");
				return;

			}

		}


		js = (JavascriptExecutor) driver;

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("baseUrl1"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = {"Master", "Sanity", "Regression"})   //group added

	public void tearDown() {

		driver.quit();
	}

	public void getProperties() throws IOException
	{
		FileReader file = new FileReader("./src/test/resources/config.properties");
		prop = new Properties();
		prop.load(file);
	}

	public void selectElementsByVisibleText(WebElement element, String optionToBeSelected) {

		new Select(element).selectByVisibleText(optionToBeSelected);
	}
 
	public static void jsScrollIntoView(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView()", element);

	}
	
	public static String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}

 