package stepDefinitions;


import org.testng.Assert;

import base.BaseTests;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminDashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class BackgroundSteps extends BaseTests{

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private AdminDashboardPage adminDashboardPage = new AdminDashboardPage(DriverFactory.getDriver());
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().navigate().to("http://localhost:4200/");
		Assert.assertEquals("Home - ADExotics Car Rental", homePage.getTitle());
	}

	@Then("user is navigated to login page")
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().navigate().to("http://localhost:4200/login");
		Assert.assertEquals("Login - ADExotics Car Rental", loginPage.getTitle());
	}
	
	@Given("Admin is on dashboard page")
	@Then("user is navigated to admin dashboard")
	public void user_is_navigated_to_admin_dashboard() {
		Assert.assertEquals("Admin Dashboard - ADExotics Car Rental", adminDashboardPage.getTitle());
	}

	@When("^user enters his \"(.*)\" and \"(.*)\"$")
	public void user_enters_his_email_and_password(String email,String password) {
	    loginPage.setEmail(email);
	    loginPage.setPassword(password);
	}

	@And("clicks on login")
	public void clicks_on_login() {
//		dashboard= loginPage.clickLoginButton();
		try {
			loginPage.clickLoginButton();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user is navigated to cars collection")
	public void user_is_navigated_to_cars_collection() {
		Assert.assertTrue(loginPage.isLoggedIn(),"Seems like you are not logged in");
		System.out.println("user is navigator tooooooooooooooooooooooooooooooooooo");
	}
}
