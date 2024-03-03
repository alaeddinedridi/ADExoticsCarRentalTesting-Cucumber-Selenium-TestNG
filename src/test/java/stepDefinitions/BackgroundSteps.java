package stepDefinitions;

import org.junit.Assert;

import base.BaseTests;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class BackgroundSteps extends BaseTests{
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().navigate().to("http://localhost:4200/");
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().navigate().to("http://localhost:4200/login");
	}
	
	@When("^user enters his \"(.*)\" and \"(.*)\"$")
	public void user_enters_his_email_and_password(String email,String password) {
	    loginPage.setEmail(email);
	    loginPage.setPassword(password);
	}
	
	@And("clicks on login")
	public void clicks_on_login() {
//		dashboard= loginPage.clickLoginButton();
		loginPage.clickLoginButton();
	}
	
	@Then("user is navigated to his profile")
	public void user_is_navigated_to_his_profile() {
//		Assert.assertTrue("Seems like you are not logged in", dashboard.getContactsCardHeader());
	}
}
