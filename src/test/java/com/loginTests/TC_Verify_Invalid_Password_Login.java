package com.loginTests;

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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TC_Verify_Invalid_Password_Login {
	WebDriver driver;
  @Test
  public void Pass_Invalid () throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
	  driver.manage().window().maximize();

		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getWrongUsername2());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getWrongPassword2());
		 LoginPage.SignInButton(driver).submit();
		
		 // Switching to Alert        
		  	WebDriverWait wait = new WebDriverWait(driver, 5);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		        		
		        // Capturing alert message.    
		        String alertMessage= driver.switchTo().alert().getText();		
		        		
		        // Displaying alert message		
		        System.out.println(" Alert Catched : " + alertMessage);	
		        
		        		
		        // Accepting alert		
		        alert.accept();		
		  
	  
	  
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

