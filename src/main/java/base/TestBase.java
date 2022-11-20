package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		if (driver != null) {
			return;
		}
		String DRIVERS_DIR = System.getProperty("user.dir") + File.separator + "src" +  File.separator + "drivers";
		System.setProperty("webdriver.chrome.driver",
				DRIVERS_DIR + File.separator + "chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	public static void stopDriver() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
			driver = null;
		}
	}
	public static void waitPageLoad() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	}
}
