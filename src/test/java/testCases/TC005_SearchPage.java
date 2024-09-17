package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Searchpage;
import testBase.Baseclass;

public class TC005_SearchPage extends Baseclass{
	
	@Test(groups= {"Master"})
	public void SearchPage() throws InterruptedException
	{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		lp.setPass(p.getProperty("password"));
		lp.clickSubmit();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		Searchpage sp = new Searchpage(driver);
		sp.searchCourse("Automation Testing with Junit");
		sp.clickButton();
		
		js.executeScript("window.scrollBy(0,150)", "");
		
		boolean isCourseVisible = sp.isCourseExist();
		Assert.assertTrue(isCourseVisible, "The course should be displayed but it is not.");
		
		sp.clickCourse();
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		
		sp.clickOverview();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		
	}

}
