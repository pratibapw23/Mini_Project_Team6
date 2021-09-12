package com.functionalityTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class ChangePassword {
	
	ExcelUtils obj=new ExcelUtils();
	
	WebDriver driver;
	
	@Test
	  public void verifyUsername() throws IOException, InterruptedException {
		
		System.out.println("Login with old Password");
		LoginPage.loginButton(driver).click();;
		LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameChangePassword());
		LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getOldPasswordChangePassword());
		LoginPage.SignInButton(driver).submit();
		ProfilePage.profileButton(driver).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[3]/button"));
		js.executeScript("arguments[0].click()", Element);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		ProfilePage.changePasswordTextbox(driver).sendKeys(ExcelUtils.getNewPasswordChangePassword());
		ProfilePage.changePasswordFinal(driver).click();
		System.out.println("Password Changed Successfully");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameChangePassword());
		LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getNewPasswordChangePassword());
		LoginPage.SignInButton(driver).submit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertEquals(driver.getTitle(), "Dashboard");
		System.out.println("Successfully checked Change Password Functionality");
		
		Thread.sleep(1000);
		ProfilePage.profileButton(driver).click();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element2 = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[3]/button"));
		js.executeScript("arguments[0].click()", Element2);
		ProfilePage.changePasswordTextbox(driver).sendKeys(ExcelUtils.getOldPasswordChangePassword());
		ProfilePage.changePasswordFinal(driver).click();
		System.out.println("Reset Completed");
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
