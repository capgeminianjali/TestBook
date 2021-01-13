package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

/***
 * 
 * @author Annjali.khertala@capgemini.com
 * 
 * LiveClasses holds the script of liveclasess.feature file.
 * Concept Used:
 * 		1. Naming convention
 * 		2. POM
 * 		3. Assert
 *
 */
public class LiveClasses extends Testbook_Base
{
	@FindBy(xpath="//a[@class='nav-icon-text study-lessons js-header-link']") WebElement live_tab;
	@FindBy(xpath="//input[@placeholder='Search Videos']") WebElement search;
	@FindBy(xpath="//div[contains(text(),'SSC Result Dates Out')]") WebElement video;
	@FindBy(xpath="//h1[@class='video-title mt--0 mb-0 ng-binding']") WebElement tag;
	
	public LiveClasses()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void live_tab()
	{
		if(live_tab.isDisplayed())
		{
			live_tab.click();
			testlog=ext.createTest("TestBook Live Classes");
			testlog.log(Status.PASS,"TestBook Live Classes tab display");
			takescreenshot("TestBookLiveClasses.png");
		}
	}
	
	public void sel_video()
	{
		search.sendKeys("SSC");
		video.click();
		testlog=ext.createTest("TestBook Live Classes selecting");
		testlog.log(Status.PASS,"TestBook Live Classes selected");
		takescreenshot("TestBookLiveClassSelect.png");
	}
	
	public void check_redirection()
	{
		if(video.getText().contains(tag.getText()))
		{
			testlog=ext.createTest("TestBook Live Classes redirection");
			testlog.log(Status.PASS,"TestBook Live Classes redirection on right page");
			takescreenshot("TestBookLiveClassredirection.png");
		}
	}
}
