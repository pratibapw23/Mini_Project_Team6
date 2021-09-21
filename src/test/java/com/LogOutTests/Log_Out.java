
package com.LogOutTests;
import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
public class Log_Out {
	WebDriver driver;
  @Test
  public void Log_Out_Successfully() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
		 ProfilePage.logoutButton(driver).click();


	 
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Login to iDrive";
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("TC Passed : LogOut Successfully");
	  
	  
	  Thread.sleep(2000);
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
