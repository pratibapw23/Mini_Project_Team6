package com.fileUploadTests;
import pageObjects.RegisterPage;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Verify_FileUploadButton {
	WebDriver driver;
  @Test
  public void check_windowOpen() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).submit();
	  
	  DashboardPage.uploadFileLink(driver).click();
	  DashboardPage.fileName(driver).sendKeys("abc");
	  DashboardPage.fileDescription(driver).sendKeys("pqr");
	  DashboardPage.chooseFile(driver).submit();
	  
	  FileReader reader=new FileReader("Info.properties");
	  Properties prop=new Properties();
	  prop.load(reader); 
	  String path=prop.getProperty("scriptPath");
	  Process p=Runtime.getRuntime().exec(path);
	  p.waitFor();
	  if(p.exitValue()==1)
		  System.out.println("Window is opened to upload file");
	  else {
	        System.out.println("Failed to open window");
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
