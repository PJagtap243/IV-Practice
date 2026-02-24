package ActionsClassExplore;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowHandleConcept2 {
	
WebDriver driver;
	
	@Test
	public void windowHandleTest() throws InterruptedException {
		driver = new ChromeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			String parentWindow = driver.getWindowHandle();
			
			By[] locators = new By[] {
				By.xpath("//a[contains(@href,'linkedin') ]"),
				By.xpath("//a[contains(@href,'facebook') ]"),
				By.xpath("//a[contains(@href,'twitter') ]"),
				By.xpath("//a[contains(@href,'youtube') ]")
			};
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			for (By locator : locators) {
				// find the element and click to open new window/tab
				WebElement ele = driver.findElement(locator);
				int before = driver.getWindowHandles().size();
				ele.click();
				// wait until a new window appears (before + 1)
				wait.until(ExpectedConditions.numberOfWindowsToBe(before + 1));
				
				// find the newly opened window and switch to it
				Set<String> handles = driver.getWindowHandles();
				for (String handle : handles) {
					if (!handle.equals(parentWindow)) {
						driver.switchTo().window(handle);
						System.out.println("Child window title: " + driver.getTitle());
						driver.close(); // close the child window
					}
				}
				// switch back to parent window
				driver.switchTo().window(parentWindow);
			}
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}