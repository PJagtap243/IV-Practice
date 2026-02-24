package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	
	@Test
	public void selectDropDownOption() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		Thread.sleep(1500);
		Select s = new Select(driver.findElement(By.id("dropdown")));
		//s.selectByValue("Option 1");
		s.selectByVisibleText("Option 1");
	}

}
