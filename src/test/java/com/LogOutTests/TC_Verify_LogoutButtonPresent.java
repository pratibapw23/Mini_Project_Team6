package com.LogOutTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import pageObjects.UploadFilePage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC_Verify_LogoutButtonPresent {
	WebDriver driver;
  @Test
  public void CheckLogout() throws Exception {
	     LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  
		 Assert.assertEquals( driver.getPageSource().contains("Logout"),true);
		 Assert.assertEquals(ProfilePage.logoutButton(driver).isDisplayed(),true);
		 String s1="Logout";
		 Assert.assertEquals("Logout", ProfilePage.logoutButton(driver).getText());
		 System.out.println("Test Case Pass Successfully");
		 
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	
	  driver.close();
  }


}
