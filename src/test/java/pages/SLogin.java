package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SLogin{

	WebDriver pagedriver;

	// ======================Objects======================//

	@FindBy(id = "user-name")
	WebElement SLoginlink;

	@FindBy(id = "password")
	WebElement SPassword;

	@FindBy(id = "login-button")
	WebElement SLoginButton;

	// ======================Methods======================//

	public SLogin(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(pagedriver, this);
	}

	public void LoginFunc(String UserNameVal, String PwdVal) throws InterruptedException {
		SLoginlink.sendKeys(UserNameVal);
		SPassword.sendKeys(PwdVal);
		Thread.sleep(1000);
		SLoginButton.click();
	}
}
