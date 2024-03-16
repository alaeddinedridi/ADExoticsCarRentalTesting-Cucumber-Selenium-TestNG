package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.className("login");
    private By submitError = By.className("submiterror");
    private By fieldError = By.className("fielderror");
    private By navbarLoginBtn = By.xpath("//nav//button[contains(@class,'btn')]//span");
    
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside login page");
	}
	
	public String CheckLoginErrorMessage() {
		
		WebElement submitErrorElm = availableElement(driver, submitError);
		System.out.println("this is the field elm: "+submitErrorElm+ " is it displayed ? "+submitErrorElm.isDisplayed());
		if (submitErrorElm.isDisplayed()) {
			return submitErrorElm.getText();
		}
		return "";
		
	}
	
	public boolean checkFieldErrorMessage() {
		WebElement fieldErrorElm = availableElement(driver, fieldError);
		System.out.println("this is the field elm: "+fieldErrorElm+ " is it displayed ? "+fieldErrorElm.isDisplayed());
		return fieldErrorElm.isDisplayed();
	}
	
	
	public void setEmail(String email){ 
		 System.out.println("this is the pass : "+email);
		 
		 enterTextInElement(driver, emailField, email);
		 System.out.println("after pass");
		 
	 }
	
	
	 public void setPassword(String password){ 
		 System.out.println("this is the pass : "+password);
		 
		 enterTextInElement(driver, passwordField, password);
		 System.out.println("after pass");
		 
	 }
	 
	 public CollectionPage clickLoginButton(){
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(driver, loginButton, "normal");
		System.out.println("clicked!!!!!!!!!!!!!!!!!!!!!!!!!");
		return new CollectionPage(driver);
	 }
	 
	 public boolean isLoggedIn() {
		 WebElement btn=availableElement(driver, navbarLoginBtn);
		 System.out.println("this is getText ="+btn.getText());
		 if (btn.isDisplayed() && btn.getText().equalsIgnoreCase("Logout")) {
			 return true;
		 }
		 return false;
	 }
}