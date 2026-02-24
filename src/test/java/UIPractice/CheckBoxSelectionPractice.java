package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBoxSelectionPractice {
	
	@Test
	public void selectCheckBox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		checkbox1.click();
		Thread.sleep(1500);
		driver.quit();	
	}

}
