Feature: As an admin, i want to be able to delete a car, so it won't be displayed to users anymore
  
	Background:
		Given user is on login page
		When user enters his "admin@gmail.com" and "admin"
		And clicks on login
	
	
  Scenario: Delete a car successfully
    Given Admin is on dashboard page
    When Admin clicks on delete button on the choosen car
    Then the car should be deleted

