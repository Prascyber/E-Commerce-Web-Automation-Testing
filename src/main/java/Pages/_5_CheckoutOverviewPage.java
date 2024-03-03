package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _5_CheckoutOverviewPage extends TestBase {

	@FindBy(xpath = "//span[@class='title']") private WebElement overviewLable;
	@FindBy(xpath = "//div[@class='summary_info_label'][1]") private WebElement paymentInfoLabal;
	@FindBy(xpath = "//div[@class='summary_info_label'][2]") private WebElement shippingInfoLabal;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement totalAmmountInfoLabal;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;

	
	public _5_CheckoutOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public boolean verifyoverviewLable() {
		return overviewLable.isDisplayed();
	}
	
	public boolean verifypaymentInfoLabal() {
		return paymentInfoLabal.isDisplayed();
	}
	
	public boolean verifyshippingInfoLabal() {
		return shippingInfoLabal.isDisplayed();
	}
	
	public boolean verifytotalAmmountInfoLabal() {
		return totalAmmountInfoLabal.isDisplayed();
	}
	
	public String verifyfinishBtn() {
		finishBtn.click();
		 return driver.getCurrentUrl();
	}

		
}
