package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.pgLogin;
import Utils.ExtentReportsManager;
import Utils.Log;

public class testLoginPage extends BaseClass{
	
	@Test
	public void testAuthenticateUser() {
		Log.info("Starting Login Test");
		extentTest = new ExtentReportsManager().createTest("Login Test");
		
		extentTest.info("Navigating to the Application");			
		pgLogin loginPg = new pgLogin(wDriver);
		
		Log.info("Entering User Credentials");		
		extentTest.info("Entering User Credentials");
		loginPg.enterUserEmail("admin@yourstore.com");
		loginPg.enterUserPassword("admin");
		
		extentTest.info("Authenticating User");
		loginPg.authenticateUser();
				
		System.out.println("Page Title is : " +	wDriver.getTitle());
		
		Log.info("Verifying Page Title");	
		extentTest.info("Verifying Page Title");		
		Assert.assertEquals(wDriver.getTitle(), "Just a moment...");
		
		Log.info("Test Completed");
		extentTest.pass("Login Successful");
	}
}
