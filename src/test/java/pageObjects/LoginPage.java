package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	
	}
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement login;
	
	@FindBy(xpath= "//input[@id='user_login']")
	WebElement username;

	@FindBy(xpath= "//input[@id='user_pass']")
	WebElement password;
	
	@FindBy(xpath= "//input[@id='wp-submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[@id='login_error']")
	WebElement Errormsg;
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	WebElement Logout1;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	@FindBy(xpath="//header[@class='header_wrapper homeheader']//div[@id='logo']//span[1]")
	WebElement Logo;
	
	@FindBy(xpath="//a[normalize-space()='Lost your password?']")
	WebElement LossPass;
	
	@FindBy(xpath="//p[@class='message']")
	WebElement msg;
	
	@FindBy(xpath="//a[normalize-space()='login page']")
	WebElement loginpage;
	
	public void clickLog()
	{
		login.click();
	}

	public void setUsername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	public void setPass(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickSubmit()
	{
		submit.click();
		
	}
	
	public void clickLogout()
	{
		Logout1.click();
		Logout.click();
	}
	
	
	public boolean checkLogo()
	{
		try
		{
		   return (Logo.isDisplayed());
		}
	catch(Exception e)
	{
		return false;
	}
		    
	 
	}
	
	public String Error()
	{
		return Errormsg.getText();
	}
	
	public void clicklossPass()
	{
		LossPass.click();
	}
	
	
	public String msgAfter()
	{
		return msg.getText();
	}
	
	public void clickLink()
	{
		loginpage.click();
	}

}
