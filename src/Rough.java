import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\JavaWorkspace\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		Thread.sleep(7000);
		driver.findElement(By.name("email")).sendKeys("iamrizzz007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("iamrizwan007R");
		driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("main-nav"))).perform();
		driver.findElement(By.xpath("//a[contains(@href,'contacts')]/following-sibling::button")).click();
		driver.findElement(By.name("first_name")).sendKeys("firstname1");
		action.moveToElement(driver.findElement(By.name("last_name"))).perform();
		driver.findElement(By.name("last_name")).sendKeys("lastname");

	}

}
