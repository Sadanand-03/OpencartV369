package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass1 {

	public WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");

	}

	@AfterClass
	public void tearDown() {

		// driver.close();

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

}
