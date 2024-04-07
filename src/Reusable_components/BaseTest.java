package Reusable_components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.devtools.v120.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dockerjava.api.model.Driver;

import POM.LoginPOM;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	WebDriver driver;
	public LoginPOM pom;
	@Test 
	public WebDriver initializingBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Reusable_components\\Browser.properties");
		prop.load(fis);
		//String browser_name = prop.getProperty("browser");
		
		String browser_name =System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browser_name.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if(browser_name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser_name.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("no browser value");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	//@BeforeMethod (alwaysRun = true)
	public LoginPOM launchingURL() throws IOException {
		driver = initializingBrowser();
        pom = new LoginPOM(driver);
        pom.goTo();
        return pom;
		
	}
	
	//@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public List<HashMap<String, String>> jsondatareader(String filepath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8); 
		
		//converting string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;

	}
	
public String screenshot(String testCaseName) throws IOException {
		
	TakesScreenshot ts = (TakesScreenshot)driver;
	File scr = ts.getScreenshotAs(OutputType.FILE);
	String filepath =System.getProperty("user.dir")+"//screenshot//"+testCaseName+".jpg";
	FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"//screenshot//"+testCaseName+".jpg"));
	return filepath;
	}

}
