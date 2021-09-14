
package com.LogOutTests;
import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
public class Log_Out {
	WebDriver driver;
  @Test
  public void Log_Out_Successfully() throws IOException, InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a")).click();
	  
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.name("username")).sendKeys(ExcelUtils.getUsername());
	  driver.findElement(By.name("password")).sendKeys(ExcelUtils.getPassword());
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
	  driver.findElement(By.xpath("/html/body/header/nav/div[1]/ul/li[3]/a")).click();
	 
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Login to iDrive";
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("TC Passed : LogOut Successfully");
	  
	  
	  Thread.sleep(4000);
  }
	  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();

  }


  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }


}
