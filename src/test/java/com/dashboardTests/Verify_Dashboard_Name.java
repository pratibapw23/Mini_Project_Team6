package com.dashboardTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class Verify_Dashboard_Name {
	WebDriver driver;
  @Test
  public void deleteButtonPresent() throws IOException {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
      LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
      LoginPage.SignInButton(driver).submit();
      String actualValue =driver.findElement(By.xpath("/html/body/div[1]")).getText();
      assertEquals(actualValue, "Hello amruta xyz");
      System.out.println("Check with the Name on the Dashboard");
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
