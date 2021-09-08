package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	static WebElement element=null;
	
	public static WebElement registerButton(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Register"));
		return element;
	}
	public static WebElement passwordTextbox(WebDriver driver)
	{
		element=driver.findElement(By.id("psw"));
		return element;
	}
	public static WebElement emailTextbox(WebDriver driver)
	{
		element=driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement usernameTextbox(WebDriver driver)
	{
		element=driver.findElement(By.name("username"));
		return element;
	}
	public static WebElement firstNameTextbox(WebDriver driver)
	{
		element=driver.findElement(By.name("first_name"));
		return element;
	}
	public static WebElement lastNameTextbox(WebDriver driver)
	{
		element=driver.findElement(By.name("last_name"));
		return element;
	}
	public static WebElement confirmPassTextbox(WebDriver driver)
	{
		element=driver.findElement(By.name("password2"));
		return element;
	}
	public static WebElement mobileNoTextbox(WebDriver driver)
	{
		element=driver.findElement(By.name("mobile_number"));
		return element;
	}
	public static WebElement registerButton2(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/form/div/div[11]/input"));
		return element;
	}
	

}
