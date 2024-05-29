Feature: Signup feature
 
 	Background:
 		Given user is on home page
 		
 		
		
	Scenario Outline: Submit signup form with empty fields 
  	Given user is on signup page
		When user leaves empty signup fields for "<fullName>" or "<email>" or "<password>" or "<confirmPassword>"
		And clicks on signup
		Then an error is displayed to the user
		
	Examples: 
	
		| fullName | email | password | confirmPassword |
		|  |  |  |  |
		|  Aladdin |  |  |  |
		|  | aladdin@gmail.com |  |  |
		|  |  | test1234 |  |
		|  |  |  | test1234 |
	
	
	
	Scenario Outline: Signup with valid informations
  	Given user is on signup page
		When user enters his signup informations "<fullName>" and "<email>" and "<password>" and "<confirmPassword>"
		And clicks on signup
		Then user is navigated to login page
		
	
	Examples: 
	
	| fullName | email | password | confirmPassword |
	#| Aladdin Dridi  | aladdin.dridi@gmail.com | test1234 | test1234 |
	#| Ahmed Dridi  | ahmed.dridi@gmail.com | test@1234 | test@1234 |
	| Miela Dridi  | miela.dridi@gmail.com | test@1234 | test@1234 |
	
	
	Scenario Outline: Try to signup with existing user informations
  	Given user is on signup page
		When user enters an existing email
		| fullName | email | password | confirmPassword |
		| Miela Dridi  | miela.dridi@gmail.com | test@1234 | test@1234 |
		And clicks on signup
		Then a signup error is displayed to the user
		

	
	
	
	
	
	
	