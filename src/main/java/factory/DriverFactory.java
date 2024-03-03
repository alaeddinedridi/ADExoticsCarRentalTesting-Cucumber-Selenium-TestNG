package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;



public class DriverFactory {
	public WebDriver driver;
	
	// ThreadLocal is necessary for parallel test execution
	public static ThreadLocal<WebDriver> TLDriver = new ThreadLocal<>();
	
	public WebDriver initDriver(String browser) {
		System.out.println("browser value is: " + browser);
		if (browser.equals("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			TLDriver.set(new ChromeDriver(chromeOptions));
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			TLDriver.set(new FirefoxDriver());
		}else {
			System.out.println("Please pass the correct driver");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}

	
	// synchronized used for parallel execution (it's a best practice)
	public static synchronized WebDriver getDriver() {
		return TLDriver.get();
	}

}