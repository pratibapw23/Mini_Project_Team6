package com.functionalityTests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class TC_Verify_PasswordEyeButton {
	
	ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
	
	@Test
	  public void verifyEyeButton() throws IOException, InterruptedException {
		LoginPage.loginButton(driver).click();
		LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		assertEquals(LoginPage.passwordTextBox(driver).getAttribute("type"),"password");
		ProfilePage.eyeButton(driver).click();
		assertEquals(LoginPage.passwordTextBox(driver).getAttribute("type"),"text");
		
		System.out.println("TestCase for Eye Button Checked Successfully");
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
