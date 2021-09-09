package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	static WebElement element;
	
	public static WebElement profileButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
	
	public static WebElement changePasswordButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[3]/button"));
		return element;
	}
	public static WebElement changePasswordTextbox(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[1]/input"));
		return element;
	}
	
	public static WebElement changePasswordFinal(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/div/button"));
		return element;
	}
	
	public static WebElement logoutButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[3]/a"));
		return element;
	}

}
