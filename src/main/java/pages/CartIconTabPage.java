package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.ReusableMethods;

public class CartIconTabPage extends ReusableMethods {
	
	
	WebDriver driver;

	public CartIconTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartIcon;
	
	
	
	//Add a product to cart Action 
	public void cartClick() throws InterruptedException
	{
		ThreadSleepWait();
		cartIcon.click();
		
	}
	
	
	
}
