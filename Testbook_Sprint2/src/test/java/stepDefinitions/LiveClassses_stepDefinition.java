package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LiveClasses;

public class LiveClassses_stepDefinition {

	LiveClasses live_class= new LiveClasses();
	
	@Given("^user clicks on Live classes tab on nav bar$")
    public void user_clicks_on_live_classes_tab_on_nav_bar() throws Throwable {
		live_class.live_tab();
    }

    @When("^user select any live class$")
    public void user_select_any_live_class() throws Throwable {
    	live_class.sel_video();
    }

    @Then("^user redirected to related page$")
    public void user_redirected_to_related_page() throws Throwable {
    	live_class.check_redirection();
    }
}
