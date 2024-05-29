package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;

public class SignupPage extends BasePage{
	private WebDriver driver;

	private By fullNameField = By.name("name");
	private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("confirmPassword");
    private By signupButton = By.className("signup");
    private By submitError = By.className("submiterror");

	public SignupPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside signup page");
	}

	public void setFullName(String fullName){
		 enterTextInElement(driver, fullNameField, fullName);
	 }

	public void setEmail(String email){
		 enterTextInElement(driver, emailField, email);
	 }

	 public void setPassword(String password){
		 enterTextInElement(driver, passwordField, password);
	 }

	 public void setConfirmPassword(String confirmPassword){
		 enterTextInElement(driver, confirmPasswordField, confirmPassword);
	 }

	 public CollectionPage clickSignupButton(){
		 try {
			 Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(driver, signupButton, "normal");
		return new CollectionPage(driver);
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
	 
	 public String CheckSignupErrorMessage() {

			WebElement submitErrorElm = availableElement(driver, submitError);
			System.out.println("this is the field elm: "+submitErrorElm+ " is it displayed ? "+submitErrorElm.isDisplayed());
			if (submitErrorElm.isDisplayed()) {
				return submitErrorElm.getText();
			}
			return "";

	 }
}
