package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver); 
	}
	
	
	@FindBy(xpath = "//a[@class='cd-dropdown-trigger desktop-navigation btn btn-primary']")
	WebElement AllCourses;
	
	@FindBy(xpath = "//ul[@id='menu-course-menu']//li[@id='nav-menu-item-6968']//a[@class='menu-link has-children main-menu-link']//div[@itemprop='url']")
	WebElement secondCourse;
	
	@FindBy(xpath = "//span[contains(@itemprop,'name')][normalize-space()='CSS for styling website']")
	WebElement SndsubCourse;
	
	@FindBy(xpath = "//a[normalize-space()='Curriculum']")
	WebElement Curriculum;
	
	@FindBy(xpath = "//li[@id='menu-item-13318']//span[@itemprop='name'][normalize-space()='Free Courses']")
	WebElement freecourses ;
	
	@FindBy(xpath = "//body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]/span[1]/a[1]")
	WebElement Viewmore;
	
	@FindBy(xpath = "//a[normalize-space()='About the Academy']")
	WebElement Academy;
	
	@FindBy(xpath = "//h3[normalize-space()='About the Academy']")
	WebElement txtExists;
	
	@FindBy(xpath = "//a[normalize-space()='Courses']")
	WebElement Courses;
	
	@FindBy(xpath = "//strong[normalize-space()='Web Development Academy']")
	WebElement CoursesExists;
	
	@FindBy(xpath = "//a[normalize-space()='Certifications']")
	WebElement Certifications;
	
	@FindBy(xpath = "//a[normalize-space()='Products']")
	WebElement Products;
	
	@FindBy(xpath = "//a[normalize-space()='FAQs']")
	WebElement Faqs;
	
	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	WebElement ContactUs;
	
	@FindBy(xpath = "//li[@id='menu-item-10835']//span[@itemprop='name'][normalize-space()='Online Classes']")
	WebElement Onlineclass;
	
	@FindBy(xpath = "//h1[contains(text(),'Java for Tester, Aws Certified Solution Architect,')]")
	WebElement headingExists;
	
	@FindBy(xpath = "//li[@id='menu-item-12194']//span[@itemprop='name'][normalize-space()='Blog']")
	WebElement Blog;
	
	@FindBy(xpath = "//a[contains(text(),'Get Started')]")
	WebElement getStarted;
	
	
	
	public void clickAllcourses()
	{
		AllCourses.click();
	}
	
	
	public void Hover()
	{
		secondCourse.click();
		SndsubCourse.click();
	}
	
	public void clickCurriculum()
	{
		Curriculum.click();
	}
	
	
	public void clickFreeCourse()
	{
		freecourses.click();
	}
	
	public void clickViewmore()
	{
		Viewmore.click();
	}
	
	public void clickAcademy()
	{
		Academy.click();
	}
	
	public String  isTextExists()
	{
		return txtExists.getText();
		
	}
	
	public void clickCourses()
	{
		Courses.click();
	}
	
	public String  isCourseExists()
	{
		return CoursesExists.getText();
		
	}
	
	public void clickCertifications()
	{
		Certifications.click();
	}
	
	public void clickProducts()
	{
		Products.click();
	}
	
	public void clickFaqs()
	{
		Faqs.click();
	}
	
	public void clickContactUs()
	{
		ContactUs.click();
	}
	
	
	public void clickOnlineclass()
	{
		Onlineclass.click();
	}
	
	public String  isheadingExists()
	{
		return headingExists.getText();
	}
	
	public void clickBlog()
	{
		Blog.click();
	}
	
	public void clickgetStarted()
	{
		getStarted.click();
	}
}
