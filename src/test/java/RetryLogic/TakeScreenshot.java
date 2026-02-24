package RetryLogic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

@Listeners(TakeScreenshot.class)
public class TakeScreenshot implements ITestListener{
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https:\\www.google.com");

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, false);
	}
	@Test
	public void test2() {
		Assert.assertEquals(true, false);
	}
	@Test
	public void test3() {
		Assert.assertEquals(true, false);
	}
	
	public void getScreenshot(String methodname) {
		TakesScreenshot shot = (TakesScreenshot)driver;
		File srcfile = shot.getScreenshotAs(OutputType.FILE);		
		try {
			Files.copy(srcfile, new File("C:\\Users\\prash\\eclipse-workspace\\InterviewPrepration\\screenshot\\"+methodname+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) {
		getScreenshot(result.getMethod().getMethodName());
	  }

}
