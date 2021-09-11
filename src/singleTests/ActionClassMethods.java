package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMethods {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement actList = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
		Actions action = new Actions(driver);
		WebElement srchBox = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(srchBox).click().keyDown(Keys.SHIFT).sendKeys("bose speakers")
		.keyUp(Keys.SHIFT).sendKeys(" test").perform();
		action.contextClick(srchBox).build().perform();
		// action.moveToElement(actList).contextClick().perform();

	}

}
