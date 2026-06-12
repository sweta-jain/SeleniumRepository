package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.Log;

public class pgLogin {
	WebDriver wDriver;
		
	public pgLogin(WebDriver pDriver){
		this.wDriver = pDriver;	
	}
	
	public WebElement findUserEmailBox()
	{
		WebElement tUserEmail = this.wDriver.findElement(By.id("Email"));
		tUserEmail.clear();
		return tUserEmail;
	}
	
	public WebElement findUserPasswordBox()
	{
		WebElement tUserPassword = this.wDriver.findElement(By.id("Password"));
		tUserPassword.clear();
		return tUserPassword;
	}
	
	public WebElement findLoginButton()
	{
		WebElement bLoginButton = this.wDriver.findElement(By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button"));
		return bLoginButton;
	}
	
	public  void enterUserEmail(String sUserEmail)
	{
		Log.info(" Entering User Name");
		findUserEmailBox().sendKeys(sUserEmail);
	}
	
	public void enterUserPassword(String sUserPassword)
	{
		Log.info(" Entering Password");
		findUserPasswordBox().sendKeys(sUserPassword);
	}
	
	public void authenticateUser()
	{
		Log.info(" Login Button Clicked");
		findLoginButton().click();
	}
}
