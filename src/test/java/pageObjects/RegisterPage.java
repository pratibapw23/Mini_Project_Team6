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

}
