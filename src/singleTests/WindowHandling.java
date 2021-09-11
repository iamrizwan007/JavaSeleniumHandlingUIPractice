package singleTests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		System.out.println("Parent Window:"+driver.getWindowHandle());
		driver.findElement(By.cssSelector(".blinkingText")).click();
		System.out.println("Child Window:"+driver.getWindowHandle());
		Set<String> windows = driver.getWindowHandles();	//driver.window_handles python, driver.switch_to.window()
		Iterator<String> itr = windows.iterator();
		String parentID = itr.next();
		String childID = itr.next();
		driver.switchTo().window(childID);	
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
