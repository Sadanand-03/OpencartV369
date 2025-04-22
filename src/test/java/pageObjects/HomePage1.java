package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage1 extends BasePage {

	
	
	public HomePage1(WebDriver driver) {
		
		super(driver);
	}
	
	//@FindBy(xpath = "//span[normalize-space()='My Account']")
	//WebElement lnkMyaccount;
	
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	
	public void clickRegister() {
		
		lnkRegister.click();
	}


}
