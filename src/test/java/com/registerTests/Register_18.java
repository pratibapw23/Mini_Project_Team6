package com.registerTests;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import Utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class Register_18 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_Regdata() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("(//A[@href='register'][text()='Register'])[2]")).click();

	  driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("utkarshb");
	  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Utkarsh");
	  driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Borawake");
	  driver.findElement(By.xpath("(//input[@id='email'])")).sendKeys("qwertyuiop@gmail.com");
	  driver.findElement(By.xpath("(//input[@id='psw'])")).sendKeys("Plmnko@1234");
	  driver.findElement(By.xpath("(//INPUT[@type='password'])[2]")).sendKeys("Plmnko@1234");
	  driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9873216540");
	  
	  Select gender = new Select(driver.findElement(By.name("gender")));  
	  gender.selectByVisibleText("Male");  
	 WebElement uploadElement = driver.findElement(By.xpath("//INPUT[@type='file']"));

      // enter the file path onto the file-selection input field
     uploadElement.sendKeys("C:\\Users\\Utkarsh\\Downloads\\friends.jpg");
     // driver.findElement(By.xpath("//INPUT[@type='file']")).click();
	  driver.findElement(By.xpath("/html/body/form/div/div[11]/input")).click(); 
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Login to iDrive";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  
	  Thread.sleep(2000);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
