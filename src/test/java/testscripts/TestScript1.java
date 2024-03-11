package testscripts;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartIconTabPage;
import pages.CartListPage;
import pages.CheckoutOverview_ContinuePage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import testcomponents.BaseTest;

public class TestScript1 extends BaseTest {
	@Test(groups = {"Sanity"},dataProvider ="getData")
	public void FullflowTest(String email , String password ) throws InterruptedException, IOException {
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.loginApplication(email,password);
		HomePage homepageObj = new HomePage(driver);
		homepageObj.filterDropdown();
	}
	@Test
	public void FullflowTest2() throws InterruptedException, IOException {
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.loginApplication("standard_user", "secret_sauce");
		HomePage homepageObj = new HomePage(driver);
		homepageObj.addProductToCart();
		CartIconTabPage cartIconObject = new CartIconTabPage(driver);
		cartIconObject.cartClick();
		CartListPage cartlistobject = new CartListPage(driver);
		cartlistobject.verifyCartListItems();
		CheckoutPage checkoutObject = new CheckoutPage(driver);
		checkoutObject.checkoutPageActions();
		CheckoutOverview_ContinuePage object = new CheckoutOverview_ContinuePage(driver);
		object.finishMethod();
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "standard_user", "secret_sauce" } };

	}
}
