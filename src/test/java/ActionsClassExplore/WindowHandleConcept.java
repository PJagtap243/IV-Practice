package ActionsClassExplore;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandleConcept {
	
	WebDriver driver;
	
	@Test
	public void windowHandleTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String parentWindow = driver.getWindowHandle();
		
		WebElement lnEle = driver.findElement(By.xpath("//a[contains(@href,'linked')]"));
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		
		lnEle.click();
		fbEle.click();
		twEle.click();
		ytEle.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while(itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			Thread.sleep(1500);
			System.out.println(driver.getTitle());
			
			if(!windowId.equals(parentWindow)) {
				driver.close();
			}
		}
	}

}
