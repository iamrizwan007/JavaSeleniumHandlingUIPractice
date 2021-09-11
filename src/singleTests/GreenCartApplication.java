package singleTests;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCartApplication {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static String[] expectedName = { "Brocolli", "Cauliflower", "Cucumber" };

	public static void addItems(WebDriver driver, String[] expectedName) {
		int count = 0;
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='product']"));
		List<String> al = Arrays.asList(expectedName);

		for (WebElement item : items) {
			String name = item.findElement(By.xpath(".//h4")).getText().split(" ")[0];
			if (al.contains(name)) {
				count++;
				item.findElement(By.xpath(".//div[@class='product-action']/button")).click();
				if (count == expectedName.length)
					break;
			}
		}
	}

	public static void openCart(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}

	public static void placeOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.tagName("button")).click();
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // driver.implicitly_Wait(time) --> with python
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		addItems(driver, expectedName);
		openCart(driver);
		placeOrder(driver);
		
		String ariaLabelValue = driver.findElement(By.cssSelector("div[aria-label='Item-Count-0']")).getAttribute("aria-label");
		
	}
}
