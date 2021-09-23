package com.loginTests;
import Utils.*;
import org.testng.annotations.Test;
import pageObjects.*;
import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_Verify_Password_HiddenFormat{
	
	WebDriver driver;
	ExcelUtils obj=new ExcelUtils();
  @Test
  public void Password_Hidden_Format() throws InterruptedException, IOException {
	
	     LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		
	    String s = LoginPage.passwordTextBox(driver).getAttribute("type"); 
		Assert.assertEquals("password",s);
		System.out.println("Test Case Pass :Password is in hidden format in the field");
		
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  
	  driver.close();
  }

}
