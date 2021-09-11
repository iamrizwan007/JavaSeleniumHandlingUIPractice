package singleTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class GetText {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=eu");
		driver.findElement(By.id("username")).sendKeys("mrizwan4");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println(driver.findElement(By.id("error")).getText());
	}
}