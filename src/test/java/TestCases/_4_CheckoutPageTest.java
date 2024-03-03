package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._3_CartPage;
import Pages._4_CheckoutPage;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _4_CheckoutPageTest extends TestBase {

	_1_LoginPage login;
	_2_InventoryPage inventory;
	_3_CartPage cart;
	_4_CheckoutPage checkout;
	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InterruptedException {
		initilization();
		login = new _1_LoginPage();
		inventory = new _2_InventoryPage();
		cart = new _3_CartPage();
		checkout = new _4_CheckoutPage();
		login.VerifyLoginToApplication();
		inventory.addAllProduct();
		cart.verifyCheckout();
		
	}
	
	@Test(enabled = false)
	public void verifyCheckoutPageUrlTest() {
		String expResult = "https://www.saucedemo.com/checkout-step-one.html";
		String actResult = checkout.verifyCheckoutPageUrl();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Checkout Page URL :- "+actResult);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyCheckoutLableTest() {
		boolean actResult = checkout.verifyCheckoutLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Checkout Lable Displayed:- "+actResult);
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyAddressInformationTest() throws InterruptedException {
		String expResult = "https://www.saucedemo.com/checkout-step-two.html";
		String actResult = checkout.verifyAddressInformation();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("After Continuee URL is:- "+actResult);
	}
	
	@AfterTest(alwaysRun = true)
	public void exit() throws IOException {
		driver.close();
	}
}
