package UIPractice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakeScreenshot {
	
	@Test
	//Taking screenshot using the getScreenshotAs()
	public void takeScreenshotOfElement() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		
		File file = email.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("C:\\Users\\prash\\eclipse-workspace\\InterviewPrepration\\target\\Screenshot/email.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void takeScreenshotOfWholePage() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		TakesScreenshot shot = (TakesScreenshot)driver;
		File file = shot.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("C:\\\\Users\\\\prash\\\\eclipse-workspace\\\\InterviewPrepration\\\\target\\\\Screenshot/Page.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void takeScreenshotOfElementUsingTakesScreenshot() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement email = driver.findElement(By.id("input-email"));
		TakesScreenshot shot = (TakesScreenshot)email;
		File file = shot.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("C:\\\\Users\\\\prash\\\\eclipse-workspace\\\\InterviewPrepration\\\\target\\\\Screenshot/Email1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
