package ActionsClassExplore;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MouseActions {

	WebDriver driver;
	
	@Test
	public void moveToElementMethodTest() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement searchField = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		
		//act.click(searchField).keyDown(Keys.SHIFT).sendKeys("This is capital text").
		//	keyUp(Keys.SHIFT).sendKeys("and this is entered in small text").build().perform();
		
		act.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
		
	}
}
