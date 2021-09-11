package seleniumEasyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RangeSliders {
	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	static String url = "https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		WebElement source = driver.findElement(By.xpath("//div[@id='slider1']//input"));
		
		// With Keyboard arrow keys
		/*
		source.click();
		while (!driver.findElement(By.xpath("//div[@id='slider1']//output")).getText().equals("70")) {
			source.sendKeys(Keys.ARROW_RIGHT);
		}
		*/
		// With Action class
		int width = source.getSize().getWidth();
		Actions action = new Actions(driver);
		int target = 30;
		action.moveToElement(source, (((width*target)/100)-((width*52)/100)), 0).click().build().perform();
		
		System.out.println("moved");
		Thread.sleep(5000);
		driver.close();
	}
}
