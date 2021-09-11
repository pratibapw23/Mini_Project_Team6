package com.fileUploadTests;

import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Verify_ImageUpload {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  String RegistrationDetails[]=ExcelUtils.getRegistrationDetails1();
		
		RegisterPage.registerButton(driver).click();
		driver.manage().window().maximize();
		RegisterPage.username(driver).sendKeys(RegistrationDetails[0]);
		
		RegisterPage.firstName(driver).sendKeys(RegistrationDetails[1]);

		RegisterPage.lastName(driver).sendKeys(RegistrationDetails[2]);

		RegisterPage.email(driver).sendKeys(RegistrationDetails[3]);
		Thread.sleep(3000);
		RegisterPage.passwordTextbox(driver).sendKeys(RegistrationDetails[4]);
		Thread.sleep(3000);
		RegisterPage.passwordTextbox2(driver).sendKeys(RegistrationDetails[5]);
		Thread.sleep(3000);
		RegisterPage.mobileNumber(driver).sendKeys("8787878787");
		Thread.sleep(3000);
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		//Upload image
		WebElement element=driver.findElement(By.name("image"));
		FileReader reader=new FileReader("Info.properties");
		Properties prop=new Properties();
		prop.load(reader); 

		String path=prop.getProperty("imageScriptPath");
		element.sendKeys(path);
		Thread.sleep(3000);
		RegisterPage.registerSubmit(driver).submit();
		System.out.println(driver.getTitle());
		
		/*if(driver.getTitle().equalsIgnoreCase(ExcelUtils.getLoginPageExpectedTitle()))
			System.out.println("LogedIn Successfully");
		else
			System.out.println("Failed to login");*/
		

		//String email=RegistrationDetails[3];
		//DeleteUser.deleteUser(email, driver);
		
  }
 
  @BeforeClass
  public void beforeClass() throws IOException {
		driver=WebDriverProperties.setChromeDriverProperties();

  }

  @AfterClass
  public void afterClass() {
	driver.quit();
  }

}
