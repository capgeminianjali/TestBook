package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login;

public class Login_stepDefinition 
{
	Login login_obj = new Login();
	
	@Given("^user is on testbook site$")
    public void user_is_on_testbook_site() throws Throwable 
	{
        login_obj.openurl();
        
    }

//--------------------------Scenario------------------------------------------------------	
	
    @Given("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
    	 login_obj.loginButtonDisplay();
    }

    @When("^enters valid (.+) valid (.+) clicks login$")
    public void enters_valid_valid_clicks_login(String email, String password) throws Throwable {
    	 login_obj.valid_login(email, password);
    }

    @Then("^user is  redirected to homepage$")
    public void user_is_redirected_to_homepage() throws Throwable {
    	login_obj.titleCheck();
    }
    
//----------------------------------------------------------------------------------------------
    
   
    @When("^enters invalid (.+) (.+) clicks next$")
    public void enters_invalid_clicks_next(String email, String password) throws Throwable {
    	login_obj.inValidEmail(email, password);
    }

    @Then("^user is displayed invalid error message$")
    public void user_is_displayed_invalid_error_message() throws Throwable {
    	login_obj.errorMsg();
    }
}
