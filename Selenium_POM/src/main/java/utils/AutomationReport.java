package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationReport {

	public static void main(String[] args) {
		//this will create a blank HTML 
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		
		//this will create out actual report
		ExtentReports extent = new ExtentReports();
	
		extent.attachReporter(reporter);
		//create test case (which is in the left handside)
		ExtentTest test = extent.createTest("TC001 - Search product");
		test.pass("Enter the desired product name");
		test.pass("Check if the product is listed");
		test.pass("Add the product to the cart");
		
		ExtentTest test2 = extent.createTest("TC002-Payment");
		test2.pass("Navigated to the payment page");
		test2.fail("Payment failed",MediaEntityBuilder.createScreenCaptureFromPath("sc.png").build());
		
		extent.flush();
		
		
		
	}
	

}
