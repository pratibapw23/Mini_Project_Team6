package com.loginTests;
import pageObjects.LoginPage;
import Utils.WebDriverProperties;
import Utils.ExcelUtils;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Pass_Validate_01 {
	ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
  
  @Test//(groups= {"Login"})
  public void verifyUsername() throws IOException, InterruptedException {
	 LoginPage.loginButton(driver).click();
	 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	 LoginPage.SignInButton(driver).submit();
	 Thread.sleep(2000);
	 String name[]=LoginPage.findFullName(driver).getText().split(" ");
	 String ActualName=name[1];
	 LoginPage.profileLink(driver).click();
	 String FullName[]=LoginPage.fullNameInProfile(driver).getText().split(" ");
	 String ExpectedName=FullName[0];
	  
	  assertEquals(ExpectedName, ActualName);
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
