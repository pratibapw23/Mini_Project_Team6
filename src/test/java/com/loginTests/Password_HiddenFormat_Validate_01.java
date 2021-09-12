package com.loginTests;
import Utils.*;
import org.testng.annotations.Test;
import pageObjects.*;
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
		LoginPage.loginButton(driver).click();
		//driver.findElement(By.linkText("Login")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		e=LoginPage.passwordTextBox(driver);
		e.sendKeys(ExcelUtils.getPassword());
	    String s = e.getAttribute("type"); 
		Assert.assertEquals("password",s);
		
		
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.close();
  }

}
