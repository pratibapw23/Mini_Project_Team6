package com.registerTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.RegisterPage;

public class Verify_Email_01 {
	WebDriver driver;
  @Test
  public void verifyEmail() throws IOException, InterruptedException {
	  String registrationDetails[]=ExcelUtils.getRegistrationDetails();
	  double mobileNo=ExcelUtils.getMobileNo();
	  RegisterPage.registerButton(driver).click();
	  RegisterPage.usernameTextbox(driver).sendKeys(registrationDetails[0]);
	  RegisterPage.firstNameTextbox(driver).sendKeys(registrationDetails[1]);
	  RegisterPage.lastNameTextbox(driver).sendKeys(registrationDetails[2]);
	  RegisterPage.emailTextbox(driver).sendKeys(registrationDetails[3]);
	
	  RegisterPage.passwordTextbox(driver).sendKeys(registrationDetails[4]);
	  Thread.sleep(2000);
	  RegisterPage.confirmPassTextbox(driver).sendKeys(registrationDetails[5]);
	  Thread.sleep(2000);
	  RegisterPage.mobileNoTextbox(driver).sendKeys("6789065786");
	  Thread.sleep(8000);
	  RegisterPage.registerButton2(driver).submit();
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
