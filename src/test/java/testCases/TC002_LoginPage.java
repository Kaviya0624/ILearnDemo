package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.Baseclass;

public class TC002_LoginPage extends Baseclass{
	

	@Test(priority=1,groups={"Sanity","Master"})
	public void Sucessfullogin() throws InterruptedException
	{
		try
		{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		lp.setPass(p.getProperty("password"));
		lp.clickSubmit();
		Thread.sleep(2000);
		boolean isLogoDisplayed = lp.checkLogo();
		Thread.sleep(2000);
		Assert.assertTrue(isLogoDisplayed,"The logo element is not present on the page.");
		
		
		lp.clickLogout();
		
		}
		catch(Exception e)
		{
			Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
	}
	
	

	@Test(priority=2,groups={"Sanity","Master"})
	public void InvalidPass() throws InterruptedException
	{
		try
		{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		lp.setPass("jhdjhds7");
		lp.clickSubmit();
		
		String errormsg = lp.Error();
		
		Assert.assertTrue(errormsg.contains("incorrect"), "The error message is not displayed as expected.");
		Thread.sleep(2000);
		driver.navigate().back();
		
		
		}
		catch(Exception e)
		{
			Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
	}
	
	@Test(priority=3,groups={"Sanity","Master"})
	public void InvalidUser() throws InterruptedException
	{
		try
		{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername("demo64gfh");
		lp.setPass(p.getProperty("password"));
		lp.clickSubmit();
		
		String errormsg = lp.Error();
		
		Assert.assertTrue(errormsg.contains("not registered on this site"), "The error message is not displayed as expected.");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		}
		catch(Exception e)
		{
			Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
	}
	
	@Test(priority=4,groups={"Sanity","Master"})
	public void LostPassword() throws InterruptedException
	{
		try
		{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		
		lp.clicklossPass();
		lp.setUsername(p.getProperty("user"));
		lp.clickSubmit();
		
		
		String msg = lp.msgAfter();
		
		Assert.assertTrue(msg.contains("Check your email"), "The message is not displayed as expected.");
		Thread.sleep(2000);
		
		lp.clickLink();
		
		
		
		}
		catch(Exception e)
		{
			Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
	}

}
