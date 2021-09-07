package pageObjects;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
	
	static WebElement element=null;
	public static WebElement loginButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
	public static WebElement usernameTextBox(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.name("username"));
		return element;
	}
	public static WebElement passwordTextBox(WebDriver driver)
	{
		element=driver.findElement(By.name("password"));
		return element;
	}
	public static WebElement SignInButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button"));
		return element;
	}
	public static WebElement findFullName(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/div[1]"));
		return element;
	}
	public static WebElement profileLink(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Profile"));
		return element;
	}
	public static WebElement fullNameInProfile(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[1]/div[2]"));
		return element;
	}

}
