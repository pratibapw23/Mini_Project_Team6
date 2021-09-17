package com.registerTests;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Lastname_Verified_Reg {
	WebDriver driver;
	String Path;
	File file;
	String email;
  @Test           
  public void Verify_LastName() throws IOException, InterruptedException {
	  String registrationDetails[]=ExcelUtils.getRegistrationDetailsDhanu();	  
	  
	  RegisterPage.registerButton1(driver).click();
	  driver.manage().window().maximize();
	  RegisterPage.usernameTextbox(driver).sendKeys(registrationDetails[0]);
	  RegisterPage.firstNameTextbox(driver).sendKeys(registrationDetails[1]);
	  RegisterPage.lastNameTextbox(driver).sendKeys(registrationDetails[2]);
	  RegisterPage.emailTextbox(driver).sendKeys(registrationDetails[3]);
	  RegisterPage.passwordTextbox1(driver).sendKeys(registrationDetails[4]);
	  RegisterPage.confirmPassTextbox(driver).sendKeys(registrationDetails[5]);
	  RegisterPage.mobileNoTextbox(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
	  
	 WindowScroll.scrollWindow(driver);
	    
	  Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");

	  WebElement element = driver.findElement(By.name("image"));
		
		element.sendKeys(file.getAbsolutePath());
		
		RegisterPage.registerSubmit(driver).click();
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Login to iDrive";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  System.out.println("TC Passed : LastName Verified Successfully");
	  
	 // email=registrationDetails[3];
	 // DeleteUser.deleteUser(email, driver);

	  
	  
  }
  
  @BeforeClass
  	public void beforeClass() throws IOException
  	{
	  driver = WebDriverProperties.setChromeDriverProperties();  	}
  
  @BeforeMethod
	public void beforeMethod() throws IOException
	{

		FileReader reader = new FileReader("Info.properties");
		Properties prop = new Properties();
		prop.load(reader);

		Path = prop.getProperty("pupload");
		
		file = new File(Path);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}