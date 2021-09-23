package com.registerTests;

import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TC_Verify_Upload_file{
	WebDriver driver;
	String email;
	
  @Test
  public void verify_registerWithoutPicture() throws IOException {
	  String RegistrationDetails[] = ExcelUtils.getRegistrationDetails1();
		RegisterPage.registerButton(driver).click();
		RegisterPage.username(driver).sendKeys(RegistrationDetails[0]);
		RegisterPage.firstName(driver).sendKeys(RegistrationDetails[1]);
		RegisterPage.lastName(driver).sendKeys(RegistrationDetails[2]);
		RegisterPage.email(driver).sendKeys(RegistrationDetails[3]);
		RegisterPage.passwordTextbox(driver).sendKeys(RegistrationDetails[4]);
		RegisterPage.passwordTextbox2(driver).sendKeys(RegistrationDetails[5]);
		RegisterPage.mobileNumber(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
		
		WindowScroll.scrollWindow(driver);
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		
		String actualTitlebefore_register=driver.getCurrentUrl();
		RegisterPage.registerSubmit(driver).click();
		String actualTitleafter_register=driver.getCurrentUrl();
		boolean urlChanges=actualTitlebefore_register.equalsIgnoreCase(actualTitleafter_register);
		assertFalse(urlChanges);

		email=RegistrationDetails[3];
		DeleteUser.deleteUser(email, driver);
		System.out.println("Verified registration successful without uploading profile image");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver = WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
