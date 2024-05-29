package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;



    public HomePage(WebDriver driver) {
		this.driver=driver;
		System.out.println("inside Home page");
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
}
