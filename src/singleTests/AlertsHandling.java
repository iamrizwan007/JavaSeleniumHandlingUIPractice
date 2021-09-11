package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#name")).sendKeys("Rizwan1");
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("Rizwan0")) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
			System.out.println("dismissed");
		}
	}
}
