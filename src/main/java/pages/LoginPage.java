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
    
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside login page");
	}
	
	public boolean CheckLoginErrorMessage() {
		try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement submitErrorElm = availableElement(driver, submitError);
		System.out.println("this is the field elm: "+submitErrorElm+ " is it displayed ? "+submitErrorElm.isDisplayed());
		return submitErrorElm.isDisplayed();
		
	}
	
	public boolean checkFieldErrorMessage() {
		try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement fieldErrorElm = availableElement(driver, fieldError);
		System.out.println("this is the field elm: "+fieldErrorElm+ " is it displayed ? "+fieldErrorElm.isDisplayed());
		return fieldErrorElm.isDisplayed();
	}
	
	
	public void setEmail(String email){ 
		 System.out.println("this is the pass : "+email);
		 
		 enterTextInElement(driver, emailField, email);
		 System.out.println("after pass");
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	 public void setPassword(String password){ 
		 System.out.println("this is the pass : "+password);
		 
		 enterTextInElement(driver, passwordField, password);
		 System.out.println("after pass");
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void setEmptyEmail() {
		 WebElement elm = enterTextInElement(driver, emailField, "empty");
		 elm.clear();
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void setEmptyPassword() {
		 WebElement elm = enterTextInElement(driver, passwordField, "empty");
		 elm.clear();
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void clickLoginButton(){
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(driver, loginButton, "normal");
		System.out.println("clicked!!!!!!!!!!!!!!!!!!!!!!!!!");
	 }
}