//package com.registerTests;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Properties;
//import Utils.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Register_18 {
//	WebDriver driver;
//
//  
//  @Test//(groups= {"Login"})
//  public void Vrfy_Regdata() throws IOException, InterruptedException {
//	  driver.findElement(By.xpath("(//A[@href='register'][text()='Register'])[1]")).click();
//	  driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("utkarshb");
//	  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Utkarsh");
//	  driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Borawake");
//	  driver.findElement(By.xpath("(//input[@id='email'])")).sendKeys("qwertyuiop@gmail.com");
//	  driver.findElement(By.xpath("(//input[@id='psw'])")).sendKeys("Plmnko@1234");
//	  driver.findElement(By.xpath("(//INPUT[@type='password'])[2]")).sendKeys("Plmnko@1234");
//	  driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9873216540");
//	  
//	  Select gender = new Select(driver.findElement(By.name("gender")));  
//	  gender.selectByVisibleText("Male");  
//	 WebElement uploadElement = driver.findElement(By.xpath("//INPUT[@type='file']"));
//
//      // enter the file path onto the file-selection input field
//     uploadElement.sendKeys("C:\\Users\\Utkarsh\\Downloads\\friends.jpg");
//     // driver.findElement(By.xpath("//INPUT[@type='file']")).click();
//	  driver.findElement(By.xpath("/html/body/form/div/div[11]/input")).click(); 
//	  String ActualTitle = driver.getTitle();
//	  String ExpectedTitle = "Login to iDrive";
//	  Assert.assertEquals(ActualTitle, ExpectedTitle);
//	  
//	  Thread.sleep(2000);
//	  System.out.println("User Registered Successfully");
//	  
//  }
//  @BeforeMethod
//  public void beforeMethod() throws IOException {
//	  driver=WebDriverProperties.setChromeDriverProperties();
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//
//}










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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Register_18 {
	WebDriver driver;
	String Path;
	File file;
	String email;
  @Test           
  public void Verify_LastName() throws IOException, InterruptedException {
	  String registrationDetails[]=ExcelUtils.getRegistrationDetailsUtkarsh();	  
	  
	  RegisterPage.registerButton1(driver).click();
	  driver.manage().window().maximize();
	  RegisterPage.usernameTextbox(driver).sendKeys(registrationDetails[0]);
	  RegisterPage.firstNameTextbox(driver).sendKeys(registrationDetails[1]);
	  RegisterPage.lastNameTextbox(driver).sendKeys(registrationDetails[2]);
	  RegisterPage.emailTextbox(driver).sendKeys(registrationDetails[3]);
	  RegisterPage.passwordTextbox1(driver).sendKeys(registrationDetails[4]);
	  RegisterPage.confirmPassTextbox(driver).sendKeys(registrationDetails[5]);
	  RegisterPage.mobileNoTextbox(driver).sendKeys("6789065786");
	  
	 WindowScroll.scrollWindow(driver);
	    
	  Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
	  
	 // WebElement uploadElement = driver.findElement(By.xpath("//INPUT[@type='file']"));

     // enter the file path onto the file-selection input field
     //uploadElement.sendKeys("C:\\Users\\Utkarsh\\Downloads\\friends.jpg");
//     driver.findElement(By.xpath("//INPUT[@type='file']")).click();
//     driver.findElement(By.xpath("/html/body/form/div/div[11]/input")).click(); 
	  WebElement element = driver.findElement(By.name("image"));
		
		element.sendKeys(file.getAbsolutePath());
		
		RegisterPage.registerSubmit(driver).click();
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Login to iDrive";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  System.out.println("TC Passed : LastName Verified Successfully");
	  
	  email=registrationDetails[3];
		DeleteUser.deleteUser(email, driver);

	  
	  
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