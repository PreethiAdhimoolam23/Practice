package RSA_StandAlone;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTesting {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys("preethiadhi@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Preethi23");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		WebDriverWait exp_wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products = exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//section[@id=\"products\"]/div/div[2]/div/div/div/h5/b"))));
		List<WebElement> Product_add = exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//section[@id=\"products\"]/div/div[2]/div/div/div/h5/b/../../button[2]/i"))));
		
		String ab="ZARA COAT 3";
		for(int i=0; i<products.size(); i++) {
			String value = products.get(i).getText();
		if(value.equalsIgnoreCase(ab)) {
			Product_add.get(i).click();
		}
		}
		
		Thread.sleep(5000);
		//exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()=\"Product Added to Cart\"]"))));
		exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")))).click();
		
		List<WebElement> cart_products = exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class=\"cart\"]/ul/li/div/div/h3"))));
		
		for(int a=0; a<cart_products.size(); a++) {
		String cart_value = cart_products.get(a).getText();
		Assert.assertEquals(cart_value, ab);
		}
		
		exp_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Checkout\"]"))).click();
		exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Select Country']")))).sendKeys("India");
		
		List<WebElement> country = exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//input[@placeholder='Select Country']/../section/button/span"))));
		List<WebElement> country_click = exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//input[@placeholder='Select Country']/../section/button"))));
		
		for(int x=0; x<country.size(); x++) {
			String country_value = country.get(x).getText();
			System.out.println(country_value);
			if(country_value.equalsIgnoreCase("India")) {
				country_click.get(x).click();
				break;
			}
		}
		
		
		exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=\"Place Order \"]")))).click();
		exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()=\" Thankyou for the order. \"]"))));
		
	}

}
