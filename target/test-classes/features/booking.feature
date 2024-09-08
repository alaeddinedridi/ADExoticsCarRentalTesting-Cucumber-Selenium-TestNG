Feature: book a car
  Test that customer is able to book a car

	Background:
 		Given user is on login page
		When user enters his "ala@gmail.com" and "test1234"
		And clicks on login
		Then user is navigated to cars collection

		
	Scenario: Book a car successfully
		Given customer chooses a car
		And customer clicks on reserve button
		And Car booking request is sent to admin
		When admin accepts the request
		Then a notification is sent to the customer