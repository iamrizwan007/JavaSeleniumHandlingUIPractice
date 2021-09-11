import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstRun {

	public static void main(String[] args) throws InterruptedException {
		// invoke the chromedriver file, before add one more step
		// for each browser, propery is defined, in this property need to provide the driver location.
		// webdriver.chrome.driver
		// webdriver.gecko.driver
		// webdriver.ie.driver
		
		System.setProperty("webdriver.chrome.driver","D:\\JavaWorkspace\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();	//driver.maximize_window() - python
		System.out.println(driver.getTitle()); 	//driver.title - python
		driver.findElement(By.name("q")).sendKeys("Mohammad Rizwan Metlife LinkedIn");	//driver.find_element(By.NAME,"name").send_keys("hello")
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();	//driver.find_element_by_name("name").click()	
	}
}
