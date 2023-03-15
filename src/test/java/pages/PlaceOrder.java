package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class PlaceOrder extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	public WebElement placeorder;
	
	@FindBy(xpath="(//button/span[text()='×'])[3]")
	public WebElement close;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement card;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement Submit;
	
	WebDriverWait wait;
	
	public PlaceOrder()
	{
		PageFactory.initElements(driver, this);
	}
	public void confirmorder() throws InterruptedException
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		placeorder.click();
//		Thread.sleep(2000);
		name.sendKeys("Esakki");		
		country.sendKeys("INDIA");
		city.sendKeys("TVL");
		card.sendKeys("12234568");
		month.sendKeys("MARCH");
		year.sendKeys("2000");
//		Thread.sleep(3000);
		purchase.click();
//		Thread.sleep(2000);
		Submit.click();
		
		
		
	}
	

}
