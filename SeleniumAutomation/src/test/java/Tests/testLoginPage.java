package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.pgLogin;
import Utils.Log;

public class testLoginPage extends BaseClass{
	
	@Test
	public void testAuthenticateUser() {
		Log.info("Starting Login Test");
		pgLogin loginPg = new pgLogin(wDriver);
		
		Log.info("Entering User Credentials");		
		loginPg.enterUserEmail("admin@yourstore.com");
		loginPg.enterUserPassword("admin");
		loginPg.authenticateUser();
		
		System.out.println("Page Title is : " +	wDriver.getTitle());
		
		Log.info("Verifying Page Title");	
		Assert.assertEquals(wDriver.getTitle(), "Just a moment...");
	}

}
