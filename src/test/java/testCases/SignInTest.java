package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountSignInPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class SignInTest extends BaseClass {
	
	@Test
	public void signintest() {
		logger.info("**Logging is started**");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickonSignIn();
		logger.info("Clicked on Signin button in Main page");
		
		
		AccountSignInPage signinPage = new AccountSignInPage(driver);
		signinPage.setEmail(resources.getString("userName"));
		signinPage.clickContinue();
		logger.info("Clicked on continue button");
		signinPage.setPwd(resources.getString("pwd"));
		signinPage.clickSignIn();
		logger.info("Clicked on sign in button");}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**Logging is completed**");
	}
	
}
