package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AddToCart;
import POM.LoginPOM;
import POM.Product_catalogue;
import POM.SubmitOrder;
import Reusable_components.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void error() throws IOException {
		//.ng-trigger-flyInOut
		
		Product_catalogue pc = pom.login("pradeep@gmail.com", "Preethi23");
		Assert.assertEquals(pom.getErrorMessage().getText(), "Incorrect email or password.");
	}
	
	@Test
	public void ProductErrorValidation() {
		String a = "ZARA COAT 3";
		 Product_catalogue pc = pom.login("preethiadhi@gmail.com", "Preethi23");
	        AddToCart atc = pc.catalogue(a);
	        SubmitOrder order = atc.addProductCart(a);
	        
	        Assert.assertTrue(order.placeOrder().isDisplayed());
	}
}
