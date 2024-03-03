package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _4_CheckoutPage extends TestBase{

	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutLable;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTextBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTextBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalTextBox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;

	
	public _4_CheckoutPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPageUrl() {
		
		return driver.getCurrentUrl();
	}
	
	public boolean verifyCheckoutLable() {
		return checkoutLable.isDisplayed();
	}
	
	
	public String verifyAddressInformation() throws InterruptedException {
		firstnameTextBox.sendKeys("Shubham");
		lastnameTextBox.sendKeys("Meshram");
		postalTextBox.sendKeys("444901");
		continueBtn.click();
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
}
