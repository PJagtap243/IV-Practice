package Testng;

import org.testng.annotations.Test;

public class GroupingConcept {
	
	@Test(groups = "smoke")
	public void method1() {
		System.out.println("Method 1..");
	}
	
	@Test(groups = "regression")
	public void method2() {
		System.out.println("Method 2..");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void method3() {
		System.out.println("Method 3..");
	}

}
