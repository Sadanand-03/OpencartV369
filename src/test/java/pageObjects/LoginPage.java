package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement eMailAddress;
@FindBy(xpath="//input[@id='input-password']") 
WebElement password;
@FindBy(xpath="//button[normalize-space()='Login']") 
WebElement login;
	

public void setEmailAddress(String email) {
	
	eMailAddress.sendKeys(email);
}

public void setPassword(String pwd) {
	
	password.sendKeys(pwd);
}

public void clickLoginButton() {
	
	login.click();
}
}
