package com.registerTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Password_Rules_01 {
ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
  @Test
  public void Password_Rules() throws InterruptedException, IOException
  {
	  String[] passwords=ExcelUtils.getStringPasswords();
	  
	  driver.findElement(By.linkText("Register")).click();
	  driver.findElement(By.id("psw")).sendKeys(ExcelUtils.getNumericPasswords());
	  Thread.sleep(2000);
	  
	WebElement elementCap=driver.findElement(By.id("capital"));
	WebElement elementLet=driver.findElement(By.id("letter"));
	WebElement elementLen=driver.findElement(By.id("length"));
	String actualcolorCap=(elementCap.getCssValue("color"));
	String actualcolorLet=(elementLet.getCssValue("color"));
	String actualcolorLen=(elementLen.getCssValue("color"));
	
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorCap);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLet);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLen);
	Thread.sleep(2000);
	driver.findElement(By.id("psw")).clear();
	driver.findElement(By.id("psw")).sendKeys(passwords[0]);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorCap);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLen);
	Thread.sleep(2000);
	driver.findElement(By.id("psw")).clear();
	driver.findElement(By.id("psw")).sendKeys(passwords[1]);
	WebElement elementNumber=driver.findElement(By.id("number"));
	String actualcolorNum=(elementNumber.getCssValue("color"));
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorNum);
	Thread.sleep(2000);

	
	  
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
