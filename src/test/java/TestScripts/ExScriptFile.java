package TestScripts;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.CartPage;
import pages.DelCartPage;
import pages.LoginPage;
import pages.PlaceOrder;
import base.TestBase;

public class ExScriptFile extends TestBase {
	LoginPage LogIn;
	DelCartPage AddPro;
	CartPage cart;
	PlaceOrder Purchase;
	WebDriverWait wait;
	
	@BeforeTest
	public void startup()
	{
		initialize();
	}
	
	
	@Test(priority=1)
	public void purchase()
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		LogIn=new LoginPage();
		LogIn.login();
		Assert.assertEquals(LogIn.welcome.getText(),"Welcome Esaki1");			
	}
	
	@Test(dataProvider="data",priority=2)
	
	public void additem(String item)
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		AddPro= new DelCartPage();
		
		AddPro.search(item);
		AddPro.GoTOCart();
		wait.until(ExpectedConditions.visibilityOfAllElements(AddPro.items));
		boolean flag=false;
		for(WebElement cartslist: AddPro.items)
		  {
			  if(cartslist.getText().equalsIgnoreCase(item)) {
			  Assert.assertEquals(cartslist.getText(), item);
			  flag=true;
			  }			  
		  }
		Assert.assertTrue(flag);	  
	}

	@Test(priority=3)
	public void delete() throws InterruptedException
	{
		cart=new CartPage();
		Purchase=new PlaceOrder();
		boolean success= cart.delete();
//		Assert.assertTrue(success);
	}
	
	@Test(priority=4)
	public void placeorder() throws InterruptedException 
	{
		Purchase=new PlaceOrder();
		Thread.sleep(3000);
		Purchase.confirmorder();
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));

		
	}
	
	 @DataProvider(name="data")
	  public Object[][] ProListCSV() throws CsvValidationException, IOException{
		  String path=System.getProperty("user.dir")+"//src//test//resources//testData//Product.csv";
		  String[] cols;
		  CSVReader reader = new CSVReader(new FileReader(path));
		  ArrayList<Object> dataList=new ArrayList<Object>();
		  while((cols=reader.readNext())!=null)
		  {
			  Object[] record= {cols[0]};
			  dataList.add(record);
		  }
		  return dataList.toArray(new Object[dataList.size()][]);
		  
	  }
	

}
