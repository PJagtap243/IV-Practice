package OpenCartMoules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AccountPage {
	By uname = By.name("email");
	By pwd = By.name("password");
	By loginBtn = By.xpath("//input[@type='submit']");
	By searchField = By.name("search");
	By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
	
	
	WebDriver driver;
	
	@Test
	public void searchProduct() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.presenceOfElementLocated(uname));
		driver.findElement(uname).sendKeys("jagtapprashant841@gmail.com");
		driver.findElement(pwd).sendKeys("Test@123");
		driver.findElement(loginBtn).click();
		Thread.sleep(5000);
		driver.findElement(searchField).sendKeys("macbook");
		driver.findElement(searchBtn).click();
	}

}
