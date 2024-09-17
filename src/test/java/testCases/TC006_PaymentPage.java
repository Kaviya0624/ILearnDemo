package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import testBase.Baseclass;

public class TC006_PaymentPage extends Baseclass {
	
	
	
	@Test(groups= {"Master"})
	public void SearchPage() throws InterruptedException
	{
	LoginPage lp =new LoginPage(driver);
	lp.clickLog();
	lp.setUsername(p.getProperty("user"));
	lp.setPass(p.getProperty("password"));
	lp.clickSubmit();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
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
	 
	}
}
