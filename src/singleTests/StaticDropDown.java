package singleTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class StaticDropDown {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		select.selectByValue("INR");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		select.selectByVisibleText("USD");
		System.out.println(select.getFirstSelectedOption().getText());
	}

}
  