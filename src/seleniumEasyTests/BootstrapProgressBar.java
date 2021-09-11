package seleniumEasyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapProgressBar {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static String url = "https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		String initalProgress = driver.findElement(By.className("percenttext")).getText();
		driver.findElement(By.id("cricle-btn")).click();
		do {
			String currentProgress = driver.findElement(By.className("percenttext")).getText();
			if (initalProgress.equals(currentProgress)==false)
				System.out.println(driver.findElement(By.className("percenttext")).getText());
			initalProgress = currentProgress;
		}
		while (!driver.findElement(By.className("percenttext")).getText().equals("100%"));
		System.out.println("completed "+driver.findElement(By.className("percenttext")).getText());
		driver.close();
	}
}
