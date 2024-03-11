package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractcomponents.ReusableMethods;

public class HomePage extends ReusableMethods {

	WebDriver driver;
	ReusableMethods object = new ReusableMethods();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".product_sort_container")
	WebElement staticDropdown;
	@FindBy(css = ".product_sort_container")
	WebElement staticDropdown1;
	@FindBy(xpath = "(//div[@class='inventory_item'][1])//div[@class='inventory_item_name ']")
	WebElement firstProductName;

	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement firstitem;

	@FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
	WebElement firstElement;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement seconditem;

	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement secondElement;

	public void filterDropdown() throws InterruptedException {
		Select dropdown = new Select(staticDropdown);

		//object.ImplictWait();
		dropdown.selectByValue("za");
		object.ThreadSleepWait();
		Select dropdown1 = new Select(staticDropdown1);
		String selectedOption = dropdown1.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		// Verify the product list should be in descending order
		String firstProductNameActual = firstProductName.getText();
		String firstDesProductNameExpected = "Test.allTheThings() T-Shirt (Red)";
		// Assert.assertEquals(firstProductNameActual, firstDesProductNameExpected);
	}

	public void addProductToCart() throws InterruptedException {
		firstitem.click();
		object.ThreadSleepWait();
		// Verify the product is added to cart by changing the icon from 'Add to cart'
		// to 'Remove'
		boolean Element = firstElement.isDisplayed();
		if (Element == true) {
			System.out.println("The product't-shirt-(red)' is added to the cart ");
		} else {
			System.out.println("The product't-shirt-(red)'is not added to the cart");
		}

		// Add one more product
		seconditem.click();
		object.ThreadSleepWait();
		boolean Element1 = secondElement.isDisplayed();
		if (Element1 == true) {
			System.out.println("The product 'Sauce Labs Bike Light'is added to the cart ");
		} else {
			System.out.println("The product 'Sauce Labs Bike Light' is not added to the cart");
		}
	}
}
