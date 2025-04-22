package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	/*
	 * data is valid - login success - test pass - logout data is valid - login
	 * failed - test fail
	 * 
	 * data is invalid - login success - test fail - logout data is invalid - login
	 * failed - test pass
	 * 
	 */
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven") // getting data provider from different
																				// class.
	public void verify_loginDDT(String email, String pwd, String expcted) throws InterruptedException {

		log.info("************* Starting TC003_LoginDDT *************");

		try {
			HomePage hp = new HomePage(driver);
			Thread.sleep(3000);
			hp.clickMyAccount();
			Thread.sleep(3000);
			hp.clickLogin();

			// Login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			
			Thread.sleep(3000);
			lp.setPassword(pwd);
			Thread.sleep(3000);
			lp.clickLoginButton();

			// My account page
			MyAccountPage mAcc = new MyAccountPage(driver);
			Thread.sleep(3000);
			boolean targetPage = mAcc.isMyAccountPageExists();

			if (expcted.equalsIgnoreCase("Valid")) {
				Thread.sleep(3000);
				if (targetPage == true) {
					Thread.sleep(3000);
					mAcc.clickLogout();
					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);

				}

			}
			if (expcted.equalsIgnoreCase("Invalid")) {
				Thread.sleep(3000);
				if (targetPage == true) {
					Thread.sleep(3000);
					mAcc.clickLogout();
					Assert.assertTrue(false);
				
				} else {

					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			Assert.fail();
		}
		log.info("************* Starting TC003_LoginDDT *************");

	}

}
