package com.registerTests;
import Utils.*;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.RegisterPage;
import Utils.DeleteUser;

public class TC_Register_Userid_1 {

	WebDriver driver;
	
	@Test
	public void Userid_001() throws IOException, InterruptedException
	{
		String RegistrationDetails[]=ExcelUtils.getRegistrationDetails1();
		
		RegisterPage.registerButton(driver).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.username(driver).sendKeys(RegistrationDetails[0]);
		RegisterPage.firstName(driver).sendKeys(RegistrationDetails[1]);
		RegisterPage.lastName(driver).sendKeys(RegistrationDetails[2]);
		RegisterPage.email(driver).sendKeys(RegistrationDetails[3]);
		RegisterPage.passwordTextbox(driver).sendKeys(RegistrationDetails[4]);
		RegisterPage.passwordTextbox2(driver).sendKeys(RegistrationDetails[5]);
		RegisterPage.mobileNumber(driver).sendKeys("8787878787");
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		RegisterPage.registerSubmit(driver).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		assertEquals(driver.getTitle(), ExcelUtils.getLoginPageExpectedTitle());
		
		String email="temp@gmail.com";
		DeleteUser.deleteUser(email, driver);
		
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
