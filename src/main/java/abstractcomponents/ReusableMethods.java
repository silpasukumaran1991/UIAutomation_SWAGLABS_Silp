package abstractcomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class ReusableMethods {
	 WebDriver driver;
	 
	 
	// public ReusableMethods(WebDriver driver)
	 //{
		//	this.driver= driver;
 
	// }
	public void ImplictWait()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void ThreadSleepWait() throws InterruptedException
	{
		Thread.sleep(2000);
	}
}
