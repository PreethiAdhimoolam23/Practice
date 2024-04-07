import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reports {
	ExtentReports extent;
	
	public  void report_extent() {
		//ExtentReports extent;
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Testing results");
		reporter.config().setDocumentTitle("Test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Preethi");
		extent.flush();
		
	}
	
@Test
public void initial() {
		
		ExtentTest test = extent.createTest("demo test");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/client/");
	    driver.manage().window().maximize();
	    extent.flush();
	}
}
