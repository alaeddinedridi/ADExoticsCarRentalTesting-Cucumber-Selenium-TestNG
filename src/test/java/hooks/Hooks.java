package hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties props;

	//@BeforeMethod
	@Before(order=0)
	public void getProperties() {
		configReader = new ConfigReader();
		props = configReader.initProperties();
		System.out.println("initialize props");
	}

	//@BeforeMethod
	@Before(order=1)
	public void launchBrowser() {
		String browser=props.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browser);
		System.out.println("init the driver to launch browser");
	}


	//@AfterMethod
	@After(order=0)
	public void quitBrowser() {
		System.out.println("inside quit");
		driver.quit();
	}

	//@AfterMethod
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("inside teardown");
		if (scenario.isFailed()) {
			String screenshotName= scenario.getName().replaceAll(" ", "_");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenshotName);
		}
	}
}