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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Button_13 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_ProfilePic() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("(//A[@href='register'][text()='Register'])[2]")).click();
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Register Yourself!";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
  
      System.out.println("Test Case Passed : Register Button is clickable");
      
	  
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
