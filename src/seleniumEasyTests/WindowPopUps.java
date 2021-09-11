package seleniumEasyTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUps {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static String url = "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.partialLinkText("Twitter")).click();
		Set<String> winHandles= driver.getWindowHandles();
		Iterator<String> window = winHandles.iterator();
		while(window.hasNext()) {
			String currentWin = window.next();
			String winTitle = driver.switchTo().window(currentWin).getTitle();
			System.out.println(winTitle);
			if (winTitle.contains("Twitter")) {
				driver.findElement(By.name("session[username_or_email]")).sendKeys("iamriz007");
				driver.findElement(By.xpath("//input[@name='session[password]']")).sendKeys("password");
				Thread.sleep(2);
				driver.close();
			}
		}
		
	}
}
