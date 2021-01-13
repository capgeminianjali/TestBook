package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featureFiles/01_Login/loginEmail.feature","featureFiles/05_LiveClasses/liveClasses.feature","featureFiles/07_Logout/logout.feature"} 
		,glue={"stepDefinitions","base"}				//package names having the scripts for the feature file
		,tags= {"@Testbook_Page,@Valid_Email_Login,@LiveClasses_Display,@logout_testbook"}			// the tags to run.... which are in feature file		
		)

public class Workflow2_testRunner extends AbstractTestNGCucumberTests {

}
