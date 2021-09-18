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
	
	public static WebElement eyeButton(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/span[1]/i"));
		return element;
	}
	public static WebElement getActualMobileNumber(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[5]/div[2]"));
		return element;
	}
	public static WebElement updateProfileButton(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[1]/button"));
		return element;
	}
	public static WebElement backBtn_updateProfileButton(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
	public static WebElement updateProfilePicture(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[2]/button"));
		return element;
	}
	public static WebElement backBtn_updatePictureButton(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/button"));
		return element;
	}
	public static WebElement backBtn_changePasswordButton(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li/a"));
		return element;
	}
	public static WebElement logout_Button(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a"));
		return element;
	}
	public static WebElement changePass_Button(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[3]/button"));
		return element;
	}
	
	public static WebElement getActualGender(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[4]/div[2]"));
		return element;
	}
	
	public static WebElement Update_Profilepic(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary'][text()='Update Picture']"));
		return element;
	}
	
	public static WebElement Update_Profilepic_choosefile(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//INPUT[@id='id_image']"));
		return element;
	}
	
	public static WebElement Update_Profilepic_UpdatePicture(WebDriver driver) throws IOException
	{
		element=driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='Update Picture']"));
		return element;
	}



	public static WebElement getActualEmail(WebDriver driver) {
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[2]/div[2]"));
		return element;
	}


}
