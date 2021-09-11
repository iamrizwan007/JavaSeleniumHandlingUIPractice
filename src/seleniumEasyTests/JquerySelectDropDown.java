package seleniumEasyTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JquerySelectDropDown {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");

//		Select select = new Select(driver.findElement(By.id("country")));
//		select.selectByVisibleText("Australia");
		
		driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']")).click();
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[2]")).sendKeys(Keys.SHIFT+"i");
		List<WebElement> options = driver.findElements(By.cssSelector("#select2-country-results li"));
		for (WebElement option:options) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
				
		}
		Select select = new Select(driver.findElement(By.name("files")));
		
		String element = select.getWrappedElement().getText();

//		for (WebElement option:select.getOptions()) {
//			System.out.println(option.getText());
//		}
//		driver.close();
		
	}

}
