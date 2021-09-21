package com.loginTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import Utils.WebDriverProperties;
//import pageObjects.LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//check home button access working or not

public class Login_003 {
	WebDriver driver;
  @Test
  public void HomeButton_working() throws IOException, InterruptedException 
  {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(driver).submit();
		 
		DashboardPage.logoutButton(driver).click(); 
		
		
		 
		// driver.findElement(By.linkText("Home")).click();
		 WebElement e=LoginPage.Home_link_login(driver);  
		 boolean display=e.isDisplayed();
		 if(display)
		 {
			 System.out.println("Home button is working");
		 }
		 else
		 {
			 System.out.println("Home button is not working");
		 }
		 Thread.sleep(1000);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
	  driver.quit();
  }

}
