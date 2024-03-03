package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._3_CartPage;
import Pages._6_CheckoutCompletePage;
import Pages._5_CheckoutOverviewPage;
import Pages._4_CheckoutPage;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _6_CheckoutCompletePageTest extends TestBase {

	_1_LoginPage loginPage;
	_2_InventoryPage inventoryPage;
	_3_CartPage cartPage;
	_4_CheckoutPage checkoutPage;
	_5_CheckoutOverviewPage checkoutOverviewPage;
	_6_CheckoutCompletePage checkoutCompletePage;
	
	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InterruptedException {
		initilization();
		loginPage = new _1_LoginPage();
		inventoryPage = new _2_InventoryPage();
		cartPage = new _3_CartPage();
		checkoutPage = new _4_CheckoutPage();
		checkoutOverviewPage = new _5_CheckoutOverviewPage();
		checkoutCompletePage = new _6_CheckoutCompletePage();
		loginPage.VerifyLoginToApplication();
		inventoryPage.addAllProduct();
		cartPage.verifyCheckout();
		checkoutPage.verifyAddressInformation();
		checkoutOverviewPage.verifyfinishBtn();
	}
	
	@Test(groups = "Smoke")
	public void verifycheckoutCompleteLableTest() {
		
		boolean actResult = checkoutCompletePage.verifycheckoutCompleteLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Checkout Complete Label:-"+actResult);
	}
	
	@Test(enabled = false)
	public void verifyorderCompleteImageTest() {
		
		boolean actResult = checkoutCompletePage.verifyorderCompleteImage();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Order Complete Image:-"+actResult);
	}

	
	@Test(enabled = false)
	public void verifyorderThankyouLableTest() {
		
		boolean actResult = checkoutCompletePage.verifyorderThankyouLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Thanks You  Label:-"+actResult);
	}

	
	@Test(groups = "Smoke")
	public void verifyorderDispatchLableTest() {
		
		boolean actResult = checkoutCompletePage.verifyorderDispatchLable();
		Assert.assertEquals(actResult, true);
		Reporter.log("Visibility of Dispatch Message :-"+actResult);
	}

	
	@Test(groups = {"Regression","Sanity"})
	public void verifybackHomeBtnTest() {
		
		String expResult = "https://www.saucedemo.com/inventory.html";
		String actResult = checkoutCompletePage.verifybackHomeBtn();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("After Compliation of Order URL:-"+actResult);
	}
	
	@AfterTest(alwaysRun = true)
	public void exit() {
		driver.close();
	}

}
