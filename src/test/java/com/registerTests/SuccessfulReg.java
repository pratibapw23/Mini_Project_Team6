package com.registerTests;

import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


//1.Register sucessfully.
//2.Login page will open
//1.Enter all field with valid informtaion Click Register

public class SuccessfulReg {
	
	WebDriver driver;
	String email;
  @Test
  public void Successful_reg() throws InterruptedException, IOException 
  {
	  
	  String RegistrationDetails[] =ExcelUtils.getRegistrationDetailsAm();
	  
	  RegisterPage.registerButton(driver).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.username(driver).sendKeys(RegistrationDetails[0]);
		RegisterPage.firstName(driver).sendKeys(RegistrationDetails[1]);
		RegisterPage.lastName(driver).sendKeys(RegistrationDetails[2]);
		RegisterPage.email(driver).sendKeys(RegistrationDetails[3]);
		RegisterPage.passwordTextbox(driver).sendKeys(RegistrationDetails[4]);
		RegisterPage.confirmPassTextbox(driver).sendKeys(RegistrationDetails[5]);
		RegisterPage.mobileNoTextbox(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
		WindowScroll.scrollWindow(driver);
		
		 RegisterPage.registerButton2(driver).click();
		 
		 
		 LoginPage.usernameTextBox(driver).sendKeys(RegistrationDetails[0]);
		 LoginPage.passwordTextBox(driver).sendKeys(RegistrationDetails[4]);
		 LoginPage.SignInButton(driver).submit();
		 
		
		 email=RegistrationDetails[3];
			DeleteUser.deleteUser(email, driver);
		
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	  
	 driver.close();
  }

}
