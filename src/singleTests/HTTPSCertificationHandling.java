package singleTests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPSCertificationHandling {

	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromepath);

		// Setting up the DesiredCapability to accept insecure certification (can add
		// multiple capability)
		// General chrome browser settings
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.acceptInsecureCerts();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		// Handling SSL -> pass desired capability to your ChromeOption
		// Local chrome browser settings
		ChromeOptions option = new ChromeOptions();
		option.merge(capability);

		// Giving this option with a capability to handle SSL certification to your
		// driver
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	}

}
