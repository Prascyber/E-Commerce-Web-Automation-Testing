package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentReportManager;
import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class TestBase {
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public static WebDriver driver;
	@SuppressWarnings({ "deprecation", "static-access" })
	public void initilization() throws IOException {
		
		try {
			
			String browser = ReadData.readProperties("Browser");
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else {
				WebDriverManager.operadriver().setup();
				driver = (WebDriver) new OperaDriverManager().operadriver();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
//				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		        driver.get(ReadData.readProperties("Url"));
	}

}
