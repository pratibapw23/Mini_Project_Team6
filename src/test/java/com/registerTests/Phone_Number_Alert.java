package com.registerTests;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class Phone_Number_Alert {
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
	  RegisterPage.mobileNoTextbox(driver).sendKeys(ExcelUtils_Registration.getWrongMobileNo());
	  
	 WindowScroll.scrollWindow(driver);
	    
	  Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");

		RegisterPage.registerSubmit(driver).click();
		
		// Switching to Alert        
	  	WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(2000);
	        		
	        // Accepting alert		
	        alert.accept();		
	  Thread.sleep(2000);
	  
		
		
		
	 
	  System.out.println("TC Passed : Invalid Phone Number");
	  
	   
	  
  }
  

  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();

  }

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

