package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

public class TestSeries extends Testbook_Base
{
	static @FindBy(xpath = "//li[@class='nav-item tut-test-series']") WebElement testseries_tab;
	static @FindBy(xpath = "//h4[@title = 'SSC CGL Mock Test 2020']") WebElement my_test_series;
	static @FindBy(xpath = "//a[@ng-href='/ssc-cgl-exam/test-series']") WebElement view_test_series;
	static @FindBy(xpath = "//h1[text()='SSC CGL Mock Test 2020']") WebElement test_series_heading;
	static @FindBy(xpath = "//h4[@title = 'General Awareness Chapter Test 1']") WebElement test_1;
	static @FindBy(xpath = "//a[@title = 'Unlock General Awareness Chapter Test 1']") WebElement click_unlockNow;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	SoftAssert softAssert = new SoftAssert();
	public TestSeries()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void testSeriesTab() {
		try {
			wait.until(ExpectedConditions.visibilityOf(testseries_tab));
			testseries_tab.click();
			testlog = ext.createTest("Testseries tab navigation");
			testlog.log(Status.PASS, "Clicked on test series tab.");
			takescreenshot("TestSeries_tab_click.png");
			System.out.println("User able to click on test series tab.");
		}
		catch(Exception e) {
			testlog = ext.createTest("Testseries tab navigation");
			testlog.log(Status.FAIL, "Cannot click on test series tab.");
			takescreenshot("TestSeries_tab_click.png");
			System.out.println("User not able to click on test series tab.");
		}
	}
	
	public void selSeries() {
		try {
			String series = my_test_series.getText();
			softAssert.assertEquals(series, "SSC CGL Mock Test 2020");
				System.out.println("User's specific test series is chosen."+my_test_series.getText());
				view_test_series.click();
				testlog = ext.createTest("View test series");
				testlog.log(Status.PASS, "User specific test series selected.");
				takescreenshot("User_test_series.png");
		}
		catch(Exception e) {
			testlog = ext.createTest("View test series");
			testlog.log(Status.FAIL, "User specific test series not selected.");
			takescreenshot("User_test_series.png");
			System.out.println("User's specific test series is not chosen.");
		}
	}
	
	public void testseriesTitle() {
		try {
			Boolean series_heading = test_series_heading.getText().isEmpty();
			softAssert.assertNotNull(series_heading);
				System.out.println(test_series_heading.getText());
				testlog = ext.createTest("My test series");
				testlog.log(Status.PASS, "User's test series openned.");
				takescreenshot("Open_test_series.png");
				
		}
		catch(Exception e) {
			testlog = ext.createTest("My test series");
			testlog.log(Status.FAIL, "User's test series not openned.");
			takescreenshot("Open_test_series.png");
		}
	}
	
	public void unlockNow() {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)");
			String test_name = test_1.getText();
			
			softAssert.assertEquals(test_name, "Unlock General Awareness Chapter Test 1");
				click_unlockNow.click();
				testlog = ext.createTest("Unlock now button displayed");
				testlog.log(Status.PASS, "User is able to click on the unlock now button.");
				takescreenshot("Unlock_Now.png");
		}
		catch(Exception e) {
			testlog = ext.createTest("Unlock now button displayed");
			testlog.log(Status.FAIL, "User is unable to click on the unlock now button.");
			takescreenshot("Unlock_Now.png");
		}
	}
}