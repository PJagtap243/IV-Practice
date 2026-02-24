package UIPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {
	
	@Test
	public void windowTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		String parentFrame = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String>handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while(itr.hasNext()) {
			String windowId = itr.next();
			if(!windowId.equals(parentFrame)) {
			driver.switchTo().window(windowId);
			String message = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
			System.out.println(message);
			driver.close();
			}
		}
		Thread.sleep(1500);
		driver.switchTo().window(parentFrame);
		String message2 = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		System.out.println(message2);
		driver.quit();
	}

}
