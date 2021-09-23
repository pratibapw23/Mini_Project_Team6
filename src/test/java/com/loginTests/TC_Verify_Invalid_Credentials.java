package com.loginTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;


import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_Verify_Invalid_Credentials{
ExcelUtils obj=new ExcelUtils();
	
WebDriver driver;
  @Test
  public void Verify_Alert_Message_Prompted_Invalid_Crendentials() throws IOException {
		 LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getInvalidUserName());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getInvalidPassword());
		 LoginPage.SignInButton(driver).submit();
		
		Alert alert = driver.switchTo().alert();
		String ActualTitle=alert.getText();
		String ExpectedTitle = "Enter the correct Email and Password";
		Assert.assertEquals(ExpectedTitle,ActualTitle);
		alert.accept();	
		
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	 FileReader reader=new FileReader("Info.properties");
	 Properties prop=new Properties();
	 prop.load(reader); 
	 String url=prop.getProperty("url");
	 driver.get(url);
	 driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	 
	  driver.quit();
  }

}
