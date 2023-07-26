package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='nav-line-1-container']") WebElement SignIn;
	
	@FindBy(xpath = "//div[@id='nav-al-signin']//span[@class='nav-action-inner']") WebElement SignInButton;
	
	@FindBy(id = "twotabsearchtextbox") WebElement Searchbox;
	
	@FindBy(xpath = "//span[contains(text(),'Sign Out')]") WebElement SignoutButton;
	
	public void clickonSignIn() {
		Actions actions = new Actions(driver);
		actions.moveToElement(SignIn).build().perform();
		
		SignInButton.click();
	}
	
	public void searchResult(String product) {
		Searchbox.sendKeys(product + Keys.ENTER);
	}
	
	public void clickSignOut() {
		Actions actions = new Actions(driver);
		actions.moveToElement(SignIn).build().perform();
		
		SignoutButton.click();
	}
	
	public boolean isSignoutExists() {
		try {
			return SignoutButton.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
}
