package seleniumEasyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarDownload {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static String url = "https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("downloadButton")).click();
		WebElement progress = driver.findElement(By.className("progress-label"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(progress, "Complete!"));
		System.out.println(ExpectedConditions.textToBePresentInElement(progress, "Complete!"));
		System.out.println(progress.getText());
	}
}
