package ActionsClassExplore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetTextAndGetAttributeConcept {
	
	WebDriver driver;
	String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/register";
	
	@Test
	public void getTextConceptTest() {
		driver = new ChromeDriver();
		driver.get(url);
		WebElement heading = driver.findElement(By.xpath("//div[@id='content']/h1"));
		System.out.println(heading.getText());
	}
	
	@Test
	public void getAttributeConceptTest() {
		driver = new ChromeDriver();
		driver.get(url);
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Prashant");
		firstName.clear();
		firstName.sendKeys("Jagtap");
		System.out.println(firstName.getAttribute("value"));
	}
	
	@Test
	public void getDOMAttributeConceptTest() {
		driver = new ChromeDriver();
		driver.get(url);
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Prashant");
		firstName.clear();
		firstName.sendKeys("Jagtap");
		System.out.println(firstName.getDomAttribute("name"));
	}

}
