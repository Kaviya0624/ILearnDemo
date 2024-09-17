package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_HomePage extends Baseclass{
	
	@Test(groups={"Regression","Master"})
	public void HomeContents() throws InterruptedException
	{
		try
		{	
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		HomePage hp = new HomePage(driver);
		
		
		hp.clickAllcourses();
		Thread.sleep(2000);
		hp.Hover();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		hp.clickCurriculum();
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		hp.clickFreeCourse();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,150)", "");
		hp.clickViewmore();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)", "");
		
		hp.clickAcademy();
		Thread.sleep(2000);
		String expectedtext = hp.isTextExists();
		Assert.assertEquals(expectedtext , "About The Academy");
		Thread.sleep(2000);
		hp.clickCourses();
		Thread.sleep(2000);
		String expectedtext1 = hp.isCourseExists();
		Assert.assertEquals(expectedtext1 , "Web Development Academy");
		Thread.sleep(2000);
		hp.clickCertifications();
		Thread.sleep(2000);
		hp.clickProducts();
		Thread.sleep(2000);
		hp.clickFaqs();
		Thread.sleep(2000);
		hp.clickContactUs();
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		
		hp.clickOnlineclass();
		Thread.sleep(2000);
		
		String expectedtext2 = hp.isheadingExists();
		Assert.assertEquals(expectedtext2, "Java for Tester, Aws Certified Solution Architect, Selenium Training with Java");
		
		Thread.sleep(2000);
		hp.clickBlog();
		Thread.sleep(2000);
		hp.clickgetStarted();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0);");
		
		}
		catch(Exception e)
		{
			  Assert.fail("Test Failed due to exception: " + e.getMessage());
		}
		
	}

}
