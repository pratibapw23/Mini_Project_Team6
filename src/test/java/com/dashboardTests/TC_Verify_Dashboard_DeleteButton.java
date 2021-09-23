package com.dashboardTests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

@SuppressWarnings("unused")
public class TC_Verify_Dashboard_DeleteButton{
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_DeleteFile() throws IOException, InterruptedException {
	     LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(driver).submit();
		 
		 DashboardPage.deleteButton(driver).click();
		 
		 driver.get("http://test-monk.in/dashboard");
		 driver.navigate().refresh();
		 
		 
		 String ActualValue=DashboardPage.getActualFilename(driver).getText();
		 Assert.assertNotSame(ActualValue,"NAME=FRIENDS2.JPG");

		 System.out.println("File Deletion Verified ");
		
	  
  }      
	  
 
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
