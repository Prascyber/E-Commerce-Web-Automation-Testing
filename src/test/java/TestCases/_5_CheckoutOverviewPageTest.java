package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._3_CartPage;
import Pages._5_CheckoutOverviewPage;
import Pages._4_CheckoutPage;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _5_CheckoutOverviewPageTest extends TestBase{

	_1_LoginPage login;
	_2_InventoryPage inventory;
	_3_CartPage cart;
	_4_CheckoutPage checkout;
	_5_CheckoutOverviewPage checkoutOverview;
	
	
	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InterruptedException {
		 initilization();
		 login = new _1_LoginPage();
		 inventory = new _2_InventoryPage();
		 cart= new _3_CartPage();
		 checkout= new _4_CheckoutPage();
		 checkoutOverview = new _5_CheckoutOverviewPage();
		 login.VerifyLoginToApplication();
		 inventory.addAllProduct();
		 cart.verifyCheckout();
		 checkout.verifyAddressInformation();
		 
		 
	}
	
	@Test(groups = "Smoke")
	public void verifyoverviewLableTest() {
		boolean actResult = checkoutOverview.verifyoverviewLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Overview Lable:-"+actResult);
	}
	
	@Test(enabled = false)
	public void verifypaymentInfoLabalTest() {
		boolean actResult = checkoutOverview.verifypaymentInfoLabal();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Payment Information Lable:-"+actResult);
	}

	@Test(enabled = false)
	public void verifyshippingInfoLabalTest() {
		boolean actResult = checkoutOverview.verifyshippingInfoLabal();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Shipping Information Lable:-"+actResult);
	}

	@Test(enabled = false)
	public void verifytotalAmmountInfoLabal() {
		boolean actResult = checkoutOverview.verifytotalAmmountInfoLabal();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Ammount Information Lable:-"+actResult);
	}

	@Test(enabled = true,groups = {"Regression","Sanity"})
	public void verifyfinishBtnTest() {
		String expResult = "https://www.saucedemo.com/checkout-complete.html";
		String actResult = checkoutOverview.verifyfinishBtn();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("After Finish Button URL:-"+actResult);
	}

	
	@AfterTest(alwaysRun = true)
	public void exit() {
		driver.close();
	}
	
	
}
