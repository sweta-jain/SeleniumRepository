package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.Log;


public class BaseClass {
	protected WebDriver wDriver;
	
	@BeforeMethod
	public void setUp() {
		Log.info("Initializing Web Driver");
		wDriver = new ChromeDriver();
		wDriver.manage().window().maximize();
		wDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		Log.info("Navigating to Application...");
		wDriver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		if(wDriver != null)
		{
			Log.info("Closing Browser...");
			wDriver.close();
			wDriver.quit();
		}
	}

}
