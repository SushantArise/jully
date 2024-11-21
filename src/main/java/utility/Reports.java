package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReport() {
		ExtentSparkReporter htmlReport= new ExtentSparkReporter("SawagLabTestReport.html");
	    ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("ProjectName", "SwagLab");
		reports.setSystemInfo("Owner", "Arise");
		return reports;
	}
	
}
