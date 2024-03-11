package swag_withoutpom;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullFlow {

public static void main(String args[]) throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
    driver.manage().window().maximize();
	
	
	//Home Page- FilterFunctinlaity - Test 1
    
    WebElement staticDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
    Select dropdown = new Select(staticDropdown);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    dropdown.selectByValue("za");
  Thread.sleep(2000);
  WebElement staticDropdown1 = driver.findElement(By.cssSelector(".product_sort_container"));
  Select dropdown1 = new Select(staticDropdown1);
  String selectedOption = dropdown1.getFirstSelectedOption().getText();
  System.out.println("Selected option: " + selectedOption);
  
  //Verify the product list should be in descending order
  String firstProductName = driver.findElement(By.xpath("(//div[@class='inventory_item'][1])//div[@class='inventory_item_name ']")).getText();
String firstDesProductNameExpected = "Test.allTheThings() T-Shirt (Red)";
Assert.assertEquals(firstProductName, firstDesProductNameExpected);


//Home Page- Add to cart Functionality - Test 2

//Add a product to cart 
driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
//Verify the product is added to cart by changing the icon from 'Add to cart' to 'Remove'
Thread.sleep(1000);
boolean Element = driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).isDisplayed();
if(Element== true )
{
	System.out.println("The product't-shirt-(red)' is added to the cart ");
}
else 
{
	System.out.println("The product't-shirt-(red)'is not added to the cart");
}

//Add one more product 
driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
Thread.sleep(1000);
boolean Element1 = driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed();
if(Element1== true )
{
	System.out.println("The product 'Sauce Labs Bike Light'is added to the cart ");
}
else 
{
	System.out.println("The product 'Sauce Labs Bike Light' is not added to the cart");
}
//Click on shopping cart icon - PAGE -Headericons

Thread.sleep(1000);
driver.findElement(By.cssSelector(".shopping_cart_link")).click();

//Cart list page 

Thread.sleep(1000);
String firstItemsInList = driver.findElement(By.xpath("(//div[@class='cart_item'][1])//div[@class='inventory_item_name']")).getText();
if(firstItemsInList.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)"))
{
	System.out.println("Corrected first item in the cart") ;
}
else 
{
	System.out.println("Not Corrected first item in the cart") ;
}

String secondItemsInList = driver.findElement(By.xpath("(//div[@class='cart_item'][2])//div[@class='inventory_item_name']")).getText();
if(secondItemsInList.equalsIgnoreCase("Sauce Labs Bike Light"))
{
	System.out.println("Corrected second item in the cart") ;
}
else 
{
	System.out.println("Not Corrected second item in the cart") ;
}

//Click on checkout 

driver.findElement(By.id("checkout")).click();

//CheckoutPage 

driver.findElement(By.id("first-name")).sendKeys("testName1");
driver.findElement(By.id("last-name")).sendKeys(" One");
driver.findElement(By.id("postal-code")).sendKeys("123456");
driver.findElement(By.id("continue")).click();


//overview Paage 
driver.findElement(By.id("finish")).click();
Thread.sleep(1000);
String  completeHeader = driver.findElement(By.cssSelector(".complete-header")).getText();
if(completeHeader.equalsIgnoreCase("Thank you for your order!"))
{
	System.out.println("Order Completed Successfully") ;	
}
else
{
	System.out.println("Issue with text message") ;		
}
driver.findElement(By.id("back-to-products")).click();
//Test 3 - continue shopping 
//homepage
Thread.sleep(1000);
driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

Thread.sleep(1000);
driver.findElement(By.cssSelector(".shopping_cart_link")).click();

driver.findElement(By.id("continue-shopping")).click();
}


}
