package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSignInPage extends BasePage{
	public AccountSignInPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(name = "email") WebElement emailtextField;
	
	@FindBy(id = "continue") WebElement continueButton;
	
	@FindBy(name = "password") WebElement pwdtextField;
	
	@FindBy(id = "signInSubmit") WebElement signinButton;
	
	public void setEmail(String email) {
		emailtextField.sendKeys(email);
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void setPwd(String pwd) {
		pwdtextField.sendKeys(pwd);
	}
	
	public void clickSignIn() {
		signinButton.click();
	}
}
