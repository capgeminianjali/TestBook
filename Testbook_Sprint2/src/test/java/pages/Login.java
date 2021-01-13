package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

/***
 * 
 * @author Anjali.Khertala@capgemini.com
 * 
 * Login Class holding the script of Login feature file.
 * It include open URL and valid/invalid email login.
 * 
 * Concepts Used:
 *  	1. naming 
 *		2. object repository (Page object Model)
 *		3. Explicit wait
 *		4. frame switching/ change focus
 *		5. Assert/ Verify
 *
 */

public class Login extends Testbook_Base
{
	@FindBy(xpath="//a[text()='Login']") WebElement loginBox;
	@FindBy(id="loginUsername") WebElement login;
	@FindBy(xpath="//button[text()='Next']") WebElement next;
	@FindBy(name="pswd") WebElement pswd;
	@FindBy(xpath="//button[text()='Login']") WebElement l_button;
	@FindBy(id = "onBoardingIframe") WebElement login_frame;
	@FindBy(id = "webklipper-publisher-widget-container-notification-frame") WebElement notification;
	@FindBy(id = "webklipper-publisher-widget-container-notification-close-div") WebElement notif_cancel;
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openurl() throws Exception 
	{
		PageFactory.initElements(driver, this);
		driver.get("https://testbook.com/");
		Thread.sleep(3000);
		testlog=ext.createTest("testbook-Homepage");
		testlog.log(Status.PASS,"testbook home page is displayed");
		takescreenshot("testbookhomepage.png");	
		
	}
	public void loginButtonDisplay() throws Exception
	{
		Thread.sleep(60000);
		new Actions(driver).click().perform();
		if(loginBox.isDisplayed())
		{				
				testlog=ext.createTest("TestBook Login-Button");
				testlog.log(Status.PASS,"TestBook Login Button is displayed");
				takescreenshot("TestBookloginbutton.png");	
				loginBox.click();		
		}
		else
		{
			testlog=ext.createTest("TestBook Login-Button");
			testlog.log(Status.FAIL,"TestBook Login Button is not displayed");
			takescreenshot("TestBookloginbutton.png");	
		}
	}
	
	public void valid_login(String email, String password ) throws Exception
	{
		Thread.sleep(4000);
		try
		{
			if(login_frame.isDisplayed())
				driver.switchTo().frame(login_frame);
		}catch(Exception w) {}
		
		if(login.isDisplayed())
		{
			Thread.sleep(2000);
			login.sendKeys(email);
			next.click();	
			Thread.sleep(3000);
			try{
				wait.until(ExpectedConditions.visibilityOf(pswd));
				}
			catch(Exception u){}
			pswd.sendKeys(password);
			l_button.click();
			Thread.sleep(3000);
			testlog=ext.createTest("TestBook Login");
			testlog.log(Status.PASS,"TestBook Login Successfully");
			takescreenshot("TestBookLogin.png");
		}
		else
		{
			testlog=ext.createTest("TestBook Login");
			testlog.log(Status.FAIL,"TestBook Login Failed");
			takescreenshot("TestBookLogin.png");
		} 
	}
	
	public void notification_cancel() throws Exception {
		System.out.println("enter....");
		if(notification.isDisplayed())
		{
			driver.switchTo().frame(notification);
			notif_cancel.click();
			Thread.sleep(3000);
		}
	}
	public void titleCheck()
	{
		try {
			Assert.assertEquals("Dashboard | Testbook", driver.getTitle());
			//new Actions(driver).click().perform();
			testlog=ext.createTest("TestBook Login-Dashboard");
			testlog.log(Status.PASS,"TestBook Dashboard title match");
			takescreenshot("TestBookDashboard.png");
		}
		catch(Exception e)
		{
			testlog=ext.createTest("TestBook Login-Dashboard");
			testlog.log(Status.FAIL,"TestBook Dashboard title not match");
			takescreenshot("TestBookDashboard.png");
		}
	}
	
	public void inValidEmail(String email,String password) throws Exception 
	{
		Thread.sleep(2000);
		try
		{
			if(login_frame.isDisplayed())
				driver.switchTo().frame(login_frame);
		}catch(Exception w) {}
		if(login.isDisplayed())
		{
			Thread.sleep(2000);
			login.sendKeys(email);
		
		try	
		{	next.click();	
			pswd.sendKeys(password);
			l_button.click();
			testlog=ext.createTest("Login with Invalid Email");
			testlog.log(Status.FAIL,"Login with Invalid, still processing further");
			takescreenshot("TestBookLoginInvalid.png");
		}
		catch(Exception e)
		{
			Thread.sleep(3000);
			testlog=ext.createTest("Login with Invalid Email");
			testlog.log(Status.PASS,"Login with Invalid, not processing further");
			takescreenshot("TestBookLoginInvalid.png");
		}
		}
	}
	public void errorMsg()
	{
		new Actions(driver).click().perform();
		loginBox.click();
	}
}
