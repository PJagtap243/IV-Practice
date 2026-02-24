package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuClick {

	@Test
	public void selectCheckBox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/context_menu");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().build().perform();
		Thread.sleep(1500);
		driver.quit();
	}
}
