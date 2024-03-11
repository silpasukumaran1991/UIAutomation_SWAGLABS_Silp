package testscripts;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testcomponents.BaseTest;

public class Test2 extends BaseTest{
	@Test 
	public void filterTest() throws InterruptedException
	{
	LoginPage loginPageObject = new LoginPage(driver);
	loginPageObject.loginApplication("standard_user", "secret_sauce");
	HomePage homepageObj = new HomePage(driver);
	homepageObj.filterDropdown();
	}

}
