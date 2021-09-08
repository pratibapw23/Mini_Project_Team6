package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverProperties {
	static WebDriver driver;
	
	public static WebDriver setChromeDriverProperties() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		 FileReader reader=new FileReader("Info.properties");
		 Properties prop=new Properties();
		 prop.load(reader); 
		 String url=prop.getProperty("url");
		 driver.get(url);
		 driver.manage().window().maximize();
		return driver;
	}
	public static void closeDriver()
	{
		driver.quit();
	}
	
	

}
