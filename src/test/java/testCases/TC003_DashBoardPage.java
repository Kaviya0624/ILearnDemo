package testCases;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.LoginPage;
import testBase.Baseclass;

public class TC003_DashBoardPage extends Baseclass {
	
	
	@Test(groups= {"Regression"})
	public void DashBoardContents() throws InterruptedException
	{
		LoginPage lp =new LoginPage(driver);
		lp.clickLog();
		lp.setUsername(p.getProperty("user"));
		lp.setPass(p.getProperty("password"));
		lp.clickSubmit();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickDashBoard();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,150)", "");
		Thread.sleep(2000);
		boolean isDpexists = dp.CheckUserprofile();
		Assert.assertTrue(isDpexists, "The user image element is not present on the page");
		
		
		
		dp.clickCourses();
		js.executeScript("window.scrollBy(0,50)", "");
		Thread.sleep(1000);
		
		dp.clickAcademics();
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		
		dp.clickSubscribe();
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		dp.clickChecklist();
		Thread.sleep(1000);
		
		dp.clickcareerpaths();
		js.executeScript("window.scrollBy(0,50)", "");
		Thread.sleep(1000);
		
		dp.clickquestions();
		Thread.sleep(1000);
		
		
		dp.clickorders();
		js.executeScript("window.scrollBy(0,50)", "");
		Thread.sleep(1000);
		
		
		dp.clickresumes();
		Thread.sleep(1000);
		dp.clickAdd();
		Thread.sleep(1000);
		dp.clickUpload("C:\\Users\\ADMIN\\Documents\\uplaod.docx");
		Thread.sleep(1000);
		
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,100)", "");
		
		dp.clickcard();
		Thread.sleep(2000);
		String originalWindow = driver.getWindowHandle();
		
		dp.clickLink();
		Thread.sleep(1000);
		 Set<String> windowHandles = driver.getWindowHandles();
		    for (String handle : windowHandles) 
		    {
		        if (!handle.equals(originalWindow))
		     
		        {
		            driver.switchTo().window(handle);
		            break;
		        }
		    }
		Thread.sleep(3000);
		    driver.close();
		    driver.switchTo().window(originalWindow);
		dp.clickChange();
		dp.clickCancel();
		    
		
		js.executeScript("window.scrollBy(0,150)", "");
		Thread.sleep(1000);
		
		dp.clicksettings();
		dp.clickAvatar();
		dp.clickChangepass();
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0);");
		
		
		dp.clickToggle();
		dp.clickMySubs();
		
		dp.clickSearch("cyber");
		Thread.sleep(1000);
		
		
		
	}
	
	

}
