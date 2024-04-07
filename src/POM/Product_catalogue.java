package POM;

import java.util.List;

import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract_components.Abstract_components;

public class Product_catalogue extends Abstract_components{

	WebDriver driver;
	
	public Product_catalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//section[@id=\"products\"]/div/div[2]/div/div/div/h5/b")
	List<WebElement> products;
	
	@FindBy(xpath = "//section[@id=\"products\"]/div/div[2]/div/div/div/h5/b/../../button[2]/i")
	List<WebElement> product_add;
	
	
	
	public List<WebElement> getProduct_list(){
		
		exp_wait(products, driver);
		return products;
	}
	
	public List<WebElement> get_product_add(){
		exp_wait(product_add, driver);
		return product_add;
	}
	
	public AddToCart catalogue(String a) {
		for(int i=0; i<getProduct_list().size(); i++) {
			String value = getProduct_list().get(i).getText();
			if(value.equalsIgnoreCase(a)) {
				get_product_add().get(i).click();
		}
	}
		AddToCart atc = new AddToCart(driver);
		return atc;
	}
	
}
