package com.profileDataTests;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_ProfilePic_63 {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void Vrfy_ProfilePic() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("(//A[@href='login'][text()='Login'])[2]")).click();
	  driver.findElement(By.xpath("(//INPUT[@class='input100'])[1]")).sendKeys("zxcv");
	  driver.findElement(By.xpath("(//INPUT[@class='input100'])[2]")).sendKeys("Zxcv@123");
	  driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='\n"
	  		+ "								Login\n"
	  		+ "							']")).click();
	  
	  driver.findElement(By.xpath("//A[@href='profile'][text()='Profile']")).click();
	  
	  driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary'][text()='Update Picture']")).click();
	  
	  
	  
	  WebElement uploadElement = driver.findElement(By.xpath("//INPUT[@id='id_image']"));
	  uploadElement.sendKeys("C:\\Users\\Utkarsh\\Downloads\\friends.jpg");
	  
	  System.out.println("Image collected from path");
  
	  driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='Update Picture']")).click();
	  
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Profile Page";
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
  
      System.out.println("Test Case Passed : Profile Picture Updated");
      
	  
	  Thread.sleep(5000);
	  
	  
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
