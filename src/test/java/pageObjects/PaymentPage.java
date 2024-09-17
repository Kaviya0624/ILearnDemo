package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage
{

	public PaymentPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='View All Courses']")
	WebElement ViewAllCourse;
	
	@FindBy(xpath="//h4[normalize-space()='Master of Automation Testing']")
	WebElement MasterCourse;
	
	@FindBy(xpath="//button[normalize-space()='Pay Now']")
	WebElement PayNow;
	
	@FindBy(xpath="//label[@for='payment_method_stripe']")
	WebElement method_stripe;
	
	@FindBy(xpath="//input[@id='learn-press-checkout-place-order']")
	WebElement place_order;
	
	@FindBy(xpath="//*[@id=\"card-element\"]/div/iframe") WebElement frameelement;
	
	@FindBy(name="cardnumber") WebElement cardnum;
	
	@FindBy(name="exp-date") WebElement expdate;
	
	@FindBy(name="cvc") WebElement cvc;
	
	public void clickAllCourse()
	{
		ViewAllCourse.click();
	}
	
	public void clickMasterCourse()
	{
		MasterCourse.click();
	}
	
	public void clickPayNow()
	{
		PayNow.click();
	}
	
	
	public void clickmethodstripe()
	{
		method_stripe.click();
	}
	
	
	public void clickplaceorder()
	{
		place_order.click();
	}
	
	public void pay(String cardnumber,String exp, String cvcnu)
	{
		driver.switchTo().frame(frameelement);
		
		cardnum.sendKeys(cardnumber);
		expdate.sendKeys(exp);
		cvc.sendKeys(cvcnu);
		
		driver.switchTo().defaultContent();
	
	}
	
	
	
}
