package com.dashboardTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Verify_ProfileBtn_02 {
	WebDriver driver;
  @Test
  public void verifyProfileButtonEnable() throws IOException, InterruptedException{
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
      LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
      LoginPage.SignInButton(driver).submit();
      WebElement e=LoginPage.profileLink(driver);
      boolean actualValue = e.isEnabled();

      if (actualValue)
             System.out.println("Button is enabled");
      else
             System.out.println("Button is disabled");
      
  }
  @Test
  public void verifyOnClickProfileButton() throws IOException
  {
	  LoginPage.profileLink(driver).click();
      String ActualUrl=driver.getCurrentUrl();
      String ExpctedUrl=ExcelUtils.getExpectedUrl();
      assertEquals(ExpctedUrl, ActualUrl);
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
