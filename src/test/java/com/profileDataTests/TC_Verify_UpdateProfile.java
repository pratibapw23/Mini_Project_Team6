package com.profileDataTests;
import Utils.ExcelUtils;
import Utils.WindowScroll;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TC_Verify_UpdateProfile{
	WebDriver driver;
  @Test
  public void updateProfile() throws InterruptedException, IOException 
  {
	  driver.findElement(By.linkText("Login")).click();
	  
	  driver.findElement(By.name("username")).sendKeys(ExcelUtils.getUsername());
	  
	  driver.findElement(By.name("password")).sendKeys(ExcelUtils.getPassword());
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).click();
	
	  driver.findElement(By.linkText("Profile")).click();
	
	 WindowScroll.scrollWindow(driver);
	  driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[1]/button")).click();
	 
	  driver.findElement(By.name("first_name")).clear();
	  driver.findElement(By.name("first_name")).sendKeys(ExcelUtils.getFirstName_UpdateProfile());
	  driver.findElement(By.name("last_name")).clear();
	  driver.findElement(By.name("last_name")).sendKeys(ExcelUtils.getLastName_UpdateProfile());
	
	  WindowScroll.scrollWindow(driver);
	  driver.findElement(By.xpath("//*[@id=\"form1\"]/div/input[2]")).submit();

	  String ActualFullName[]=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div[1]/div[2]")).getText().split(" ");
	  String ActualFirstName=ActualFullName[0];
	  String ActualLastName=ActualFullName[1];
	  assertEquals("Rutu",ActualFirstName);
	  assertEquals("Jadhav",ActualLastName);
	  
	  //set to original again
	  driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[1]/button")).click();

	  driver.findElement(By.name("first_name")).clear();
	  driver.findElement(By.name("first_name")).sendKeys("amruta");
	  driver.findElement(By.name("last_name")).clear();
	  driver.findElement(By.name("last_name")).sendKeys("xyz");

	  driver.findElement(By.xpath("//*[@id=\"form1\"]/div/input[2]")).submit();

	  

  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
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
  public void afterMethod() 
  {
	  driver.quit();
  }

}
