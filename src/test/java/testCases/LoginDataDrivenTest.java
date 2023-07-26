package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountSignInPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_login(String email, String pwd, String exp) {
		logger.info("***Logging is started***");
		logger.info("Opening Amazon Mail Page");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickonSignIn();
			
			logger.info("Signing into the account");
			AccountSignInPage AccSignPage = new AccountSignInPage(driver);
			AccSignPage.setEmail(email);
			AccSignPage.clickContinue();
			AccSignPage.setPwd(pwd);
			AccSignPage.clickSignIn();
			
			boolean target = hp.isSignoutExists();
			
			if(exp.equals("valid") && target == true) {
				hp.clickSignOut();
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
			
			if(exp.equals("invalid") && target == false) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		logger.info("Logging is completed");
	}
}
