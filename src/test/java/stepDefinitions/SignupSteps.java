package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Signup;
import pages.SignupPage;

public class SignupSteps {

	private SignupPage signupPage = new SignupPage(DriverFactory.getDriver());

	@Given("user is on signup page")
	public void user_is_on_signup_page() {
		DriverFactory.getDriver().navigate().to("http://localhost:4200/signup");
		Assert.assertEquals("Signup - ADExotics Car Rental", signupPage.getTitle());
	}
	
	@When("^user enters his signup informations \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	@When("^user leaves empty signup fields for \"(.*)\" or \"(.*)\" or \"(.*)\" or \"(.*)\"$")
	public void user_leaves_empty_signup_fields(String fullName, String email,String password, String confirmPassword) {
		
			if (fullName!=null) {
				signupPage.setFullName(fullName);
			}else {
				signupPage.setFullName("");
			}

			if (email!=null) {
				signupPage.setEmail(email);
			}else {
				signupPage.setEmail("");
			}

			if (password!=null) {
				signupPage.setPassword(password);
			}else {
				signupPage.setPassword("");
			}

			if (confirmPassword!=null) {
				signupPage.setConfirmPassword(confirmPassword);
			}else {
				signupPage.setConfirmPassword("");
			}
		

	}

	@And("clicks on signup")
	public void clicks_on_signup() {
//		dashboard= loginPage.clickLoginButton();
		try {
			signupPage.clickSignupButton();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("a signup error is displayed to the user")
	public void a_signup_error_is_displayed_to_the_user() {
		Assert.assertEquals("Could not create an account",signupPage.CheckSignupErrorMessage());
	}
	
	@When("^user enters an existing email$")
	public void user_leaves_empty_fields(DataTable dataTable) {
		List<Signup> signups= new ArrayList<Signup>();

		signups=dataTable.asList(Signup.class);

		for (Signup signup:signups) {
		
			if (signup.getFullName()!=null) {
				signupPage.setFullName(signup.getFullName());
			}else {
				signupPage.setFullName("");
			}
			
			if (signup.getEmail()!=null) {
				signupPage.setEmail(signup.getEmail());
			}else {
				signupPage.setEmail("");
			}

			if (signup.getPassword()!=null) {
				signupPage.setPassword(signup.getPassword());
			}else {
				signupPage.setPassword("");
			}
			
			if (signup.getConfirmPassword()!=null) {
				signupPage.setConfirmPassword(signup.getConfirmPassword());
			}else {
				signupPage.setConfirmPassword("");
			}
			
		}

	}
}
