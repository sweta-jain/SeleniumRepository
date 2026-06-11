package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver wDriver;
	
	@BeforeMethod
	public void setUp() {
		wDriver = new ChromeDriver();
		wDriver.manage().window().maximize();
		wDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		wDriver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		if(wDriver != null)
		{
			wDriver.close();
			wDriver.quit();
		}
	}

}
