package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._2_InventoryPage;
import Pages._3_CartPage;
import Pages._1_LoginPage;
import Utility.ReadData;
import Utility.ScreenShot;

public class _3_CartPageTest extends TestBase {
	_1_LoginPage login;
	_2_InventoryPage inventory;
	_3_CartPage cart;
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		initilization();
		_1_LoginPage _1_LoginPage = new _1_LoginPage();
		inventory = new _2_InventoryPage();
		cart = new _3_CartPage();
		_1_LoginPage.VerifyLoginToApplication();
		inventory.addAllProduct();
		inventory.clickonCart();
		
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyCartCurrentUrlTest() throws EncryptedDocumentException, IOException {
		String expResult = ReadData.readExcelData(1, 5);
		String actResult = cart.verifyCartCurrentUrl();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Current url is "+ actResult);
		
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyCartLableTest() throws EncryptedDocumentException, IOException {
		String expResult = /*ReadData.readExcelData(1, 6)*/ "Your Cart";
		String actResult = cart.verifyCartLable();
		Assert.assertEquals(actResult, expResult);
		Reporter.log("Cart lable "+actResult);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyCheckoutTest() {
		cart.verifyCheckout();
	}
	
	
	@AfterTest(alwaysRun = true)
	public void exit(/*ITestResult it*/) throws IOException {
		/*if(it.FAILURE == it.getStatus()) {
			ScreenShot.getScreenShot(it.getName());
		}*/
		driver.close();
	}

}
