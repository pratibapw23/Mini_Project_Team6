package com.profileDataTests;
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

import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_ProfileEmail_display_56 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_EmailPresence() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("(//A[@href='login'][text()='Login'])[2]")).click();
	  driver.findElement(By.xpath("(//INPUT[@class='input100'])[1]")).sendKeys("zxcv");
	  driver.findElement(By.xpath("(//INPUT[@class='input100'])[2]")).sendKeys("Zxcv@123");
	  driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='\n"
	  		+ "								Login\n"
	  		+ "							']")).click();
	  
	  driver.findElement(By.xpath("//A[@href='profile'][text()='Profile']")).click();
	  
	  Boolean Display = driver.findElement(By.xpath("//DIV[@class='col-sm-9 text-secondary'][text()='\n"
	  		+ "                          zxcv@gm.com\n"
	  		+ "                        ']")).isDisplayed();
	//To print the value
	System.out.println("Element displayed is :"+Display);
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Profile Page";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
  
      System.out.println("Test Case Passed : Email Presence Verified");
      
	  
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
