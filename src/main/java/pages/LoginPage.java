package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement username= driver.findElement(By.id("user-name"));
	//WebElement password= driver.findElement(By.id("password"));
	//WebElement login = driver.findElement(By.id("login-button"));
	
	//pagefactory design 
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(id="password")
	WebElement passowrd;
	@FindBy(id="login-button")
	WebElement login;
	
	
	
	//Actions for login
	
	public void loginApplication(String email, String password)
	{
		username.sendKeys(email);
		passowrd.sendKeys(password);
		login.click();
	    driver.manage().window().maximize();
	}
	
public void GoTo()
{
	driver.get("https://www.saucedemo.com/");

}
	
}
