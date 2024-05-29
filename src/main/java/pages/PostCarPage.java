package pages;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;

public class PostCarPage extends BasePage{
	private WebDriver driver;
	private By modelField = By.id("model");
	private By carNameField = By.id("name");
	private By energyField = By.id("energy");
	private By transmissionField = By.id("transmission");
	private By modelYearField = By.id("modelyear");
	private By priceField = By.id("price");
	private By descriptionField = By.id("description");
	private By uploadFileElement = By.cssSelector("input[type=file]"); 
	private By uploadBtn = By.className("upload-btn");
	
	String picturesPath="src/test/resources/data/pictures/";
	List<String> listOfPictures = List.of(picturesPath+"under green urus 1.png \n ",
									picturesPath+"under green urus 2.png \n ",
									picturesPath+"under green urus 3.png \n ",
									picturesPath+"under green urus 4.png \n ",
									picturesPath+"sub huracan tecnica 1.png");
	
	
	List<CharSequence> picturesAbsolutePath= new ArrayList<CharSequence>();
	CharSequence[] picturesAbsolutePathArr = new CharSequence[picturesAbsolutePath.size()];
	
	
	public PostCarPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside post car page");
	}
	
	public boolean isOnUploadPage() {
		WebElement elm=availableElement(driver,uploadFileElement);
		if (elm.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void pickPictures() {
		
		WebElement uploadElement = driver.findElement(By.xpath("//input[@id='btn_myFileInput']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('style')", uploadElement);
		for (int i=0;i<listOfPictures.size();i++) {
			String path =new File(listOfPictures.get(i)).getAbsolutePath();
			picturesAbsolutePath.add(i, path);
			System.out.println("this is the absolute path: "+path);
		}
		
		System.out.println("this is arraylist:"+picturesAbsolutePath);
		uploadElement.sendKeys(picturesAbsolutePath.toArray(picturesAbsolutePathArr));
		
		
		
	}
	
	public void uploadPictures() {
		clickElement(driver, uploadBtn, "normal");
	}
	
	public String getTitle() {
		 try {
			 Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 String pageTitle=driver.getTitle();
		 System.out.println("this is the page title: "+pageTitle);
		 return pageTitle;
	 }
	
	public void setModel(String model){
		 System.out.println("this is the model : "+model);

		 selectElement(driver, modelField, model);
		 System.out.println("after model");

	 }
	
	public void setCarName(String name){
		 System.out.println("this is the name : "+name);

		 enterTextInElement(driver, carNameField, name);
		 System.out.println("after name");

	}
	
	
	public void setEnergy(String energy){
		 energy= energy.toLowerCase();
		 System.out.println("this is the energy : "+energy);
		 selectElement(driver, energyField, energy);
		 System.out.println("after energy");

	}
	
	public void setTransmission(String transmission){
		 System.out.println("this is the transmission : "+transmission);
		 transmission= transmission.toLowerCase();
		 selectElement(driver, transmissionField, transmission);
		 System.out.println("after transmission");

	}
	
	public void setModelYear(String year){
		 System.out.println("this is the year : "+year);

		 enterTextInElement(driver, modelYearField, year);
		 System.out.println("after year");

	}
	
	public void setPrice(String price){
		 System.out.println("this is the price : "+price);

		 enterTextInElement(driver, priceField, price);
		 System.out.println("after price");

	}
	
	public void setDescription(String description){
		 System.out.println("this is the description : "+description);

		 enterTextInElement(driver, descriptionField, description);
		 System.out.println("after description");

	}
}
