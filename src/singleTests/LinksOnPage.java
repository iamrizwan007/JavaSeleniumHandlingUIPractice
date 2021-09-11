package singleTests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksOnPage {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int allLinks = driver.findElements(By.tagName("a")).size();

		// all links present in the footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		int footerLinks = footer.findElements(By.tagName("a")).size();

		// all links present in Discount Coupon section
		WebElement discountFooter = driver.findElement(By.xpath("//table[@class='gf-t']//td[1]"));
		List<WebElement> discountFtr = discountFooter.findElements(By.tagName("a"));
		int dsctLinks = discountFooter.findElements(By.tagName("a")).size();

		System.out.println("All Links: " + allLinks);
		System.out.println("Footer Links: " + footerLinks);
		System.out.println("Discount Coupon Links: " + dsctLinks);

		String clickOnNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (WebElement a : discountFtr) {
			a.sendKeys(clickOnNewTab);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();

		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}
}