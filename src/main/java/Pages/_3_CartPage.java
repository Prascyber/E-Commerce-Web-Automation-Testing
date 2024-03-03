package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _3_CartPage extends TestBase {
	
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement verifyCartLable;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement CheckoutBtn;
	
	public _3_CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String verifyCartLable() {
		return verifyCartLable.getText();
	}
	
	public void verifyCheckout() {
		CheckoutBtn.click();
	}

	
	

}
