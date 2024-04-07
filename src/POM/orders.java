package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract_components.Abstract_components;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orders extends Abstract_components {

	WebDriver driver;
	
	public orders(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement order;
	
	@FindBy (xpath = "//table[@class = \"table table-bordered table-hover ng-star-inserted\"]/tbody/tr/td[2]")
	List<WebElement> elements;
	
	public String order(String a) {
		order.click();
		String value = null;
		for (int i=0; i<elements.size(); i++) {
			value = elements.get(i).getText();
			if(value.equalsIgnoreCase(a)) {
				System.out.println(value);
				break;
			}
		}
		return value;
	}
}
