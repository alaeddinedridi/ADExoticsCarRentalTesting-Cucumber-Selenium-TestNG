Feature: Login feature
 
 	Background:
 		Given user is on home page
 		

 	#Scenario: Submit login form with empty fields 
  	#Given user is on login page
		#When user leaves empty fields
		#| email | password |
		#|  |  |
		#| admin@gmail.com |  |
		#|  | admin |
		#And clicks on login
		#Then an error is displayed to the user
		
	Scenario Outline: Submit login form with empty fields 
  	Given user is on login page
		When user leaves empty fields for "<email>" or "<password>"
		And clicks on login
		Then an error is displayed to the user
	
	Examples: 
	
		| email | password |
		|  |  |
		| admin@gmail.com |  |
		|  | admin |
	
	
	
	
	
	
		Scenario Outline: Check login is failed with invalid credentials
  	Given user is on login page
		When user enters an invalid "<email>" and "<password>"
		And clicks on login
		Then an authentication error is displayed to the user
		
		

	Examples: 
	
	| email | password |
	| test@test.com | test |
	
	
	
	@SanityTest
	Scenario Outline: Check login is successful with valid credentials
  	Given user is on login page
		When user enters his "<email>" and "<password>"
		And clicks on login
		Then user is navigated to cars collection
		
		

	Examples: 
	
	| email | password |
	| admin@gmail.com | admin |
	| ala@gmail.com | test1234 |
	| jenkins.dridi@gmail.com | test1234 |
	
		
		

	