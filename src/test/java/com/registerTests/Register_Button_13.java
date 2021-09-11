package com.registerTests;
import pageObjects.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import Utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Button_13 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_ProfilePic() throws IOException, InterruptedException {
	  RegisterPage.registerButton(driver).click();
	  System.out.println("Register Button is clickable");
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle =ExcelUtils.getRegisterPageExpectedTitle();
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  
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
