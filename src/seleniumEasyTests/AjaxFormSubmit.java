package seleniumEasyTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AjaxFormSubmit {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
		driver.findElement(By.id("title")).sendKeys("test");
		driver.findElement(By.id("description")).sendKeys("testdescription");
		driver.findElement(By.name("btn-submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Form submited Successfully!']")));
		System.out.println(driver.findElement(By.xpath("//div[text()='Form submited Successfully!']")).getText());
		driver.close();
	}

}
