package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import POM.AddToCart;
import POM.LoginPOM;
import POM.Product_catalogue;
import POM.SubmitOrder;
import Reusable_components.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{

	public LoginPOM pom;
	public Product_catalogue pc;
	public AddToCart atc;
	public SubmitOrder order;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException{
	
		pom = launchingURL();
	}
	
	@Given("^I logged in with username (.+) and password (.+)$")
	public void I_logged_in_with_username_and_password(String username, String password) {
		  pc = pom.login(username, password);
	}
	
	@When("^I add the Product (.+) to cart$")
	public void I_add_product_to_cart(String product) {
		atc = pc.catalogue(product);
	}
	
	@And("^checkout  (.+) is available and submit the order$")
	public void submitOrder(String product){
		order = atc.addProductCart(product);
	}
	
	@Then("\"Thankyou for the order.\" is displayed. I verify the confirmation message")
	public void confirmation_message() {
		Assert.assertTrue(order.placeOrder().isDisplayed());
	}
	
	@Then("\"Incorrect email or password.\" message is displayed")
	public void error_validation(){
		Assert.assertEquals(pom.getErrorMessage().getText(), "Incorrect email or password.");
	}
}
