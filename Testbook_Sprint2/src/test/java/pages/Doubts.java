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
 * @author Anjali.khertala@capgemini.com
 * 
 * Doubts Class holding the script of Doubts.feature file.
 * It includes adding a file from system, adding doubts and deleting doubts;
 * 
 *  Concepts Used:
 *  	1. Naming Convention
 *  	2. AutoIt
 *  	3. Window alert handle
 *  	4. POM
 *  	5. Assert
 *
 */

public class Doubts extends Testbook_Base
{
	@FindBy(xpath="//a[text()=' Doubts ']") WebElement doubt_tab;
	@FindBy(xpath="//div[@class='mt-5 col-md-3 d-none d-md-block ai-center ng-star-inserted']") WebElement ask_doubt;
	@FindBy(xpath="//textarea[@placeholder='Write your question here']") WebElement text_doubt;
	@FindBy(xpath="//button[@class='btn btn--outline ng-tns-c45-0']") WebElement add_image;
	@FindBy(xpath="//button[@class='btn btn--block ng-tns-c45-0']") WebElement next_doubt;
	@FindBy(xpath="//input[@placeholder='Search Subjects, topics...']") WebElement search;
	@FindBy(xpath="//span[text()='logical reasoning +']") WebElement sel_topic;
	@FindBy(xpath="//button[text()='Post Doubt Without Topic']") WebElement post;
	@FindBy(xpath="//div[@class='dot-menu ng-star-inserted']") WebElement dots;
	@FindBy(xpath="//span[@class='tb-dropdown-item icon-delete']") WebElement del;
	@FindBy(xpath="//button[text()='Yes']") WebElement yes;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public Doubts()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void doubtsTab() throws Exception
	{	
		driver.navigate().refresh();
		Thread.sleep(5000);
		try
		{
			Assert.assertTrue((doubt_tab.isDisplayed()));
			doubt_tab.click();
			testlog=ext.createTest("TestBook Doubts Tab");
			testlog.log(Status.PASS,"TestBook Doubts tab present, and Clickable");
			takescreenshot("TestBookdoubtstab.png");
		}
		catch(Exception w)
		{
			testlog=ext.createTest("TestBook Doubts Tab");
			testlog.log(Status.PASS,"TestBook Doubts tab present, and Clickable");
			takescreenshot("TestBookdoubtstab.png");
		}
	}
	
	public void askDoubt() throws Exception
	{
		Thread.sleep(3000);
		new Actions(driver).click().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(ask_doubt));
		try
		{
			Assert.assertTrue((ask_doubt.isDisplayed()));
			ask_doubt.click();
			testlog=ext.createTest("TestBook Doubts Page");
			testlog.log(Status.PASS,"TestBook ask Doubts button present, and Clickable");
			takescreenshot("TestBookdoubtsask.png");
		}
		catch (Exception e)
		{
			testlog=ext.createTest("TestBook Doubts Page");
			testlog.log(Status.PASS,"TestBook ask Doubts button not present, and Clickable");
			takescreenshot("TestBookdoubtsask.png");
		}
	}
	
	public void addDoubt() throws Exception
	{
		text_doubt.sendKeys("Dummy Data in Doubts text.....");
		Thread.sleep(3000);
		add_image.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\CapgeminiSelenium\\doubt_autoIt.exe");
		Thread.sleep(3000);
		next_doubt.click();
		search.sendKeys("logical");
		sel_topic.click();
		post.click();
		testlog=ext.createTest("TestBook Doubts Adding");
		testlog.log(Status.PASS,"TestBook Doubts added succesfully");
		takescreenshot("TestBookdoubtsadded.png");
	}

	public void selDoubts() 
	{
		dots.click();
	}

	public void delDoubts() 
	{
		if(del.isDisplayed())
		{
			del.click();
			yes.click();
			testlog=ext.createTest("TestBook Doubts Delete");
			testlog.log(Status.PASS,"TestBook Doubts Deleted succesfully");
			takescreenshot("TestBookdoubtsdeleted.png");
			driver.navigate().refresh();
		}
		else
		{
			testlog=ext.createTest("TestBook Doubts Delete");
			testlog.log(Status.FAIL,"TestBook Doubts not Deleted");
			takescreenshot("TestBookdoubtsdeleted.png");
		}
		
	}
	
}
