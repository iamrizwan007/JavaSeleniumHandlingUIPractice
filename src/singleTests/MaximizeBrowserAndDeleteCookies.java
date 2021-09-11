package singleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeBrowserAndDeleteCookies {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

	}

}
