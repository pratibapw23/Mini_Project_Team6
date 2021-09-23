package com.LogOutTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import Utils.WebDriverProperties;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;


//Verify After successfully login account click on profile icon to check logout button is visible or not.

public class TC_Verify_Logout_Button{
	
ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
  @Test
  public void Check_logoutVisible() throws IOException, InterruptedException 
  {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(driver).submit();
		 
		 DashboardPage.profileLink(driver).click();
		
		
		WebElement e=ProfilePage.logout_Button(driver);
		boolean visible=e.isDisplayed();
		if(visible)
		{
			System.out.println("logout button is working");
		}
		else
		{
			System.out.println("logout button is not working");
		}
		
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
