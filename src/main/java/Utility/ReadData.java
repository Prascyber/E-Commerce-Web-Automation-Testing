package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
	public static String readProperties(String value) throws IOException {
		
		Properties pts = new Properties();
		FileInputStream propResource = new FileInputStream("C:\\Users\\91942\\eclipse-workspace\\SwagLabProject\\TestData\\config.properties");
		pts.load(propResource);
		return pts.getProperty(value);
	}
	
	public static String readExcelData(int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileResource = new FileInputStream("C:\\Users\\91942\\eclipse-workspace\\SwagLabProject\\TestData\\SwagLabData.xlsx");
		Sheet excelSheet = WorkbookFactory.create(fileResource).getSheet("Sheet1");
		String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
		
	}

}
