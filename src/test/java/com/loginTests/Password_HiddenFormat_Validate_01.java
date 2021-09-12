package com.loginTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Password_HiddenFormat_Validate_01 {
	
	WebDriver driver;
	ExcelUtils obj=new ExcelUtils();
  @Test
  public void Password_Hidden_Format() throws InterruptedException, IOException {
	
		WebElement e;
		driver.findElement(By.linkText("Login")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		e=driver.findElement(By.name("password"));
		e.sendKeys(ExcelUtils.getPassword());
	    String s = e.getAttribute("type"); 
		Assert.assertEquals("password",s);
		
		
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
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.close();
  }

}
