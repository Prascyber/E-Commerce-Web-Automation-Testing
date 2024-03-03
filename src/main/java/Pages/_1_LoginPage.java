package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import Utility.ReadData;

public class _1_LoginPage extends TestBase{
	
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement applicationLogo;
	@FindBy(xpath = "//input[@id='user-name']") private WebElement usernameTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginButton;
	
	public _1_LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyLoginToApplication() throws IOException {
		
		logger = report.createTest("Login to Sause Lab Application");
		usernameTextBox.sendKeys(ReadData.readProperties("Username"));
		logger.log(Status.INFO, "Username is entered");
		passwordTextBox.sendKeys(ReadData.readProperties("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginButton.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login Successfull");
		return driver.getCurrentUrl();
	}

//   public String loginMultipleCredential(String user, String password) throws IOException {
//		
//		/*logger = report.createTest("Login to Sause Lab Application");*/
//		//usernameTextBox.sendKeys(/*ReadData.readProperties("Username")user*/);
//		/*logger.log(Status.INFO, "Username is entered");*/
//		//passwordTextBox.sendKeys(/*ReadData.readProperties("Password")password*/);
//		/*logger.log(Status.INFO, "Password is entered");*/
//		//loginButton.click();
//		/*logger.log(Status.INFO, "Login button is clicked");
//		logger.log(Status.PASS, "Login Successfull");*/
//		return driver.getCurrentUrl();
//	}
//
	
	public boolean verifyApplicationLogo() {
		
		logger = report.createTest("Test Case of Verify Login Logo");
		logger.log(Status.INFO, "Logo is Displayed");
		logger.log(Status.PASS, "Login Logo Verified Successfull");
		return applicationLogo.isDisplayed();
		
	}
	
	public String verifyTitle() {
		
		logger = report.createTest("Test Case of Verify Title");
		logger.log(Status.INFO, "Title is Displayed");
		logger.log(Status.PASS, "Title Verified Succesfully");
		return driver.getTitle();
	}
	
	public String verifyUrl() {
		
		logger = report.createTest("Test Case of Verify URL");
		logger.log(Status.INFO, "URL is Displayed");
		logger.log(Status.PASS, "URL Verified Succesfully");
		return driver.getCurrentUrl();
	}

}
