package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

/***
 * 
 * @author Anjali.khertala@capgemini.com
 * Logout class holding the script of Logout.feature file.
 * It includes verifying profile icon and logged out.
 * 
 *  Concepts Used:
 *  	1. Naming Convention
 *  	2. POM
 *  	3. Assert/Verify
 *
 */
public class Logout extends Testbook_Base {
	
	@FindBy(xpath = "(//img[@class='circle-img'])[2]") WebElement actorIcon;
	@FindBy(xpath = "(//li[@class='dropdown-item ng-scope'])[8]/a") WebElement logout_user;
	
	public Logout()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void actorProfile() throws Exception
	{
		
		Thread.sleep(3000);
		try
		{
			Assert.assertTrue((actorIcon.isDisplayed()));
			Thread.sleep(3000);
			actorIcon.click();
			testlog=ext.createTest("TestBook Profile");
			testlog.log(Status.PASS,"TestBook Profile icon Display");
			takescreenshot("TestBookProfile.png");
		}
		catch(Exception a)
		{
			testlog=ext.createTest("TestBook Profile");
			testlog.log(Status.FAIL,"TestBook Profile icon not Display");
			takescreenshot("TestBookProfile.png");
		}
	}
	
	public void logout() throws Exception
	{
		Thread.sleep(3000);
		try
		{
			Assert.assertTrue((logout_user.isDisplayed()));
			logout_user.click();
			testlog=ext.createTest("TestBook LogOut");
			testlog.log(Status.PASS,"TestBook Logout Done");
			takescreenshot("TestBookLogOut.png");
			Thread.sleep(3000);
		} 
		catch(Exception a)
		{
			testlog=ext.createTest("TestBook LogOut");
			testlog.log(Status.FAIL,"TestBook Logout Pending...");
			takescreenshot("TestBookLogOut.png");
		}
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
	}
}

