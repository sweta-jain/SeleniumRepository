package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsManager {
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	public static String reportPath;
	
	public static ExtentReports getReportsInstance() {	
		if(extentReport == null) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			reportPath = "reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Test Execution Report");
			extentReport = new ExtentReports();
			extentReport.attachReporter(reporter);
		}
	return extentReport;
	}
	
	
	public ExtentTest createTest(String sTestName) {	
		
		extentTest = getReportsInstance().createTest(sTestName);		
		return extentTest;
	}
	
	public static String captureScreenShot(WebDriver pDriver, String sScreenName) {	
		try {
			File fileSrc = ((TakesScreenshot)pDriver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screnshots/" + sScreenName + ".png";
			FileUtils.copyFile(fileSrc, new File(path));
			
			return path;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
