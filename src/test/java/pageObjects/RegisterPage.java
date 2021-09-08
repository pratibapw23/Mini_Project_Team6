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
<<<<<<< HEAD
	public static WebElement emailTextbox(WebDriver driver)
	{
		element=driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement usernameTextbox(WebDriver driver)
=======
	
	public static WebElement username(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.name("username"));
		return element;
	}
<<<<<<< HEAD
	public static WebElement firstNameTextbox(WebDriver driver)
=======
	
	public static WebElement firstName(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.name("first_name"));
		return element;
	}
<<<<<<< HEAD
	public static WebElement lastNameTextbox(WebDriver driver)
=======
	
	public static WebElement lastName(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.name("last_name"));
		return element;
	}
<<<<<<< HEAD
	public static WebElement confirmPassTextbox(WebDriver driver)
=======
	
	public static WebElement email(WebDriver driver)
	{
		element=driver.findElement(By.id("email"));
		return element;
	}
	
	public static WebElement passwordTextbox2(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.name("password2"));
		return element;
	}
<<<<<<< HEAD
	public static WebElement mobileNoTextbox(WebDriver driver)
=======
	
	public static WebElement mobileNumber(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.name("mobile_number"));
		return element;
	}
<<<<<<< HEAD
	public static WebElement registerButton2(WebDriver driver)
=======
	
	public static WebElement gender(WebDriver driver)
	{
		element=driver.findElement(By.name("gender"));
		return element;
	}
	
	public static WebElement registerSubmit(WebDriver driver)
>>>>>>> refs/remotes/origin/master
	{
		element=driver.findElement(By.xpath("/html/body/form/div/div[11]/input"));
		return element;
	}
<<<<<<< HEAD
	

=======
>>>>>>> refs/remotes/origin/master
}
