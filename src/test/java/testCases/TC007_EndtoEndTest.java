package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.Searchpage;
import testBase.Baseclass;

public class TC007_EndtoEndTest extends Baseclass{
	
	@Test(groups= {"Master"})
	public void endToendTest() throws InterruptedException
	{
		
		
		//Soft assertions
		SoftAssert myassert = new SoftAssert();
		
		//login
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		lp.setPass(p.getProperty("password"));
		lp.clickSubmit();
		Thread.sleep(2000);
		boolean isLogoDisplayed = lp.checkLogo();
		Thread.sleep(2000);
		myassert.assertTrue(isLogoDisplayed,"The logo element is not present on the page.");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//SearchCourse
		
		Searchpage sp = new Searchpage(driver);
		sp.searchCourse("Automation Testing with Junit");
		sp.clickButton();
		
		js.executeScript("window.scrollBy(0,150)", "");
		
		boolean isCourseVisible = sp.isCourseExist();
		myassert.assertTrue(isCourseVisible, "The course should be displayed but it is not.");
		driver.navigate().back();
		
		//payment 
		 PaymentPage pp = new  PaymentPage(driver);
		 js.executeScript("window.scrollBy(0,800)", "");
		 Thread.sleep(2000);
		 pp.clickAllCourse();
		 Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0,1000)", "");
		 pp.clickMasterCourse();
		 Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0,800)", "");
		 Thread.sleep(2000);
		 pp.clickPayNow();
		 Thread.sleep(2000);
		 pp.clickmethodstripe();
		 js.executeScript("window.scrollBy(0,250)", "");
		 pp.clickplaceorder();
		 pp.pay("4242424242424242", "06/27", "2406");
		
		 myassert.assertAll(); //conclusion
	}

}
