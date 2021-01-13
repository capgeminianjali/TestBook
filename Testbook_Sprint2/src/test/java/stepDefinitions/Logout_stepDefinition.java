package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Logout;

public class Logout_stepDefinition {

	Logout logout_obj = new Logout();
	
	@When("^click on actor icon$")
    public void click_on_actor_icon() throws Throwable {
		logout_obj.actorProfile();
    }

    @Then("^click on logout$")
    public void click_on_logout() throws Throwable {
        logout_obj.logout();
    }
}
