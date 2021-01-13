package base;

import java.io.File;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/***
 * @author Anjali.Khertala@capgemini.com
 * 
 * Testbook_Base class is used as a Base of all classes, which include the initialization of driver and 
 * key driven approach using config.properties file. And Generating TestNg Cucumber report with 
 * ExtentHtmlReporter
 * 		
 *  Concepts Used: 
 * 			1. Naming 
 *			2. WebDriver initialization 
 *			3. Implicit wait
 *			4. Hooks 
 *			5. Key Driven Approach
 ***/

public class Testbook_Base {

	public static WebDriver driver;	//for accessing outside the package
	public static Properties prop;
	
	public static ExtentHtmlReporter htmlreport; 	//for extent report "google.html" page visualization
	public static ExtentReports ext;				//for details about test report
	public static ExtentTest testlog;
	
	
	@BeforeSuite
	//@Before("@Testbook_Page")
	public void initialize()
	{
		prop=new Properties();
		try
		{
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 htmlreport = new ExtentHtmlReporter(prop.getProperty("reportslocation")+"\\testBook.html");
		 ext = new ExtentReports();
		 ext.attachReporter(htmlreport);
		 ext.setSystemInfo("Host Name", "Hcl-sysname");
		 ext.setSystemInfo("Environment", "Test Env");
		 ext.setSystemInfo("User Name", "Anjali Khertala-testername");
		   
		 htmlreport.config().setDocumentTitle("TestBook");
		 htmlreport.config().setReportName("TestBook Functional Testing");
		 htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreport.config().setTheme(Theme.STANDARD);	
		  
		String browser=prop.getProperty("browser");
		if(browser.matches("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(browser.matches("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //when element not found
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //for page loading
	}

	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screens")+"\\"+imagename));	//for save SS in system
		testlog.addScreenCaptureFromPath(prop.getProperty("screens")+"\\"+imagename);	//for save SS in report
		}catch(Exception e) {}
	}
	
	//@After("@logout_testbook")
	@AfterSuite
	public void teardown()
	{
		ext.flush();		//save the report
		driver.quit();		//close if all browsers which are open
		try
		{
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");	//kill the geckodriver/chromedriver process
		}
		catch(Exception e) {}
	}
}
