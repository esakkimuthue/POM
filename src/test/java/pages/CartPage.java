package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement gotocart;
	
	@FindBy(xpath="//tr[@class='success']")
	List<WebElement> BFdelete;
	
	@FindBy(xpath="//h3")
	WebElement PR;
	
	@FindBy(xpath="//h3")
	WebElement PR1;
	
	
	@FindBy(xpath="(//td[4]//a)[1]")
	WebElement delete;
	
	@FindBy(id="totalm")
	public WebElement totalAM;
	
	WebDriverWait wait;
	public CartPage() 
	{
		PageFactory.initElements(driver, this);
	}
	public boolean delete() throws InterruptedException
	{
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		gotocart.click();
		String totalpr=PR1.getText();
		int TL= Integer.parseInt(totalpr);
		System.out.println(TL);
		delete.click();
		String totalpr1= PR1.getText();
		int TL1= Integer.parseInt(totalpr1);
		System.out.println(totalpr1);
		return (TL>TL1);
	}
}
