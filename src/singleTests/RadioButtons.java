package singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static WebDriver driver;
	
	static boolean checkEnabled() {
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1")) {
			System.out.println("single way selected, date is enabled");
			return true;
		}else {
			System.out.println("single way selected, date is disabled");
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		WebElement singleWay = driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0"));
		WebElement twoWay = driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1"));
		WebElement returnDate = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2"));
		WebElement returnDtEnabled = driver.findElement(By.xpath("//div[@id='Div1']"));
		
		System.out.println(singleWay.isSelected());
		System.out.println(returnDate.isEnabled());	//not working with this UI
		System.out.println(RadioButtons.checkEnabled());
		twoWay.click();
		System.out.println(RadioButtons.checkEnabled());
	}

}
