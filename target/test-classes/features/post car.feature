Feature: post a car
  Test that admin is able to post a car

	Background:
 		Given user is on login page
		When user enters his "admin@gmail.com" and "admin"
		And clicks on login
		Then user is navigated to admin dashboard

  #Scenario: Submit post car form with empty fields
  #  Given admin is on post car page
  #  When admin leaves empty post car field
  #  And clicks on next
  #  Then an error is displayed to the user

  #Scenario: Submit post car form successfully
  #  Given admin is on post car page
  #  When admin enters car informations
  #  | model | name | energy | transmission | year | price | description |
  #  | MCLAREN | MCLAREN Test | Essence | Manual | 2024 | 251.000 | description for test |
  #  And clicks on next
  #  Then admin is navigated to the next page to pick car pictures
  #  And post the car
    
   Scenario: Select a thumbnail for the car
    Given admin is on post car page
    When admin enters car informations
    | model | name | energy | transmission | year | price | description |
    | MCLAREN | MCLAREN Test | Essence | Manual | 2024 | 251.000 | description for test |
    And clicks on next
    And picks car pictures
    Then admin chooses a main picture for the car
    And post the car
    And checks if the car was uploaded with the selected thumbnail
    
    
    
    
    
    
    