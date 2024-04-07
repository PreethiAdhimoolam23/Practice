package POM;

import java.util.List;

import org.bouncycastle.pkix.SubjectPublicKeyInfoChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstract_components.Abstract_components;

public class SubmitOrder extends Abstract_components {

	WebDriver driver;
	
	public SubmitOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[text()=\"Checkout\"]")
	WebElement checkout;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country_textbox;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']/../section/button/span")
	List<WebElement> country;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']/../section/button")
	List<WebElement> country_click;
	
	@FindBy(xpath = "//a[text()=\"Place Order \"]")
	WebElement order;
	
	@FindBy(xpath = "//h1[text()=\" Thankyou for the order. \"]")
	WebElement note;
	
	public List<WebElement> country() {
		exp_wait(country, driver);
		return country;
	}
	public List<WebElement> country_click() {
		exp_wait(country_click, driver);
		return country_click;
	}
	
	public WebElement placeOrder() {
		checkout.click();
		country_textbox.sendKeys("India");
		for(int x=0; x<country.size(); x++) {
			String country_value = country.get(x).getText();
			System.out.println(country_value);
			if(country_value.equalsIgnoreCase("India")) {
				country_click.get(x).click();
				break;
			}
		}
		order.click();
		return note;
	}
}
