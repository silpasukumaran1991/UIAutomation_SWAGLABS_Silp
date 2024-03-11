package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.ReusableMethods;

public class CheckoutOverview_ContinuePage extends ReusableMethods {

	WebDriver driver;
	ReusableMethods object = new ReusableMethods();

	public CheckoutOverview_ContinuePage(WebDriver driver) {
		this.driver = driver;
		// super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id= "finish")
	WebElement finish;
	
	@FindBy(css=".complete-header")
	WebElement header;
	
	@FindBy(id= "back-to-products")
	WebElement backButton;
	
	
	public void finishMethod() throws InterruptedException
	{
	finish.click();
	object.ThreadSleepWait();
	String  completeHeader = header.getText();
	if(completeHeader.equalsIgnoreCase("Thank you for your order!"))
	{
		System.out.println("Order Completed Successfully") ;	
	}
	else
	{
		System.out.println("Issue with text message") ;		
	}
	backButton.click();
}
}
