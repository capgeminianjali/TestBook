#Author: anjalikhertala@gmail.com
@Puschase
Feature: Purchase Plan and Payment Method
  
  @BuyGetPass
  Scenario: Verify Purchase plan, Payment Method
    Given all Plans are display
    When user clicks on Buy Pass
    Then all payment methods display

  @cardPayment
  Scenario Outline: card payment method
    Given user select card payment method
    Then enter details <card_no> <exp_date> <name> <cvv> and pay
    
    Examples: 
      | card_no  | exp_date | name |	cvv  |
      | 378282246310005	 | 11/23 | ABC |	2314  |
      | 478282246310005  | 05/21 | XYZ |	123  |

	@upiPayment
  Scenario Outline: upi payment method
    Given user selects upi payment
    When user enters <row_no>
    Then clicks on pay

    Examples: 
      | row_no |
      | 1 |
      | 2 |
      
      
  @closePayment
  Scenario: close the payment window
  	Given close the payment method window