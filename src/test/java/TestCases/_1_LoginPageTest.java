package TestCases;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._1_LoginPage;
import Utility.ReadData;
import Utility.ScreenShot;

public class _1_LoginPageTest extends TestBase {

	_1_LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		
		initilization();
		login = new _1_LoginPage();
	}
	
	@Test(enabled = true, priority = 1,dependsOnMethods = "verifyUrlTest",groups = {"Regression","Sanity"})
	public void verifyTitleTest() throws EncryptedDocumentException, IOException {
		String expResult = ReadData.readExcelData(1, 0);
		String actResult = login.verifyTitle();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Current Title of Application "+actResult);
	
	}
	
	@Test(enabled = true, priority = 0,groups = {"Regression","Sanity"},invocationCount = 2)
	public void verifyUrlTest() throws EncryptedDocumentException, IOException {
		String expResult = ReadData.readExcelData(1, 1);
		String actResult = login.verifyUrl();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Current Url of Application "+ actResult);
	}
	
	@Test(enabled = true, priority = 2,dependsOnMethods = "verifyTitleTest", groups = "Smoke",timeOut = 1000)
	public void verifyApplicationLogoTest() {
		boolean actResult = login.verifyApplicationLogo();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Application Logo "+actResult);
		
	}
	
	@Test(enabled = true, priority = 3,groups = "Smoke")
	public void VerifyLoginToApplicationTest() throws IOException {
		String expResult = ReadData.readExcelData(1, 2);
		String actResult = login.VerifyLoginToApplication();
		
		Assert.assertEquals(expResult, actResult);
		Reporter.log("After Login URL of Application "+actResult);
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
