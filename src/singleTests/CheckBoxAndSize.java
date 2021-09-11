package singleTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxAndSize {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		WebElement seniorCitizen = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		seniorCitizen.click();
		System.out.println(seniorCitizen.isSelected());
		Assert.assertTrue(seniorCitizen.isSelected()); //if false, assertion pass else fail.
		
		//Number of checkboxes in this page
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input"));
		System.out.println(checkboxes.size());
		Assert.assertEquals(checkboxes.size(), 6);
	}

}
