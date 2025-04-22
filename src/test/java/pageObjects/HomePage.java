package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	//@FindBy(xpath="xpathvalue") WebElement selectorname;		: sample format to find the element using SelectorsHub
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement login;
	
	public void clickMyAccount() {
		
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	public void clickLogin() {
		
		login.click();
	}


}
