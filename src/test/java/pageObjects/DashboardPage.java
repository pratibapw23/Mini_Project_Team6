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
	public static WebElement deleteButton(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Delete"));
		return element;
	}
	
	public static WebElement downloadButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/a[1]"));
		return element;
	}
	public static WebElement backButton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/button"));
		return element;
	}
	public static WebElement profileLink(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
	
	public static WebElement Searchbar(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//INPUT[@type='text']"));
		return element;
	}
	public static WebElement getActualFilename(WebDriver driver) {
		element=driver.findElement(By.xpath("//DIV[@class='cards_wrap']"));
		return element;
	}
	public static WebElement logoutButton(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[3]/a"));
		return element;
	}
	
	public static WebElement getTextUserName(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div[1]"));
		return element;
	}
}
