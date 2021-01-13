package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Doubts;

public class Doubts_stepDefinition 
{
	Doubts doubts_obj = new Doubts();
	
	@Given("^user click on Doubts tab$")
    public void user_click_on_doubts_tab() throws Throwable {
		doubts_obj.doubtsTab();
    }

    @When("^Click on ask doubt$")
    public void click_on_ask_doubt() throws Throwable {
       doubts_obj.askDoubt();
    }

    @Then("^add doubts and upload screenschot$")
    public void add_doubts_and_upload_screenschot() throws Throwable {
       doubts_obj.addDoubt();
    }
    
 //----------------------------

    @Given("^select doubts$")
    public void select_doubts() throws Throwable {
        doubts_obj.selDoubts();
    }

    @Then("^Delete the doubts$")
    public void delete_the_doubts() throws Throwable {
        doubts_obj.delDoubts();
    }

}
