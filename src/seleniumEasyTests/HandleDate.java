package seleniumEasyTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDate {
	private static WebDriver driver;
	private static String path = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public void yearMonthSame(int expectedDate) {
		System.out.println("no need to change the month as actual=expected");
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']"));
		for (WebElement date : dates) {
			if (date.getText().equals(Integer.toString(expectedDate))) {
				date.click();
				break;
			}
		}
	}

	public void yearSameMonthDiff(int expectedDate, String expectedMonth) {
		List<WebElement> months = driver.findElements(By.xpath("//span[@class='month']"));
		for (WebElement month : months) {
			if (month.getText().equalsIgnoreCase(expectedMonth.substring(0, 3))) {
				month.click();
				List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']"));
				for (WebElement date : dates) {
					if (date.getText().equals(Integer.toString(expectedDate))) {
						date.click();
						break;
					}
				}
				break;
			}
		}
	}

	public void yearLessThanExpected(int expectedYear) {
		boolean flag = false;
		while (flag == false) {
			System.out.println("inside while");
			WebElement previous = driver.findElement(By.xpath("(//th[@class='prev'])[3]"));
			List<WebElement> yearGrid = driver.findElements(By.cssSelector(".year"));
			for (WebElement element:yearGrid) {
				if (element.getText().equals(Integer.toString(expectedYear))){
					System.out.println("found, clicking on it and setting flag true and breaking for each loop");
					element.click();
					flag = true;
					break;
				}		
			}
			if(flag==false) {
				previous.click();
				System.out.println("clicked");
			}
		}
	}
	
	public void yearGreaterThanExpected(int expectedYear) {
		boolean flag = false;
		while (flag == false) {
			System.out.println("inside while");
			WebElement next = driver.findElement(By.xpath("(//th[@class='next'])[1]"));
			List<WebElement> yearGrid = driver.findElements(By.cssSelector(".year"));
			for (WebElement element:yearGrid) {
				if (element.getText().equals(Integer.toString(expectedYear))){
					System.out.println("found, clicking on it and setting flag true and breaking for each loop");
					element.click();
					flag = true;
					break;
				}		
			}
			if(flag==false) {
				System.out.println("before clicking");
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", next);
				//next.click();
				System.out.println("clicked");
			}
		}		
	}

	public void selectStartDate(int expectedDate, String expectedMonth, int expectedYear) {
		driver.findElement(By.xpath("//input[@placeholder='Start date']")).click();
		WebElement dateSwitcher = driver.findElement(By.cssSelector(".datepicker-switch"));
		String currentView = dateSwitcher.getText();
		String currentMonth = currentView.split(" ")[0];
		String currentYear = currentView.split(" ")[1];

		if (Integer.parseInt(currentYear) == expectedYear) {
			System.out.println("no need to change the year as actual=expected");
			if (currentMonth.equalsIgnoreCase(expectedMonth)) {
				yearMonthSame(expectedDate);
			} else {
				dateSwitcher.click();
				yearSameMonthDiff(expectedDate, expectedMonth);
			}

		} else if (expectedYear < Integer.parseInt(currentYear)) {
			dateSwitcher.click();
			driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).click();
			yearLessThanExpected(expectedYear);
			yearSameMonthDiff(expectedDate, expectedMonth);
		} else if (expectedYear > Integer.parseInt(currentYear)) {
			dateSwitcher.click();
			driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).click();
			yearGreaterThanExpected(expectedYear);
			yearSameMonthDiff(expectedDate, expectedMonth);
		}

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HandleDate dateObj = new HandleDate();
		dateObj.selectStartDate(7, "January", 2090);
	}
}
