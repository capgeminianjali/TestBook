
@Doubts
Feature: Doubts adding and viewing
  
  @Doubts_adding
  Scenario: Doubts asking
    Given user click on Doubts tab
    When Click on ask doubt
    Then add doubts and upload screenschot

  @Doubts_deleting
  Scenario: Delete the doubt
    Given select doubts
    Then Delete the doubts
