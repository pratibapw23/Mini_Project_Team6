package com.profileDataTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.*;
import pageObjects.ProfilePage;

public class FirstNameLastNameCheck {
	ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
  
  @Test//(groups= {"Login"})
  public void verifyUsername() throws IOException, InterruptedException {
	 LoginPage.loginButton(driver).click();
	 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	 LoginPage.SignInButton(driver).submit();
	 Thread.sleep(2000);
	 ProfilePage.profileButton(driver).click();
	 String actualValue = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[1]/div[2]")).getText();
	 assertEquals(actualValue, "amruta xyz");
	 System.out.println("Check with the First Name and Last Name");
	 System.out.println("Test Case Verified Successfully");
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
