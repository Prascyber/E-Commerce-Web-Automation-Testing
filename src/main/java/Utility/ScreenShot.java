package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class ScreenShot extends TestBase {
	
	
	public static void getScreenShot(String testName) throws IOException {
		
		
		File screenShotResource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destResource = new File("C:\\Users\\91942\\eclipse-workspace\\SwagLabProject\\ScreenShots\\"+testName+".jpeg");
		FileHandler.copy(screenShotResource, destResource);
	}

}
