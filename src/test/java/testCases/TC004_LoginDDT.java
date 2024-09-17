package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import testBase.Baseclass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
 					login failed - test fail

Data is invalid - login success - test fail  - logout
 					login failed - test pass
*/


public class TC004_LoginDDT extends Baseclass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")// getting data provider from different class
	public void verify_loginDDT(String username, String password, String exp) throws InterruptedException
	{
		logger.info("***** stating TC_004_LoginDDT ******");
		
		try
		{
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(username);
		lp.setPass(password);
		lp.clickSubmit();
		
		boolean targetPage= lp.checkLogo();
		
		driver.navigate().back();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				lp.clickLogout();
				Assert.assertTrue(true);
				
			}
			
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				lp.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				
				Assert.assertTrue(true);
				
			}
			
			
		}
		 
		}catch(Exception e)
		{
			
			Assert.fail();

		}
		
		
		
		Thread.sleep(1000);
		logger.info("***** Finished TC_004_LoginDDT ******");
		
	}
	
}










