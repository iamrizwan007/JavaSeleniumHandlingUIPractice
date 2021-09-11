package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripAssignment {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		WebElement departOn = driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/button"));
		WebElement adultDropdwn = driver.findElement(By.cssSelector(".mb-4 select"));
		WebElement creditShell = driver.findElement(By.xpath("//span[contains(@class,'checkbox__mark')]"));
		WebElement srchBtn = driver.findElement(By.xpath("//div[@class='col flex flex-middle']/button"));

		departOn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-selected='true']/div/div")).click();
		Select select = new Select(adultDropdwn);
		select.selectByValue("3");
		if (creditShell.isSelected() == false) {
			creditShell.click();
		}
		srchBtn.click();
		if (driver.findElement(By.xpath("//div[@class='col-24']//span")).isDisplayed()) {
			System.out.println(driver.findElement(By.xpath("//div[@class='col-24']//span")).getText());
		} else {
			System.out.println("error message not displayed, Failed");
		}
	}
}
