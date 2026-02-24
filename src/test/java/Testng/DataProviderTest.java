package Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			{"Prashant", "Jagtap"},
			{"Pranjali", "Mane"}
		};
	}
	
	@Test(dataProvider = "testData")
	public void fullNameTest(String firstName, String lastName) {
		System.out.println(firstName +" "+lastName);
	}

}
