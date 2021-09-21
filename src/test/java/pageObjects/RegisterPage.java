package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	static WebElement element=null;
	
	public static WebElement registerButton1(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Register"));
		return element;
	}
	public static WebElement passwordTextbox1(WebDriver driver)
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
	
	public static WebElement username(WebDriver driver)
	{
		element=driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement firstName(WebDriver driver)
	{
		element=driver.findElement(By.name("first_name"));
		return element;
	}
	
	public static WebElement lastName(WebDriver driver)
	{
		element=driver.findElement(By.name("last_name"));
		return element;
	}
	
	public static WebElement email(WebDriver driver)
	{
		element=driver.findElement(By.id("email"));
		return element;
	}
	
	public static WebElement passwordTextbox2(WebDriver driver)
	{
		element=driver.findElement(By.name("password2"));
		return element;
	}
	
	public static WebElement mobileNumber(WebDriver driver)
	{
		element=driver.findElement(By.name("mobile_number"));
		return element;
	}
	
	public static WebElement gender(WebDriver driver)
	{
		element=driver.findElement(By.name("gender"));
		return element;
	}
	
	public static WebElement registerSubmit(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/form/div/div[11]/input"));
		return element;
	}
	public static WebElement gender_female(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/form/div/div[9]/div[2]/select/option[2]"));
		return element;
	}
	public static WebElement profileImage(WebDriver driver)
	{
		element=driver.findElement(By.name("image"));
		return element;
	}
	
	public static WebElement Home_link(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[1]/a"));
		return element;
	}
	
}
