package com.fileUploadTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class File_size 
{
	WebDriver driver;
  @Test
  public void Display_File_size() throws IOException 
  {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils_Registration.username_am());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils_Registration.getRegPassword_am());
	  LoginPage.SignInButton(driver).submit();
	  
	  DashboardPage.uploadFileLink(driver).click();
	  WebElement ele= DashboardPage.fileName(driver);
	  ele.sendKeys("A");
	  DashboardPage.fileDescription(driver).sendKeys("xyz");
	  
	  
	  WebElement e=DashboardPage.chooseFile(driver);
	  
	  e.sendKeys("C:\\Users\\amruta_kulkarni4\\git\\Mini_Project_Team6\\Files\\A.jfif");
	  //e.sendKeys(".//Files/A.jfif");
	  String fileName = "C:\\Users\\amruta_kulkarni4\\git\\Mini_Project_Team6\\Files\\A.jfif";
	  File f = new File(fileName);
	  long fileSize = f.length();
	  System.out.format("The size of the file: %d bytes", fileSize);
	 
	  //System.out.println("size"+fileSize);
	  
	  DashboardPage.uploadfile11(driver).submit();
	  
	 WebElement word= driver.findElement(By.className("role_name"));
	 
	 WebElement word_size= driver.findElement(By.className("real_name"));
	 
	 
	 //if(file_size==word_size)
	 //{
		// System.out.println("file size matched");
	 //}
	 //else
	 //{
		// System.out.println("file size not matched");
	 //}
	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
