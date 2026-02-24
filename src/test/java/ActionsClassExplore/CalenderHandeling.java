package ActionsClassExplore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderHandeling {
	
	WebDriver driver;
	
	@Test
	public void calenderTest() throws InterruptedException {
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
			// wait for calendar icon and click
			By calIcon = By.xpath("//img[@title='Calendar-icon']");
			wait.until(ExpectedConditions.elementToBeClickable(calIcon)).click();
			
			// small wait until calendar title visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']")));
			
			selectDate("December 2026", 6);
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
	
	public void selectDate(String expMonthYear, int date) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// read the visible month and year separately for robustness
		String month = wait.until(d -> d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
		String year = wait.until(d -> d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
		String monthYear = normalize(month + " " + year);
		System.out.println("Current monthYear: '" + monthYear + "'");
		
		// guard for infinite loops: limit number of next clicks
		int maxAttempts = 48; // increased guard (4 years)
		int attempts = 0;
		while (!normalize(expMonthYear).equalsIgnoreCase(monthYear) && attempts < maxAttempts) {
			// click next
			By nextBtn = By.xpath("//a[@data-handler='next']");
			wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
			// update month and year after DOM updates
			month = wait.until(d -> d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
			year = wait.until(d -> d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
			monthYear = normalize(month + " " + year);
			System.out.println("After click monthYear: '" + monthYear + "'");
			attempts++;
		}
		
		if (!normalize(expMonthYear).equalsIgnoreCase(monthYear)) {
			throw new RuntimeException("Desired month/year not found after " + attempts + " attempts. Last seen: " + monthYear);
		}
		
		// click the date - ensure proper XPath and visible date
		String dateXpath = String.format("//table[contains(@class,'ui-datepicker-calendar')]//a[text()='%d']", date);
		By dateLocator = By.xpath(dateXpath);
		// find visible date element and click
		for (WebElement el : driver.findElements(dateLocator)) {
			if (el.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(el)).click();
				return;
			}
		}
		throw new RuntimeException("Date element not found or not clickable: " + date);
	}
	
	private String normalize(String s) {
		if (s == null) return "";
		// replace non-breaking spaces, collapse whitespace and trim
		s = s.replace('\u00A0', ' ');
		s = s.replaceAll("\\s+", " ").trim();
		return s;
	}

}