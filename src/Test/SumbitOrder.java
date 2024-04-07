package Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.ContextNotEmptyException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.AddToCart;
import POM.LoginPOM;
import POM.Product_catalogue;
import POM.SubmitOrder;
import POM.orders;
import Reusable_components.BaseTest;
import Reusable_components.RetryTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SumbitOrder extends BaseTest {

	
	@Test(groups = "Smoke", dataProvider = "getData")
	public  void submitOrder(HashMap<String, String> input) throws IOException {
		
		//String a = "ZARA COAT 3";
        Product_catalogue pc = pom.login(input.get("email"), input.get("password"));
        AddToCart atc = pc.catalogue( input.get("product"));
        SubmitOrder order = atc.addProductCart( input.get("product"));
        
        Assert.assertTrue(order.placeOrder().isDisplayed());
	}
	
	
	@Test(dependsOnMethods = "submitOrder", retryAnalyzer = RetryTest.class)
	public void order() {
		////button[@routerlink="/dashboard/myorders"]
		
		String a = "ZARA COAT 3";
        Product_catalogue pc = pom.login("preethiadhi@gmail.com", "Preethi23");
        AddToCart atc = pc.catalogue(a);
        SubmitOrder order = atc.addProductCart(a);
        orders orderDisplay = pc.ordersPage(a);
	}
	
@DataProvider
	public Object[][] getData() throws IOException {
	
		List<HashMap<String, String>> data = jsondatareader("C:\\Users\\Preethi\\eclipse-workspace\\Selenium_RSA_Framework\\src\\Reusable_components\\data.json");
		
		Object[][] a= {{data.get(0)}, {data.get(1)}};
		return a;
	}
	
	

}
