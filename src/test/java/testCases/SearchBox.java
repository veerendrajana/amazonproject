package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;

public class SearchBox extends SignInTest {
	
	@Test(dependsOnMethods="signintest")
	public void test_search() {
		logger.info("*** Logging is started ***");
		HomePage hp = new HomePage(driver);
		hp.searchResult(resources.getString("item"));
	}

}
