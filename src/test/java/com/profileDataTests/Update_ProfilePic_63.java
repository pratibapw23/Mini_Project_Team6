package com.profileDataTests;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import Utils.ExcelUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class Update_ProfilePic_63 {
	WebDriver driver;
	String Path;
	File file;
  
  @Test//(groups= {"Login"})
  public void Vrfy_ProfilePic() throws IOException, InterruptedException {
	  
	   
	  	 LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
		 
		 ProfilePage.profileButton(driver).click();
		 ProfilePage.Update_Profilepic(driver).click();
	  
		 WebElement element = driver.findElement(By.name("image"));
		 element.sendKeys(file.getAbsolutePath());
	  
	  
		 System.out.println("Image collected from path");
  
	  ProfilePage.Update_Profilepic_UpdatePicture(driver).click();
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Profile Page";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
  
      System.out.println("Test Case Passed : Profile Picture Updated");
      
	  
	  Thread.sleep(1000);
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @BeforeMethod
	public void beforeMethod() throws IOException
	{

		FileReader reader = new FileReader("Info.properties");
		Properties prop = new Properties();
		prop.load(reader);

		Path = prop.getProperty("pupload");
		
		file = new File(Path);
	}
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
