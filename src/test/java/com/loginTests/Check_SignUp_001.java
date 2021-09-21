package com.loginTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Check_SignUp_001 {
	WebDriver driver;
  @Test
  public void check_SignUp() throws InterruptedException, IOException {
	  driver.findElement(By.linkText("Login")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/a")).click();
	  String title[]=driver.getTitle().split(" ");
	  String ActualTitle=title[0];
	  assertEquals("Register",ActualTitle);
	  
	  
  }
  
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	 FileReader reader=new FileReader("Info.properties");
	 Properties prop=new Properties();
	 prop.load(reader); 
	 String url=prop.getProperty("url");
	 driver.get(url);
	 driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
