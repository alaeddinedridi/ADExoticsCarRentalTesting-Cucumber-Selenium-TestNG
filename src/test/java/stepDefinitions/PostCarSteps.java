package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import base.BaseTests;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Car;
import pages.AdminDashboardPage;
import pages.LoginPage;
import pages.PostCarPage;

public class PostCarSteps extends BaseTests{
	private PostCarPage postCarPage;
	private AdminDashboardPage adminDashboardPage = new AdminDashboardPage(DriverFactory.getDriver());
	private String newMainPicture;
	
	
	@Given("admin is on post car page")
	public void admin_is_on_post_car_page() {
		postCarPage = adminDashboardPage.clickOnPostCar();
		Assert.assertEquals(postCarPage.getTitle(),"Post Car - ADExotics Car Rental");
		
	}
	
	@When("^admin enters car informations$")
	public void admin_enters_car_informations(DataTable dataTable) {
		

		List<Car> cars= new ArrayList<Car>();
		cars=dataTable.asList(Car.class);
		for (Car car: cars) {
			
			postCarPage.setModel(car.getModel());
			postCarPage.setCarName(car.getName());
			postCarPage.setEnergy(car.getEnergy());
			postCarPage.setTransmission(car.getTransmission());
			postCarPage.setModelYear(car.getModelYear());
			postCarPage.setPrice(car.getPrice());
			postCarPage.setDescription(car.getDescription());
		}
	}
	
	
	@And("clicks on next")
	public void clicks_on_next() {
		adminDashboardPage.clickNext();
		Assert.assertEquals("Post Car - ADExotics Car Rental", postCarPage.getTitle());
	}
	
	@And("picks car pictures")
	@Then("admin is navigated to the next page to pick car pictures")
	public void admin_is_navigated_to_the_next_page_to_pick_car_pictures() {
		Assert.assertTrue(postCarPage.isOnUploadPage());
		postCarPage.pickPictures();
	}
	
	@Then("admin chooses a main picture for the car")
	public void admin_chooses_a_main_picture_for_the_car() {
		this.newMainPicture = postCarPage.chooseMainPicture();
	}
	
	
	@And("post the car")
	public void post_the_car() {
		Assert.assertEquals(postCarPage.uploadPictures(),"Car uploaded successfully!");
	}

	@And("checks if the car was uploaded with the selected thumbnail")
	public void checks_if_the_car_was_uploaded_with_the_selected_thumbnail() {
		Assert.assertEquals(this.newMainPicture,postCarPage.checkUploadedCar());
	}

}
