package testRunner;

import org.junit.runner.RunWith;

import base.Testbook_Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featureFiles/01_Login/loginEmail.feature","featureFiles/02_CourseSelect/courseSelected.feature","featureFiles/03_Billing/buyGetPass.feature","featureFiles/04_Doubts/doubts.feature","featureFiles/07_Logout/logout.feature"}
		,glue={"stepDefinitions","base"}				
		,tags= {"@Testbook_Page,@Valid_Email_Login,@Course_Display,@Course_Purchase,@BuyGetPass,@cardPayment,@upiPayment,@closePayment,@Doubts_adding,@Doubts_deleting,@logout_testbook"}			
		)

public class Workflow1_testRunner extends AbstractTestNGCucumberTests {}
