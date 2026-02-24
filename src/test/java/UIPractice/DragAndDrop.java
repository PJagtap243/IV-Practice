package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	@Test
	public void dragAndDropTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		Actions act = new Actions(driver);
		WebElement blockA = driver.findElement(By.id("column-a"));
		WebElement blockB = driver.findElement(By.id("column-b"));
		
		act.clickAndHold(blockA).moveToElement(blockB).release().build().perform();
		
		//act.dragAndDrop(blockA, blockB).build().perform();
	}

}
