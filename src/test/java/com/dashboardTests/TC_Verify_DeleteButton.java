package com.dashboardTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC_Verify_DeleteButton{
	WebDriver driver;
  @Test
  public void deleteButtonPresent() throws IOException {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
      LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
      LoginPage.SignInButton(driver).submit();
      
      WebElement e=DashboardPage.deleteButton(driver);
      boolean display=e.isDisplayed();
      if(display)
    	  System.out.println("Delete Button is visible");
      else
    	  System.out.println("Delete Button is not present");
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
