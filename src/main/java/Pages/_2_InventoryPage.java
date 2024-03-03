package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.DropDown;

public class _2_InventoryPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Products']" ) private WebElement productLable;
	@FindBy(xpath = "//select[@class='product_sort_container']" ) private WebElement productSort;
	@FindBy(xpath = "//a[text()='Twitter']" ) private WebElement tweeterLogo;
	@FindBy(xpath = "//a[text()='Facebook']" ) private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']" ) private WebElement linkindinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']" ) private WebElement copyrightLine;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']" ) private WebElement backpackProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']" ) private WebElement bikelightProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']" ) private WebElement bolttshirtProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']" ) private WebElement jacketProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']" ) private WebElement onesieProduct;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']" ) private WebElement redtshirtProduct;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']" ) private WebElement cart;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement gotoCart;
	
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']" ) private WebElement removebackpackProduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']" ) private WebElement removefleecejacketProduct;
	@FindBy(xpath = "//button[@name='remove-test.allthethings()-t-shirt-(red)']" ) private WebElement removeredtshirtProduct;
	
	public _2_InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifyProductLable() {
		
		return productLable.isDisplayed();
	}
	
	public boolean verifyTweeterLogo() {
		return tweeterLogo.isDisplayed();
	}
	
	public boolean verifyFacebookLogo() {
		return facebookLogo.isDisplayed();
	}

	
	public boolean verifylinkindinLogo() {
		return linkindinLogo.isDisplayed();
	}
	
	public boolean verifyCopyrightLine() {
		return copyrightLine.isDisplayed();
	}
	
	public String addAllProduct() throws InterruptedException {
		
		DropDown.dropDown(productSort, "Price (low to high)");
		backpackProduct.click();
		bikelightProduct.click();
		bolttshirtProduct.click();
		jacketProduct.click();
		onesieProduct.click();
		redtshirtProduct.click();
		gotoCart.click();
		
		return cart.getText();
		
	}
	
	public String verifyremoveCartProduct() {
		
		removebackpackProduct.click();
		removefleecejacketProduct.click();
		removeredtshirtProduct.click();
		
		return cart.getText();
	}
	
	public void clickonCart() {
		
		cart.click();
	}


	

}
