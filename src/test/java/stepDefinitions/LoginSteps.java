package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import base.BaseTests;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Login;
import pages.LoginPage;

public class LoginSteps extends BaseTests {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	@When("^user leaves empty fields$")
	public void user_leaves_empty_fields(DataTable dataTable) {
		List<Login> logins= new ArrayList<Login>();
		
		logins=dataTable.asList(Login.class);
		
		for (Login login:logins) {
			System.out.println("Email is :"+login.getEmail());
			System.out.println("Password is:"+login.getPassword());
			if (login.getEmail()!=null) {
				loginPage.setEmail(login.getEmail());
			}else {
				loginPage.setEmptyEmail();
			}
			
			if (login.getPassword()!=null) {
				loginPage.setPassword(login.getPassword());
			}else {
				loginPage.setEmptyPassword();
			}
		}
		
	}
	
	
	
	

	@When("^user enters an invalid \"(.*)\" and \"(.*)\"$")
	public void user_enters_his_email_and_password(String email,String password) {
	    loginPage.setEmail(email);
	    loginPage.setPassword(password);
	}

	
	@Then("an error is displayed to the user")
	public void an_error_is_displayed_to_the_user() {
		Assert.assertTrue(loginPage.checkFieldErrorMessage());
		Assert.assertTrue(loginPage.CheckLoginErrorMessage());
	}
}