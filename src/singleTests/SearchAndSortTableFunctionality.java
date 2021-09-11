package singleTests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchAndSortTableFunctionality {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String item = "ea";
		driver.findElement(By.id("search-field")).sendKeys(item);
		List<WebElement> items = driver.findElements(By.xpath("//td[1]"));
		
		List<String> filteredItems = items.stream().filter(e->e.getText().contains(item)).map(e->e.getText()).collect(Collectors.toList());
		
		Assert.assertTrue(items.size() == filteredItems.size());
	}

}
