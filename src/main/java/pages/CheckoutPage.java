package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.ReusableMethods;

public class CheckoutPage extends ReusableMethods {

	WebDriver driver;
	ReusableMethods object = new ReusableMethods();

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		// super(driver);
		PageFactory.initElements(driver, this);

	}


	@FindBy(id = "first-name")
	WebElement firstname;
	@FindBy(id ="last-name")
	WebElement lastname;
	@FindBy(id ="postal-code")
	WebElement postalcode;
	@FindBy(id ="continue")
	WebElement continueButton;
	
	
	public void checkoutPageActions()
	{
		firstname.sendKeys("testName1");
		lastname.sendKeys(" One");
		postalcode.sendKeys("12345");
		continueButton.click();
	}
	
}
