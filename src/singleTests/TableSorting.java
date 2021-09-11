package singleTests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TableSorting {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		Select select = new Select(driver.findElement(By.xpath("//select")));
//		select.selectByValue("20");

		List<WebElement> vegNames = driver.findElements(By.xpath("//td[1]"));
		List<String> vegSortedByStream = vegNames.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());

		driver.findElement(By.cssSelector("th[aria-label*='Veg']")).click();

		List<WebElement> vegNamesSorted = driver.findElements(By.xpath("//td[1]"));
		List<String> vegNameSortedByClick = vegNamesSorted.stream().map(s -> s.getText()).collect(Collectors.toList());

		System.out.println(vegNameSortedByClick);
		System.out.println(vegSortedByStream);
		//Assert.assertTrue(vegSortedByStream.equals(vegNameSortedByClick));

		// Get price of Beans
		List<String> priceOfBeans = vegNamesSorted.stream()filter(s -> s.getText().contains("Almond")).map(s -> getPrice(s))
				.collect(Collectors.toList());

		priceOfBeans.forEach(s->System.out.println(s));
	}

	public static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

}
