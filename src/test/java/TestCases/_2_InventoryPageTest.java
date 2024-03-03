package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;
import Utility.ReadData;

public class _2_InventoryPageTest extends TestBase {

	_1_LoginPage login;
	_2_InventoryPage inventory;
	@BeforeTest(alwaysRun = true)
	public void setUp() throws IOException {
		initilization();
		login = new _1_LoginPage();
		inventory = new _2_InventoryPage();
		login.VerifyLoginToApplication();
		
	}
	
	@Test(groups = "Smoke")
	public void verifyProductLableTest() {
		boolean actResult = inventory.verifyProductLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of product lable "+actResult);
	}
	
	@Test(groups = "Smoke")
	public void verifyTweeterLogoTest() {
		boolean actResult = inventory.verifyTweeterLogo();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of tweeter logo "+actResult);
	}
	
	@Test(enabled = true,groups = "Smoke")
	public void verifyFacebookLogoTest() {
		boolean actResult = inventory.verifyFacebookLogo();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of facebook logo "+actResult);
	}
	
	@Test(enabled = true ,groups = "Smoke")
	public void verifylinkindinLogoTest() {
		boolean actResult = inventory.verifylinkindinLogo();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of linkidin logo "+actResult);
	}
	
	@Test(enabled = true,groups = "Smoke")
	public void verifyCopyrightLineTest() {
		boolean actResult = inventory.verifyCopyrightLine();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of copyRightLine line "+actResult);
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addAllProductTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String expCount = ReadData.readExcelData(1, 3);
		String actCount = inventory.addAllProduct();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of product is "+actCount);
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyremoveCartProductTest() throws EncryptedDocumentException, IOException {
		String expResult = ReadData.readExcelData(1, 4);
		String removeProduct = inventory.verifyremoveCartProduct();
		Assert.assertEquals(expResult, removeProduct);
		Reporter.log("After removing products "+removeProduct);
	}


	@AfterTest(alwaysRun = true)
	
	public void exit() {
		driver.close();
	}
}
