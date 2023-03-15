package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class DelCartPage extends TestBase {
	
	@FindBy(xpath="//li/a[contains(text(),'Home')]")
	WebElement HomePage;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement AddToCart;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> items;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement gotocart;
	
	WebDriverWait wait;
	
	public DelCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void search(String itm)

	{
		 wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		 HomePage.click();
		 WebElement itmchk= driver.findElement(By.linkText(itm));
		 itmchk.click();
		 AddToCart.click();
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert();		  
		 alert.accept();
	}
	
	public void GoTOCart()
	{
		gotocart.click();
	}

}
