package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtils {
	public static WebDriver driver;
	
	public SeleniumUtils(WebDriver driver){
		SeleniumUtils.driver = driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void goToUrl(String url)
	{
		driver.get(url);
	}
	
	
	public void init() {
		// Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
				
		//	Creating object of chrome driver
		WebDriver driver = new ChromeDriver();
						
		//	Open maximum window size
		driver.manage().window().maximize();
	}
	
}
