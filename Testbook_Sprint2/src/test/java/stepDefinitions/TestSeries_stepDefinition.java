package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.TestSeries;

public class TestSeries_stepDefinition 
{
	TestSeries testSeries_obj = new TestSeries();
	
	 	@Given("^user clicks on TestSeries tab on nav bar$")
	    public void user_clicks_on_testseries_tab_on_nav_bar() throws Throwable {
	 		testSeries_obj.testSeriesTab();
	    }

	    @When("^user select any testseries$")
	    public void user_select_any_testseries() throws Throwable {
	    	testSeries_obj.selSeries();
	    }

	    @Then("^user redirected to Testseries page$")
	    public void user_redirected_to_testseries_page() throws Throwable {
	    	testSeries_obj.testseriesTitle();
	    	
	    }
	    
	    @When("^user click on unlock now $")
	    public void user_click_on_unlock_now() throws Throwable {
	    	testSeries_obj.unlockNow();
	    }

}
