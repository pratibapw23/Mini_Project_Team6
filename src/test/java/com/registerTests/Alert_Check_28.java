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

public class Alert_Check_28 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_Alert() throws IOException, InterruptedException {
	  driver.findElement(By.xpath("(//A[@href='register'][text()='Register'])[2]")).click();
	  driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9873216540");
	  driver.findElement(By.xpath("/html/body/form/div/div[11]/input")).click(); 
	  // Switching to Alert        
	  	WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        alert.accept();		
	  Thread.sleep(5000);
	  
	  
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
