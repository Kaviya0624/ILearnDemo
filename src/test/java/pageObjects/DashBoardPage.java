package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends  BasePage

{
	
	public DashBoardPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='lg_button']")
	WebElement Dashboard;
	
	@FindBy(xpath="//div[@alt='User Profile']")
	WebElement Userprofile;
	
	@FindBy(xpath="//a[normalize-space()='My Courses']")
	WebElement Courses;
	
	
	//in academics click subscribe in one course
	@FindBy(xpath="//a[normalize-space()='Offered Academies']")
	WebElement Academics;
	
	@FindBy(xpath="//li[1]//form[1]//div[1]//button[1]")
	WebElement Subscribe;
	
	
	
	@FindBy(xpath="//a[normalize-space()='My Todolists']")
	WebElement Checklist;
	
	@FindBy(xpath="//a[normalize-space()='My Career Paths']")
	WebElement careerpaths;
	
	@FindBy(xpath="//a[normalize-space()='My Questions']")
	WebElement questions;
	
	@FindBy(xpath="//li[@class='border-radius-sm orders_tab']//a[contains(text(),'My Subscriptions')]")
	WebElement orders;
	
	@FindBy(xpath="//a[normalize-space()='My Resumes']")
	WebElement resumes;
	
	
	//uploading resume
	
	@FindBy(xpath="//button[normalize-space()='Add Resume']")
	WebElement AddResume;
	
	@FindBy(xpath="//input[@id='upload_resume_form']")
	WebElement UploadResume;
	
	
	
	//page
	
	@FindBy(xpath="//a[normalize-space()='Change Payment Method']")
	WebElement card;
	
	@FindBy(xpath="//a[normalize-space()='https://stripe.com/about']")
	WebElement link;
	
	@FindBy(xpath="//input[@id='learn-press-change-card-detail']")
	WebElement Change;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement CardCancel;
	

	@FindBy(xpath="//a[normalize-space()='Settings']")
	WebElement settings;
	
	//page
	
	@FindBy(xpath="//a[normalize-space()='Avatar']")
	WebElement Avatar;
	
	@FindBy(xpath="//a[normalize-space()='Change Password']")
	WebElement ChangePAss;
	
	
	@FindBy(xpath="//a[@id='gk-login-toggle']")
	WebElement toggle;
	
	@FindBy(xpath="//ul[@class='us_pr_lt']//a[contains(text(),'My Subscriptions')]")
	WebElement MySubscriptions;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	
	public void clickDashBoard()
	{
		Dashboard.click();
	}
	
	public boolean CheckUserprofile()
	{
		return Userprofile.isDisplayed();
	}
	
	public void clickCourses()
	{
		Courses.click();
	}
	
	//
	
	public void clickAcademics()
	{
		Academics.click();
	}
	
	public void clickSubscribe()
	{
		Subscribe.click();
	}
	
	//
	
	public void clickChecklist()
	{
		Checklist.click();
	}
	
	public void clickquestions()
	{
		questions.click();
	}
	
	public void clickcareerpaths()
	{
		careerpaths.click();
	}
	
	public void clickorders()
	{
		orders.click();
	}
	
	//
	public void clickresumes()
	{
		resumes.click();
	}
	
	public void clickAdd()
	{
		AddResume.click();
	}
	
	
	public void clickUpload(String file)
	{
		
		UploadResume.sendKeys(file);
		
	}

	//
	public void clickcard()
	{
		card.click();
	}
	
	//
	
	public void clickLink()
	{
		
		//String originalWindow = driver.getWindowHandle();
		
		link.click();
		
//	    Set<String> windowHandles = driver.getWindowHandles();
//	    for (String handle : windowHandles) 
//	    {
//	        if (!handle.equals(originalWindow))
//	     
//	        {
//	            driver.switchTo().window(handle);
//	            break;
//	        }
//	    }
//	    
//	    driver.close();
//	    driver.switchTo().window(originalWindow);
	}
	
	public void clickChange()
	{
		Change.click();
	}
	
	public void clickCancel()
	{
		CardCancel.click();
	}
	
	
	public void clicksettings()
	{
		settings.click();
	}
	
	//
	
	public void clickAvatar()
	{
		Avatar.click();
	}
	
	
	public void clickChangepass()
	{
		ChangePAss.click();
	}
	
	
	
	
	
	
	
	public void clickToggle()
	{
		toggle.click();
	}
	
	public void clickMySubs()
	{
		MySubscriptions.click();	
		
	}
	
	public void clickSearch(String find)
	{

		search.sendKeys(find);
		
	}
	
	
	
	
	
}
