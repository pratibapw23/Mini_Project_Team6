package com.fileUploadTests;
import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
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

public class FileUpload_Button_Clickable {
	WebDriver driver;
	
  @Test
  public void upload_file_Button() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
		 DashboardPage.uploadFileLink(driver).click();
		 
		 
		  String actualTitle = driver.getTitle();
		  String expectedTitle = "Upload File";
		  assertEquals(actualTitle,expectedTitle);
		  System.out.println("TC Passed : File Upload Button Is Clickable ");
		  // Thread.sleep(4000);
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
