package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CourseSelect;

public class CourseSelect_stepDefinition {
	
		CourseSelect course_obj = new CourseSelect();

//---------------------
	@Given("^user clicks on Courses tab$")
    public void user_clicks_on_courses_tab() throws Throwable {
        course_obj.courseTab();
    }

    @When("^user selects any course$")
    public void user_selects_any_course() throws Throwable {
        course_obj.courseSel();
    }

    @Then("^user redirected to course page$")
    public void user_redirected_to_course_page() throws Throwable {
        course_obj.courseTitle();
    }
    
//--------------------------
    
    @When("^user is on selected course page course title match$")
    public void user_is_on_selected_course_page_course_title_match() throws Throwable {
       course_obj.courseTitle();
    }

    @Then("^user clicks on Get TestBook Pass$")
    public void user_clicks_on_get_testbook_pass() throws Throwable {
       course_obj.purchaseCourse();
    }

}
