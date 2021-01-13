#Author: anjalikhertala@gmail.com
@tag
Feature: Login witrd party API
  

  @Testbook_Page
			Scenario: Testbook Page
				Given user is on testbook site
				
			@facebook_Login
			Scenario Outline: login with facebook
				Given user clicks on signIn with login button
				When enters valid crendential 
				Then user is redirected to homepage
				
			@Google_Login
			Scenario Outline: login with facebook
				Given user clicks on signIn with Gmail button
				When select logged in gmail account 
				Then user is redirected to homepage
			