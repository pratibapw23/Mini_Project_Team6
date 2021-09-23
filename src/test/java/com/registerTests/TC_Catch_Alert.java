package com.registerTests;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegisterPage;

public class TC_Catch_Alert{
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_Alert() throws IOException, InterruptedException {
	  RegisterPage.registerButton1(driver).click();
	  Utils.WindowScroll.scrollWindow(driver);
	  RegisterPage.mobileNoTextbox(driver).sendKeys("9765245826");
	  
	  RegisterPage.registerSubmit(driver).click();
	  
	  // Switching to Alert        
	  	WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        		
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
