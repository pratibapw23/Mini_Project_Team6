package com.fileUploadTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Your_Uploaded_Files_text {
	WebDriver driver;
  @Test
  public void Text_Fields_Present() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername1());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword1());
		 LoginPage.SignInButton(driver).submit();
		 Thread.sleep(2000);
	  Boolean Display = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).isDisplayed();
	  //to print the value
	  System.out.println("Element Displayed is : " + Display);
	  Thread.sleep(2000);
  
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
