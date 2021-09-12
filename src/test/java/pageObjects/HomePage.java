package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
WebDriver driver;
	
	static WebElement element=null;
	public static WebElement sideImage(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/img"));
		return element;
	}
	public static WebElement logo(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"header\"]/nav/img"));
		return element;
	}
	
}
