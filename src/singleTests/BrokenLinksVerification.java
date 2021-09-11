package singleTests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksVerification {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> allLinks = driver.findElements(By.cssSelector(".gf-li a"));
		SoftAssert softAssert = new SoftAssert();
		for (WebElement link: allLinks) {
			String url = link.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int response = connection.getResponseCode();
			System.out.println(link.getText()+":"+response);
			if (response>400) {
				System.out.println(link.getText()+":"+response);
				//Assert.assertTrue(false);
				softAssert.assertTrue(response<400, link.getText()+":failed:"+response);
				
			}
		}
		softAssert.assertAll();
		driver.close();
	}

}
