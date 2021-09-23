package com.profileDataTests;
import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class TC_Verify_ProfileEmail_Display{
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_EmailVisibility() throws IOException, InterruptedException {
	  
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		 
		 
		 ProfilePage.profileButton(driver).click();
	  

		 
		 String ActualValue=ProfilePage.getActualEmail(driver).getText();
		 assertEquals(ActualValue,"zxcv@gm.com");
		 
      System.out.println("Verified Email Visibility : "+ ActualValue);
 
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
