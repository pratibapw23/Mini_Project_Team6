package com.fileUploadTests;
import pageObjects.RegisterPage;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC_Verify_FileUploadButton_Enabled {
	WebDriver driver;
	FileReader reader;
  @Test
  public void check_windowOpen() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).submit();
	  
	  DashboardPage.uploadFileLink(driver).click();
	  DashboardPage.fileName(driver).sendKeys("abc");
	  DashboardPage.fileDescription(driver).sendKeys("pqr");
	  boolean checkClickable=DashboardPage.chooseFile(driver).isEnabled();
	  
	  assertTrue(checkClickable);
	    
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
