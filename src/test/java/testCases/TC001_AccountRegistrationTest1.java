package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AccountRegistrationPage1;
import pageObjects.HomePage;
import pageObjects.HomePage1;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest1 extends BaseClass{

	@Test
	public void verify_account_registration() throws InterruptedException {

		HomePage1 hp = new HomePage1(driver);
		Thread.sleep(5000);
		
		hp.clickRegister();

		AccountRegistrationPage1 registration = new AccountRegistrationPage1(driver);
		registration.setMale();
		registration.setFirstName(randomString().toUpperCase());
		registration.setLastName(randomString().toUpperCase());
		registration.seteMail(randomString() + "@gmail.com"); // Randomly generated. By calling randomString you will
		registration.setCompanyName(randomString());													// get random five character alphabet.

		String password = randomAlphanumeric();

		registration.setPassword(password);
		registration.setConfirmPassoword(password);
		registration.clickRegister();

		String confmsg = registration.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created"); // (actual,Expected)

	}

}
