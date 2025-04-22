package testCases;

import static org.testng.Assert.fail;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {

		
		log.info("***** Starting TC001_AccountRegistrationTest *****");
		
		//try {
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.clickMyAccount();
		log.info("Clicked on My Account link");
		Thread.sleep(5000);
		hp.clickRegister();
		log.info("Clicked on Register link");

		AccountRegistrationPage registration = new AccountRegistrationPage(driver);
		log.info("Providing customer details");
		Thread.sleep(5000);
		registration.setFirstName(randomString().toUpperCase());
		Thread.sleep(5000);
		registration.setLastName(randomString().toUpperCase());
		Thread.sleep(5000);
		registration.setEmail(randomString() + "@gmail.com"); // Randomly generated. By calling randomString you will
																// get random five character alphabet.

		String password = randomAlphanumeric();

		Thread.sleep(5000);
		registration.setPassword(password);
		Thread.sleep(5000);
		registration.ReadPrivacyPolicy();
		Thread.sleep(5000);
		registration.clickContinue();

		log.info("validating expected message..");
		String confmsg = registration.getConfirmationMsg();
		Thread.sleep(5000);
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			//takeScreenShot(driver);
			takeScreenShot(driver, registration.getConfirmationMsgElement());
			log.error("Test failed..");
			log.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		

		/*}catch(Exception e) {
			
			
			Assert.fail();
			e.getStackTrace();
		}*/
	
		log.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	

}
