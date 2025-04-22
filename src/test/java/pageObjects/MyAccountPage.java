package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//@FindBy(xpath = "//h1[normalize-space()='My Account']")
	@FindBy(xpath = "//h1[text()='My Account']")
	WebElement MsgHeading;

	//@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement logout;

	public boolean isMyAccountPageExists() {

		try {

			return MsgHeading.isDisplayed();

		} catch (Exception e) {

			return false;

		}
	}

	public void clickLogout() {

		logout.click();
	}

}
