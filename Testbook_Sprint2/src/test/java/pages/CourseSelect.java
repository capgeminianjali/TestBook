package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
 * CourseSelect class holding the script of courseSelect.feature file.
 * It includes displaying button, availability of course and selecting any one of them.
 * 
 * Concept Used:
 * 		1. naming convention
 * 		2. Explicitly wait
 * 		3. Assert
 * 		4. handling scrollbar (JavascriptExecutor)
 *
 */
public class CourseSelect extends Testbook_Base{

	@FindBy(xpath="//a[@class='nav-icon-text courses js-header-link']") WebElement nav_course;
	@FindBy(xpath="//h5[text()='SSC JE Paper - I GA & LR Complete Course']") WebElement course_sel;
	@FindBy(xpath="//h3[text()='SSC JE Paper - I GA & LR Complete Course Course Curriculum']") WebElement course_sel_title;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public CourseSelect()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void courseTab() throws Exception
	{   
		Thread.sleep(3000);
		new Actions(driver).click().perform();
		try
		{	
			Assert.assertTrue((nav_course.isDisplayed()));
			try{wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h5[text()='SSC JE Paper - I GA & LR Complete Course']"))));}catch(Exception u){}
			nav_course.click();
			testlog=ext.createTest("TestBook Course");
			testlog.log(Status.PASS,"TestBook Course tab present, and Clickable");
			takescreenshot("TestBookcoursetab.png");
		}
		catch(Exception e) {
			testlog=ext.createTest("TestBook Course");
			testlog.log(Status.FAIL,"either TestBook Course tab not present, or not Clickable");
			takescreenshot("TestBookcoursetab.png");
		}
	}
	
	public void courseSel() throws InterruptedException
	{
		Thread.sleep(3000);
		if(course_sel.isDisplayed())
		{
			Point p= course_sel.getLocation();	
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,"+p.getY()+")");
			course_sel.click();
			Thread.sleep(3000);
			testlog=ext.createTest("TestBook Course Select");
			testlog.log(Status.PASS,"Course available and selected");
			takescreenshot("TestBookcourseselect.png");
		}
		else
		{
			testlog=ext.createTest("TestBook Course Select");
			testlog.log(Status.FAIL,"either Course not available or not clickable");
			takescreenshot("TestBookcourseselect.png");
		}
	}
	
	public void courseTitle() 
	{
		if(driver.getTitle().contains("SSC"))
		{
			testlog=ext.createTest("Selected Course page");
			testlog.log(Status.PASS,"Selected Course displayed");
			takescreenshot("TestBookcoursetitle.png");
		}
		else
		{
			testlog=ext.createTest("Selected Course page");
			testlog.log(Status.FAIL,"Selected Course not displayed");
			takescreenshot("TestBookcoursetitle.png");
		}
	}
	
	public void selCourseTitle()
	{
		if(course_sel_title.getText().contains("SSC JE Paper"))
		{
			testlog=ext.createTest("Selected Course name");
			testlog.log(Status.PASS,"Selected Course name displayed");
			takescreenshot("TestBookcoursename.png");
		}
		else
		{
			testlog=ext.createTest("Selected Course name");
			testlog.log(Status.FAIL,"Selected Course name not displayed");
			takescreenshot("TestBookcoursename.png");
		}
	}
	public void purchaseCourse() throws Exception
	{
		driver.findElement(By.xpath("//a[text()='Get Testbook Pass']")).click();
		Thread.sleep(3000);
	}
	
}
