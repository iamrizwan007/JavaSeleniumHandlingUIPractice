package singleTests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		do {
			List<WebElement> vegNames = driver.findElements(By.xpath("//td[1]"));
			price = vegNames.stream().filter(s -> s.getText().contains(" e")).map(s -> getPrice(s))
					.collect(Collectors.toList());
			price.forEach(p -> System.out.println(p));
			if (price.size() < 1) {
				if (driver.findElement(By.cssSelector("[aria-label='Next']")).getAttribute("aria-disabled")=="false") {
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}else {
					System.out.println("cannot find the item in the list");
					break;
				}
			}
		} while (price.size() < 1);

		driver.close();

	}

}
