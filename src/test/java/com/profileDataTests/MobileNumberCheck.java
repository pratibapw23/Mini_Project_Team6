package com.profileDataTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class MobileNumberCheck {
	WebDriver driver;
  @Test
  public void verifyMobileNumber() throws IOException {
	  
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).submit();
	  LoginPage.profileLink(driver).click();
	  String ActualValue=ProfilePage.getActualMobileNumber(driver).getText();
	  assertEquals(ActualValue, "6754902280");
	  System.out.println("Check with the Mobile Number");
	  System.out.println("Test Case Verified Successfully");
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
