package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.cssSelector("div[id='draggable'] p"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(src, destination).build().perform();
		driver.switchTo().defaultContent();
		driver.close();
	}

}
