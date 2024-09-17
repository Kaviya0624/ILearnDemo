package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends BasePage {
	
	public Searchpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//nav[@role='navigation']//input[@id='search_course']")
	WebElement Search;
	
	@FindBy(xpath="//nav[@role='navigation']//button")
	WebElement button;
	
	@FindBy(xpath="//h3[normalize-space()='Automation Testing with Junit']")
	WebElement course;
	
	@FindBy(xpath="//a[normalize-space()='Overview']")
	WebElement Overview;
	
	public void searchCourse(String coursen)
	{
		Search.sendKeys(coursen);
	}

	public void clickButton()
	{
		button.click();
	}
	
	public boolean isCourseExist()
	{
		return course.isDisplayed();
	}
	
	public void clickCourse()
	{
		course.click();
	}
	
	public void clickOverview()
	{
		Overview.click();
	}
}
