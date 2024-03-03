package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _6_CheckoutCompletePage extends TestBase {

	@FindBy(xpath = "//span[@class='title']")
	private WebElement checkoutCompleteLable;
	@FindBy(xpath = "//img[@alt='Pony Express']")
	private WebElement orderCompleteImage;
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement orderThankyouLable;
	@FindBy(xpath = "//div[@class='complete-text']")
	private WebElement orderDispatchLable;
	@FindBy(xpath = "//button[@id='back-to-products']")
	private WebElement backHomeBtn;

	public _6_CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifycheckoutCompleteLable() {
		return checkoutCompleteLable.isDisplayed();
	}

	public boolean verifyorderCompleteImage() {
		return orderCompleteImage.isDisplayed();
	}

	public boolean verifyorderThankyouLable() {
		return orderThankyouLable.isDisplayed();
	}

	public boolean verifyorderDispatchLable() {
		return checkoutCompleteLable.isDisplayed();
	}

	public String verifybackHomeBtn() {
		backHomeBtn.click();
		return driver.getCurrentUrl();
	}
}
