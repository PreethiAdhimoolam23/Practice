package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstract_components.Abstract_components;

public class AddToCart extends Abstract_components {

	WebDriver driver;
	public AddToCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//button[@class='btn btn-custom'])[3]")
	WebElement add_cart;
	
	@FindBy (xpath = "//div[@class=\"cart\"]/ul/li/div/div/h3")
	List<WebElement> products_cart;
	
	
	
	public List<WebElement> products_list() {
		exp_wait(products_cart, driver);
		return products_cart;	
	}
	
	public SubmitOrder addProductCart(String x) {
		add_cart.click();
		//Thread.sleep(5000);
		for(int a=0; a<products_list().size(); a++) {
			String cart_value = products_list().get(a).getText();
			Assert.assertEquals(cart_value, x);
			}
		SubmitOrder order = new SubmitOrder(driver);
		return order;
	}
}
