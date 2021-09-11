package singleTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();

		// Month and year logic
		driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']")).getText()
				.contains("January 2022");
		while (!driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']"))
				.getText().contains("January 2022")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}

		// Date logic
		List<WebElement> days = driver.findElements(By.xpath("//td[@class='day']"));
		for (WebElement day : days) {
			if (day.getText().equalsIgnoreCase("25")) {
				day.click();
				break;
			}
		}

	}

}
