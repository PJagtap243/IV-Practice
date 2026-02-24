package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameTest {
	
	@Test
	public void getTextFromFrame() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		Thread.sleep(1500);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		String frameName = driver.findElement(By.xpath("//body[normalize-space()='LEFT']")).getText();
		System.out.println(frameName);
	}

}
