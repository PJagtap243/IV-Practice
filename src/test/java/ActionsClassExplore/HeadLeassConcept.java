package ActionsClassExplore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadLeassConcept {
	
	WebDriver driver;
	
	@Test
	public void launchBrowserInHeadlessMode() {
		
//		ChromeOptions op = new ChromeOptions();
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
		

		//driver = new ChromeDriver(op);
		
		driver = new FirefoxDriver(op);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
	}

}
