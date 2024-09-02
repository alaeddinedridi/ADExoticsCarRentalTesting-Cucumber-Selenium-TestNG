package pages;

import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class CollectionPage extends BasePage{
	private WebDriver driver;



    public CollectionPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside Collection page");
	}
    
    
}
