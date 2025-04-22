package pageObjects;

import java.awt.event.ActionEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage1 extends BasePage {

	public AccountRegistrationPage1(WebDriver driver) {

		super(driver);
	}

	/*@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	*/

	/*public void setFirstName(String fname) {

		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {

		txtLastname.sendKeys(lname);

	}

	public void setEmail(String email) {

		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);

	}

	public void ReadPrivacyPolicy() {

		chkPolicy.click();

	}

	public void clickContinue() {

		btnContinue.click();
		
		//			OR
		
		//btnContinue.submit();
		
		//			OR
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		// 			OR
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//			OR
		//btnContinue.sendKeys(Keys.RETURN);
		
		//			OR
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		

	}
	
	public String getConfirmationMsg() {
		try {
		return msgConfirmation.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
	}*/
	
	

@FindBy(xpath="//input[@id='gender-male']") WebElement male;
@FindBy(xpath="//input[@id='FirstName']") WebElement firstName;
@FindBy(xpath="//input[@id='LastName']") WebElement lastName;
@FindBy(xpath="//input[@id='Email']") WebElement email;
@FindBy(xpath="//input[@id='Company']") WebElement companyName;
@FindBy(xpath="//input[@id='Password']") WebElement password;
@FindBy(xpath="//input[@id='ConfirmPassword']") WebElement confirmPassword;
@FindBy(xpath="//button[@id='register-button']") WebElement register;
@FindBy(xpath="//div[@class='result']") WebElement yourRegistrationCompleted;
public void setMale() {

	male.click();
}

public void setFirstName(String fname) {

	firstName.sendKeys(fname);
}
public void setLastName(String lname) {
	
	lastName.sendKeys(lname);
	
}

public void seteMail(String eMail) {
	
	email.sendKeys(eMail);
	
}

public void setCompanyName(String company_name) {
	
	companyName.sendKeys(company_name);
	
}

public void setPassword(String pwd) {
	
	password.sendKeys(pwd);
}

public void setConfirmPassoword(String ConfirmPWD) {
	
	confirmPassword.sendKeys(ConfirmPWD);
}

public void clickRegister() {
	
	register.click();
}
	
public String getConfirmationMsg() {
	try {
	return yourRegistrationCompleted.getText();

	}catch(Exception e) {
		
		return e.getMessage();
	}
	}

}
