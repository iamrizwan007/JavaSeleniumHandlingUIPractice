package singleTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableGridHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> elements= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		int expectedSum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		for (WebElement element:elements) {
			sum = sum + Integer.parseInt(element.getText());
		}
		System.out.println("Total sum is:"+ sum);
		Assert.assertEquals(sum, expectedSum);
	}
}
