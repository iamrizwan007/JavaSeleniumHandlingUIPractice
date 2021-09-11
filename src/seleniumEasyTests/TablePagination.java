package seleniumEasyTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePagination {

	static WebDriver driver;
	static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
		
		String expectedCount = "15";
		boolean flag = false;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr[@style='display: table-row;']/td[1]"));
			for (WebElement row: rows) {
				System.out.println(row.getText());
				if (row.getText().equals(expectedCount)) {
					System.out.println("found");
					flag = true;
					break;
				}
			}
			if (driver.findElement(By.xpath("//a[@class='next_link']")).isDisplayed()) {
				driver.findElement(By.xpath("//a[@class='next_link']")).click();
			}else if (flag==false){
				System.out.println("not found");
				break;
			}
				
			
		}while(flag==false);
		
	}

}