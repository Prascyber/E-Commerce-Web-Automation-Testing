package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void dropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

}
