package Testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGConcepts {
	
	@Test(invocationCount = 5)
	public void invocationCountAnnotationTest() {
		System.out.println("This is invocation count method..");
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void expectedExcceptionAnnotationTest() {
		int i = 9/0;
		System.out.println("After the expected exception..");
	}
	
	@Test(enabled = true)
	public void mainMethod() {
		System.out.println("Main method..");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "mainMethod")
	public void dependadntMethod() {
		System.out.println("This method is depends on mainMethod");
	}
	
	
	@Parameters({"browser", "url"})
	@Test
	public void parameterFromTestngFile(String browserName, String url) {
		System.out.println("BrowserName : "+browserName);
		System.out.println("URL : "+url);
	}

}
