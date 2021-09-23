package com.registerTests;
import pageObjects.RegisterPage;
import org.testng.annotations.Test;
import Utils.WebDriverProperties;
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

public class TC_Verify_Password_Rules{
ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
  @Test
  public void Password_Rules() throws InterruptedException, IOException
  {
	  String[] passwords=ExcelUtils.getStringPasswords();
	  RegisterPage.registerButton(driver).click();
	  RegisterPage.passwordTextbox(driver).sendKeys(ExcelUtils.getNumericPasswords());
	  
	WebElement elementCap=driver.findElement(By.id("capital"));
	WebElement elementLet=driver.findElement(By.id("letter"));
	WebElement elementLen=driver.findElement(By.id("length"));
	String actualcolorCap=(elementCap.getCssValue("color"));
	String actualcolorLet=(elementLet.getCssValue("color"));
	String actualcolorLen=(elementLen.getCssValue("color"));
	
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorCap);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLet);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLen);

	RegisterPage.passwordTextbox(driver).clear();
	RegisterPage.passwordTextbox(driver).sendKeys(passwords[0]);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorCap);
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorLen);
	
	RegisterPage.passwordTextbox(driver).clear();
	RegisterPage.passwordTextbox(driver).sendKeys(passwords[1]);
	WebElement elementNumber=driver.findElement(By.id("number"));
	String actualcolorNum=(elementNumber.getCssValue("color"));
	assertEquals(ExcelUtils.getExpectedColor(), actualcolorNum);
	
	  
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
