package ActionsClassExplore;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkConcept {
	
	WebDriver driver;
	
	@Test
	public void getBrokenLinks() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		
		List<String> urlList = new ArrayList<String>();
		
		for(WebElement e : alltags) {
			String url = e.getAttribute("href");
			//urlList.add(url);
			findBrokenList(url);
		}
		
		
	}
	
	public void findBrokenList(String url) {
		
		try {
			URL ul = new URL(url);
			HttpURLConnection httpConnection =  (HttpURLConnection)ul.openConnection();
			httpConnection.connect();
			
			if(httpConnection.getResponseCode() >=400) {
				System.out.println(ul +" --> is broken link" );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
