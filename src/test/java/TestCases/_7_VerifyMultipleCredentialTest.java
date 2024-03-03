package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages._1_LoginPage;
import Utility.ScreenShot;

public class _7_VerifyMultipleCredentialTest extends TestBase{
	_1_LoginPage login;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		
		initilization();
		login = new _1_LoginPage();
	}
	
	@Test
	public void loginMultipleCredentialTest(String user,String password) throws IOException {
		SoftAssert sA = new SoftAssert();
		String expResult = "https://www.saucedemo.com/v1/inventory.html";
		/*String ActResult = login.loginMultipleCredential(user,password);
		sA.assertEquals(expResult, ActResult);
		sA.assertAll();
		Reporter.log("Current URL is:-"+ActResult);*/
	}
	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] {
			
				{"standard_user","secret_sauce"},
				{"locked_out_user","locked_out_user"},
				{"problem_user","problem_user"},
				{"performance_glitch_user","performance_glitch_user"}
			
		};
	}
	
	
	@SuppressWarnings("static-access")
	@AfterMethod(alwaysRun = true)
	
	public void close(ITestResult it) throws IOException {
		if(it.FAILURE == it.getStatus()) {
			ScreenShot.getScreenShot(it.getName());
		}
		report.flush();
		driver.close();
	}


}
