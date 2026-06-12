package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.pgLogin;

public class testLoginPage extends BaseClass{
	
	@Test
	public void testAuthenticateUser() {
		pgLogin loginPg = new pgLogin(wDriver);
		
		loginPg.enterUserEmail("admin@yourstore.com");
		loginPg.enterUserPassword("admin");
		loginPg.authenticateUser();
		
		System.out.println("Page Title is : " +	wDriver.getTitle());
		Assert.assertEquals(wDriver.getTitle(), "Dashboard / nopCommerce administration");
	}

}
