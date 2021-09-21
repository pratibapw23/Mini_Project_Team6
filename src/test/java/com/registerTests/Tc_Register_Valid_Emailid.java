package com.registerTests;
import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WindowScroll;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Tc_Register_Valid_Emailid{
	ExcelUtils_Registration r;
	WebDriver driver;
  @Test
  public void Valid_Email_Verfy() throws InterruptedException, IOException {
	  				
		RegisterPage.registerButton(driver).click();
	
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.username(driver).sendKeys(ExcelUtils_Registration.getUserName());
		RegisterPage.firstName(driver).sendKeys(ExcelUtils_Registration.getFirstName());
		RegisterPage.lastName(driver).sendKeys(ExcelUtils_Registration.getLastName());
		RegisterPage.email(driver).sendKeys(ExcelUtils_Registration.getEmail());
		RegisterPage.passwordTextbox(driver).sendKeys(ExcelUtils_Registration.getRegPassword());
		RegisterPage.passwordTextbox2(driver).sendKeys(ExcelUtils_Registration.getRegConfirmPassword());
		RegisterPage.mobileNumber(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
		WindowScroll.scrollWindow(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		RegisterPage.gender_female(driver).click();	
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		RegisterPage.registerSubmit(driver).click();
	
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		String s1 = driver.getTitle();
		String s2 = "Login to iDrive";
		Assert.assertEquals(s1, s2);
		String email=ExcelUtils_Registration.getEmail();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		DeleteUser.deleteUser(email, driver);
		System.out.println("Test case Pass: Verify Valid Email Id");
		
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
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }

}
