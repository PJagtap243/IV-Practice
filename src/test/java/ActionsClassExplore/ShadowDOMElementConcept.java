package ActionsClassExplore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOMElementConcept {
		
	WebDriver driver;
	
	@Test
	public void shadowDOMElementConcept() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(1500);
		
		// Return the iframe element from the shadow root and cast it as a WebElement
		String script = "return document.querySelector('#userName').shadowRoot.querySelector('#pact1')";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement frameElement = (WebElement) js.executeScript(script);
		driver.switchTo().frame(frameElement);
		Thread.sleep(1500);
		driver.findElement(By.id("jex")).sendKeys("Text");
		
		//label[normalize-space()='Can you enter name here through automation']//*[name()='svg']
	}
	
	@Test
	public void enterTextInDisabledField() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(1500);
		
		WebElement disabledInput = driver.findElement(By.xpath("//input[@placeholder = 'Enter Last name']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Jagtap';", disabledInput);

		
	}

}