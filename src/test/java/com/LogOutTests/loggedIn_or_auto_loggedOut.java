package com.LogOutTests;

import org.testng.annotations.Test;


import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;

public class loggedIn_or_auto_loggedOut {
	WebDriver driver;
	
  @Test
  public void LogIn() throws IOException, InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[2]/a")).click();
	  driver.findElement(By.name("username")).sendKeys(ExcelUtils.getUsername());
	  driver.findElement(By.name("password")).sendKeys(ExcelUtils.getPassword());
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
      //browser.close();
	 // browser.find_element_by_tag_name('body').send_keys(Keys.CONTROL + 'w');
	  
	 // BrowserType.getAllWindowHandles().then(function (handles) { browser.driver.switchTo().window(handles[1]); 
	 // browser.driver.close();
	 // browser.driver.switchTo().window(handles[0]); 
	 
	  
	  ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs3.get(1));
	  driver.close();
	  driver.switchTo().window(tabs3.get(2));
	  
	 // Thread.sleep(4000);
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
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
