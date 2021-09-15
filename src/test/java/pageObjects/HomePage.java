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
	public static WebElement loginButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[2]/a[1]s"));
		return element;
	}
	public static WebElement registerButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[2]/a[2]"));
		return element;
	}
	public static WebElement contactUsButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[4]/a"));
		return element;
	}
	
	public static WebElement loginOnRegisterPage(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
}
