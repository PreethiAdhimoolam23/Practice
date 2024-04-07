package POM;

import org.bouncycastle.crypto.engines.ISAACEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import Abstract_components.Abstract_components;

public class LoginPOM extends Abstract_components{

	WebDriver driver;
	public LoginPOM(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement submit;
	
	@FindBy(css = "[class*='ng-trigger-flyInOut']")
	WebElement errorMessage;
	
	public Product_catalogue login(String email, String pass) {
		username.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		Product_catalogue pc = new Product_catalogue(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	public WebElement getErrorMessage() {
		WebElement errorElement = exp_wait_webelement(errorMessage, driver);
		return errorElement;
	}
	
}
