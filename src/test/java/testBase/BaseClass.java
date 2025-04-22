package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import net.bytebuddy.asm.Advice.This;

public class BaseClass {

	public static WebDriver driver;

	// public static final Logger logger = LogManager.getLogger(BaseClass.class);
	public static Logger log;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// Loading config.properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties"); // read the config.properties file
		p = new Properties();
		p.load(file); // load the properties file

		log = LogManager.getLogger(This.class);

		if (p.getProperty("execution_environment").equals("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {

				cap.setPlatform(Platform.WIN11);
				
			} else if (os.equalsIgnoreCase("linux")) {

				cap.setPlatform(Platform.LINUX);
				
			} else {

				System.out.println("No matching OS");
				return;
			}

			// browser

			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;

			case "edge":
				cap.setBrowserName("edge");
				break;

			case "firefox":
				cap.setBrowserName("firefox");
				break;

			default:
				System.out.println("No matching Browser");

				return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);

		}

		if (p.getProperty("execution_environment").equals("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name..");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(p.getProperty("appURL")); // reading url from properties file

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {

		driver.close();

	}

	public void takeScreenShot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File img_file = ts.getScreenshotAs(OutputType.FILE);
		img_file.renameTo(new File(System.getProperty("user.dir") + "\\screenshots\\fullpage1.png"));
	}

	public void takeScreenShot(WebDriver driver, WebElement ele) {

		File img_file = ele.getScreenshotAs(OutputType.FILE);
		img_file.renameTo(new File(System.getProperty("user.dir") + "\\screenshots\\ConfirmMessage.png"));
	}

	public String randomString() {

		// This method is imported from org.apache.commons.lang3.RandomStringUtils
		// package. It does not belongs to java.
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {

		// int generatedNumber = Integer.parseInt(RandomStringUtils.randomNumeric(10));
		// return generatedNumber;

		// OR

		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphanumeric() {

		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);

		return (generatedString + "@" + generatedNumber);

	}

	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
