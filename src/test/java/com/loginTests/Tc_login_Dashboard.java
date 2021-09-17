package com.loginTests;

import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Tc_login_Dashboard {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void LoginUser() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername1());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword1());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Dashboard";
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("TC Passed : Login Successfully , DashBoard Opened");
	  
	  Thread.sleep(3000);
	  
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
