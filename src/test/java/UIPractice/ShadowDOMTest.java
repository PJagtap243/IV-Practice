package UIPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOMTest {
	
	@Test
	public void getShadowDOMElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/shadowdom");
		
		String script = "return document.querySelector(\"#content > my-paragraph:nth-child(4) > span\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement textField = (WebElement) js.executeScript(script);
		String message = textField.getText();
		System.out.println(message);
		driver.quit();
	}

}
