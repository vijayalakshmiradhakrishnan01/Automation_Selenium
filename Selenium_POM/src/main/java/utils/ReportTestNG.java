package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportTestNG {

	ExtentReports extent;
	ExtentTest test;
   String desc; String author ; String category = "";
	  
	 
	@BeforeSuite
	protected void startReport() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	@AfterSuite
	protected void endReport() {

		extent.flush();
	}

	@BeforeClass
	//remove @beforeClass and add below method, this willalso work., but this method has to run for before all the class right.
	//Before test has 
	// void designTest(String desc ,String author,String category) {
	void designTest() {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(category);

	}

	void stepReport(String status, String description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.pass(description);
			break;
		case "info":
			test.pass(description);
			break;
		case "warning":
			test.pass(description);
			break;

		default:
			System.err.println("Status is not defined");
			break;
		}

	}

}
