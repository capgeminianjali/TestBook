package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.Testbook_Base;

/***
 * 
 * @author Anjali.khertala@capgemini.com
 * Billing class holding the script of Billing.feature file.
 * It includes Verifying the payment plan, method and functionality.
 * 
 * Concepts Used:
 * 		1. Naming convention
 * 		2. Apache-poi-xml implementation
 * 		3. Data driven approach(read/write in Excel) 
 * 		4. Frame switching / Change focus
 * 		5. POM (locator: xpath, id, etc.)
 *
 */
public class Billing extends Testbook_Base {

	@FindBy(xpath="//div[text()='Weekly Testbook ']") WebElement weekly;
	@FindBy(xpath="//div[text()='Monthly Testbook ']") WebElement monthly;
	@FindBy(xpath="//div[text()='14 Month Testbook ']") WebElement yearly;
	@FindBy(xpath="//a[text()='Buy Pass']") WebElement buyPass_button;
	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']") WebElement billing_frame;
	@FindBy(xpath="//button[@method='card']") WebElement card;
	@FindBy(xpath="//button[@method='upi']") WebElement upi;
	@FindBy(xpath="//button[@method='netbanking']") WebElement netbanking;
	@FindBy(xpath="//button[@method='wallet']") WebElement wallet;
	@FindBy(xpath="//button[@method='wallet']") WebElement paylater;
	@FindBy(id="card_number") WebElement card_number;
	@FindBy(id="card_expiry") WebElement card_expiry;
	@FindBy(id="card_name") WebElement card_name;
	@FindBy(id="card_cvv") WebElement card_cvv;
	@FindBy(id="footer-cta") WebElement pay;
	@FindBy(id="otp") WebElement otp;
	@FindBy(id="otp-prompt") WebElement prompt;
	@FindBy(id="tab-title") WebElement payment_back;
	@FindBy(id="vpa-upi") WebElement upi_id;
	@FindBy(id="fd-hide") WebElement upi_retry;
	@FindBy(id="modal-close") WebElement close_window;
	
	FileInputStream fin,fin1;
	XSSFWorkbook wb,wb1;
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public Billing()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void billingPlan()
	{
		if(weekly.isDisplayed() && monthly.isDisplayed() && yearly.isDisplayed())
		{
			testlog=ext.createTest("testbook-Billing-Plan");
			testlog.log(Status.PASS,"All billing plan are displayed");
			takescreenshot("testbookbillingplan.png");		
		}
		else
		{
			testlog=ext.createTest("testbook-Billing-Plan");
			testlog.log(Status.FAIL,"All billing plan are not displayed");
			takescreenshot("testbookbillingplan.png");		
		}
	}
	public void buyPass() throws Exception
	{
		fin1 = new FileInputStream("D:\\CapgeminiSelenium\\Sprint2_Report\\DataDriven\\upi_data.xlsx");
		wb1 = new XSSFWorkbook(fin1);
		XSSFSheet ws1 = wb1.getSheet("Sheet2");
		
		Row row= ws1.getRow(1);
		String type = row.getCell(0).getStringCellValue();
		
		if(type.equals("weekly"))
		{
			weekly.click();
			row.createCell(1).setCellValue("weekly Selected");
		}
		else if(type.equals("monthly"))
		{
			monthly.click();
			row.createCell(1).setCellValue("monthly Selected");
		}
		else
		{
			yearly.click();
			row.createCell(1).setCellValue("yearly Selected");
		}
		
		FileOutputStream fout1 = new FileOutputStream("D:\\CapgeminiSelenium\\Sprint2_Report\\DataDriven\\upi_data.xlsx");
		wb1.write(fout1);		
		fin1.close();		
		
		if(buyPass_button.isDisplayed())
		{
			buyPass_button.click();
			Thread.sleep(3000);
			testlog=ext.createTest("testbook-Buy pass Button");
			testlog.log(Status.PASS,"Redirect to the payment window");
			takescreenshot("testbookbuypass.png");		
		}
		else
		{
			testlog=ext.createTest("testbook-Buy pass Button");
			testlog.log(Status.PASS,"Not Redirect to the payment window");
			takescreenshot("testbookbuypass.png");
		}
	}
	public void paymentMethod()
	{
		driver.switchTo().frame(billing_frame);
		Point p= upi.getLocation();	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,"+p.getY()+")");
		if(card.isDisplayed() && upi.isDisplayed() && netbanking.isDisplayed() && wallet.isDisplayed() && paylater.isDisplayed())
		{
			testlog=ext.createTest("testbook Payment Method");
			testlog.log(Status.PASS,"All Payment Method are displayed");
			takescreenshot("testbookpaymentmethod.png");		
		}
		else
		{
			testlog=ext.createTest("testbook Payment Method");
			testlog.log(Status.FAIL,"All Payment Method are not displayed");
			takescreenshot("testbookpaymentmethod.png");
		}
	}
	public void sel_card() throws Exception
	{
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(card));
		card.click();
	}
	public void card_detail(String cardno, String expdate, String name, String cvv) throws Exception
	{
		try {
			driver.findElement(By.id("otp-sec")).click();
		}catch(Exception e) {}
		card_number.clear();
		card_number.sendKeys(cardno);
		
		card_expiry.clear();
		card_expiry.sendKeys(expdate);
		
		card_name.clear();
		card_name.sendKeys(name);
		
		card_cvv.clear();
		card_cvv.sendKeys(cvv);
		pay.click();
		Thread.sleep(3000);
		if(otp.isDisplayed())
		{
			otp.sendKeys("1234");
			testlog=ext.createTest("testbook Payment By Card valid");
			testlog.log(Status.PASS,"Payment done succesfully with valid details");
			takescreenshot("testbookpaymentcard.png");
		}
		else
		{
			testlog=ext.createTest("testbook Payment By Card invalid");
			testlog.log(Status.FAIL,"Payment done with invalid details");
			takescreenshot("testbookpaymentcard.png");
		}
		payment_back.click();
	}
	public void sel_upi() {
		try{
			upi.click();
		}
		catch(Exception m) {}
	}
	public void upi_detail(String rowno) throws Exception {
		
		fin = new FileInputStream("D:\\CapgeminiSelenium\\Sprint2_Report\\DataDriven\\upi_data.xlsx");
		wb = new XSSFWorkbook(fin);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int r=Integer.parseInt(rowno);
		Row row= ws.getRow(r);
		String upi_excel = row.getCell(0).getStringCellValue();
		
		upi_id.clear();
		upi_id.sendKeys(upi_excel);
		upi_id.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		if(upi_retry.isDisplayed())
		{
			upi_retry.click();
			try {upi_retry.click();}catch(Exception m) {}
			
			row.createCell(1).setCellValue("Valid UPI id");
			testlog=ext.createTest("testbook Payment By UPI valid");
			testlog.log(Status.PASS,"Payment done succesfully with valid upi Id");
			takescreenshot("testbookpaymentupi.png");
		}
		else
		{
			row.createCell(1).setCellValue("Invalid UPI id");
			testlog=ext.createTest("testbook Payment By UPI invalid");
			testlog.log(Status.FAIL,"Payment done with invalid upi Id");
			takescreenshot("testbookpaymentupi.png");
		}
	}
	public void upi_pay() throws Exception
	{
		FileOutputStream fout = new FileOutputStream("D:\\CapgeminiSelenium\\Sprint2_Report\\DataDriven\\upi_data.xlsx");
		wb.write(fout);		
		fin.close();		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(payment_back));
		payment_back.click();
	}

	public void close_window() {
		close_window.click();
	}
}
