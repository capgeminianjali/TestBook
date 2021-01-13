#Author: anjalikhertala@gmail.com
@Email_Login
Feature: Login using Email
			
			@Testbook_Page
			Scenario: Testbook Page
				Given user is on testbook site
				
			@Valid_Email_Login
			Scenario Outline: Valid email login
				Given user clicks on login button
				When enters valid <email> valid <password> clicks login
				Then user is  redirected to homepage
				
				Examples:
				| email | password |
				| 16cse011@gweca.ac.in | 12345678 |
				
			
			@Invalid_Login 
			Scenario Outline: Invalid email login
				When enters invalid <email> <password> clicks next
				Then user is displayed invalid error message
				
				Examples:
				| email | password |
				| anjalikhertala@gmail.com | sajcndks |
				