package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbtn;
	
	@FindBy(xpath="//li/a[text()='Welcome Esaki1']")
	public WebElement welcome;
	
	WebDriverWait wait;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		login.click();
		username.sendKeys(prop.getProperty("userN"));
		password.sendKeys(prop.getProperty("PWD"));
		loginbtn.click();
		
	}
}
