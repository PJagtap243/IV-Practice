package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFrameTest {
	
	@Test
	public void frameTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'tox-edit-area')]")));
		String text = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
		System.out.println(text);
	}
}
