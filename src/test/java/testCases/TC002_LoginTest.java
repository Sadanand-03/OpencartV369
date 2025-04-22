package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		
		log.info("******** Starting TC_002_LoginTest ********");
		try {
		//Home page
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickLogin();
		
		// Login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email1"));
		Thread.sleep(3000);
		lp.setPassword(p.getProperty("passward1"));
		Thread.sleep(3000);
		lp.clickLoginButton();
		
		// My account page
		MyAccountPage mAcc = new MyAccountPage(driver);
		Thread.sleep(3000);
		boolean targetPage = mAcc.isMyAccountPageExists();
		//Assert.assertEquals(targetPage, true, "Login Failed");
		//				OR
		
		Assert.assertTrue(targetPage);
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		log.info("******** Finished TC_002_LoginTest ********");
	}
	
	
	
	
}
