package Base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utils.EmailUtil;
import Utils.ExtentReportsManager;
import Utils.Log;


public class BaseClass {
	protected WebDriver wDriver;
	protected ExtentReports extentReport;
	protected ExtentTest extentTest;
	
	@BeforeSuite
	public void setUpReport() {
		extentReport = ExtentReportsManager.getReportsInstance();		
	}
	
	@AfterSuite
	public void tearDownReport() {
		extentReport.flush();
		EmailUtil.sendEmail(new File(ExtentReportsManager.reportPath));		
	}
	
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
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportsManager.captureScreenShot(wDriver, "Login Failure");
			System.out.println(screenshotPath);
			extentTest.fail("Test Failed, screenshot attached ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		if(wDriver != null)
		{
			Log.info("Closing Browser...");
			wDriver.close();
			wDriver.quit();
		}
	}

}
