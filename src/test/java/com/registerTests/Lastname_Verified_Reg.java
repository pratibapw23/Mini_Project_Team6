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
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;
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
	  String registrationDetails[]=ExcelUtils.getRegistrationDetails();	  
	  
	  RegisterPage.registerButton(driver).click();
	  driver.manage().window().maximize();
	  RegisterPage.usernameTextbox(driver).sendKeys(registrationDetails[0]);
	  RegisterPage.firstNameTextbox(driver).sendKeys(registrationDetails[1]);
	  RegisterPage.lastNameTextbox(driver).sendKeys(registrationDetails[2]);
	  RegisterPage.emailTextbox(driver).sendKeys(registrationDetails[3]);
	  RegisterPage.passwordTextbox(driver).sendKeys(registrationDetails[4]);
	  RegisterPage.confirmPassTextbox(driver).sendKeys(registrationDetails[5]);
	  RegisterPage.mobileNoTextbox(driver).sendKeys("6789065786");
	  
	  WindowScroll.scrollWindow(driver);
	    
	 // Select genderUi=new
	  Select genderUi = new Select(driver.findElement(By.name("gender")));  
	  genderUi.selectByVisibleText("Female"); 
	  
	  
	 // WebElement element = driver.findElement(By.name("image"));
	//element.sendKeys(file.getAbsolutePath());
	RegisterPage.registerSubmit(driver).click();
	  
	
    // RegisterPage.registerButton2(driver).click();
	  
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Login to iDrive";
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("TC Passed : LastName Verified Successfully");
	  
	//  Thread.sleep(2000);
	  
	  
	  email=registrationDetails[3];
		DeleteUser.deleteUser(email, driver);
	  
	  
	  
	  
	  
  }
  @BeforeClass
	public void beforeClass() throws IOException {
		driver = WebDriverProperties.setChromeDriverProperties();
		

	}
	@BeforeMethod
	public void beforeMethod() throws IOException
	{

		FileReader reader = new FileReader("Info.properties");
		Properties prop = new Properties();
		prop.load(reader);

		Path = prop.getProperty("imageSun");
		
		file = new File(Path);
	}
  @AfterClass
  public void afterMethod() {
	  driver.quit();
  }

}
