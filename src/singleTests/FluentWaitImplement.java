package singleTests;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitImplement {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.tagName("button")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement msg = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					System.out.println("returning the WebElement");
					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				} else {
					System.out.println("returning null");
					return null;
				}

			}

		});
		System.out.println(msg.getText());

	}

}