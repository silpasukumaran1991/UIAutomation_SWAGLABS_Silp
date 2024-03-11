package testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {
	
	protected static WebDriver driver;
	public WebDriver initialiseDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
	
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{			
		//edge browser	
		}
		return driver;
		}
	
@BeforeMethod(alwaysRun=true)
public LoginPage launchApplication() throws IOException
{
	driver = initialiseDriver();
	LoginPage loginPageObject = new LoginPage(driver);
	loginPageObject.GoTo();
	return loginPageObject;
}

@AfterMethod(alwaysRun=true)
public void aftermethod()
{
	driver.close();
}
	



}