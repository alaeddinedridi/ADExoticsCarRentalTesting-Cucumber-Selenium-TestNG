package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;

	protected WebElement clickElement(WebDriver driver, By locator,String method){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement elm= wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (method == "normal") {
			elm.click();
		}
		else if (method == "js") {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", elm);
		}
        return elm;
    }

	protected WebElement availableElement(WebDriver driver,By locator){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return elm;
    }

	protected List<WebElement> availableElements(WebDriver driver,By locator){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		List<WebElement> elms = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		return elms;
    }
	
	protected WebElement enterTextInElement(WebDriver driver,By locator, String value){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		elm.clear();
		elm.sendKeys(value);

		return elm;
    }

	protected void selectElement(WebDriver driver,By locator, String option){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(selectElement);
		System.out.println("these are the items of the list : "+select.getOptions());
		select.selectByValue(option);
	}
}