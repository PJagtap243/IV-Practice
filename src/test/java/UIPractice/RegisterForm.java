 	package UIPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RegisterForm {
	
	String url = "https://selectorshub.com/xpath-practice-page/";
	WebDriver driver;
	@Test
	public void enterDataInRegisterFormTest() throws InterruptedException {
		
		By userName = By.name("email");
		By passwordName = By.id("pass");
		By companyName = By.name("company");
		By country = By.xpath("//label[text()='Country']/input");
		By submit_btn = By.xpath("//button[@value='Submit']");
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(userName).sendKeys("prashant123@gmail.com");
		driver.findElement(passwordName).sendKeys("prashant123");
		driver.findElement(companyName).sendKeys("NTT Data");
		driver.findElement(country).sendKeys("India");
		driver.findElement(submit_btn).click();
	}
	
	@Test
	public void selectUserBasedOnName() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1500);
		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//td[text()='Jasmine Morgan']//parent::tr/td/input[@type='checkbox']"))).build().perform();
		driver.findElement(By.xpath("//td[text()='Jasmine Morgan']//parent::tr/td/input[@type='checkbox']")).click();
		
	}
	
	@Test
	public void clickOnLinkUnderShadowDOM() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
		String jsQuery = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement)js.executeScript(jsQuery);
		Actions act = new Actions(driver);
		act.scrollToElement(ele).build().perform();
		ele.sendKeys("Pizza");
	}

}
