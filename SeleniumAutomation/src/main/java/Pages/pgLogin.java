package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Log;

public class pgLogin {
	private WebDriver wDriver;
	
	/*private By userEmail = By.id("Email");
	private By userPassword = By.id("Password");
	private By loginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");*/
			
	@FindBy(id="Email")
	WebElement wUserEmail;
	
	@FindBy(id="Password")
	WebElement wUserPassword;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement wLoginButton;
		
	public pgLogin(WebDriver pDriver){
		this.wDriver = pDriver;	
		PageFactory.initElements(pDriver, this);
	}
	
	public WebElement findUserEmailBox()
	{
		//WebElement wUserEmail = this.wDriver.findElement(userEmail);
		wUserEmail.clear();
		return wUserEmail;
	}
	
	public WebElement findUserPasswordBox()
	{
		//WebElement wUserPassword = this.wDriver.findElement(userPassword);
		wUserPassword.clear();
		return wUserPassword;
	}
	
	public WebElement findLoginButton()
	{
		//WebElement wLoginButton = this.wDriver.findElement(loginButton);
		return wLoginButton;
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
