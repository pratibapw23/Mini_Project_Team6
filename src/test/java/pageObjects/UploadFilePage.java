package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadFilePage {
	static WebElement element=null;
	public static WebElement uploadButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("/html/body/form/div[4]/button"));
		return element;
	}
	public static WebElement getForm(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/form"));
		return element;
	}
	
}
