package Abstract_components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.orders;

public class Abstract_components {

	WebDriver driver;
	
	public Abstract_components(WebDriver driver) {
		this.driver = driver;
	}
	
	public void exp_wait(List<WebElement> elements, WebDriver driver) {
		
		WebDriverWait exp_wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		exp_wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public WebElement exp_wait_webelement(WebElement element, WebDriver driver) {
		WebDriverWait exp_wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		return(exp_wait.until(ExpectedConditions.visibilityOf(element)));
	}
	
	public orders ordersPage(String a) {
		orders orderDisplay = new orders(driver);
		orderDisplay.order(a);
		return orderDisplay;
	}
	
}
