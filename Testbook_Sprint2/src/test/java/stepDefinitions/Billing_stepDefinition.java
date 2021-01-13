package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Billing;

public class Billing_stepDefinition 
{
	Billing billing_obj = new Billing();
	
//----------------------Verify Purchase plan, Payment Method--------
	@Given("^all Plans are display$")
    public void all_plans_are_display() throws Throwable {
		billing_obj.billingPlan();
    }

    @When("^user clicks on Buy Pass$")
    public void user_clicks_on_buy_pass() throws Throwable {
    	billing_obj.buyPass();
    }

    @Then("^all payment methods display$")
    public void all_payment_methods_display() throws Throwable {
    	billing_obj.paymentMethod();
    }
//-----------------------card payment method--------------
    @Given("^user select card payment method$")
    public void user_select_card_payment_method() throws Throwable {
        	billing_obj.sel_card();
    }

    @Then("^enter details (.+) (.+) (.+) (.+) and pay$")
    public void enter_details_and_pay(String cardno, String expdate, String name, String cvv) throws Throwable {
    	billing_obj.card_detail(cardno, expdate,name,  cvv);
    }
//------------------------upi payment method-----------------
    
    @Given("^user selects upi payment$")
    public void user_selects_upi_payment() throws Throwable {
        billing_obj.sel_upi();
    }

    @When("^user enters (.+)$")
    public void user_enters(String rowno) throws Throwable {
        billing_obj.upi_detail(rowno);
    }

    @Then("^clicks on pay$")
    public void clicks_on_pay() throws Throwable {
        billing_obj.upi_pay();
    }
//-----------------------------------
    
    @Given("^close the payment method window$")
    public void close_the_payment_method_window() throws Throwable {
       billing_obj.close_window();
    }
}
