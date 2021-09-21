package com.compatibilityTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;



//Test the functionalities of field login and register.
public class HomePage_01 {
	WebDriver driver;
	
  @Test
  public void VerifyLogin_register() throws IOException, InterruptedException
  {
	  
	    HomePage.loginButton(driver).click();   //login button
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils_Registration.username_am());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils_Registration.getRegPassword_am());
		 LoginPage.SignInButton(driver).submit();
		 
		
		 DashboardPage.Logout1(driver).click();    //Dashboard->logout
		
		 LoginPage.Home_link_login(driver).click();    //Login->Home
		 HomePage.registerButton(driver).click();
		
		 RegisterPage.Home_link(driver).click();     //registerPage->Home
		
		 
  }
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }
  

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
