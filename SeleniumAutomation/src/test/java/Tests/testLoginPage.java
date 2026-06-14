package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.pgLogin;
import Utils.ExcelUtils;
import Utils.ExtentReportsManager;
import Utils.Log;

public class testLoginPage extends BaseClass{
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		String filePath = System.getProperty("user.dir") + "/testData/testData.xlsx";
		
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();	
		
		 Object[][] data = new Object[rowCount-1][2];
		 
		 for(int i=1; i<rowCount; i++) {
			 data[i-1][0] = ExcelUtils.getCellValue(i, 0); //username
			 data[i-1][1] = ExcelUtils.getCellValue(i, 1); //password
		 }
		 
		 ExcelUtils.closeExcel();		 
		 return data;
	}
	
	@Test(dataProvider = "LoginData")
	public void testAuthenticateUser(String username, String password) {
		Log.info("Starting Login Test");
		extentTest = new ExtentReportsManager().createTest("Login Test");
		
		extentTest.info("Navigating to the Application");			
		pgLogin loginPg = new pgLogin(wDriver);
		
		Log.info("Entering User Credentials");		
		extentTest.info("Entering User Credentials");
		loginPg.enterUserEmail(username);
		loginPg.enterUserPassword(password);
		
		extentTest.info("Authenticating User");
		loginPg.authenticateUser();
				
		System.out.println("Page Title is : " +	wDriver.getTitle());
		
		Log.info("Verifying Page Title");	
		extentTest.info("Verifying Page Title");		
		Assert.assertEquals(wDriver.getTitle(), "Just a moment...");
		
		Log.info("Test Completed");
		extentTest.pass("Login Successful");
	}
	
	
	/*public void testAuthenticateUser() {
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
	}*/
}
