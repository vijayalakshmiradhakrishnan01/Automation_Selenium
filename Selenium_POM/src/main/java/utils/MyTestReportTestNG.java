package utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestReportTestNG extends ReportTestNG {
	
	
	
	  @BeforeTest 
	  void setData() {
		
		  desc="first test"; 
		  author ="Viji"; 
		  category ="sanity";
		 
	  
	//  designTest("First test","Vijayalakshmi","Reg");
	  
	  }
	 
	@Test
	void myTest() {
		System.out.println("Test begins");
		stepReport("pass","some decription");
		System.out.println("Test ends");
	}

}
