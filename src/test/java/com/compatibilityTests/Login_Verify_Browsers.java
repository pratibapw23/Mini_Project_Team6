package com.compatibilityTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Login_Verify_Browsers {
	WebDriver chrome_driver,Edge_driver;
	String s1,s2,s3;
  @Test
  public void MicrosoftEdge() throws Exception {
	  
		 LoginPage.loginButton(Edge_driver).click();
		 LoginPage.loginButton(Edge_driver).click();
		 LoginPage.usernameTextBox(Edge_driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(Edge_driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(Edge_driver).submit();
		 System.out.println("Login in MicrosoftEdge");
		 s2=DashboardPage.getTextUserName(Edge_driver).getText();
  }
  @Test
  public void ChromeBrowser() throws Exception {
	

	  chrome_driver.manage().window().maximize();
	  LoginPage.loginButton(chrome_driver).click();
	  LoginPage.usernameTextBox(chrome_driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(chrome_driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(chrome_driver).submit();
	  System.out.println("Login in Chrome Browser");
	  s1= s2=DashboardPage.getTextUserName(chrome_driver).getText();
	  DashboardPage.logoutButton(chrome_driver).click();
	  s3=chrome_driver.findElement(By.xpath("/html/body/div[1]/div/div/form/span")).getText();	 
	  Assert.assertEquals(s3,"Welcome");
	  System.out.println("Logout Successful In Chrome Browser");
	  LoginPage.usernameTextBox(chrome_driver).sendKeys(ExcelUtils.getUsernameU());
	  LoginPage.passwordTextBox(chrome_driver).sendKeys(ExcelUtils.getPasswordU());
	  LoginPage.SignInButton(chrome_driver).submit();
	  System.out.println("Login in Chrome Browser with different Account");
	  
  }
  
  @BeforeTest
  public void beforeTest() throws IOException {

	  chrome_driver=WebDriverProperties.setChromeDriverProperties();
	  Edge_driver=WebDriverProperties.setEdgeDriverProperties();
	 
  }

  @AfterTest
  public void afterTest() {
	  DashboardPage.logoutButton(Edge_driver).click();
	  DashboardPage.logoutButton(chrome_driver).click();
	  System.out.println("Logout from all browser");
	  Assert.assertEquals(s1, s2);
	  System.out.println("TC Passed : Login Sucessful in both browser");
	  chrome_driver.close();
	  Edge_driver.close();
  }

 

}
