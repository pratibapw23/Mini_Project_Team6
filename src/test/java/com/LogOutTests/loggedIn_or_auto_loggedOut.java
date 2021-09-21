package com.LogOutTests;

import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.AfterMethod;

public class loggedIn_or_auto_loggedOut {
	WebDriver driver;
	
  @Test
  public void LogIn() throws IOException, InterruptedException, AWTException {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  
	  LoginPage.SignInButton(driver).submit();
	  String url=driver.getCurrentUrl();
	  System.out.println("Logged In successfully..");
	  WebElement body = driver.findElement(By.tagName("body"));
	  body.sendKeys(Keys.CONTROL + "t");
	
	  Thread.sleep(3000);
	  
	  driver.get("http://test-monk.in/dashboard");
	  Thread.sleep(3000);
	  System.out.println("Loggedin in tab..");
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
