package stepDefinitions;

import org.testng.Assert;

import base.BaseTests;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminDashboardPage;

public class DeleteCarSteps extends BaseTests{
	private AdminDashboardPage adminDashboardPage = new AdminDashboardPage(DriverFactory.getDriver());
	
	@When("Admin clicks on delete button on the choosen car")
	public void Admin_clicks_on_delete_button_on_the_choosen_car() {
		adminDashboardPage.deleteCar();
	}
	
	@Then("the car should be deleted")
	public void the_car_should_be_deleted() {
		Assert.assertTrue(adminDashboardPage.checkIfCarDeleted());
	}
}
