package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class AdminDashboardPage extends BasePage{
	private WebDriver driver;
	private By postCarButton = By.xpath("//nav/div[contains(@class,'nav-elm')]/span[contains(text(), 'Post car')]");
	private By nextBtn = By.id("next");

    public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside Admin dashboard page");
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
