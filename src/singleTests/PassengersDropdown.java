package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassengersDropdown {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		WebElement adultAdd = driver.findElement(By.id("hrefIncAdt"));
		int t = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
		while (t <= 5) {
			adultAdd.click();
			t = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
			System.out.println(t);
		}
	}
}
