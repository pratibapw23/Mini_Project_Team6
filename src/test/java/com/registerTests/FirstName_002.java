package com.registerTests;

import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
//failed test case
//Check first name with invalid characters
//1.Enter number or symbol in name field
//2.Enter other field with valid information
//3.Click Register

public class FirstName_002 {
	
	WebDriver driver;
	String email=null;
	
  @Test
  public void FirstName() throws InterruptedException, IOException 
  {
	  String FirstNameDetails[] =ExcelUtils.getDetailsFirstNameAm();
	  
	    RegisterPage.registerButton(driver).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.username(driver).sendKeys(FirstNameDetails[0]);   //amruta789
		RegisterPage.firstName(driver).sendKeys(FirstNameDetails[1]);
		RegisterPage.lastName(driver).sendKeys(FirstNameDetails[2]);
		RegisterPage.email(driver).sendKeys(FirstNameDetails[3]);
		RegisterPage.passwordTextbox(driver).sendKeys(FirstNameDetails[4]);
		RegisterPage.confirmPassTextbox(driver).sendKeys(FirstNameDetails[5]);
		RegisterPage.mobileNoTextbox(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
		WindowScroll.scrollWindow(driver);
		
		 RegisterPage.registerButton2(driver).click();
		 
		 LoginPage.usernameTextBox(driver).sendKeys(FirstNameDetails[0]);
		 LoginPage.passwordTextBox(driver).sendKeys(FirstNameDetails[4]);
		 LoginPage.SignInButton(driver).submit();
		 
		email=FirstNameDetails[3];
			DeleteUser.deleteUser(email, driver);
		
	
		
  }
  @BeforeMethod
  public void beforeMethod() throws Exception 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() 
  
  {
		driver.quit();
  }

}
