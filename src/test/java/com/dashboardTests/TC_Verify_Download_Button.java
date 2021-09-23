package com.dashboardTests;

import org.testng.annotations.Test;
import pageObjects.*;
import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC_Verify_Download_Button {
	WebDriver driver;
  @Test
  public void verifyDownloadButton() throws IOException 
  {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).submit();
	  boolean Checkdownloadbtn = DashboardPage.downloadButton(driver).isDisplayed();
	  if(Checkdownloadbtn)
		  System.out.println("Download Button is present");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
	  }

}
