package Utility;


import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
	public static ExtentReports report;
	public static ExtentReports getReportInstance() {
		
		Date d = new Date();
		String reportDate = d.toString();
		
		if(report == null) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\91942\\eclipse-workspace\\SwagLabProject\\ExtentReport\\report.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Envaornment", "Production");
		report.setSystemInfo("Build Number", "1.0");
		report.setSystemInfo("Browser", "Chrome");
		
		htmlReporter.config().setDocumentTitle("UI Automation");
		htmlReporter.config().setReportName("UI Test Report");
		
		}
		return report;

	}

}
