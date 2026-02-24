package UIPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicControls {
	
	@Test
	public void waitForFieldToBeEnabled() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
		WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(textField));
		textField.sendKeys("Entered text after enableing the field..");
	}
	
	@Test
	public void waitForTextToBePresent() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		By textMessage = By.id("message");
		WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
		
		removeBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(textMessage));
		System.out.println(textMessage);
	}

}
