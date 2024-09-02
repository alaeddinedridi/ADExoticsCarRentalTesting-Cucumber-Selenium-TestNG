package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.BasePage;

public class AdminDashboardPage extends BasePage{
	private WebDriver driver;
	private By postCarButton = By.xpath("//nav/div[contains(@class,'nav-elm')]/span[contains(text(), 'Post car')]");
	private By nextBtn = By.id("next");
	private By deleteBtn = By.id("");
	private By carTagname = By.tagName("app-car");
	private int numberOfCars=0;
    public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside Admin dashboard page");
	}
    
    public void deleteCar() {
    	try {
    		List<WebElement> elms=availableElements(driver,carTagname);
    		this.numberOfCars=elms.size();
    		new Actions(driver)
            .moveToElement(elms.get(0))
            .perform();
    		elms.get(0).findElement(By.xpath("//div[@class='show-btns']/button[1]")).click();
			 Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
    	
    	
    	//clickElement(driver, nextBtn, "normal");
    }
    
    public boolean checkIfCarDeleted() {
    	List<WebElement> elms=availableElements(driver,carTagname);
    	System.out.println("this elms size: "+elms.size() + " "+ "this is old elms size: "+this.numberOfCars);
    	if (elms.size()<this.numberOfCars) {
    		return true;
    	}
    	return false;
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
    
    public void clickNext() {
    	clickElement(driver, nextBtn, "normal");
    }
    
    public PostCarPage clickOnPostCar(){
		 try {
			 Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(driver, postCarButton, "normal");
		System.out.println("clicked!!!!!!!!!!!!!!!!!!!!!!!!!");
		return new PostCarPage(driver);
	 }

}
