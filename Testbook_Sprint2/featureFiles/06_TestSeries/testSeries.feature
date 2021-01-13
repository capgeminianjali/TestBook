#Author: anjalikhertala@gmail.com
@Testseries_Selection
Feature: Selecting a testseries
  
  @Testseries_Display
  Scenario: Testseries list displayed
    Given user clicks on TestSeries tab on nav bar
    When user select any testseries
    Then user redirected to Testseries page
	@Testseries_Purchase
	Scenario: purchase test series
		When user click on unlock now 