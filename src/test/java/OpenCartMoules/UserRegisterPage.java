package OpenCartMoules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegisterPage {
	
	WebDriver driver;
	By myAccount = By.xpath("//span[text()='My Account']");
	By registerLink = By.linkText("Register");
	By fName = By.name("firstname");
	By lName = By.name("lastname");
	By email = By.name("email");
	By telephone = By.name("telephone");
	By pwd = By.name("password");
	By confirmPwd = By.name("confirm");
	By subscribeYes = By.xpath("//label[normalize-space()='Yes']");
	By subscribeNo = By.xpath("//label[normalize-space()='No']");
	By checkBox = By.name("agree");
	By contBtn = By.xpath("//input[@value='Continue']");
	
	@DataProvider
	public Object[][] userData() {
		return new Object[][] {
			{"Prashant1", "Jagtap1", "prashant11@gmail.com", "1234567890","Test@123","Yes", true},
			{"Prashant2", "Jagtap2", "prashant12@gmail.com", "1234567890","Test@123","No", true},
			{"Prashant3", "Jagtap3", "prashant13@gmail.com", "1234567890","Test@123","Yes", true},
		};		
	}
	
	@Test(dataProvider = "userData")
	public void RegisterUserUsingRegisterButton(String fname, String lname, String emailAdd, String phone, 
			String pawd, String subscribe, boolean check) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount));
		driver.findElement(myAccount).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		driver.findElement(registerLink).click();
		
		driver.findElement(fName).sendKeys(fname);
		driver.findElement(lName).sendKeys(lname);
		driver.findElement(email).sendKeys(emailAdd);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(pwd).sendKeys(pawd);
		driver.findElement(confirmPwd).sendKeys(pawd);
		if(subscribe.equalsIgnoreCase("Yes")) {
			driver.findElement(subscribeYes).click();
		}else {
			driver.findElement(subscribeNo).click();
		}
		driver.findElement(checkBox).click();
		driver.findElement(contBtn).click();
		driver.close();
	}

}
