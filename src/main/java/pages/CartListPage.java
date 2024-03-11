package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.ReusableMethods;

public class CartListPage extends ReusableMethods {

	WebDriver driver;
	ReusableMethods object = new ReusableMethods();

	public CartListPage(WebDriver driver) {
		this.driver = driver;
		// super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@class='cart_item'][1])//div[@class='inventory_item_name']")
	WebElement firstItemsInListActual;
	@FindBy(xpath = "(//div[@class='cart_item'][1])//div[@class='inventory_item_name']")
	WebElement secondItemsInListActual;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	public void verifyCartListItems() throws InterruptedException {
		object.ThreadSleepWait();

		String firstItemsInList = firstItemsInListActual.getText();
		if (firstItemsInList.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")) {
			System.out.println("Corrected first item in the cart");
		} else {
			System.out.println("Not Corrected first item in the cart");
		}

		String secondItemsInList = secondItemsInListActual.getText();
		if (secondItemsInList.equalsIgnoreCase("Sauce Labs Bike Light")) {
			System.out.println("Corrected second item in the cart");
		} else {
			System.out.println("Not Corrected second item in the cart");
		}

		// Click on checkout

		checkoutButton.click();
	}
}
