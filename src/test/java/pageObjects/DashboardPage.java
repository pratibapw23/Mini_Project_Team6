package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
WebDriver driver;
	
	static WebElement element=null;
	
	public static WebElement uploadFileLink(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Upload File"));//click
		return element;
	}
	public static WebElement fileName(WebDriver driver)
	{
		element=driver.findElement(By.name("filename"));//sendkey=filename
		return element;
	}
	public static WebElement fileDescription(WebDriver driver)
	{
		element=driver.findElement(By.name("description"));//send keys=file desc
		return element;
	}
	public static WebElement chooseFile(WebDriver driver)
	{
		element=driver.findElement(By.name("files"));//click
		return element;
	}
	public static WebElement UploadFileButton(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Upload File"));
		return element;
	}

}
